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
import static odev.Menü.kayitVar;
import static odev.Menü.scan;

/**
 *
 * @author Sefa
 */
public class adminMenu extends AdminGiris {

    Scanner scan = new Scanner(System.in);
    Baglanti baglanti = new Baglanti();
    Connection con = baglanti.baglan();
    Statement sttm = null;
    int secim;

    public void menu() {
        boolean loop = true;
        int geridon;

        while (loop) {
            System.out.println("[1] Üyeleri Gör \n"
                    + "[2] Kitap ekle \n"
                    + "[3] Kitap sil \n"
                    + "[4] Geri Dön\n"
                    + "<------------ Secim Yapiniz --------->\n");
            secim = scan.nextInt();
            switch (secim) {
                case 1:

                    try {

                        sttm = con.createStatement();
                        ResultSet rs = sttm.executeQuery("Select * from uyelik  ");
                        while (rs.next()) {
                            System.out.println("Adi : " + rs.getString(2) + "  Soyadi  : " + rs.getString(3));

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Odev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     System.out.println("\n\n[0] Geri Dön\n");
                    geridon = scan.nextInt();
                    if (geridon == 0) {
                        loop = true;
                    } 
                    break;
                case 2:
                    int kno, fiyat;
                    String kAdi;
                    System.out.print("Kitap id giriniz : ");
                    kno = scan.nextInt();
                    System.out.print("Kİtap adi giriniz : ");
                    kAdi =  scan.next();
                    System.out.print("\nKİtap fiyati giriniz : ");
                    fiyat =  scan.nextInt();
            {
                try {
                    sttm = con.createStatement();
                    sttm.execute("insert into kitap values("+ kno +", '"+ kAdi +"', "+ fiyat +")");
                    System.out.println("\n Kitap Eklendi \n");
                    sttm.close();
                    con.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(adminMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
              System.out.println("\n\n[0] Geri Dön\n");
                    geridon = scan.nextInt();
                    if (geridon == 0) {
                        loop = true;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    loop = false;
                    break;
            }

            System.out.println("");
        }
    }

    public void girisSorgu() {
        boolean kayitVarMi;
        int sifre;
        String kullaniciadi;
        System.out.print("Kullanıcı Adi giriniz : ");
        kullaniciadi = scan.next();
        System.out.print("Sifre giriniz : ");
        sifre = scan.nextInt();
        kayitVarMi = adminGiris(sifre, kullaniciadi);
        if (kayitVarMi) {
            menu();
        }
    }
}
