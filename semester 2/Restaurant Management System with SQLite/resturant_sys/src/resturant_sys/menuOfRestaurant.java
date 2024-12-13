package resturant_sys;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;
import static resturant_sys.userSignIn.clientUsernameField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saber
 */
public class menuOfRestaurant extends javax.swing.JFrame {

    /**
     * Creates new form menuOfRestaurant
     */
    public menuOfRestaurant() throws SQLException {
        initComponents();

        setMealTable();
        setReceiptTable();
        setDrinkTable();
    }

    public void setMealTable() throws SQLException {
        String DB = listOfRest.getNameOfdb();
        Connection conn = database.connectMenudb();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("meal");
        tblModel.addColumn("price");

        String a = "SELECT * FROM " + DB;

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(a);
        while (rs.next()) {
            String meal = rs.getString("meal");
            double price;
            price = rs.getDouble("mealPrice");
            if (meal != null) {
                tblModel.addRow(new Object[]{meal, price});
            }
        }
        mealTable.setModel(tblModel);
    }

    public void setDrinkTable() throws SQLException {
        String DB = listOfRest.getNameOfdb();
        Connection conn = database.connectMenudb();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.addColumn("Drink");
        tblModel.addColumn("Price");

        String a = "SELECT * FROM " + DB;

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(a);
        while (rs.next()) {
            String drink = rs.getString("drink");
            double price;
            price = rs.getDouble("drinkPrice");
            if (drink != null) {
                tblModel.addRow(new Object[]{drink, price});
            }
        }
        drinkTable.setModel(tblModel);
    }
    DefaultTableModel tblModel = new DefaultTableModel();

    public void setReceiptTable() {

        tblModel.addColumn("Order");
        tblModel.addColumn("Price");
        tblModel.addColumn("qty");
        tblModel.addColumn("Total");
        receiptTable.setModel(tblModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mealTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        reduceButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        drinkTable = new javax.swing.JTable();
        allTotalLabel = new javax.swing.JLabel();
        receiptLabel = new javax.swing.JLabel();
        menuLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mealTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mealTable.setRowHeight(25);
        jScrollPane1.setViewportView(mealTable);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        receiptTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "price", "qty", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        receiptTable.setRowHeight(25);
        jScrollPane2.setViewportView(receiptTable);

        reduceButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reduceButton.setText("-");
        reduceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceButtonActionPerformed(evt);
            }
        });

        drinkTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drinkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        drinkTable.setRowHeight(25);
        jScrollPane4.setViewportView(drinkTable);

        allTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        receiptLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        receiptLabel.setText("Receipt");
        receiptLabel.setToolTipText("");

        menuLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menuLabel1.setText("Menu");
        menuLabel1.setToolTipText("");

        submitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitButton.setText("Submit and pay");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reduceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(menuLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(allTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(receiptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reduceButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allTotalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        mealAndDrinkSelection();
        if (mealTable.getSelectedRow() != -1) {
            addMeal();
        } else if (drinkTable.getSelectedRow() != -1) {
            addDrink();
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        listOfRest list;
        try {
            list = new listOfRest();
            list.setVisible(true);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menuOfRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(menuOfRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void reduceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceButtonActionPerformed
        int i = receiptTable.getSelectedRow();
        int j = receiptTable.getSelectedColumn();
        String order = (String) receiptTable.getModel().getValueAt(i, j - 1);
        double price = (double) receiptTable.getModel().getValueAt(i, j);

        int qty = (int) receiptTable.getModel().getValueAt(i, j + 1);

        if (qty == 1) {

            ((DefaultTableModel) receiptTable.getModel()).removeRow(i);
            Alltotal();
        } else {
            qty = qty - 1;
            double total = price * qty;

            ((DefaultTableModel) receiptTable.getModel()).removeRow(i);
            tblModel.addRow(new Object[]{order, price, qty, total});
            Alltotal();
        }

    }//GEN-LAST:event_reduceButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            if (!existenceOfDB()) {
                createOrdersDB();
            }
            submitOrders();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(menuOfRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(menuOfRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Thank you and have a good meal!");
        firstMenu backToFirstMenu = new firstMenu();
        backToFirstMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_submitButtonActionPerformed
    public void addMeal() {
        int i = mealTable.getSelectedRow();
        int j = mealTable.getSelectedColumn();
        int qty = 1;
        boolean found = false;
        int rowToRemove = 0;
        if (add != 0) {
            for (int x = 0; x < receiptTable.getRowCount(); x++) {
                int y = 0;
                if (receiptTable.getModel().getValueAt(x, y).equals((String) mealTable.getModel().getValueAt(i, j - 1))) {//Search the model
                    found = true;
                    rowToRemove = x;
                    qty = (int) receiptTable.getModel().getValueAt(x, y + 2);
                    qty++;

                }
            }
        }
        add++;
        if (!found) {

            String meal = (String) mealTable.getModel().getValueAt(i, j - 1);
            double price = (double) mealTable.getModel().getValueAt(i, j);

            double total = qty * price;

            tblModel.addRow(new Object[]{meal, price, qty, total});

        } else {
            ((DefaultTableModel) receiptTable.getModel()).removeRow(rowToRemove);
            String meal = (String) mealTable.getModel().getValueAt(i, j - 1);
            double price = (double) mealTable.getModel().getValueAt(i, j);

            double total = qty * price;

            tblModel.addRow(new Object[]{meal, price, qty, total});
        }
        Alltotal();
        clearSelection();

    }

    public void addDrink() {
        int i = drinkTable.getSelectedRow();
        int j = drinkTable.getSelectedColumn();
        int qty = 1;
        boolean found = false;
        int rowToRemove = 0;
        if (add != 0) {
            for (int x = 0; x < receiptTable.getRowCount(); x++) {
                int y = 0;
                if (receiptTable.getModel().getValueAt(x, y).equals((String) drinkTable.getModel().getValueAt(i, j - 1))) {//Search the model
                    found = true;
                    rowToRemove = x;
                    qty = (int) receiptTable.getModel().getValueAt(x, y + 2);
                    qty++;

                }
            }
        }
        add++;
        if (!found) {

            String drink = (String) drinkTable.getModel().getValueAt(i, j - 1);
            double price = (double) drinkTable.getModel().getValueAt(i, j);

            double total = qty * price;

            tblModel.addRow(new Object[]{drink, price, qty, total});

        } else {
            ((DefaultTableModel) receiptTable.getModel()).removeRow(rowToRemove);
            String drink = (String) drinkTable.getModel().getValueAt(i, j - 1);
            double price = (double) drinkTable.getModel().getValueAt(i, j);

            double total = qty * price;

            tblModel.addRow(new Object[]{drink, price, qty, total});
        }
        Alltotal();
        clearSelection();

    }

    public void clearSelection() {
        receiptTable.getSelectionModel().clearSelection();
        mealTable.getSelectionModel().clearSelection();
        drinkTable.getSelectionModel().clearSelection();
    }

    public void Alltotal() {
        double Alltotal = 0;
        for (int x = 0; x < receiptTable.getRowCount(); x++) {
            int y = 3;

            Alltotal = Alltotal + (double) receiptTable.getModel().getValueAt(x, y);
        }
        String textAlltotal = String.valueOf(Alltotal);
        allTotalLabel.setText("Total:  " + textAlltotal + "$");
    }

    public void mealAndDrinkSelection() {
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

    public void createOrdersDB() throws ClassNotFoundException, SQLException {
        String DB = listOfRest.getNameOfdb() + "Orders";
        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB + ".db");
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE  " + DB
                + "(user TEXT ,"
                + "orders TEXT ,"
                + "total TEXT"
                + ");";

        stmt.executeUpdate(sql);
        conn.close();
    }

    public void submitOrders() throws ClassNotFoundException, SQLException {
        String DB = listOfRest.getNameOfdb() + "Orders";
        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB + ".db");
        String a = "INSERT INTO " + DB + " (user,orders,total) VALUES(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(a);
        String orderDetails = "";
        String total = allTotalLabel.getText();

        String user = userSignIn.nameOFUser();
        System.out.println(user);
        for (int x = 0; x < receiptTable.getRowCount(); x++) {
            String orderDetail = "order: " + (String) receiptTable.getModel().getValueAt(x, 0) + "-price: "
                    + (double) receiptTable.getModel().getValueAt(x, 1) + "$-qty: " + (int) receiptTable.getModel().getValueAt(x, 2)
                    + "___";
            //total = (double) receiptTable.getModel().getValueAt(x, 3);
            orderDetails = orderDetails + orderDetail;

        }
        pst.setString(1, user);
        pst.setString(2, orderDetails);
        pst.setString(3, total);
        pst.execute();

        conn.close();
    }

    public boolean existenceOfDB() throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Class.forName("org.sqlite.JDBC");
        String DB = listOfRest.getNameOfdb() + "Orders";

        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB + ".db");
        DatabaseMetaData dbm = conn.getMetaData();
// check if "employee" table is there
        ResultSet tables = dbm.getTables(null, null, DB, null);
        if (tables.next()) {
            flag = true;
            System.out.println("yes");
        } else {
            flag = false;

        }
        conn.close();
        return flag;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuOfRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuOfRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuOfRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuOfRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new menuOfRestaurant().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(menuOfRestaurant.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    int add = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel allTotalLabel;
    private javax.swing.JButton back;
    private javax.swing.JTable drinkTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable mealTable;
    private javax.swing.JLabel menuLabel1;
    private javax.swing.JLabel receiptLabel;
    private javax.swing.JTable receiptTable;
    private javax.swing.JButton reduceButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}