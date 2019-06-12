/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adisyon;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sefa
 */
public class deneme1 {

    JPanel panel1, panel2;
    JButton buton1, buton2;
    
    public deneme1() {
        panel1 =new JPanel();
        panel1.setSize(250, 350);
        panel1.add(buton1);
        panel2 =new JPanel();
        panel2.setSize(250, 350);
        panel2.add(buton1);
        panel2.setVisible(false);
        
        
        
    }
    
    public static void main(String[] args) {
        deneme1 dnm =new deneme1();
      
    }
    
}
