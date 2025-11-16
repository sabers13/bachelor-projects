# Phase Correct PWM on OC0 (ATmega32, Assembly)

AVR assembly example for **ATmega32** that configures **Timer0** in **Phase Correct PWM mode** and outputs a symmetric PWM waveform on the **OC0 pin (PB3)**.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Timer: **Timer/Counter0** in **Phase Correct PWM mode**  
- Output pin: **OC0 / PB3**  
- Duty cycle: Controlled by **OCR0**

The program initializes PB3 as an output, sets a duty‑cycle value in OCR0, and configures TCCR0 to enable Phase Correct PWM with non‑inverting output on OC0.

## Behavior

- PB3 is set as an output to drive the OC0 signal.  
- OCR0 is loaded with a value that defines the proportion of the up‑down counting cycle during which OC0 is high.  
- TCCR0 is configured so that:
  - Phase Correct PWM mode is active.  
  - OC0 operates in non‑inverting mode.  
  - The timer uses the system clock with a chosen prescaler.  
- As Timer0 counts up and down, the compare unit switches OC0 according to OCR0, producing a symmetric PWM waveform.  
- The main loop remains idle while the hardware timer generates the signal.

This example shows how to configure Timer0 for Phase Correct PWM, which is useful when a more symmetric PWM waveform is required.
