package otomasyon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sifre extends Otomasyon{
    
    static int sifre;
     
    static void sifre() throws IOException{
        dosya = new File("sifre.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        writer = new FileWriter(dosya, false);
        yazar = new BufferedWriter(writer);
        yazar.write("yonetici sifresi = 1453");
        yazar.newLine();
        yazar.close();
    }
    
    static void sifreOkuma() throws IOException{
        dosya = new File("sifre.txt");
        if (!dosya.exists()) {
            dosya.createNewFile();
        }
        reader = new FileReader(dosya);
        okur = new BufferedReader(reader);
        sifre=Integer.parseInt(okur.readLine());
        okur.close();
    }
}