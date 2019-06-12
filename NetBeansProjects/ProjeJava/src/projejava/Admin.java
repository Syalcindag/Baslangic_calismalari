/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

import java.util.Scanner;

/**
 *
 * @author Sefa
 */
public class Admin extends GirişBilgisi implements Menü{

    
    @Override
    public void menü() {
        System.out.println("**************************************************************");
                System.out.println("[ 1 ] Üye kaydı\n"
                        + "[ 2 ] Üye silme\n"
                        + "[ 3 ] Üye güncelleme\n"
                        + "[ 4 ] Ders programı\n"
                        + "[ 5 ] geri\n");
        Scanner scan = new Scanner(System.in);
        Ogrenci ogr = new Ogrenci();
        OgretimUyesi ogrUye1 = new OgretimUyesi();
                int secim8 = scan.nextInt();
                switch(secim8){
                    case 1:
                        System.out.println("*******************************************************");
                        System.out.println("Üye kaydı işlemlerine devam etmek için secim yapınız");
                        System.out.println("[ 1 ]öğrenci üye kaydı\n"
                                + "[ 2 ] Ögretim üyesi  kaydı \n"
                                + "[ 3 ] geri\n");
                        Scanner scan1 = new Scanner(System.in);
                        int secim4 = scan1.nextInt();
                        switch(secim4){
                            case 1:
                                String isim,soyisim, mail;
                                int no;
                                System.out.println("Öğrencinin adını giriniz");
                                isim = scan.next();
                                System.out.println("Öğrencinin soyismini giriniz");
                                soyisim = scan.next();
                                System.out.println("Ögrencinin numarasını giriniz");
                                no = scan.nextInt();
                                System.out.println("Ögrencinin mail adresini  giriniz");
                                mail = scan.next();

                                Ogrenci ogr1 = new Ogrenci();
                                ogr1.kaydetme(isim, soyisim, no, mail);
                                ogrenciGirişi++;
                                
                                break;
                            case 2:
                                
                                System.out.println("Öğretim üyesinin adını giriniz");
                                isim = scan.next();
                                System.out.println("Öğretim üyesinin soyismini giriniz");
                                soyisim = scan.next();
                                System.out.println("Ögretim üyesinin id  giriniz");
                                no = scan.nextInt();
                                System.out.println("ögretim üyesi mail adresini giriniz");
                                mail =scan.next();
                                OgretimUyesi ogrUye =new OgretimUyesi();
                                ogrUye.kaydetme(isim, soyisim, no, mail);
                                ögretiminÜyesigirişi++;
                                break; 
                            case 3:
                                
                                break;
                        }
                        
                        break;
                    case 2:
                        System.out.println("********************************************************");
                        System.out.println("Üye silme işlemlerine devam etmek için seçim yapınız");
                        System.out.println("[ 1 ]öğrenci üye silme \n"
                                + "[ 2 ]öğretim üyesi silme\n"
                                + "[ 3 ] geri\n");
                        int secim5 =scan.nextInt();
                        switch(secim5){
                            case 1:
                                System.out.println("silmek istediğiniz öğrencinin numarasını giriniz");
                                int ogrNo = scan.nextInt();
                                ogr.silme(ogrNo);
                                ogrenciGirişi--;
                                break;
                            case 2:
                                System.out.println("silmek istediginiz ögretim üyesinin numarasını giriniz");
                                int ogrUyeNo =scan.nextInt();
                                
                                ogrUye1.silme(ogrUyeNo);
                                ögretiminÜyesigirişi--;
                                break;
                            case 3:
                                this.menü();
                                break;
                        
                        }
                    break;
                    case 3:
                        System.out.println("**************************************************************");
                        System.out.println("Üye güncelleme işlemninde devam etmek için seçim yapınız");
                        System.out.println("[ 1 ]Ögrenci güncelleme\n"
                                + "[ 2 ]Öğretim üyesi güncelleme\n"
                                + "[ 3 ]geri");
                        int secim6=scan.nextInt();
                        switch(secim6){
                            case 1:
                                System.out.println("Güncellemek istediğiniz öğrencinin numaraını giriniz");
                                int ogrNo =scan.nextInt();
                                System.out.println("Güncellemek istediğiniz öğrencinin ismini giriniz");
                                String isim =scan.next();
                                System.out.println("Güncellemek istediğiniz öğrencinin soyismini giriniz");
                                String soyisim=scan.next();
                                System.out.println("Güncellemek istediğiniz öğrencinin mail adresini giriniz");
                                String mail =scan.next();
                                ogr.güncelleme(isim, soyisim, ogrNo, mail);
                                break;
                            case 2:
                                ogrUye1.menüOgrUyesiGuncelleme();
                                break;
                            case 3:
                                menü();
                                break;
                        } 
                    break;
                    case 4:
                        System.out.println("************************************************************");
                        System.out.println("Ders proğramı oluşturma menüsü");
                        System.out.println("[ 1 ]Ders programı oluşturmak\n"
                                + "[ 2 ]Ders programı silme\n"
                                + "[ 3 ] geri ");
                        
                         DersProgramı dersProg =new DersProgramı();
                        int secim7 =scan.nextInt();
                        switch(secim7){
                            case 1:
                               
                                dersProg.menü();
                                break;
                            case 2:
                                System.out.println("*************************************************************");
                                System.out.println("Des Programı silme");
                                dersProg.dersProgramıSilme();
                                break;
                            case 3:
                                
                                break;
                        }
                       break; 
                    case 5:
                        this.menü();
                        break;
                   
                        
                       
                }
    }
        
    
}
