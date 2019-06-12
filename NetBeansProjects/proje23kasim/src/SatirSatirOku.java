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
public class SatirSatirOku {
    public static void main(String args[]){
        try{
           FileInputStream fi=new FileInputStream("C:/2015-2016/kasim/nyp/proje26kasim/src/newfile.txt");
           
           BufferedReader buf=new BufferedReader(new InputStreamReader(fi));
            String satir;
           while ((satir=buf.readLine())!=null){
                if (!satir.equals("")) 
                  System.out.println(satir);
            }}
        catch(FileNotFoundException f)
          {
              System.out.println("dosya yok");
          }
        catch(IOException ioex)
          {System.out.println("başka bir hata oldu"); }
        }
    }

