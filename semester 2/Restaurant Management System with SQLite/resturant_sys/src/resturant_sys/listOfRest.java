/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant_sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static resturant_sys.userSignIn.clientUsernameField;

/**
 *
 * @author Saber
 */
public class listOfRest extends javax.swing.JFrame {

    /**
     * Creates new form listOfRestaurant
     */
    public listOfRest() throws ClassNotFoundException, SQLException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws ClassNotFoundException, SQLException {

        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantsList = new javax.swing.JList<>();

        selectLabel = new javax.swing.JLabel();
        listOfRestaurantsLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        restaurantsList = new JList(getRestaurantsName());
        restaurantsList.setFont(new java.awt.Font("Tahoma", 0, 18));

        jScrollPane1.setViewportView(restaurantsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 280, 310));

        selectLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectLabel.setText("Select a restaurant then click on next!");
        selectLabel.setToolTipText("");
        getContentPane().add(selectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, 30));

        listOfRestaurantsLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        listOfRestaurantsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listOfRestaurantsLabel.setText("List of restaurants");
        listOfRestaurantsLabel.setToolTipText("");
        getContentPane().add(listOfRestaurantsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 40));

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextButton.setText("Next");
        nextButton.setToolTipText("");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    nextButtonActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(listOfRest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 120, 40));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.setToolTipText("");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 40));

        pack();
    }// </editor-fold>                        

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (restaurantsList.getSelectedIndex() != -1) {

            Connection conn = database.connectMenudb();
            String nameOfDB = listOfRest.getNameOfdb();
            String a = "Select *from " + nameOfDB;

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);

            menuOfRestaurant menu = new menuOfRestaurant();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        userSignIn clientSignIn = new userSignIn();
        clientSignIn.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(listOfRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listOfRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listOfRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listOfRest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new listOfRest().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(listOfRest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(listOfRest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static DefaultListModel getRestaurantsName() throws ClassNotFoundException, SQLException {

        Connection conn = database.connectManagerdb();
        String a = "Select *from manager";

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(a);

        DefaultListModel restaurantsListModel;

        restaurantsListModel = new DefaultListModel();
        String element;
        while (rs.next()) {
            element = rs.getString("nameOfRestaurant");
            restaurantsListModel.addElement(element);
        }
        return restaurantsListModel;
    }

    public static String getNameOfdb() {

        String nameOfDB = null;
        if (restaurantsList.getSelectedIndex() != -1) {
            nameOfDB = restaurantsList.getSelectedValue();
        }
        return nameOfDB;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listOfRestaurantsLabel;
    private javax.swing.JButton nextButton;
    public static javax.swing.JList<String> restaurantsList;
    private javax.swing.JLabel selectLabel;
    // End of variables declaration                   

}