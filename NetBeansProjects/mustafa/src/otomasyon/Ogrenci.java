package otomasyon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static otomasyon.Otomasyon.kayitSayisi;


public class Ogrenci extends Kisi implements FakulteMuhendislik,FakulteIsletme,FakulteSiyaset,Bolumler{
    
    static String bolumler[]={"Bilgisayar Muhendisligi","Endustri Muhendisligi","Isletme","Iktisat","Kamu Yonetimi","Uluslararasi Iliskiler"};
    String bolum;
    int dersSayisi=0;
    Ders dersler[]=new Ders[10];
    long okulNo;
    static String saatler[] = {"   09.00    ", "   10.00    ", "   11.00    ", "   12.00    "};
    static String gunler[] = {" pazartesi  ", "    sali    ", "  carsamba  ", "  persembe  ", "    cuma    "};
    
    public static void noAtama(Ogrenci ogrenci){
        String okulNo="0";
        if(ogrenci.bolum=="Bilgisayar Muhendisligi")
            okulNo="130617";
        if(ogrenci.bolum=="Endustri Muhendisligi")
            okulNo="130517";
        if(ogrenci.bolum=="Isletme")
            okulNo="120117";
        if(ogrenci.bolum=="Iktisat")
            okulNo="120217";
        if(ogrenci.bolum=="Kamu Yonetimi")
            okulNo="140717";
        if(ogrenci.bolum=="Uluslararasi Iliskiler")
            okulNo="140817";
        if(ogrenciSayisi<10)
            okulNo=okulNo+"000"+String.valueOf(ogrenciSayisi);
        else if((9<ogrenciSayisi)||(ogrenciSayisi<100))
            okulNo=okulNo+"00"+String.valueOf(ogrenciSayisi);
        else
            okulNo=okulNo+"0"+String.valueOf(ogrenciSayisi);
        ogrenci.okulNo=Long.parseLong(okulNo);
    }
    public static void duzenle(Ogrenci ogrenci){
        do{
        System.out.println("düzenlemek istediginiz bilgiyi secin...\n1-telefon numarasi\n2-e-posta adresi\n3-sifre\n0-cik");
        switch(input.nextInt()){
            case 1:
                System.out.println("guncel telefon numaranizi giriniz...");
                ogrenci.telefon=input.nextLong();
                break;
            case 2:
                System.out.println("guncel e-posta adresinizi giriniz...");
                ogrenci.mail=input.next();
                break;
            case 3:
                System.out.println("4 haneli yeni sifrenizi giriniz...");
                ogrenci.sifre=input.nextInt();
                System.out.println("yeni sifreniz "+ogrenci.sifre+" olarak olusturuldu");
                break;
            default:
                System.out.println("yanlis secim yaptiniz!");
            }
        System.out.println("1-duzenlemeye devam et\n0-duzenlemeden cik");
        }while(input.nextInt()!=0);
    }
    public static void ekleOgr() {
        ogrenciler[ogrenciSayisi] = new Ogrenci(); 
        System.out.println("TC kimlik numarasi giriniz...");
        Long TC = input.nextLong();
        boolean kontrol=false;
        for(int i=0;i<ogrenciSayisi;i++){
            if(ogrenciler[i].kimlikNo==TC){
                kontrol=true;
                System.out.println("Bu kayit sistemde mevcut!");
            }
        }
        if(kontrol==false){
        ogrenciler[ogrenciSayisi].kimlikNo=TC;
        System.out.println("Ad giriniz...");
        ogrenciler[ogrenciSayisi].ad = input.next();
        System.out.println("Soyad giriniz...");
        ogrenciler[ogrenciSayisi].soyad = input.next();
        int durum=1;
        do{
        System.out.println("Bolum seciniz...\n1-Bilgisayar Muhendisligi\n2-Endustri Muhendisligi");
        System.out.println("3-Isletme\n4-Iktisat\n5-Kamu Yonetimi\n6-Uluslararasi Iliskiler");
        switch(input.nextInt()){
            case 1:
            ogrenciler[ogrenciSayisi].bolum = "Bilgisayar Muhendisligi";
            durum=1;
            break;
            case 2:
                ogrenciler[ogrenciSayisi].bolum ="Endustri Muhendisligi";
                durum=1;
                break;
            case 3:
                ogrenciler[ogrenciSayisi].bolum ="Isletme";
                durum=1;
                break;
            case 4:
                ogrenciler[ogrenciSayisi].bolum ="Iktisat";
                durum=1;
                break;
            case 5:
                ogrenciler[ogrenciSayisi].bolum ="Kamu Yonetimi";
                durum=1;
                break;
            case 6:
                ogrenciler[ogrenciSayisi].bolum ="Uluslararasi Iliskiler";
                durum=1;
                break;
            default:
                durum=0;
                System.out.println("yanlis secim yaptiniz!");
            }
        }while(durum==0);
        System.out.println("Telefon numarasi giriniz...");
        ogrenciler[ogrenciSayisi].telefon=input.nextLong();
        System.out.println("e-posta adresi giriniz...");
        ogrenciler[ogrenciSayisi].mail=input.next();
        ogrenciler[ogrenciSayisi].sifre=r.nextInt(10000);//4 haneli random sifre uretme
        noAtama(ogrenciler[ogrenciSayisi]);
        System.out.println("okul numaraniz: "+ogrenciler[ogrenciSayisi].okulNo);
        System.out.println("gecici sifreniz: "+ogrenciler[ogrenciSayisi].sifre);
        kayitlar[kayitSayisi] = (Kisi) ogrenciler[ogrenciSayisi];
        kayitSayisi++;
        ogrenciSayisi++;
        System.out.println("Ogrenci basariyla eklendi.");
        }
    }
    public static void goruntuleOgr(long goruntulenecekOgr) {
        if (ogrenciSayisi != 0) {
            for (int i = 0; i < ogrenciSayisi; i++) {
                if (ogrenciler[i].kimlikNo == goruntulenecekOgr) {
                    System.out.println("Bolum= "+ogrenciler[i].bolum);
                    System.out.println("TC kimlik no= "+ogrenciler[i].kimlikNo);
                    System.out.println("ad= " + ogrenciler[i].ad);
                    System.out.println("soyad= " + ogrenciler[i].soyad);
                    System.out.println("okul no= " + ogrenciler[i].okulNo);
                    System.out.println("telefon numarasi= "+ogrenciler[i].telefon);
                    System.out.println("e-posta adresi= "+ogrenciler[i].mail);
                    temp = 1;
                }
            }
            if (temp != 1) {
                System.out.println("aradiginiz kayit bulunamadi");
            } else {
                temp = -1;
            }
        } else {
            System.out.println("sistemde kayitli ogrenci yok!");
        }
    }
    public static void silOgr(long silinecekOgr) {
        if (ogrenciSayisi == 0) {
            System.out.println("sistemde kayitli ogrenciyok!");
        } else {
            for (int i = 0; i < ogrenciSayisi; i++) {
                if ((silinecekOgr == ogrenciler[i].kimlikNo) && (i + 1 == ogrenciSayisi)) {
                    temp = 1;//bulundu
                } else if ((silinecekOgr == ogrenciler[i].kimlikNo) && (i + 1 != ogrenciSayisi)) {
                    ogrenciler[i] = ogrenciler[i + 1];
                    temp = 1;
                    indis = i + 1;
                }
                if (indis + 1 < ogrenciSayisi) {
                    ogrenciler[indis] = ogrenciler[++indis];
                }
            }
            if (temp == -1)//temp degeri degismemisse bulunamamis demektir
            {
                System.out.println("silmek istediginiz kayit bulunamadi!");
            } else {
                temp = -1;//tempi eski degerine döndür
                indis = 999;//indisi eski degerine dondur
                ogrenciSayisi--;
                kayitSayisi--;
                System.out.println(silinecekOgr + " kimlik numarali ogrenci silindi.");
            }
        }
    }
    public static void kayitYazma()throws IOException{
        dosya=new File("ogrenciler.txt");
        if(!dosya.exists())
            dosya.createNewFile();
        writer=new FileWriter(dosya,false);
        yazar=new BufferedWriter(writer);
        for(int i=0;i<ogrenciSayisi;i++){
            yazar.write(String.valueOf(ogrenciler[i].kimlikNo));yazar.newLine();
            yazar.write(String.valueOf(ogrenciler[i].sifre));yazar.newLine();
            yazar.write(ogrenciler[i].bolum);yazar.newLine();
            yazar.write(ogrenciler[i].ad);yazar.newLine();
            yazar.write(ogrenciler[i].soyad);yazar.newLine();
            yazar.write(String.valueOf(ogrenciler[i].okulNo));yazar.newLine();
            yazar.write(ogrenciler[i].mail);yazar.newLine();
            yazar.write(String.valueOf(ogrenciler[i].telefon));yazar.newLine();
        }
        yazar.close();
    }
    public static void kayitOkuma() throws IOException{
        dosya=new File("ogrenciler.txt");
        if(!dosya.exists())
            dosya.createNewFile();
        reader=new FileReader(dosya);
        okur=new BufferedReader(reader);
        for(int i=0;i<ogrenciSayisi;i++){
            ogrenciler[i]=new Ogrenci();
            ogrenciler[i].kimlikNo=Long.parseLong(okur.readLine());
            ogrenciler[i].sifre=Integer.parseInt(okur.readLine());
            ogrenciler[i].bolum=okur.readLine();
            ogrenciler[i].ad=okur.readLine();
            ogrenciler[i].soyad=okur.readLine();
            ogrenciler[i].okulNo=Long.parseLong(okur.readLine());
            ogrenciler[i].mail=okur.readLine();
            ogrenciler[i].telefon=Long.parseLong(okur.readLine());
        }
        okur.close();
    }
    public static void dersYazdir() throws IOException{
        dosya=new File("dersler.txt");
        if(!dosya.exists())
            dosya.createNewFile();
        writer=new FileWriter(dosya,false);
        yazar=new BufferedWriter(writer);
        for(int i=0;i<ogrenciSayisi;i++){
            yazar.write(String.valueOf(ogrenciler[i].dersSayisi));yazar.newLine();
            for(int j=0;j<ogrenciler[i].dersSayisi;j++){
                yazar.write(ogrenciler[i].dersler[j].dersAdi);yazar.newLine();
                yazar.write(String.valueOf(ogrenciler[i].dersler[j].puan));yazar.newLine();
                yazar.write(String.valueOf(ogrenciler[i].dersler[j].gecmeNotu));yazar.newLine();
            }
        }
        yazar.close();
    }
    public static void dersOku() throws IOException{
        dosya=new File("dersler.txt");
        if(!dosya.exists())
            dosya.createNewFile();
        reader=new FileReader(dosya);
        okur=new BufferedReader(reader);
        for(int i=0;i<ogrenciSayisi;i++){
            try{ogrenciler[i].dersSayisi=Integer.parseInt(okur.readLine());}catch(Exception e1){}
            for(int j=0;j<ogrenciler[i].dersSayisi;j++){
                ogrenciler[i].dersler[j]=new Ders();
                ogrenciler[i].dersler[j].dersAdi=okur.readLine();
                for(int k=0;k<11;k++){
                    String str=ogrenciler[i].dersler[j].dersAdi;
                    if(str.equals(Bilgisayar.dersler[k].dersAdi)){
                        ogrenciler[i].dersler[j]=Bilgisayar.dersler[k];
                        ogrenciler[i].dersler[j].puan=Integer.parseInt(okur.readLine());
                        ogrenciler[i].dersler[j].gecmeNotu=Integer.parseInt(okur.readLine());
                    }
                }
            }
        }
        okur.close();
    }
    public static void dersProgrami(Ogrenci ogrenci){
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                System.out.print("--------------");}
            System.out.println();
            for(int j=0;j<6;j++){
                if((i==0)&&(j>0)){
                    System.out.print("| ");System.out.print(gunler[j-1]);
                }
                else if((j==0)&&(i>0)){
                    System.out.print("| ");System.out.print(saatler[i-1]);
                }
                else if((j==0)&&(i==0)){
                System.out.print("| ");System.out.print("            ");
                }
                else{
                    int kontrol=0;
                    for(int k=0;k<ogrenci.dersSayisi;k++){
                        if((ogrenci.dersler[k].gun==gunler[j-1])&&(ogrenci.dersler[k].saat==saatler[i-1])){
                            System.out.print("| ");System.out.print(ogrenci.dersler[k].dersAdi);
                            kontrol=1;
                        }
                    }
                    if(kontrol==0){
                        System.out.print("| ");System.out.print("            ");
                    }
                }
            }System.out.print("|");
            System.out.println();
            for(int j=0;j<6;j++){
                int kontrol=0;
                    for(int k=0;k<ogrenci.dersSayisi;k++){
                        if((j>0)&&(i>0)&&(ogrenci.dersler[k].gun==gunler[j-1])&&(ogrenci.dersler[k].saat==saatler[i-1])){
                            System.out.print("| ");System.out.print(ogrenci.dersler[k].sinif);
                            kontrol=1;
                        }
                    }
                    if(kontrol==0){
                        System.out.print("| ");System.out.print("            ");
                    }
            }System.out.print("|");
            System.out.println();
        }
        
            for(int j=0;j<6;j++){
                System.out.print("--------------");}
            System.out.println();
    }
    public static int kayitBul(long TC) {
        int i = 0, j = -1;
        for (; i < ogrenciSayisi; i++) {
            if (ogrenciler[i].kimlikNo == TC) {
                j = i;
            }
        }
        return j;
    }
    public static boolean kayitKontrol(double TC) {
        boolean dogru = false;
        boolean mevcut = false;
        for (int i = 0; i < ogrenciSayisi; i++) {
            if (ogrenciler[i].kimlikNo == TC) {
                System.out.println("sifre giriniz...");
                if (ogrenciler[i].sifre == input.nextInt()) {
                    dogru = true;
                    mevcut = true;
                } else {
                    System.out.println("yanlis sifre!");
                    mevcut=true;
                }
            }
        }
        if(!mevcut)
            System.out.println("Kayit bulunamadi!");
        return dogru;
    }
    static void dersSecme(Ogrenci ogrenci){
        String str=ogrenci.bolum;
        if(str.equals(bolumler[0]))
            Bilgisayar.dersSecimi(ogrenci);
        if(str.equals(bolumler[1]))
            Endustri.dersSecimi(ogrenci);
        if(str.equals(bolumler[2]))
            Endustri.dersSecimi(ogrenci);
        if(str.equals(bolumler[3]))
            Endustri.dersSecimi(ogrenci);
        if(str.equals(bolumler[4]))
            Endustri.dersSecimi(ogrenci);
        if(str.equals(bolumler[5]))
            Endustri.dersSecimi(ogrenci);
    }
    static void notGoruntuleme(Ogrenci ogrenci){
        if(ogrenci.dersSayisi==0)
            System.out.println("Henuz ders secimi yapmadiniz!");
        else{
        for(int i=0;i<ogrenci.dersSayisi;i++){
            if((ogrenci.dersler[i].puan<=100)&&(ogrenci.dersler[i].puan>=0)){
            System.out.println(ogrenci.dersler[i].dersAdi+" : "+ogrenci.dersler[i].puan);
                if(ogrenci.dersler[i].puan<ogrenci.dersler[i].gecmeNotu)
                    System.out.println("Bu dersten kaldiniz,tekrar almalisiniz!");
                else if(ogrenci.dersler[i].puan>ogrenci.dersler[i].gecmeNotu)
                    System.out.println("Bu dersi gectiniz");
                else
                    System.out.println("Bu ders icin henuz gecme notu belirlenmedi!");
            }
            else
                System.out.println("Henuz "+ogrenci.dersler[i].dersAdi+" dersi icin notunuz girilmedi");
            }
        }
    }
}
