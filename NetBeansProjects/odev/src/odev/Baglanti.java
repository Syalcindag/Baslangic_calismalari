/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class Baglanti {
    
     String url = "jdbc:derby://localhost:1527/kayitdb";
    
    public Connection baglan() {
        Connection con = null; 
         try {
             con= DriverManager.getConnection(url);
         } catch (SQLException ex) {
             Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return con;
    }
    
}
