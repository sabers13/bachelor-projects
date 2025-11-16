# push_button_led_chaser

AVR-based **push-button controlled LED chaser** implemented in C and simulated with Proteus.  
A push button on `PD0` starts and stops an 8‑LED running light pattern on `PORTB`.

---

## Overview

- Target MCU: **ATmega16** (or compatible AVR with `PORTB` and `PORTD`)
- Input: **Momentary push button** on `PD0` with internal pull-up enabled
- Output: **8 LEDs** on `PORTB0`–`PORTB7`
- Toolchain: **CodeVisionAVR / AVR-GCC** with `<mega16.h>` and `<delay.h>`
- Simulation: **Proteus** project (`push button.pdsprj`)

Pressing the button starts a cyclic left-shift of a single `1` bit across `PORTB`, creating a running light effect. Pressing the button again stops the sequence and clears all LEDs.

---

## Files

```text
firmware/
  push_button_led_chaser.c        # Main C source file (push-button LED chaser logic)
  push_button_led_chaser.cproj    # AVR project file
  push_button_led_chaser.atsln    # Atmel Studio solution file

simulation/
  push button.pdsprj   # Proteus simulation project (MCU + button + LEDs)
  push_button_led_chaser.prj              # Additional Proteus project data
```

---

## Firmware Logic

```c
#include <mega16.h>
#include <delay.h>

void main () {
    int i;
    DDRD = 0x00;     // PORTD as input (button on PD0)
    PORTD = 0x01;    // Enable pull-up on PD0

    DDRB = 0xFF;     // PORTB as output (8 LEDs)
    PORTB = 0x00;    // All LEDs initially off

    while (1) {

        delay_ms(100);

        if (PIND.0 == 0) {          // Button press detected (active low)
            delay_ms(100);          // Debounce

            for (i = 0; i < 1000; i++) {

                PORTB = PORTB << 1; // Shift the lit LED to the next position

                if (PORTB == 0)     // Wrap around when shifting past MSB
                    PORTB = 0b00000001;

                delay_ms(200);      // Visible delay between steps

                if (PIND.0 == 0) {  // Button pressed again → stop sequence
                    delay_ms(100);  // Debounce
                    PORTB = 0x00;   // Turn off all LEDs
                    break;          // Exit the for-loop
                }
            }
        }
    }
}
```

Behavior:

- On startup, all LEDs are off.
- When the button on `PD0` is pressed:
  - The code enters the counting loop.
  - `PORTB` is shifted left every 200 ms.
  - When the value becomes `0`, it is reset to `0b00000001`, creating a continuous circular running light on the 8 LEDs.
- While the pattern is running:
  - Pressing the button again clears `PORTB` and stops the sequence.

---

## Hardware / Simulation Setup

- `PD0` connected to a momentary push button:
  - One side to `PD0`
  - Other side to ground
  - Internal pull-up on `PD0` enabled via `PORTD = 0x01`
- `PORTB0`–`PORTB7` each connected to:
  - LED → series resistor → VCC or GND (depending on wiring; code assumes active-high output)
- Clock configuration as defined in the project settings (e.g. 8 MHz internal oscillator).

The Proteus project `push button.pdsprj` contains the full schematic with the ATmega16, button, and LED array.

---

## Educational Points

- Configuring AVR ports for input with internal pull-ups and output for LEDs
- Simple **button debouncing** using `delay_ms`
- Implementing an **LED chaser** with bitwise shift operations and wrap-around
- Separating firmware implementation from circuit simulation
