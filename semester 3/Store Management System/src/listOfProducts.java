
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saber
 */
public class listOfProducts extends javax.swing.JFrame {
/*
    JFrame jf = new JFrame();
    JPanel jp = new JPanel();
    JButton nameButton = new JButton("Edit name");
    public static JTextField name = new JTextField();
    JButton saleButton = new JButton("Sale");
    public static JTextField sale = new JTextField();
    JLabel saleLabel=new JLabel("%");
*/
    /**
     * Creates new form managerPanel
     */
    public listOfProducts() {

        initComponents();
//editwindow();
        try {
            setTables();
        } catch (SQLException ex) {
            Logger.getLogger(listOfProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }/*
public void editwindow()
{
    jf.setSize(400, 300);
        jf.add(jp, BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Manager panel");
        nameButton.setBounds(10, 70, 160, 40);
        name.setBounds(180, 70, 165, 40);
        saleButton.setBounds(10, 140, 160, 40);
        sale.setBounds(180, 140, 135, 40);
        saleLabel.setBounds(330, 140, 30, 40);
        jp.setLayout(null);
        jp.add(nameButton);
        jp.add(name);
        jp.add(saleButton);
        /* saleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        jp.add(sale);
        jp.add(saleLabel);
        jf.setVisible(true);
        //nameButton.addActionListener(new managerPanel() );
    
}
private void saleButtonActionPerformed(java.awt.event.ActionEvent evt) { 
    System.out.println("managerPanel.actionPerformed()");
}
public void actionPerformed(ActionEvent e){
    System.out.println("managerPanel.actionPerformed()");
    
}*/
    public void setTables() throws SQLException {

        DefaultTableModel tvTblModel = new DefaultTableModel();

        tvTblModel.addColumn("Name of Product");
        tvTblModel.addColumn("Manufacturer");
        tvTblModel.addColumn("Resolution");
        tvTblModel.addColumn("Price($)");
        tvTblModel.addColumn("QTY");

        DefaultTableModel refrigeratorTblModel = new DefaultTableModel();

        refrigeratorTblModel.addColumn("Name of Product");
        refrigeratorTblModel.addColumn("Manufacturer");
        refrigeratorTblModel.addColumn("Volume");
        refrigeratorTblModel.addColumn("Price($)");
        refrigeratorTblModel.addColumn("QTY");

        DefaultTableModel acTblModel = new DefaultTableModel();

        acTblModel.addColumn("Name of Product");
        acTblModel.addColumn("Manufacturer");
        acTblModel.addColumn("BTU");
        acTblModel.addColumn("Price($)");
        acTblModel.addColumn("QTY");

        try {

            Connection conn = database.connectManufacturersdb();
            String a = "SELECT * FROM manufacturer";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {
                String name = rs.getString("name");
                Connection manufacturerConn = database.connectManufacturerdb(name);
                String q = "SELECT * FROM " + name;
                Statement stmManufacturer = manufacturerConn.createStatement();
                ResultSet rsManufacturer = stmManufacturer.executeQuery(q);
                while (rsManufacturer.next()) {
                    String type = rsManufacturer.getString("Product");
                    String manufacturer = name;

                    if (type.equals("TV")) {
                        String nameOfProduct = rsManufacturer.getString("model")+ managerEditPanel.nameOfStore()+" Edition";

                        String spec = rsManufacturer.getString("spec");
                        double price;
                        price = rsManufacturer.getDouble("price");
                        int qty = rsManufacturer.getInt("qty");
                        tvTblModel.addRow(new Object[]{nameOfProduct, manufacturer, spec, price, qty});

                    } else if (type.equals("Refrigerator")) {
                        String nameOfProduct = rsManufacturer.getString("model") +managerEditPanel.nameOfStore()+" Edition";
                        manufacturer = name;
                        String spec = rsManufacturer.getString("spec");

                        double price = rsManufacturer.getDouble("price");
                        int qty = rsManufacturer.getInt("qty");

                        refrigeratorTblModel.addRow(new Object[]{nameOfProduct, manufacturer, spec, price, qty});

                    } else if (type.equals("AC")) {
                        String nameOfProduct = rsManufacturer.getString("model") +managerEditPanel.nameOfStore()+" Edition";
                        manufacturer = name;
                        String spec = rsManufacturer.getString("spec");

                        double price = rsManufacturer.getDouble("price");
                        int qty = rsManufacturer.getInt("qty");

                        acTblModel.addRow(new Object[]{nameOfProduct, manufacturer, spec, price, qty});

                    }
                }
            }
            tvTable.setModel(tvTblModel);
            acTable.setModel(acTblModel);
            refrigeratorTable.setModel(refrigeratorTblModel);
        } catch (Exception e) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tvTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        refrigeratorTable = new javax.swing.JTable();
        menuLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        acTable = new javax.swing.JTable();
        menuLabel2 = new javax.swing.JLabel();
        back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        menuLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menuLabel1.setText("TVs");
        menuLabel1.setToolTipText("");

        tvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name of product", "Manufacturer", "Resolution", "Price"
            }
        ));
        jScrollPane3.setViewportView(tvTable);

        refrigeratorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name of product", "Manufacturer", "Volume", "Price"
            }
        ));
        jScrollPane6.setViewportView(refrigeratorTable);

        menuLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menuLabel3.setText("ACs");
        menuLabel3.setToolTipText("");

        acTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name of product", "Manufacturer", "BTU", "Price"
            }
        ));
        jScrollPane5.setViewportView(acTable);

        menuLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        menuLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuLabel2.setText("Refrigerator");
        menuLabel2.setToolTipText("");
        menuLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        back1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back1.setText("back");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menuLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menuLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(menuLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        
    }//GEN-LAST:event_back1ActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //System.out.println(nameOfStore());
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
            java.util.logging.Logger.getLogger(listOfProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listOfProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listOfProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listOfProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listOfProducts().setVisible(true);
            }
        });
        //System.out.println(name.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable acTable;
    private javax.swing.JButton back1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel menuLabel1;
    private javax.swing.JLabel menuLabel2;
    private javax.swing.JLabel menuLabel3;
    private javax.swing.JTable refrigeratorTable;
    private javax.swing.JTable tvTable;
    // End of variables declaration//GEN-END:variables
}
