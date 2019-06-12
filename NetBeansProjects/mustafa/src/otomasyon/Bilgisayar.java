package otomasyon;

public abstract class Bilgisayar extends Ogrenci implements FakulteMuhendislik {

    static Ogrenci bmOgrencileri[] = new Ogrenci[100];//bilgisayar muhendisligi ogrencilerinin bilgilerinin tutuldugu dizi
    static String siniflar[] = {"    d202    ", "    d301    ", "    d701    ", "    a312    "};

    static Ders calculus = new Ders(" Calculus I ", 4, siniflar[1], saatler[0], gunler[0]);
    static Ders fizik = new Ders("  Fizik I   ", 4, siniflar[3], saatler[1], gunler[1]);
    static Ders algoritma = new Ders("Int. to Algo", 4, siniflar[0], saatler[2], gunler[2]);
    static Ders bmg = new Ders("    BMG     ", 2, siniflar[2], saatler[3], gunler[3]);
    static Ders discrete = new Ders("Discrete Mat", 3, siniflar[0], saatler[0], gunler[4]);
    static Ders inklap = new Ders("   İnklap   ", 2, siniflar[2], saatler[0], gunler[3]);
    static Ders turkdili = new Ders(" Turk Dili  ", 2, siniflar[2], saatler[3], gunler[0]);
    static Ders beden = new Ders("Beden Egtimi", 2, siniflar[0], saatler[3], gunler[1]);
    static Ders guzelsanatlar = new Ders("Guzel Santlr", 2, siniflar[2], saatler[1], gunler[3]);
    static Ders lineer = new Ders("Linear Algbr", 3, siniflar[1], saatler[0], gunler[2]);
    static Ders etik = new Ders("Bilsim Etigi", 2, siniflar[0], saatler[2], gunler[3]);
    static Ders dersler[] = {fizik, calculus, algoritma, bmg, discrete, inklap, turkdili, beden, guzelsanatlar, lineer, etik};

    void mensuplar() {/*
        int a = 0;
        String str = "Bilgisayar Muhendisligi";
        for (int i = 0; i < ogrenciSayisi; i++) {
            if (str.equals(super.ogrenciler[0].bolum)) {
                this.ogrenciler[a] = new (Bilgisayar)Ogrenci();
                this.ogrenciler[a].ad = super.ogrenciler[i].ad;
                this.ogrenciler[a].soyad = super.ogrenciler[i].soyad;
                this.ogrenciler[a].kimlikNo = super.ogrenciler[i].kimlikNo;
                this.ogrenciler[a].sifre = super.ogrenciler[i].sifre;
                a++;
            }
        }*/
    }

    static void dersSecimi(Ogrenci ogrenci) {
        int kredi = 0;
        System.out.println("Ders seciniz...(toplam kredi 16-20 arasi olmalidir)");
        System.out.println("1- " + fizik.dersAdi + "/" + fizik.kredi);
        System.out.println("2- " + calculus.dersAdi + "/" + calculus.kredi);
        System.out.println("3- " + algoritma.dersAdi + "/" + algoritma.kredi);
        System.out.println("4- " + bmg.dersAdi + "/" + bmg.kredi);
        System.out.println("5- " + discrete.dersAdi + "/" + discrete.kredi);
        System.out.println("6- " + inklap.dersAdi + "/" + inklap.kredi);
        System.out.println("7- " + turkdili.dersAdi + "/" + turkdili.kredi);
        System.out.println("8- " + beden.dersAdi + "/" + beden.kredi);
        System.out.println("9- " + guzelsanatlar.dersAdi + "/" + guzelsanatlar.kredi);
        System.out.println("10- " + lineer.dersAdi + "/" + lineer.kredi);
        System.out.println("11- " + etik.dersAdi + "/" + etik.kredi);
        boolean d1 = false, d2 = false, d3 = false, d4 = false, d5 = false, d6 = false, d7 = false, d8 = false, d9 = false, d10 = false, d11 = false;//dersin secilip secilmedigini kontrol
        while (kredi < 17) {
            switch (input.nextInt()) {
                case 1:
                    if (d1 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = fizik;
                        ogrenci.dersSayisi++;
                        kredi += 4;
                        System.out.println(fizik.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d1 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 2:
                    if (d2 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = calculus;
                        ogrenci.dersSayisi++;
                        kredi += 4;
                        System.out.println(calculus.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d2 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 3:
                    if (d3 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = algoritma;
                        ogrenci.dersSayisi++;
                        kredi += 4;
                        System.out.println(algoritma.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d3 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 4:
                    if (d4 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = bmg;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(bmg.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d4 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 5:
                    if (d5 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = discrete;
                        ogrenci.dersSayisi++;
                        kredi += 3;
                        System.out.println(discrete.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d5 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 6:
                    if (d6 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = inklap;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(inklap.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d6 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 7:
                    if (d7 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = turkdili;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(turkdili.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d7 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 8:
                    if (d8 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = beden;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(beden.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d8 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 9:
                    if (d9 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = guzelsanatlar;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(guzelsanatlar.dersAdi + "secildi");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d9 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 10:
                    if (d10 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = lineer;
                        ogrenci.dersSayisi++;
                        kredi += 3;
                        System.out.println(lineer.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d10 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                case 11:
                    if (d11 == false) {
                        ogrenci.dersler[ogrenci.dersSayisi] = etik;
                        ogrenci.dersSayisi++;
                        kredi += 2;
                        System.out.println(etik.dersAdi + " secildi.");
                        System.out.println("alınan kredi= " + kredi + " kalan max kredi: " + (20 - kredi));
                        d11 = true;
                    } else {
                        System.out.println("Sectiginiz dersi bir daha secemezsiniz!");
                    }
                    break;
                default:
                    System.out.println("Yanlis secim!");
                    break;
            }
        }
        System.out.println("Secim tamamlandi. Aldiginiz toplam kredi: " + kredi);
    }

    static void dersSecimi(Egitimci egitimci) {
        System.out.println("Verilecek dersi seciniz...");
        for (int i = 0; i < 11; i++) {
            System.out.println((i + 1) + "-" + Bilgisayar.dersler[i].dersAdi);
        }
        switch (input.nextInt()) {
            case 1:
                egitimci.verilenDers = Bilgisayar.dersler[0];
                break;
            case 2:
                egitimci.verilenDers = Bilgisayar.dersler[1];
                break;
            case 3:
                egitimci.verilenDers = Bilgisayar.dersler[2];
                break;
            case 4:
                egitimci.verilenDers = Bilgisayar.dersler[3];
                break;
            case 5:
                egitimci.verilenDers = Bilgisayar.dersler[4];
                break;
            case 6:
                egitimci.verilenDers = Bilgisayar.dersler[5];
                break;
            case 7:
                egitimci.verilenDers = Bilgisayar.dersler[6];
                break;
            case 8:
                egitimci.verilenDers = Bilgisayar.dersler[7];
                break;
            case 9:
                egitimci.verilenDers = Bilgisayar.dersler[8];
                break;
            case 10:
                egitimci.verilenDers = Bilgisayar.dersler[9];
                break;
            case 11:
                egitimci.verilenDers = Bilgisayar.dersler[10];
                break;
        }
    }
}
