/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
import java.io.*;
public class HarfHarfOku {
    public static void main(String args[]){
        StringBuffer icerik = new StringBuffer("");
        try{
        File f=new File("C:/2017-2018/kasim/nyp/proje23kasim/src/newfile.txt");
            FileInputStream fi=new FileInputStream(f);
            int k;
            
            while ((k=fi.read())!=-1){
                icerik.append((char)k);
                
                    }
        
        }
        catch(FileNotFoundException f)
          {System.out.println("dosya yok");}
        catch(IOException ioex)
          {System.out.println("başka bir hata oldu"); }
        
           System.out.println("icerik :");
           System.out.println(icerik);
          }
    }

