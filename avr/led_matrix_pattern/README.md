# led_matrix_pattern

AVR-based **8×8 LED matrix** demo implemented in C and simulated with Proteus.  
The firmware scans each row of the matrix using `PORTB` while driving the column pattern on `PORTA` to render a fixed bitmap.

## Overview

- Target MCU: **ATmega16** (or compatible AVR)
- Output: **8×8 LED matrix**
- Row select lines: `PORTB` (one active bit per row)
- Column lines: `PORTA` (bit pattern for LEDs in the active row)
- Toolchain: **CodeVisionAVR / AVR-GCC** with `<mega16.h>` and `<delay.h>`
- Simulation: **Proteus** project (`matrix.pdsprj`)

## Files

```text
firmware/
  led_matrix_pattern.c      # Main C source file (renamed from cv6.c)
  led_matrix_pattern.cproj  # AVR project file (renamed from cv6.cproj)
  led_matrix_pattern.atsln  # Atmel Studio solution file (renamed from cv6.atsln)

simulation/
  matrix.pdsprj             # Proteus simulation project (MCU + 8×8 LED matrix)
```

## Firmware Logic

```c
#include <mega16.h>
#include <delay.h>

void main(void)
{
    DDRA = 0xFF;   // PORTA as output: columns
    DDRB = 0xFF;   // PORTB as output: rows

    while (1)
    {
        PORTB = 0b00000001;
        PORTA = 0b11111111;
        delay_ms(1);

        PORTB = 0b00000010;
        PORTA = 0b10110101;
        delay_ms(1);

        PORTB = 0b00000100;
        PORTA = 0b10110111;
        delay_ms(1);

        PORTB = 0b00001000;
        PORTA = 0b10110101;
        delay_ms(1);

        PORTB = 0b00010000;
        PORTA = 0b10000101;
        delay_ms(1);

        PORTB = 0b00100000;
        PORTA = 0b10110101;
        delay_ms(1);

        PORTB = 0b01000000;
        PORTA = 0b10110101;
        delay_ms(1);

        PORTB = 0b10000000;
        PORTA = 0b11111111;
        delay_ms(1);
    }
}
```

- `PORTB` selects which **row** of the 8×8 matrix is active (one bit high at a time).
- `PORTA` drives the **column pattern** for the currently active row.
- Each row is displayed for 1 ms; the full frame is scanned repeatedly to create a stable image via persistence of vision.
- The bitmap encoded in the `PORTA` values defines the shape shown on the matrix (e.g. icon, symbol, or character).

## Hardware / Simulation Setup

- `PORTB0`–`PORTB7`: connected to the **row lines** of the LED matrix (through appropriate drivers if needed).
- `PORTA0`–`PORTA7`: connected to the **column lines** of the LED matrix.
- Current-limiting resistors in series with either rows or columns, depending on the matrix wiring.
- Clock frequency configured in the project settings (for correct refresh timing).

## Educational Points

- Driving an **LED matrix with row-column multiplexing**.
- Using **bit patterns** to encode a static 2D image.
- Practicing AVR **I/O configuration** and timing with short delays to achieve smooth visual output.
