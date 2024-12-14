# Product List Management System Manual

## 1. Project Overview

The Product List Management System is a Java-based application designed to process and display categorized product data. It reads input from text files, validates data formats, and generates organized outputs. The system is primarily aimed at managing product inventories with associated categories and prices.

---

## 2. System Features

- **File-Based Input**: Reads product and category data from text files.
- **Data Validation**: Ensures the integrity and format of input data.
- **Organized Output**: Displays products in a structured tabular format.
- **Category Association**: Maps products to their respective categories.

---

## 3. File Descriptions

### `Main.java`

The core logic of the application, which:

- Reads and validates category data from `categories.txt`.
- Reads and validates product data from `products.txt`.
- Organizes and displays validated product information in a tabular format.
- Generates a summary output file (`output.txt`).

---

## 4. Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE.

### Steps

1. **Clone the Repository**: Download or clone the project from the GitHub repository.
2. **Prepare Data Files**:
   - Ensure `categories.txt` and `products.txt` are available in the specified directory.
   - `categories.txt` format:
     - Each line should contain a category code (3 digits) followed by a category name (max 25 characters).
   - `products.txt` format:
     - Each line should include product details in the format: `CategoryCodes & ProductName & ID # Price $`.
3. **Open the Project**:
   - Import the `.java` files into your Java IDE.
4. **Compile the Code**:
   - Compile `Main.java`.
5. **Run the Application**:
   - Execute the `main` method in `Main.java`.

---

## 5. Usage Instructions

### Starting the System
1. Run the application.
2. The program will:
   - Read and validate categories from `categories.txt`.
   - Read, validate, and display products from `products.txt`.

### Output Structure
- Products are displayed in a table with columns for:
  - **Product Name**: Center-aligned with a maximum length of 25 characters.
  - **ID**: Displayed in a fixed format.
  - **Price**: Displayed with a `$` sign.
  - **Categories**: Comma-separated list of associated categories.

### Generated Output File
- The program creates an `output.txt` file summarizing the validated data.

---

## 6. Additional Notes

### Common Issues

- **File Not Found**: Ensure `categories.txt` and `products.txt` are present in the correct directory.
- **Invalid Data**: Verify that input data conforms to the required formats.

### Future Enhancements

- Add a graphical user interface (GUI) for better usability.
- Implement database integration for large-scale data management.
- Include detailed error reporting for invalid data entries.

---

This document provides a comprehensive guide to understanding and using the Product List Management System. For further assistance, refer to the source code or contact the developer.

