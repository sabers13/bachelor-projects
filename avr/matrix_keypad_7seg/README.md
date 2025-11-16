# matrix_keypad_7seg

AVR assembly project for **ATmega32** that scans a **4×4 matrix keypad** using `PORTA` and drives a **7-segment style output pattern** on `PORTB`.  
A 16-entry lookup table in flash encodes the valid keypad patterns.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Input: 4×4 matrix keypad on `PORTA` (lower nibble used for column drive, upper nibble for row sense)  
- Output: 8-bit pattern on `PORTB` corresponding to the detected key  
- Additional resources: Proteus project (`EX11.pdsprj`) for simulation

The firmware continuously scans the keypad by cycling a single active column on the lower four bits of `PORTA` and reading the upper four bits of `PINA`. When a key press is detected, the row/column combination is combined into an 8‑bit code and compared against a lookup table in flash. If a match is found, the final pattern is presented on `PORTB`.

## Files

```text
matrix_keypad_7seg.asm   # Main AVR assembly source (renamed from ex11.asm)
matrix_keypad_7seg.aps   # Assembler/project settings (renamed from ex11.aps)
matrix_keypad_7seg.hex   # Compiled flash image (renamed from ex11.hex)
matrix_keypad_7seg.eep   # EEPROM image (renamed from ex11.eep)
matrix_keypad_7seg.map   # Linker / memory map (renamed from ex11.map)
matrix_keypad_7seg.obj   # Object file (renamed from ex11.obj)
EX11.pdsprj              # Proteus simulation project (keypad + display)
AvrBuild.bat             # Build script for AVRASM
labels.tmp               # Temporary label file from assembler
```

## Lookup Table

A 16‑entry table at program memory address `$0200` defines the valid 8‑bit patterns:

```asm
.ORG $200
.DB $EE,$ED,$EB,$E7,$DE,$DD,$DB,$D7,$BE,$BD,$BB,$B7,$7E,$7D,$7B,$77
```

Each byte represents a distinct row/column combination and can be interpreted as a 7‑segment code or other indicator pattern, depending on external wiring.

## Firmware Behavior

### Initialization

- `DDRA` is loaded with `0x0F` to configure the lower four bits of `PORTA` as outputs (keypad columns) and the upper four bits as inputs (keypad rows).
- `SFIOR` is cleared.
- `PORTA` and `PORTB` are set to `0xFF`. The upper nibble of `PORTA` thereby enables pull‑ups on the row inputs.
- `R18` is cleared and used as a counter during scanning.

### Idle Wait for All Rows Released

Label `wait1` repeatedly:

- Reads `PINA` into `R16`.
- Masks the upper nibble with `ANDI R16,$F0`.
- Compares the result with `$F0`; if not equal, the code remains in `wait1`.

This state corresponds to a condition where no key is pressed (all row lines inactive).

### Column Scanning

After all rows are released, control moves to `loop1`:

- `R17` is initialized with `$0E`, defining the initial column drive pattern on the lower nibble of `PORTA`.
- At `wait2`, the code:
  - Writes `R17` to `PORTA`, driving one column active at a time.
  - Reads `PINA`, masks the upper nibble, and checks again for the all‑rows‑inactive pattern (`$F0`).
  - When no key is pressed, increments `R18`, sets carry, and rotates `R17` left (`ROL R17`) to move the active bit through the four column positions.
  - When `R18` reaches 4, the scan restarts at `loop1`, continuously cycling through all columns.

### Key Press Detection and Encoding

When the upper nibble of `PINA` deviates from `$F0`, execution branches to `search`:

- `R17` is masked with `0x0F` to keep only the active column bit.
- The masked column pattern is ORed into `R16`, which still holds the row nibble, forming a combined 8‑bit code for the pressed key.

### Table Search

The combined code in `R16` is matched against the 16‑entry table:

- `R18` and `R30` are cleared to act as index and low byte of the Z pointer.
- `R31` is loaded with `$03`, selecting the page containing the table.
- In `loop2`, `LPM` loads table entries via Z, each entry is compared to `R16`, and the index in `R18` and pointer in `R30` are incremented until:
  - A match is found (`BREQ end1`), or
  - All 16 entries have been tested, after which control returns to `wait1`.

### Output

At `end1`, the current code in `R16` is written to `PORTB`:

```asm
end1: OUT PORTB,R16
```

This pattern can be wired directly to a 7‑segment display or to LEDs to visualize the key that was pressed.

## Hardware Connections

- Lower nibble of `PORTA` (`PA0–PA3`): drive lines for the four keypad columns.
- Upper nibble of `PORTA` (`PA4–PA7`): sense lines for the four keypad rows, configured as inputs with pull‑ups.
- `PORTB[7:0]`: 8‑bit output bus connected to a bank of LEDs or a 7‑segment display through current‑limiting resistors.
- System clock and other hardware wiring defined in the associated Proteus schematic (`EX11.pdsprj`).

## Concepts Demonstrated

- Scanning a **4×4 matrix keypad** using row/column drive and sense.
- Constructing an 8‑bit code from row and column information.
- Implementing a **table search in flash memory** with `LPM` and the Z pointer.
- Presenting the decoded key pattern on a parallel output port suitable for a 7‑segment display or LED array.
