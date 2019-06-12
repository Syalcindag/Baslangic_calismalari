/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*  Sefa Yalçındağ
 *  no: 1306150069
 *  
 *
 */
package projejava;

/**
 * @param args the command line arguments
 */
import java.util.Scanner;

/**
 *
 * @author Sefa
 */
public class Ogrenciİşleri extends Admin implements Menü{

    
    
     public static void main(String[] args) {
         
         Scanner scan = new Scanner(System.in);
         Ogrenciİşleri ogrişleri = new Ogrenciİşleri();
         ogrişleri.menü();

        
           
     }
     
     
    @Override
    public void menü() {
         
        System.out.println("Menülerden yapmak istediginiz işlemi seçerek devam edebilirsiniz.");
        System.out.println("[ 1 ] Ögrenci işleri \n"
                + "[ 2 ] Ögretim üyesi işleri  \n"
                + "[ 3 ] Admin girişi \n"
                + "[ 4 ] çıkış");
        Scanner scan = new Scanner(System.in);
        OgretimUyesi oUye = new OgretimUyesi();
        Ogrenci ogr = new Ogrenci();
           int secim = scan.nextInt();
        switch(secim){
            case 1:
                System.out.println("*********************************************");
                System.out.println("Ögrenci sayısı: " + ogrenciGirişi);
                ogr.menü();
                this.menü();
                break;
                
            case 2:
                System.out.println("*********************************************");
                System.out.println("Ögretim üyesi sayısı: " + ögretiminÜyesigirişi);
               oUye.menü();
               this.menü();
                break;
            case 3:
                super.menü();
                super.menü();
                this.menü();
                break;
            case 4:
                
                break;
        }
                
        }
    }
 
    
    
     

