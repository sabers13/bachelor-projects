# 7seg

AVR-based **4-digit 7‑segment display** demo implemented in C and simulated with Proteus.  
The firmware multiplexes four 7‑segment digits using `PORTA` for digit selection and `PORTB` for segment data.

---

## Overview

- Target MCU: **ATmega16** (or compatible AVR)
- Output: **4 multiplexed 7‑segment displays**
- Digit select lines: `PORTA` (active‑low digit enable)
- Segment lines: `PORTB`
- Toolchain: **CodeVisionAVR / AVR-GCC** with `<mega16.h>` and `<delay.h>`
- Simulation: **Proteus** project (`7seg.pdsprj`)

A lookup table defines the segment patterns for four digits, and the firmware scans through them quickly to create a stable 4‑digit display using time‑multiplexing.

---

## Files

```text
firmware/
  7seg.c        # Main C source file (7‑segment multiplexing logic)
  7seg.cproj    # AVR project file (if present)
  7seg.atsln    # Atmel Studio solution file

simulation/
  7seg.pdsprj   # Proteus simulation project (MCU + 4 x 7‑segment displays)
```

---

## Firmware Logic

```c
#include <mega16.h>
#include <delay.h>

void main() {

    char seg[] = {
        0b00000110,
        0b01001111,
        0b01101111,
        0b01101111
    };

    DDRA = 0xFF;   // PORTA as output: digit select lines
    DDRB = 0xFF;   // PORTB as output: segment lines

    while (1) {

        PORTA = 0b11111110;  // Enable digit 0 (active low)
        PORTB = seg[0];      // Segment pattern for digit 0
        delay_ms(10);

        PORTA = 0b11111101;  // Enable digit 1
        PORTB = seg[1];
        delay_ms(10);

        PORTA = 0b11111011;  // Enable digit 2
        PORTB = seg[2];
        delay_ms(10);

        PORTA = 0b11110111;  // Enable digit 3
        PORTB = seg[3];
        delay_ms(10);
    }
}
```

Key points:

- `seg[]` holds the four **segment patterns** to be displayed on the 7‑segment displays.
- `PORTA` controls which digit is active by pulling one line low at a time.
- `PORTB` outputs the corresponding segment pattern for that digit.
- Each digit is refreshed every 10 ms, fast enough that all four digits appear continuously lit to the human eye.

The exact mapping between bits in `seg[]` and the physical segments (a–g, dp) depends on the wiring used in the Proteus schematic and the hardware.

---

## Hardware / Simulation Setup

- `PORTA` pins connected to the **common pins** of the 7‑segment displays (through drivers or directly, depending on the design).  
  One bit per digit, active‑low enable.
- `PORTB0`–`PORTB7` connected to the **segment lines** (a–g and dp) of all four displays in parallel.
- Proper current‑limiting resistors for each segment.
- Clock configuration as defined in the project (e.g. 8 MHz internal oscillator).

The Proteus project `7seg.pdsprj` contains the MCU, 4 x 7‑segment displays, and all associated wiring.

---

## Educational Points

- Implementing **time‑multiplexed 7‑segment displays** with a single port for segments.
- Using a **segment pattern lookup table** to control displayed digits.
- Understanding **active‑low digit selection** and shared segment buses.
- Practicing AVR I/O configuration and timing delay usage for visual effects.
