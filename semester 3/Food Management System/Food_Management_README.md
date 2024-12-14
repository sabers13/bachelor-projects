
### README: Food Management System

**Project Name**: Food Management System

**Description**:
This project is a food management application developed using Java and SQLite. It includes role-based functionalities for clients, chefs, cooks, and managers (bosses), allowing seamless management of orders, menus, and user data. This project serves as a practice for implementing object-oriented programming (OOP) principles and role-based access control in Java.

**Key Features**:

- **User Management**:
  - Clients can sign up, log in, and place orders.
  - Managers can manage employees and remove items from the menu.
  - Chefs can edit the menu and manage completed orders.
  - Cooks handle pending orders and update their status.

- **Order Management**:
  - Clients can view their order history and manage their wallet.
  - Real-time status updates for pending and completed orders.

- **Menu Management**:
  - Role-based editing of menu items (e.g., add, remove, or update food and drinks).

- **Database Integration**:
  - SQLite databases (`food.db`, `user.db`) for storing menu items and user information.
  - Modular database interactions through `database.java`.

**Tech Stack**:
- **Frontend**: Java Swing for GUI.
- **Backend**: Java for application logic and SQLite for database integration.
- **Development Environment**: NetBeans IDE.

**Usage Instructions**:
1. **Setup**:
   - Install Java and NetBeans IDE.
   - Open the project in NetBeans.

2. **Database Configuration**:
   - Ensure `food.db` and `user.db` are present and accessible during runtime.

3. **Run the Application**:
   - Build and run the project.
   - Use role-based login to access different functionalities.

**Example Workflow**:
- A client signs up and places an order.
- A chef updates the menu and marks orders as completed.
- A cook manages pending orders.
- A manager removes outdated menu items and manages employees.

**Project Structure**:
- `src/pack1/`: Core functionality and user role implementations.
  - **`user.java`**: Represents a generic user in the system.
  - **`userSignIn.java`** and **`userSignUp.java`**: Handle user authentication.
  - **`changePass.java`**: Provides password update functionality.
  - **`boss/bossPanel.java`**: Main interface for the manager role.
  - **`boss/employeesManagement.java`**: Allows the manager to oversee employees.
  - **`chef/chefPanel.java`**: Interface for chefs to edit menus and manage orders.
  - **`client/clientPanel.java`**: Main client interface for browsing menus and managing orders.
  - **`cook/cookPanel.java`**: Interface for cooks to view and update order statuses.

- `src/pack2/`: Food and drink-related logic.
  - **`food.java`**: Handles food-related data.
  - **`drink.java`**: Manages drink-related items.
  - **`meal.java`**: Represents a complete meal.

- `nbproject/`: NetBeans-specific project configurations.
- `.db`: SQLite database files for persistent data storage.

**Educational Purpose**:
This project demonstrates:
- Practical implementation of OOP concepts like inheritance, encapsulation, and modular design.
- Role-based access control in software systems.
- Integration of databases with Java applications.

**Future Enhancements**:
- Add notifications for real-time order updates.
- Enhance the GUI for better usability.
- Extend functionality to include delivery tracking and customer feedback.
