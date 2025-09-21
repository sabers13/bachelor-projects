
# Library Management System

## Overview
This project is a Library Management System built with **Python (Tkinter)** and **Microsoft SQL Server** to demonstrate database design, implementation, and integration with a Python-based application. The system focuses on core database techniques, including schema design, relational integrity, and CRUD operations, while incorporating essential educational aspects of application development.

## Features
- **User Management**: Account creation, login, and profile management for both users and administrators.
- **Book Management**: Adding, borrowing, returning, and listing books.
- **Admin Panel**: Tools for managing users, books, and library operations.
- **Subscription System**: Manage user subscriptions with varying durations.
- **Error Handling**: Robust error detection and handling mechanisms in both database operations and application logic.


## 🚀 What this project demonstrates

**Relational Database Design**
- Star/normalized schema across `publisher`, `book`, `category`, `member`, `user_tbl`, `transactions`
- **Foreign keys**, **cascading rules**, and **indexes** for integrity and performance
- Batch-safe SQL file execution and idempotent creation logic

**Python Back‑End**
- Modular codebase (`utils.py`, `table_creation.py`, panels & flows)
- **ODBC** access with `pyodbc`, parameterized queries to prevent SQL injection
- Robust commit/rollback patterns; safe handling of batch separators (`GO`) in runner

**Authentication & Security**
- Role‑based access (**Admin/User**)
- MD5 hashing (project requirement) with consistent hex representation across app & DB
- Basic input validation and error reporting

**Desktop UI / UX**
- Tkinter GUI: login, admin panel, user panel, account creation, password reset
- Asset pipeline for icons/images (`./assets`)
- Usability details (placeholders, role selection, feedback dialogs)

**DevOps & Environment**
- 64‑bit DSN configuration for SQL Server (**ODBC Driver 17**)
- Repeatable setup scripts (`table_creation.py`, `run_sql_folder.py`)
- Local developer ergonomics (encryption flags for Driver 17 in dev)


- Designed and implemented a multi‑table relational schema with FKs, indexes, and integrity constraints in **MS SQL Server**.
- Built a **Python/Tkinter** desktop app with role‑based auth (Admin/User) and secure, parameterized DB access via **pyodbc**.
- Automated environment setup with DSN configuration, idempotent table creation, and **batch‑safe SQL execution** (**GO** splitter).
- Implemented consistent password hashing & verification across Python and SQL (MD5 hex for course spec).
- Delivered a usable CRUD interface for library operations (add/borrow/return) with clear UX feedback.
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


## ✅ Quick Start

### 0) Prerequisites
- **Windows 64-bit**, **Python 3.10+**
- **Microsoft SQL Server** (Express/Developer) + **SSMS**
- **ODBC Driver 17 for SQL Server (64-bit)**

### 1) Create & activate venv
```bat
cd "bachelor-projects\semester 7\Library Management System"
python -m venv .venv
.venv\Scripts\activate
pip install --upgrade pip
pip install pyodbc
```

### 2) Create a System DSN (must match `utils.py`)
- Open **ODBC Data Sources (64-bit)** → **System DSN** → **Add…** → **ODBC Driver 17 for SQL Server**
- **Name:** `SQL-ODBC`
- **Server:** one that works in SSMS (e.g., `localhost`, `localhost\SQLEXPRESS`, or `127.0.0.1,1433`)
- **Auth:** Windows (Integrated) *or* SQL Login
- **Default DB:** `master` (you can change to `LibraryDB` after creation)
- **Encryption (local dev):** set **Encrypt = No**, or **Encrypt = Yes** + **Trust server certificate = Yes**
- **Test** and save

### 3) Create the database
In **SSMS**:
```sql
IF DB_ID('LibraryDB') IS NULL
    CREATE DATABASE LibraryDB;
GO
```
> Optional: update your DSN default DB to `LibraryDB`.

### 4) Initialize schema
```bat
python table_creation.py        :: base tables/indexes/constraints/admin (idempotent if scripted)
python run_sql_folder.py        :: executes 1→6 .sql files, GO-safe
```

### 5) Run the app (entry point)
```bat
python login.py
```
- Enter **username** and **password**, and choose the correct **Role** (Admin/User).  
- Images are loaded from `./assets` — keep that folder next to `login.py`.

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
