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
public class FileWrite {
  public static void main(String args[]){
      String cumle="Bugun hava çok guzel";
      try{
        FileOutputStream f=new FileOutputStream("C:\\Users\\Sefa\\Documents\\NetBeansProjects\\proje23kasim\\src\\yaz1.txt",true) ;
        PrintStream yaz=new PrintStream(f);
        yaz.println(cumle);
        yaz.print(4);
        yaz.print('%');
      }
      catch(IOException e){    
          System.out.println("fasfs");
      }
  }  
}


