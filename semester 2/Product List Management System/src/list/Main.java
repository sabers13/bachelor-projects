package list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File cat = new File("C:\\Users\\Saber\\eclipse-workspace\\list\\categories.txt");
		Scanner categories;
		ArrayList<String> nameOfCategories = new ArrayList<String>();
		ArrayList<String> Codes = new ArrayList<String>();
		int numberOfValidLines = 0;
		try {
			categories = new Scanner(cat);

			while (categories.hasNextLine()) {
				String line = categories.nextLine();

				String Code = line.substring(0, 3);
				String name = line.substring(4);

				try {
					if (line.charAt(3) != ' ' || line.charAt(2) == ' ' || line.charAt(1) == ' '
							|| Integer.parseInt(Code) < 0 || Integer.parseInt(Code) > 999 || name.length() > 25)
						throw new java.io.IOException();
					else {

						nameOfCategories.add(name);
						Codes.add(Code);
						numberOfValidLines++;
					}

				} catch (NumberFormatException e) {

				} catch (IOException e) {

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		File pro = new File("C:\\Users\\Saber\\eclipse-workspace\\list\\products.txt");
		Scanner products;
		System.out.print("|");
		for (int i = 0; i < 26; i++)
			System.out.print(" ");
	
		System.out.print("|");
		for (int i = 0; i < 5; i++)
			System.out.print(" ");
		System.out.print("|");
		for (int i = 0; i < 12; i++)
			System.out.print(" ");
	
		System.out.print("|");
		for (int i = 0; i < 20; i++)
			System.out.print(" ");
		System.out.print("|");
		System.out.println("");
		try {
			products = new Scanner(pro);

			while (products.hasNextLine()) {
				String line = products.nextLine();
				int posOfFirstAmpersand = line.indexOf("&");
				int lengthOfName = line.indexOf("&", 1);

				int indexOfHashtag = line.indexOf("#");
				int indexOfDollarSign = line.indexOf("$");
				if (indexOfDollarSign != -1 && indexOfHashtag != -1 && lengthOfName != -1
						&& posOfFirstAmpersand != -1) {
					String nameOfProduct = line.substring(posOfFirstAmpersand + 1, lengthOfName);
					if (nameOfProduct.length() <= 25) {
						ArrayList<Integer> indexOfSpaces = new ArrayList<Integer>();
						indexOfSpaces.add(lengthOfName + 1);
						int numberOfSpaces = 1;
						for (int i = lengthOfName + 2;; numberOfSpaces++) {
							if (line.indexOf(" ", i) == -1)
								break;
							indexOfSpaces.add(line.indexOf(" ", i));
							i = line.indexOf(" ", i) + 1;
						}
						int indexOfSpaceListAfterHashtag;
						int indexOfSpaceListAfterDollarSign;
						for (indexOfSpaceListAfterHashtag = 0; indexOfSpaces
								.get(indexOfSpaceListAfterHashtag) < indexOfHashtag; indexOfSpaceListAfterHashtag++)
							if (numberOfSpaces - 1 == indexOfSpaceListAfterHashtag) {
								indexOfSpaceListAfterHashtag = indexOfSpaceListAfterHashtag + 1;
								break;
							}
						for (indexOfSpaceListAfterDollarSign = 0; indexOfSpaces.get(
								indexOfSpaceListAfterDollarSign) < indexOfDollarSign; indexOfSpaceListAfterDollarSign++)
							if (numberOfSpaces - 1 == indexOfSpaceListAfterDollarSign) {
								indexOfSpaceListAfterDollarSign = indexOfSpaceListAfterDollarSign + 1;
								break;
							}
						String ID = line.substring(indexOfSpaces.get(indexOfSpaceListAfterHashtag - 1) + 1,
								indexOfHashtag + 5);
						String price = line.substring(indexOfSpaces.get(indexOfSpaceListAfterDollarSign - 1) + 1,
								indexOfDollarSign);
						ArrayList<String> LineCategories = new ArrayList<String>();
						int numberOfLineCategories = 0;

						for (int a = 0; a < numberOfSpaces - 1; a++) {
							String Code = line.substring(indexOfSpaces.get(a) + 1, indexOfSpaces.get(a + 1));
							for (int i = 0; i < numberOfValidLines; i++)
								if (Code.equals(Codes.get(i))) {
									LineCategories.add(nameOfCategories.get(i));
									numberOfLineCategories++;
								}

							if (a + 1 == numberOfSpaces - 1) {
								Code = line.substring(indexOfSpaces.get(a + 1) + 1, line.length());
								for (int i = 0; i < numberOfValidLines; i++)
									if (Code.equals(Codes.get(i))) {
										LineCategories.add(nameOfCategories.get(i));
										numberOfLineCategories++;
									}

							}

						}
						boolean priceIsInteger=isInteger(price);
						if(nameOfProduct!=null&&ID!=null&&LineCategories!=null&&priceIsInteger) {
						System.out.print("|");
						for (int i = 0; i < ((25 - lengthOfName) / 2)+1; i++)
							System.out.print(" ");

						System.out.print(nameOfProduct);
						for (int i = 0; i < ((25 - lengthOfName) / 2)+1; i++)
							System.out.print(" ");
						if ((25 - lengthOfName) % 2 != 0)
							System.out.print(" ");

						System.out.print("|");

						System.out.print(ID);
						System.out.print("|");
						for (int i = 0; i < (11 - price.length()) / 2; i++)
							System.out.print(" ");
						System.out.print(price + "$");
						for (int i = 0; i < (11 - price.length()) / 2; i++)
							System.out.print(" ");
						if ((11 - price.length()) % 2 != 0)
							System.out.print(" ");
						System.out.print("|");
						for (int i = 0; i < numberOfLineCategories; i++) {
							System.out.print(LineCategories.get(i));
							if (i != numberOfLineCategories - 1)
								System.out.print(",");

						}
						System.out.print("|");
						System.out.println("");
						}

					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 PrintWriter outputfile;
		try {
			outputfile = new PrintWriter("output.txt");
			outputfile.print(" ");
		    outputfile.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		   
	}
	public static boolean isInteger(String price) {
	    try { 
	        Integer.parseInt(price); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
