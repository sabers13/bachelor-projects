/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1.client;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pack1.database;
import pack1.user;
import pack1.userSignIn;
import pack2.drink;
import pack2.meal;

/**
 *
 * @author Saber
 */
public class client extends user {

    static DefaultTableModel tblModel = new DefaultTableModel();
    static DefaultTableModel orderTblModel = new DefaultTableModel();
    static int add = 0;
    static double Alltotal;
    //static double addWalletNumber=0;

    static void setHistoryTable() {

        orderTblModel.addColumn("Order");
        orderTblModel.addColumn("QTY");
        try {

            Connection conn = database.connectFooddb();
            String a = "SELECT * FROM history";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {

                String client = rs.getString("client");
                String order = rs.getString("title");
                int qty = rs.getInt("qty");
                if (client.equals(nameOFUser())) {
                    orderTblModel.addRow(new Object[]{order, qty});
                }

            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void setTables(JTable mealTable, JTable receiptTable, JTable drinkTable) throws SQLException {

        tblModel.addColumn("Order");
        tblModel.addColumn("Type");
        tblModel.addColumn("Price($)");
        tblModel.addColumn("qty");
        tblModel.addColumn("Total");
        tblModel.addColumn("Cook");
        receiptTable.setModel(tblModel);
        receiptTable.removeColumn(receiptTable.getColumnModel().getColumn(5));

        mealTable.setModel(meal.orderTblModel);
        drinkTable.setModel(drink.orderTblModel);
        mealTable.removeColumn(mealTable.getColumnModel().getColumn(2));
        drinkTable.removeColumn(drinkTable.getColumnModel().getColumn(2));
        drinkTable.removeColumn(drinkTable.getColumnModel().getColumn(2));

    }

    static void addOrder(JTable orderTable, JTable receiptTable, String type) {
        int i = orderTable.getSelectedRow();
        // int j = tvTable.getSelectedColumn();
        int qty = 1;
        boolean found = false;
        int rowToRemove = 0;

        if (add != 0) {
            for (int x = 0; x < receiptTable.getRowCount(); x++) {

                if (receiptTable.getModel().getValueAt(x, 0).equals((String) orderTable.getModel().getValueAt(i, 0))) {
                    found = true;
                    rowToRemove = x;
                    qty = (int) receiptTable.getModel().getValueAt(x, 3);
                    qty++;

                }
            }
        }
        add++;
        if (!found) {

            String order = (String) orderTable.getModel().getValueAt(i, 0);
            double price = (double) orderTable.getModel().getValueAt(i, 1);

            String cook = (String) orderTable.getModel().getValueAt(i, 2);

            double total = qty * price;

            tblModel.addRow(new Object[]{order, type, price, qty, total, cook});

        } else {

            double price = (double) orderTable.getModel().getValueAt(i, 1);

            double total = qty * price;
            tblModel.setValueAt(qty, rowToRemove, 3);
            tblModel.setValueAt(total, rowToRemove, 4);
        }

    }

    static void clearSelection(JTable mealTable, JTable receiptTable, JTable drinkTable) {
        receiptTable.getSelectionModel().clearSelection();
        mealTable.getSelectionModel().clearSelection();
        drinkTable.getSelectionModel().clearSelection();

    }

    static void mealAndDrinkSelection(JTable mealTable, JTable drinkTable) {
        if (mealTable.getSelectedRow() != -1) {
            if (drinkTable.getSelectedRow() != -1) {
                mealTable.getSelectionModel().clearSelection();
            }
        } else if (drinkTable.getSelectedRow() != -1) {
            if (mealTable.getSelectedRow() != -1) {
                drinkTable.getSelectionModel().clearSelection();
            }
        }
    }

    static void Alltotal(JTable receiptTable, JLabel allTotalLabel) {
        Alltotal = 0;
        for (int x = 0; x < receiptTable.getRowCount(); x++) {

            Alltotal = Alltotal + (double) receiptTable.getModel().getValueAt(x, 4);
        }
        String textAlltotal = String.valueOf(Alltotal);
        allTotalLabel.setText("Total:  " + textAlltotal + "$");
    }

    static void submitOrders(JTable receiptTable) throws ClassNotFoundException, SQLException {
        Connection conn = database.connectFooddb();

        String a = "INSERT INTO history (client,title,qty,type,ready,cook) VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(a);

        String user = nameOFUser();
        // String user = "";

        for (int x = 0; x < receiptTable.getRowCount(); x++) {

            String title = (String) receiptTable.getModel().getValueAt(x, 0);
            int qty = (int) receiptTable.getModel().getValueAt(x, 3);
            String type = (String) receiptTable.getModel().getValueAt(x, 1);
            String cook_brand = (String) receiptTable.getModel().getValueAt(x, 5);
            int itype;
            if (type.equals("Meal")) {
                itype = 0;
            } else {
                itype = 1;
            }

            pst.setString(1, user);
            pst.setString(2, title);
            pst.setInt(3, qty);
            pst.setInt(4, itype);
            pst.setInt(5, -1);
            pst.setString(6, cook_brand);
            pst.execute();
        }
        conn.close();

    }

    static void setBalance(JLabel accountBalancelLabel) {
        String textAlltotal = String.valueOf(walletBalance);
        accountBalancelLabel.setText("Account balance:  " + textAlltotal + "$");
    }

    static void submitBalance() throws SQLException {
        Connection conn = database.connectuserdb();
        String query = "update user set wallet = ? where username='" + nameOFUser() + "'";
        PreparedStatement preparedStmt = conn.prepareStatement(query);

        preparedStmt.setDouble(1, walletBalance);

        //System.out.println(walletBalance);
        // execute the java preparedstatement
        preparedStmt.executeUpdate();

        conn.close();

    }

}
