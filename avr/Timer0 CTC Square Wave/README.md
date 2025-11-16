# Timer0 CTC Square Wave (ATmega32, Assembly)

AVR assembly example that configures **Timer0 in CTC mode** on an **ATmega32** and generates a continuous square wave on the **OC0 pin (PB3)**.

## Overview

- Microcontroller: **ATmega32**
- Language: **AVR Assembly**
- Peripheral used: **8-bit Timer/Counter0**
- Mode: **CTC (Clear Timer on Compare Match)**
- Output pin: **OC0 / PB3**
- Function: Generate a fixed-frequency square wave by toggling OC0 on every compare match

The compare value and prescaler are set so that Timer0 toggles OC0 at a constant rate, producing a hardware-generated square wave without any CPU intervention after setup.

## Files

```text
ctc.asm      # Main AVR assembly source configuring Timer0 in CTC mode
ctc.aps      # Assembler/project settings
```

(Additional build artifacts such as HEX, MAP, OBJ, and temporary files are typically produced by the assembler toolchain and are not required in version control.)

## Firmware Behavior

Core configuration in `ctc.asm`:

```asm
.INCLUDE "M32DEF.INC"

        .ORG 0
        RJMP main

        .ORG $100

main:
        SBI DDRB,3      ; Set PB3 (OC0) as output

        LDI R16,49      ; OCR0 compare value
        LDI R17,$19     ; TCCR0 configuration: CTC mode, toggle OC0 on compare, clk/1

        OUT OCR0,R16    ; Load compare value
        OUT TCCR0,R17   ; Enable Timer0 in CTC mode

wait:
        RJMP wait       ; Main loop does nothing; hardware timer runs autonomously
```

### Timer0 Configuration

`TCCR0 = 0x19` sets:

- **WGM01 = 1, WGM00 = 0** → CTC mode (counter resets on compare match)
- **COM01 = 0, COM00 = 1** → Toggle OC0 (PB3) on compare match
- **CS02 = 0, CS01 = 0, CS00 = 1** → Clock source = system clock, no prescaling

`OCR0 = 49` defines the compare value. For a typical 8 MHz system clock, the output toggle frequency on OC0 is:

- Timer compare match frequency: `f_match = f_clk / (N * (1 + OCR0))`
- OC0 square wave frequency (toggling output): `f_OC0 = f_match / 2`

With `f_clk = 8 MHz`, `N = 1`, `OCR0 = 49`:

- `f_match = 8,000,000 / (1 * 50) = 160 kHz`
- `f_OC0 = 160 kHz / 2 = 80 kHz`

The exact frequency scales with the chosen system clock and compare value.

## Hardware Connections

- **PB3 (OC0)** connected to:
  - Logic analyzer, oscilloscope, or frequency counter, or
  - LED and resistor (for low frequencies, using a different compare value or prescaler)

All other pins remain in their default state. After initialization, the CPU stays in an idle loop while the hardware timer continues to generate the square wave.

## Key Concepts Demonstrated

- Configuring **Timer/Counter0** in **CTC mode**
- Using **output compare** to **toggle OC0** automatically
- Generating a stable square wave entirely in hardware, with no per-cycle software overhead
- Basic ATmega32 I/O setup using `DDRB` and `PORTB` in assembly
