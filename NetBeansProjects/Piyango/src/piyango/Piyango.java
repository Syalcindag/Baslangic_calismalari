/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piyango;

import java.util.Random;

/**
 *
 * @author Sefa
 */
public class Piyango {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rnd = new Random();
        
        int i1, i2, i3, i4,i5,i6,i7; 
        
        i1 =rnd.nextInt(9);
        i2 =rnd.nextInt(9);
        i3 =rnd.nextInt(9);
        i4 =rnd.nextInt(9);
        i5 =rnd.nextInt(9);
        i6 =rnd.nextInt(9);
        i7 =rnd.nextInt(9);
        System.out.println( " bilet numarası: " + i1 + i2 +i3+ i4 + i5 + i6 + i7);
      
    }
    
}
