/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PELIN
 */
 import javax.swing.JOptionPane; // program uses JOptionPane

public class Addition
 {
 public static void main( String[] args )
 {

String firstNumber =
JOptionPane.showInputDialog( "Enter first integer" );
String secondNumber =
JOptionPane.showInputDialog( "Enter second integer" );


int number1 = Integer.parseInt( firstNumber );
 int number2 = Integer.parseInt( secondNumber );

 int sum = number1 + number2; // add numbers

 // display result in a JOptionPane message dialog
JOptionPane.showMessageDialog(null, "The sum is " + sum,
"Sum of Two Integers", JOptionPane.OK_CANCEL_OPTION);


 } // end method main
 } // end class Addition

