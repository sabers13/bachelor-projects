/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import static pack1.userSignIn.clientUsernameField;
import static pack1.userSignIn.clientPasswordField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saber
 */
public class user {

   
    public static String type;
    public static double walletBalance;
    static int ID;
    public static boolean usernameCheck( ){
    boolean check = false;
        try {
            
            Connection conn=database.connectuserdb();
            String a="Select *from user where username='"+clientUsernameField.getText()
                    +"' and password='"+clientPasswordField.getText()+"'";
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(a);
            if(rs.next()){
                check=true;
            type = rs.getString("type");
            walletBalance=rs.getDouble("wallet");
            //ID=rs.getInt("ID");
                //System.out.println(type);
            }
            else{
			JOptionPane.showMessageDialog(null, "Username or Password is incorrecy");
                        check=false;}
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(userSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return check;
}
    public static String nameOFUser(){
        
        return clientUsernameField.getText();
        
    }
}
