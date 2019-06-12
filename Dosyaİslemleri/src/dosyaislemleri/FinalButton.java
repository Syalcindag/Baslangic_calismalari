/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sefa
 */
public class FinalButton extends JFrame{
    private JButton birincibuton;
    private JButton ikincibuton;

    public FinalButton() {
        super("buton denemesi");
        setLayout(new FlowLayout());
        
        birincibuton = new JButton("birinci Buton");
        add(birincibuton);
        
        birincibuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FinalButton.this, String.format("you pressed %s", e.getActionCommand()));
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        FinalButton button = new FinalButton();
        button.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setSize(275, 310);
        button.setVisible(true);
    }
  
    
}
