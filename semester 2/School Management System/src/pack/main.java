package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;

public class main {

	public static void main(String[] args) {

		startMenu();

	}

	public static void startMenu() {
		manager manager = new manager();

		System.out.println("=== Welcome to school management ===");
		System.out.println("1.Sign in");
		System.out.println("2.Sign up");
		System.out.println("Please enter a number: ");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		switch (input) {
		case 1:
			singInMenu();
		case 2:
			// code block
			break;
		default:
			System.out.println("Input is not valid!");
			startMenu();
		}

	}

	public static int teacherUsernameCheck() {
		teacher teacher = new teacher();
		ArrayList<String> t_usernames = teacher.getUsernamesList();

		System.out.println("Username: ");
		Scanner sc = new Scanner(System.in);
		String usernameInput = sc.nextLine();
		int userIndex;
		for (userIndex = 0; userIndex < t_usernames.size(); userIndex++) {
			String line = t_usernames.get(userIndex);
			if (line.equals(usernameInput))
				break;
		}
		if (userIndex == t_usernames.size()) {
			System.out.println("Username is not valid");
			teacherUsernameCheck();
		}

		return userIndex;

	}

	public static void teacherPasswordCheck(int userIndex) {
		System.out.println("Password: ");
		Scanner sc = new Scanner(System.in);
		String passwordInput = sc.nextLine();
		teacher teacher = new teacher();
		ArrayList<String> t_passwords = teacher.getPasswordsList();
		if (!passwordInput.equals(t_passwords.get(userIndex)))
			System.out.println("Username or password is not valid");

	}

	public static int studentUsernameCheck() {
		student student = new student();
		ArrayList<String> s_usernames = student.getUsernamesList();

		System.out.println("Username: ");
		Scanner sc = new Scanner(System.in);
		String usernameInput = sc.nextLine();
		int userIndex;
		for (userIndex = 0; userIndex < s_usernames.size(); userIndex++) {
			String line = s_usernames.get(userIndex);
			if (line.equals(usernameInput))
				break;
		}
		if (userIndex == s_usernames.size()) {
			System.out.println("Username is not valid");
			teacherUsernameCheck();
		}

		return userIndex;

	}

	public static void studentPasswordCheck(int userIndex) {
		System.out.println("Password: ");
		Scanner sc = new Scanner(System.in);
		String passwordInput = sc.nextLine();
		student student = new student();
		ArrayList<String> s_passwords = student.getPasswordsList();
		if (!passwordInput.equals(s_passwords.get(userIndex)))
			System.out.println("Username or password is not valid");

	}
	public static int managerUsernameCheck() {
		manager manager = new manager();

		ArrayList<String> m_usernames = manager.getUsernamesList();

		System.out.println("Username: ");
		Scanner sc = new Scanner(System.in);
		String usernameInput = sc.nextLine();
		int userIndex;
		for (userIndex = 0; userIndex < m_usernames.size(); userIndex++) {
			String line = m_usernames.get(userIndex);
			if (line.equals(usernameInput))
				break;
		}
		if (userIndex == m_usernames.size()) {
			System.out.println("Username is not valid");
			teacherUsernameCheck();
		}

		return userIndex;

	}

	public static void managerPasswordCheck(int userIndex) {
		System.out.println("Password: ");
		Scanner sc = new Scanner(System.in);
		String passwordInput = sc.nextLine();
		manager manager = new manager();
		ArrayList<String> m_passwords = manager.getPasswordsList();
		if (!passwordInput.equals(m_passwords.get(userIndex)))
			System.out.println("Username or password is not valid");

	}
	public static void singInMenu() {
		System.out.println("Enter as: ");
		System.out.println("1.Student");
		System.out.println("2.Teacher");
		System.out.println("3.Manager");
		System.out.println("4.back to start menu");

		System.out.println("Please enter a number: ");
		Scanner sc = new Scanner(System.in);
		int input2 = sc.nextInt();
		switch (input2) {
		case 1:
			int s_userIndex = studentUsernameCheck();
			studentPasswordCheck(s_userIndex);
			break;
		case 2:
			int t_userIndex = teacherUsernameCheck();
			teacherPasswordCheck(t_userIndex);
			break;
		case 3:

			int m_userIndex = managerUsernameCheck();
			managerPasswordCheck(m_userIndex);
			break;
		case 4:
			startMenu();
			break;
		default:
			System.out.println("Input is not valid!");
			singInMenu();
			

		}

	}
}
