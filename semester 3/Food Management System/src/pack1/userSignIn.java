package pack1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import pack1.chef.chefPanel;
import pack1.boss.bossPanel;
import pack1.cook.cookPanel;
import pack1.client.clientPanel;
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
        signUpButton = new javax.swing.JButton();
        signInButton = new javax.swing.JButton();

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

        signUpButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUpButton.setText("Sign up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 130, 40));

        signInButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signInButton.setText("Sign in");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientUsernameFieldActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
       userSignUp userSignUp=new userSignUp();
    userSignUp.setVisible(true);
    this.setVisible(false);
                
	 
        
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        if( user.usernameCheck()){
        if(user.type.equals("client")){
        clientPanel clientPanel = new clientPanel();
        clientPanel.setVisible(true);
        this.setVisible(false);
        
        }
        else if(user.type.equals("cook")){
            cookPanel cookPanel = new cookPanel();
        cookPanel.setVisible(true);
        this.setVisible(false);
        }
        else if(user.type.equals("chef")){
            chefPanel chefPanel = new chefPanel();
        chefPanel.setVisible(true);
        this.setVisible(false);
        }
        else if(user.type.equals("boss")){
            bossPanel bossPanel = new bossPanel();
        bossPanel.setVisible(true);
        this.setVisible(false);
        }
        }
        
    }//GEN-LAST:event_signInButtonActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userSignIn().setVisible(true);
            }
        });
    }
    /*public static String nameOFUser(){
        
        return clientUsernameField.getText();
        
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPasswordField clientPasswordField;
    private javax.swing.JLabel clientPasswordLabel;
    public static javax.swing.JTextField clientUsernameField;
    private javax.swing.JLabel clientUsernameLabel;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    // End of variables declaration//GEN-END:variables

}
