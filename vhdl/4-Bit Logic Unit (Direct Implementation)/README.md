# 4-Bit Logic Unit (Direct Implementation) – VHDL

## Overview

This project implements a simple **4-bit combinational logic unit** in VHDL.

Given two 4-bit input vectors `a` and `b`, the circuit computes four different bitwise operations and selects one of them based on the 2-bit control input `s`:

- `a and b`
- `a or b`
- `a xor b`
- `not a`

The selected 4-bit result is driven on the output vector `e`. A VHDL testbench is provided to verify the behaviour for a sample set of inputs.

---

## Files

- `Top_level.vhd`  
  Top-level 4-bit logic unit:
  - Inputs  
    - `a(0..3)` – 4-bit operand A  
    - `b(0..3)` – 4-bit operand B  
    - `s(0..1)` – 2-bit select signal  
  - Output  
    - `e(0..3)` – 4-bit result

- `Top_level_tb.vhd`  
  VHDL testbench for `Top_level`. Instantiates the logic unit and applies one example vector (`a = "0101"`, `b = "1010"`) with `s = "00"` to exercise the `a and b` case. The structure can be extended with additional stimuli if needed.

---

## Entity: `azhw`

```vhdl
entity azhw is
    Port (
        a : in  STD_LOGIC_VECTOR (0 downto 3);
        b : in  STD_LOGIC_VECTOR (0 downto 3);
        s : in  STD_LOGIC_VECTOR (0 downto 1);
        e : out STD_LOGIC_VECTOR (0 downto 3)
    );
end azhw;
```

### Architecture

The logic unit is implemented as a single combinational process:

```vhdl
process(s, a, b)
begin
    if    s = "00" then
        e <= a and b;
    elsif s = "01" then
        e <= a or b;
    elsif s = "10" then
        e <= a xor b;
    else
        e <= not a;
    end if;
end process;
```

### Operation Summary

With the wiring above, the select input `s` chooses the operation as follows:

- `s = "00"` → **bitwise AND**  → `e = a and b`
- `s = "01"` → **bitwise OR**   → `e = a or b`
- `s = "10"` → **bitwise XOR**  → `e = a xor b`
- `s = "11"` → **bitwise NOT A**→ `e = not a`

All operations are purely combinational; there is no clock or internal state.

---

## Testbench: `Top_level_tb`

The testbench:

- Declares signals for `a`, `b`, `s`, and `e`.
- Instantiates the `Top_level` unit under test.
- Applies a single stimulus pattern and waits for 100 ns to observe the result.

This file serves as a basic starting point for simulation and can be expanded with additional test cases and assertions as needed.
