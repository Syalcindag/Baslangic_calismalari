/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaişlemleri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.print.DocFlavor;

/**
 *
 * @author Sefa
 */
public class Dosyaİşlemleri {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File f = new File("C:\\Users\\Sefa\\Documents\\NetBeansProjects\\Dosyaİşlemleri\\src\\dosyaişlemleri\\dosya.txt" + true);
        
       // try (FileWriter fw = new FileWriter(f)) {
         //   fw.write("15 sefa ");
           // fw.write("15 sefa");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String satir ;
            satir = br.readLine();
            
            while(satir != null)
            {
                System.out.println(satir);  
                satir = br.readLine();
            }
            
            
            
                
           // }  
            
           //fw.close();
        
        
    }
    
}
