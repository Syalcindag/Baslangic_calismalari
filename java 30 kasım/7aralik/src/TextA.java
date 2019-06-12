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
import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 import javax.swing.JPasswordField;
 import javax.swing.JOptionPane;

 public class TextA extends JFrame
 {
 private JTextField textField1; // text field with set size
 private JTextField textField2; // text field constructed with text
 private JTextField textField3; // text field with text and size
 private JPasswordField passwordField; // password field with text
 
 // TextFieldFrame constructor adds JTextFields to JFrame
 public TextA()
 {
 super( "Testing JTextField and JPasswordField" );
 setLayout( new FlowLayout() ); // set frame layout


 textField1 = new JTextField( 10 );
 add( textField1 ); // add textField1 to JFrame


 textField2 = new JTextField( "Enter text here");
 add( textField2 ); // add textField2 to JFrame

 // construct textfield with default text and 21 columns
textField3 = new JTextField( "Uneditable text field", 21 );
textField3.setEditable( false ); // disable editing


 add( textField3 ); // add textField3 to JFrame

 // construct passwordfield with default text
 passwordField = new JPasswordField( "Hidden text" );
 add( passwordField ); // add passwordField to JFrame
  
 // register event handlers
 IcSinif handler = new IcSinif();
textField1.addActionListener( handler );
textField2.addActionListener( handler );
textField3.addActionListener( handler );
passwordField.addActionListener( handler );

 } // end TextFieldFrame constructor

 // private inner class for event handling
 private class IcSinif implements ActionListener
 {
 // process text field events
 public void actionPerformed( ActionEvent event )
 {
 String string = ""; // declare string to display

 // user pressed Enter in JTextField textField1
 if( event.getSource() == textField1)
 string = String.format( "textField1: %s",
 event.getActionCommand());

 // user pressed Enter in JTextField textField2
 else if( event.getSource() == textField2)
 string = String.format( "textField2: %s",
 event.getActionCommand());

 // user pressed Enter in JTextField textField3
 else if(event.getSource() == textField3 )
 string = String.format( "textField3: %s",
 event.getActionCommand());

 // user pressed Enter in JTextField passwordField
 else if( event.getSource() == passwordField)
 string = String.format( "passwordField: %s",
 event.getActionCommand());

 
 // display JTextField content
 JOptionPane.showMessageDialog( null,string );
 } // end method actionPerformed
 
 } // end private inner class TextFieldHandler

 
 } // end class TextFieldFrame
