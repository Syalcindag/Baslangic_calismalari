/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author PELIN
 */

import java.awt.FlowLayout;
 import java.awt.event.ItemListener;
 import java.awt.event.ItemEvent;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JComboBox;
 import javax.swing.Icon;
 import javax.swing.ImageIcon;

 public class ComboBoxFrame extends JFrame
 {
 private JComboBox imagesJComboBox; // combobox to hold names of icons
 private JLabel label; // label to display selected icon

 private static final String[] names =
 { "bug1.png", "bug2.png", "bug3.png", "bug4.png" };
 private Icon[] icons = {
 new ImageIcon( getClass().getResource( names[ 0 ] ) ),
 new ImageIcon( getClass().getResource( names[ 1 ] ) ),
 new ImageIcon( getClass().getResource( names[ 2 ] ) ),
 new ImageIcon( getClass().getResource( names[ 3 ] ) ) };

 // ComboBoxFrame constructor adds JComboBox to JFrame
 public ComboBoxFrame()
 {
 super( "Testing JComboBox" );
 setLayout( new FlowLayout() ); // set frame layout
imagesJComboBox = new JComboBox( names ); // set up JComboBox
imagesJComboBox.setMaximumRowCount( 10 ); // display three rows
imagesJComboBox.setSelectedItem("bug4.png");

imagesJComboBox.addItemListener(new IcSinif());
add( imagesJComboBox ); // add combobox to JFrame
 label = new JLabel( icons[ 3 ] ); // display first icon
 add( label ); // add label to JFrame
 } // end ComboBoxFrame constructor
 private class IcSinif implements ItemListener
{
// handle JComboBox event
public void itemStateChanged( ItemEvent event )
{
    System.out.println(event.getStateChange() );
   //System.out.println(imagesJComboBox.getSelectedIndex() );
 if ( event.getStateChange() == ItemEvent.SELECTED )
  label.setIcon( icons[imagesJComboBox.getSelectedIndex() ] );
} // end method itemStateChanged
} // end anonymous inner class
 // end call to addItemListener

} // end class ComboBoxFrame