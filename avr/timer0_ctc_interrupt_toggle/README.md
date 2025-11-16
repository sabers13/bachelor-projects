# Timer0 CTC Interrupt Toggle (ATmega32, Assembly)

AVR assembly example for **ATmega32** where **Timer0** runs in **CTC mode** and a **compare match interrupt** toggles **PB0**, generating a square wave entirely from the interrupt service routine.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Timer: **Timer/Counter0** in **CTC mode**  
- Interrupt: **Output Compare Match** (OCIE0)  
- Output: Square wave on **PB0**

Timer0 is configured with a compare value and CTC mode so that a compare match event occurs at a fixed rate. The compare match interrupt is enabled, and within the ISR the code XORs a register and writes it to PORTB to toggle PB0.

## Behavior

- PB0 is configured as an output pin.  
- OCR0 is loaded with a compare value that sets the interrupt rate.  
- TIMSK is configured so that the Timer0 compare match interrupt is enabled.  
- Global interrupts are enabled after the stack pointer is set.  
- The main loop remains idle while Timer0 runs.  
- On each compare match:
  - The interrupt routine toggles an internal register using XOR.
  - The updated value is written to PORTB.
  - PB0 changes level on every interrupt, generating a periodic square wave.

This example demonstrates Timer0 CTC configuration, interrupt vector usage, and generation of a software‑controlled square wave using an ISR.
