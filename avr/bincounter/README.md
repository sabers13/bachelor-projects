# bincounter

4-bit **binary counter** project using an **AVR microcontroller**, written in **C** (CodeVisionAVR / AVR toolchain) and simulated in **Proteus**.

The program drives the **lower 4 bits of PORTB** as outputs and repeatedly counts from `0001₂` to `1111₂` (1–15) on a set of LEDs, updating the pattern every 250 ms.

---

## Features

- Displays a **4-bit binary count** on four LEDs
- Uses a simple **lookup table** (`code[]`) to step through values `0x01` to `0x0F`
- Fixed delay (`delay_ms(250)`) between each step for a visible counting effect
- Clean separation between:
  - **Firmware** (C source + project files)
  - **Simulation** (Proteus schematic)

---

## Tech Stack

- **Microcontroller:** AVR (e.g. ATmega16)
- **Language:** C
- **Toolchain / IDE:** CodeVisionAVR or AVR toolchain integrated in Atmel Studio
- **Simulation:** Proteus

---

## Repository Structure

Suggested clean structure when publishing to GitHub:

```text
bincounter/
├─ firmware/
│  ├─ bincounter.c        # Main C source file (binary counter logic)
│  ├─ bincounter.cproj    # Atmel/CodeVision project file
│  └─ bincounter.atsln    # Solution file (if using Atmel Studio)
├─ simulation/
│  ├─ bincounter.pdsprj   # Proteus simulation project (MCU + 4 LEDs)
├─ .gitignore
└─ README.md
```

Build artifacts (`Debug/`, `Release/`, `.obj`, `.cof`, `.hex`, etc.) should **not** be committed to keep the repository clean.

---

## How the Code Works

The core logic in `bincounter.c` is:

1. Configure the **lower 4 bits of PORTB as outputs**:

   - `DDRB = 0x0F;`  
   - This makes pins `PB0`–`PB3` output, typically each driving an LED (with a series resistor).

2. Initialize the output port:

   - `PORTB = 0x00;` (all LEDs initially off)

3. Define a **lookup table** of 4-bit values:

   ```c
   char code[15] = {
       0x01, 0x02, 0x03, 0x04,
       0x05, 0x06, 0x07, 0x08,
       0x09, 0x0A, 0x0B, 0x0C,
       0x0D, 0x0E, 0x0F
   };
   ```

   This corresponds to binary patterns from `0001₂` to `1111₂`.

4. In the main loop:

   - Iterate through the array from index `0` to `14`
   - Write each value to `PORTB`, lighting the LEDs according to the binary pattern
   - Wait 250 ms between updates using `delay_ms(250);`

The effect is a **visible binary count** on the 4 LEDs, repeatedly cycling from 1 to 15.

---

## Getting Started

### Requirements

- **AVR toolchain** (CodeVisionAVR or AVR-GCC via Atmel Studio)
- **Proteus** (for simulation)
- Optional hardware:
  - ATmega16 (or compatible) development board
  - AVR programmer (USBasp, AVRISP, etc.)
  - Breadboard, 4 LEDs, resistors

---

### 1. Build the Firmware

1. Open the project (`bincounter.cproj` / `bincounter.atsln`) in your AVR IDE.
2. Ensure the **device** is set correctly (e.g. `ATmega16`).
3. Build the project to generate the **HEX** file.

---

### 2. Run the Simulation in Proteus

1. Open `simulation/bincounter.pdsprj` in **Proteus**.
2. Double-click the microcontroller component and **load the generated HEX file**.
3. Click **Run**.
4. Watch the 4 LEDs toggle through the binary sequence from 1 to 15.

---

### 3. (Optional) Test on Real Hardware

1. Flash the compiled HEX to your ATmega16 using your programmer.
2. Connect 4 LEDs (with series resistors) to `PB0`–`PB3`.
3. Power the circuit and observe the binary counting pattern on the LEDs.

---

## Educational Objectives

This project demonstrates:

- Basic **AVR I/O configuration** for output
- Using **lookup tables** instead of arithmetic for simple patterns
- The concept of **binary representation** on multiple LEDs
- The development workflow from **firmware** → **simulation** → (optional) **real hardware**

---

## Possible Extensions

- Add `0x00` to the table to show a full 0–15 count (16 states).
- Increase the number of output bits (e.g. 8 LEDs on an entire port).
- Change the delay to vary counting speed or make it user-adjustable.
- Use a **timer interrupt** instead of `delay_ms()` for more accurate timing.


---

## Author

**Saber Sojudi**  
4-bit AVR binary counter project from my Bachelor’s embedded systems work.
