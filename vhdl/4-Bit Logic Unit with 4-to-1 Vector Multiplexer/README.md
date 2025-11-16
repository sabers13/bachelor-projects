# 4-Bit Logic Unit with 4-to-1 Vector Multiplexer (VHDL)

## Overview

This project implements a simple **4-bit combinational logic unit** in VHDL.

Given two 4-bit input vectors `a` and `b`, the top-level module `4_Bit_Logic_Unit` computes four different bitwise operations:

- `a and b`
- `a or b`
- `a xor b`
- `not a`

A separate 4-to-1 **vector multiplexer** (`mux`) then selects which of these four results appears on the 4-bit output `e`, based on a 2-bit select signal `s`.

This design is a compact example of how to combine basic logic operations with a multiplexer to build a configurable logic block (similar in spirit to a very small ALU slice).

---

## Files

- `4_Bit_Logic_Unit.vhd`  
  Top-level 4-bit logic unit that:
  - Takes 4-bit inputs `a` and `b`.
  - Computes the four bitwise results (`a and b`, `a or b`, `a xor b`, `not a`).
  - Instantiates the `mux` component to select which result drives the output `e`.

- `mux.vhd`  
  4-to-1 multiplexer for 4-bit vectors, used as a building block by `4_Bit_Logic_Unit`.

---

## Entity Interfaces

### `4_Bit_Logic_Unit` – 4-Bit Logic Unit

```vhdl
entity hw is
    Port (
        a : in  STD_LOGIC_VECTOR (0 downto 3);
        b : in  STD_LOGIC_VECTOR (0 downto 3);
        s : in  STD_LOGIC_VECTOR (0 downto 1);
        e : out STD_LOGIC_VECTOR (0 downto 3)
    );
end hw;
```

- `a`, `b` — 4-bit input operands.  
- `s` — 2-bit select signal; controls which operation result is sent to `e`.  
- `e` — 4-bit output vector.

Internally, `4_Bit_Logic_Unit` instantiates the `mux` component as:

```vhdl
mux0: mux
    port map(
        a and b,   -- i1
        a or b,    -- i2
        a xor b,   -- i3
        not a,     -- i4
        s,         -- select
        e          -- output
    );
```

This means the four multiplexer inputs correspond to:

- `i1 = a and b`
- `i2 = a or b`
- `i3 = a xor b`
- `i4 = not a`

### `mux` – 4-to-1 Vector Multiplexer

```vhdl
entity mux is
    Port (
        i1 : in  STD_LOGIC_VECTOR (0 downto 3);
        i2 : in  STD_LOGIC_VECTOR (0 downto 3);
        i3 : in  STD_LOGIC_VECTOR (0 downto 3);
        i4 : in  STD_LOGIC_VECTOR (0 downto 3);
        s  : in  STD_LOGIC_VECTOR (0 downto 1);
        y  : out STD_LOGIC_VECTOR (0 downto 3)
    );
end mux;
```

The architecture is a simple combinational process that selects one of the four 4-bit inputs based on `s`:

```vhdl
process(s, i1, i2, i3, i4)
begin
    if    s = "00" then
        y <= i1;
    elsif s = "01" then
        y <= i2;
    elsif s = "10" then
        y <= i3;
    else
        y <= i4;
    end if;
end process;
```

---

## Behaviour Summary

With the wiring in `4_Bit_Logic_Unit.vhd`, the 2-bit select `s` controls the logic operation:

- `s = "00"` → `e = a and b`
- `s = "01"` → `e = a or b`
- `s = "10"` → `e = a xor b`
- `s = "11"` → `e = not a`

All operations are **bitwise** and purely combinational, so there is no clock or state involved.

---

## Usage

To use this logic unit in a larger design or to simulate it:

1. Add both `4_Bit_Logic_Unit.vhd` and `mux.vhd` to your VHDL project.
2. Set `4_Bit_Logic_Unit` as the top-level entity (or instantiate it from another top-level).
3. Drive `a`, `b`, and `s` with the desired values.
4. Observe `e` to see the selected logic operation result.
