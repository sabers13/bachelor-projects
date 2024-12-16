
# Library Management System

## Overview
This project is a Library Management System developed as part of a database course to demonstrate database design, implementation, and integration with a Python-based application. The system focuses on core database techniques, including schema design, relational integrity, and CRUD operations, while incorporating essential educational aspects of application development.

## Features
- **User Management**: Account creation, login, and profile management for both users and administrators.
- **Book Management**: Adding, borrowing, returning, and listing books.
- **Admin Panel**: Tools for managing users, books, and library operations.
- **Subscription System**: Manage user subscriptions with varying durations.
- **Error Handling**: Robust error detection and handling mechanisms in both database operations and application logic.

## Technical Details
### Database
The database schema is defined through SQL scripts:
1. **Publisher Table (`1-publisher.sql`)**: Maintains publisher details.
2. **Book Table (`2-book.sql`)**: Stores information about books.
3. **Category Table (`3-category.sql`)**: Categorizes books for easy retrieval.
4. **Member Table (`4-member.sql`)**: Tracks library members.
5. **User Table (`5-user_tbl.sql`)**: Manages user account details.
6. **Transactions Table (`6-transactions.sql`)**: Logs borrowing and returning activities.

Key techniques demonstrated:
- Schema design and normalization.
- Referential integrity with foreign keys.
- Efficient indexing for query performance.

### Application
The application is built using Python, with modular scripts for various functionalities:
- **Authentication**: `login.py`, `create_account.py`, `forgetpassword.py`
- **Book Operations**: `addbook.py`, `borrowBook.py`, `bookReturn.py`
- **User Management**: `user_profile.py`, `admin_profile.py`
- **Admin Panel**: `admin_panel.py`, `suspendedUsers.py`
- **Utilities**: `utils.py` for shared functionality and `table_creation.py` for automated database setup.

Key concepts demonstrated:
- Modular programming and code reuse.
- Integration with SQL databases using Python.
- Secure authentication practices.

### Frontend
The project includes image assets (`assets/`) for a graphical user interface, enhancing usability and aesthetics.

## Educational Aspects
This project emphasizes:
1. **Database Principles**:
   - Relational database design.
   - Query optimization techniques.
   - CRUD operations and transaction management.

2. **Programming Practices**:
   - Writing modular and maintainable code.
   - Implementing error handling and input validation.

3. **Full-Stack Integration**:
   - Bridging backend databases with a functional Python-based frontend.

## Setup Instructions
1. **Database Setup**:
   - Execute the SQL scripts (`1-publisher.sql` to `6-transactions.sql`) to create the necessary schema.
2. **Python Environment**:
   - Install required libraries: `pip install -r requirements.txt` (if a `requirements.txt` file is available).
   - Run `table_creation.py` to initialize the database.
3. **Application**:
   - Launch `admin_panel.py` or `user_panel.py` depending on the role.

## Usage
- Admins can log in to manage library resources and user accounts.
- Users can log in to borrow, return, and explore books.
- The subscription system allows users to choose and manage their memberships.

## Future Enhancements
- **Search Functionality**: Implementing advanced search and filtering for books.
- **Analytics Dashboard**: Adding a panel for usage statistics and insights.
- **Web-Based Interface**: Transitioning to a web-based frontend for broader accessibility.

## Conclusion
This project is an educational showcase of database design and integration, combining theoretical knowledge with practical application. It is an excellent starting point for exploring advanced database-driven application development.
