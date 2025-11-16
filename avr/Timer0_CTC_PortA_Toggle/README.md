# Timer0 CTC PortA Toggle (ATmega32, Assembly)

AVR assembly example that configures **Timer0 in CTC mode** on an **ATmega32** and generates a periodic toggle on **PA0** by polling the **OCF0** flag and updating `PORTA` in software.

---

## Overview

- Microcontroller: **ATmega32**
- Language: **AVR Assembly**
- Peripheral used: **8-bit Timer/Counter0**
- Mode: **CTC (Clear Timer on Compare Match)**
- Output pin: **PA0** (bit 0 of `PORTA`)
- Function: Generate a software-controlled square wave on PA0 by:
  - Running Timer0 in CTC mode with a programmed compare value
  - Polling the OCF0 flag in `TIFR`
  - Toggling a bit pattern in a register and writing it to `PORTA`

---

## Files

```text
CTCPORTA.asm     # Main AVR assembly source
CTCPORTA.aps     # Assembler/project settings
ctcporta.hex     # Compiled flash image
ctcporta.eep     # EEPROM image (if used)
ctcporta.map     # Linker / memory map
ctcporta.obj     # Object file
AvrBuild.bat     # Build script for AVRASM
labels.tmp       # Temporary label file from assembler
```

---

## Firmware Behavior

### Core Code

```asm
.INCLUDE "M32DEF.INC"

        .ORG 0
        RJMP main

        .ORG $100

main:
        SBI DDRA,0       ; PA0 as output

        LDI R16,250      ; OCR0 compare value
        LDI R17,$09      ; TCCR0: CTC mode, clk/1
        LDI R18,$02      ; Mask for OCF0 bit in TIFR
        SER R20          ; R20 = 0xFF
        CLR R21          ; R21 = 0x00
        CLR R22          ; R22 = 0x00

        OUT OCR0,R16     ; Load compare value
        OUT TCCR0,R17    ; Enable Timer0 in CTC mode

wait:
        IN  R19,TIFR     ; Read timer interrupt flags
        SBRS R19,1       ; Skip next if OCF0 set (bit 1)
        RJMP wait        ; Wait until compare match

        EOR R21,R20      ; Toggle R21
        EOR R22,R21      ; Toggle R22 every two matches
        OUT PORTA,R22    ; Update PA0 (only bit 0 is configured as output)

        OUT TIFR,R18     ; Clear OCF0 by writing 1 to its bit
        RJMP wait        ; Repeat
```

### Explanation

- `DDRA`:
  - `SBI DDRA,0` sets **PA0** as output; all other `PORTA` pins remain inputs.
- Timer0 setup:
  - `OCR0 = 250` defines the compare match value.
  - `TCCR0 = 0x09` configures:
    - **CTC mode** (`WGM01 = 1`, `WGM00 = 0`)
    - **No hardware OC0 action** (`COM01:0 = 00`)
    - **Clock source = system clock, no prescaler** (`CS00 = 1`, `CS01 = 0`, `CS02 = 0`)
- Software toggle:
  - On each compare match, `OCF0` is set in `TIFR`.
  - The `wait` loop polls `TIFR` and branches when `OCF0` becomes 1.
  - `R20` is preset to `0xFF`. With `R21` and `R22` initially zero:
    - First match:
      - `R21 = R21 XOR R20 = 0xFF`
      - `R22 = R22 XOR R21 = 0xFF`
    - Second match:
      - `R21 = 0xFF XOR 0xFF = 0x00`
      - `R22 = 0xFF XOR 0x00 = 0xFF XOR 0x00 = 0xFF`? (actual sequence produces a toggling pattern every two matches based on initial conditions)
  - Because only **bit 0 of `DDRA`** is configured as output, the observable effect on hardware is a **square wave on PA0** whose frequency is derived from the Timer0 compare match rate and the extra software toggling logic.
- Flag clearing:
  - `OUT TIFR,R18` writes `0b00000010` to `TIFR`, clearing **OCF0** for the next cycle.

The resulting waveform period depends on:

- System clock frequency (`f_clk`)
- Prescaler (here `N = 1`)
- Compare value (`OCR0 = 250`)
- The fact that the PORTA update is performed only when the software detects `OCF0` and after the EOR-based divide-by-2 effect.

---

## Key Concepts Demonstrated

- Configuring **Timer0** in **CTC mode** using `TCCR0` and `OCR0`.
- Polling the **OCF0** flag in **`TIFR`** instead of using interrupts.
- Clearing timer flags by writing a `1` to the corresponding bit in `TIFR`.
- Using **XOR (EOR) operations** to implement periodic toggling on an output pin.
- Separating data direction configuration (`DDRA`) from port data (`PORTA`) to control which bits actually drive hardware pins.
