package resturant_sys;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                TH thread = new TH(socket);
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    static class TH extends Thread {

        Socket socket;

        public TH(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataInputStream input = new DataInputStream(this.socket.getInputStream());
                System.out.println(input.readUTF());
            } catch (IOException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Connection connectClientdb() {
        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:client.db");

            return conn;
        } catch (Exception e) {

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

    public static Connection connectMenudb() {
        try {
            Class.forName("org.sqlite.JDBC");
            String nameOfDB = listOfRest.getNameOfdb();

            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + nameOfDB + ".db");

            return conn;
        } catch (Exception e) {

            return null;

        }
    }

}
