# AVR Microcontroller Projects (Bachelor Embedded Systems)

This folder contains a set of **AVR microcontroller mini-projects** developed during my Bachelor studies.  
They are implemented in **C and AVR assembly** on **ATmega16 / ATmega32**, and simulated and/or tested on real hardware.

The projects gradually build up from simple LED blinking to a full **traffic light controller with 7-segment countdown**, which serves as the capstone.

---

## Skills & Technologies

**Microcontrollers & Tools**

- ATmega16 / ATmega32 (8-bit AVR architecture)
- Atmel Studio / CodeVisionAVR projects (`.cproj`, `.atsln`)  
- AVR assembly toolchain (`.asm`, `.aps`, `.hex`)
- Proteus simulation (`.pdsprj`) for hardware validation

**Low-Level Embedded Programming**

- Register-level configuration of `DDRx`, `PORTx`, `PINx`
- Writing firmware in **C** and **AVR assembly**
- Bitwise operations, lookup tables in flash (`LPM` with `Z` pointer)
- Polling vs. interrupt-driven design
- Implementation of simple state machines

**Peripherals & Interfaces**

- **GPIO / LEDs**
- **Timer0** in:
  - Normal mode (overflow timing)
  - CTC (Clear Timer on Compare) mode
  - Fast PWM and Phase Correct PWM
- **External interrupt INT0**
- **7-segment displays**
  - Single, two-digit, three-digit, and multiplexed four-digit setups
- **8×8 LED matrix**
- **16×2 HD44780 character LCD**
- **4×4 matrix keypads**

**Embedded Design Concepts**

- Time-multiplexed displays (sharing segment bus, per-digit enable lines)
- Generating precise delays with timers instead of busy-waits
- PWM for brightness / signal generation
- Decoding keypad row/column patterns to key codes
- Binary-to-decimal conversion (0–255) using repeated subtraction
- Capstone: integrating timers, displays, state machines, and user input

---

## Project Index

Each subfolder contains its own `README.md` with build details and schematics.

### Basic I/O & Patterns

- [`flashing_light`](./flashing_light)  
  Simple LED blinking on an AVR output pin using C and delay routines.  
  **Skills:** GPIO setup, delays, basic embedded C.

- [`bincounter`](./bincounter)  
  4-bit binary counter on `PORTB` LEDs (1–15) using a lookup table.  
  **Skills:** GPIO, lookup tables, simple patterns in C.

- [`push_button_led_chaser`](./push_button_led_chaser)  
  Push-button controlled LED “running light” on 8 LEDs.  
  **Skills:** Input with pull-ups, basic debouncing, shifting patterns.

- [`prime_checker`](./prime_checker)  
  Simple prime-number check in C (trial division up to `sqrt(n)`).  
  **Skills:** Control flow, math in embedded C, basic console-style logic.

### 7-Segment Display Projects

- [`7seg`](./7seg)  
  4-digit multiplexed 7-segment display driven from C, using `PORTA` for digit selects and `PORTB` for segment data.  
  **Skills:** Time-multiplexing, segment encoding, display refresh timing.

- [`7seg.asm`](./7seg.asm)  
  Two-digit 7-segment display demo in pure AVR assembly (constant value display).  
  **Skills:** AVR assembly, lookup tables in flash, basic multiplexing.

- [`three_digit_7seg_display`](./three_digit_7seg_display)  
  Reads an 8-bit value from `PINA` (0–255), converts to hundreds/tens/ones, and drives a 3-digit 7-segment display.  
  **Skills:** Binary-to-decimal conversion, 7-segment multiplexing, flash lookup tables.

### Matrix & LCD Displays

- [`led_matrix_pattern`](./led_matrix_pattern)  
  8×8 LED matrix pattern driver using `PORTA` (columns) and `PORTB` (rows).  
  **Skills:** LED matrix scanning, persistence of vision, bit patterns.

- [`lcd_welcome_banner`](./lcd_welcome_banner)  
  16×2 HD44780 LCD demo with a “WELCOME” banner and scrolling AVR/microcontroller text.  
  **Skills:** Character LCD initialization, cursor positioning, simple text animation.

### Timers, Interrupts & PWM

- [`Timer0_CTC_Square_Wave`](./Timer0%20CTC%20Square%20Wave)  
  Timer0 configured in CTC mode to toggle OC0 (PB3) purely in hardware.  
  **Skills:** Timer0 CTC, hardware-generated square waves, precise timing.

- [`Timer0_CTC_PortA_Toggle`](./Timer0_CTC_PortA_Toggle)  
  Timer0 CTC used as a time base; code polls OCF0 and toggles `PORTA` in software.  
  **Skills:** Polling timer flags, software toggling, timing vs. CPU load trade-off.

- [`timer0_ctc_interrupt_toggle`](./timer0_ctc_interrupt_toggle)  
  Timer0 in CTC mode with **compare match interrupt** toggling `PB0`.  
  **Skills:** ISRs, interrupt vectors, timer-driven square wave via software.

- [`ext_into_timer_start`](./ext_into_timer_start)  
  External interrupt **INT0** starts Timer0 and sets an LED.  
  **Skills:** External interrupts, stack initialization, interaction between INT0 and timers.

- [`fast_pwm_oc0`](./fast_pwm_oc0)  
  Timer0 in **Fast PWM** mode generating PWM on OC0 (PB3).  
  **Skills:** Fast PWM configuration, duty-cycle control via `OCR0`.

- [`pwmPhaseC`](./pwmPhaseC)  
  Timer0 in **Phase Correct PWM** mode for symmetric PWM on OC0.  
  **Skills:** Phase correct PWM, non-inverting output setup, timing symmetry.

- [`timer0_led_blink_porta`](./timer0_led_blink_porta)  
  Uses Timer0 overflow as a software time base to blink three LEDs on `PORTA`.  
  **Skills:** Timer overflow, multi-stage software delays, simple light patterns.

### Keypads & Input Decoding

- [`IO TEST`](./IO%20TEST)  
  Nibble copy and basic arithmetic demo in assembly: upper nibble of `PINA` mirrored to lower nibble of `PORTA`.  
  **Skills:** DDRA configuration, reading/writing ports, shifts, `MUL` instruction.

- [`keypad_direct_decode`](./keypad_direct_decode)  
  4×4 matrix keypad on `PORTA`, decoded to a numeric code on `PORTC` using explicit comparisons (no table).  
  **Skills:** Matrix keypad scanning, row/column decoding in assembly, control flow.

- [`matrix_keypad_7seg`](./matrix_keypad_7seg)  
  4×4 keypad scanned on `PORTA`; matching patterns are looked up in a flash table and output on `PORTB`.  
  **Skills:** Keypad scanning, flash table search with `LPM`, pattern mapping.

- [`keypad_2digit_7seg`](./keypad_2digit_7seg)  
  Starts with keypad scanning, then demonstrates a constant 2-digit 7-segment display (value 35) using the same flash lookup table.  
  **Skills:** Reusing lookup tables, keypad to display pipeline, 2-digit multiplexing.

### Capstone

- [`traffic_light_controller_7seg`](./traffic_light_controller_7seg)  
  **Capstone project.** A full traffic light controller with red/orange/green phases on `PORTA` and a 2-digit 7-segment **countdown timer** driven by Timer0. Supports **manual overrides** via `PORTD` to shorten or skip phases.  
  **Skills:**  
  - State machine design for multi-phase control  
  - Timer0 as 1-second time base (overflow timing)  
  - Binary-to-decimal conversion for countdown  
  - Two-digit 7-segment multiplexing  
  - Handling user input to modify timing logic  
  - Combining multiple peripherals (GPIO, timers, displays, inputs) into a single integrated system

---

These AVR exercises document my **embedded-systems fundamentals**: from raw register programming and assembly to integrating timers, interrupts, keypads, displays, and state machines into a complete application.
