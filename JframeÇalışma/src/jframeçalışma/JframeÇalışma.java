/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframeçalışma;

import javax.swing.JOptionPane;

/**
 *
 * @author Sefa
 */
public class JframeÇalışma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String firstNumber =
        JOptionPane.showInputDialog("Enter first integer");
        String secondNumber =
        JOptionPane.showInputDialog("enter second integer");
        
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        
        int sum = number1 + number2;
        
        JOptionPane.showMessageDialog(null, "the sum is" + sum,
                "sum of two integer", JOptionPane.OK_CANCEL_OPTION);
    }
    
}
