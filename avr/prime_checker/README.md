# prime_checker

Simple **prime number checker** written in C.  
The program reads an integer from standard input and prints whether it is a prime number, using trial division up to the square root of the input.

---

## Overview

- Language: C  
- Target: generic C environment or AVR toolchain with standard I/O enabled  
- Algorithm: trial division with an upper bound of `sqrt(n)`  
- Libraries: `<math.h>`, `<stdio.h>` (and `<mega16.h>`, `<delay.h>` for AVR projects)

The implementation demonstrates basic control flow, user input handling, and the concept of prime numbers.

---

## How It Works

1. Reads an integer `n` from input using `scanf`.
2. Initializes a flag variable `flag = 1`, assuming `n` is prime.
3. Handles non-prime edge cases:
   - If `n <= 1`, `flag` is set to `0`.
4. For `n > 1`, iterates `i` from `2` up to `sqrt(n)`:
   - If `n % i == 0` for any `i` in this range, `flag` is set to `0` and the loop terminates early.
5. At the end:
   - If `flag == 1`, prints "`n` is a prime number".
   - Otherwise, prints "`n` is not a prime number".

This reduces the number of divisions needed compared to checking all numbers up to `n - 1`.

---

## Files

```text
firmware/
  prime_checker.c        # Main C source file (renamed from cv5.c)
  prime_checker.cproj    # C project file (renamed from cv5.cproj)
  prime_checker.atsln    # Solution file (renamed from cv5.atsln)

simulation/
  hex.pdsprj             # Optional Proteus project (if used in the original assignment)
```

The core logic resides in `prime_checker.c`.

---

## Example

Input:

```text
Enter a number:
7
```

Output:

```text
7 is a prime number
```

Another example:

```text
Enter a number:
12
```

Output:

```text
12 is not a prime number
```

---

## Notes

- For embedded/AVR use, console I/O (`printf`, `scanf`) relies on the project’s runtime configuration (e.g., UART redirection); behavior depends on the chosen toolchain.
- For desktop use, the code can be compiled with any standard C compiler that supports `<math.h>` and `<stdio.h>`.
