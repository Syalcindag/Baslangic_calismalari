/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyaislemleri;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Sefa
 */
public class Finallist extends JFrame{
    
    private JList renklistesi;
    
    private static final String [] renkİsimleri = {"siyah", "mavi","beyaz"};
    private static final Color[] renkler = { Color.BLACK, Color.BLUE, Color.WHITE};
    
    public Finallist(){
        super("liste deneme");
        setLayout(new FlowLayout());
        
        renklistesi = new JList(renkİsimleri);
        renklistesi.setVisibleRowCount(2);
        
        renklistesi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(renklistesi));
        
        renklistesi.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(renkler[renklistesi.getSelectedIndex() ] );
                
            }
        });
    }   
    
    public static void main(String[] args) {
        Finallist list = new Finallist();
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list.setSize(300, 200);
        list.setVisible(true);
    }
}
