/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static odev.Menü.kayitVar;

/**
 *
 * @author Sefa
 */
public class AdminGiris  implements If_admin {
    Baglanti baglanti =  new Baglanti();
    Scanner scan = new Scanner(System.in);
    Connection con = baglanti.baglan();
    Statement sttm = null;
    
    @Override
    public boolean adminGiris(int sifre, String kullaniciadi) {
    
         try {

            sttm = con.createStatement();
            ResultSet rs = sttm.executeQuery("Select * from adminler  ");
            while (rs.next()) {

                if (kullaniciadi.equals(rs.getString(1)) && sifre == rs.getInt(2)) {
                    kayitVar = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(kayitVar) {
             return true;
         }
         return false;
    }

    @Override
    public void kitapEkle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void kitapSil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
