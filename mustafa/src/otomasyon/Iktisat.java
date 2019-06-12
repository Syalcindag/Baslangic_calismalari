package otomasyon;

public abstract class Iktisat extends Ogrenci{
    
    static String siniflar[] = {"    d101    ", "    d402    ", "    d610    ", "    a420    "};
    
    static Ders mat = new Ders(" Matematik  ", 4, siniflar[1], saatler[0], gunler[0]);
    static Ders isletme = new Ders("Temel Isltme", 4, siniflar[3], saatler[1], gunler[1]);
    static Ders sosyoloji= new Ders(" Sosyoloji  ", 4, siniflar[0], saatler[2], gunler[2]);
    static Ders iktisat = new Ders("Temel Iktsat", 2, siniflar[2], saatler[3], gunler[3]);
    static Ders makro = new Ders("Makro Eknomi", 3, siniflar[0], saatler[0], gunler[4]);
    static Ders inklap = new Ders("   İnklap   ", 2, siniflar[2], saatler[0], gunler[3]);
    static Ders turkdili = new Ders(" Turk Dili  ", 2, siniflar[2], saatler[3], gunler[0]);
    static Ders beden = new Ders("Beden Egtimi", 2, siniflar[0], saatler[3], gunler[1]);
    static Ders guzelsanatlar = new Ders("Guzel Santlr", 2, siniflar[2], saatler[1], gunler[3]);
    static Ders programlama = new Ders("Temel Prog. ", 3, siniflar[1], saatler[0], gunler[2]);
    static Ders ekonomi = new Ders("  Ekonomi   ", 2, siniflar[0], saatler[2], gunler[3]);
    static Ders dersler[]={mat,isletme,sosyoloji,iktisat,makro,inklap,turkdili,beden,guzelsanatlar,programlama,ekonomi};
    
    static void dersSecimi(Ogrenci ogrenci) {
        int kredi = 0;
        System.out.println("Ders secini...(toplam kredi 16-20 arasi olmalidir)");
        System.out.println("1- " + mat.dersAdi + "/" + mat.kredi);
        System.out.println("2- " + isletme.dersAdi + "/" + isletme.kredi);
        System.out.println("3- " + sosyoloji.dersAdi + "/" + sosyoloji.kredi);
        System.out.println("4- " + iktisat.dersAdi + "/" + iktisat.kredi);
        System.out.println("5- " + makro.dersAdi + "/" + makro.kredi);
        System.out.println("6- " + inklap.dersAdi + "/" + inklap.kredi);
        System.out.println("7- " + turkdili.dersAdi + "/" + turkdili.kredi);
        System.out.println("8- " + beden.dersAdi + "/" + beden.kredi);
        System.out.println("9- " + guzelsanatlar.dersAdi + "/" + guzelsanatlar.kredi);
        System.out.println("10- " + programlama.dersAdi + "/" + programlama.kredi);
        System.out.println("11- " + ekonomi.dersAdi + "/" + ekonomi.kredi);
        boolean d1=false,d2=false,d3=false,d4=false,d5=false,d6=false,d7=false,d8=false,d9=false,d10=false,d11=false;//dersin secilip secilmedigini kontrol
        while(kredi<17){
        switch (input.nextInt()) {
            case 1:
                if(d1==false){
                ogrenci.dersler[ogrenci.dersSayisi] = mat;
                ogrenci.dersSayisi++;
                kredi += 4;
                System.out.println(mat.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d1=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 2:
                if(d2==false){
                ogrenci.dersler[ogrenci.dersSayisi] = isletme;
                ogrenci.dersSayisi++;
                kredi += 4;
                System.out.println(isletme.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d2=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 3:
            if(d3==false){
                ogrenci.dersler[ogrenci.dersSayisi] = sosyoloji;
                ogrenci.dersSayisi++;
                kredi += 4;
                System.out.println(sosyoloji.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d3=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 4:
            if(d4==false){
                ogrenci.dersler[ogrenci.dersSayisi] = iktisat;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(iktisat.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d4=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 5:
            if(d5==false){
                ogrenci.dersler[ogrenci.dersSayisi] = makro;
                ogrenci.dersSayisi++;
                kredi += 3;
                System.out.println(makro.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d5=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 6:
            if(d6==false){
                ogrenci.dersler[ogrenci.dersSayisi] = inklap;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(inklap.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d6=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 7:
            if(d7==false){
                ogrenci.dersler[ogrenci.dersSayisi] = turkdili;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(turkdili.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d7=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 8:
            if(d8==false){
                ogrenci.dersler[ogrenci.dersSayisi] = beden;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(beden.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d8=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 9:
            if(d9==false){
                ogrenci.dersler[ogrenci.dersSayisi] = guzelsanatlar;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(guzelsanatlar.dersAdi+"secildi");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d9=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 10:
            if(d10==false){
                ogrenci.dersler[ogrenci.dersSayisi] = programlama;
                ogrenci.dersSayisi++;
                kredi += 3;
                System.out.println(programlama.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d10=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            case 11:
            if(d11==false){
                ogrenci.dersler[ogrenci.dersSayisi] = ekonomi;
                ogrenci.dersSayisi++;
                kredi += 2;
                System.out.println(ekonomi.dersAdi+" secildi.");
                System.out.println("alınan kredi= "+kredi+" kalan max kredi: "+(20-kredi));
                d11=true;}
                else
                    System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                break;
            default:
                System.out.println("Yanlis secim!");
                break;
            }
        }
        System.out.println("Secim tamamlandi. Aldiginiz toplam kredi: "+kredi);
    }
    static void dersSecimi(Egitimci egitimci) {
        System.out.println("Verilecek dersi seciniz...");
            for (int i = 0; i < 11; i++) {
                System.out.println((i + 1) + "-" + Iktisat.dersler[i].dersAdi);
            }
            switch (input.nextInt()) {
                case 1:
                    egitimciler[egitimciSayisi].verilenDers = Iktisat.dersler[0];
                    break;
                case 2:
                    egitimci.verilenDers = Iktisat.dersler[1];
                    break;
                case 3:
                    egitimci.verilenDers = Iktisat.dersler[2];
                    break;
                case 4:
                    egitimci.verilenDers = Iktisat.dersler[3];
                    break;
                case 5:
                    egitimci.verilenDers = Iktisat.dersler[4];
                    break;
                case 6:
                    egitimci.verilenDers = Iktisat.dersler[5];
                    break;
                case 7:
                    egitimci.verilenDers = Iktisat.dersler[6];
                    break;
                case 8:
                    egitimci.verilenDers = Iktisat.dersler[7];
                    break;
                case 9:
                    egitimci.verilenDers = Iktisat.dersler[8];
                    break;
                case 10:
                    egitimci.verilenDers = Iktisat.dersler[9];
                    break;
                case 11:
                    egitimci.verilenDers = Iktisat.dersler[10];
                    break;
        }
    }
}
