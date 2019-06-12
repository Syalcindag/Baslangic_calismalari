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
public class Ogretmen extends Baglantı implements ProfilDuzenleme1,Menüler,ProfilDuzenleme2{

    Connection con;
    Scanner scan =new Scanner(System.in);
    @Override
    public void kisiKaydetme(int no, String ad, String soyad, int telefon) {
        con =baglan();
        String sql ="INSERT INTO otomasyon.ogretmen(Id, ad, soyad, telefon )VALUES(?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, no);
            ps.setString(2, ad);
            ps.setString(3, soyad);
            ps.setInt(4, telefon);
            
            int durum =ps.executeUpdate();
            if(durum > 0)
            {
                System.out.println("ogretmen  eklendi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(İdariBirim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void kisiSilme(int no) {
        
        try {
            con =baglan();
            String sql = "DELETE FROM otomasyon.ogrenci WHERE id = ?";
            
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, no);
            int sonuc = ps.executeUpdate();
            if(sonuc > 0)
            {
                System.out.println("Ogretmen basarı ile silindi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ogretmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public void profilGuncelleme(int no, String ad, String soyad, int telefon) {
        
        try {
            con = baglan();
            String sql = "UPDATE otomasyon.ogretmen SET ad =? soyad = ? telefon = ?  WHERE id = ?";
            
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, no);
            ps.setString(2, ad);
            ps.setString(3, soyad);
            ps.setInt(4, telefon);

            int rowupdate = ps.executeUpdate();
            if(rowupdate > 0)
            {
                System.out.println("güncelleştirme gerceklesti");
            }   } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void menü() {
        DersProgramı dersprogramı = new DersProgramı();
        SınavProgramı sınavprogramı = new SınavProgramı();
        Otomasyon otomasyon = new Otomasyon();
         System.out.println("BİLGİ GÜNCELLEME -> [1]\nSINAV PROGRAMI HAZIRLAMA -> [2]\nDERS PROGRAMI AYARLAMA ->[3]\nSINAV PROGRAMI GÖRME ->[4]\nCIKIŞ ->[5]");
       Scanner klavye = new Scanner (System.in);
    int sayi = klavye.nextInt(); 
    switch(sayi){
        case 1:
            ogretmenProfilGüncellemeMenü();
            this.menü();

            break;
        case 2:
            sınavprogramı.menü();
            this.menü();
            break;
        case 3:
            dersprogramı.menü();
            this.menü();
            break;
        case 4:
            sınavprogramı.sınavProgGörüntülenmesi();
            this.menü();
            break;
        case 5:
            otomasyon.girişmenu();//geri döndürüür
        default:
            System.out.println("Geçersiz değer girdiniz");
            }
    }

    public  void ogretmenKaydetmeMenü(){
        System.out.println("Eklemek istediginiz ogretmen adı:");
        String ad = scan.next();
        System.out.println("Eklemek istediginiz ogretmen soyadı:");
        String soyad = scan.next();
        System.out.println("Eklemek istediginiz ogretmen numarası:");
        int no = scan.nextInt();
        System.out.println("Eklemek istediginiz ogretmen telefon numarası:");
        int telefon = scan.nextInt();
                  kisiKaydetme(no, ad, soyad, telefon);
        
    }
    
    public void ogretmenSilmeMenü(){
                
        
        System.out.println("Eklemek istediginiz ogretmenin numarası:");
        int no = scan.nextInt();
        kisiSilme(no);
                 System.out.println("silindi");
    }
   
    public  void ogretmenProfilGüncellemeMenü(){
        System.out.println("Güncellemek istediginiz ogretmen adı:");
        String ad = scan.next();
        System.out.println("Güncellemek istediginiz ogretmen soyadı:");
        String soyad = scan.next();
        System.out.println("Güncellemek istediginiz ogretmen numarası:");
        int no = scan.nextInt();
        System.out.println("Güncellemek istediginiz ogretmen telefon numarası:");
        int telefon = scan.nextInt();
                  profilGuncelleme(no, ad, soyad, telefon);
                  System.out.println("guncellendi");
        
    }
    
}
