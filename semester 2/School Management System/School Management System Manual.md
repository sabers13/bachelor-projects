# School Management System Manual

## 1. Project Overview

The School Management System is a Java-based application designed to manage various aspects of a school, including user authentication, role-specific operations, and school-wide data handling. It leverages file-based storage for user and role management, making it lightweight and easy to use.

---

## 2. System Features

- **User Authentication**: Supports sign-in and sign-up functionalities for students, teachers, and managers.
- **Role-Based Access**: Provides different capabilities based on user roles (student, teacher, manager).
- **File-Based Storage**: Reads and writes user data to text files for simplicity.
- **Data Management**: Handles user information, classes, scores, and account balances.
- **Interactive Menu**: Guides users through intuitive text-based menus.

---

## 3. File Descriptions

### `Class.java`

A placeholder for managing class-related logic. Currently, it does not include any functionality but can be extended to handle class scheduling or related operations.

### `main.java`

The entry point of the application. It:
- Initializes the system with a welcome menu.
- Handles sign-in and sign-up flows for students, teachers, and managers.
- Validates usernames and passwords.
- Provides a menu-driven interface for navigating the application.

### `manager.java`

Manages data for managers, including:
- Reading manager details from `manager.txt`.
- Validating usernames and passwords.
- Extracting and storing manager-specific data such as names, IDs, and account information.

### `school.java`

A placeholder for school-wide operations. Can be extended to include functionalities like reporting or school-wide announcements.

### `student.java`

Manages student-specific data:
- Reads student details from `student.txt`.
- Validates student usernames and passwords.
- Tracks classes, scores, account balances, and personal information.

### `study.java`

Manages study-related data:
- Stores a list of available subjects (e.g., Biology, Math, Chemistry).
- Writes study-related data to a file for later use.

### `teacher.java`

Handles teacher-specific data:
- Reads teacher details from `teacher.txt`.
- Validates teacher usernames and passwords.
- Tracks classes, scores, and account balances.

### `user.java`

A placeholder for common user functionalities. Can be used as a base class for implementing shared logic across students, teachers, and managers.

---

## 4. Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE.

### Steps

1. **Clone the Repository**: Download or clone the project from the GitHub repository.
2. **Open the Project**:
   - Import the `.java` files into your Java IDE.
3. **Prepare Data Files**:
   - Ensure `manager.txt`, `student.txt`, and `teacher.txt` are available in the project directory with appropriate data.
4. **Compile the Code**:
   - Compile all `.java` files.
5. **Run the Application**:
   - Execute the `main.java` file to start the application.

---

## 5. Usage Instructions

### Starting the System
1. Run the application.
2. Choose an option from the main menu (e.g., sign in or sign up).

### Role-Specific Actions
- **Students**:
  - Sign in using a valid username and password.
  - View personal information, classes, and scores.
  - Manage account balance.
- **Teachers**:
  - Sign in using a valid username and password.
  - Manage assigned classes and students.
  - Update class scores and personal information.
- **Managers**:
  - Sign in using a valid username and password.
  - Oversee teacher and student data.
  - Manage school-wide operations.

---

## 6. Additional Notes

### Common Issues

- **File Not Found**: Ensure that all required text files (`manager.txt`, `student.txt`, `teacher.txt`) are present in the correct directory.
- **Invalid Input**: Validate user inputs for usernames, passwords, and menu options.

### Future Enhancements

- Add a graphical user interface (GUI) for improved usability.
- Implement a database for robust data storage.
- Include detailed reporting and analytics features.
- Add notification and messaging capabilities for better communication.

---

This document provides a comprehensive guide to understanding and using the School Management System. For further assistance, refer to the source code or contact the developer.

