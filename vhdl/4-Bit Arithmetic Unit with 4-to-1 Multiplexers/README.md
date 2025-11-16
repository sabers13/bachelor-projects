# 4-Bit Arithmetic Unit with 4-to-1 Multiplexers (VHDL)

## Overview

This project implements a simple **4-bit arithmetic unit** in VHDL.  
The design uses:

- A **4-to-1 multiplexer** to generate different variants of the second operand `B` bit-by-bit.
- A chain of **1-bit full adders** to form a 4-bit ripple-carry adder.

By selecting different multiplexer inputs via control signals `s1` and `s0`, and providing an external carry-in `cin`, the circuit can realize several arithmetic operations between the 4-bit operands `A` and `B` (for example: `A + B`, `A + not B`, `A + 1`, etc., depending on how the inputs are wired and which operation is selected).

A dedicated testbench (`mainTB.vhd`) stimulates the design with various input and select patterns.

---

## Files

- `main.vhd`  
  Top-level 4-bit arithmetic unit.  
  - Inputs:  
    - `cin` – carry in  
    - `s1`, `s0` – 2-bit control for the multiplexers  
    - `a0`, `a1`, `a2`, `a3` – bits of operand A  
    - `b0`, `b1`, `b2`, `b3` – bits of operand B  
  - Outputs:  
    - `d0`, `d1`, `d2`, `d3` – 4-bit result  
    - `Cout` – final carry out  
  Internally, `main` instantiates:
  - Four instances of `mux4to1` (one per bit of operand B) to generate modified bits `y0`–`y3`.
  - Four instances of a `fulladder` component, chained in ripple-carry form, to produce `d0`–`d3` and `Cout`.

- `mux4to1.vhd`  
  4-to-1 multiplexer used as a building block in the arithmetic unit.  
  - Inputs:  
    - `s0`, `s1` – select lines  
    - `i0`, `i1`, `i2`, `i3` – data inputs  
  - Output:  
    - `y` – selected data output  
  The architecture is a simple combinational process that selects `y` based on the values of `s1 s0`:
  - `s1 s0 = "00"` → `y = i0`  
  - `s1 s0 = "01"` → `y = i1`  
  - `s1 s0 = "10"` → `y = i2`  
  - `s1 s0 = "11"` → `y = i3`  

- `mainTB.vhd`  
  VHDL testbench for the `main` entity.  
  Instantiates the arithmetic unit as the Unit Under Test and applies a sequence of test vectors to:
  - Explore different combinations of `s1`, `s0`, and `cin`.
  - Vary the 4-bit operands `A` (`a3..a0`) and `B` (`b3..b0`).
  - Observe the resulting outputs `d3..d0` and `Cout` over time.

> Note: `main.vhd` depends on a `fulladder` component (1-bit full adder) with ports `(A, B, Cin, S, Cout)`.  
> The corresponding VHDL source for this full adder must be available in the same library when synthesizing or simulating this project.

---

## Design Structure

For each bit position `i` (0 to 3):

1. `mux4to1` selects one of four possibilities derived from `b(i)`:
   - `b(i)`
   - `not b(i)`
   - constant `'0'`
   - constant `'1'`

2. The selected bit `y(i)` is then fed, together with `a(i)` and the incoming carry, into a `fulladder` cell.

The four `fulladder` instances are connected in series:

- Bit 0 receives external `cin`.
- Bit 1 receives the carry out of bit 0.
- Bit 2 receives the carry out of bit 1.
- Bit 3 receives the carry out of bit 2 and produces the final `Cout`.

This structure demonstrates how multiplexers and full adders can be combined to form a small configurable arithmetic block.

---

## Simulation

- `mainTB.vhd` serves as the top-level for simulation.  
- The testbench drives the control signals and operands through multiple scenarios with fixed time delays between changes, allowing observation of the arithmetic unit’s behaviour under different configurations.
