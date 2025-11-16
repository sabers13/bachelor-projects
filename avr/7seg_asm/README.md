# Two-Digit 7-Segment Display (AVR Assembly)

Two-digit **7-segment display** demo implemented in **AVR assembly** for ATmega32.  
The firmware decodes a constant decimal value (35) into tens and ones digits and drives two multiplexed 7-segment displays via `PORTB` and `PORTC`.

---

## Overview

- Microcontroller: **ATmega32**
- Language: **AVR Assembly**
- Output: **Two 7-segment displays** (tens and ones)
- Segment data: `PORTB`
- Digit select (enable) lines: `PORTC0`, `PORTC1`
- Build: `7seg.hex` produced by `7seg.asm` using `AvrBuild.bat` or an AVRASM toolchain
- Target use: direct programming to ATmega32 or simulation in AVR-compatible tools

The program uses a **lookup table** of 7-segment codes stored in flash, decodes the number 35 into its tens and ones components, then continuously multiplexes the two digits.

---

## Files

```text
7seg.asm      # Main AVR assembly source
7seg.aps      # Project/assembler settings
7seg.hex      # Compiled flash image
7seg.eep      # EEPROM image (if used)
7seg.map      # Linker / memory map
7seg.obj      # Object file
AvrBuild.bat  # Build script for AVRASM
labels.tmp    # Temporary label file from assembler
```

---

## Firmware Behavior

### Data Table

At program memory address `$0100`, the code defines a 10-byte table of 7-segment codes for digits 0–9:

```asm
.ORG $100
.DB $3F,$06,$DB,$CF,$E6,$ED,$FD,$07,$FF,$EF
```

Each byte encodes the segment pattern for a single digit, following the wiring convention used for the displays (common anode or common cathode).

### Initialization

```asm
main: CLR R18
      OUT DDRA,R18      ; PORTA as input (unused here)
      OUT SFIOR,R18
      SER R18           ; R18 = 0xFF
      OUT DDRB,R18      ; PORTB as output (segments)
      OUT DDRC,R18      ; PORTC as output (digit enables)
      CLR R27           ; R27 will hold the tens digit
      LDI R18,35        ; R18 starts with decimal value 35
```

- `DDRB = 0xFF` and `DDRC = 0xFF` configure both ports as outputs.
- `R18` is initialized with the value 35 (the number to display).
- `R27` is initialized to zero and will accumulate the tens digit.

### Decimal Decomposition

```asm
l1:   CPI R18,10        ; Compare R18 with 10
      BRLO exit         ; If R18 < 10, done
      SUBI R18,10       ; R18 -= 10
      INC R27           ; R27++ (count tens)
      RJMP l1
```

- Repeatedly subtracts 10 from `R18` until it is less than 10.
- `R18` ends as the **ones digit** (5).
- `R27` ends as the **tens digit** (3).

### Lookup in 7-Segment Table

```asm
exit: LDI R31,$02       ; ZH = 0x02 (high byte of table address)
      MOV R30,R18       ; ZL = ones digit index
      LPM R29,Z         ; R29 = segment pattern for ones digit
      MOV R30,R27       ; ZL = tens digit index
      LPM R26,Z         ; R26 = segment pattern for tens digit
```

- Uses the Z pointer (`R31:R30`) to index the lookup table.
- `R29` holds the segment code for the ones digit (5).
- `R26` holds the segment code for the tens digit (3).

### Display Multiplexing

```asm
l3:   SBI PORTC,0       ; Ensure both digits are initially disabled
      SBI PORTC,1

      OUT PORTB,R29     ; Put ones digit segments on PORTB
      CBI PORTC,0       ; Enable digit 0 (active edge)
      SBI PORTC,0       ; Disable digit 0 again

      OUT PORTB,R26     ; Put tens digit segments on PORTB
      CBI PORTC,1       ; Enable digit 1
      SBI PORTC,1       ; Disable digit 1

      RJMP l3           ; Repeat forever
```

- `PORTC0` and `PORTC1` control the enables for the two 7-seg displays.
- The code:
  - Sets both enable lines high,
  - Outputs the ones-digit pattern on `PORTB`,
  - Pulses `PORTC0` low/high to latch or light the ones digit,
  - Outputs the tens-digit pattern on `PORTB`,
  - Pulses `PORTC1` low/high to latch or light the tens digit,
  - Loops indefinitely, refreshing both digits fast enough to appear continuously lit.

The exact active level and timing behavior depend on the external circuitry and display wiring (e.g., whether the digits are common anode or common cathode and how the enable lines are driven).

---

## Summary

- Displays the constant value **35** on two multiplexed 7-segment displays.
- Uses a compact **lookup-table + divide-by-10** routine to obtain tens and ones digits.
- Demonstrates basic AVR assembly patterns:
  - I/O configuration via `DDRx` and `PORTx`
  - Flash lookup with `LPM` and the Z pointer
  - Simple decimal-to-7-segment decoding and time-multiplexed display driving.
