/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Sefa
 */
public class Ogrenci extends DersAlma implements Kişiler, Menü{
    
   Connection conn = null;
    

    @Override
    public void kaydetme(String isim, String soyisim, int no, String mail) {
       
       
       conn = baglantı();
      //baglantı bolumunun bıtimi
        String sql ="INSERT INTO abc.ogrenci(Id, ISIM ,soyisim, mail )VALUES(?, ?, ?, ?)";
            PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, no);
            ps.setString(2, isim);
            ps.setString(3, soyisim);
            ps.setString(4, mail);
 
           

            int durum =ps.executeUpdate();
            if(durum > 0)
            {
                System.out.println("basarı ile eklendi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void silme( int no) {
        
        try{

      
           conn =baglantı();
            //baglantı bolumunun bıtimi
            
            
            
            //tsblodan veri silme
            String sql = "DELETE FROM abc.ogrenci WHERE id = ?";
            
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1,no );
            int sonuc = ps.executeUpdate();
            if(sonuc > 0)
            {
                System.out.println("basarı ile silindi");
            }
            //tablodan veri silme sonu
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
      //baglantı bolumunun bıtimi
       
    }

    @Override
    public void güncelleme(String isim, String soyisim, int no, String mail) {
            try{
                //baglantı bolumu

               conn = baglantı();
                //baglantı bolumunun bıtimi
                
                //tablo da veri güncelleme
                String sql2 ="UPDATE abc SET isim =? soyisim =? mail =? WHERE id =?";
                
                PreparedStatement ps =conn.prepareStatement(sql2);
                ps.setInt(1, no);
                ps.setString(2,isim );
                ps.setString(3, soyisim);
                ps.setString(4, mail);
                int rowupdate = ps.executeUpdate();
                if(rowupdate > 0)
                {
                    System.out.println("basarı ile eklendi");
                }
                //tabloda veri güncelleme sonu
                
            }
            catch(SQLException ex)
            {
                Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
            }
            //baglantı bolumunun bıtimi

    }

    @Override
    public void menü() {
        System.out.println("**********************************************************");
                System.out.println("Öğrenci menüsünden seçim yaparak devam edebilirsiniz");
                System.out.println("[ 1 ] Ögrencinin notu görüntülemesi \n"
                        + "[ 2 ]Ögrencinin ders alma işlemleri  \n"
                        + "[ 3 ]Ögrencinin ders programını görmesi  \n"
                        + "[ 4 ] Ögrencinin sınav programını göremesi \n"
                        + "[ 5 ] geri");
                int secim2 = scan.nextInt(6);
                Ogrenci ogr =new Ogrenci();
                NotGirişi not = new NotGirişi();
                switch(secim2){
                    case 1:
                        not.menü();
                    break;
                    case 2:
                        
                        super.menü();
                        
                    break;    
                    case 3:
                        DersProgramı dersProg = new DersProgramı();
                        dersProg.dersProgramı();
                    break;
                    case 4:
                        SınavProgramı snvProg = new SınavProgramı();
                        snvProg.sınavProgramı();
                      break;
                    case 5:
                        Ogrenciİşleri ogrişleri =new Ogrenciİşleri();
                        ogrişleri.menü();
                        break;

                     
                }
    }
    
    
    
    
}
