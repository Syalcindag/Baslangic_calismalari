
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sefa
 */
@ManagedBean (name = "giris")
public class ödev extends Baglantı{

   private String username;
   private String password;
   

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   
    public String getSonuc(){
       try {
           
           Connection con;
          con = baglan();
           String sql ="INSERT INTO MEZUNLAR(KULLANICIADI, SIFRE)VALUES(?, ?)";
           PreparedStatement ps;
           ps = con.prepareStatement(sql);
           ps.setString(1, getUsername());
           ps.setString(2, getPassword());
            int durum =ps.executeUpdate();
    if(durum > 0)
    {
        
    }
           
       } catch (SQLException ex) {
           Logger.getLogger(ödev.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return null;
    }

    
    
}
