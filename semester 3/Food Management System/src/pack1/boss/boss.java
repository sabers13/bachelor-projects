/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1.boss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pack1.chef.chef;
import pack1.chef.editMenu;
import pack1.database;
import pack1.user;

/**
 *
 * @author Saber
 */
public class boss extends chef {
        public static DefaultTableModel empTblModel = new DefaultTableModel();

    
     static void setTable() {

       
        empTblModel.addColumn("Username");
        empTblModel.addColumn("Password");
        empTblModel.addColumn("Title");
        

        try {

            Connection conn = database.connectuserdb();
            String a = "SELECT * FROM user";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {
                
                String username = rs.getString("username");
                String password = rs.getString("password");
                String type = rs.getString("type");
                double wallet= rs.getDouble("wallet");
                System.out.println(wallet);
               if (wallet==-1) 
                   empTblModel.addRow(new Object[]{username, password, type});
                

            }
            conn.close();
            
            

        } catch (Exception ex) {
Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("pack1.editMenu.setTables()");
        }
    }
     static void addEmp(String type,String username,String password){
         try {
            
            if(usernameCheck(username)){
            
            empTblModel.addRow(new Object[]{username, password, type});
            Connection conn = database.connectuserdb();
            String a = "INSERT INTO user (username, password, type, wallet) VALUES(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(a);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, type);
            pst.setDouble(4, -1);
            
            
            pst.execute();
            
            }
            else
                JOptionPane.showMessageDialog(null, "Username is invalid!");
            // orderTblModel.addRow(new Object[]{ID, order, type, price, cook});
        } catch (SQLException ex) {
            Logger.getLogger(employeesManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     static void removeEmp(JTable empTable){
        try {
            int i = empTable.getSelectedRow();
            String username =  (String) empTable.getModel().getValueAt(i, 0);
            Connection conn = database.connectuserdb();
            String a = "DELETE FROM user WHERE username = ?";
            PreparedStatement pst = conn.prepareStatement(a);
            pst.setString(1, username);
            // execute the delete statement
            pst.executeUpdate();
            conn.close();
            ((DefaultTableModel) empTable.getModel()).removeRow(i);
        } catch (SQLException ex) {
            Logger.getLogger(removeDrink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     static boolean usernameCheck(String username){
        boolean flag=true;
        try {
            Connection conn = database.connectuserdb();
            String a = "SELECT * FROM user";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {
                if( username.equals(rs.getString("username")))
                        flag=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(employeesManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
     static void removeDrink(JTable orderTable){
        try {
            int i = orderTable.getSelectedRow();
            String order =  (String) orderTable.getModel().getValueAt(i, 0);
            Connection conn = database.connectFooddb();
            String a = "DELETE FROM food WHERE title = ?";
            PreparedStatement pst = conn.prepareStatement(a);
            pst.setString(1, order);
            // execute the delete statement
            pst.executeUpdate();
            
            ((DefaultTableModel) orderTable.getModel()).removeRow(i);
        } catch (SQLException ex) {
            Logger.getLogger(removeDrink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
