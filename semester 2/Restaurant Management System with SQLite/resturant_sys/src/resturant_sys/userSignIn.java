/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant_sys;

import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Saber
 */
public class userSignIn extends javax.swing.JFrame {

    /**
     * Creates new form userSignIn
     */
    public userSignIn() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPasswordLabel = new javax.swing.JLabel();
        clientUsernameLabel = new javax.swing.JLabel();
        clientUsernameField = new javax.swing.JTextField();
        clientPasswordField = new javax.swing.JPasswordField();
        signInClientButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientPasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clientPasswordLabel.setText("Password");
        getContentPane().add(clientPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 50));

        clientUsernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clientUsernameLabel.setText("Username");
        getContentPane().add(clientUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 50));

        clientUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientUsernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(clientUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 140, 30));
        getContentPane().add(clientPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, 30));

        signInClientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signInClientButton.setText("Sign in");
        signInClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signInClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 130, 40));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientUsernameFieldActionPerformed

    private void signInClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInClientButtonActionPerformed
        try {
             Connection conn=database.connectClientdb();
	    String a="Select *from client where username='"+clientUsernameField.getText()+"' and password='"+clientPasswordField.getText()+"'";
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery(a);
		if(rs.next()){
			
                        listOfRest listOfRestaurats;
                 try {
                     listOfRestaurats = new listOfRest();
                                             listOfRestaurats.setVisible(true);

                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(userSignIn.class.getName()).log(Level.SEVERE, null, ex);
                 }
                        this.setVisible(false);
                        
                }
		else
			JOptionPane.showMessageDialog(null, "Username or Password is incorrecy");
                
	        conn.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
    }//GEN-LAST:event_signInClientButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    firstMenu backToFirstMenu=new firstMenu();
    backToFirstMenu.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(userSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userSignIn().setVisible(true);
            }
        });
    }
    public static String nameOFUser(){
        
        return clientUsernameField.getText();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPasswordField clientPasswordField;
    private javax.swing.JLabel clientPasswordLabel;
    public static javax.swing.JTextField clientUsernameField;
    private javax.swing.JLabel clientUsernameLabel;
    private javax.swing.JButton signInClientButton;
    // End of variables declaration//GEN-END:variables

}