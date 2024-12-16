opcode_table = {
    "Load": "00",
    "ADD": "01",
    "SUB": "10",
    "JNZ": "11"
}


def assemble(assembly_code):
    binary_code = []
    for line in assembly_code.split('\n'):
        parts = line.replace(",", "").split()  # Split tokens and add to list
        # print(parts)
        if parts:  # Check if not empty
            opcode = opcode_table.get(parts[0])  # First element is opcode
            if opcode:  # Check if not empty
                binary_line = opcode
                for part in parts[1:]:
                    if part.startswith('R'):
                        binary_line += format(int(part[1:]), '02b')  # Convert register to 2-bit binary
                    else:
                        binary_line += format(int(part), '04b')  # Convert value to 4-bit binary
                # First element is opcode + Convert Second element to the end
                binary_code.append(binary_line)
    return binary_code


if __name__ == "__main__":
    for code in ["ADD R1, R2", "Load R3", "SUB R3, R1"]:
        print("Assembly code: " + code)
        print("Binary code: " + "".join(assemble(code)))  # List to string
