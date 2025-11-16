# Combinational Building Blocks: Multiplexers and Add/Subtract Units (VHDL)

## Overview

This project contains a small library of **combinational building blocks** implemented in VHDL:

- A basic **2-to-1 multiplexer**
- A hierarchical **4-to-1 multiplexer** built from 2-to-1 MUXes
- A **1-bit add/subtract unit**
- A **4-bit add/subtract unit** with overflow and carry-out

Each module has a dedicated VHDL testbench for functional simulation.

## File Structure

- `mux2x1.vhd`  
  2-to-1 multiplexer.

- `mux4x1.vhd`  
  4-to-1 multiplexer built from three instances of the 2-to-1 multiplexer.

- `mux4x1TB.vhd`  
  Testbench for the 4-to-1 multiplexer.

- `fulladder.vhd`  
  1-bit add/subtract cell with an operation-select input.

- `fulladderTB.vhd`  
  Testbench for the 1-bit add/subtract cell.

- `subadder.vhd`  
  4-bit add/subtract unit with overflow and carry-out flags, built from four 1-bit cells.

- `subadderTB.vhd`  
  Testbench for the 4-bit add/subtract unit.

---

## Module Descriptions

### 2-to-1 Multiplexer (`mux2x1`)

A simple 2:1 MUX that selects between two single-bit inputs based on a select line.

**Entity**

```vhdl
entity mux2x1 is
    Port ( i0, i1, s : in  STD_LOGIC;
           y         : out STD_LOGIC);
end mux2x1;
```

- `i0`, `i1` – data inputs  
- `s` – select input  
- `y` – output (`i0` when `s = '0'`, `i1` when `s = '1'`)

---

### 4-to-1 Multiplexer (`mux4x1`)

A 4:1 MUX implemented hierarchically using three instances of `mux2x1`.

**Entity**

```vhdl
entity mux4x1 is
    Port ( i0, i1, i2, i3, s0, s1 : in  STD_LOGIC;
           y                      : out STD_LOGIC);
end mux4x1;
```

- `i0`–`i3` – data inputs  
- `s0`, `s1` – select lines (`s1 s0` form a 2-bit select)  
- `y` – selected output

**Truth Table (select behavior)**

| s1 s0 | Output |
|-------|--------|
|  0 0  | i0     |
|  0 1  | i1     |
|  1 0  | i2     |
|  1 1  | i3     |

The internal architecture instantiates three `mux2x1` blocks in a tree structure.

---

### 1-Bit Add/Subtract Cell (`fulladder`)

A 1-bit arithmetic cell that can perform **addition or subtraction** based on the operation input `OP`.

**Entity**

```vhdl
entity fulladder is
    port (
        A, B, OP : in  std_logic;
        R, C     : out std_logic
    );
end fulladder;
```

- `A`, `B` – operand bits  
- `OP` – operation select (e.g. `'0'` for addition, `'1'` for subtraction using 2’s complement logic)  
- `R` – result bit  
- `C` – carry-out / borrow-out (depending on the operation)

The internal implementation uses combinational logic to implement a configurable 1-bit adder/subtractor cell.

---

### 4-Bit Add/Subtract Unit (`subadder`)

A 4-bit wide add/subtract unit composed of four `fulladder` cells. It operates on two 4-bit operands and generates result bits, a carry-out, and an overflow flag.

**Entity**

```vhdl
entity subadder is
    Port ( A0, A1, A2, A3,
           B0, B1, B2, B3,
           OP            : in  STD_LOGIC;
           R0, R1, R2, R3,
           overflow,
           Cout          : out STD_LOGIC);
end subadder;
```

- `A0`–`A3` – bits of operand A (LSB to MSB)  
- `B0`–`B3` – bits of operand B (LSB to MSB)  
- `OP` – operation select for add/subtract (propagated to each 1-bit cell)

- `R0`–`R3` – result bits (LSB to MSB)  
- `Cout` – final carry-out / borrow flag  
- `overflow` – arithmetic overflow indicator for signed operations

The typical implementation uses:

- Conditional inversion of `B` depending on `OP` (for subtraction via 2’s complement),
- A chain of four `fulladder` instances with ripple carry,
- Overflow derived from the most significant carries.

---

## Testbenches

Each major block has a corresponding testbench:

- `mux4x1TB.vhd`  
  Drives various combinations of inputs and select lines for the 4:1 MUX and observes the output.

- `fulladderTB.vhd`  
  Enumerates combinations of `A`, `B`, and `OP` to verify the 1-bit add/subtract behavior.

- `subadderTB.vhd`  
  Applies 4-bit operand patterns and different `OP` values to test the 4-bit add/subtract logic, checking both `Cout` and `overflow`.

Set the testbench entity as the **top-level** in your simulator (e.g. `mux4x1TB`, `fulladderTB`, or `subadderTB`) to run the corresponding simulation.

---

## Simulation

1. Add the VHDL source files and the desired testbench to your VHDL project.
2. Set the appropriate testbench entity as the **top-level** for simulation.
3. Run the simulation long enough to cover all stimuli defined in the testbench.
4. Inspect waveforms/signals to verify:
   - Correct multiplexing behavior in `mux4x1`.
   - Correct single-bit arithmetic in `fulladder`.
   - Correct 4-bit arithmetic, carry propagation, and overflow handling in `subadder`.

---

## Synthesis Notes

- All modules are purely **combinational**, using only basic logic operations.
- They map cleanly to LUT-based FPGA architectures or simple logic gates in ASIC implementations.
- No clock or reset is required, making them suitable as basic building blocks in larger arithmetic and control datapaths.
