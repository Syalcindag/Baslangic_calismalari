/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

/**
 *
 * @author Sefa
 */
public interface Kişiler {
    public void kaydetme(String isim , String soyisim , int no, String mail);
    public void silme(int no);
    public void güncelleme(String isim , String soyisim , int no, String mail);
    
}
