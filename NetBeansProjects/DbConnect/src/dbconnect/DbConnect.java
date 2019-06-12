/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Sefa
 */
public class DbConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String host = "jdbc:derby://localhost:1527/ögrenci";
        String uName = "sefa";
        String uPass = "123";

        
        
        
        
        Connection con = null;
        try {
            con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException ex) {
            System.out.println("hata: " + ex.getMessage());
        }
        
        
        try {
           
           /*
           String name = "dekmme";
            
          String sql1 = "INSERT INTO SEFA.ÜYELER (id, ad ,soyad) VALUES (?,?,?)";
 
PreparedStatement statement = con.prepareStatement(sql1);
statement.setInt(1, 69);
statement.setString(2, name);
statement.setString(3, "Bjbcdkkl");

 
int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
    System.out.println("A new user was inserted successfully!");
}*/
           
           
         
           
           
           
           
           
           
           
           
           
           
           
           
           
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM ÜYELER";
            ResultSet rs = stmt.executeQuery(sql);
           
           
           
           
             if(rs.next())
            {
                int id_col =rs.getInt(2);
                String isim =rs.getString(2);
                String soyisim = rs.getString("soyad");
                
                String p =id_col + " " + isim + " " + soyisim;
                System.out.println(p);
                
            }
            else
            {
                System.out.println("kayıt gerçekleşmedi");
            }
            
           
        } catch (SQLException ex) {
            System.out.println("hata: " + ex.getMessage());
        }
    }
    
}
