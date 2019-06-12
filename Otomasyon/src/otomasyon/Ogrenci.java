/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class Ogrenci extends Baglantı implements ProfilDuzenleme2, Menüler{

    Connection con;
    Scanner scan = new Scanner(System.in);
    @Override
    public void profilGuncelleme(int no, String ad, String soyad, int telefon) {
        
        try {
            con = baglan();
            String sql = "UPDATE otomasyon.ogrenci SET ad=? soyad=? telefon=?  WHERE id =?";
            
            PreparedStatement ps =con.prepareStatement(sql);
           // ps.setInt(1, no);
           ps.setString(1, ad);
            ps.setString(2, soyad);
            ps.setInt(3, telefon);

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
       SınavProgramı sınavprogramı = new SınavProgramı();
       DersSecimi derssecimi = new DersSecimi();
       DersProgramı dersprogramı = new DersProgramı();
       Otomasyon otomasyon = new Otomasyon();
        System.out.println("BİLGİ GÜNCELLEME -> [1]\nSINAV PROGRAMI GÖRME -> [2]\nDERS SEÇME ->[3]\nDERS PROGRAMI GÖRME -> [4]\nCIKIŞ ->[5]\n");
     Scanner klavye = new Scanner (System.in);
    int sayi = klavye.nextInt(); 
    switch(sayi){
        case 1:
            ogrenciProfilGüncellemeMenü();
            this.menü();

            break;
        case 2:
            sınavprogramı.sınavProgGörüntülenmesi();
            this.menü();

            break;
        case 3:
            derssecimi.menü();
            this.menü();
            break;
        case 4:
            dersprogramı.dersProgGörüntülenmesi();
            this.menü();
            break;
        case 5:
            otomasyon.girişmenu();
            break;

            default:
                System.out.println("Geçersiz değer girdiniz");              
            }
        
        
    }
    
    public  void ogrenciProfilGüncellemeMenü(){
        System.out.println("Güncellemek istediginiz ogrenci adı:");
        String ad = scan.next();
        System.out.println("Güncellemek istediginiz ogrenci soyadı:");
        String soyad = scan.next();
        System.out.println("Güncellemek istediginiz ogrenci numarası:");
        int no = scan.nextInt();
        System.out.println("Güncellemek istediginiz ogrenci telefon numarası:");
        int telefon = scan.nextInt();
                  profilGuncelleme(no, ad, soyad, telefon);
                  System.out.println("guncellendi");
        
    }
    
}
