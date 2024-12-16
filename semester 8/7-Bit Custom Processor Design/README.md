
# **7-Bit Custom Processor Design for Hardware-Software Co-Design**

---

## **Overview**  
This project implements a **7-bit processor** as part of a **hardware-software co-design** course. The processor supports fundamental instructions including `LOAD`, `ADD`, `SUB`, `JNZ` (Jump if Not Zero), and **MULTIPLY**. The entire design is implemented using **VHDL** and tested through simulation and assembly code conversion.

The processor consists of modular components:
- Arithmetic Logic Unit (ALU)
- Register File
- Program Counter (PC)
- Control Unit
- Memory (ROM)
- Multiplexers and Instruction Register  

---

## **Key Features**  

1. **7-Bit Processor Architecture**  
   - The processor operates on 7-bit wide data and instructions.  
   - Supports binary-coded instructions to execute operations efficiently.  

2. **Instruction Set Architecture (ISA)**  
   The processor supports a minimal but functional instruction set:  

   | **Instruction** | **Operation**                | **Opcode** |  
   |-----------------|------------------------------|-----------|  
   | `LOAD`         | Rx ← M[PC], PC ← PC + 1      | 00        |  
   | `ADD`          | Rx ← Rx + Ry                 | 01        |  
   | `SUB`          | Rx ← Rx - Ry                 | 10        |  
   | `JNZ`          | Jump to address if Rx ≠ 0    | 11        |  
   | **MULTIPLY**   | Rx ← Rx * Ry                 | Extended  |  

   The **MULTIPLY** operation uses a **shift-and-add** technique to minimize hardware complexity.

3. **Arithmetic Logic Unit (ALU):**  
   - Performs **addition**, **subtraction**, and **multiplication**.  
   - Outputs a 7-bit result and generates status flags (e.g., Zero flag).

4. **Memory:**  
   - ROM-based storage for instructions and program data.  
   - Binary instruction loading is supported via an assembler.

5. **Control Unit:**  
   - Implements an **ASM (Algorithmic State Machine)**-based state machine.  
   - Decodes instructions and generates control signals.  

6. **Register File:**  
   - Four general-purpose registers (`R0` to `R3`) for intermediate data storage.  
   - Zero flag (`ZR`) detection for conditional operations.  

7. **Multiplexers:**  
   - Used to route data efficiently between memory, ALU, and registers.

---

## **Project Components**  

1. **ALU (Arithmetic Logic Unit):**  
   - Handles arithmetic operations (`ADD`, `SUB`, `MULTIPLY`) based on control signals.  
   - Outputs the 7-bit result along with the zero flag.  

2. **Registers (Reg.vhd):**  
   - Four 7-bit registers to store and transfer data.  
   - Implements zero flag detection.  

3. **Program Counter (PC.vhd):**  
   - Sequentially increments the address to fetch instructions.  

4. **Instruction Register (IR.vhd):**  
   - Temporarily holds fetched instructions for decoding.  

5. **Memory (Memory.vhd):**  
   - ROM-based binary instruction storage.  

6. **Control Unit (control_unit.vhd):**  
   - Generates control signals for all components based on the current instruction.  

7. **Multiplexers (MUX2x1, MUX4x1):**  
   - Control input and output routing across the processor components.  

---

## **Python Assembler**  
The project includes a Python-based assembler (`Conversion.py`) to convert assembly instructions into binary format.  
Example usage:  

```python
Input: ADD R1, R2  
Output: 0100010
```

The assembler supports all implemented instructions and ensures compatibility with the processor's ROM memory.

---

## **Educational Aspects**  

This project provides practical understanding of the following areas:  
1. **Processor Design Principles:**  
   - Modular design of processor components.  
   - Instruction execution pipeline: Fetch, Decode, and Execute.  

2. **Algorithmic State Machine (ASM):**  
   - Designing the control unit using ASM charts to define states and transitions.  

3. **Shift-and-Add Multiplication:**  
   - Efficient implementation of multiplication using minimal hardware resources.  

4. **Hardware-Software Integration:**  
   - Integration of assembly code (converted using Python) with VHDL-based hardware components.

5. **VHDL Design and Simulation:**  
   - Writing and testing modular VHDL code for processor components.  

---

## **How to Run the Project**  

1. **VHDL Simulation:**  
   - Load the provided VHDL files into a simulator (e.g., ModelSim, Vivado).  
   - Compile and simulate individual processor components and the full system.  

2. **Assembly Code Conversion:**  
   - Use the Python `Conversion.py` script to convert assembly instructions into binary code.  
   - Example:  
     ```python
     python Conversion.py  
     Input: ADD R1, R2  
     Output: 0100010
     ```  

3. **Load Binary Instructions into Memory:**  
   - Update the `Memory.vhd` file with the generated binary instructions.  

4. **Verify Results:**  
   - Monitor the ALU output, register values, and program counter progression during simulation.  

---

## **Conclusion**  

This project demonstrates the design and implementation of a **7-bit processor** with a functional instruction set and efficient arithmetic capabilities. It serves as a foundational resource for understanding processor design, VHDL development, and hardware-software co-design principles.

---
