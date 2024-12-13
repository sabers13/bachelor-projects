
# Restaurant Management System Manual

## 1. Project Overview

The Restaurant Management System is designed to streamline the operations of a restaurant by providing user and manager functionalities. The system facilitates tasks such as managing menus, handling orders, and authenticating users and managers.

This project consists of 14 Java files, each playing a distinct role in achieving the system's objectives. It is built using Java Swing for the graphical user interface and a relational database for data storage. The project uses SQLite as its database and requires the following libraries:
- `AbsoluteLayout.jar`
- `sqlite-jdbc-3.34.0.jar`

The system is designed to run in NetBeans IDE.

---

## 2. System Features

- **User Authentication**: Sign-in and sign-up functionalities for both users and managers.
- **Menu Management**: Create, edit, and view menus for restaurants.
- **Order Management**: Submit and track orders.
- **Restaurant Display**: List restaurants with their respective menus.

---

## 3. File Descriptions

### `createMenu.java`

Responsible for creating new menu items for restaurants. Includes functionalities to save data to the database and display menus in a tabular format.

### `database.java`

Handles all database connections and queries. Provides methods for connecting to the database and executing SQL commands. **Note**: Run this file first to set up the server and establish the SQLite database connection.

### `editMenu.java`

Allows managers to update existing menu items. Features include loading menus into editable forms and saving changes back to the database.

### `firstMenu.java`

The entry point for the graphical user interface. Provides options to navigate to user or manager functionalities.

### `listOfRest.java`

Displays a list of available restaurants. Allows users to view details about a selected restaurant.

### `managerMenu.java`

Provides the main menu for managers. Includes options for managing restaurants, viewing orders, and editing menus.

### `managerPanel.java`

A dashboard for managers, showing key metrics and providing shortcuts to frequently used features.

### `managerSignIn.java` and `managerSignUp.java`

Handle manager authentication. Provide forms for signing in and registering new manager accounts.

### `menuOfRestaurant.java`

Displays the menu of a selected restaurant. Includes functionality for users to place orders.

### `Resturant_sys.java`

The main entry point of the system. Initializes the application and loads the first menu. **Note**: Run this file after `database.java` to launch the client application.

### `submitedOrders.java`

Displays orders submitted by users. Managers can view and manage these orders.

### `userSignIn.java` and `userSignUp.java`

Handle user authentication. Provide forms for signing in and registering new user accounts.

---

## 4. Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Database**: SQLite.
- **Required Libraries**:
  - `AbsoluteLayout.jar`
  - `sqlite-jdbc-3.34.0.jar`
- **IDE**: NetBeans (preferred).

### Steps

1. **Clone the Repository**: Download or clone the project from the GitHub repository.
2. **Database Setup**:
   - Ensure `sqlite-jdbc-3.34.0.jar` is added to the project libraries.
   - Run `database.java` in NetBeans to initialize the SQLite database.
3. **Compile the Code**:
   - Use NetBeans to build the project. Ensure all dependencies are correctly linked.
4. **Run the Application**:
   - Run `Resturant_sys.java` in NetBeans to launch the client application.

---

## 5. Usage Instructions

### User Instructions

- **Sign Up**: Open the application and navigate to the user sign-up form. Fill in the required details and register.
- **Sign In**: Use the sign-in form to log in.
- **View Restaurants**: Browse the list of available restaurants and their menus.
- **Place Orders**: Select menu items and place orders.

### Manager Instructions

- **Sign Up**: Register as a manager through the sign-up form.
- **Sign In**: Log in using your credentials.
- **Manage Menus**: Use the menu management tools to create or edit menus.
- **View Orders**: Check submitted orders and update their statuses as needed.

---

## 6. Additional Notes

### Common Issues

- **Database Connection Errors**: Ensure `sqlite-jdbc-3.34.0.jar` is correctly linked and the database is initialized by running `database.java`.
- **UI Scaling**: Use a compatible screen resolution to ensure the UI elements display correctly.

### Future Extensions

- Add more advanced features like analytics for managers.
- Implement an online ordering feature for users.

---

This document serves as a guide for understanding and using the Restaurant Management System. For further assistance, refer to the source code or contact the developer.
