/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmethodları;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Sefa
 */
public class StringMethodları {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "merhaba dunya";
        
        int uzunluk =s.length();
        
        System.out.println("uzunluk " + uzunluk);
        System.out.println(s.contains("dunya"));
        
        int deger = s.compareTo("merhaba ay");
        System.out.println(deger);
        
        System.out.println(s.substring(6));
        Date now = new Date();
        
        System.out.println(now.toString());
        DateFormat formatzaman =new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(formatzaman.format(now));
        
    
    }
    
}
