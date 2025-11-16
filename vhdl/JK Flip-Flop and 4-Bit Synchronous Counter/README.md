# JK Flip-Flop and 4-Bit Synchronous Counter (VHDL)

## Overview

This project contains two classic sequential building blocks implemented in VHDL:

- A **JK flip-flop with asynchronous preset and clear**
- A **4-bit synchronous up-counter** with synchronous reset

Each module comes with its own auto-generated testbench for simulation.

---

## JK Flip-Flop

### Entity

```vhdl
entity jkff is
    port (
        j, k, clk, pr, clr : in  std_logic;
        q, qnot            : out std_logic
    );
end jkff;
```

### Behaviour

- **clk** – flip-flop is edge triggered (updates on the rising edge of `clk`).
- **clr** – asynchronous clear:
  - When `clr = '1'`, the internal state is forced to `0` and `q = '0'`, `qnot = '1'`.
- **pr** – asynchronous preset:
  - When `pr = '1'` (and `clr = '0'`), the internal state is forced to `1` and `q = '1'`, `qnot = '0'`.
- **J/K inputs** – standard JK truth table is implemented when clocked and not in reset/preset:
  - `J = 0, K = 0` → **hold** previous state
  - `J = 0, K = 1` → **reset** (`q = 0`)
  - `J = 1, K = 0` → **set** (`q = 1`)
  - `J = 1, K = 1` → **toggle** (`q` becomes `not q`)

The internal state is stored in a signal (e.g. `answer`) and continuously driven out to `q` and its complement `qnot`.

### Testbench (`jkTB.vhd` / `jk_flip_flop_tb.vhd`)

The testbench instantiates `jkff` as the Unit Under Test (UUT) and:

- Generates a clock.
- Pulses **clr** and **pr** to verify asynchronous behaviour.
- Applies different combinations of `J` and `K` to demonstrate hold, set, reset and toggle.

To simulate:

1. Add `jkff.vhd` and `jkTB.vhd` to your project.
2. Set the testbench entity (usually `jkTB`) as the top-level for simulation.
3. Run the simulation and inspect `q`/`qnot` for all J/K and preset/clear conditions.

---

## 4-Bit Synchronous Up-Counter

### Entity

```vhdl
entity counter is
    port (
        clk      : in  std_logic;
        rst      : in  std_logic;
        counterO : out std_logic_vector(3 downto 0)
    );
end counter;
```

### Behaviour

The architecture uses an internal 4-bit `std_logic_vector` signal (e.g. `count`) and increments it on each rising edge of the clock:

```vhdl
process(clk)
begin
    if rising_edge(clk) then
        if rst = '1' then
            count <= x"0";          -- synchronous reset to 0000
        else
            count <= count + x"1";  -- increment by 1
        end if;
    end if;
end process;

counterO <= count;
```

Key properties:

- **Synchronous reset** – `rst` is checked inside the clocked process, so the counter resets on a clock edge.
- **Up-counter** – counts from `0000` to `1111` and then wraps around to `0000`.
- **4-bit output** – `counterO` exposes the internal count value.

### Testbench (`counterTB.vhd` / `sync_counter_4bit_tb.vhd`)

The testbench:

- Generates a periodic clock.
- Drives `rst` high for a few cycles to verify reset behaviour.
- Keeps `rst` low to let the counter run through multiple counts.

To simulate:

1. Add `counter.vhd` and `counterTB.vhd` to your project.
2. Set the testbench entity (usually `counterTB`) as the top-level for simulation.
3. Run the simulation long enough to observe several increments and at least one wrap from `1111` to `0000`.

---

## How to Use in Larger Designs

- The **JK flip-flop** can be used as a building block in custom counters, shift registers, and control state machines, especially when you want explicit toggle behaviour.
- The **4-bit counter** can serve as:
  - A simple clock divider (using one of its bits).
  - A state index for sequence generation.
  - A basic timing/delay element in digital designs.

Both modules are synthesizable and map directly to flip-flops and LUTs on FPGAs or standard cells in ASIC flows.
