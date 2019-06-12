/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dnm extends JFrame implements ActionListener {
     private int clickCount = 0;
     static JButton button1  = new JButton("Click Me!"), exitButton= new JButton("Exit");
     @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == button1) {
        clickCount++;
        if (clickCount == 1)
          button1.setText("clicked!");
        else
          button1.setText("clicked " + clickCount + " times!");
      } else if (e.getSource() == exitButton) {
        if (clickCount > 0)
          System.exit(0);
        else {
          JOptionPane.showMessageDialog(this, "You must click at least once!"+clickCount,
              "Title", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  public static void main(String[] args) {
  Dnm a=new Dnm();
  

  
    a.setSize(275, 100);
    //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel1 = new JPanel();

    button1.addActionListener(a);
    panel1.add(button1);

    exitButton.addActionListener(a);
    panel1.add(exitButton);
    a.add(panel1);

    a.setVisible(true); 
  

}}

