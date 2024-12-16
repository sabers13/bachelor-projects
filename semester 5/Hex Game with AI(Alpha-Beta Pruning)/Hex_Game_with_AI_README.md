# Hex Game with AI

## Overview
This project is a Python implementation of the classic Hex board game for two players: one human and one AI. The primary focus of this project is educational, showcasing key artificial intelligence techniques, including **Minimax Search** with **Alpha-Beta Pruning** and **Disjoint Set Data Structures** for efficient win condition checking.

## Features
- **Graphical User Interface**: Built using Pygame to provide an interactive Hex game experience.
- **AI Player**: The computer-controlled player uses Minimax with Alpha-Beta Pruning to make strategic decisions.
- **Dynamic Board Evaluation**: The AI evaluates board positions dynamically, rewarding progress toward its goal while blocking the opponent.
- **Win Condition Checking**: Efficient implementation of Hex-specific win conditions using the Disjoint Set data structure.

## Educational Aspects
This project demonstrates:
1. **Minimax Algorithm with Alpha-Beta Pruning**:
   - A recursive decision-making algorithm that explores all possible moves up to a given depth.
   - Alpha-Beta Pruning optimizes the search by eliminating branches that cannot influence the final decision, reducing computation time.

2. **Dynamic Board Evaluation Function**:
   - Rewards AI progress toward the winning path (left-to-right connection for Blue).
   - Penalizes opponent’s progress (top-to-bottom connection for Red).
   - Encourages clustering and connectivity of pieces for stronger board control.

3. **Disjoint Set Data Structure**:
   - Efficiently tracks connected components on the board.
   - Used to check if a player has formed a winning path.

4. **Game Theory**:
   - Concepts such as maximizing one’s advantage while minimizing the opponent’s are implemented via the evaluation function.

## Technical Details
### Minimax with Alpha-Beta Pruning
The AI evaluates possible moves up to a configurable depth. The algorithm maximizes its score while minimizing the opponent's potential score.

- **Alpha-Beta Pruning** ensures that branches of the game tree that cannot affect the final decision are not explored.

#### Code Example:
```python
if isMaximizing:  # AI's move
    bestScore = -math.inf
    for x in range(7):
        for y in range(7):
            if pieceSet[x][y] == '':
                pieceSet[x][y] = 'B'
                score = minimax(False, depth - 1, alpha, beta)
                pieceSet[x][y] = ''
                bestScore = max(bestScore, score)
                alpha = max(alpha, bestScore)
                if beta <= alpha:  # Prune
                    break
    return bestScore
```

### Evaluation Function
The evaluation function provides the AI with a heuristic to judge board positions.

#### Code Example:
```python
def evaluateBoard():
    blueScore = 0
    redScore = 0

    for x in range(7):
        for y in range(7):
            if pieceSet[x][y] == 'B':
                blueScore += (6 - x) * 2  # Proximity to right edge
                for dx, dy in [(1, 0), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < 7 and 0 <= ny < 7 and pieceSet[nx][ny] == 'B':
                        blueScore += 3  # Cluster reward
            elif pieceSet[x][y] == 'R':
                redScore += (6 - y) * 2
                for dx, dy in [(1, 0), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < 7 and 0 <= ny < 7 and pieceSet[nx][ny] == 'R':
                        redScore += 3

    return blueScore - redScore
```

### Disjoint Set Data Structure
Efficiently tracks clusters of connected pieces, checking if a player has connected their sides of the board.

#### Code Example:
```python
class disjointSet:
    def __init__(self, elements):
        self.root = {element: element for element in elements}

    def find(self, set1):
        if self.root[set1] != set1:
            self.root[set1] = self.find(self.root[set1])
        return self.root[set1]

    def union(self, set1, set2):
        root1 = self.find(set1)
        root2 = self.find(set2)
        self.root[root1] = root2
```

### Pygame Integration
- A visually interactive board.
- Click-based input for the human player.
- Visual indication of the winner when the game ends.

## How to Run
1. Install the required libraries:
   ```bash
   pip install pygame
   ```

2. Run the main script:
   ```bash
   python main.py
   ```

3. Play as Red (click to place pieces) while the AI (Blue) competes.

## Files
- **main.py**: Contains the game logic and AI implementation.
- **disjointSet.py**: Implements the Disjoint Set data structure.
- **assets/**: Contains images for the board and pieces.

## Future Improvements
- Enhance the evaluation function with Monte Carlo simulations for greater accuracy.
- Implement dynamic depth adjustment based on the complexity of the board state.
- Add support for larger board sizes.

## Credits
This project was developed as part of an AI course to demonstrate fundamental AI techniques and their application in games.
