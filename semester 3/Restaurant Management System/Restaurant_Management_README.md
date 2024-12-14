
### README: Restaurant Management System

**Project Name**: Restaurant Management System

**Description**:
This project is a restaurant management application designed using Java and NetBeans. It focuses on role-based functionalities for assistants, chefs, and head chefs, enabling efficient kitchen and staff management. The application also includes salary calculations, user authentication, and database integration. It emphasizes object-oriented programming (OOP) concepts.

**Key Features**:

- **Role-Based Management**:
  - Assistants can manage basic tasks and support kitchen operations.
  - Chefs are responsible for preparing food and managing orders.
  - Head chefs oversee operations, manage assistants and chefs, and calculate salaries.

- **Salary Management**:
  - Salary calculation based on predefined roles and tasks.

- **User Authentication**:
  - Sign-up and sign-in functionality for secure access.

- **Database Integration**:
  - Manages persistent data for users and roles.

**Tech Stack**:
- **Frontend**: Java Swing for GUI.
- **Backend**: Java for application logic and SQLite for database operations.
- **Development Environment**: NetBeans IDE.

**Usage Instructions**:
1. **Setup**:
   - Install Java and NetBeans IDE.
   - Open the project in NetBeans.

2. **Database Configuration**:
   - Ensure the SQLite database is accessible during runtime.

3. **Run the Application**:
   - Build and run the project.
   - Use role-based login to access specific functionalities.

**Example Workflow**:
- An assistant logs in and manages basic tasks.
- A chef logs in, views orders, and updates their status.
- The head chef logs in to oversee operations, manage staff, and calculate salaries.

**Project Structure**:
- `src/`: Contains all Java source files.
  - **`Start.java`**: Entry point of the application, initializing the main GUI.
  - **`userSignIn.java`** and **`userSignUp.java`**: Handle user authentication.
  - **`assistant.java`**, **`chef.java`**, and **`headChef.java`**: Implement role-specific logic and operations.
  - **`assistantPanel.java`**, **`chefPanel.java`**, and **`headChefPanel.java`**: Provide GUI components for respective roles.
  - **`salaryFinder.java`**: Calculates and displays staff salaries.
  - **`generalMethods.java`**: Includes utility methods shared across the application.
  - **`database.java`**: Manages database connectivity and operations.

- `nbproject/`: NetBeans-specific project configurations.

**Educational Purpose**:
This project demonstrates:
- Application of OOP principles like inheritance, encapsulation, and polymorphism.
- Role-based access control in software systems.
- GUI design and database integration in Java applications.

**Future Enhancements**:
- Add real-time order tracking and notifications.
- Enhance the GUI for better usability.
- Include advanced analytics for kitchen operations and staff performance.
