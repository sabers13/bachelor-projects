import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random; 



public class Main {
	public static void main(String[] args){
		int n;
		Scanner scanner=new Scanner(System.in);
		getDimension();
		System.out.print("Enter a Number: ");
		n = scanner.nextInt();
		int[][] array= new int[n][n];
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				array[i][j]=j+(i*n)+1;
		Random random = new Random();

	    for (int i = array.length - 1; i > 0; i--) {
	        for (int j = array[i].length - 1; j > 0; j--) {
	            int m = random.nextInt(i + 1);
	            int n1 = random.nextInt(j + 1);

	            int temp = array[i][j];
	            array[i][j] = array[m][n1];
	            array[m][n1] = temp;
	        }
	    }
	    int x = 0;
	    int y=0;
	    boolean max=false;
	    for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				if(array[i][j] ==(n*n)) {
					max=true;
					y=j;
					break;
				}
			if(max==true) {
				x=i;
				break;
			}
	    }
	    
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				if(array[i][j] ==(n*n))
					System.out.print("#"+" ");
				else
				System.out.print(array[i][j]+" ");
			System.out.println();
		}
		System.out.println(x);
		System.out.println(y);

	}
	static void getDimension() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter a Number: ");
		n = scanner.nextInt();
		
	}
	}

}
