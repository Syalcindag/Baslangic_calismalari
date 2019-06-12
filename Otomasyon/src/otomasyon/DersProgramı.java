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
public class DersProgramı extends Dersler {
    Baglantı baglantı = new Baglantı();
    Connection con;
    Scanner scn =new Scanner(System.in);
    public void dersPolustur(String ders1, String ders2, String ders3, String ders4, String ders5){
       
        con = baglantı.baglan();

        String sql = "INSERT INTO otomasyon.dersprogramı(pazartesi, salı, çarşamba, perşembe, cuma )VALUES(?, ?, ?, ?, ?)";
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
        System.out.println("ders programı olusturuldu");
    }
} catch (SQLException ex) {
    Logger.getLogger(DersProgramı.class.getName()).log(Level.SEVERE, null, ex);

    }
    } 

    public void dersProgGörüntülenmesi(){
         try {
             String ders1, ders2, ders3, ders4, ders5;
             
             con = baglantı.baglan();
             String sql1 = "SELECT * FROM otomasyon.dersprogramı";
             Statement sttm = con.createStatement();
             ResultSet rs = sttm.executeQuery(sql1);
            rs.next();
             ders1 = rs.getString(1);
             ders2 = rs.getString(2);
             ders3 = rs.getString(3);
             ders4 = rs.getString(4);
             ders5 = rs.getString(5);
             System.out.println("Ders programı \n"
                     + ders1 + " \n" + ders2+" \n" + ders3 + " \n"+  ders4+"\n" + ders5);
         } catch (SQLException ex) {
             Logger.getLogger(DersProgramı.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    @Override
    public void menü() {
        super.menü(); //To change body of generated methods, choose Tools | Templates.
       String ders1, ders2, ders3, ders4, ders5;
        System.out.println("pazartesi olacak ders ismini giriniz:");
        ders1 =scn.next();
        System.out.println("salı olacak ders ismini giriniz:");
        ders2 =scn.next();
        System.out.println("çarsamba olacak ders ismini giriniz:");
        ders3 =scn.next();
        System.out.println("perşembe olacak ders ismini giriniz:");
        ders4 =scn.next();
        System.out.println("cuma olacak ders ismini giriniz:");
        ders5 =scn.next();
        dersPolustur(ders1, ders2, ders3, ders4, ders5);
        
    }
    
    
    
}
