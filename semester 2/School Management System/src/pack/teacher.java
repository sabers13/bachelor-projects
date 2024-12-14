package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class teacher {

	File stu = new File("teacher.txt");
	Scanner teacher;
	ArrayList<String> lines = new ArrayList<String>();
	ArrayList<String> IDs = new ArrayList<String>();
	ArrayList<String> usernames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> lastnames = new ArrayList<String>();
	ArrayList<Integer> accountsBalance = new ArrayList<Integer>();
	ArrayList<String> classes = new ArrayList<String>();
	
	{

		try {
			teacher = new Scanner(stu);
			int numberOfLines = 0;
			while (teacher.hasNextLine()) {
				ArrayList<Integer> indexOfUnderlines = new ArrayList<Integer>();
				String line = teacher.nextLine();
				lines.add(line);
				getIndexOfUnderlines(line,indexOfUnderlines);
				getIDs(line,indexOfUnderlines);
				getUsernames(line,indexOfUnderlines);
				getPasswords(line,indexOfUnderlines);
				getNames(line,indexOfUnderlines);
				getLastNames(line,indexOfUnderlines);
				getAccountsBalance(line,indexOfUnderlines);
				getClassesAndScores(line,indexOfUnderlines);


			}

			numberOfLines++;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<String> getUsernamesList() {
	       return usernames;
	   }
	public ArrayList<String> getPasswordsList() {
	       return passwords;
	   }

	public void getIDs(String line,ArrayList<Integer> indexOfUnderlines) {
		String ID = line.substring(0, indexOfUnderlines.get(0));
		IDs.add(ID);
	}

	public void getUsernames(String line,ArrayList<Integer> indexOfUnderlines) {
		String username = line.substring(indexOfUnderlines.get(0) + 1, indexOfUnderlines.get(1));
		usernames.add(username);
	}

	public void getPasswords(String line,ArrayList<Integer> indexOfUnderlines) {
		String password = line.substring(indexOfUnderlines.get(1) + 1, indexOfUnderlines.get(2));
		passwords.add(password);
	}

	public void getNames(String line,ArrayList<Integer> indexOfUnderlines) {
		String name = line.substring(indexOfUnderlines.get(2) + 1, indexOfUnderlines.get(3));
		names.add(name);
	}

	public void getLastNames(String line,ArrayList<Integer> indexOfUnderlines) {
		String lastname = line.substring(indexOfUnderlines.get(3) + 1, indexOfUnderlines.get(4));
		lastnames.add(lastname);
	}

	public void getAccountsBalance(String line,ArrayList<Integer> indexOfUnderlines) {
		String accountBalance = line.substring(indexOfUnderlines.get(4) + 1, indexOfUnderlines.get(5));
		int Balance = Integer.parseInt(accountBalance);
		accountsBalance.add(Balance);
	}

	public void getClassesAndScores(String line,ArrayList<Integer> indexOfUnderlines) {
		String classAndScore = line.substring(indexOfUnderlines.get(5) + 1);
		classes.add(classAndScore);
	}

	public void getIndexOfUnderlines(String line,ArrayList<Integer> indexOfUnderlines) {
		int numberOfUnderlines = 0;
		for (int i = 0; line.indexOf("_", i) != -1; numberOfUnderlines++) {

			indexOfUnderlines.add(line.indexOf("_", i));
			i = line.indexOf("_", i) + 1;
		}
	}

}