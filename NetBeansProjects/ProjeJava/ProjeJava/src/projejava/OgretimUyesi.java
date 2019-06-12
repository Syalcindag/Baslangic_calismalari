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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class OgretimUyesi extends Baglantı implements Kişiler, Menü{
Connection conn = null;
    Scanner scan = new Scanner(System.in);
    @Override
    public void kaydetme(String isim, String soyisim, int no, String mail) {
        
         //baglantı bolumu
      
         conn = baglantı();
        try{
          conn=  DriverManager.getConnection(host, uName, uPass);
        }
        catch(SQLException ex)
        {
            System.out.println("hata:" + ex.getMessage());
        }
      //baglantı bolumunun bıtimi
        String sql ="INSERT INTO abc.ögretimüyesi(Id, ISIM ,soyisim, mail)VALUES(?, ?, ?, ?)";
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
            Logger.getLogger(OgretimUyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void silme(int no) {
        try{

            //baglantı bolumu
            
            conn =baglantı();
            
            //baglantı bolumunun bıtimi
            
            
            
            //tsblodan veri silme
            String sql = "DELETE FROM abc.ögretimüyesi WHERE id = ?";
            
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
            Logger.getLogger(OgretimUyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
      //baglantı bolumunun bıtimi
        
    }

    @Override
    public void güncelleme(String isim, String soyisim, int no, String mail) {
        try{
                //baglantı bolumu
               conn=baglantı();
                //baglantı bolumunun bıtimi
                
                //tablo da veri güncelleme
                String sql2 ="UPDATE abc.ögretimüyesi SET isim =? soyisim =? mail =? WHERE id =?";
                
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
                Logger.getLogger(OgretimUyesi.class.getName()).log(Level.SEVERE, null, ex);
            }
            //baglantı bolumunun bıtimi
        
    }

    @Override
    public void menü() {
                                
        DersProgramı dersProg = new DersProgramı();
        NotGirişi notgirişi = new NotGirişi();
        SınavProgramı snvProg = new SınavProgramı();
        System.out.println("************************************************************");
                System.out.println("Ögretim üyesi menüsünden seçim yaparak devam edebilirsiniz");
                System.out.println("[ 1 ]Ögretim üyesinin not girişi  \n"
                        + "[ 2 ]Ögretim üyesinin ders programı hazırlaması  \n"
                        + "[ 3 ]ögretim üyesinin sınav proğramı hazırlaması \n"
                        + "[ 4 ]Ögretim üyesinin not sorgulaması  \n"
                        + "[ 5 ]Ögretim üyesinin profili güncellemesi\n"
                        + "[ 6 ]çıkış");
                Scanner scan = new Scanner(System.in);
                int secim3 = scan.nextInt();
                switch(secim3){
                    case 1:
                        notgirişi.menü();
                        break;
                    case 2:
                        dersProg.menü();
                        break;
                    case 3:
                        snvProg.menü();
                        break;
                    case 4:
                        break;
                    case 5:
                        menüOgrUyesiGuncelleme();
                        break;
                    case 6:
                        this.menü();
                        break;
                        
                }
    }

    public void menüOgrUyesiGuncelleme(){
       
        System.out.println("Güncellemek istediginiz öğretim üyesinin numarasını giriniz");
        int ogrUyeno = scan.nextInt();
        System.out.println("Güncellemek istediginiz öğretim üyesinin ismini giriniz");
        String isimUye = scan.next();
        System.out.println("Güncellemek istediginiz öğretim üyesinin soyismini giriniz");
        String soyisimUye = scan.next();
        System.out.println("Güncellemek istediginiz öğretim üyesinin maili giriniz");
        String mailUye = scan.next();
        this.güncelleme(isimUye, soyisimUye, ogrUyeno, mailUye);

    }
    
}
