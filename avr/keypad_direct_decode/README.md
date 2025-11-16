# Matrix Keypad Direct Decode (ATmega32, Assembly)

AVR assembly example for **ATmega32** that scans a **4×4 matrix keypad** on `PORTA` and decodes key presses into numeric codes written to **PORTC**, using a series of explicit comparisons rather than a flash lookup table.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Input: 4×4 matrix keypad connected to `PORTA`  
- Output: Key code (0–15) on `PORTC`  
- Decoding method: Direct comparison of row/column patterns

The lower four bits of PORTA drive the keypad columns, and the upper four bits read the keypad rows. Each distinct row/column combination is mapped to a numeric code by a chain of `CPI`/`BREQ` instructions.

## Behavior

- The lower nibble of PORTA is configured as outputs (column drivers), and the upper nibble as inputs with pull‑ups (row sense lines).  
- PORTA, PORTB, and PORTC are initialized so that keypad scanning and output display are enabled.  
- The scanning loop:
  - Waits until all rows are in the released state.  
  - Activates one column at a time on the lower nibble of PORTA.  
  - Reads the upper nibble of PINA to detect which row is low.  
  - Combines row and column bits into a single 8‑bit pattern.
- In the `search` section:
  - The combined pattern is compared against a fixed set of constants representing valid key presses.  
  - Each match assigns a corresponding numeric value (0–15) to a register.  
- On a successful decode:
  - The numeric code is written to PORTC.  
  - Control returns to the initial wait state, ready for the next key press.

This example demonstrates keypad scanning without a lookup table, implementing the key map directly in program logic.
