/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pelin
 */
// Fig. 14.26: MultipleSelectionTest.java
 // Testing MultipleSelectionFrame.
 import javax.swing.JFrame;

public class MultipleSelectionTest
 {
 public static void main( String[] args )
 {
 MultipleSelectionFrame multipleSelectionFrame =
 new MultipleSelectionFrame();
 multipleSelectionFrame.setDefaultCloseOperation(
 JFrame.EXIT_ON_CLOSE );
 multipleSelectionFrame.setSize( 350, 150 ); // set frame size
 multipleSelectionFrame.setVisible( true ); // display frame
 } // end main
 } // end class MultipleSelectionTest
