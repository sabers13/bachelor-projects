// ConsoleApplication21.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include <conio.h>
#include <string>
#include <cstdlib>	
#include <ctime>
#include <fstream>

using namespace std;

// constants
const int J = 4,I=4;
const int VALUE_TO_WIN = 2048;

// entery point
void menu();
void playGame();
int main() {
	menu();
	cout << "\nPress any key to close the game ...\n";
	_getch();
}


// global variables : shared state
bool gameOver, stuck, win;
int score;
char input_char;
string logMessage;
int arr[I][J];

// game manager section
void setGlobals();
void gameLoop();
void render();
void credits();
void records();
ofstream records_file("records.txt");
string name;
void menu() {
	char input;
	cout << "===2048 Game===\n";
	cout << "1. Start Game\n";
	cout << "2. Credits\n";
	cout << "3. Records\n";
	cout << "4. Exit\n";
	cout << "Enter a number:\n";
	for (int x=0; ;x++) {
		input = _getch();
		if (input == '1') {
			system("CLS");
			cout << "Enter your name: \n";
			cin >> name;
			records_file << name << "-";
			system("CLS");
			playGame();
			break;
		}
		if (input == '2') {
			credits();
			break;
		}
		if (input == '3') {
			records();
			break;
		}
		if (input == '4')
			break;
		else
			if(!x)
				cout << "* COMMAND WAS NOT VALID!";
	}
}

void returnToMenu();
void playGame() {
	setGlobals();
	render();
	while (!gameOver) {
		gameLoop();
	}
	records_file << score << "\n";
	if (win) {
		cout << "You won ! :D";
		returnToMenu();
	}
	else if (stuck) {
		cout << "You lost the game :(";
		returnToMenu();
	}
	else {
		system("CLS");
		menu();
	}
}

void credits() {
	system("CLS");
	cout << "Created by Saber Sojudi.\n";
	cout << "Student id: 990122681012";
	returnToMenu();

}

void records() {
	system("CLS");
	ifstream records_file("records.txt");
	while (records_file >> name >> score)
	{
		cout << name << " " << score << endl;
	}
	returnToMenu();

}

void returnToMenu() {
	cout << "\nPress any key to return to the game menu ...\n";
	_getch();
	system("CLS");
	menu();
}
void updateScore();
void setGlobals() {
	for(int i=0;i<I;i++)
	for (int j = 0; j<J; j++)
		arr[i][j] = 0;
	arr[0][J-1] = 2;
	gameOver = false;
	stuck = false;
	win = false;
	updateScore();
	logMessage = "";
}


void input();
void update();
void render();
void gameLoop() {
	input();
	update();
	render();
}

// input section
void input() {
	cout << "[Move: L R U D |Exit: E]\n";
	input_char = _getch();
	switch (input_char) {
	case 'l':
		input_char = 'L';
		break;
	case 'r':
		input_char = 'R';
		break;
	case 'u':
		input_char = 'U';
		break;
	case 'd':
		input_char = 'D';
		break;
	case 'e':
		input_char = 'E';
		break;
	}
}

// update (game logic) section
bool move(char);
void updateScore();
void gameOverCheck();
void addTile(char);
void update() {
	bool moved;
	switch (input_char) {
	case 'E':
		gameOver = true;
		break;
	case 'L':
	case 'R':
	case 'U':
	case 'D':
		moved = move(input_char);
		if (moved)
			addTile(input_char);
		break;
	default:
		logMessage = "* COMMAND WAS NOT VALID!";
	}
	updateScore();
	gameOverCheck();
}

bool moveLeft();
bool moveRight();
bool moveUp();
bool moveDown();

bool move(char direction) {
	bool moved = false;
	switch (direction) {
	case 'L':
		moved = moveLeft();
		break;
	case 'R':
		moved = moveRight();
		break;
	case 'U':
		moved = moveUp();
		break;
	case 'D':
		moved = moveDown();
		break;
	}
	return moved;
}

bool moveLeft() {
	bool moved = false;
	for (int i = 0; i<I; i++)
	for (int j = 0; j<J - 1; j++) {
		int next = j + 1;
		for (; next < J - 1; next++)
			if (arr[i][next] > 0)
				break;

		if (arr[i][j] == 0) {
			if (arr[i][next] > 0) {
				arr[i][j] = arr[i][next];
				arr[i][next] = 0;
				moved = true;
				j--;
			}
		}
		else {
			if (arr[i][j] == arr[i][next]) {
				arr[i][j] += arr[i][next];
				arr[i][next] = 0;
				moved = true;
			}
		}
	}
	return moved;
}

bool moveRight() {
	bool moved = false;
	for (int i = 0; i<I; i++)
	for (int j = J - 1; j>0; j--) {
		int next = j - 1;
		for (; next > 0; next--)
			if (arr[i][next] > 0)
				break;

		if (arr[i][j] == 0) {
			if (arr[i][next] > 0) {
				arr[i][j] = arr[i][next];
				arr[i][next] = 0;
				j++;
				moved = true;
			}
		}
		else {
			if (arr[i][j] == arr[i][next]) {
				arr[i][j] += arr[i][next];
				arr[i][next] = 0;
				moved = true;
			}
		}
	}
	return moved;
}

bool moveUp() {
	bool moved = false;
	for (int j = 0; j<J; j++)
		for (int i = 0; i<I - 1; i++) {
			int next = i + 1;
			for (; next < I - 1; next++)
				if (arr[next][j] > 0)
					break;

			if (arr[i][j] == 0) {
				if (arr[next][j] > 0) {
					arr[i][j] = arr[next][j];
					arr[next][j] = 0;
					moved = true;
					i--;
				}
			}
			else {
				if (arr[i][j] == arr[next][j]) {
					arr[i][j] += arr[next][j];
					arr[next][j] = 0;
					moved = true;
				}
			}
		}
	return moved;
}

bool moveDown() {
	bool moved = false;
	for (int j = 0; j<J; j++)
		for (int i = I - 1; i>0; i--) {
			int next = i - 1;
			for (; next > 0; next--)
				if (arr[next][j] > 0)
					break;

			if (arr[i][j] == 0) {
				if (arr[next][j] > 0) {
					arr[i][j] = arr[next][j];
					arr[next][j] = 0;
					i++;
					moved = true;
				}
			}
			else {
				if (arr[i][j] == arr[next][j]) {
					arr[i][j] += arr[next][j];
					arr[next][j] = 0;
					moved = true;
				}
			}
		}
	return moved;
}
void addTile(char direction)
{
	int randomNumber;
	int findRandomNumber();
	switch (direction)
	{
	case 'L':
		while (true)
		{
			findRandomNumber();
			if (arr[findRandomNumber()][J-1] == 0)
			{
				arr[findRandomNumber()][J-1] = 2;
				break;
			}
		}
		break;
	case 'R':
		while (true)
		{
			findRandomNumber();
			if (arr[findRandomNumber()][0] == 0)
			{
				arr[findRandomNumber()][0] = 2;
				break;
			}
		}
		break;
	case 'U':
		while (true)
		{
			findRandomNumber();
			if (arr[J - 1][findRandomNumber()] == 0)
			{
				arr[J - 1][findRandomNumber()] = 2;
				break;
			}
		}
		break;
	case 'D':
		while (true)
		{
			findRandomNumber();
			if (arr[0][findRandomNumber()] == 0)
			{
				arr[0][findRandomNumber()] = 2;
				break;
			}
		}
		break;
	}
}
int findRandomNumber()
{
	int randomNumber;
	srand(time(0));
	randomNumber = rand() % 4;
	return randomNumber;
}

void updateScore() {
	score = 0;
	for (int i = 0; i<I; i++)
	for (int j = 0; j<J; j++)
		score += arr[i][j];
}

void stuckCheck();
void winCheck();
void gameOverCheck() {
	winCheck();
	stuckCheck();

	if (stuck || win) {
		gameOver = true;
	}
}

void stuckCheck() {
	stuck = true;
	for (int i = 0; i<I; i++)
	for (int j = 0; j<J; j++)
		if (arr[i][j] == 0) {
			stuck = false;
			break;
		}
	
	for (int i = 0; i<I; i++)
	for (int j = 0; j<J - 1; j++)
		if (arr[i][j] == arr[i][j + 1]) {
			stuck = false;
			break;
		}
	for (int i = 0; i<I-1; i++)
		for (int j = 0; j<J ; j++)
			if (arr[i+1][j] == arr[i][j]) {
				stuck = false;
				break;
			}
}

void winCheck() {
	for (int i = 0; i<I; i++)
	for (int j = 0; j<J; j++)
		if (arr[i][j] == VALUE_TO_WIN) {
			win = true;
			break;
		}
}

// render section
void topPannel();
void printBoard();
void bottomPannel();
void render() {
	system("CLS");
	topPannel();
	printBoard();
	bottomPannel();
}

void topPannel() {
	cout << "===2048 Game===\n";
	if (logMessage != "") {
		cout << logMessage;
		logMessage = "";
	}
	cout << '\n';
}

void printCell(int);
void printBoard() {
	for (int i = 0; i < I; i++) {
		for (int j = 0; j < J; j++) {
			printCell(arr[i][j]);
		}
		cout << '\n';
	}
	cout << '\n';
}

void printCell(int value) {
	if (value == 0)
		cout << "[    ]";
	else if (value < 10) {
		cout << "[ " << value << "  ]";
	}
	else if (value < 100) {
		cout << "[ " << value << " ]";
	}
	else if (value < 1000) {
		cout << "[ " << value << "]";
	}
	else {
		cout << "[" << value << "]";
	}
}

void bottomPannel() {
	cout << "Score: " << score << '\n';
}

