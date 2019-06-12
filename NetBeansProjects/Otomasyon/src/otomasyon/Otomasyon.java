/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.util.Scanner;


/**
 *
 * @author Sefa
 */
public class Otomasyon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Otomasyon otomasyon = new Otomasyon();
       otomasyon.girişmenu();
        
    }
    public void girişmenu(){
        Ogrenci ogrenci = new Ogrenci();
        Ogretmen ogretmen = new Ogretmen();
        İdariBirim idaribirim = new İdariBirim();
    System.out.println("ÖĞRENCİ -> [1]\nÖĞRETMEN -> [2]\nADMİN -> [3]\nCIKIŞ ->[4]");
    Scanner klavye = new Scanner (System.in);
    int sayi = klavye.nextInt(); 
    switch(sayi){
            case 1:
                  ogrenci.menü();
                  break;
            case 2:
                  ogretmen.menü();
                  break;
            case 3:
                  idaribirim.menü();
                  break;
            case 4:
                break;
            default:
                System.out.println("Geçersiz değer girdiniz");              
            }
    
}

}
