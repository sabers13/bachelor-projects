
# Algorithm Design Course Projects

---

## **Introduction**

This repository contains a collection of individual projects created for the **Algorithm Design** course. Each project is focused on solving a unique computational problem while demonstrating algorithmic techniques such as **divide and conquer**, **dynamic programming**, and **greedy algorithms**. These implementations are designed to be both practical and educational, making them a great resource for understanding key principles of algorithm design.

---

## **Project Overview**

### **1. Largest Element Below Threshold (`largest_element_below_threshold.py`)**
- **Description**: This program identifies the largest number in a list that is strictly less than a given threshold.
- **Methods Used**:
  - **QuickSort**: Implements a recursive sorting algorithm to efficiently organize the elements in the list.
  - **Threshold Filtering**: Incorporates a condition to extract the largest number below the threshold.
- **Educational Value**:
  - Demonstrates **divide and conquer** for sorting large datasets.
  - Explains how to integrate problem-specific constraints into standard algorithms.
- **How to Run**:
  - Input: A space-separated list of integers followed by the threshold value.
  - Example:
    ```
    Input: 10 5 3 8 6 2
           6
    Output: 5
    ```

---

### **2. Count Reverse Pairs (`count_reverse_pairs.py`)**
- **Description**: Counts the number of reverse pairs in an array, where a reverse pair is defined as `arr[i] > 2 * arr[j]` for `i < j`.
- **Methods Used**:
  - **Merge Sort**: Enhances the merge step to efficiently count reverse pairs.
  - **Divide and Conquer**: Splits the problem into smaller parts for improved efficiency.
- **Educational Value**:
  - Combines sorting and counting to optimize performance.
  - Introduces the concept of solving computational geometry problems through array manipulation.
- **How to Run**:
  - Input: A list of integers in array format (e.g., `[1, 3, 2, 3, 1]`).
  - Output: The number of reverse pairs.
  - Example:
    ```
    Input: [1, 3, 2, 3, 1]
    Output: 2
    ```

---

### **3. Sum of Skipped Indices (`sum_of_skipped_indices.py`)**
- **Description**: Computes the sum of skipped indices during repeated sorting of array subsets.
- **Methods Used**:
  - **QuickSort**: Uses partitioning and recursive calls to sort the subsets.
  - **Index Tracking**: Keeps a count of skipped indices during the sorting process.
- **Educational Value**:
  - Demonstrates the internal mechanics of **QuickSort**.
  - Provides insights into how array modifications affect indices.
- **How to Run**:
  - Input: A space-separated list of integers.
  - Output: The sum of skipped indices.
  - Example:
    ```
    Input: 10 5 3 8 6 2
    Output: <sum>
    ```

---

### **4. Fibonacci Sequence for Mountain Climbing (`fibonacci_mountain_climbing.py`)**
- **Description**: Calculates the `n`th Fibonacci number using a dynamic programming approach.
- **Methods Used**:
  - **Iterative Approach**: Avoids recursion by storing intermediate results in an array.
  - **Dynamic Programming**: Utilizes previously computed values to reduce redundant calculations.
- **Educational Value**:
  - Explains the importance of avoiding redundant computations in recursive algorithms.
  - Provides an efficient alternative to recursive Fibonacci computation.
- **How to Run**:
  - Input: An integer `n`.
  - Output: The `n`th Fibonacci number.
  - Example:
    ```
    Input: 5
    Output: 5
    ```

---

### **5. Minimum Cost for Chopping Trees (`minimum_tree_chopping_cost.py`)**
- **Description**: Calculates the minimum cost of chopping trees by finding an optimal path through a 2D cost grid.
- **Methods Used**:
  - **Dynamic Programming**: Uses cumulative cost tables to determine the cheapest route.
  - **Grid Manipulation**: Handles 2D arrays effectively to perform grid-based calculations.
- **Educational Value**:
  - Introduces **grid-based problems** and their solutions.
  - Explains how to build and use a **cost matrix** for dynamic programming solutions.
- **How to Run**:
  - Input: An integer `n` (grid size) followed by a flat list of costs.
  - Output: The minimum cost to traverse the grid.
  - Example:
    ```
    Input: 3
           1 2 3 4 5 6 7 8 9
    Output: 21
    ```

---

### **6. Longest Palindromic Substring (`longest_palindromic_substring.py`)**
- **Description**: Identifies the length of the longest palindromic substring in a given string.
- **Methods Used**:
  - **Manacher's Algorithm**: A linear-time algorithm for finding palindromic substrings.
  - **String Transformation**: Adds delimiters between characters to handle even/odd length palindromes uniformly.
- **Educational Value**:
  - Demonstrates how preprocessing can simplify complex string problems.
  - Introduces an advanced algorithm with linear complexity.
- **How to Run**:
  - Input: A string `s`.
  - Output: The length of the longest palindromic substring.
  - Example:
    ```
    Input: "babad"
    Output: 3
    ```

---

## **Educational Objectives**
This repository highlights:
- Core algorithmic techniques such as **divide and conquer**, **dynamic programming**, and **greedy algorithms**.
- Practical applications of sorting, searching, and optimization problems.
- Implementation of efficient algorithms for real-world use cases.

---

## **Getting Started**
1. Clone this repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project of interest:
   ```bash
   cd <project-folder>
   ```
3. Run the file with the required input:
   ```bash
   python <file_name.py>
   ```

---

## **Future Improvements**
- Extend the projects to explore alternative algorithmic approaches.
- Add visualization for some problems (e.g., grid traversal in "Minimum Cost for Chopping Trees").
- Optimize existing solutions for larger datasets.

Feel free to explore and adapt these projects for your learning or use them as references for implementing algorithms!
