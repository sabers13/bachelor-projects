
import java.sql.*;
import java.sql.DriverManager;
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
public class database {
    
    public static  Connection connectClientdb() {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:client.db");
            return conn;
        } catch (Exception e) {
 System.out.println("project4samples.database.connectManagerdb()");
            return null;

        }
       
    }

    public static Connection connectManagerdb() {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:manager.db");

            return conn;
        } catch (Exception e) {

            return null;

        }
    }
    public static Connection connectManufacturersdb() {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:manufacturer.db");
            //System.out.println("ex");

            return conn;
        } catch (Exception e) {

            return null;

        }
    }
    public static Connection connectManufacturerdb(String name) {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + name+ ".db");
            /*
            String a = "SELECT * FROM manufacturer";

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(a);
        while (rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }
*/
            return conn;
        } catch (Exception e) {
                System.out.println("e");

            return null;

        }
    }
     public static Connection updateManufacturerPricedb(String manufacturer,double price,String name) {
    try {
            Connection conn=connectManufacturerdb(manufacturer);
           // String a="Select *from client";
           String sql = "UPDATE "+manufacturer+" SET price = ? WHERE model =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, price);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return null;
     }
     public static Connection updateManufacturerQtydb(String manufacturer,int qty,String name) {
    try {
            Connection conn=connectManufacturerdb(manufacturer);
           // String a="Select *from client";
           String sql = "UPDATE "+manufacturer+" SET qty = ? WHERE model =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qty);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            
        }
        return null;
     }
}

