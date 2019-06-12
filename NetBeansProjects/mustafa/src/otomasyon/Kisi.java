package otomasyon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Kisi extends Otomasyon{//tum siniflarin miras aldigi ust sinif
    
    String ad;
    String soyad;
    String mail;
    long telefon;
    long kimlikNo;
    int sifre;
    
    
    public static void sayiYazdir() throws IOException{
        dosya=new File("sayilar.txt");
        writer=new FileWriter(dosya,false);
        yazar=new BufferedWriter(writer);
        yazar.write(String.valueOf(kayitSayisi));yazar.newLine();
        yazar.write(String.valueOf(egitimciSayisi));yazar.newLine();
        yazar.write(String.valueOf(ogrenciSayisi));yazar.newLine();
        yazar.close();
    }
    public static void kayitlar(Ogrenci ogrenciler[],Egitimci egitimciler[]){
        for(int i=ogrenciSayisi;i<=(ogrenciSayisi+egitimciSayisi);i++){
            for(int j=0;j<ogrenciSayisi;j++){
                kayitlar[j]=new Kisi();
                kayitlar[j]=(Kisi)ogrenciler[j];
            }
            kayitlar[i]=new Kisi();
            kayitlar[i]=(Kisi)egitimciler[i-ogrenciSayisi];
        }
    }
}
