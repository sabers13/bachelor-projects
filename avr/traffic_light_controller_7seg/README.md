# traffic_light_controller_7seg

Traffic light controller for **ATmega32** implemented in **AVR assembly**, with a **2-digit 7‑segment countdown** and configurable phase times using **Timer0**.  
Red, orange, and green phases are driven on `PORTA`, and the remaining time for the current phase is shown on two 7‑segment displays via `PORTB` (ones) and `PORTC` (tens). An input on `PORTD` is used to modify the current phase duration or trigger an early phase change.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Outputs:
  - Traffic light LEDs on `PORTA`:
    - `PA0` = red  
    - `PA1` = orange  
    - `PA2` = green  
  - 2-digit 7‑segment countdown:
    - Ones digit on `PORTB`  
    - Tens digit on `PORTC`  
- Timer: **Timer/Counter0** in normal mode with prescaler 1024  
- Input: `PORTD` used to read a key value for changing the phase durations

## Files

```text
traffic_light_controller_7seg.asm   # Main AVR assembly source
traffic_light_controller_7seg.aps   # Assembler/project settings
traffic_light_controller_7seg.hex   # Compiled flash image
traffic_light_controller_7seg.eep   # EEPROM image
traffic_light_controller_7seg.map   # Linker / memory map
traffic_light_controller_7seg.obj   # Object file

traffic_light_controller_7seg.pdsprj  # Proteus simulation project 
```

## 7‑Segment Lookup Table

A 10‑entry lookup table at program memory address `$0100` holds the 7‑segment codes for digits 0–9:

```asm
.ORG $100
.DB $3F,$06,$DB,$CF,$E6,$ED,$FD,$07,$FF,$EF
```

Each byte represents the segment pattern for one digit, used to drive the ones and tens displays through `PORTB` and `PORTC`.

## Phase Definition

The controller implements a four‑step sequence:

1. **Red** phase  
   - `R17 = 0x01`  
   - Initial duration `R18 = 10` seconds  

2. **First orange** phase  
   - `R17 = 0x02`  
   - Initial duration `R18 = 2` seconds  

3. **Green** phase  
   - `R17 = 0x04`  
   - Initial duration `R18 = 8` seconds  

4. **Second orange** phase  
   - `R17 = 0x02`  
   - Initial duration `R18 = 2` seconds  

`R25` is used as a phase index:

- `R25 = 0` → red  
- `R25 = 1` → first orange  
- `R25 = 2` → green  
- `R25 = 3` → second orange  

The phase labels `red`, `orange1`, `green`, and `orange2` load the color bit into `R17`, the default duration into `R18`, update `R25`, and then jump to the `start` routine.

## Timer0 Setup and One‑Second Tick

Timer0 is configured in normal mode with prescaler 1024:

```asm
LDI R16,$05       ; TCCR0: normal mode, clk/1024 prescaler
MOV R15,R16       ; R15 holds TCCR0 configuration
LDI R16,10
MOV R14,R16       ; TCNT0 start value
LDI R16,$01
MOV R13,R16       ; mask to clear TOV0 in TIFR
```

In `start`, the code initializes:

```asm
OUT TCNT0,R14     ; preload TCNT0
OUT TCCR0,R15     ; start Timer0
MOV R21,R18       ; R21 = current phase time (seconds)
MOV R22,R18
```

The main timing loop:

- Polls the Timer0 overflow flag **TOV0** in `TIFR`.  
- On each overflow:
  - Clears the flag via `OUT TIFR,R13`.  
  - Reloads `TCNT0` with `R14`.  
  - Increments `R19`.  
- After four overflows (`R19 == 4`), approximately one second has elapsed:
  - `R19` is reset.  
  - `R21` (remaining seconds) is decremented.  

When `R21` reaches zero, the phase time has expired and the next phase is selected based on the value of `R25`.

## Countdown Display on 7‑Segment

At each pass through `wait`, the code converts the remaining seconds (`R21`) to two decimal digits and drives the displays:

1. Copy `R21` into `R22` and clear `R27`:

   ```asm
   MOV R22,R21
   CLR R27          ; tens digit
   ```

2. Repeatedly subtract 10 to separate ones and tens:

   ```asm
l1:
   CPI R22,10
   BRLO exit
   SUBI R22,10      ; R22 becomes ones digit
   INC R27          ; R27 counts tens
   RJMP l1
   ```

3. Use the lookup table to get segment patterns:

   ```asm
exit:
   LDI R31,$02      ; table page
   MOV R30,R22      ; ones index
   LPM R29,Z        ; R29 = pattern for ones

   MOV R30,R27      ; tens index
   LPM R26,Z        ; R26 = pattern for tens
   ```

4. Write segment data to ports:

   ```asm
OUT PORTB,R29       ; ones digit
OUT PORTC,R26       ; tens digit
```

As a result, the remaining time in seconds for the current phase is always shown as a two‑digit decimal number on the 7‑segment displays.

## Input on PORTD and Phase Time Adjustment

`PORTD` is configured as input:

```asm
CLR R16
OUT DDRD,R16       ; PORTD inputs
SER R16
OUT DDRB,R16       ; PORTB outputs
OUT DDRC,R16       ; PORTC outputs
```

During `wait`, the code reads `PIND` and compares it against a reference value stored in `R24`:

```asm
MOV R11,R23        ; preserve previous key state
IN  R23,PIND       ; read keys
CP  R23,R24        ; is key equal to 'on' value?
BRNE skip
```

Special cases:

- If the system is currently in **green** (`R25 = 3`) and the key value matches a preset (`R8 = 14`), the controller branches to `cong`, then to `orange2`, forcing an early transition from green to the second orange phase.
- If the system is currently in **red** (`R25 = 1`) and the key value matches a preset (`R9 = 15`), the controller branches to `conr`, then to `orange1`, forcing an early transition from red to the first orange phase.

When a valid override is detected, `R24` is temporarily loaded with a large value (e.g. 30) to avoid rapid re‑triggering of the same event. Otherwise, `R24` is kept at 10, the default reference value for the “on key”.

The selected or adjusted time for the phase is saved back into `R21`, so the countdown and display logic use the updated duration.

## Phase Sequencing

When the countdown for the current phase (`R21`) reaches zero:

- The LEDs on `PORTA` are cleared.  
- `R21` and `R18` are reset.  
- The value of `R25` determines the next label:

  ```asm
  CPI R25,0
  BREQ redjmp

  CPI R25,1
  BREQ ornjmp

  CPI R25,2
  BREQ grnjmp

  CPI R25,3
  BREQ orange2
  ```

`redjmp`, `ornjmp`, and `grnjmp` simply jump back to the corresponding phase labels (`red`, `orange1`, `green`). After the second orange phase (`orange2`), `R25` is cleared so that the sequence restarts from red.

## Summary of Functionality

- Drives a **three‑LED traffic light** on `PORTA` with red, orange, and green phases.  
- Uses **Timer0** with a prescaler to build an approximate **one‑second time base**.  
- Shows the **remaining phase time** on a **two‑digit 7‑segment display** via `PORTB` and `PORTC`.  
- Supports **manual override** via `PORTD` to trigger early transitions from red to orange, or green to orange, based on configured key patterns.  
- Implements phase sequencing and countdown logic entirely in AVR assembly, suitable for simulation in Proteus and for deployment on physical ATmega32 hardware.
