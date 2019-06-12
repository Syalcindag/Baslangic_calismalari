/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class DersSecimi extends Dersler{
    
     Baglantı baglantı = new Baglantı();
    Connection con;
    Scanner scn =new Scanner(System.in);
    
    public void dersSecimi(String ders1, String ders2, String ders3, String ders4, String ders5){
        
           con = baglantı.baglan();

        String sql = "INSERT INTO otomasyon.dersseçimi(ders1, ders2, ders3, ders4, ders5 )VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps;

 
try {
    ps = con.prepareStatement(sql);
    ps.setString(1, ders1);
    ps.setString(2, ders2);
    ps.setString(3, ders3);
    ps.setString(4, ders4);
    ps.setString(5, ders5);
    
    int durum =ps.executeUpdate();
    if(durum > 0)
    {
        System.out.println("ders seçimi gerçekleşti");
    }
} catch (SQLException ex) {
    Logger.getLogger(DersSecimi.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    public void dersSecimiGoruntule(){
         try {
             String ders1, ders2, ders3, ders4, ders5;
             
             con = baglantı.baglan();
             String sql1 = "SELECT * FROM otomasyon.dersseçimi";
             Statement sttm = con.createStatement();
             ResultSet rs = sttm.executeQuery(sql1);
            rs.next();
             ders1 = rs.getString(1);
             ders2 = rs.getString(2);
             ders3 = rs.getString(3);
             ders4 = rs.getString(4);
             ders5 = rs.getString(5);
             System.out.println("seçtiginiz dersler \n"
                     + ders1 + " \n" + ders2+" \n" + ders3 + " \n"+  ders4+"\n" + ders5);
         } catch (SQLException ex) {
             Logger.getLogger(DersSecimi.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public void menü() {
        super.menü(); //To change body of generated methods, choose Tools | Templates.
          String ders1, ders2, ders3, ders4, ders5;
        System.out.println("Sectiginiz 1. dersi ismini giriniz:");
        ders1 =scn.next();
        System.out.println("sectiginiz 2. dersi ismini giriniz:");
        ders2 =scn.next();
        System.out.println("sectiginiz 3. dersi ismini giriniz:");
        ders3 =scn.next();
        System.out.println("sectiginiz 4. dersi ismini giriniz:");
        ders4 =scn.next();
        System.out.println("sectiginiz 5. dersi ismini giriniz:");
        ders5 =scn.next();
        dersSecimi(ders1, ders2, ders3, ders4, ders5);
        dersSecimiGoruntule();
    }
    
    
}
