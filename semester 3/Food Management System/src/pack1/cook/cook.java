/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1.cook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pack1.chef.chefPanel;
import pack1.database;
import pack1.user;
import pack1.userSignIn;

/**
 *
 * @author Saber
 */
public class cook extends user{
    
    
    static void setPendingTable() {

        

        pendingOrdersTblModel.addColumn("Order");
        pendingOrdersTblModel.addColumn("QTY");
        pendingOrdersTblModel.addColumn("Client");
        try {

            Connection conn = database.connectFooddb();
            String a = "SELECT * FROM history";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {

                String cook = rs.getString("cook");
                String order = rs.getString("title");
                String client = rs.getString("client");
                int qty = rs.getInt("qty");
                int ready = rs.getInt("ready");
                
                if (cook.equals(nameOFUser()) || user.type.equals("chef")) {
                    if (ready==-1) {
                        pendingOrdersTblModel.addRow(new Object[]{order, qty, client});
                    }
                }

            }
            conn.close();
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
static void cooking(JTable pendingOrderTable) {
        try {
            int i = pendingOrderTable.getSelectedRow();
            String order = (String) pendingOrderTable.getModel().getValueAt(i, 0);
            String client = (String) pendingOrderTable.getModel().getValueAt(i, 2);
            Connection conn = database.connectFooddb();
            String query = "update history set ready = ? where title='" + order
                    + "' and client='" + client + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setInt(1, 1);

            preparedStmt.executeUpdate();

            conn.close();

            ((DefaultTableModel) pendingOrderTable.getModel()).removeRow(i);
        } catch (SQLException ex) {
            Logger.getLogger(pendingOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
static void pendingBackButton (){
     if(type.equals("cook")){
            cookPanel cookPanel = new cookPanel();
        cookPanel.setVisible(true);
        
        }
        else if(type.equals("chef")){
            chefPanel chefPanel = new chefPanel();
        chefPanel.setVisible(true);
        
        }
}
    static void setCompletedTable() {

        

        completedOrdersTblModel.addColumn("Order");
        completedOrdersTblModel.addColumn("QTY");
        completedOrdersTblModel.addColumn("Client");
        try {

            Connection conn = database.connectFooddb();
            String a = "SELECT * FROM history";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {

                String cook = rs.getString("cook");
                String order = rs.getString("title");
                String client = rs.getString("client");
                int qty = rs.getInt("qty");
                boolean ready = rs.getBoolean("ready");
                System.out.println(ready);
                if (cook.equals(nameOFUser()) && ready) {
                    completedOrdersTblModel.addRow(new Object[]{order, qty, client});
                }

            }
            conn.close();
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    static DefaultTableModel completedOrdersTblModel = new DefaultTableModel();
    static DefaultTableModel pendingOrdersTblModel = new DefaultTableModel();

}
