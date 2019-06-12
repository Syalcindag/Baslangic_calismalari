/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PELIN
 */
 import java.awt.FlowLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import javax.swing.JFrame;
 import javax.swing.JButton;
 import javax.swing.Icon;
 import javax.swing.ImageIcon;
 import javax.swing.JOptionPane;

 public class ButtonFrame extends JFrame
 {
 private JButton plainJButton; // button with just text
private JButton fancyJButton;


 // ButtonFrame adds JButtons to JFrame
 public ButtonFrame()
 {
 super( "Testing Buttons" );
 setLayout( new FlowLayout() ); // set frame layout

 plainJButton = new JButton( "Plain Button" );
 add( plainJButton ); // add plainJButton to JFrame
     System.out.println("URL = " + getClass().getResource( "bug1.png" ));
     System.out.println("URL = " + getClass().getResource( "bug2.png" ));
 Icon bug1 = new ImageIcon( getClass().getResource( "bug1.png" ) );
Icon bug2 = new ImageIcon( getClass().getResource( "bug2.png" ) );
fancyJButton = new JButton( "Fancy Button", bug1 ); // set image
fancyJButton.setRolloverIcon( bug2 ); // set rollover image


 add( fancyJButton ); // add fancyJButton to JFrame


 Icsınıf handler = new Icsınıf();
fancyJButton.addActionListener( handler);
plainJButton.addActionListener( handler );


 } // end ButtonFrame constructor

 // inner class for button event handling
 private class Icsınıf implements ActionListener
 {
 // handle button event
 public void actionPerformed( ActionEvent event )
 {
    JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
 "You pressed: %s", event.getActionCommand()));
 } // end method actionPerformed
 } // end private inner class ButtonHandler
 } // end class ButtonFrame
