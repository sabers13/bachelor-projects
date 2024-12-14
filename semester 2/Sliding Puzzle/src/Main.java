import java.lang.Math;
import java.util.Scanner;
import java.util.Random; 


public class Main {
	public static void main(String[] args){
		//variables
		int moves=0;
		long time=0;
		int gameNumber=gameNumber();
		int n;
		n=getDimension();
		int[][] array= new int[n][n];
		//start capturing time
		long startTime = System.nanoTime();
		//save number in order then shuffle them 
		//introduce maximum number as number sign
		saveNumbers(n,array);
		shuffle(array);
		gameLoop( n, gameNumber, moves,array,time,startTime);
	
	}
	static int gameNumber() {
		Random random = new Random();
		int gameNumber=random.nextInt(1000);
		return gameNumber;
	}
	static int getDimension() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter a Number: ");
		int n = scanner.nextInt();
		return n;
	}
	static void saveNumbers(int n,int[][] array) {
		
	for(int i=0;i<n;i++) 
		for(int j=0;j<n;j++)
			array[i][j]=j+(i*n)+1;
	}
	static void shuffle(int[][]array) {
		Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--) {
	        for (int j = array[i].length - 1; j > 0; j--) {
	            int m = random.nextInt(i + 1);
	            int n = random.nextInt(j + 1);
	          
	            int temp = array[i][j];
	            array[i][j] = array[m][n];
	            array[m][n] = temp;
	        }
	    }
	}
    static void gameLoop(int n,int gameNumber,int moves,int[][]array,long time,long startTime) {
    	
    	//finding number sign to perform move on it
    	int hashtagsRow=findHashtagsRow(n,array);
		int hashtagsCol=findHashtagsCol(n,array);
    	printBoard(n,array,gameNumber,moves,time);
    	moves=move( n, moves, hashtagsRow, hashtagsCol,array);
		time=timeInseconds(startTime,time);
		gameOverCheck(n, gameNumber, moves, hashtagsRow, hashtagsCol,array,time,startTime);
		
    }
	static int findHashtagsRow(int n,int[][]array) {
		 int x = 0;
		    
		    boolean max=false;
		    for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
					if(array[i][j] ==(n*n)) {
						max=true;
						
						break;
					}
				if(max==true) {
					x=i;
					break;
				}
		    }
		    return x;
	}
    static int findHashtagsCol(int n,int[][]array) {
		 
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
					
					break;
				}
		    }
		    return y;
	}
	static void printBoard(int n,int[][]array,int gameNumber,int moves,long time) {
		topBoard( n,array);
		bottomBoard(n,gameNumber,moves,time);
		
	}
    static void topBoard(int n,int[][]array) {
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++)
			if(array[i][j] ==(n*n))
				System.out.print("#"+"  ");
			else
			if(array[i][j]<10)
				System.out.print(array[i][j]+"  ");
			else
				System.out.print(array[i][j]+" ");
		System.out.println();
	}
}
    static void bottomBoard(int n,int gameNumber,int moves,long time) {
    	System.out.println("Press R,L,U,D to move!");
		System.out.println("Game number: "+gameNumber);
		System.out.println("Number of moves: "+moves);
		System.out.println("Time:"+time );
		double score=score(n,moves,time);
		System.out.println("Score: "+score);

    }
    static double score(int n,int moves,long time) {
    	double score=0;
    	//start calculating score form second move because log 1=0
		if(moves>1)
			score=Math.round((1000*n*n)/(Math.pow(time, 0.3333)*Math.log10(moves)));
		return score;
    }
    static int move(int n,int moves,int hashtagsRow,int hashtagsCol,int[][]array) {
    	switch (direction()) {
    	case 'L':
    		moves=moveLeft( moves, hashtagsRow, hashtagsCol,array);
    		break;
    	case 'R':
    		moves=moveRight( n, moves, hashtagsRow, hashtagsCol,array);
    		break;
    	case 'U':
    		moves=moveUp( moves, hashtagsRow, hashtagsCol,array);
    		break;
    	case 'D':
    		moves=moveDown( n, moves, hashtagsRow, hashtagsCol,array);
    		break;
    		

    	
    	}
    	return moves;
    	
    	

}
	static char direction() {
		Scanner scanner=new Scanner(System.in);
		 char input_char= scanner.next().charAt(0);
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
		case 'L':
		case 'R':
		case 'U':
		case 'D':
			break;
		default:
    		System.out.println("* COMMAND WAS NOT VALID!");
		}
		return input_char;

	}
    static int moveLeft(int moves,int hashtagsRow,int hashtagsCol,int[][]array) {
    	if(hashtagsCol!=0) {
			int temp = array[hashtagsRow][hashtagsCol-1];
            array[hashtagsRow][hashtagsCol-1] = array[hashtagsRow][hashtagsCol];
            array[hashtagsRow][hashtagsCol] = temp;
            moves++;
		}
		else
			System.out.println("* COMMAND WAS NOT VALID!");
    	return moves;
    }
    static int moveRight(int n,int moves,int hashtagsRow,int hashtagsCol,int[][]array) {
    	if(hashtagsCol!=n-1) {
			int temp = array[hashtagsRow][hashtagsCol+1];
            array[hashtagsRow][hashtagsCol+1] = array[hashtagsRow][hashtagsCol];
            array[hashtagsRow][hashtagsCol] = temp;
            moves++;
		}
		else
			System.out.println("* COMMAND WAS NOT VALID!");
    	return moves;
    }
    static int moveUp(int moves,int hashtagsRow,int hashtagsCol,int[][]array) {
    	if(hashtagsRow!=0) {
			int temp = array[hashtagsRow-1][hashtagsCol];
            array[hashtagsRow-1][hashtagsCol] = array[hashtagsRow][hashtagsCol];
            array[hashtagsRow][hashtagsCol] = temp;
            moves++;
		}
		else
			System.out.println("* COMMAND WAS NOT VALID!");
    	return moves;
    }
    static int moveDown(int n,int moves,int hashtagsRow,int hashtagsCol,int[][]array) {
    	if(hashtagsRow!=n-1) {
			int temp = array[hashtagsRow+1][hashtagsCol];
            array[hashtagsRow+1][hashtagsCol] = array[hashtagsRow][hashtagsCol];
            array[hashtagsRow][hashtagsCol] = temp;
            moves++;
		}
		else
			System.out.println("* COMMAND WAS NOT VALID!");
    	return moves;
		
    }
    static long timeInseconds(long startTime,long time) {
    	long endTime = System.nanoTime();
		time = (endTime - startTime);
		//divide by 10 to the power of 9 to convert nanoseconds to seconds
		return time/1000000000;
    } 
    static void gameOverCheck(int n,int gameNumber,int moves,int hashtagsRow,int hashtagsCol,int[][]array,long time,long startTime) {
    	boolean win=true;
    	//making one dimension array to check win conditions
		int[] array1D= new int[n*n];
		array2Dto1D(n,array1D,array);
    	win=winCheck(win,n,array1D,array);
    	if(win) {
			clearConsole();
			printBoard(n,array,gameNumber,moves,time);
    		System.out.println("You WON!");

		}
		else {
			clearConsole();
			gameLoop( n, gameNumber, moves,array,time,startTime);
		}
    		
    				
    	
    }
    static void array2Dto1D(int n,int[]array1D,int[][]array) {
	for(int a = 0;a<n*n;a++)
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
				array1D[a]=array[i][j];
}
    static boolean winCheck(boolean win,int n,int[]array1D,int[][]array) {
    	//when number sign is first element of array 
    	if(array[0][0]==n*n && array[0][1]==2) {
    		/*add 2 from second element to check being even and order of numbers
    		 * if first number that didn't apply to this condition was 1 then continue adding 2
    		 * to check being odd and order of numbers to the last element
    		 */
    		for(int i=1;i<n*n;i++) 
    			if(array1D[i]+2==array1D[i+1]) {}
    			else if(array1D[i]==1) {}
    			else {
    				win=false;
    				break;
    			}
    	}
    	//when number sign is last element of array 
    	else if(array[n-1][n-1]==n*n && array[0][0]==2) {
    		/*add 2 from first element to check being even and order of numbers
    		 * if first number that didn't apply to this condition was 1 then continue adding 2
    		 * to check being odd and order of numbers to the element before number sign
    		 */
    		for(int i=0;i<(n*n)-1;i++) 
    			if(array1D[i]+2==array1D[i+1]) {}
    			else if(array1D[i]==1) {}
    			else {
    				win=false;
    				break;
    			}
    	}
    	else {
    		win=false;
    	}
    
    	return win;
    }
    static void clearConsole(){
    	for(int i=0;i<10;i++) {
    		System.out.println("\n");

    	}
    }
}


