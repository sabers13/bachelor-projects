# Sliding Puzzle Game Manual

## 1. Project Overview

The Sliding Puzzle Game is a simple yet engaging application that challenges players to arrange numbered tiles in order by sliding them into an empty space. This implementation supports customizable board sizes and generates a unique puzzle configuration for each game. The project is written in Java and emphasizes logic-based gameplay.

---

## 2. System Features

- **Dynamic Board Size**: Players can choose the board's dimension (e.g., 3x3, 4x4).
- **Randomized Setup**: The board is shuffled randomly at the start of each game.
- **Interactive Gameplay**: Players move tiles by entering directional commands (R, L, U, D).
- **Scoring System**: Calculates a score based on time and moves.
- **Win Condition**: Checks if the tiles are arranged in the correct order.

---

## 3. File Descriptions

### `Main.java`

This file contains the core logic for the sliding puzzle game. Key functionalities include:

- Initializing and shuffling the game board.
- Handling user input for board dimension and directional moves.
- Managing the game loop, win condition, and score calculation.
- Displaying the current state of the board and game statistics.

### `Main1.java`

A variant of the main file, possibly for testing or alternative gameplay logic. It includes:

- Basic board initialization and shuffling.
- Simplified game board display.
- Auxiliary methods for calculating positions of tiles and the empty space.

---

## 4. Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE.

### Steps

1. **Clone the Repository**: Download or clone the project from the GitHub repository.
2. **Open the Project**:
   - Import the `.java` files into your Java IDE.
3. **Compile the Code**:
   - Compile `Main.java` or `Main1.java` depending on the intended gameplay.
4. **Run the Game**:
   - Execute the main method in the selected file to start the game.

---

## 5. Usage Instructions

### Starting a Game
1. Run the application.
2. Enter the board dimension (e.g., 3 for a 3x3 board).

### Gameplay
1. Use the following keys to move tiles:
   - **R**: Move the empty space to the right.
   - **L**: Move the empty space to the left.
   - **U**: Move the empty space up.
   - **D**: Move the empty space down.
2. The game tracks the number of moves and elapsed time.
3. Arrange the tiles in ascending order to win.

### Winning the Game
- The game checks the board state after each move.
- When all tiles are in order, the game displays a win message and the final score.

---

## 6. Additional Notes

### Common Issues

- **Invalid Commands**: Ensure that you enter valid commands (R, L, U, D).
- **Board Configuration**: The game might not shuffle properly if the random number generator isn't seeded correctly.

### Future Enhancements

- Add a graphical user interface (GUI) for better interactivity.
- Implement a feature to save and load game states.
- Include a hint system to assist players.

---

This document provides a comprehensive guide to understanding and playing the Sliding Puzzle Game. For further assistance, refer to the source code or contact the developer.

