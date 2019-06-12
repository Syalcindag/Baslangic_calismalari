
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sefa
 */
public class database {

    public static void main(String[] args) {
        Connection conn= null;
        PreparedStatement sttm = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/isilani ", "sefa", "123");
            String sql = "Select * from isilani";
            sttm = conn.prepareStatement(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
