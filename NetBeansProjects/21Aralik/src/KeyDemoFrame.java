/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pelin
 */
import java.awt.Color;
 import java.awt.event.KeyListener;
 import java.awt.event.KeyEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
 {
 private String line1 = ""; // first line of textarea
 private String line2 = ""; // second line of textarea
 private String line3 = ""; // third line of textarea
 private JTextArea textArea; //
public KeyDemoFrame()
 {
 super( "Demonstrating Keystroke Events" );

 textArea = new JTextArea( 10, 15 ); // set up JTextArea
 textArea.setText( "Press any key on the keyboard..." );
 textArea.setEnabled( false ); // disable textarea
 textArea.setDisabledTextColor( Color.BLACK ); // set text color
 textArea.setBackground(Color.yellow);
 
 add( textArea ); // add textarea to JFrame

 addKeyListener( this ); // allow frame to process key events
 } // end KeyDemoFrame constructor

 // handle press of any key
public void keyPressed( KeyEvent event )
 {
 line1 = String.format( "Key pressed: %s",
 KeyEvent.getKeyText( event.getKeyCode() )); // show pressed key
 setLines2and3( event ); // set output lines two and three
 } // end method keyPressed

 // handle release of any key
public void keyReleased( KeyEvent event )
 {
 line1 = String.format( "Key released: %s",
 KeyEvent.getKeyText( event.getKeyCode() )); // show released key
 setLines2and3( event ); // set output lines two and three
 } // end method keyReleased

 // handle press of an action key
public void keyTyped( KeyEvent event )
 {
     System.out.println("event.getKeyChar() = " + event.getKeyChar());
 line1 = String.format( "Key typed: %s",event.getKeyChar() );
 setLines2and3( event ); // set output lines two and three
 } // end method keyTyped

 // set second and third lines of output
 private void setLines2and3( KeyEvent e )
 {
 line2 = String.format( "This key is %san action key",
 ( e.isActionKey()?"" : "not " ) );

String temp = KeyEvent.getKeyModifiersText( e.getModifiers() );

 line3 = String.format( "Modifier keys pressed: %s",
 ( temp.equals( "" ) ? "none" : temp ) ); // output modifiers

 textArea.setText( String.format( "%s\n%s\n%s\n",
 line1, line2, line3 ) ); // output three lines of text
 } // end method setLines2and3
 } // end class KeyDemoFrame
