package processing;

import java.awt.Color;

public class Playing {

	// currently playing game information
	public static int jmax = 7;
	public static int imax = 6;
	public static int turn;
	public static boolean win = false;

	/**
	 * Initiate the game. called once every game.
	 */
	public static void init(int rows, int cols) {
		Playing.turn = (int) Math.floor(Math.random() * 2);
		Playing.imax = rows;
		Playing.jmax = cols;
	}

	public static Color getTurnColor() {
		if (turn == 1) {
			return Color.blue;
		} else
			return Color.red;
	}

	public static void changeTurn() {
		turn = 1 - turn;
	}

	public static String getPlayerName() {
		return (Playing.turn == 0) ? "Computer" : "Player";
	}
}
