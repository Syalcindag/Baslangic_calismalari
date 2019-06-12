/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;

import java.sql.Connection;
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
public class Menü extends Abs_Uyekayit {
   static boolean kayitVar;
    static Scanner scan = new Scanner(System.in);
    static boolean hata;

   @Override
     public void menu() {

        System.out.println("[1] Üye Girisi \n"
                + "[2] Üye Ol\n"
                + "[3] Admin Girisi\n"
                + "[4] Cikis\n"
                + "<-------Secim Yapınız--------->");
    }

   @Override
     public void menuUyelik() {

        System.out.print("Uye numarası giriniz : ");
        uyeid = scan.nextInt();
        Baglanti baglanti = new Baglanti();
        Connection con = baglanti.baglan();
        Statement sttm = null;
        try {

            sttm = con.createStatement();
            ResultSet rs = sttm.executeQuery("Select * from uyelik  ");
            while (rs.next()) {

                if (uyeid == rs.getInt(1)) {
                    hata = true;
                }
            }
            hata = false;
        } catch (SQLException ex) {
            Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (hata) {
            System.out.println("<----Bu uye numarasına ait baska kayıt var !!!---->");
        } else {
            System.out.print("Uye Adi  giriniz : ");
            uyeAdi = scan.next();
            System.out.print("Uye Soyadi giriniz : ");
            uyeSoyadi = scan.next();
            System.out.print("Sifre giriniz : ");
            uyeSifre = scan.next();
            try {
                sttm.execute("insert into uyelik values(" + uyeid + ", '" + uyeAdi + "', '" + uyeSoyadi + "', '" + uyeSifre + "' )");
                System.out.println("\n<-----Uyelik Gerçekleşildi----->\n\n");
                con.close();
                sttm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

   @Override
     public void menuUyeGiris() {
        int uyeId;
        String sifre;
         
        System.out.print("Üye id giriniz : ");
        uyeId = scan.nextInt();
        System.out.print("Üye sifre giriniz : ");
        sifre = scan.next();

        Baglanti baglanti = new Baglanti();
        Connection con = baglanti.baglan();
        Statement sttm = null;
        try {

            sttm = con.createStatement();
            ResultSet rs = sttm.executeQuery("Select * from uyelik  ");
            while (rs.next()) {

                if (uyeId == rs.getInt(1)) {
                    kayitVar = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if (kayitVar) {
            GirisYapildi(uyeId);
        }

    }

    private static void GirisYapildi(int uyeid) {
        int secim;
         int geridon;
        boolean loop = true;
        Baglanti baglanti = new Baglanti();
        Connection con = baglanti.baglan();
        Statement sttm = null;
        while (loop) {
            System.out.println("[1] Kitap Lİstele \n"
                    + "[2] Alinan Kitaplar \n"
                    + "[3] Cikis \n"
                    + "<-------Secim Yapiniz -------->");
            secim = scan.nextInt();

            switch (secim) {
                case 1:
                        try {

                        sttm = con.createStatement();
                         ResultSet rs = sttm.executeQuery("select * from kitap  ");
                        while (rs.next()) {
                            System.out.println("Kitap no : " + rs.getString(1) + " Adi  : " + rs.getString(2)+ " Fiyat : " + rs.getInt(3)+ " tl");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                    System.out.println("[0] Geri Dön");
                    geridon = scan.nextInt();
                    if (geridon == 0) {
                        loop = true;
                    } 
                        
                    break;
                case 2:
                    int kisi;

                    try {

                        sttm = con.createStatement();
                        sttm.execute("select * from alinankitaplar where alankisiid = " + uyeid + "");

                    } catch (SQLException ex) {
                        Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println("[0] Geri Dön");
                    geridon = scan.nextInt();
                    if (geridon == 0) {
                        loop = true;
                    }
                    break;
                case 3:
                    loop = false;
                    break;

            }
        }
    }
}
