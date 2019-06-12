package otomasyon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Yonerge extends Otomasyon{
    
    static void yonergeYazdir() throws IOException{
        dosya = new File("yonerge.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        writer = new FileWriter(dosya, false);
        yazar = new BufferedWriter(writer);
        yazar.write("Ogrenci ya da Ogretim gorevlisi olarak giris yapmak icin oncelikle Yonetici menusune girip sifreyi 1453 olarak giriniz.");
        yazar.newLine();
        yazar.write("Buradan ekleme silme duzenleme gibi islemlerinizi halledebilirsiniz.");
        yazar.newLine();
        yazar.write("Sistem size 4 haneli gecici sifre olusturacaktır. Bu sifreyi giris yaparken kullanacaksiniz.");
        yazar.newLine();
        yazar.write("Sonrasinda sisteme ogrenci ya da ogretim gorevlisi olarak giris yapip duzenle kismindan sifrenizi degistirebilirsiniz.");
        yazar.newLine();
        yazar.write("O zamana kadar gecici sifrenizi unutmayiniz!!!");
        yazar.close();
    }
    
}
