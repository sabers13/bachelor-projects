package processing;

import java.awt.Color;

import javax.swing.JButton;

import processing.NegamaxTree.node;

public class CurrentTable {

	public static JButton[][] table;

	public static void init(JButton[][] buttons) {
		table = new JButton[buttons.length][buttons[0].length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				table[i][j] = buttons[i][j];
				table[i][j].setBackground(Color.gray);
			}
		}
	}

	public static boolean isMoveAvailable(int i, int j) {
		if (table[0][j].getBackground() != Color.gray)
			return false;
		return true;
	}

	public static boolean move(int i, int j) {
		if (isMoveAvailable(i, j)) {
			i = findFirstEmpty(table, j);
			table[i][j].setBackground(Playing.getTurnColor());
			return true;
		}
		return false;
	}

	private static int findFirstEmpty(JButton[][] table, int j) {
		int i = Playing.imax - 1;
		while (table[i][j].getBackground() != Color.gray)
			i--;
		return i;
	}

	private static int findFirstFull(JButton[][] table, int j) {
		int i = 0;
		while (table[i][j].getBackground() == Color.gray)
			i++;
		return i;
	}

	public static boolean checkWin(int i, int j) {
		i = findFirstFull(table, j);
		Color player = Playing.getTurnColor();
		// direction matrixes
		int[] xmod = { 0, 1, 1, 1, 0, -1, -1, -1 }, ymod = { 1, 1, 0, -1, -1, -1, 0, 1 };
		check: for (int k = 0; k < 8; k++) { // direction
			int tj = j + xmod[k], ti = i - ymod[k];
			for (int l = 0; l < 3; l++) {
				if (tj >= Playing.jmax || ti >= Playing.imax || ti < 0 || tj < 0
						|| table[ti][tj].getBackground() != player) {
					continue check;
				}
				tj += xmod[k];
				ti -= ymod[k];
			}
			Playing.win = true;
			return true;
		}
		return false;
	}

	public static node getbinary() {
		int[][] bin = new int[table.length][table[0].length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (!table[i][j].getBackground().equals(Color.gray)) {
					bin[i][j] = table[i][j].getBackground().equals(Color.blue) ? 1 : 0;
				} else {
					bin[i][j] = -1;
				}
			}
		}
//		for (int i = 0; i < bin.length; i++) {
//			for (int j = 0; j < bin[0].length; j++) {
//				System.out.print(bin[i][j] + " ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < bin.length; i++) {
//			for (int j = 0; j < bin[0].length; j++) {
//				System.out.print(table[i][j].getBackground().equals(Color.blue) + " ");
//			}
//			System.out.println();
//		}
		return new node(bin);
	}

}
