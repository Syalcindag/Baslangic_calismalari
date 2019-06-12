
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
public class UsingExceptions {
    public static void main(String args[]){
        try {
            hataFirlat1();
            hataFirlatma();
        }
        catch (Exception ex1){
            System.out.println("main in catchine dustu");
        }
        
         System.out.println("main metodu sonu"); }
    
    public static void hataFirlat() throws Exception {
        try {
            System.out.println("hataFirlat metodu try");
            throw new Exception();       
        }
        catch (Exception ex2){
            System.out.println("hataFirlat metodu catchine dustu");
           throw ex2;
        }
     
        //System.out.println("fırlatıldı");
    }
     public static void hataFirlatma() throws Exception {
        try {
             String cumle="Bugun hava çok guzel";
    
        FileOutputStream f=new FileOutputStream("C:/2015-2016/kasim/nyp/proje26kasim/src/yaz1.txt",true) ;
        PrintStream yaz=new PrintStream(f);
        yaz.println(cumle);
        yaz.print(4);
        yaz.print('%');
            System.out.println("hataFirlatma metodu try");
             }
        catch (Exception exception) {
            System.out.println("hataFirlatma metodu catchine dustu");
            throw exception;
            }
        System.out.println("hataFirlatma metodu sonu");  }

     
      public static void hataFirlat1() {
       try {
            System.out.println(" try");
            throw new Exception();
             }
        catch (Exception exception){
            System.out.println("hataFirlat metodu catchine dustu");
             
            }
            System.out.println("hataFirlatma metodu try");}
           
     
}


