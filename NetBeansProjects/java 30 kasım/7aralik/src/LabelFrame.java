/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PELIN
 */

import java.awt.Color;
import java.awt.FlowLayout; // specifies how components are arranged
 import javax.swing.JFrame; // provides basic window features
 import javax.swing.JLabel; // displays text and images
 import javax.swing.SwingConstants; // common constants used with Swing
 import javax.swing.Icon; // interface used to manipulate images
 import javax.swing.ImageIcon; // loads images
// resimler proje klasörünün içindeki build/classes klasörünün altında
 public class LabelFrame extends JFrame
 {
 private JLabel label1; // JLabel with just text
 private JLabel label2; // JLabel constructed with text and icon
 private JLabel label3; // JLabel with added text and icon

 // LabelFrame constructor adds JLabels to JFrame
 public LabelFrame()
 {
    super( "Testing JLabel" );
    setLayout( new FlowLayout() ); // set frame layout

// JLabel constructor with a string argument
label1 = new JLabel( "Label with text" );
label1.setToolTipText( "This is label1" );

System.out.println(getClass().getResource("bug1.png"));
 add( label1 ); // add label1 to JFrame
ImageIcon bug = new ImageIcon( getClass().getResource("bug1.png") );

//ImageIcon bug = new ImageIcon( "D:/2012-2013/mart/pa/kod/JavaApplication5/src/bug1.png" );
label2 = new JLabel( "Label with text and icon", bug,
                                SwingConstants.LEFT);


 label2.setToolTipText( "This is label2" );
 add( label2 ); // add label2 to JFrame

 label3 = new JLabel(); // JLabel constructor no arguments
label3.setIcon( bug ); 
label3.setText( "Label with icon " );
// add icon to JLabel
label3.setHorizontalTextPosition( SwingConstants.LEFT );
label3.setVerticalTextPosition( SwingConstants.TOP );
label3.setToolTipText( "This is label3" );

 add( label3 ); // add label3 to JFrame
 } // end LabelFrame constructor
 public static void main(String args[]) {
    LabelFrame labelFrame = new LabelFrame();
    labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 labelFrame.setSize( 260, 300 ); // set frame size
 labelFrame.setVisible( true ); // display frame
 //labelFrame.setBackground(Color.yellow);
  //labelFrame.pack();
 labelFrame.getContentPane().setBackground(Color.yellow);
  }
 } // end class LabelFrame

