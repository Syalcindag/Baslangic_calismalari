/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.annotation.processing.FilerException;

/**
 *
 * @author Sefa
 */
public class Dosyaİslemleri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cumle = "ali baba ve kırk haramiler";
        
        try{
            FileOutputStream f=new FileOutputStream("C:/Users/Sefa/Documents/NetBeansProjects/Dosyaİslemleri/src/dosyaislemleri/dosya.txt", true);
            PrintStream yaz = new PrintStream(f);
            yaz.println(cumle);
            
            
        }
         catch(FileNotFoundException ex)
        {
            System.out.println("dosya yok");
        }
        catch(Exception e)
        {
            System.out.println("hata:" + e.getMessage());
        }
       
    }
    
}
