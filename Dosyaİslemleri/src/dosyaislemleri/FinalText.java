/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sefa
 */
public class FinalText extends JFrame{
    private JTextField text1;

    public FinalText() {
        super("birinci text");
        setLayout(new FlowLayout());
         
        text1 = new JTextField("enter text here");
        add(text1);
        text1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, e.getActionCommand());
            }
        });
    }
    public static void main(String[] args) {
     
        FinalText text = new FinalText();
        text.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setSize(300, 300);
        text.setVisible(true);
    }
    
    
}
