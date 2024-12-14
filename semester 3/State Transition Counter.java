import java.util.Scanner;

public class hw {
	public static void main(String[] args) {

		//System.out.println("Enter n");
		Scanner mainsc = new Scanner(System.in);
		int n = mainsc.nextInt();
		//System.out.println("Enter states");
		int totstate = 0;
		int count = 0;
		for (int i = 0; i<n; i++) {
		int secstate = mainsc.nextInt();
		if (secstate != totstate && i!=0)
			++count;
		totstate=secstate;		
		}
		System.out.println(count);
		}
	}
