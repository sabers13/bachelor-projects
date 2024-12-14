//package specialsum;

import java.util.Scanner;

public class specialsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mainsc = new Scanner(System.in);
		int n = mainsc.nextInt();
		int tavan = 0;
		int total = 0;
		int digit = 0;
		int k = 1;
		while (n!=0) {
			digit = n%10;
			n=n/10;
			int digitpower = 1;
			for (int i=0;i<tavan;i++)
				{digitpower = digitpower*digit;}
			total = total + (k*(digitpower));
			++tavan;
			k *= -1;
		}
		System.out.println(total);
	}

}
