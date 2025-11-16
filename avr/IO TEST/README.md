# Port I/O and Nibble Copy Demo (ATmega32, Assembly)

AVR assembly example for **ATmega32** that performs simple arithmetic and then continuously mirrors the **upper nibble of PINA** onto the **lower nibble of PORTA**.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Input: Upper four bits of **PINA**  
- Output: Lower four bits of **PORTA**  
- Additional feature: Simple multiplication and addition using `MUL` and `ADD`

The code configures the lower four bits of PORTA as outputs, performs one arithmetic sequence using general‑purpose registers, and then enters a loop that shifts the sampled input nibble down onto the output nibble.

## Behavior

- DDRA is initialized so that the lower four bits (PA0–PA3) are outputs.  
- SFIOR is cleared and PORTA is briefly driven high, then cleared.  
- A small arithmetic sequence is executed:
  - Registers hold values 7, 10, and 8.
  - `MUL` multiplies 7 by 10, and the low byte of the product is added to 8.  
- In the main loop:
  - PINA is read into a register.  
  - The value is shifted right four times to move the upper nibble into the lower nibble.  
  - The result is written to PORTA, so PA0–PA3 reflect the original PA4–PA7.  

This example demonstrates basic port direction control, reading from and writing to I/O ports, bit shifting operations, and use of the `MUL` instruction on ATmega32.
