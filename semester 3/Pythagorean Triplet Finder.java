//package pithagoras;

import java.util.Scanner;

public class pitha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mainsc = new Scanner(System.in);
		int n = mainsc.nextInt();
		int p1, p2, p3 = 1;
		boolean yes = false;
		for (p1 = 1; p1 <= (n / 2); p1++) {
			for (p2 = 1; p2 <= p1; p2++) {
				for (p3 = 1; p3 <= p2; p3++) {
					int p1power = (p1 * p1);
					int p2power = (p2 * p2);
					int p3power = (p3 * p3);
					if ((p2power + p3power) == p1power && (p1 + p2 + p3) == n) {
						System.out.println(p3 + " " + p2 + " " + p1);
						yes = true;
						break;
					}

				}
				if (yes)
					break;
			}
			if (yes)
				break;
		}

		if (!yes)
			System.out.println("Impossible");
	}

}
