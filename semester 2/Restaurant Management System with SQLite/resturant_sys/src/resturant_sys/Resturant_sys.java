/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package resturant_sys;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import resturant_sys.firstMenu;

/**
 *
 * @author saber
 */
public class Resturant_sys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("hello");
            firstMenu test = new firstMenu();
            test.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Resturant_sys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
