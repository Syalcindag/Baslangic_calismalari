
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static void main(String[] args) throws SQLException{
        
        Connection con = null ;
        String host="jdbc:derby://localhost:1527/mezun";
        String uName="sefa";
        String uPass="123";
        String kullanıcıadı=null;
        String sifre=null;
        ödev ödev = new ödev();
        kullanıcıadı = ödev.getUsername().toString();
        sifre = ödev.getPassword().toString();
        
        
            String sql = "INSERT INTO MEZUNLAR(KULLANICIADI, SIFRE) VALUES('sefa','yalbkvnl'";
            PreparedStatement sttm =con.prepareStatement(sql);
            int rset=  sttm.executeUpdate();
            
        
        
        
        
    }
}
