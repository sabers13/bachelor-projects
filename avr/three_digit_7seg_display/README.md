# Three-Digit 7-Segment Display (ATmega32, Assembly)

AVR assembly project for **ATmega32** that reads an 8-bit value from `PINA`, converts it to **three decimal digits**, and drives a **3-digit multiplexed 7-segment display** via `PORTB` and `PORTC`.

## Overview

- Microcontroller: ATmega32
- Language: AVR Assembly
- Input: 8-bit value on `PINA` (0–255)
- Output: Three 7-segment digits showing the decimal value
- Segment data bus: `PORTB`
- Digit enable lines: `PORTC0`, `PORTC1`, `PORTC2`
- Build artifacts: Intel HEX (`three_digit_7seg_display.hex`) and EEPROM (`three_digit_7seg_display.eep`)

The firmware implements a simple binary-to-decimal conversion using repeated subtraction and then multiplexes three 7-segment digits using a lookup table stored in flash.

## Files

```text
three_digit_7seg_display.asm   # Main AVR assembly source (renamed from ex10.asm)
three_digit_7seg_display.aps   # Assembler/project settings (renamed from ex10.aps)
three_digit_7seg_display.hex   # Compiled flash image (renamed from ex10.hex)
three_digit_7seg_display.eep   # EEPROM image (renamed from ex10.eep)
three_digit_7seg_display.map   # Linker / memory map (renamed from ex10.map)
three_digit_7seg_display.obj   # Object file (renamed from ex10.obj)
AvrBuild.bat                   # Build script for AVRASM
labels.tmp                     # Temporary label file from assembler
```

## 7-Segment Lookup Table

A lookup table for 7-segment codes is stored in program memory:

```asm
.ORG $200
.DB $EE,$ED,$EB,$E7,$DE,$DD,$DB,$D7,$BE,$BD,$BB,$B7,$7E,$7D,$7B,$77
```

The first ten entries encode the segment patterns for decimal digits **0–9** according to the wiring used for the display. Additional entries can represent hexadecimal digits A–F if needed.

## Firmware Behavior

### Initialization

```asm
.ORG 0
RJMP main

.ORG $300
main:
    CLR R16
    OUT DDRA,R16      ; PORTA as input
    OUT SFIOR,R16
    SER R16
    OUT PORTA,R16     ; Enable pull-ups on PORTA
    OUT DDRB,R16      ; PORTB as output (segments)
    OUT DDRC,R16      ; PORTC as output (digit enables)
    IN  R16,PINA      ; Read 8-bit input value
    CLR R17           ; Tens digit
    CLR R18           ; Hundreds digit
```

- `PORTA` is configured as input with pull-ups.
- `PORTB` and `PORTC` are configured as outputs.
- The initial value is read once from `PINA` into `R16`.

### Binary to Decimal Conversion (0–255)

The code converts the 8-bit input in `R16` into three decimal digits using repeated subtraction by 10:

```asm
l1:
    CPI R16,10        ; While value >= 10:
    BRLO l2
    SUBI R16,10       ;   value -= 10
    INC R17           ;   tens++
    RJMP l1

l2:
    CPI R17,10        ; While tens >= 10:
    BRLO exit
    SUBI R17,10       ;   tens -= 10
    INC R18           ;   hundreds++
    RJMP l2
```

- After `l1`, `R16` holds the **ones** digit (0–9), and `R17` holds the full tens count.
- After `l2`, `R17` holds the **tens** digit (0–9), and `R18` holds the **hundreds** digit (0–2).

### Digit Code Lookup

The three decimal digits are then mapped to 7-segment codes via the flash table:

```asm
exit:
    LDI R31,$02       ; ZH = 0x02 → table base at 0x0200

    MOV R30,R16       ; Ones index
    LPM R19,Z         ; R19 = segment pattern for ones

    MOV R30,R17       ; Tens index
    LPM R20,Z         ; R20 = segment pattern for tens

    MOV R30,R18       ; Hundreds index
    LPM R21,Z         ; R21 = segment pattern for hundreds
```

- `R19`, `R20`, and `R21` hold the segment patterns for the ones, tens, and hundreds digits respectively.

### 3-Digit Multiplexing Loop

```asm
l3:
    SBI PORTC,0
    SBI PORTC,1
    SBI PORTC,2

    OUT PORTB,R19     ; Ones digit
    CBI PORTC,0       ; Enable digit 0
    SBI PORTC,0       ; Disable digit 0

    OUT PORTB,R20     ; Tens digit
    CBI PORTC,1       ; Enable digit 1
    SBI PORTC,1       ; Disable digit 1

    OUT PORTB,R21     ; Hundreds digit
    CBI PORTC,2       ; Enable digit 2

    RJMP l3
```

- `PORTC0`, `PORTC1`, and `PORTC2` act as digit enable lines for the ones, tens, and hundreds displays.
- Each digit is enabled briefly while its pattern is present on `PORTB`, then disabled.
- The loop cycles continuously, relying on persistence of vision to create the appearance of a stable 3-digit display.

## Hardware Connections

- `PINA[7:0]` connected to an 8-bit source (switches, external logic, or another device) representing a value from 0 to 255.
- `PORTB[7:0]` connected to the segment lines of three 7-segment displays (a–g and possibly dp) through appropriate current-limiting resistors.
- `PORTC0`, `PORTC1`, `PORTC2` connected to the common pins (or enable lines) of the three 7-segment digits, with active level and driver circuitry matching the display type (common anode or common cathode).
- System clock and power supplied according to ATmega32 requirements.

## Concepts Demonstrated

- Binary-to-decimal conversion using repeated subtraction on an 8-bit value.
- Use of a **lookup table in flash** with `LPM` and the Z pointer.
- **Time-multiplexed driving** of multiple 7-segment displays from a shared segment bus.
- Basic ATmega32 port configuration for input and multiplexed display output.
