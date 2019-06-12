/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class DersAlma extends Baglantı implements Menü{
    
    String host = "jdbc:derby://localhost:1527/admin";
        String uName ="abc";
        String uPass = "abc";
        Scanner scan =new Scanner(System.in);
    
        Ogrenciİşleri ogrisleri = new Ogrenciİşleri();
    @Override
    public void menü() {
        System.out.println("Ogrenci numaranızı girin ve ders secimine baslayınız");
        int a = scan.nextInt();
        System.out.println("Ders seçimi yapınız\n"
                + "almak istediginiz ders için [ 1 ] istemiyorsanız  [ 0 ]\n");
        System.out.println("lojik devre ve tasarımı ");
        int b = scan.nextInt();
        System.out.println("Devreler ve sistemler ");
        int c = scan.nextInt();
        System.out.println("nesneye yönelik programlama ");
        int d = scan.nextInt();
        
        System.out.println("Olasılık ");
        int e = scan.nextInt();
        dersAlmaIşlemleri(a, b, c, d, e);
        System.out.println("Aldıgınız dersler");
        alınanDersler(a);
        ogrisleri.menü();

    }
    
    public void dersAlmaIşlemleri(int a, int b, int c, int d, int e){
        
         Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException ex) {
            Logger.getLogger(DersAlma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql ="INSERT INTO abc.dersalma(id, lojik, devreler, nesne, olasilik)VALUES(?, ?, ?, ?, ?) ";
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setInt(2, b);
            ps.setInt(3, c);
            ps.setInt(4, d);
            ps.setInt(5, e);
            
            
            int sonuc = ps.executeUpdate();
            if(sonuc > 0)
            {
                System.out.println("ders secimi tamamlandı");
            }


        } catch (SQLException ex) {
            Logger.getLogger(DersAlma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
 public void alınanDersler(int no){
        try {
            Connection conn = null;
            
            try {
                conn = DriverManager.getConnection(host, uName, uPass);
            } catch (SQLException ex) {
                Logger.getLogger(DersAlma.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM ABC.dersalma";
            
            Statement sttm =conn.createStatement();
            ResultSet rs =sttm.executeQuery(sql);
            rs.next();
            while(no != rs.getInt(1)){
                rs.next();
            }
            
            if(rs.getInt(2) != 0){
                System.out.println("lojik devre ve tasarımı");
            }
            if (rs.getInt(3) != 0){
                System.out.println("Devreler ve sistemler");
            }
            if(rs.getInt(4) != 0){
                System.out.println("Nesneye yönelik programlama");
            }
            if(rs.getInt(5) != 0){
                System.out.println("Veri yapıları");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DersAlma.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
 }

    
}
