
**Project Name**: Special Sum Calculator

**Description**:
This program calculates a special alternating sum derived from the digits of a given integer. Each digit's contribution to the sum alternates between positive and negative powers, determined by its position.

**Key Features**:

- Reads an integer input.
- Extracts digits using modulo and division operations.
- Alternates signs and computes powers of each digit.
- Outputs the final calculated sum.

**Techniques Used**:

- Iterative power calculation without using built-in libraries.
- Modulo and division operations for digit extraction.
- Alternating signs using a multiplier variable.

**Example Input and Output**:

- Input: `123`
- Output: `6` (calculated as 1^0 - 2^1 + 3^2)

**Educational Purpose**:
Demonstrates fundamental iterative and arithmetic operations in Java. Useful for understanding digit-based computations and power functions.

---


**Project Name**: Homework Priority Scheduler

**Description**:
This program prioritizes homework assignments based on their scores and deadlines, aiming to maximize total score within a fixed time frame.

**Key Features**:

- Reads a list of homework assignments with titles, deadlines, and scores.
- Implements a greedy algorithm to schedule homework.
- Outputs a prioritized list of homework titles.

**Techniques Used**:

- Custom sorting using a comparator for descending score order.
- Array-based scheduling with boolean flags for time slot availability.
- Iterative decision-making to maximize score.

**Example Input and Output**:

- Input:
  ```
  3
  Math 2 50
  English 1 40
  Science 2 60
  ```
- Output: `Science, Math`

**Educational Purpose**:
Demonstrates the greedy approach to optimization problems and showcases basic data structures like arrays and ArrayLists.

---


**Project Name**: State Transition Counter

**Description**:
This program counts the number of state changes in a sequence of integer inputs.

**Key Features**:

- Reads a sequence of integers.
- Compares consecutive integers to detect state changes.
- Outputs the total count of transitions.

**Techniques Used**:

- Sequential input processing.
- Conditional logic to identify changes between consecutive elements.
- Efficient iteration through input data.

**Example Input and Output**:

- Input:
  ```
  5
  1 1 2 1 2
  ```
- Output: `3`

**Educational Purpose**:
Illustrates simple algorithms for detecting and counting changes in data streams.

---


**Project Name**: Hands-Free Compatibility Checker

**Description**:
This program checks compatibility between two hands-free devices based on specific character criteria.

**Key Features**:

- Reads input strings representing device attributes.
- Extracts specific characters for comparison.
- Determines compatibility based on character equality.

**Techniques Used**:

- Character array manipulation.
- Logical comparisons to check conditions.
- Simplified input parsing and validation.

**Example Input and Output**:

- Input:
  ```
  1X
  2X
  ```
- Output: `YES`

**Educational Purpose**:
Introduces basic string manipulation and logical condition checking in Java.

---


**Project Name**: Unique Character Counter

**Description**:
This program finds the maximum number of unique characters in names provided as input.

**Key Features**:

- Reads a list of names.
- Calculates the number of unique characters in each name.
- Outputs the maximum count among all names.

**Techniques Used**:

- Nested loops for character comparison.
- Logical flags to avoid counting duplicates.
- Iterative updates to find the maximum count.

**Example Input and Output**:

- Input:
  ```
  3
  Anna
  Bob
  Charlie
  ```
- Output: `7` (from "Charlie")

**Educational Purpose**:
Teaches nested loop structures and logical operations for data analysis.

---


**Project Name**: Pythagorean Triplet Finder

**Description**:
This program identifies a Pythagorean triplet (a, b, c) where the sum of the triplet equals a given number.

**Key Features**:

- Reads an integer input.
- Iteratively generates candidate triplets.
- Validates the Pythagorean condition and sum equality.
- Outputs the triplet or declares it impossible.

**Techniques Used**:

- Nested loops for candidate generation.
- Mathematical condition checking for Pythagorean triplets.
- Optimization by limiting search ranges.

**Example Input and Output**:

- Input: `12`
- Output: `3 4 5`

**Educational Purpose**:
Explains the concept of Pythagorean triplets and demonstrates nested iteration and mathematical validation.
