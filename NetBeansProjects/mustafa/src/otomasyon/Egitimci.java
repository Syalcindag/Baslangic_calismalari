package otomasyon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Egitimci extends Kisi implements Bolumler{

    Ders verilenDers;
    String bolum;

    public static void duzenle(Egitimci egitimci) {
        do {
            System.out.println("düzenlemek istediginiz bilgiyi secin...\n1-telefon numarasi\n2-e-posta adresi\n3-sifre\n0-cik");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("guncel telefon numaranizi giriniz...");
                    egitimci.telefon = input.nextLong();
                    break;
                case 2:
                    System.out.println("guncel mail adresinizi giriniz...");
                    egitimci.mail = input.next();
                    break;
                case 3:
                    System.out.println("4 haneli yeni sifrenizi giriniz...");
                    egitimci.sifre = input.nextInt();
                    System.out.println("yeni sifreniz " + egitimci.sifre + " olarak olusturuldu");
                default:
                    System.out.println("yanlis secim yaptiniz!");
            }
            System.out.println("1-duzenlemeye devam et\n0-duzenlemeden cik");
        } while (input.nextInt() != 0);
    }

    public static void ekleEgtmc() {
        egitimciler[egitimciSayisi] = new Egitimci();
        System.out.println("TC kimlik numarasi giriniz...");
        Long TC = input.nextLong();
        boolean kontrol = false;
        for (int i = 0; i < egitimciSayisi; i++) {
            if (egitimciler[i].kimlikNo == TC) {
                kontrol = true;
                System.out.println("Bu kayit sistemde mevcut!");
            }
        }
        if (kontrol == false) {
            egitimciler[egitimciSayisi].kimlikNo = TC;
            System.out.println("ad giriniz...");
            egitimciler[egitimciSayisi].ad = input.next();
            System.out.println("soyad giriniz...");
            egitimciler[egitimciSayisi].soyad = input.next();
            int durum = 1;
            do {
                System.out.println("Bolum seciniz...\n1-Bilgisayar Muhendisligi\n2-Endustri Muhendisligi");
                System.out.println("3-Isletme\n4-Iktisat\n5-Kamu Yonetimi\n6-Uluslararasi Iliskiler");
                switch (input.nextInt()) {
                    case 1:
                        egitimciler[egitimciSayisi].bolum = "Bilgisayar Muhendisligi";
                        durum = 1;
                        break;
                    case 2:
                        egitimciler[egitimciSayisi].bolum = "Endustri Muhendisligi";
                        durum = 1;
                        break;
                    case 3:
                        egitimciler[egitimciSayisi].bolum = "Isletme";
                        durum = 1;
                        break;
                    case 4:
                        egitimciler[egitimciSayisi].bolum = "Iktisat";
                        durum = 1;
                        break;
                    case 5:
                        egitimciler[egitimciSayisi].bolum = "Kamu Yonetimi";
                        durum = 1;
                        break;
                    case 6:
                        egitimciler[egitimciSayisi].bolum = "Uluslararasi Iliskiler";
                        durum = 1;
                        break;
                    default:
                        durum = 0;
                        System.out.println("yanlis secim yaptiniz!");
                }
            } while (durum == 0);
        }
        dersBelirle(egitimciler[egitimciSayisi]);
        System.out.println("Telefon numarasi giriniz...");
        egitimciler[egitimciSayisi].telefon = input.nextLong();
        System.out.println("e-posta adresi giriniz...");
        egitimciler[egitimciSayisi].mail = input.next();
        egitimciler[egitimciSayisi].sifre = r.nextInt(10000);//4 haneli random gecici sifre uretme
        System.out.println("gecici sifre: " + egitimciler[egitimciSayisi].sifre);
        kayitlar[kayitSayisi] = (Kisi) egitimciler[egitimciSayisi];
        kayitSayisi++;
        egitimciSayisi++;
        System.out.println("ogretim gorevlisi basariyla eklendi.");
    }

    public static void silEgtmc(long silinecekEgtmc) {
        if (egitimciSayisi == 0) {
            System.out.println("sistemde kayitli egitimciyok!");
        } else {
            for (int i = 0; i < egitimciSayisi; i++) {
                if ((silinecekEgtmc == egitimciler[i].kimlikNo) && (i + 1 == egitimciSayisi)) {
                    temp = 1;//bulundu
                } else if ((silinecekEgtmc == egitimciler[i].kimlikNo) && (i + 1 != egitimciSayisi)) {
                    egitimciler[i] = egitimciler[i + 1];
                    temp = 1;
                    indis = i + 1;
                }
                if (indis + 1 < egitimciSayisi) {
                    egitimciler[indis] = egitimciler[++indis];
                }
            }
            if (temp == -1)//temp degeri degismemisse bulunamamis demektir
            {
                System.out.println("silmek istediginiz kayit bulunamadi!");
            } else {
                temp = -1;//tempi eski degerine döndür
                indis = 999;//indisi eski degerine dondur
                egitimciSayisi--;
                kayitSayisi--;
                System.out.println(silinecekEgtmc + " kimlik numarali egitimci silindi.");
            }
        }
    }

    public static void goruntuleEgtmc(long goruntulenecekEgtmc) {
        if (egitimciSayisi != 0) {
            for (int i = 0; i < egitimciSayisi; i++) {
                if (egitimciler[i].kimlikNo == goruntulenecekEgtmc) {
                    System.out.println("TC kimlik no= " + egitimciler[i].kimlikNo);
                    System.out.println("ad= " + egitimciler[i].ad);
                    System.out.println("soyad= " + egitimciler[i].soyad);
                    System.out.println("telefon= " + egitimciler[i].telefon);
                    System.out.println("e-posta= " + egitimciler[i].mail);
                    System.out.println("verdigi ders= " + egitimciler[i].verilenDers.dersAdi);
                    temp = 1;
                }
            }
            if (temp != 1) {
                System.out.println("aradiginiz kayit bulunamadi");
            } else {
                temp = -1;
            }
        } else {
            System.out.println("sistemde kayitli egitimci yok!");
        }
    }

    public static void kayitYazma() throws IOException {
        dosya = new File("egitimciler.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        writer = new FileWriter(dosya, false);
        yazar = new BufferedWriter(writer);
        for (int i = 0; i < egitimciSayisi; i++) {
            yazar.write(String.valueOf(egitimciler[i].kimlikNo));
            yazar.newLine();
            yazar.write(String.valueOf(egitimciler[i].sifre));
            yazar.newLine();
            yazar.write(egitimciler[i].ad);
            yazar.newLine();
            yazar.write(egitimciler[i].soyad);
            yazar.newLine();
            yazar.write(egitimciler[i].mail);
            yazar.newLine();
            yazar.write(String.valueOf(egitimciler[i].telefon));
            yazar.newLine();
            yazar.write(egitimciler[i].verilenDers.dersAdi);
            yazar.newLine();
        }
        yazar.close();
    }

    public static void kayitOkuma() throws IOException {
        dosya = new File("egitimciler.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        reader = new FileReader(dosya);
        okur = new BufferedReader(reader);
        for (int i = 0; i < egitimciSayisi; i++) {
            egitimciler[i] = new Egitimci();
            egitimciler[i].kimlikNo = Long.parseLong(okur.readLine());
            egitimciler[i].sifre = Integer.parseInt(okur.readLine());
            egitimciler[i].ad = okur.readLine();
            egitimciler[i].soyad = okur.readLine();
            egitimciler[i].mail = okur.readLine();
            egitimciler[i].telefon = Long.parseLong(okur.readLine());
            egitimciler[i].verilenDers = new Ders();
            egitimciler[i].verilenDers.dersAdi = okur.readLine();
        }
        okur.close();
    }

    public static void dersVerme() {
        for (int i = 0; i < egitimciSayisi; i++) {
            for (int j = 0; j < 11; j++) {
                String str = egitimciler[i].verilenDers.dersAdi;
                if (str.equals(Bilgisayar.dersler[j].dersAdi)) {
                    egitimciler[i].verilenDers = new Ders();
                    egitimciler[i].verilenDers = Bilgisayar.dersler[j];
                }
            }
        }
    }

    public static void notGiris(Egitimci egitimci) {
        do {
            System.out.println("Ogrencinin TC kimlik numarasini giriniz...");
            Long TC = input.nextLong();
            if (Ogrenci.kayitBul(TC) == -1) {
                System.out.println("Kayit bulunamadi!");
            } else {
                Ogrenci ogrenci = ogrenciler[Ogrenci.kayitBul(TC)];
                int kontrol = 0;
                for (int i = 0; i < ogrenci.dersSayisi; i++) {
                    if (ogrenci.dersler[i] == egitimci.verilenDers) {
                        kontrol = 1;
                        System.out.println("Ogrencinin " + egitimci.verilenDers.dersAdi + " dersi icin notunu giriniz...");
                        int not = input.nextInt();
                        if ((not >= 0) && (not <= 100)) {
                            ogrenci.dersler[i].puan = not;
                            System.out.println(ogrenci.okulNo + " numarali ogrencinin " + ogrenci.dersler[i].dersAdi + " dersi icin notu " + ogrenci.dersler[i].puan + " olarak girildi.");
                        } else {
                            System.out.println("Gecersiz not girisi!");
                        }
                    }
                }
                if (kontrol == 0) {
                    System.out.println("Ogrenci" + egitimci.verilenDers.dersAdi + " dersini almamaktadir!");
                }
            }
            System.out.println("1-not verme islemine devam et\n0-cik");
        } while (input.nextInt() != 0);
    }

    public static int kayitBul(long TC) {
        int i = 0, j = -1;
        for (; i < egitimciSayisi; i++) {
            if (egitimciler[i].kimlikNo == TC) {
                j = i;
            }
        }
        return j;
    }

    public static boolean kayitKontrol(double TC) {
        boolean dogru = false;
        boolean mevcut = false;
        for (int i = 0; i < egitimciSayisi; i++) {
            if (egitimciler[i].kimlikNo == TC) {
                System.out.println("sifre giriniz...");
                if (egitimciler[i].sifre == input.nextInt()) {
                    dogru = true;
                    mevcut = true;
                } else {
                    System.out.println("yanlis sifre!");
                    mevcut = true;
                }
            }
        }
        if (!mevcut) {
            System.out.println("Kayit bulunamadi!");
        }
        return dogru;
    }

    static void notBelirleme(Egitimci egitimci) {
        System.out.println("Gecme notunu giriniz...");
        int not = input.nextInt();
        if ((not <= 50) && (not >= 0)) {
            String str = egitimci.verilenDers.dersAdi;
            for (int i = 0; i < ogrenciSayisi; i++) {
                for (int j = 0; j < ogrenciler[i].dersSayisi; j++) {
                    if (str.equals(ogrenciler[i].dersler[j].dersAdi)) {
                        ogrenciler[i].dersler[j].gecmeNotu = not;
                    }
                }
            }
            egitimci.verilenDers.gecmeNotu = not;
            System.out.println("Gecme notu " + not + " olarak belirlendi");
        } else if ((not <= 100) && (not > 50)) {
            System.out.println("Lutfen mantikli bir not giriniz :D");
        } else {
            System.out.println("Lutfen gecerli bir not giriniz...");
        }
    }
    
    static void dersBelirle(Egitimci egitimci){
        String str=egitimci.bolum;
        if(str.equals(bolumler[0]))
            Bilgisayar.dersSecimi(egitimci);
        if(str.equals(bolumler[1]))
            Endustri.dersSecimi(egitimci);
        if(str.equals(bolumler[2]))
            Endustri.dersSecimi(egitimci);
        if(str.equals(bolumler[3]))
            Endustri.dersSecimi(egitimci);
        if(str.equals(bolumler[4]))
            Endustri.dersSecimi(egitimci);
        if(str.equals(bolumler[5]))
            Endustri.dersSecimi(egitimci);
    }
}
