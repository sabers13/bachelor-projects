
# **Compiler Design Project**  
### **Educational Lexical Analyzer and Parser with JFlex and CUP**

This project is an **educational implementation** of a compiler's front-end, focusing on **Lexical Analysis** and **Parsing** techniques. Using **JFlex** for tokenization and **CUP** for syntax analysis, the project provides a hands-on approach to understanding compiler components and how programming languages are processed.

---

## **Project Goals**

This project was developed to demonstrate and practice key concepts in compiler design:

1. **Lexical Analysis**: Tokenizing source code into meaningful symbols.  
2. **Parsing**: Building a syntax tree and validating code structure against defined grammar rules.  
3. **Educational Objectives**:
   - Recognize **class names** and print them.
   - Parse and print detailed **function definitions**, including return types, names, and parameters.
   - Identify **variable declarations**, their types, and initial values.
   - Detect and analyze **conditional statements** (`if`, `else if`, `else`) and loops (`for`, `while`).
   - Analyze **function calls** for argument validation.

---

## **Techniques Used**

1. **JFlex for Lexical Analysis**:  
   - **Tokenization**: Custom rules in `java.flex` tokenize the source code into identifiers, keywords, literals, and operators.  
   - This step ensures input code is broken into meaningful units, such as:
     - Keywords: `class`, `void`, `if`, `for`, `while`, etc.
     - Identifiers: Variable names, function names.
     - Literals: Numbers, strings, etc.  

2. **CUP for Parsing**:  
   - **Syntax Analysis**: Grammar rules defined in `java12.cup` build a parse tree to validate code structure.  
   - This includes:  
     - Class and function declarations.  
     - Conditional and looping constructs.  
     - Correct syntax for variable assignments and function calls.  

3. **Grammar Development**:  
   - Customized grammar rules ensure proper recognition of programming constructs.  
   - Techniques include **recursive parsing** and **operator precedence** handling.

4. **Output and Educational Logging**:  
   - At each significant parsing step, outputs are logged for educational purposes:
     - **Classes**: Print class names.  
     - **Functions**: Print return types, names, and parameters.  
     - **Conditionals**: Log `if`, `else if`, and `else` branches.  
     - **Loops**: Print loop details (e.g., `for` and `while` loops).  
     - **Variables**: Log type, name, and values.  

---

## **Why This Project?**

This project is designed for **students and learners** who want to:  

- Understand how a **compiler's front-end** works.  
- Learn how to write custom rules for **lexical analysis** and **parsing**.  
- Gain hands-on experience with **JFlex** and **CUP** tools.  
- Analyze code systematically and build grammar-based syntax validation.  

---

## **Code Sample**

Here’s an example of the code that the compiler can analyze and parse:

```java
class MyClass begin
   int int_var;
   int int_var2 = 10;

   void some_function(int x, float y, double z) begin
   end

   void free_function(int a1, int a2) begin
   end

   void main() begin
      float float_var = 10.0f;
      int j = 20 + 2 * 3 - 10 + 15 / 5; // = 19

      free_function(5, 10);

      for(int i = 0; i < 10; i++)
         free_function(10, j);

      while(i < 10) begin
         print("Hello world!");
         i++;
      end

      if(i < 5) begin
         print("If!");
      end
      else if(j < 5)
         print("Else if!");
      else begin
         print("Else!");
      end
   end
end
```

---

## **How It Works**

1. **Tokenization (JFlex)**:  
   - Source code is scanned and divided into tokens using the rules defined in `java.flex`.  

2. **Parsing (CUP)**:  
   - Tokens are validated against the grammar rules in `java12.cup`.  
   - Errors are reported if the code does not adhere to the defined syntax.  

3. **Logging Outputs**:  
   - During parsing, educational logs are generated at each major code element:
     - Class definitions.  
     - Function declarations and calls.  
     - Variable assignments.  
     - Conditional and loop structures.  

---

## **Project Setup**

To run the project, follow these steps:

1. Install **JFlex** and **CUP** tools.  
2. Place the customized files:
   - `java.flex` for token definitions.  
   - `java12.cup` for grammar and parser rules.  

3. Compile and execute:  

```bash
# Generate lexical analyzer
jflex java.flex  

# Generate parser
java -jar java12.cup java12.cup  

# Compile all generated Java files
javac *.java  

# Run the program
java MainClass
```

---

## **Educational Outputs**

The compiler logs educational outputs at various steps, helping learners understand the structure of the input program. For example:  

- **Class**: `MyClass`  
- **Variable Declaration**: `int int_var = 10`  
- **Function**: `void some_function(int x, float y, double z)`  
- **Conditional**:  
   - `Conditional: if`  
   - `Conditional: else if`  
   - `Conditional: else`  
- **Loop**: `for` loop detected with range and increment.  

---

## **Key Learnings**

Through this project, you will:  

1. Learn to develop a **Lexical Analyzer** using JFlex.  
2. Understand how to build and apply **grammar rules** with CUP.  
3. Implement parsing for key programming constructs.  
4. See the connection between **tokens**, **parse trees**, and **structured outputs**.  
5. Practice compiler design principles in a real-world educational context.

---

## **Future Enhancements**

- Add **error recovery** mechanisms for syntax errors.  
- Integrate a **symbol table** for semantic analysis.  
- Enhance support for **nested functions** and **complex expressions**.  
