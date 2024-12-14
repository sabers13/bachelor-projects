
### README: 2D Fighter Game

**Project Name**: 2D Fighter Game

**Description**:
This project is a 2D fighter game built using Java, designed to demonstrate core principles of object-oriented programming (OOP) and game development techniques. The game includes player characters, animations, and mechanics for fighting, health management, and input processing. As a capstone project for the third semester, it emphasizes advanced OOP concepts, efficient class design, and resource handling.

**Key Features**:

- **Player Mechanics**:
  - Two-player fighting system with movement, attacks, and health bars.
  - Animations for running, attacking, and dying.

- **Game Engine**:
  - Real-time input handling and collision detection.
  - Modular game state management with menus and gameplay.

- **Resource Management**:
  - Integration of graphical assets for characters and backgrounds.
  - Optimized loading and handling of sprite animations.

**Tech Stack**:
- **Programming Language**: Java.
- **Frameworks/Tools**: Java AWT and Swing for rendering.
- **Resources**: Custom assets for characters, animations, and UI.

**Usage Instructions**:
1. **Setup**:
   - Install Java and a compatible IDE (e.g., NetBeans or IntelliJ IDEA).
   - Open the project in your IDE.

2. **Run the Game**:
   - Compile and run the `game.java` class to start the application.
   - Use the menu to navigate and initiate gameplay.

3. **Controls**:
   - Player 1: Arrow keys for movement, specific keys for attacks.
   - Player 2: WASD for movement, specific keys for attacks.

**Project Structure**:
- `src/fightergame/`: Contains all Java source files.
  - **`game.java`**: The main class controlling the game loop and state transitions.
  - **`player.java`** and **`player2.java`**: Implement player-specific mechanics, including movement and attacks.
  - **`object.java`**: Defines the base class for all game objects with position, size, and rendering methods.
  - **`processor.java`**: Handles collisions, interactions, and updates during gameplay.
  - **`menu.java`**: Manages the graphical user interface for the main menu.
  - **`bar.java`**: Represents health bars and other visual indicators.
  - **`ID.java`**: Enumerates unique identifiers for game objects.
  - **`input.java`**: Processes and maps user input to game actions.
  - **`window.java`**: Creates and manages the game window.

- `resources/`: Contains graphical assets.
  - **Backgrounds**: Images for menu and in-game scenes.
  - **Player Sprites**: Animations for player actions like attacks and movement.

**Educational Purpose**:
This project highlights:
- Application of OOP principles like inheritance, polymorphism, and encapsulation.
- Design patterns for game loops, input processing, and state management.
- Integration of graphical assets and animations into Java applications.
- Real-time event handling and object interactions.

**Future Enhancements**:
- Add AI opponents for single-player gameplay.
- Improve physics-based interactions and collision responses.
- Enhance graphics with particle effects and smoother animations.
- Introduce additional characters and unique fighting styles.
