# 1-Bit Magnitude Comparator (VHDL)

## Overview

This project implements a **1-bit magnitude comparator** in VHDL.  
Given two 1-bit inputs `A` and `B`, the circuit produces three outputs that indicate whether:

- `H` – **A < B**
- `L` – **A > B**
- `E` – **A = B**

A simple VHDL testbench is included to exercise all input combinations.

## Files

- `one_bit_magnitude_comparator.vhd`  
  VHDL description of the 1-bit magnitude comparator.

- `one_bit_magnitude_comparator_tb.vhd`  
  VHDL testbench that applies all possible input combinations of `A` and `B` with 100 ns spacing between vectors.

## Entity Interface

```vhdl
entity one_bit_magnitude_comparator is
  port (
    A : in  std_logic;  -- first input bit
    B : in  std_logic;  -- second input bit
    H : out std_logic;  -- A < B
    L : out std_logic;  -- A > B
    E : out std_logic   -- A = B
  );
end one_bit_magnitude_comparator;
```

### Logic Equations

The comparator can be expressed with simple Boolean equations:

- `H = '1'` when `A < B`, else `'0'`
- `L = '1'` when `A > B`, else `'0'`
- `E = '1'` when `A = B`, else `'0'`

In the VHDL implementation this is written using conditional signal assignments:

```vhdl
H <= '1' when A < B else '0';
L <= '1' when A > B else '0';
E <= '1' when A = B else '0';
```

## How to Simulate

1. **Add sources**  
   Import `one_bit_magnitude_comparator.vhd` and `one_bit_magnitude_comparator_tb.vhd` into your VHDL project (e.g., Xilinx ISE, ModelSim, etc.).

2. **Set top module**  
   Set `one_bit_magnitude_comparator_tb` as the **top-level / simulation** entity.

3. **Run the simulation**  
   Run the simulation for at least **400 ns** so that all test vectors generated in the testbench are applied.

4. **Verify results**  
   - Check that only one of `H`, `L`, or `E` is high at any given time.
   - Confirm that:
     - `H = '1'` when `A = '0'` and `B = '1'`
     - `L = '1'` when `A = '1'` and `B = '0'`
     - `E = '1'` when `A = B`

## Synthesis Notes

- The design uses purely combinational logic and maps directly to LUTs on any FPGA or to simple gates in ASIC/TTL implementations.
- No clock or reset is required.

