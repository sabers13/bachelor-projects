# External Interrupt INT0 with Timer0 Start (ATmega32, Assembly)

AVR assembly example for **ATmega32** demonstrating how an **external interrupt on INT0 (PD2)** can be used to start **Timer0** and drive an LED on **PA0**.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Trigger source: External interrupt **INT0** on pin **PD2**  
- Timer used: **Timer/Counter0**  
- Output: LED connected to **PA0**

The program configures PD2 as an input with pull‑up, enables the INT0 interrupt on an edge condition, and sets PA0 as a digital output. When the INT0 interrupt fires, Timer0 is enabled and the LED on PA0 is driven high.

## Behavior

- PA0 is configured as an output and can be connected to an LED.  
- PD2 (INT0) is configured as an input with pull‑up enabled.  
- The global interrupt enable flag is set after the stack pointer is initialized.  
- When an external event on INT0 occurs, the interrupt routine:
  - Starts Timer0 with a prescaler configuration.
  - Sets PA0 high to indicate that the interrupt has occurred.

This example illustrates basic use of an external interrupt, stack initialization, and interaction between an interrupt source and a timer peripheral.
