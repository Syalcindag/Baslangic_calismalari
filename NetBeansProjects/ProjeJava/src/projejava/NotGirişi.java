/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class NotGirişi extends Dersler{
     
    String host = "jdbc:derby://localhost:1527/admin";
    String uName = "abc";
    String uPass = "abc";
    Scanner scan = new Scanner(System.in);
 
    public void menü(){
        System.out.println("*********************************");
      
        System.out.println("Notunu girmek istediginiz ögrencinin numarasını giriniz");
        int no = scan.nextInt();
      
        notVermeİŞlemleri(no);
    }
    
    
    
    
    
    public void notVermeİŞlemleri(int no){
         
            

                
                    int ders1, ders2, ders3, ders4, ders5;
                    
                    
                        
                        
                        
                        
                        
                        
                        try {

                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            Connection conn = null;
                            
                            try {
                                conn = DriverManager.getConnection(host, uName, uPass);
                            } catch (SQLException ex) {
                                Logger.getLogger(DersAlma.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Statement sttm = conn.createStatement();
                            String sql1 = "SELECT * FROM abc.dersalma";
                            String sql = "INSERT INTO abc.notgirişi(id, lojik, devreler, nesne, olasılık )VALUES(?, ?, ?, ?, ?)";
                            
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ResultSet rs = sttm.executeQuery(sql1);
                            rs.next();
                            if(rs.getInt(1) == no){                            
                                ders2 = rs.getInt(2);
                                ders3 = rs.getInt(3);
                                ders4 = rs.getInt(4);
                                ders5 = rs.getInt(5);
                                ps.setInt(1, no);
                                if(ders2 == 1)
                                {
                                    System.out.println("lojik notunu giriniz");
                                    int notlojık=scan.nextInt();
                                    ps.setInt(2, notlojık);
                                }
                                else
                                    ps.setInt(2, 0);
                                if(ders3 == 1 )
                                {
                                    System.out.println("Devreler ve sistemler notunu giriniz");
                                    int notDevreler=scan.nextInt();
                                    ps.setInt(3, notDevreler);
                                }
                                else
                                    ps.setInt(3, 0);
                                if(ders4 == 1)
                                {
                                    System.out.println("Nesneye Yönelik programlama notunu giriniz");
                                    int notNesne=scan.nextInt();
                                    ps.setInt(4, notNesne);
                                }
                                else
                                    ps.setInt(4, 0);
                                if(ders5 == 1)
                                {
                                       System.out.println("Olasılık notunu giriniz");
                                    int notOlasılık=scan.nextInt();
                                    ps.setInt(5, notOlasılık);
                                }
                                else
                                    ps.setInt(5, 0);
                            }
                            else 
                                System.out.println("Bu numaraya sahip ögrenci Henüz ders seçimi yapmamış");
                            
                           
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(NotGirişi.class.getName()).log(Level.SEVERE, null, ex);
                        }
             

}
}


