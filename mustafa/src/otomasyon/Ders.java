package otomasyon;

public class Ders extends Otomasyon{
    
    Egitimci verenHocalar[];
    Ogrenci alanOgrenciler[];
    String dersAdi;
    int kredi;
    int gecmeNotu;
    String sinif;
    String saat;
    String gun;
    int puan=-1;
    
    Ders(){
        int o=0;
        int e=0;
    };
    Ders(String dersAdi,int kredi,String sinif,String saat,String gun){
        this.dersAdi=dersAdi;
        this.kredi=kredi;
        this.sinif=sinif;
        this.saat=saat;
        this.gun=gun;
        int o=0;
        int e=0;
        /*for(int i=0;i<ogrenciSayisi;i++){
            for(int j=0;j<ogrenciler[i].dersSayisi;j++){
                String str=ogrenciler[i].dersler[j].dersAdi;
                if(str.equals(dersAdi)){
                    alanOgrenciler[o++]=ogrenciler[i];
                }
            }
        }
        for(int i=0;i<egitimciSayisi;i++){
            for(int j=0;j<egitimciler[i].dersSayisi;j++){
                String str=egitimciler[i].dersler[j].dersAdi;
                if(str.equals(dersAdi)){
                    verenHocalar[e++]=egitimciler[i];
                }
            }
        }*/
    }
}
