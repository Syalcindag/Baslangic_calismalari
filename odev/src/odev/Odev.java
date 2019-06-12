/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class Odev {

    /**
     * @param args the command line arguments
     */

   
   

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);  //Kullanıcıdan verileri almak için scanner nesnesini kullanıyoruz. 
        int secim, secim2;
        boolean loop = true;
        Menü m = new Menü();
        adminMenu admin =  new adminMenu();
        while (loop) {
            m.menu();
            secim = m.scan.nextInt();
            switch (secim) {
                case 1:
                  m.menuUyeGiris();
                    break;
                case 2:
                      m.menuUyelik();
                    System.out.println("[1] menü\n"
                            + "[2] Cikis");
                    secim2 = m.scan.nextInt();
                    if(secim2 == 1){
                        loop = true;
                    } else {
                        loop = false;
                    }
                    break;
                case 3:
                    admin.girisSorgu();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Gecersiz işlem...");
                    break;
            }
        }
    }

  

    

}
