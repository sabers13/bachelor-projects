# keypad_2digit_7seg

AVR assembly project for **ATmega32** that scans a **4×4 matrix keypad** on `PORTA` and then demonstrates a **two-digit 7-segment display** driven from a lookup table in program memory.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Input: 4×4 matrix keypad on `PORTA`  
- Outputs:
  - Segment data on `PORTB`  
  - Digit enable lines on `PORTC0` and `PORTC1`  
- Features:
  - Matrix keypad scanning using row/column drive on `PORTA`  
  - Flash-resident lookup table for keypad patterns and digits 0–9  
  - Two-digit 7-segment multiplexing example displaying the decimal value **35**

## Files

```text
keypad_2digit_7seg.asm   # AVR assembly source (renamed from KEYPAD.asm)
keypad_2digit_7seg.hex   # Compiled flash image
keypad_2digit_7seg.eep   # EEPROM image (optional)
keypad_2digit_7seg.map   # Linker / memory map
keypad_2digit_7seg.obj   # Object file
```

## Lookup Table

At program memory address `$0100`, a table of segment and keypad patterns is defined:

```asm
.ORG $100
.DB $3F,$06,$DB,$CF,$E6,$ED,$FD,$07,$FF,$EF,
    $EE,$ED,$EB,$E7,$DE,$DD,$DB,$D7,$BE,$BD,
    $BB,$B7,$7E,$7D,$7B,$77
```

- The first 10 entries (`$3F`…`$EF`) correspond to 7-segment codes for digits **0–9**.  
- The remaining 16 entries encode the combined row/column patterns used to identify pressed keys in the 4×4 matrix keypad.

## Keypad Scanning

The program initially configures `PORTA` for keypad use:

- `DDRA = 0x0F`  
  - Lower nibble (`PA0–PA3`): outputs (column drivers)  
  - Upper nibble (`PA4–PA7`): inputs (row sense lines)  
- `PORTA = 0xFF` and `PORTB = 0xFF`  
  - Enables pull-ups on the row inputs and sets all initial outputs high.

The scanning sequence is:

1. **Idle wait (`wait1`)**  
   Reads `PINA`, masks the upper nibble with `ANDI R16,$F0`, and waits until it equals `$F0`, indicating that no key is pressed.

2. **Column drive loop (`loop1` / `wait2`)**  
   - Initializes `R17` with `$0E`, defining the first column pattern on the lower nibble of `PORTA`.  
   - In `wait2`:
     - Writes `R17` to `PORTA` to drive one column active at a time.  
     - Reads `PINA` and checks the upper nibble for a change from `$F0`.  
     - If no key is pressed, increments `R18`, sets carry, and rotates `R17` left (`ROL R17`) to move the active bit to the next column.  
     - When `R18` reaches 4, the scan restarts with the first column pattern.

3. **Key press detection (`search`)**  
   - When the upper nibble deviates from `$F0`, a key is assumed to be pressed.  
   - The active column pattern (lower nibble of `R17`) is masked with `ANDI R17,$0F` and ORed into `R16`, which already holds the row nibble, forming a unique 8-bit code for the key:  
     ```asm
     ANDI R17,$0F
     OR   R16,R17
     ```

4. **Table search (`loop2`)**  
   - The combined code in `R16` is compared against the 16 keypad entries in the table:  
     - `R30:R31` (Z pointer) is initialized to point to the keypad section (`.ORG $100 + 10`).  
     - Up to 16 entries are loaded with `LPM` and compared with `R16`.  
     - On a match, control branches to `END1`; otherwise, if no entry matches, the code returns to `wait1` to resume scanning.

## Two-Digit 7-Segment Demo

At label `END1`, the program transitions into a simple two-digit 7-segment display demo:

1. **Reconfigure I/O**  
   - `DDRA` is cleared, disabling keypad driving.  
   - `DDRB` and `DDRC` are set to `0xFF`, making all bits of `PORTB` and `PORTC` outputs for the 7-segment displays.

2. **Decimal decomposition of a constant**  
   - `R16` is loaded with the value **35**:  
     ```asm
     LDI R16,35
     ```  
   - A loop repeatedly subtracts 10, incrementing `R17` to derive tens and ones:  
     - On exit, `R16` holds the ones digit (5), and `R17` holds the tens digit (3).

3. **Lookup of segment patterns**  
   - Using the same flash table at `$0100`, the code loads the 7-segment patterns for the ones and tens digits:  
     ```asm
     LDI R31,$02
     MOV R30,R16        ; ones index
     LPM R19,Z
     MOV R30,R17        ; tens index
     LPM R20,Z
     ```

4. **Multiplexed output (`l3`)**  
   - A simple multiplexing loop enables each digit in turn and outputs the corresponding pattern:  
     ```asm
     l3:
         SBI PORTC,0
         SBI PORTC,1

         OUT PORTB,R19   ; ones digit
         CBI PORTC,0     ; enable digit 0
         SBI PORTC,0

         OUT PORTB,R20   ; tens digit
         CBI PORTC,1     ; enable digit 1
         SBI PORTC,1

         RJMP l3
     ```  
   - `PORTC0` and `PORTC1` act as digit enable lines, while `PORTB` carries the segment pattern from the lookup table.  
   - The example displays the fixed value **35** on the two 7-segment digits.

## Concepts Demonstrated

- Scanning a **4×4 matrix keypad** using row/column drive and sense on a single port.  
- Combining row and column information into a single 8-bit code.  
- Searching a **flash-resident lookup table** using the Z pointer and `LPM`.  
- Decoding a binary value into tens and ones via repeated subtraction.  
- Driving a **two-digit 7-segment display** with shared segment lines and individual digit enable lines.  
- Reusing a single lookup table for both keypad patterns and numeric 7-segment codes.
