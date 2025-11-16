# Fast PWM on OC0 (ATmega32, Assembly)

AVR assembly example for **ATmega32** that configures **Timer0** in **Fast PWM mode** and drives a PWM waveform on the **OC0 pin (PB3)**.

## Overview

- Microcontroller: ATmega32  
- Language: AVR Assembly  
- Timer: **Timer/Counter0** in **Fast PWM mode**  
- Output pin: **OC0 / PB3**  
- Duty cycle: Determined by **OCR0** value

The program sets PB3 as an output, loads OCR0 with a duty‑cycle value, and configures TCCR0 so that Timer0 runs in Fast PWM mode with non‑inverting output.

## Behavior

- PB3 (OC0) is configured as an output.  
- OCR0 is loaded with a compare value (for example, 200) representing the high‑time portion of the PWM cycle.  
- TCCR0 is configured so that:
  - Fast PWM mode is enabled (WGM00 and WGM01 set for Fast PWM).  
  - Non‑inverting PWM is selected on OC0.  
  - The timer clock is derived from the system clock with a chosen prescaler.  
- After initialization, the main loop is empty and Timer0 continuously generates a PWM waveform on OC0.  
- The output duty cycle is determined by the ratio `OCR0 / 255`.

This example highlights basic Fast PWM configuration for Timer0 and hardware generation of a PWM signal on the OC0 pin.
