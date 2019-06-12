/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Sefa
 */
public class FinalLabel extends JFrame{
    
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public FinalLabel() {
        super("label denemesi");
        
        setLayout(new FlowLayout());
        
        label1 = new JLabel("label1");
        label1.setToolTipText("bu label1  kardeş");
        add(label1);
    }
    
    public static void main(String[] args) {
        FinalLabel label = new FinalLabel();
        label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setSize(250, 250);
        label.setVisible(true);
        label.getContentPane().setBackground(Color.red);
    }
    
    
}
