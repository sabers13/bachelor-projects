import math
import pygame
from disjointSet import disjointSet


def setPosition():
    x, y = 0, 0
    for x in range(7):
        piecePos[x][y] = 150 + (x * 70), 85
        for y in range(7):
            piecePos[x][y] = 150 + (x * 70) + (y * 35), (y * 60) + 85


def AImove():
    bestScore = -math.inf
    bestMove = None
    for x in range(7):
        for y in range(7):
            if pieceSet[x][y] == '':
                pieceSet[x][y] = 'B'
                score = minimax(False, 3, -math.inf, math.inf)
                pieceSet[x][y] = ''
                if score > bestScore:
                    bestScore = score
                    bestMove = (x, y)

    if bestMove:
        pieceSet[bestMove[0]][bestMove[1]] = 'B'
        blueWinCheck(bestMove[0], bestMove[1])


def evaluateBoard():
    blueScore = 0
    redScore = 0

    for x in range(7):
        for y in range(7):
            if pieceSet[x][y] == 'B':
                # Reward proximity to right edge for Blue
                blueScore += (6 - x)
                # Bonus for connecting with adjacent Blue pieces
                for dx, dy in [(1, 0), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < 7 and 0 <= ny < 7 and pieceSet[nx][ny] == 'B':
                        blueScore += 2
            elif pieceSet[x][y] == 'R':
                # Penalize proximity to bottom edge for Red
                redScore += (6 - y)
                # Bonus for connecting with adjacent Red pieces
                for dx, dy in [(1, 0), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < 7 and 0 <= ny < 7 and pieceSet[nx][ny] == 'R':
                        redScore += 2

    # Blue is maximizing, so return the difference
    return blueScore - redScore


def minimax(isMaximizing, depth, alpha, beta):
    if depth == 0 or gameOver:
        return evaluateBoard()  # Evaluate the board state

    if isMaximizing:  # Blue's move
        bestScore = -math.inf
        for x in range(7):
            for y in range(7):
                if pieceSet[x][y] == '':
                    pieceSet[x][y] = 'B'
                    score = minimax(False, depth - 1, alpha, beta)
                    pieceSet[x][y] = ''  # Undo the move
                    bestScore = max(bestScore, score)
                    alpha = max(alpha, bestScore)
                    if beta <= alpha:  # Prune
                        break
        return bestScore

    else:  # Red's move
        bestScore = math.inf
        for x in range(7):
            for y in range(7):
                if pieceSet[x][y] == '':
                    pieceSet[x][y] = 'R'
                    score = minimax(True, depth - 1, alpha, beta)
                    pieceSet[x][y] = ''  # Undo the move
                    bestScore = min(bestScore, score)
                    beta = min(beta, bestScore)
                    if beta <= alpha:  # Prune
                        break
        return bestScore


def updateBoard():
    for i in range(7):
        for j in range(7):
            if pieceSet[i][j] == 'R':
                screen.blit(redPic, piecePos[i][j])
            elif pieceSet[i][j] == 'B':
                screen.blit(bluePic, piecePos[i][j])


def redWinCheck(x, y):
    currentX = x
    currentY = y
    for x, y in [(x + 1, y), (x + 1, y - 1), (x, y + 1), (x, y - 1), (x - 1, y), (x - 1, y + 1)]:
        if 0 <= x <= 6 and 0 <= y <= 6:
            if pieceSet[x][y] == 'R':
                dsRed.union((currentX, currentY), (x, y))
    if dsRed.find((0, 0)) == dsRed.find((6, 6)):
        print('red wins')
        return True
    else:
        return False


def blueWinCheck(x, y):
    currentX, currentY = x, y
    for dx, dy in [(1, 0), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1)]:
        nx, ny = currentX + dx, currentY + dy
        if 0 <= nx <= 6 and 0 <= ny <= 6 and pieceSet[nx][ny] == 'B':
            dsBlue.union((currentX, currentY), (nx, ny))

    # Check if left and right edges are connected
    for i in range(7):
        if dsBlue.find((0, i)) == dsBlue.find((6, i)):
            print('Blue wins')
            return True
    return False


# Initialize the pygame
pygame.init()
pygame.font.init()
textfont = pygame.font.SysFont('monospace', 150)
gameOver = redWon = blueWon = False

cells = [(i, j) for j in range(7) for i in range(7)]
dsRed = disjointSet(cells)
dsBlue = disjointSet(cells)

for i in range(7):
    # top
    dsRed.union((i, 0), (0, 0))
    # bottom
    dsRed.union((i, 6), (6, 6))

for i in range(7):
    # left
    dsBlue.union((0, i), (0, 0))
    # right
    dsBlue.union((6, i), (6, 6))

# Create the screen
screen = pygame.display.set_mode((1000, 600))

# Background
background = pygame.image.load('background.jpg')
BoardPic = pygame.image.load('Hex Board.png')
redPic = pygame.image.load('red piece.png')
bluePic = pygame.image.load('blue piece.png')

# Caption and Icon
pygame.display.set_caption("Hex Game g-26")
icon = pygame.image.load('daneshgah_gilan.png')
pygame.display.set_icon(icon)

# Set matrices
piecePos = [[0 for i in range(7)] for j in range(7)]
pieceSet = [["" for i in range(7)] for j in range(7)]
setPosition()

# Game Loop

while True:

    screen.blit(background, (0, 0))
    screen.blit(BoardPic, (120, -78))
    updateBoard()

    for event in pygame.event.get():
        # Mouse click
        if event.type == pygame.MOUSEBUTTONDOWN and not gameOver:
            # Left click
            if event.button == 1:
                cx = event.pos[0]
                cy = event.pos[1]
                temp = piecePos[0]
                selectedX = -1
                selectedY = -1
                # Find Y of select position
                for i in range(7):
                    if temp[i][1] + 10 < cy < temp[i][1] + 50:
                        selectedY = i
                        break
                else:
                    selectedY = -1

                # Find X of select position
                for j in range(7):
                    if selectedY != -1:
                        if piecePos[j][selectedY][0] < cx < piecePos[j][selectedY][0] + 50:
                            selectedX = j
                            break
                else:
                    selectedX = -1

                # Set pieces to appropriate positions
                if selectedY != -1 and selectedX != -1:
                    if pieceSet[selectedX][selectedY] == '':
                        pieceSet[selectedX][selectedY] = 'R'
                        redWon = redWinCheck(selectedX, selectedY)
                        AImove()
                        blueWon = False
                        for i in range(7):
                            if dsBlue.find((0, i)) == dsBlue.find((6, i)):
                                blueWon = True
                        if redWon or blueWon:
                            gameOver = True

        if event.type == pygame.QUIT:
            pygame.quit()
            quit()

    redText = textfont.render('Red Won!', 1, (255, 0, 0))
    blueText = textfont.render('Blue Won!', 1, (0, 0, 255))
    if redWon:
        screen.blit(redText, (200, 200))
        gameOver = True
    if blueWon:
        screen.blit(blueText, (200, 200))
        gameOver = True

    pygame.display.update()
