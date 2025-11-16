# VHDL Digital Logic Mini‑Projects

This directory contains a collection of small **VHDL designs** I implemented during my bachelor studies to practice **combinational and sequential digital design**, hierarchical modeling, and simulation workflows.  
Each sub‑folder is a self‑contained project with clean VHDL sources and its own `README.md`.

> Tools used: Xilinx ISE / ISim, ModelSim, and standard IEEE libraries (`STD_LOGIC_1164`, `NUMERIC_STD` where needed).

---

## Projects Overview

### 1. `full_subtractor/` – 1‑Bit Full Subtractor

A basic **1‑bit full subtractor** that computes the difference `D` and borrow‐out `Bo` for operands `A`, `B` and borrow‑in `Bi`.  
Includes a testbench that exhaustively simulates all input combinations.

**Skills demonstrated**

- Boolean‑equation design and VHDL implementation of arithmetic cells  
- Writing minimal, self‑checking style testbenches  
- Understanding of borrow handling and propagation

---

### 2. `one_bit_magnitude_comparator/` – 1‑Bit Comparator

Implements a **1‑bit magnitude comparator** with outputs for “less than”, “greater than”, and “equal”.  
All input combinations are driven from a dedicated testbench.

**Skills demonstrated**

- Clean use of conditional signal assignment in VHDL  
- Encoding comparison logic with mutually exclusive outputs  
- Basic verification of truth‑table–based circuits

---

### 3. `Multiplexers and AddSubtract Units/`

A small library of **combinational building blocks**:

- 2‑to‑1 and 4‑to‑1 multiplexers  
- 1‑bit configurable add/subtract cell  
- 4‑bit ripple‑carry add/subtract unit with carry‑out and overflow

**Skills demonstrated**

- **Hierarchical design** (building 4‑to‑1 MUX from 2‑to‑1 MUXes)  
- Ripple‑carry adder / subtractor construction from 1‑bit cells  
- Modeling overflow and carry behaviour in VHDL  
- Writing structured testbenches for multi‑bit arithmetic

---

### 4. `JK Flip-Flop and 4-Bit Synchronous Counter/`

Sequential building blocks:

- JK flip‑flop with asynchronous preset and clear  
- 4‑bit synchronous up‑counter with synchronous reset

**Skills demonstrated**

- Edge‑triggered sequential logic and process sensitivity lists  
- Handling **asynchronous preset/clear** vs. synchronous reset  
- Designing simple counters and understanding wrap‑around behaviour  
- Simulation of clocked circuits and timing

---

### 5. `4-Bit Arithmetic Unit with 4-to-1 Multiplexers/`

A small **4‑bit arithmetic unit** that combines:

- A 4‑to‑1 multiplexer per bit to generate different variants of operand `B`  
- A chain of 1‑bit full adders to form a 4‑bit ripple‑carry adder

By choosing multiplexer inputs and control signals, the unit can realize several operations such as `A + B`, `A + not B`, `A + 1`, etc.

**Skills demonstrated**

- Designing an **ALU‑like datapath**  
- Combining multiplexers and adders to create configurable arithmetic  
- Managing carry propagation and control signals across multiple bits

---

### 6. `4-Bit Logic Unit with 4-to-1 Vector Multiplexer/`

A 4‑bit logic unit that computes:

- `A AND B`  
- `A OR B`  
- `A XOR B`  
- `NOT A`

and uses a **4‑to‑1 vector multiplexer** to select which result appears on the output.

**Skills demonstrated**

- Re‑using a vector multiplexer as a shared resource  
- Clean separation between **operator logic** and **selection logic**  
- Working with `STD_LOGIC_VECTOR` signals and bitwise operators

---

### 7. `4-Bit Logic Unit (Direct Implementation)/`

A second version of the 4‑bit logic unit, implemented directly in a single combinational process without a separate multiplexer component.

**Skills demonstrated**

- Alternative, compact coding style using a single `process`  
- Comparing hierarchical vs. flat modelling styles in VHDL  
- Reasoning about readability and synthesizability of different descriptions

---

## Skills Highlighted by This Collection

Across these mini‑projects I practiced and demonstrated:

- **VHDL syntax & coding style**
  - Entities/architectures, component instantiation, concurrent vs. sequential statements
- **Combinational design**
  - Adders, subtractors, comparators, multiplexers, basic logic units
- **Sequential design**
  - JK flip‑flops, synchronous counters, reset strategies
- **Hierarchical and modular design**
  - Building complex blocks (ALU‑like units, 4‑to‑1 MUX) from simpler components
- **Simulation & verification**
  - Creating focused testbenches for both combinational and sequential logic  
  - Using waveform inspection and timing control (`wait for`, clock generation)
- **FPGA readiness**
  - All designs are synthesizable and map directly to LUT‑ and flip‑flop–based FPGA fabrics.

Together, these projects form a compact showcase of my **digital design foundations in VHDL**: from basic gates and arithmetic cells up to small arithmetic/logic units and counters, with a strong emphasis on clear structure, reusability, and simulation‑driven verification.
