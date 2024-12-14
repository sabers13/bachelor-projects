
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
public class generalMethods {

    static boolean doublecheck(String check) {
        boolean flag = false;
        try {
            double salary = Double.parseDouble(check);
            if (salary > 0) {
                flag = true;
            } else {
                try {
                    throw new java.io.IOException();
                } catch (IOException ex) {
                    Logger.getLogger(generalMethods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "input is not valid!");
           
        }
        return flag;
    }

    static void setLabels(JLabel firstName, JLabel lastName, JLabel age) {
        firstName.setText("First name: " + database.firstName.get(userSignIn.indexOfUser));
        lastName.setText("Last name: " + database.lastName.get(userSignIn.indexOfUser));
        age.setText("Age: " + database.age.get(userSignIn.indexOfUser));

    }

    
}
