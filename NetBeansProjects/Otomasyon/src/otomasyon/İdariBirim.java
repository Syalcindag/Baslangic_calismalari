/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

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
public class İdariBirim extends Baglantı implements ProfilDuzenleme1,Menüler{

    Connection con;
     Scanner scan = new Scanner(System.in);
    @Override
    public void kisiKaydetme(int no, String ad, String soyad, int telefon) {
        String sql ="INSERT INTO otomasyon.ogrenci(Id, ad, soyad, telefon )VALUES(?, ?, ?, ?)";
        PreparedStatement ps;
       
 con =baglan();
try {
    ps = con.prepareStatement(sql);
    ps.setInt(1, no);
    ps.setString(2, ad);
    ps.setString(3, soyad);
    ps.setInt(4, telefon);
    
    int durum =ps.executeUpdate();
    if(durum > 0)
    {
        System.out.println("Ogrenci eklendi");
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
                System.out.println("Ogrenci basarı ile silindi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ogretmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void menü() {
    Ogretmen ogretmen = new Ogretmen();
    SınavProgramı sınavProgramı =new SınavProgramı();
    Otomasyon otomasyon = new Otomasyon();
System.out.println("ÖĞRENCİ EKLEME -> [1]\nÖĞRENCİ SİLME -> [2]\nÖĞRETMEN EKLEME -> [3]\nÖĞRETMEN EKLEME -> [4]\nSINAV PROGRAMI HAZIRLAMA -> [5]\nÇIKIŞ -> [6]");
       Scanner klavye = new Scanner (System.in);
    int sayi = klavye.nextInt(); 
    switch(sayi){
            case 1:
                    ogrenciKaydetmeMenü();
                    this.menü();
                  break;
            case 2:
                ogrenciSilmeMenü();
                this.menü();

                  break;
            case 3:
                  ogretmen.ogretmenKaydetmeMenü();
                    this.menü();

                  break;
            case 4:
                ogretmen.ogretmenSilmeMenü();
                    this.menü();
                break;
            case 5:
                 sınavProgramı.menü();
                    this.menü();
                break;
            case 6:
                otomasyon.girişmenu();//geri döndürüür
            default:
                System.out.println("Geçersiz değer girdiniz");              
            }
    }
    
    public  void ogrenciKaydetmeMenü(){
        System.out.println("Eklemek istediginiz ogrencinin adı:");
        String ad = scan.next();
        System.out.println("Eklemek istediginiz ogrencinin soyadı:");
        String soyad = scan.next();
        System.out.println("Eklemek istediginiz ogrencinin numarası:");
        int no = scan.nextInt();
        System.out.println("Eklemek istediginiz ogrencinin telefon numarası:");
        int telefon = scan.nextInt();
                  kisiKaydetme(no, ad, soyad, telefon);
        System.out.println("eklendi");
    }
    
    public void ogrenciSilmeMenü(){
                
        
        System.out.println("Eklemek istediginiz ogrencinin numarası:");
        int no = scan.nextInt();
        kisiSilme(no);
                 System.out.println("silindi");
    }
}
