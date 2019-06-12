/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package çıkmışsoru;

import com.sun.java.accessibility.util.SwingEventMonitor;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author wijdan
 */
public class Exam extends JFrame {

   private JTextField T1 ,T2,T3,T4;
   private JLabel L1 , L2 , L3 , L4 ,L5 ;
   private JRadioButton R1 ,R2 ,R3;
   private JButton B ;
   private JCheckBox C ;
   static boolean yuzde = false;
   static String yil =null ;
   
   
   Exam()
   {
       super("kredi karti harcama");     
       setLayout(new FlowLayout());
       L1= new JLabel("giyim");
       L2=new JLabel("saglik");
       L3= new JLabel("gida");
       L4 = new JLabel("elektronik");
       L5 = new JLabel();
       T1 = new JTextField(10);
        T2 = new JTextField(10);
        T3 = new JTextField(10);
        T4 = new JTextField(10);
        R1 = new JRadioButton("2011");
        R2 = new JRadioButton("2012");
        R3 = new JRadioButton("2013"); 
        add(L1); 
        add(T1);
        RadioB a = new RadioB();
        R1.addItemListener(a);
        add(R1);
         add(L2); 
        add(T2);
        R2.addItemListener(a);
        add(R2);
         add(L3); 
        add(T3);
        R3.addItemListener(a);
        add(R3);
         add(L4); 
        add(T4);
        
        C= new JCheckBox("Yuzde hesapla");
        CheckBoxHandler xx = new CheckBoxHandler();
        C.addItemListener(xx);
        add(C);
        Button mm = new Button();
           B = new JButton("sonuc");
        B.addActionListener(mm);
        add(B);
        add(L5);
        
   }
   class CheckBoxHandler implements ItemListener
   {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(C.isSelected())
                yuzde=true;
            else
                yuzde=false;
        }
       
   }
  
   class Button implements ActionListener
   {
  
  
        public void actionPerformed(ActionEvent e) {
            if(yuzde==true)
            {
                
                L5.setText(yil+"yillinda giyimde %"+String.valueOf(T1.getText())+",%saglik "+String.valueOf(T2.getText())+",%gida"+String.valueOf(T3.getText())+",%elektroink"+String.valueOf(T4.getText()));
            }
            else
            {
                
                int toplam = Integer.valueOf(T1.getText())+
          Integer.valueOf(T2.getText())+Integer.valueOf(T3.getText())+Integer.valueOf(T4.getText());
                L5.setText(yil+"yillinda giyimde "+String.valueOf(T1.getText())+"TL"+",saglik "+String.valueOf(T2.getText())+"TL  gida"+String.valueOf(T3.getText())+"TL ,elektroink"+String.valueOf(T4.getText())+"toplam ="+toplam +"TL ");
        }}
       
   }
   class RadioB implements ItemListener
   {
       public void itemStateChanged(ItemEvent e)
       {
           if(R1.isSelected())
               yil=R1.getText();
           else if (R2.isSelected())
               yil=R2.getText();
           else
            yil=R3.getText();
       }
   }
  public static void main(String [] args)
  {
    java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
               Exam demo = new Exam();
               demo.setSize(300,300);
               demo.setVisible(true);
 }
        });
            }
}



    

