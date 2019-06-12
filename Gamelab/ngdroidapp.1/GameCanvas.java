package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Color;

import java.util.Vector;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.core.SoundManager;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */

public class GameCanvas extends BaseCanvas {




    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    //region DEĞİŞKENLER
    private static final int GEMIOZELLIGI_TUR = 0, GEMIOZELLIGI_AKS = 1,
            GEMIOZELLIGI_POSX = 2, GEMIOZELLIGI_POSY = 3, GEMIOZELLIGI_CAN = 4,
            GEMIOZELLIGI_HIZ = 5, GEMIOZELLIGI_SD = 6,
            GEMIOZELLIGI_YON = 7, GEMIOZELLIGI_DEGER = 8, GEMIOZELLIGI_PUAN = 9,
            GEMIOZELLIGI_ATESSABITI = 10, GEMIOZELLIGI_ATESSAYACI = 11;

    private static final int MERMIOZELLIGI_TUR = 0, MERMIOZELLIGI_DOGX = 1,
            MERMIOZELLIGI_DOGY = 2, MERMIOZELLIGI_POSX = 3,
            MERMIOZELLIGI_POSY = 4, MERMIOZELLIGI_HIZ = 5,
            MERMIOZELLIGI_YON = 6;
    private int gemiTuruAdedi = 4;

    //patlama ile ilgili indexler
    private static final int X_MERKEZ_P = 0, Y_MERKEZ_P = 1, AKS_PATLAMA = 2;

    // platform ile ilgili indexler
    private boolean platformCizOnay = true;
    private int platformSayaci = 0;
    //platform koordinatları
    private  int  solPlatformX = 156, solPlatformY = 1215, sagPlatformX = 669, sagPlatformY = 1215;
    // platform efekti
    private Bitmap platformAnimasyon[];
    private Vector<Vector<Integer>> platformlar = new Vector<Vector<Integer>>();
    private Vector<Integer> platformYeni;
    //slotCiz parametreleri
    private int slotOzellikCerceveX, slotOzellikCerceveY, slotOzellikCanX, slotOzellikCanY, slotOzellikHizX, slotOzellikHizY, slotOzellikGucX, slotOzellikGucY;
    private int slotBayrak;
    private boolean slotAcikMi = true;
    private int bekleme = 0;
    private long baslangic = 0, bitis = 0;

    // fiyat cerceve resim
    private Bitmap fiyatResimleri[] = new Bitmap[2];
    private int gemiFiyatCerceveY[];

    private Canvas canvas;

    private Bitmap oyunArkaplan;
    private Bitmap gemiAnimasyonlari[][];
    private Bitmap mermiResimleri[] = new Bitmap[2];


    // pause fonksiyonu parametreleri
    private boolean oyunDevamEdiyor = true;
    //Gemilerin doğacağı koordinatlar
    private int dusmanGemisiDogumX = 282,
            dusmanGemisiDogumY = 300,
            oyuncuGemisiDogumX = 282,
            oyuncuGemisiDogumY = 1360;

    private Vector<Vector<Integer>> oyuncuGemileri = new Vector<Vector<Integer>>();
    private Vector<Vector<Integer>> dusmanGemileri = new Vector<Vector<Integer>>();
    private Vector<Vector<Integer>> oyuncuMermileri = new Vector<Vector<Integer>>();
    private Vector<Vector<Integer>> dusmanMermileri = new Vector<Vector<Integer>>();

    private Vector<Integer> oyuncuYeniGemi;
    private Vector<Integer> dusmanYeniGemi;
    private Vector<Integer> oyuncuMermi;
    private Vector<Integer> dusmanMermi;

    private int slotOrtaNoktalariX[] = new int[4];
    private int slotOrtaNoktalariY;
    //region OyunSonucu
    private  Bitmap oyunSonucuKaybettin, oyunSonucuKazandin, fluArkaPlan, oyunGeriDugme, oyunYenidenBaslatDugme;
    private boolean kazandiniz, kaybettin = false;
    //endregion
    private int fark = 0;
    private int sayac = 0;
    private int mermiMenzil = 410;      //merminin yaşam menzili
    private int yon;                    //oyunun sağda mı solda mı başlayacağını belirtir
    private int mermiHasar = 25;



    //region Patlama efekti
    private Bitmap patlamaEfekti;
    private Vector<Vector<Integer>> patlamalar = new Vector<Vector<Integer>>();
    private Rect patlamaKareleri[] = new Rect[16];
    //endregion

    //region Para fonksiyonu ve puan parametreleri
    private int toplamPara, paraYaziPosX, paraYaziPosY,
            gemiParaYaziKordinatX[], gemiParaYaziKordinatY[], gemiFiyat[];
    private Paint renk;
    private Bitmap paraCerceve, puanCerceve;
    private int toplamPuan, puanYaziPosX, puanYaziPosY, puanSayı[];
    //endregion

    //Döngü değişkenleri
    private int ogc_i, dgc_i, patlama_i, pc_i, dmi_i, dmi_j, plat_anim_i, pat_efkt_i, gemi_anim_i,  oGemi_i, dmc_i, omc_i, sc_i, fcc_i, fc_i, bc_i, dmu_i, omu_i,
            dMermiIler_i, oMermiIler_i, menzilDusman_j, menzilDusman_i, menzilTest_j, menzilTest_i, dGemiIler, oGemiIler_i, dGemi_i;                          //---sefa----

    //region Oyun içi ayarlar parametreleri
    private Bitmap ayarlarResim, geriResim, sesResim;

    private boolean ayarAcikMi = false;

    final private int BUTON_RESIM_ID = 0, BUTON_MERKEZ_X = 1, BUTON_MERKEZ_Y = 2, BUTON_VARLIK_X = 3, BUTON_VARLIK_Y = 4, BUTON_GORUNURLUK = 5;
    final private int BUTON_AYARLAR = 0, BUTON_SES = 1, BUTON_GERI = 2;


    private Vector<Vector<Integer>> butonlar = new Vector<Vector<Integer>>();

    //endregion Oyun içi ayarlar parametreleri - SON

    //endregion DEĞİŞKENLER - SON

    //kurulum fonksiyonu
    public void setup() {
        //region Oyun içi ayarlar parametreleri


        butonUret(root.RESIM_AYARLAR,1010,60,true);
        butonUret(root.RESIM_SES,1010,180,false);
        butonUret(root.RESIM_GERI,1010,300,false);
        //endregion Oyun içi ayarlar parametreleri - SON


        //region OyunSonucu tanımları
        oyunSonucuKaybettin = Utils.loadImage(root,"kaybetti.png");
        oyunSonucuKazandin = Utils.loadImage(root,"kazandi.png");
        fluArkaPlan = Utils.loadImage(root,"map_bulanik.png");
        oyunGeriDugme = Utils.loadImage(root,"geri_don.png");
        oyunYenidenBaslatDugme = Utils.loadImage(root,"yeniden_baslat.png");
        oyunDevamEdiyor = true;
        //endregion OyunSonucu tanımları
        //region Para ve Puan Yüklemeleri
        // para fonksiyon yüklenecekler
        gemiParaYaziKordinatX = new int[4];
        gemiParaYaziKordinatX[0] = 206;
        gemiParaYaziKordinatX[1] = 476;
        gemiParaYaziKordinatX[2] = 746;
        gemiParaYaziKordinatX[3] = 1005;
        gemiParaYaziKordinatY = new int[4];
        gemiParaYaziKordinatY[0] = 1742;
        gemiParaYaziKordinatY[1] = 1742;
        gemiParaYaziKordinatY[2] = 1742;
        gemiParaYaziKordinatY[3] = 1742;

        // gemi fiyat tanımlamaları
        gemiFiyat = new int[4];
        gemiFiyat[0] = 25;
        gemiFiyat[1] = 50;
        gemiFiyat[2] = 75;
        gemiFiyat[3] = 100;

        // puan fonksiyon yüklenecekler
        puanSayı = new int[4];
        puanSayı[0] = 100;
        puanSayı[1] = 200;
        puanSayı[2] = 300;
        puanSayı[3] = 400;

        // baslangıc puanı
        toplamPuan = 0;
        puanYaziPosX = 90;
        puanYaziPosY = 135;

        // baslangıc parası ve
        toplamPara = 100;
        paraYaziPosX = 90;
        paraYaziPosY = 75;

        // para çizimi
        paraCerceve = Utils.loadImage(root,"coin_icon.png");
        // puan cizimi
        puanCerceve = Utils.loadImage(root,"puan_icon.png");

        // yazı tipi
        renk = new Paint();
        renk.setColor(Color.WHITE);
        renk.setStyle(Paint.Style.FILL);
        renk.setTextSize(40);
        //endregion Para ve Puan Yüklemeleri



        //Platform efekti resimlerinin yüklenmesi
        platformAnimasyon = new Bitmap[25];
        for ( plat_anim_i = 0; plat_anim_i < platformAnimasyon.length; plat_anim_i++){
            platformAnimasyon[plat_anim_i] = Utils.loadImage(root,"animasyon/platform_" + plat_anim_i + ".png");
        }


        //Fiyat cercevenin ayarlanması
        gemiFiyatCerceveY = new int [4];
        gemiFiyatCerceveY[0] = 1700;
        gemiFiyatCerceveY[1] = 1700;
        gemiFiyatCerceveY[2] = 1700;
        gemiFiyatCerceveY[3] = 1700;


        fiyatResimleri[0] = Utils.loadImage(root,"para_kapali.png");
        fiyatResimleri[1] = Utils.loadImage(root,"para_acik.png");


        oyunArkaplan = Utils.loadImage(root, "map.png"); //Arkaplan fotoğrafı yükleniyor

        //Slot posizyonları belirleniyor:
        slotOrtaNoktalariY = 1806;
        slotOrtaNoktalariX[0] = 134;
        slotOrtaNoktalariX[1] = 404;
        slotOrtaNoktalariX[2] = 674;
        slotOrtaNoktalariX[3] = 944;




        //Patlama efekti resimlerinin yüklenmesi
        patlamaEfekti = Utils.loadImage(root, "explosion.png");
        for ( pat_efkt_i = 0; pat_efkt_i < 16; pat_efkt_i++) {
            patlamaKareleri[pat_efkt_i] = new Rect((pat_efkt_i % 4) * 64, (pat_efkt_i / 4) * 64,
                    ((pat_efkt_i % 4) + 1) * 64, ((pat_efkt_i / 4) + 1) * 64);
        }


        //Gemi resimlerinin yüklemelelerinin olduğu yer.
        gemiAnimasyonlari = new Bitmap[4][];
        gemiAnimasyonlari[0] = new Bitmap[25];
        gemiAnimasyonlari[1] = new Bitmap[16];
        gemiAnimasyonlari[2] = new Bitmap[25];
        gemiAnimasyonlari[3] = new Bitmap[25];

        for (gemi_anim_i = 0; gemi_anim_i < gemiAnimasyonlari.length; gemi_anim_i++) {
            for (int j = 0; j < gemiAnimasyonlari[gemi_anim_i].length; j++) {
                gemiAnimasyonlari[gemi_anim_i][j] = Utils.loadImage(root, "animasyon/ship_" + (gemi_anim_i + 1) + "_" + (j + 1) + ".png");
            }
        }

        mermiResimleri[0] = Utils.loadImage(root, "mavi_ates.png");        //Oyuncu ateş yükleniyor
        mermiResimleri[1] = Utils.loadImage(root, "kirmizi_ates.png");     //Düşman ateş yükleniyor
        root.oyunMuzik.prepare();
        root.oyunMuzik.start();
    }

    //region UPDATE FONKSİYONLARI
    public void update() {
        if(oyunDevamEdiyor == true) {
            dusmanGemiUret();
            oyuncuGemiIlerlet();
            dusmanGemiIlerlet();
            oyuncuMermiIlerlet();
            dusmanMermiIlerlet();
            menzilTesti();
            oyunBitti();
            slotOzellikCizimSuresi();
        }
    }
    private void slotOzellikCizimSuresi() {
        bekleme++;
        if(bekleme <= 15) {
            slotAcikMi = true;
        } else {
            slotAcikMi = false;

        }
    }
    private void oyunBitti() {
        for(oGemi_i = 0; oGemi_i <oyuncuGemileri.size(); oGemi_i++){
            if(oyuncuGemileri.get(oGemi_i).get(GEMIOZELLIGI_POSY)  <= dusmanGemisiDogumY){
                oyunDevamEdiyor = false;
                kazandiniz = true;
                return;
            }
        }

        for(dGemi_i= 0;dGemi_i<dusmanGemileri.size();dGemi_i++){
            if(dusmanGemileri.get(dGemi_i).get(GEMIOZELLIGI_POSY) + gemiAnimasyonlari[dusmanGemileri.get(dGemi_i).get(GEMIOZELLIGI_TUR)][0].getHeight()/2 >= oyuncuGemisiDogumY){
                oyunDevamEdiyor = false;
                kaybettin = true;
                return;
            }
        }
    }
    private void oyuncuGemiIlerlet() {
        for (oGemiIler_i = 0; oGemiIler_i < oyuncuGemileri.size(); oGemiIler_i++) {
            if (oyuncuGemileri.get(oGemiIler_i).get(GEMIOZELLIGI_POSY) > dusmanGemisiDogumY &&
                    oyuncuGemileri.get(oGemiIler_i).get(GEMIOZELLIGI_SD) == 0) {
                oyuncuGemileri.get(oGemiIler_i).set(GEMIOZELLIGI_POSY, oyuncuGemileri.get(oGemiIler_i).get(GEMIOZELLIGI_POSY)
                        - oyuncuGemileri.get(oGemiIler_i).get(GEMIOZELLIGI_HIZ));
            }
        }
    }
    private void dusmanGemiIlerlet() {
        for (dGemiIler = 0; dGemiIler < dusmanGemileri.size(); dGemiIler++) {
            if (dusmanGemileri.get(dGemiIler).get(GEMIOZELLIGI_POSY) < oyuncuGemisiDogumY &&
                    dusmanGemileri.get(dGemiIler).get(GEMIOZELLIGI_SD) == 0) {
                dusmanGemileri.get(dGemiIler).set(GEMIOZELLIGI_POSY, dusmanGemileri.get(dGemiIler).get(GEMIOZELLIGI_POSY)
                        + dusmanGemileri.get(dGemiIler).get(GEMIOZELLIGI_HIZ));
            }
        }
    }


    //menzil testi fonksiyonu
    private void menzilTesti() {
        for (menzilTest_i = 0; menzilTest_i < oyuncuGemileri.size(); menzilTest_i++) {
            oyuncuGemileri.get(menzilTest_i).set(GEMIOZELLIGI_SD, 0);
            for (menzilTest_j = 0; menzilTest_j < dusmanGemileri.size(); menzilTest_j++) {
                fark = Math.abs(oyuncuGemileri.get(menzilTest_i).get(GEMIOZELLIGI_POSY)
                        - dusmanGemileri.get(menzilTest_j).get(GEMIOZELLIGI_POSY));
                if (fark < 400 && oyuncuGemileri.get(menzilTest_i).get(GEMIOZELLIGI_YON) == dusmanGemileri.get(menzilTest_j).get(GEMIOZELLIGI_YON)) {
                    oyuncuGemileri.get(menzilTest_i).set(GEMIOZELLIGI_SD, 1);
                    if (oyuncuGemileri.get(menzilTest_i).get(GEMIOZELLIGI_ATESSAYACI) < oyuncuGemileri.get(menzilTest_i).get(GEMIOZELLIGI_ATESSABITI)) {//*
                        oyuncuGemileri.get(menzilTest_i).set(GEMIOZELLIGI_ATESSAYACI, oyuncuGemileri.get(menzilTest_i).get(GEMIOZELLIGI_ATESSAYACI) + 1);//*
                    } else {
                        oyuncuGemileri.get(menzilTest_i).set(GEMIOZELLIGI_ATESSAYACI, 0);//**
                        oyuncuMermiUret();
                        root.sesEfekti.play(root.sesEfekleri[0]);
                        break;
                    }
                }
            }
        }


            for (menzilDusman_i = 0; menzilDusman_i < dusmanGemileri.size(); menzilDusman_i++) {
                dusmanGemileri.get(menzilDusman_i).set(GEMIOZELLIGI_SD, 0);
                for (menzilDusman_j = 0; menzilDusman_j < oyuncuGemileri.size(); menzilDusman_j++) {
                    fark = Math.abs(dusmanGemileri.get(menzilDusman_i).get(GEMIOZELLIGI_POSY)
                            - oyuncuGemileri.get(menzilDusman_j).get(GEMIOZELLIGI_POSY));
                    //aynı yöndelerde ve aralarında 400 fark varsa ateş et
                    if (fark < 400 && dusmanGemileri.get(menzilDusman_i).get(GEMIOZELLIGI_YON) == oyuncuGemileri.get(menzilDusman_j).get(GEMIOZELLIGI_YON)) {
                        dusmanGemileri.get(menzilDusman_i).set(GEMIOZELLIGI_SD, 1);
                        if (dusmanGemileri.get(menzilDusman_i).get(GEMIOZELLIGI_ATESSAYACI) < dusmanGemileri.get(menzilDusman_i).get(GEMIOZELLIGI_ATESSABITI)) {//*
                            dusmanGemileri.get(menzilDusman_i).set(GEMIOZELLIGI_ATESSAYACI, dusmanGemileri.get(menzilDusman_i).get(GEMIOZELLIGI_ATESSAYACI) + 1);//*
                        } else {
                            dusmanGemileri.get(menzilDusman_i).set(GEMIOZELLIGI_ATESSAYACI, 0);//**
                            dusmanMermiUret();
                            root.sesEfekti.play(root.sesEfekleri[0]);
                            break;
                        }
                    }
                }
            }
        }

    private void oyuncuMermiIlerlet() {
        for (oMermiIler_i = 0; oMermiIler_i < oyuncuMermileri.size(); oMermiIler_i++) {
            //eğer menzilini geçerse mermiyi yok et
            if (Math.abs(oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_DOGY) -
                    oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_POSY)) > mermiMenzil) {
                oyuncuMermileri.remove(oMermiIler_i);
            } else {
                //mermiyi ilerlet
                oyuncuMermileri.get(oMermiIler_i).set(MERMIOZELLIGI_POSY,
                        oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_POSY) -
                                oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_HIZ));
                for (dMermiIler_i = 0; dMermiIler_i < dusmanGemileri.size(); dMermiIler_i++) {
                    if (oyuncuMermileri.isEmpty())
                        break;
                    //vurulunca mermiyi ve düşmanı yok et
                    if (oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_POSY) <=
                            dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_POSY) +
                                    gemiAnimasyonlari[dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_TUR)][0].getHeight() / 2
                            && oyuncuMermileri.get(oMermiIler_i).get(MERMIOZELLIGI_YON) == dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_YON)) {
                        if (dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_CAN) >= 0)
                            dusmanGemileri.get(dMermiIler_i).set(GEMIOZELLIGI_CAN, dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_CAN) - mermiHasar); else {
                            patlamaUret(dusmanGemileri.get(dMermiIler_i));
                            toplamPara += dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_DEGER);
                            toplamPuan += dusmanGemileri.get(dMermiIler_i).get(GEMIOZELLIGI_PUAN);
                            dusmanGemileri.remove(dMermiIler_i);
                        }
                        oyuncuMermileri.remove(oMermiIler_i);
                        break;
                    }
                }
            }
        }
    }

    private void dusmanMermiIlerlet() {
        for ( dmi_i = 0; dmi_i < dusmanMermileri.size(); dmi_i++) {
            //eğer menzilini geçerse mermiyi yok et
            if (Math.abs(dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_DOGY) - dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_POSY)) > mermiMenzil) {
                dusmanMermileri.remove(dmi_i);
            } else {//eğer menzil geçilmemişse ilerlet ve çarpışma kontrolü yap
                dusmanMermileri.get(dmi_i).set(MERMIOZELLIGI_POSY, dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_POSY) + dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_HIZ));
                for ( dmi_j = 0; dmi_j < oyuncuGemileri.size(); dmi_j++) {
                    if (dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_POSY) >=
                            oyuncuGemileri.get(dmi_j).get(GEMIOZELLIGI_POSY) -
                                    mermiResimleri[dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_TUR)].getHeight() / 2
                            && dusmanMermileri.get(dmi_i).get(MERMIOZELLIGI_YON) == oyuncuGemileri.get(dmi_j).get(GEMIOZELLIGI_YON)) {
                        if (oyuncuGemileri.get(dmi_j).get(GEMIOZELLIGI_CAN)>=0)
                            oyuncuGemileri.get(dmi_j).set(GEMIOZELLIGI_CAN, oyuncuGemileri.get(dmi_j).get(GEMIOZELLIGI_CAN)- mermiHasar);
                        else {
                            patlamaUret(oyuncuGemileri.get(dmi_j));
                            oyuncuGemileri.remove(dmi_j);
                        }
                        dusmanMermileri.remove(dmi_i);
                        break;
                    }
                }
            }
        }
    }

    //endregion UPDATE FONKSİYONLARI - SON

    //region ÜRETİM FONKSİYONLARI
    private void oyuncuGemiUret(int gemiTuru) {
        oyuncuYeniGemi = new Vector<Integer>();
        oyuncuGemisiDogumX = 282 + (yon * 514);
        oyuncuYeniGemi.add(gemiTuru);
        oyuncuYeniGemi.add(0);
        oyuncuYeniGemi.add(oyuncuGemisiDogumX);
        oyuncuYeniGemi.add(oyuncuGemisiDogumY);
        oyuncuYeniGemi.add(100);
        oyuncuYeniGemi.add(10);
        oyuncuYeniGemi.add(0);
        oyuncuYeniGemi.add(yon);
        oyuncuYeniGemi.add(gemiFiyat[gemiTuru]);
        oyuncuYeniGemi.add(puanSayı[gemiTuru]);
        oyuncuYeniGemi.add(30);//ates sabiti //*
        oyuncuYeniGemi.add(30);//***GEMIOZELLIGI_ATESSAYACI
        oyuncuGemileri.add(oyuncuYeniGemi);
        root.sesEfekti.play(root.sesEfekleri[2]);
    }

    public void butonUret(int resimId, int merkezX, int merkezY, boolean gorunurluk) {
        Vector<Integer> olusanButon = new Vector<>();
        olusanButon.add(resimId);                                                   //BUTON_RESIM_ID=0 Oluşan BUTONnin resminin idsi ekleniyor
        olusanButon.add(merkezX);                                                   //BUTON_MERKEZ_X=1
        olusanButon.add(merkezY);                                                   //BUTON_MERKEZ_Y=2
        int varlikX = merkezX - root.butonResimleri[resimId].getWidth() / 2;             //varlıkX hesaplanıyor
        int varlikY = merkezY - root.butonResimleri[resimId].getHeight() / 2;            //varlıkY hesaplanıyor
        olusanButon.add(varlikX);                                                   //BUTON_VARLIK_X=3
        olusanButon.add(varlikY);                                                   //BUTON_VARLIK_Y=4
        if (gorunurluk) //Setupda fonksiyonu çağırırken verdiğimiz değere göre nesnenin görünürlük indexini true false olarak değiştiriyoruz
            olusanButon.add(1);                                                             //BUTON_GORUNURLUK=5
        else
            olusanButon.add(0);
        butonlar.add(olusanButon);  //değerlerini verdiğimiz objeyi menuNesneleri listesine ekliyoruz
    }
    private void dusmanGemiUret() {

        if (sayac < 40) {
            sayac++;
            return;
        } else {
            sayac = 0;
        }
        int dusmanYon = (int) (Math.random() * 2);
        int dusmanGemiTuru = (int) (Math.random() * 4);
        dusmanGemisiDogumX = 282 + dusmanYon * 514;
        dusmanYeniGemi = new Vector<Integer>();
        dusmanYeniGemi.add(dusmanGemiTuru);
        dusmanYeniGemi.add(0); //Geminin AKS sayacı
        dusmanYeniGemi.add(dusmanGemisiDogumX);
        dusmanYeniGemi.add(dusmanGemisiDogumY);
        dusmanYeniGemi.add(100); // Geminin Can Değeri
        dusmanYeniGemi.add(10); // Geminin Hız Değeri
        dusmanYeniGemi.add(0);  // Geminin Saldırı Durumu
        dusmanYeniGemi.add(dusmanYon);
        dusmanYeniGemi.add(gemiFiyat[dusmanGemiTuru]);
        dusmanYeniGemi.add(puanSayı[dusmanGemiTuru]);
        dusmanYeniGemi.add(30);//ates sabiti //*
        dusmanYeniGemi.add(30);//***GEMIOZELLIGI_ATESSAYACI
        dusmanGemileri.add(dusmanYeniGemi);

    }

    private void patlamaUret(Vector<Integer> gemi) {
        Vector<Integer> olusanPatlama = new Vector<>();
        int x = gemi.get(GEMIOZELLIGI_POSX);
        int y = gemi.get(GEMIOZELLIGI_POSY);
        olusanPatlama.add(x);                       //X_MERKEZ_P = 0  x merkez noktası
        olusanPatlama.add(y);                       //Y_MERKEZ_P = 1  y merkez noktası
        olusanPatlama.add(0);                       //AKS_PATLAMA = 2 animasyon karesi. başlangıç = 0
        patlamalar.add(olusanPatlama);
        root.sesEfekti.play(root.sesEfekleri[7]);
    }

    private void oyuncuMermiUret() {
        for (omu_i = 0; omu_i < oyuncuGemileri.size(); omu_i++) {
            if (oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_SD) == 1) {
                oyuncuMermi = new Vector<>();
                oyuncuMermi.add(0);
                oyuncuMermi.add(oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_POSX));
                oyuncuMermi.add(oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_POSY));
                oyuncuMermi.add(oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_POSX));
                oyuncuMermi.add(oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_POSY));
                oyuncuMermi.add(10);
                oyuncuMermi.add(oyuncuGemileri.get(omu_i).get(GEMIOZELLIGI_YON));
                oyuncuMermileri.add(oyuncuMermi);
                root.sesEfekti.play(root.sesEfekleri[0]);
            }
        }
    }

    private void dusmanMermiUret() {
        for (dmu_i = 0; dmu_i < dusmanGemileri.size(); dmu_i++) {
            if (dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_SD) == 1) {
                dusmanMermi = new Vector<>();
                dusmanMermi.add(1);
                dusmanMermi.add(dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_POSX));
                dusmanMermi.add(dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_POSY));
                dusmanMermi.add(dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_POSX));
                dusmanMermi.add(dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_POSY));
                dusmanMermi.add(10);
                dusmanMermi.add(dusmanGemileri.get(dmu_i).get(GEMIOZELLIGI_YON));
                dusmanMermileri.add(dusmanMermi);
                root.sesEfekti.play(root.sesEfekleri[0]);
            }
        }
    }
    //endregion ÜRETİM FONKSİYONLARI - SON

    //region ÇİZİM FONKSİYONLARI
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        canvas.save();
        canvas.scale(getWidth() / 1080f, getHeight() / 1920f);
        arkaplanCiz();
        slotlariCiz();
        platformlariCiz();
        oyuncuGemiCiz();
        dusmanGemiCiz();
        oyuncuMermiCiz();
        dusmanMermiCiz();
        patlamalariCiz();
        fiyatCerceveCiz();      //fiyat çizin altına
        fiyatCiz();
        paraCiz();
        puanCiz();
        butonlariCiz();
        slotOzellikCiz();
        oyunSonucuCiz();

        canvas.restore();
    }
    private void slotOzellikCiz() {                                                                 //Hangi gemi secildiyse o geminin özelliklerini yazdıracak

        if (slotBayrak == 1) {
            if(slotAcikMi) {
                slotOzellikUret(200, 100, 50);
            }
        }
        if (slotBayrak == 2) {
            if(slotAcikMi) {
                slotOzellikUret(150, 75, 25);
            }
        }
        if(slotBayrak == 3) {
            if(slotAcikMi) {
                slotOzellikUret(125, 50, 20);
            }
        }
        if(slotBayrak == 4) {
            if(slotAcikMi) {
                slotOzellikUret(100, 40, 10);
            }
        }
    }

    private void butonlariCiz() {
        for (bc_i = 0; bc_i < butonlar.size(); bc_i++) {
            if (butonlar.get(bc_i).get(BUTON_GORUNURLUK) == 1)
                canvas.drawBitmap(root.butonResimleri[butonlar.get(bc_i).get(BUTON_RESIM_ID)],
                        butonlar.get(bc_i).get(BUTON_VARLIK_X), butonlar.get(bc_i).get(BUTON_VARLIK_Y), null);
        }
    }

    private void slotOzellikUret(int can, int hiz, int guc) {                              //Ozellik cercevesini cizme icin kullanılan fonksiyon

        canvas.drawBitmap(root.slotOzellikCerceve, slotOzellikCerceveX, slotOzellikCerceveY, null);
        canvas.drawBitmap(root.slotOzellikCan, slotOzellikCanX, slotOzellikCanY, null);
        canvas.drawText("" + can + "", slotOzellikCanX + 60, slotOzellikCanY + 40, renk);
        canvas.drawBitmap(root.slotOzellikHiz, slotOzellikHizX, slotOzellikHizY, null);
        canvas.drawText("" + hiz + "", slotOzellikHizX + 60, slotOzellikHizY + 40, renk);
        canvas.drawBitmap(root.slotOzellikGuc, slotOzellikGucX, slotOzellikGucY, null);
        canvas.drawText("" + guc + "", slotOzellikGucX + 60, slotOzellikGucY + 40, renk);
    }

    private void oyunSonucuCiz() { //bayrak
        if(oyunDevamEdiyor == true ) return;

        if(kaybettin == true)
        {
            canvas.drawBitmap(fluArkaPlan, 0, 0, null);
            canvas.drawBitmap(oyunSonucuKaybettin, getWidthHalf() - oyunSonucuKaybettin.getWidth() / 2 , getHeightHalf() - oyunSonucuKaybettin.getHeight() / 2, null);
            canvas.drawBitmap(oyunGeriDugme, getWidthHalf() - oyunGeriDugme.getWidth() , getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2 , null);
            canvas.drawBitmap(oyunYenidenBaslatDugme, getWidthHalf() , getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2 , null);
        }
        if(kazandiniz == true)
        {
            canvas.drawBitmap(fluArkaPlan, 0, 0, null);
            canvas.drawBitmap(oyunSonucuKazandin, getWidthHalf() - oyunSonucuKazandin.getWidth() / 2 , getHeightHalf() - oyunSonucuKazandin.getHeight() / 2, null);
            canvas.drawBitmap(oyunGeriDugme, getWidthHalf() - oyunGeriDugme.getWidth() , getHeightHalf() + oyunSonucuKazandin.getHeight() / 2 , null);
            canvas.drawBitmap(oyunYenidenBaslatDugme, getWidthHalf() , getHeightHalf() + oyunSonucuKazandin.getHeight() / 2 , null);
        }


    }
    private void paraCiz(){
        canvas.drawBitmap(paraCerceve, 20,30, null);
        canvas.drawText(Integer.toString(toplamPara), paraYaziPosX, paraYaziPosY, renk);
    }
    private void fiyatCiz(){
        for (fc_i = 0; fc_i < gemiTuruAdedi; fc_i++){
            canvas.drawText(Integer.toString(gemiFiyat[fc_i]), gemiParaYaziKordinatX[fc_i], gemiParaYaziKordinatY[fc_i], renk);
        }
    }
    public void puanCiz(){
        canvas.drawBitmap(puanCerceve,20,90, null);
        canvas.drawText(Integer.toString(toplamPuan), puanYaziPosX, puanYaziPosY, renk);
    }

    private void oyuncuGemiCiz() {
        for (ogc_i = 0; ogc_i < oyuncuGemileri.size(); ogc_i++) {
            //O anki çizilmesi gereken nesnenin varlık x ve y koordinatlarını bulur.
            int vX = oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_POSX)
                    - gemiAnimasyonlari[oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_TUR)][oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_AKS)].getWidth() / 2;
            int vY = oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_POSY)
                    - gemiAnimasyonlari[oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_TUR)][oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_AKS)].getHeight() / 2;
            //Gemiyi çiziyor
            canvas.save();
            canvas.rotate(180, oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_POSX), oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_POSY));
            canvas.drawBitmap(gemiAnimasyonlari[oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_TUR)][oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_AKS)], vX, vY, null);
            canvas.restore();

            //Animasyon sayacı arttırılıyor.
            if (oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_AKS) < gemiAnimasyonlari[oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_TUR)].length - 1) {
               if(oyunDevamEdiyor == true) oyuncuGemileri.get(ogc_i).set(GEMIOZELLIGI_AKS, oyuncuGemileri.get(ogc_i).get(GEMIOZELLIGI_AKS) + 1);
            } else {
                oyuncuGemileri.get(ogc_i).set(GEMIOZELLIGI_AKS, 0);
            }
        }
    }

    private void dusmanGemiCiz() {
        for (dgc_i = 0; dgc_i < dusmanGemileri.size(); dgc_i++) {

            //O anki çizilmesi gereken nesnenin x ve y koordinatlarını bulur.
            int gX = dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_POSX)
                    - gemiAnimasyonlari[dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_TUR)][dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_AKS)].getWidth() / 2;
            int gY = dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_POSY)
                    - gemiAnimasyonlari[dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_TUR)][dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_AKS)].getHeight() / 2;
            //Gemiyi çiziyor
            canvas.drawBitmap(gemiAnimasyonlari[dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_TUR)][dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_AKS)], gX, gY, null);

            //Animasyon sayacı arttırılıyor.
            if (dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_AKS) < gemiAnimasyonlari[dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_TUR)].length - 1) {
                if(oyunDevamEdiyor == true) dusmanGemileri.get(dgc_i).set(GEMIOZELLIGI_AKS, dusmanGemileri.get(dgc_i).get(GEMIOZELLIGI_AKS) + 1);
            } else {
                dusmanGemileri.get(dgc_i).set(GEMIOZELLIGI_AKS, 0);
            }
        }
    }
    private  void fiyatCerceveCiz() {
        for (fcc_i = 0; fcc_i < gemiTuruAdedi; fcc_i++) {
            if (toplamPara < gemiFiyat[fcc_i]) {
                canvas.drawBitmap(fiyatResimleri[0], gemiParaYaziKordinatX[fcc_i], gemiFiyatCerceveY[fcc_i], renk);
            } else {

                canvas.drawBitmap(fiyatResimleri[1], gemiParaYaziKordinatX[fcc_i], gemiFiyatCerceveY[fcc_i], renk);
            }

        }
    }

        private void platformlariCiz(){
        if(platformCizOnay == false) return;
        if(platformSayaci < 25) {
            canvas.drawBitmap(platformAnimasyon[platformSayaci], solPlatformX + (yon * 514), solPlatformY, null);
            platformSayaci++;
        }else {
            canvas.drawBitmap(platformAnimasyon[platformSayaci - 1], solPlatformX + (yon * 514), solPlatformY, null);
        }
        }
    private void patlamalariCiz() {
        for (pc_i = 0; pc_i < patlamalar.size(); pc_i++) {
            Rect patlamaKonumu = new Rect(patlamalar.get(pc_i).get(X_MERKEZ_P) - 256 / 2, patlamalar.get(pc_i).get(Y_MERKEZ_P) - 256 / 2,
                    patlamalar.get(pc_i).get(X_MERKEZ_P) + 256 / 2, patlamalar.get(pc_i).get(Y_MERKEZ_P) + 256 / 2);

            canvas.drawBitmap(patlamaEfekti, patlamaKareleri[patlamalar.get(pc_i).get(AKS_PATLAMA)], patlamaKonumu, null);

            if (patlamalar.get(pc_i).get(AKS_PATLAMA) < patlamaKareleri.length - 1) {
                patlamalar.get(pc_i).set(AKS_PATLAMA, patlamalar.get(pc_i).get(AKS_PATLAMA) + 1);
            } else patlamalar.remove(pc_i);
        }
    }

    private void slotlariCiz() {
        for (sc_i = 0; sc_i < gemiAnimasyonlari.length; sc_i++) {
            canvas.drawBitmap(gemiAnimasyonlari[sc_i][0], slotOrtaNoktalariX[sc_i] - (gemiAnimasyonlari[sc_i][0].getWidth() / 2), slotOrtaNoktalariY - gemiAnimasyonlari[sc_i][0].getHeight() / 2, null);
        }
    }

    private void oyuncuMermiCiz() {
        for (omc_i = 0; omc_i < oyuncuMermileri.size(); omc_i++) {
            canvas.drawBitmap(mermiResimleri[0],
                    oyuncuMermileri.get(omc_i).get(MERMIOZELLIGI_POSX) - mermiResimleri[0].getWidth() / 2,
                    oyuncuMermileri.get(omc_i).get(MERMIOZELLIGI_POSY) - mermiResimleri[0].getHeight(),
                    null);
        }
    }

    private void dusmanMermiCiz() {
        for (dmc_i = 0; dmc_i < dusmanMermileri.size(); dmc_i++) {
            canvas.drawBitmap(mermiResimleri[1],
                    dusmanMermileri.get(dmc_i).get(MERMIOZELLIGI_POSX) - mermiResimleri[1].getWidth() / 2,
                    dusmanMermileri.get(dmc_i).get(MERMIOZELLIGI_POSY), null);
        }
    }

    private void arkaplanCiz() {
        canvas.drawBitmap(oyunArkaplan, 0, 0, null);
    }
    //endregion ÇİZİM FONKSİYONLARI - SON

    private void slotKontrolu(int x, int y) {

        if (x > root.xOranla(15) && x < root.xOranla(270) && y > root.yOranla(1700) && y < root.yOranla(1900) && toplamPara >= gemiFiyat[0]) {
            Log.i("GC", "Basildi");
            oyuncuGemiUret(0);
            toplamPara -= gemiFiyat[0];
            //dusmanGemiUret(0);
        }

        if (x > 280 && x < 535 && y > 1700 && y < 1900 && toplamPara >= gemiFiyat[1]) {
            oyuncuGemiUret(1);
            toplamPara -= gemiFiyat[1];
            //dusmanGemiUret(1);
        }

        if (x > 550 && x < 805 && y > 1700 && y < 1900 && toplamPara >= gemiFiyat[2]) {
            oyuncuGemiUret(2);
            toplamPara -= gemiFiyat[2];
            // dusmanGemiUret(2);
        }

        if (x > 820 && x < 1075 && y > 1700 && y < 1900 && toplamPara >= gemiFiyat[3]) {
            oyuncuGemiUret(3);
            toplamPara -= gemiFiyat[3];
            // dusmanGemiUret(3);
        }
    }

    public boolean ustundeMi(int x, int y, Vector<Integer> buton) {
        int resimYarisiX = root.butonResimleri[buton.get(BUTON_RESIM_ID)].getWidth() / 2;    //BUTONnin kullandığı resmin yarısının x değerini alıyoruz
        int resimYarisiY = root.butonResimleri[buton.get(BUTON_RESIM_ID)].getHeight() / 2;   //BUTONnin kullandığı resmin yarısının y değerini alıyoruz
        int x1 = buton.get(BUTON_MERKEZ_X) - resimYarisiX;                        //BUTONnin merkez x kordinatından resmin yarısı çıkartıpıl x1'e atanıyor
        int y1 = buton.get(BUTON_MERKEZ_Y) - resimYarisiY;                        //BUTONnin merkez y kordinatından resmin yarısı çıkartıpıl y1'e atanıyor
        int x2 = buton.get(BUTON_MERKEZ_X) + resimYarisiX;                        //BUTONnin merkez x kordinatıyla resmin yarısı toplanıp x2'e atanıyor
        int y2 = buton.get(BUTON_MERKEZ_Y) + resimYarisiY;                        //BUTONnin merkez y kordinatıyla resmin yarısı toplanıp y2'e atanıyor
        if (root.xOranla(x1) < x && root.yOranla(y1) < y && root.yOranla(x2) > x && root.yOranla(y2) > y && buton.get(BUTON_GORUNURLUK) == 1 && kazandiniz == false && kaybettin == false) //Fonksiyonu çağırırken verdiğimiz x ve y kordinatı oluşturduğumuz karenin içindeyse
        {
            root.sesEfekti.play(root.sesEfekleri[8]);
            return true;    //true döndür
        } else                //değilse
            return false;   //false döndür
    }

    private void slotOzellikKontrol(int x, int y) {                                                 //Gemilerin Özelliklerini belirlemek için tıklanılan alan kontrolu


        if (x > 15 && x < 270 && y > 1700 && y < 1900) {
            //birinci slot
            slotOzellikKontrolUret(0, 1526, 42, 1542, 42, 1594, 42, 1643, 1);
            bekleme = 0;


        }
        if (x > 280 && x < 535 && y > 1700 && y < 1900) {
            //ikinci slot
            slotOzellikKontrolUret(0 + root.slotOzellikCerceve.getWidth() + 20, 1526, 42 + root.slotOzellikCerceve.getWidth(), 1542, 42 + root.slotOzellikCerceve.getWidth(), 1594, 42 + root.slotOzellikCerceve.getWidth(), 1642, 2);
            bekleme = 0;

        }
        if (x > 550 && x < 805 && y > 1700 && y < 1900) {
            //üçüncü slot
            slotOzellikKontrolUret(2 * root.slotOzellikCerceve.getWidth() + 30, 1526, 48 + 2 * root.slotOzellikCerceve.getWidth(), 1542, 52 + 2 * root.slotOzellikCerceve.getWidth(), 1594, 52 + 2 * root.slotOzellikCerceve.getWidth(), 1643, 3);
            bekleme = 0;

        }
        if (x > 820 && x < 1075 && y > 1700 && y < 1900) {
            //dorduncu slot
            slotOzellikKontrolUret(3 * root.slotOzellikCerceve.getWidth() + 45, 1526, 52 + 3 * root.slotOzellikCerceve.getWidth(), 1542, 52 + 3 * root.slotOzellikCerceve.getWidth(), 1594, 52 + 3 * root.slotOzellikCerceve.getWidth(), 1643, 4);
            bekleme = 0;

        }
    }
    private void slotOzellikKontrolUret(int cerceveX, int cerceveY, int canX, int canY, int hizX, int hizY, int gucX, int gucY, int bayrak) {  // Bu fonksiyon ile gemilerin özelliklerinin hangi konumda çıkacagı konumu belirliyoruz.
        slotOzellikCerceveX = cerceveX;                                                                                                         //bysefa
        slotOzellikCerceveY = cerceveY;
        slotOzellikCanX = canX;
        slotOzellikCanY = canY;
        slotOzellikHizX = hizX;
        slotOzellikHizY = hizY;
        slotOzellikGucX = gucX;
        slotOzellikGucY = gucY;
        slotBayrak = bayrak;
    }

        public void touchUp(int x, int y, int id) {
            Log.i("GC", "x:  " + x +  "    x scale:  " + root.xOranla(x) + "    y:  " +y+"    y scale:  " +root.yOranla(y));
            slotKontrolu(x , y);

            butonlar.get(BUTON_GERI).set(BUTON_RESIM_ID, root.RESIM_GERI);
            if (ustundeMi(x, y, butonlar.get(BUTON_AYARLAR))) {

                if (butonlar.get(BUTON_SES).get(BUTON_GORUNURLUK) == 1) {                 //eğer butonun görünürlük indexi 1 se
                    oyunDevamEdiyor = true;
                    butonlar.get(BUTON_SES).set(BUTON_GORUNURLUK, 0);                     //0 yap ve
                    butonlar.get(BUTON_GERI).set(BUTON_GORUNURLUK, 0);
                    butonlar.get(BUTON_AYARLAR).set(BUTON_RESIM_ID, root.RESIM_AYARLAR);       //ayar butonunun görselini ilk haline döndürüyoruz
                } else {                                                                  //değilse
                    oyunDevamEdiyor = false;
                    butonlar.get(BUTON_SES).set(BUTON_GORUNURLUK, 1);                     //BUTONnin görünürlük değerini 1 yapıyoruz
                    butonlar.get(BUTON_GERI).set(BUTON_GORUNURLUK, 1);
                }
            } else
            if (ustundeMi(x, y, butonlar.get(BUTON_SES))) {
                if (butonlar.get(BUTON_SES).get(BUTON_RESIM_ID) != root.RESIM_SESSIZ) {          //eğer butonun resim idsi sessiz değilse
                    butonlar.get(BUTON_SES).set(BUTON_RESIM_ID, root.RESIM_SESSIZ);              //sessiz yap
                    root.oyunMuzik.pause();
                } else {                                                                        //sessizse
                    butonlar.get(BUTON_SES).set(BUTON_RESIM_ID, root.RESIM_SES);                 //sesli yap
                    root.oyunMuzik.start();
                }
            }
            if (ustundeMi(x, y, butonlar.get(BUTON_GERI))) {
                root.oyunMuzik.stop();

                root.canvasManager.setCurrentCanvas(new MenuCanvas(root));
            }

        if (x > 150 && x < 380 && y > 1215 && y < 1480) {
            yon = 0;
            platformSayaci = 0;
            platformCizOnay = true;

        }
        if (x > 700 && x < 880 && y > 1210 && y < 1480) {
            yon = 1;
            platformSayaci = 0;
            platformCizOnay = true;
        }
        baslangic = 70 ;
            if (x > getWidthHalf() - oyunGeriDugme.getWidth()
                    && x < getWidthHalf()
                    && y > getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2
                    && y < getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2 + oyunGeriDugme.getHeight()
                    && oyunDevamEdiyor == false && (kazandiniz == true || kaybettin == true) ) { //bayrak
                root.menuMuzik.prepare();
                root.oyunMuzik.stop();
                MenuCanvas mc = new MenuCanvas(root);
                root.canvasManager.setCurrentCanvas(mc);
            }
            if (x > getWidthHalf()
                    && x < getWidthHalf() + oyunYenidenBaslatDugme.getWidth()
                    && y > getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2
                    && y < getHeightHalf() + oyunSonucuKaybettin.getHeight() / 2 + oyunYenidenBaslatDugme.getHeight()
                    && oyunDevamEdiyor == false && ( kazandiniz == true || kaybettin == true )) { //bayrak
                root.oyunMuzik.stop();
                GameCanvas mc = new GameCanvas(root);
                root.canvasManager.setCurrentCanvas(mc);
            }
    }

    //region DİĞER FONKSİYONLAR
    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {
    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {
    }

    public void surfaceCreated() {
    }

    public void surfaceDestroyed() {
    }

    public void touchDown(int x, int y, int id) {
        baslangic = 0;
        if(bitis <= 60){		 //1 saniye den fazla basılı tutulursa özellikler gösterilecek
            slotOzellikKontrol(x, y);
        }
        if (ustundeMi(x, y, butonlar.get(BUTON_AYARLAR))) {                                 //x ve y koordinatı ayar butonunun içindeyse
            butonlar.get(BUTON_AYARLAR).set(BUTON_RESIM_ID, root.RESIM_AYARLAR_TIK);                 //Tıklanma görselini resim idiye atıyoruz
        }
        if (ustundeMi(x, y, butonlar.get(BUTON_GERI))) {
            butonlar.get(BUTON_GERI).set(BUTON_RESIM_ID, root.RESIM_GERI_TIK);
        }
    }

    public void touchMove(int x, int y, int id) {
        baslangic = 0;
        if(bitis <= 60){		 //1 saniye den fazla basılı tutulursa özellikler gösterilecek
            slotOzellikKontrol(x, y);
        }
    }


    public void pause() {
    }

    public void resume() {
    }

    public void reloadTextures() {
    }

    public void showNotify() {
    }

    public void hideNotify() {
    }
    //endregion DİĞER FONKSİYONLAR - SON
}