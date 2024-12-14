/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1.chef;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import pack1.cook.cook;
import pack1.database;

/**
 *
 * @author Saber
 */
public class chef extends cook{
    
    static void deleteDbData() {
        try {
            Connection conn = database.connectFooddb();
            String query = "DELETE FROM food";
            Statement stmt = conn.createStatement();
            int deletedRows = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void insertDataToDB(JTable orderTable) {
        try {
            Connection conn = database.connectFooddb();
            String a = "INSERT INTO food (ID, title, type, price, cook_brand) VALUES(?,?,?,?,?)";
            for (int x = 0; x < orderTable.getRowCount(); x++) {
                PreparedStatement pst = conn.prepareStatement(a);
                String order = (String) orderTable.getModel().getValueAt(x, 1);
                int type = 1;
                if (orderTable.getModel().getValueAt(x, 2).equals("Meal")) {
                    type = 0;
                }
                double price = Double.parseDouble((String) orderTable.getModel().getValueAt(x, 3));
                String cook = (String) orderTable.getModel().getValueAt(x, 4);
                int ID = x + 1;
                pst.setInt(1, ID);
                pst.setString(2, order);
                pst.setInt(3, type);
                pst.setDouble(4, price);
                pst.setString(5, cook);

                pst.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
