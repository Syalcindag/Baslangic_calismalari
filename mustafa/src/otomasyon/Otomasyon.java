//!!!yonetici sifre 1453!!!
//1306160215
//Mustafa Abdullah Bayrak
//NYP Otomasyon Projesi 2017
package otomasyon;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Otomasyon {

    static File dosya;//program kapatildiginda kayitlarin sayisinin yazildigi dosya
    static FileReader reader;
    static BufferedReader okur;
    static FileWriter writer;
    static BufferedWriter yazar;
    static int ogrenciSayisi = 0;
    static int egitimciSayisi = 0;
    static int kayitSayisi = 0;
    static int temp = -1, indis = 999;
    static Kisi kayitlar[] = new Kisi[1100];//program calismaya basladiginda dosyadan okunan kayitlarin tutuldugu ve kapanırken dosyaya yazilan dizi
    static Ogrenci ogrenciler[] = new Ogrenci[1000];//program her calistiginda dosyadan okunan ogrenci kayitalarinin tutuldugu ve kapanırken dosyaya yazilan dizi
    static Egitimci egitimciler[] = new Egitimci[100];//program her calistiginda dosyadan okunan egitimci kayitlarinin tutuldugu ve kapanırken dosyaya yazilan dizi
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) throws IOException {
        dosya = new File("sayilar.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        reader = new FileReader(dosya);
        okur = new BufferedReader(reader);
        try {
            kayitSayisi = Integer.parseInt(okur.readLine());
            egitimciSayisi = Integer.parseInt(okur.readLine());
            ogrenciSayisi = Integer.parseInt(okur.readLine());
        } catch (Exception e1) {
        }
        Yonerge.yonergeYazdir();
        Ogrenci.kayitOkuma();
        Ogrenci.dersOku();
        Egitimci.kayitOkuma();
        Egitimci.dersVerme();
        Kisi.kayitlar(ogrenciler, egitimciler);
        do {
            System.out.println("Giris yontemini seciniz...\n1-yonetici\n2-egitimci\n3-ogrenci\n0-cikis");
            switch (input.nextInt()) {
                case 0:
                    break;
                case 1://yonetici menusu
                    do {
                        System.out.println("Parolayı giriniz...");
                        if (input.nextInt() == 1453) {
                            System.out.println("Islem seciniz...\n1-ogrenci menusu\n2-ogretim gorevlisi menusu");
                            switch (input.nextInt()) {
                                case 1:
                                    do {
                                        System.out.println("1-ogrenci kayit\n2-ogrenci sil\n3-ogrenci goruntule");
                                        switch (input.nextInt()) {
                                            case 1:
                                                Ogrenci.ekleOgr();
                                                break;
                                            case 2:
                                                System.out.println("silinecek ogrencinin TC kimlik numarasini giriniz...");
                                                Ogrenci.silOgr(input.nextLong());
                                                break;
                                            case 3:
                                                System.out.println("gormek istediginiz ogrencinin TC kimlik numarasini giriniz...");
                                                Ogrenci.goruntuleOgr(input.nextLong());
                                                break;
                                            default:
                                                System.out.println("yanlis secim yaptiniz!");
                                        }
                                        System.out.println("1-ogrenci islemlerine devam\n0-ogrenci islemlerinden cik");
                                    } while (input.nextInt() != 0);
                                    break;
                                case 2:
                                    do {
                                        System.out.println("islem seciniz...\n1-egitimci ekle\n2-egitimci sil\n3-egitimci goruntule");
                                        switch (input.nextInt()) {
                                            case 1:
                                                Egitimci.ekleEgtmc();
                                                break;
                                            case 2:
                                                System.out.println("silmek istediginiz egitimcinin TC kimlik numarasini giriniz...");
                                                Egitimci.silEgtmc(input.nextLong());
                                                break;
                                            case 3:
                                                System.out.println("goruntulemek istediginiz ogretim gorevlisinin TC kimlik numarasini giriniz...");
                                                Egitimci.goruntuleEgtmc(input.nextLong());
                                                break;
                                            default:
                                                System.out.println("yanlis secimyaptiniz, lutfen tekrar deneyin...");
                                        }
                                        System.out.println("1-ogretim gorevlisi islemlerine devam\n0-ogretim gorevlisi islemlerinden cik");
                                    } while (input.nextInt() != 0);
                                    break;
                                default:
                                    System.out.println("yanlis secim yaptiniz!");
                            }
                        } else {
                            System.out.println("Yanlis sifre girdiniz...");
                        }
                        System.out.println("1-yonetici olarak devam et\n0-yonetici menusunden cik");
                    } while (input.nextInt() != 0);
                    break;
                case 2://ogretim gorevlisi menusu
                    do {
                        System.out.println("TC kimlik numaranizi giriniz...");
                        long TC = input.nextLong();
                        if (Egitimci.kayitKontrol(TC)) {
                            do {
                                System.out.println("islem seciniz...\n1-profil goruntule\n2-profil düzenle\n3-not islemleri\n0-cik");
                                switch (input.nextInt()) {
                                    case 1:
                                        Egitimci.goruntuleEgtmc(TC);
                                        break;
                                    case 2:
                                        Egitimci.duzenle(egitimciler[Egitimci.kayitBul(TC)]);
                                        break;
                                    case 3:
                                        do {
                                            System.out.println("1-not girisi\n2-gecme notu belirleme");
                                            switch (input.nextInt()) {
                                                case 1:
                                                    Egitimci.notGiris(egitimciler[Egitimci.kayitBul(TC)]);
                                                    break;
                                                case 2:
                                                    Egitimci.notBelirleme(egitimciler[Egitimci.kayitBul(TC)]);
                                                    break;
                                            }
                                            System.out.println("1-not islemlerine devam\n0-cik");
                                        } while (input.nextInt() != 0);
                                        break;
                                    default:
                                        System.out.println("Yanlis secim yaptiniz!");
                                }
                                System.out.println("1-islemlere devam et\n0-cikis yap");
                            } while (input.nextInt() != 0);
                        }
                        System.out.println("1-ogretim gorevlisi olarak giris yap\n0-ogretim gorevlisi menusunden cik");
                    } while (input.nextInt() != 0);
                    break;
                case 3://ogrenci menusu
                    System.out.println("TC kimlik numaranizi giriniz...");
                    long TC = input.nextLong();
                    if (Ogrenci.kayitKontrol(TC)) {
                        do {
                            System.out.println("islem seciniz...\n1-profili goruntule\n2-profili duzenle\n3-ders secimi\n4-ders programi\n5-notlar");
                            switch (input.nextInt()) {
                                case 1:
                                    Ogrenci.goruntuleOgr(ogrenciler[Ogrenci.kayitBul(TC)].kimlikNo);
                                    break;
                                case 2:
                                    Ogrenci.duzenle(ogrenciler[Ogrenci.kayitBul(TC)]);
                                    break;
                                case 3:
                                    Ogrenci.dersSecme(ogrenciler[Ogrenci.kayitBul(TC)]);
                                    break;
                                case 4:
                                    Ogrenci.dersProgrami(ogrenciler[Ogrenci.kayitBul(TC)]);
                                    break;
                                case 5:
                                    Ogrenci.notGoruntuleme(ogrenciler[Ogrenci.kayitBul(TC)]);
                                    break;
                                default:
                                    System.out.println("yanlis secim yaptiniz!");
                            }
                            System.out.println("\n1-ogrenci islemlerine devam\n0-ogrenci islemlerinden cik");
                        } while (input.nextInt() != 0);
                    }
                    break;
                default:
                    System.out.println("Yanlis secim yaptiniz!");
            }
            System.out.println("1-devam\n0-programdan cik");
        } while (input.nextInt() != 0);
        Ogrenci.kayitYazma();
        Ogrenci.dersYazdir();
        Egitimci.kayitYazma();
        Kisi.sayiYazdir();
    }
}
