
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saber
 */
public class database {

    static ArrayList<String> user = new ArrayList<String>();
    static ArrayList<String> pass = new ArrayList<String>();
    static ArrayList<String> firstName = new ArrayList<String>();
    static ArrayList<String> lastName = new ArrayList<String>();
    static ArrayList<String> age = new ArrayList<String>();
    static ArrayList<String> salary = new ArrayList<String>();

    public static void setDB(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                ArrayList<Integer> indexOfApostrophe = new ArrayList<Integer>();
                String data = reader.nextLine();
                int i = 0;
                while (true) {

                    if (data.indexOf("'", i) == -1) {
                        break;
                    }
                    indexOfApostrophe.add(data.indexOf("'", i));
                    i = data.indexOf("'", i) + 1;

                }
                user.add(data.substring(indexOfApostrophe.get(0) + 1, indexOfApostrophe.get(1)));
                pass.add(data.substring(indexOfApostrophe.get(1) + 1, indexOfApostrophe.get(2)));
                firstName.add(data.substring(indexOfApostrophe.get(2) + 1, indexOfApostrophe.get(3)));
                lastName.add(data.substring(indexOfApostrophe.get(3) + 1, indexOfApostrophe.get(4)));
                age.add(data.substring(indexOfApostrophe.get(4) + 1, indexOfApostrophe.get(5)));
                salary.add(data.substring(indexOfApostrophe.get(5) + 1, indexOfApostrophe.get(6)));

            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static boolean updateDB(String salary, String filename) {
        boolean flag = false;

        try {
            database.salary.set(userSignIn.indexOfUser, salary);
            File file = new File(filename);
            file.delete();
            FileWriter writer = new FileWriter(filename, true);
            for (int i = 0; i < database.user.size(); i++) {
                if (i > 0) {
                    writer.write("\n");
                }
                writer.write("'" + database.user.get(i) + "'" + database.pass.get(i)
                        + "'" + database.firstName.get(i) + "'" + database.lastName.get(i) + "'"
                        + database.age.get(i) + "'" + database.salary.get(i) + "'");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "your salary is: " + database.salary.get(userSignIn.indexOfUser));
            flag = true;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return flag;
    }

    public static void clearDB() {
        user.clear();
        pass.clear();
        firstName.clear();
        lastName.clear();
        age.clear();
        salary.clear();
    }

}
