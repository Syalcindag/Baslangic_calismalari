/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pelin
 */
 import java.awt.BorderLayout;
 import javax.swing.JFrame;
 import javax.swing.JLabel;

public class PanelSinifiTest
 {
 public static void main( String[] args )
 {
 // create JFrame
 JFrame frame = new JFrame( "A simple paint program" );

 PanelSinifi paintPanel = new PanelSinifi(); // create paint panel
 frame.add( paintPanel, BorderLayout.CENTER ); // in center

 // create a label and place it in SOUTH of BorderLayout
 frame.add( new JLabel( "Drag the mouse to draw" ),BorderLayout.SOUTH );

 frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 frame.setSize( 400, 200 ); // set frame size
 frame.setVisible( true ); // display frame
 } // end main
 } // end class Painter
