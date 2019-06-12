/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import javax.swing.JOptionPane;

/**
 *
 * @author Sefa
 */
public class buttun {
    
    /**
     *
     */
    public static void main(String [] args){
        
        String sayi1 =
                JOptionPane.showInputDialog("ilk sayiyi giriniz");
        String sayi2 = 
                JOptionPane.showInputDialog("ikinci sayiyi giriniz");
        
        int number1 = Integer.parseInt(sayi1);
        int number2 = Integer.parseInt(sayi2);
        
        int sum = number1 + number2;
        
        JOptionPane.showMessageDialog(null, "toplam sayı " + sum, "iki sayinin toplamı", JOptionPane.OK_CANCEL_OPTION);
        
        
        
    }
    
}
