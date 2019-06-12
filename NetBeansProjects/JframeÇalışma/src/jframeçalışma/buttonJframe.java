/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframeçalışma;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Sefa
 */
public class buttonJframe extends JFrame{
    
    private final JButton plainJButton;
    private JButton fancyJButton;
     
    

    public buttonJframe()
    {
        super("Testing buttons");
        String location1 ="C:\\Users\\Sefa\\Documents\\NetBeansProjects\\7aralik\\build\\classes\\bug1.png";
        String location2 ="C:\\Users\\Sefa\\Documents\\NetBeansProjects\\7aralik\\build\\classes\\bug2.png";
        setLayout( new FlowLayout());
        plainJButton = new JButton("plain button");
        add(plainJButton);//add plainJBUtton to JFrame
        System.out.println("URL = " + getClass().getResource(location1));
        System.out.println("URL = " + getClass().getResource(location2));
        Icon bug1 = new ImageIcon(location2);
        Icon bug2 = new ImageIcon(location1);
    
        fancyJButton = new JButton("Francy Button", bug1);//set image
        fancyJButton.setRolloverIcon(bug2);//set rollover image
    
        add(fancyJButton);//add fancyJButton to JFrame
    Icsınıf handler = new Icsınıf();
    fancyJButton.addActionListener(handler);
    plainJButton.addActionListener(handler);
    }

    
    
    private class Icsınıf implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(buttonJframe.this, String.format("you pressed: %s",
                    e.getActionCommand()));
         }
        
        
    
    }
    }
