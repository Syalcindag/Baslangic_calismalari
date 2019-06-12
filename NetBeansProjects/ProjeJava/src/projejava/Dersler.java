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
public class Dersler extends GenelDersSecimi{

    public void setDers1(String ders1) {
        this.ders1 = ders1;
    }

    public void setDers2(String ders2) {
        this.ders2 = ders2;
    }

    public void setDers3(String ders3) {
        this.ders3 = ders3;
    }

    public void setDers4(String ders4) {
        this.ders4 = ders4;
    }

    public void setDers5(String ders5) {
        this.ders5 = ders5;
    }
     
    
    public void dersler(){
        System.out.println("Bilgisayar mühendisliği  dersleri\n"
                + "[ 1 ] Lojik Devre tasarımı\n"
                + "[ 2 ] Devreler ve Sistemler\n"
                + "[ 3 ] Veri Yapıları\n"
                + "[ 4 ] Nesneye yönelik programlama\n"
                + "[ 5 ] Olasılık\n");
    }
    
}
