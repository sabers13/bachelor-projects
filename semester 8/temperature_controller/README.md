# Temperature-Based Heater & Cooler Controller (Finite-State Machine)

## Overview

This project implements a **temperature controller** using a finite‑state machine.  
Depending on the measured temperature, the controller:

- Turns the **heater** on in low or high mode, or
- Turns the **cooler** on with three different fan speeds (CRS = 4, 6, 8 RPS), or
- Turns both heater and cooler **off** when the temperature is in a comfortable range.

Two variants are included:

- A **console simulation in C** that lets you step through the state machine by typing temperatures.
- An **embedded sketch** (Arduino + DHT22 sensors) that reads real temperature/humidity data and controls cooler output pins.

The state diagram is provided in `states.jpg`.

---

## Files

- `cooler heater.c`  
  Console‑based C implementation of the state machine.  
  Models:
  - **State 1** – Idle: heater OFF, cooler OFF  
  - **State 2** – Cooling: heater OFF, cooler ON with 3 internal speed states  
  - **State 3** – Heating: cooler OFF, heater ON with 2 internal power modes  

- `code.c`  
  Arduino sketch using the **DHT22** temperature/humidity sensors to:
  - Read temperature from two DHT22 sensors (pins 8 and 9).
  - Drive two digital output pins for **low** and **high** cooler modes.
  - Print current humidity and temperature values over the serial monitor.

- `states.jpg`  
  State diagram for the controller, showing:
  - Top‑level states (Idle, Cooling, Heating)
  - Internal cooler states (CRS = 4, 6, 8 RPS)
  - Internal heater modes (Low, High)
  - State transitions based on temperature thresholds.

- `project.pdsprj`, `pro.pdsprj`  
  Proteus project files (or similar schematic/simulation project) used to simulate the hardware design.

- `cooler heater.exe`, `cooler heater.o`  
  Pre‑built binary and object files for the console simulation.

---

## State Machine Logic

### Top‑Level States

1. **State 1 – Idle (Comfort Zone)**  
   - Heater: OFF  
   - Cooler: OFF  
   - Transitions:
     - If **T < 15°C** → go to **State 3 (Heating)**  
     - If **T > 35°C** → go to **State 2 (Cooling)**  
     - Otherwise stay in State 1 and read a new temperature.

2. **State 2 – Cooling**  
   - Heater: OFF  
   - Cooler: ON  
   - Internal cooler state `coolerState` controls the speed:
     - **coolerState = 1** → `CRS = 4` RPS  
       - If **T > 40°C** → go to `coolerState = 2`  
       - If **T < 25°C** → go back to **State 1 (Idle)**  
     - **coolerState = 2** → `CRS = 6` RPS  
       - If **T < 35°C** → go to `coolerState = 1`  
       - If **T > 45°C** → go to `coolerState = 3`  
     - **coolerState = 3** → `CRS = 8` RPS  
       - If **T < 40°C** → go back to `coolerState = 2`  

   - From each internal state, the program prints the current cooler speed and reads a new temperature from the user.

3. **State 3 – Heating**  
   - Cooler: OFF  
   - Heater: ON  
   - Internal heater state `heaterState` controls the power mode:
     - **heaterState = 1 – Low**  
       - If **T > 30°C** → go back to **State 1 (Idle)**  
       - If **T < 10°C** → go to `heaterState = 2` (High)  
     - **heaterState = 2 – High**  
       - If **T > 15°C** → go back to `heaterState = 1`  

   - In each internal heater state, the program prints the current mode (low / high) and reads the next temperature.

The transitions in the C code match the thresholds and states shown in `states.jpg`.

---

## How to Build & Run (Console Version)

1. **Compile**

   ```bash
   gcc "cooler heater.c" -o cooler_heater
   ```

2. **Run**

   ```bash
   ./cooler_heater
   ```

3. **Interact**

   - The program starts in State 1 with an initial temperature of 25°C.
   - After each message, type the next temperature (integer) and press **Enter**.
   - Watch the printed messages to see when the controller:
     - Turns the heater ON (low/high),
     - Changes cooler speed (CRS = 4, 6, 8),
     - Or returns to the idle state.

---

## How to Use the Arduino Sketch

1. Open `code.c` in the Arduino IDE (or copy its contents into a new sketch).
2. Install the **DHT sensor library** (if not already installed).
3. Adjust the digital pin numbers for:
   - `DHT0PIN`, `DHT1PIN`
   - `Cooler_Low_PIN`, `Cooler_High_PIN`
4. Upload to an Arduino board with:
   - Two DHT22 sensors wired to the specified pins.
   - Two digital outputs connected to cooler‑control circuitry (or LEDs for testing).
5. Open the Serial Monitor at **9600 baud** to view humidity/temperature and observe cooler pin toggling.

---

## Skills Demonstrated

- **Finite‑state machine design** for real‑world control logic.
- **Structured C programming** with nested state machines and clear transition logic.
- **Embedded development** with Arduino, including:
  - Using external libraries (`DHT.h`)
  - Reading sensor data (DHT22)
  - Driving digital outputs for actuators.
- Integration of **state diagrams**, console simulation, and embedded code for a complete control‑system prototype.
