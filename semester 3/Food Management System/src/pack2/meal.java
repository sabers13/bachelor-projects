/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pack1.chef.editMenu;
import pack1.database;

/**
 *
 * @author Saber
 */
public class meal {
     public static DefaultTableModel orderTblModel = new DefaultTableModel();
    
    public static void setTable() {

       
        //orderTblModel.addColumn("ID");
        orderTblModel.addColumn("Order");
        //orderTblModel.addColumn("Type");
        orderTblModel.addColumn("Price($)");
        orderTblModel.addColumn("Cook/Brand");

        try {

            Connection conn = database.connectFooddb();
            String a = "SELECT * FROM food";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {
                
                String order = rs.getString("title");
                double price = rs.getDouble("price");
                String cook = rs.getString("cook_brand");
                int itype = rs.getInt("type");
                if (itype == 0) {
                    
                orderTblModel.addRow(new Object[]{order, price, cook});
                }
            }
            conn.close();
            //orderTable.setModel(orderTblModel);

        } catch (Exception ex) {
Logger.getLogger(editMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("pack1.editMenu.setTables()");
        }
    }
    
}
