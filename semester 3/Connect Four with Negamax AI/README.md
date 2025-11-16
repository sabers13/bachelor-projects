# Connect Four with Negamax AI (Java, Swing)

## Overview

This project is a simple **Connect Four** implementation written in Java using the Swing toolkit.  
It supports a 6×7 board and separates the responsibilities of:

- **GUI rendering & user input** (`gui.Main`)
- **Game state & turn handling** (`processing.Playing`)
- **Board representation and win detection** (`processing.CurrentTable`)
- **Search-based computer player (Negamax)** (`processing.NegamaxTree`)

The current GUI allows a human to play on the board; the AI module is implemented as a separate component and can be wired into the UI to make automatic moves for the computer player.

---

## Features

- 6×7 **Connect Four** board built with a `GridLayout` of `JButton` cells.
- Colored discs:
  - One player rendered in **red**
  - The other player rendered in **blue**
- Turn label at the side of the board (`"Computer"` vs `"Player"`), updated after each valid move.
- End-of-game detection:
  - Win detection for 4 in a row (horizontal, vertical, or diagonal)
  - Draw detection when no more moves are available in any column
  - Board is automatically disabled once the game is finished.

- Negamax-based AI core:
  - Board state represented as a 2D integer array (`-1` for empty, `0/1` for each player).
  - Children generation by simulating drops in each non-full column.
  - Depth-limited **Negamax** search with an evaluation function that scores potential 4-in-a-row patterns for both sides.

---

## Project Structure

```text
src/
  gui/
    Main.java           # Swing GUI and program entry point
  processing/
    Playing.java        # Global game settings (rows/cols), turn tracking, color helpers
    CurrentTable.java   # Maps buttons to board state, applies moves, and checks for wins
    NegamaxTree.java    # Negamax search tree + heuristic evaluation for Connect Four
```

### `gui.Main`

- Creates the main window (`JFrame`) and centers it on the screen.
- Builds a 6×7 `JButton` grid to represent the Connect Four board.
- Hooks a single `ActionListener` to all cells, which:
  - Finds the clicked cell.
  - Delegates the move to `CurrentTable.move(row, col)`.
  - On a win, updates the status label to `"X Wins!"`.
  - Otherwise toggles turns via `Playing.changeTurn()` and updates the label.
  - Calls `Main.checkEndGame(...)` to handle draw or final cleanup.

### `processing.Playing`

- Stores global parameters:
  - `imax` (rows), `jmax` (columns)
  - `turn` (0/1) and `win` flag
- Initializes a new game via `init(rows, cols)`.
- Provides helper methods:
  - `getColor()` → returns `Color.red` / `Color.blue` for the active player
  - `changeTurn()` → toggles the `turn` field
  - `getPlayerName()` → resolves `"Computer"` or `"Player"` from the current turn

### `processing.CurrentTable`

- Holds the Swing `JButton[][] table` representing the board.
- Initializes the local copy of the board and associates it with the GUI buttons.
- Implements:
  - `move(i, j)` → applies a drop in the selected column if the move is legal
  - `isMoveAvailable(i, 0)` → checks if there is still space left in a column
  - `checkWin(i, j)` → checks for 4 consecutive discs of the active player in all directions after a move
  - `getbinary()` → converts the visual board (button colors) into a numeric 2D array for use by `NegamaxTree`.

### `processing.NegamaxTree`

- Defines an inner `node` class containing:
  - `int[][] table` – abstract board state
  - `ArrayList<node> children` – generated child nodes
  - `int score` – evaluation of the node
  - `boolean full` – whether the board is full
  - `int lastMove` and `ArrayList<Integer> moves` – move history

- Provides:
  - `negamax(node node, int depth, int alpha, int beta, int color)` – depth-limited Negamax search routine.
  - `h(node node)` – heuristic evaluation:
    - Uses `checkWinScore` to count aligned pieces for the current player and the opponent for chains of length 1–3.
    - Weights longer chains more heavily (e.g. potential 4-in-a-row patterns get the highest score).
  - `checkWin(node node, int turn)` – pure board-based win checking (no GUI dependency).

This separation allows the search algorithm to work entirely on integer arrays, independent of Swing.

---

## How to Run

1. **Compile**

   From the `src` directory:

   ```bash
   javac gui/Main.java processing/*.java
   ```

   Make sure your source paths match this layout.

2. **Run**

   ```bash
   java gui.Main
   ```

3. **Play**

   - Click on any cell in a column; the game logic will place your disc in the lowest available row for that column.
   - Watch the status label to see whose turn it is and who wins.
   - When a win or draw occurs, the board is disabled.

---

## Possible Extensions

- Wire the **Negamax AI** into the GUI so that:
  - The human controls one color.
  - After each human move, the AI computes the best response and plays automatically.
- Add settings for:
  - Board size (rows/cols)
  - Search depth / difficulty
- Add a scoreboard and restart button to play multiple rounds.

This project demonstrates:

- Basic **Java Swing** GUI programming
- Clean separation of view (GUI) and logic (game state / AI)
- Implementation of a **Negamax search** with a simple heuristic evaluation for a classic board game.
