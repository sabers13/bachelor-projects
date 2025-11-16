# 1-Bit Full Subtractor (VHDL)

## Overview

This project implements a **1-bit full subtractor** in VHDL.  
The circuit subtracts `B` and the borrow-in `Bi` from `A` and produces:

- `D` – the 1-bit **difference**
- `Bo` – the **borrow out** signal

A simple VHDL testbench is included to exercise all input combinations.

## Files

- `full_subtractor.vhd`  
  VHDL description of the 1-bit full subtractor.

- `full_subtractor_tb.vhd`  
  VHDL testbench that applies all possible input combinations of `A`, `B`, and `Bi` with 100 ns spacing.

## Entity Interface

```vhdl
entity full_subtractor is
  port (
    A  : in  std_logic;  -- minuend bit
    B  : in  std_logic;  -- subtrahend bit
    Bi : in  std_logic;  -- borrow in
    D  : out std_logic;  -- difference
    Bo : out std_logic   -- borrow out
  );
end full_subtractor;
```

### Logic Equations

- Difference: `D  = A xor B xor Bi`
- Borrow out: `Bo = (not A and B) or (not (A xor B) and Bi)`

These are the standard equations for a 1-bit full subtractor.

## How to Simulate

1. **Add sources**  
   Import `full_subtractor.vhd` and `full_subtractor_tb.vhd` into your VHDL project (e.g., Xilinx ISE, ModelSim, etc.).

2. **Set top module**  
   Set `full_subtractor_tb` as the **top-level / simulation** entity.

3. **Run the simulation**  
   Run the simulation for at least **800 ns** so that all test vectors generated in the testbench are applied.

4. **Verify results**  
   - Check that `D` matches the binary difference `A − B − Bi`.  
   - Check that `Bo` is asserted whenever a borrow is required.

## Synthesis Notes

- The design uses only basic `and`, `or`, `xor`, and `not` logic, so it maps directly to LUTs on any FPGA.
- No clock or reset is required; this is a purely combinational circuit.
