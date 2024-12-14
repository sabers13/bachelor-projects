
### README: Store Management System

**Project Name**: Store Management System

**Description**:
This project is a store management application developed using Java and SQLite, designed to handle various store-related operations such as user management, order processing, and product inventory. It is built in NetBeans and integrates a GUI for user interaction. This project is specifically designed to practice object-oriented programming (OOP) concepts.

**Key Features**:

- **User Management**:

  - Sign-up and sign-in functionalities for customers, managers, and manufacturers.
  - Distinct panels for different user roles (e.g., customer, manager, manufacturer).

- **Product Management**:

  - List and view available products.
  - Manage inventory through the manager and manufacturer interfaces.

- **Order Processing**:

  - Customers can place and view orders.
  - Managers can review and process submitted orders.

- **Database Integration**:

  - SQLite databases for storing user, product, and order information.
  - Separate databases for managing orders and inventory (e.g., `client.db`, `manager.db`, etc.).

**Tech Stack**:

- **Frontend**: Java Swing for the graphical user interface.
- **Backend**: Java for application logic and SQLite for persistent data storage.
- **Development Environment**: NetBeans IDE.

**Usage Instructions**:

1. **Setup**:

   - Ensure you have Java and NetBeans IDE installed on your system.
   - Open the project in NetBeans.

2. **Database Configuration**:

   - The SQLite database files are included in the project (`client.db`, `manager.db`, etc.).
   - Ensure the databases are accessible during runtime.

3. **Run the Application**:

   - Build and run the project from NetBeans.
   - Use the GUI to interact with the application as a user, manager, or manufacturer.

**Example Workflow**:

- A user signs up and logs into the application.
- The user browses the product list and places an order.
- The manager reviews submitted orders and updates their status.
- The manufacturer manages inventory and supplies products as needed.

**Project Structure**:

- `src/`: Contains all Java source files, including GUI components and backend logic.

  - **`Start.java`**: Entry point of the application, responsible for initializing the main GUI.
  - **`userSignIn.java`** and **`userSignUp.java`**: Handle user login and registration functionalities.
  - **`userPanel.java`**: Provides the main interface for users to browse products and place orders.
  - **`managerSignIn.java`** and **`managerPanel.java`**: Allow managers to log in, manage products, and review orders.
  - **`managerEditPanel.java`**: Enables managers to modify product details.
  - **`manufacturerSignIn.java`** and **`manufacturerPanel.java`**: Facilitate manufacturer login and inventory management.
  - **`listOfProducts.java`**: Displays available products in the store.
  - **`submitedOrders.java`**: Handles the display and management of submitted orders.
  - **`purchase.java`**: Manages the purchase process for customers.
  - **`database.java`**: Provides methods for interacting with SQLite databases, including CRUD operations.

- `nbproject/`: NetBeans-specific project configurations.

- `.db`: SQLite database files for storing application data.

**Educational Purpose**:
This project demonstrates how to:

- Apply object-oriented programming principles, such as encapsulation, inheritance, and polymorphism.
- Integrate SQLite databases with Java applications.
- Build GUI-based applications using Java Swing.
- Implement role-based access control in a software system.

**Future Enhancements**:

- Add advanced analytics for sales and inventory.
- Improve the GUI for better user experience.
- Implement cloud-based database storage for scalability.
