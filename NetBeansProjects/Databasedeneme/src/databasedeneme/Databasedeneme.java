/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedeneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Sefa
 */
public class Databasedeneme {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
       
        
         //baglantı bolumu
        String host = "jdbc:derby://localhost:1527/deneme";
        String uName ="deneme";
        String uPass = "deneme";
        Connection conn = null;
        try{
          conn=  DriverManager.getConnection(host, uName, uPass);
        }
        catch(SQLException ex)
        {
            System.out.println("hata:" + ex.getMessage());
        }
      //baglantı bolumunun bıtimi
      
      //tabloya ekleme
      
      
//        
//            String sql ="INSERT INTO DENEME.DENEME(Id, ISIM )VALUES(?, ?)";
//            PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(sql);
//             ps.setInt(1, 5556);
//            ps.setString(2, "sssefaaaaaa");
//            
//            int durum =ps.executeUpdate();
//            if(durum > 0)
//            {
//                System.out.println("basarı ile eklendi");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Databasedeneme.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           
       
      //tablo ekleme bitiş

      
//      //tablo okuma başlangıcı
//       String sql1 = "SELECT * FROM DENEME";
//        Statement sttm = conn.createStatement();
//        ResultSet rs = sttm.executeQuery(sql1);
//        rs.next();
//        int sıra = rs.getInt(1);
//        
//        
//        int id =rs.getInt("ID");
//        System.out.println("sıra: "+ sıra +"id = " + id);
//        rs.next();
//        String isim = rs.getString(2);
//        System.out.println("isim: " +isim);
//        //tablo okuma bitimi
//        
//        //tablo da veri güncelleme
//        String sql2 ="UPDATE DENEME SET Id =?  WHERE Isim =?";
//        
//        PreparedStatement ps =conn.prepareStatement(sql2);
//        ps.setString(1, "101");
//        ps.setString(2, "sefaa");
//        int rowupdate = ps.executeUpdate();
//        if(rowupdate > 0)
//        {
//            System.out.println("basarı ile eklendi");
//        }
//        //tabloda veri güncelleme sonu

//
//        //tsblodan veri silme
//        String sql = "DELETE FROM deneme WHERE id = ?";
//        
//        PreparedStatement ps =conn.prepareStatement(sql);
//        ps.setString(1, "100");
//        int sonuc = ps.executeUpdate();
//        if(sonuc > 0)
//        {
//            System.out.println("basarı ile silindi");
//        }
//        //tablodan veri silme sonu
    }
    
}
