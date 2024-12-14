
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saber
 */
public class managerEditPanel {

    JFrame jf = new JFrame();
    JPanel jp = new JPanel();
    JButton nameButton = new JButton("Edit name");
    JButton backButton = new JButton("Back");
    public static JTextField name = new JTextField();
    JButton saleButton = new JButton("Sale");
    public static JTextField sale = new JTextField();
    JLabel saleLabel = new JLabel("%");

    public managerEditPanel() {
        editwindow();
    }

    public void editwindow() {
        jf.setSize(400, 300);
        jf.add(jp, BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setTitle("Manager panel");
        nameButton.setBounds(10, 30, 160, 40);
        name.setBounds(180, 30, 165, 40);
        name.setText("Sample");
        saleButton.setBounds(10, 100, 160, 40);
        sale.setBounds(180, 100, 135, 40);
        saleLabel.setBounds(330, 100, 30, 40);
        backButton.setBounds(10, 170, 160, 40);
        jp.setLayout(null);
        jp.add(nameButton);
        jp.add(name);
        jp.add(saleButton);
        jp.add(backButton);
        nameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("name");;
            }
        });
        
        saleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sale");;
                if(isNumeric(sale.getText())){
                   double salesPercentage = Double.parseDouble(sale.getText()); 
                   if(salesPercentage<100){
                sale(salesPercentage);
                   JOptionPane.showMessageDialog(null, "sale has been applied!");
                   }
                   else
                       JOptionPane.showMessageDialog(null, "sale value is too high!");
                }
                else
                    JOptionPane.showMessageDialog(null, "sale value is not valid!");
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");;
            }
        });
                        /* saleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });*/
                        jp.add(sale);
                        jp.add(saleLabel);
                        jf.setVisible(true);
                        //nameButton.addActionListener(new managerPanel() );

                    }
    public static String nameOfStore(){
        
        return name.getText();
        
    }
    
    public void sale(double salesPercentage){
        
        try {

            Connection conn = database.connectManufacturersdb();
            String a = "SELECT * FROM manufacturer";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(a);
            while (rs.next()) {
                int rowCount = 0;
                String name = rs.getString("name");
                Connection manufacturerConn = database.connectManufacturerdb(name);
                String q = "SELECT * FROM " + name;
                Statement stmManufacturer = manufacturerConn.createStatement();
                ResultSet rsManufacturer = stmManufacturer.executeQuery(q);
                while (rsManufacturer.next()) {
                    double price = rsManufacturer.getDouble("price");
                    price=price*((100-salesPercentage)/100);
                    //String manufacturer = name;
                    rowCount++;
                                    System.out.println(price);
                                     System.out.println(name);
                                                                          System.out.println(rowCount);


                    String sql = "UPDATE "+name+" SET price = ? WHERE ID =?";
            PreparedStatement pstmt = manufacturerConn.prepareStatement(sql);
            pstmt.setDouble(1, price);
            pstmt.setInt(2, rowCount);
            pstmt.executeUpdate();
                }
            }
            } catch (Exception e) {

        }

    }
private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
                    public static void main(String args[]) {
                        managerEditPanel run = new managerEditPanel();
                    }

                }
