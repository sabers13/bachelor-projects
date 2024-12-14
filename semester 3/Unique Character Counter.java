
import java.util.Scanner;
import java.util.ArrayList;

public class grandfather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner mainsc = new Scanner(System.in);
		int n = mainsc.nextInt();
		String name;
		int total = 1;
		for (int i = 0; i <= n; i++) {
			int newtotal = 0;
			name = mainsc.nextLine();
			for (int j = 0; j < name.length(); j++) {
				boolean rep = false;
				for (int k = 0; k < j; k++) {
					if (name.charAt(k) == name.charAt(j))
						rep = true;	
				}
				if (!rep)
						++newtotal;
			}
			if (newtotal > total)
				total = newtotal;

		}
		System.out.println(total);

	}

}
