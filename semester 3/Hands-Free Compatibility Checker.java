//package handsfree;

import java.util.Scanner;

public class handsfree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mainsc = new Scanner(System.in);
		String hf1 = mainsc.nextLine();
		String hf2 = mainsc.nextLine();
		char[] hfs = { hf1.charAt(0), hf1.charAt(2), hf2.charAt(0), hf2.charAt(2) };
		/*boolean yes = false;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (hfs[i] == hfs[j] && i + j != 2 && i + j != 4 && i != j)
					yes = true;
				
			}

		}*/
		if (hfs[0]==hfs[1] || hfs[0]==hfs[3] || hfs[1]==hfs[2] || hfs[2]==hfs[3])
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
