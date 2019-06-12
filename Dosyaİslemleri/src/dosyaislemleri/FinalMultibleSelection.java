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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Sefa
 */
public class FinalMultibleSelection extends JFrame{
    
    private JList liste1;
    private JList liste2;
    private JButton buton;
    
    private static final String[] isimler = {"sefa", "yunus", "furkan","ömer"};

    public FinalMultibleSelection() {
        
        super("çoklu seçim");
        setLayout(new FlowLayout());
        
        liste1 = new JList(isimler);
        liste1.setVisibleRowCount(2);
        liste1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        add(new JScrollPane(liste1));
        liste2 = new JList();
        
        add(liste2);
        
        buton = new  JButton("kopyala");
        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liste2.setListData(liste1.getSelectedValues());
            }
            
        }
        
        );
       add(buton); 
    }
    
    public static void main(String[] args) {
        FinalMultibleSelection list = new FinalMultibleSelection();
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list.setSize(250, 205);
        list.setVisible(true);
        
    }
 
    
    
}
