package processing;

import java.util.ArrayList;
import java.util.Arrays;

public class NegamaxTree {
	static int count = 0;

	public static class node {
		int[][] table;
		ArrayList<node> children;
		node[] sort;
		public int score = 0;
		boolean full = false;
		public int lastMove = -1;
		public ArrayList<Integer> moves;
		public int turn;

		node() {
		}

		node(int[][] table) {
			count = 0;
			this.table = table;
		}

		node(int[][] table, int j, int turn) {
			this.table = table;
			this.lastMove = j;
			this.table[findFirstEmpty(table, j)][j] = turn;
			this.turn = turn;
		}

		public node(int[][] table, int j, int turn, ArrayList<Integer> moves) {
			this.table = table;
			this.lastMove = j;
			this.table[findFirstEmpty(table, j)][j] = turn;
			this.turn = turn;
			this.moves = new ArrayList<Integer>();
			if (moves != null)
				this.moves.addAll(moves);
			this.moves.add(j);
		}
	}

	public static node negamax(node node, int a, int b, int color) {
		node temp = new node();
		int max = 0;
		for (int i = 1; i < 6; i++) {
			temp = negamax(node, i, a, b, color);
			max = max > temp.score ? max : temp.score;
			if (temp.score > 0) {
				System.out.println("found in iteration " + i);
				return temp;
			}
		}
		System.out.println("max:" + max);
		return temp;
	}

	public static node negamax(node node, int depth, int a, int b, int color) {
		int debugdepth = 0;
		if (depth == 0 || node.full || (node.lastMove != -1 && checkWin(node, node.turn))) {
			count++;

			node.score = color * h(node);
//			System.out.println(node.score);
//			if (depth == debugdepth)
//			System.out.println("c:" + color + " d:" + depth + " " + node.score);
			return node;
		}

		node.children = genChildren(node, -color);
//		orderChildren(node);
//		int value = Integer.MIN_VALUE;
		node bestnode = new node();
		for (int i = 0; i < node.children.size(); i++) {
			node child = node.children.get(i);
			negamax(child, depth - 1, -b, -a, -color);
			if (bestnode.score < (-1 * child.score)) {
				bestnode = child;
			}
//			value = Math.max(value, -1 * child.score);
//			a = Math.max(a, value);
//			if (a >= b) {
//				break;
//			}
		}
//		for (int i = 0; i < node.children.size(); i++) {
//			System.out.print(node.children.get(i).score + " ");
//		}
//		System.out.println();
//		if (depth == debugdepth)
//		System.out.println("c:" + color + " d:" + depth + " " + bestnode.score);
//		if (depth == 0) {
//			System.out.println(bestnode.lastMove);
//		}
		node.score = bestnode.score;
		return bestnode;

	}

	private static void orderChildren(node node) {
		node.children.sort((o1, o2) -> o2.score - o1.score);
	}

	private static ArrayList<node> genChildren(node node, int color) {
		ArrayList<node> temp = new ArrayList<node>();
		int full = 0;
		for (int j = 0; j < Playing.jmax; j++) {
			int[][] t = Arrays.stream(node.table).map(int[]::clone).toArray(int[][]::new);
			if (node.table[0][j] == -1) {
				node newnode = new node(t, j, 1 - node.turn, node.moves);
				temp.add(newnode);
				System.out.println("child gen");
				count++;

				for (int k = 0; k < Playing.imax; k++) {
					for (int l = 0; l < Playing.jmax; l++) {
						System.out.print(newnode.table[k][l] + "\t");
					}
					System.out.println();
				}
				System.out.println(h(newnode));
			} else {
				full++;
			}
			if (full == node.table[0].length) {
				node.full = true;
			}
		}
		return temp;
	}

	private static int h(node node) {
		int temp;
		temp = checkWinScore(node, node.turn, 3);
		if (temp > 0)
			return 100 * temp;
		temp = checkWinScore(node, 1 - node.turn, 3);
		if (temp > 0)
			return -100 * temp;
		temp = checkWinScore(node, node.turn, 2);
		if (temp > 0)
			return 10 * temp;
		temp = checkWinScore(node, 1 - node.turn, 2);
		if (temp > 0)
			return -10 * temp;
		temp = checkWinScore(node, node.turn, 1);
		if (temp > 0)
			return 1 * temp;
		temp = checkWinScore(node, 1 - node.turn, 1);
		if (temp > 0)
			return -1 * temp;
		return 0;
	}
//	private static int h(node node) {
//		int[][] t = node.table;
//		int score = 0;
//		for (int i = 0; i < t.length; i++) {
//			for (int j = 0; j < t[0].length; j++) {
//				int[] xmod = { 0, 1, 1, 1, 0, -1, -1, -1 }, ymod = { 1, 1, 0, -1, -1, -1, 0, 1 };
//				check: for (int k = 0; k < 8; k++) { // direction
//					int tx = i + xmod[k], ty = j + ymod[k];
//					boolean flag1 = false, flag2 = false;
//					for (int l = 0; l < 3; l++) {
//						if (tx >= Playing.cols || ty >= Playing.rows || tx < 0 || ty < 0 || t[tx][ty] != node.turn) {
//							continue check;
//						}
//						tx += xmod[k];
//						ty += ymod[k];
//						if (i == 0) {
//							score++;
//						}
//						if (i == 1) {
//							score += 10;
//						}
//						if (i == 2) {
//							return 1;
//						}
//						if (tx >= Playing.cols || ty >= Playing.rows || tx < 0 || ty < 0
//								|| t[tx][ty] != 1 - node.turn) {
//							flag2 = true;
//						}
//						tx += xmod[k];
//						ty += ymod[k];
//						if (i == 0) {
//							score++;
//						}
//						if (i == 1) {
//							score += 10;
//						}
//						if (i == 2 && !flag2) {
//							score -= 200;
//						}
//						if (flag1 && flag2)
//							continue check;
//					}
//				}
//			}
//		}
//		return score;
//	}

	private static int findFirstEmpty(int[][] table, int j) {
		int i = Playing.imax - 1;
		while (table[i][j] != -1)
			i--;
		return i;
	}

	private static int findFirstFull(int[][] table, int j) {
		int i = 0;
		while (table[i][j] == -1)
			i++;
		return i;
	}

	public static boolean checkWin(node node, int turn, int winCount) {
		for (int i = 0; i < Playing.imax; i++) {
			for (int j = 0; j < Playing.jmax; j++) {
				if (node.table[i][j] == turn) {
					// direction matrixes
					int[] xmod = { 0, 1, 1, 1 }, ymod = { 1, 1, 0, -1 };
					check: for (int k = 0; k < 4; k++) { // direction
						int tj = j + xmod[k], ti = i - ymod[k];
						for (int l = 0; l < winCount; l++) {
							if (tj >= Playing.jmax || ti >= Playing.imax || tj < 0 || ti < 0
									|| node.table[ti][tj] != turn) {
								continue check;
							}
							tj += xmod[k];
							ti -= ymod[k];
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public static int checkWinScore(node node, int turn, int winCount) {
		int score = 0;
		for (int i = 0; i < Playing.imax; i++) {
			for (int j = 0; j < Playing.jmax; j++) {
				if (node.table[i][j] == turn) {
					// direction matrixes
					int[] xmod = { 0, 1, 1, 1 }, ymod = { 1, 1, 0, -1 };
					check: for (int k = 0; k < 4; k++) { // direction
						int tj = j + xmod[k], ti = i - ymod[k];
						for (int l = 0; l < winCount; l++) {
							if (tj >= Playing.jmax || ti >= Playing.imax || tj < 0 || ti < 0
									|| node.table[ti][tj] != turn) {
								continue check;
							}
							tj += xmod[k];
							ti -= ymod[k];
						}
						score++;
					}
				}
			}
		}
		return score;
	}

	public static boolean checkWin(node node, int turn) {
		return checkWin(node, turn, 3);
	}
}
