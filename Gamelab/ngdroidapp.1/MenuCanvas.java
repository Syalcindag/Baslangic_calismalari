package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.util.Vector;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.core.SoundManager;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by noyan on 27.06.2016.
 * Nitra Games Ltd.
 */

public class MenuCanvas extends BaseCanvas {



    public MenuCanvas(NgApp ngApp) {
        super(ngApp);
    }

    private Canvas canvas;
    //region DEĞİŞKENLER
    final private int OBJE_RESIM_ID = 0, OBJE_MERKEZ_X = 1, OBJE_MERKEZ_Y = 2, OBJE_VARLIK_X = 3, OBJE_VARLIK_Y = 4, OBJE_GORUNURLUK = 5;
    //region Patlama efekti
    private static final int PATLAMA_MERKEZ_X = 0, PATLAMA_MERKEZ_Y = 1, PATLAMA_AKS = 2;
    private Bitmap patlamaEfekti;
    private Vector<Vector<Integer>> patlamalar = new Vector<Vector<Integer>>();
    private Rect patlamaKareleri[] = new Rect[16];
    //endregion

    final private int RESIM_OYNA_BUTON = 0, RESIM_AYAR_BUTON = 1, RESIM_YARDIM_BUTON = 2,
            RESIM_KUPA_BUTON = 3, RESIM_SES_BUTON = 4, RESIM_SESSIZ_BUTON = 5,
            RESIM_LOGO = 6, RESIM_OYNAT_TIK = 7, RESIM_AYAR_TIK = 8, RESIM_YARDIM_TIK = 9, RESIM_KUPA_TIK = 10, RESIM_BiZ_KIMIZ = 11, RESIM_BiZ_KIMIZ_TIK = 12;

    final private int BUTON_OYNA = 0, BUTON_AYAR = 1, BUTON_YARDIM = 2, BUTON_KUPA = 3, BUTON_SES = 4, BUTON_BIZ_KIMIZ = 5,LOGO_MENU=6;

    private Bitmap arkaplan;
    //Menu canvastaki objelerin Tutuldugu Yer
    private Vector<Vector<Integer>> menuNesneleri = new Vector<>();
    private Bitmap menuResimleri[] = new Bitmap[13];

    //region Gemi değişkenleri
    final private int GEMI_MERKEZ_X = 0, GEMI_MERKEZ_Y = 1, GEMI_VARLIK_X = 2, GEMI_VARLIK_Y = 3, GEMI_ACI = 4, GEMI_RESIM_ID = 5;

    private Bitmap menuGemiResimleri[] = new Bitmap[2];
    private Vector<Vector<Float>> menuGemileri = new Vector<>();

    private SoundManager sesEfekti = new SoundManager(root);
    private int menuSesEfekleri[] = new int[2];

    private float x, y, aci;
    private float saniye = 8;
    private float frame = 25;
    private float toplamTik = saniye * frame;
    private int sayac = 0;
    //endregion Gemi değişkenleri - SON

    //Döngü Degiskenleri
    private int pc_i, gsk_i, gc_i, mnc_i;
    //endregion DEĞİŞKENLER - SON

    //region SETUP FONKSİYONLARI
    public void setup() {
        root.menuMuzik.start();
        arkaplan = Utils.loadImage(root, "menu_background2.jpg");
        //region Kullanılan görseller çekiliyor
        menuResimleri[RESIM_OYNA_BUTON] = Utils.loadImage(root, "oynat_buton.png");
        menuResimleri[RESIM_AYAR_BUTON] = Utils.loadImage(root, "ayarlar_buton.png");
        menuResimleri[RESIM_YARDIM_BUTON] = Utils.loadImage(root, "yardim_buton.png");
        menuResimleri[RESIM_KUPA_BUTON] = Utils.loadImage(root, "kupa_buton.png");
        menuResimleri[RESIM_SES_BUTON] = Utils.loadImage(root, "ses_buton.png");
        menuResimleri[RESIM_SESSIZ_BUTON] = Utils.loadImage(root, "sessiz_buton.png");
        menuResimleri[RESIM_LOGO] = Utils.loadImage(root, "logo.png");
        menuResimleri[RESIM_OYNAT_TIK] = Utils.loadImage(root, "oynat_butonu_tiklandi.png");
        menuResimleri[RESIM_AYAR_TIK] = Utils.loadImage(root, "ayarlar_butonu_tiklandi.png");
        menuResimleri[RESIM_YARDIM_TIK] = Utils.loadImage(root, "yardim_butonu_tiklandi.png");
        menuResimleri[RESIM_KUPA_TIK] = Utils.loadImage(root, "kupa_butonu_tiklandi.png");
        menuResimleri[RESIM_BiZ_KIMIZ] = Utils.loadImage(root, "bizkimiz_buton.png");
        menuResimleri[RESIM_BiZ_KIMIZ_TIK] = Utils.loadImage(root, "bizkimiz_buton_tiklandi.png");
        //endregion Kullanılan göreseller - SON
        try {
            menuSesEfekleri[0] = sesEfekti.load("sounds/buton_ses.mp3");
            menuSesEfekleri[1] = sesEfekti.load("sounds/patlama.mp3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //region Ekrandaki nesneler uretiliyor
        nesneUret(RESIM_OYNA_BUTON, 540, 1508, true);
        nesneUret(RESIM_AYAR_BUTON, 123, 1826, true);
        nesneUret(RESIM_YARDIM_BUTON, 967, 1826, true);
        nesneUret(RESIM_KUPA_BUTON, 540, 309, true);
        nesneUret(RESIM_SES_BUTON, 123, 1696, false);
        nesneUret(RESIM_BiZ_KIMIZ, 540, 1859, true);
        nesneUret(LOGO_MENU, 540, 996, true);
        //endregion üretme - SON

        gemiSetupKodlari();
    }

    public void gemiSetupKodlari() {
        float saniye = 4;
        float frame = 25;
        toplamTik = saniye * frame;
        x = -(63 - 1035) / toplamTik;
        y = (430 - 894) / toplamTik;
        aci = (135 - 45) / toplamTik;

        menuGemiResimleri[0] = Utils.loadImage(root, "animasyon/ship_1_1.png");
        menuGemiResimleri[1] = Utils.loadImage(root, "animasyon/ship_2_1.png");

        gemiUret(0, 1035, 894, 135);

        patlamaEfekti = Utils.loadImage(root, "explosion.png");
        for (gsk_i = 0; gsk_i < 16; gsk_i++) {
            patlamaKareleri[gsk_i] = new Rect((gsk_i % 4) * 64, (gsk_i / 4) * 64,
                    ((gsk_i % 4) + 1) * 64, ((gsk_i / 4) + 1) * 64);
        }
    }
    //endregion SETUP FONKSİYONLARI - SON

    //region UPDATE FONKSİYONLARI
    public void update() {
        Log.i("update", "Update uğradı");
        gemilerUpdate();
    }

    public void gemilerUpdate() {
        if (menuGemileri.get(0).get(GEMI_MERKEZ_X) >= 63) {
            menuGemileri.get(0).set(GEMI_MERKEZ_X, menuGemileri.get(0).get(GEMI_MERKEZ_X) - x);
            menuGemileri.get(0).set(GEMI_VARLIK_X, menuGemileri.get(0).get(GEMI_VARLIK_X) - x);
        }
        if (toplamTik >= sayac) {
            if (menuGemileri.get(0).get(GEMI_MERKEZ_Y) > 465 && sayac <= toplamTik / 2) {
                menuGemileri.get(0).set(GEMI_MERKEZ_Y, menuGemileri.get(0).get(GEMI_MERKEZ_Y) + y);
                menuGemileri.get(0).set(GEMI_VARLIK_Y, menuGemileri.get(0).get(GEMI_VARLIK_Y) + y);
            } else {
                menuGemileri.get(0).set(GEMI_MERKEZ_Y, menuGemileri.get(0).get(GEMI_MERKEZ_Y) - y);
                menuGemileri.get(0).set(GEMI_VARLIK_Y, menuGemileri.get(0).get(GEMI_VARLIK_Y) - y);
            }
            sayac++;
            menuGemileri.get(0).set(GEMI_ACI, menuGemileri.get(0).get(GEMI_ACI) - aci);
        } else{
            sayac=0;
            patlamaUret(menuGemileri.get(0));
            //patlamaUret(menuGemileri.get(1));
            menuGemileri.remove(0);

            gemiUret(0, 1035, 894, 135);

        }
    }
    //endregion UPDATE FONKSİYONLARI - SON

    //region ÇİZİM FONKSİYONLARI
    public void draw(Canvas canvas) {
        Log.i("draw", "draw uğradı");
        this.canvas = canvas;
        canvas.save();
        canvas.scale(getWidth() / 1080f, getHeight() / 1920f);
        arkaplanCiz();
        menuNesneleriniCiz();                                           //Butonları çizdiriyoruz.
        gemileriCiz();                                            //Gemileri çizdiriyoruz.
        patlamalariCiz();
        canvas.restore();
    }
    private void patlamalariCiz() {
        for ( pc_i = 0; pc_i < patlamalar.size(); pc_i++) {
            Rect patlamaKonumu = new Rect(patlamalar.get(pc_i).get(PATLAMA_MERKEZ_X) - 256 / 2, patlamalar.get(pc_i).get(PATLAMA_MERKEZ_Y) - 256 / 2,
                    patlamalar.get(pc_i).get(PATLAMA_MERKEZ_X) + 256 / 2, patlamalar.get(pc_i).get(PATLAMA_MERKEZ_Y) + 256 / 2);

            canvas.drawBitmap(patlamaEfekti, patlamaKareleri[patlamalar.get(pc_i).get(PATLAMA_AKS)], patlamaKonumu, null);

            if (patlamalar.get(pc_i).get(PATLAMA_AKS) < patlamaKareleri.length - 1) {
                patlamalar.get(pc_i).set(PATLAMA_AKS, patlamalar.get(pc_i).get(PATLAMA_AKS) + 1);
            } else patlamalar.remove(pc_i);
        }
    }
    private void arkaplanCiz() {
        canvas.drawBitmap(arkaplan, 0, 0, null);          //Arkaplanı çizdiriyoruz.
    }

    public void menuNesneleriniCiz() {
        for (mnc_i = 0; mnc_i < menuNesneleri.size(); mnc_i++) {
            if (menuNesneleri.get(mnc_i).get(OBJE_GORUNURLUK) == 1)
                canvas.drawBitmap(menuResimleri[menuNesneleri.get(mnc_i).get(OBJE_RESIM_ID)],
                        menuNesneleri.get(mnc_i).get(OBJE_VARLIK_X), menuNesneleri.get(mnc_i).get(OBJE_VARLIK_Y), null);
        }
    }

    public void gemileriCiz() {
        for (gc_i = 0; gc_i < menuGemileri.size(); gc_i++) {
            canvas.save();
            canvas.rotate(menuGemileri.get(gc_i).get(GEMI_ACI), menuGemileri.get(gc_i).get(GEMI_MERKEZ_X),
                    menuGemileri.get(gc_i).get(GEMI_MERKEZ_Y));
            canvas.drawBitmap(menuGemiResimleri[0], menuGemileri.get(gc_i).get(GEMI_VARLIK_X), menuGemileri.get(gc_i).get(GEMI_VARLIK_Y), null);
            canvas.restore();
        }
    }

    //endregion ÇİZİM FONKSİYONLARI - SON

    //region ÜRETİM FONKSİYONLARI
    public void nesneUret(int resimId, int merkezX, int merkezY, boolean gorunurluk) {
        Vector<Integer> olusanObje = new Vector<>();
        olusanObje.add(resimId);                                                   //OBJE_RESIM_ID=0 Oluşan objenin resminin idsi ekleniyor
        olusanObje.add(merkezX);                                                   //OBJE_MERKEZ_X=1
        olusanObje.add(merkezY);                                                   //OBJE_MERKEZ_Y=2
        int varlikX = merkezX - menuResimleri[resimId].getWidth() / 2;             //varlıkX hesaplanıyor
        int varlikY = merkezY - menuResimleri[resimId].getHeight() / 2;            //varlıkY hesaplanıyor
        olusanObje.add(varlikX);                                                   //OBJE_VARLIK_X=3
        olusanObje.add(varlikY);                                                   //OBJE_VARLIK_Y=4
        if (gorunurluk) //Setupda neseUret fonksiyonunu çağırırken verdiğimiz değere göre nesnenin görünürlük indexini true false olarak değiştiriyoruz
            olusanObje.add(1);                                                             //OBJE_GORUNURLUK=5
        else
            olusanObje.add(0);
        menuNesneleri.add(olusanObje);//değerlerini verdiğimiz objeyi menuNesneleri listesine ekliyoruz
    }
    private void patlamaUret(Vector<Float> gemi) {
        Vector<Integer> olusanPatlama = new Vector<>();
        int x = Math.round(gemi.get(GEMI_MERKEZ_X));
        int y = Math.round(gemi.get(GEMI_MERKEZ_Y));
        olusanPatlama.add(x);                       //PATLAMA_MERKEZ_X = 0  x merkez noktası
        olusanPatlama.add(y);                       //PATLAMA_MERKEZ_Y = 1  y merkez noktası
        olusanPatlama.add(0);                       //PATLAMA_AKS = 2 animasyon karesi. başlangıç = 0
        patlamalar.add(olusanPatlama);
        sesEfekti.play(menuSesEfekleri[1]);
    }
    public void gemiUret(int resimId, float merkezX, float merkezY, float aci) {
        Vector<Float> olusanGemi = new Vector<>();
        olusanGemi.add(merkezX);
        olusanGemi.add(merkezY);
        float varlikX = merkezX - menuResimleri[resimId].getWidth() / 2;
        float varlikY = merkezY - menuResimleri[resimId].getHeight() / 2;
        olusanGemi.add(varlikX);
        olusanGemi.add(varlikY);
        olusanGemi.add(aci);
        olusanGemi.add((float) resimId);
        menuGemileri.add(olusanGemi);
    }
    //endregion ÜRETİM FONKSİYONLARI - SON

    //region KONTROL FONKSİYONLARI
    public boolean ustundeMi(int x, int y, Vector<Integer> obje) {
        int resimYarisiX = menuResimleri[obje.get(OBJE_RESIM_ID)].getWidth() / 2;    //objenin kullandığı resmin yarısının x değerini alıyoruz
        int resimYarisiY = menuResimleri[obje.get(OBJE_RESIM_ID)].getHeight() / 2;   //objenin kullandığı resmin yarısının y değerini alıyoruz
        int x1 = obje.get(OBJE_MERKEZ_X) - resimYarisiX;                        //objenin merkez x kordinatından resmin yarısı çıkartıpıl x1'e atanıyor
        int y1 = obje.get(OBJE_MERKEZ_Y) - resimYarisiY;                        //objenin merkez y kordinatından resmin yarısı çıkartıpıl y1'e atanıyor
        int x2 = obje.get(OBJE_MERKEZ_X) + resimYarisiX;                        //objenin merkez x kordinatıyla resmin yarısı toplanıp x2'e atanıyor
        int y2 = obje.get(OBJE_MERKEZ_Y) + resimYarisiY;                        //objenin merkez y kordinatıyla resmin yarısı toplanıp y2'e atanıyor
        if (root.xOranla(x1) < x && root.yOranla(y1) < y && root.xOranla(x2) > x && root.yOranla(y2) > y && obje.get(OBJE_GORUNURLUK) == 1) //Fonksiyonu çağırırken verdiğimiz x ve y kordinatı oluşturduğumuz karenin içindeyse
        {
            sesEfekti.play(menuSesEfekleri[0]);
            return true;    //true döndür
        } else                //değilse
            return false;   //false döndür
    }

    //endregion KONTROL FONKSİYONLARI - SON
    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {
    }

    public boolean backPressed() {
        return false;
    }

    public void touchDown(int x, int y, int id) {                                       //Mouse basıldığı anda
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_OYNA))) {                                 //x ve y koordinatı oyna butonunun içindeyse
            menuNesneleri.get(BUTON_OYNA).set(OBJE_RESIM_ID, RESIM_OYNAT_TIK);                //Tıklanma görselini resim idiye atıyoruz
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_AYAR))) {                                 //x ve y koordinatı ayar butonunun içindeyse
            menuNesneleri.get(BUTON_AYAR).set(OBJE_RESIM_ID, RESIM_AYAR_TIK);                 //Tıklanma görselini resim idiye atıyoruz
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_YARDIM))) {
            menuNesneleri.get(BUTON_YARDIM).set(OBJE_RESIM_ID, RESIM_YARDIM_TIK);
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_KUPA))) {
            menuNesneleri.get(BUTON_KUPA).set(OBJE_RESIM_ID, RESIM_KUPA_TIK);
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_BIZ_KIMIZ))) {
            menuNesneleri.get(BUTON_BIZ_KIMIZ).set(OBJE_RESIM_ID, RESIM_BiZ_KIMIZ_TIK);
        }
    }

    public void touchMove(int x, int y, int id) {
    }

    public void touchUp(int x, int y, int id) {                                     //Mouse tıklanmayı bıraktığında
        menuNesneleri.get(BUTON_YARDIM).set(OBJE_RESIM_ID, RESIM_YARDIM_BUTON);           //butonların ilk görselini resim idye atıyoruz
        menuNesneleri.get(BUTON_KUPA).set(OBJE_RESIM_ID, RESIM_KUPA_BUTON);


        if (ustundeMi(x, y, menuNesneleri.get(BUTON_OYNA))) {
            root.menuMuzik.stop();
            GameCanvas gc = new GameCanvas(root);
            root.canvasManager.setCurrentCanvas(gc);
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_AYAR))) {
            if (menuNesneleri.get(BUTON_SES).get(OBJE_GORUNURLUK) == 1) {                 //eğer butonun görünürlük indexi 1 se
                menuNesneleri.get(BUTON_SES).set(OBJE_GORUNURLUK, 0);                     //0 yap ve
                menuNesneleri.get(BUTON_AYAR).set(OBJE_RESIM_ID, RESIM_AYAR_BUTON);       //ayar butonunun görselini ilk haline döndürüyoruz
            } else                                                                  //değilse
                menuNesneleri.get(BUTON_SES).set(OBJE_GORUNURLUK, 1);                     //objenin görünürlük değerini 1 yapıyoruz
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_YARDIM))) {
            RehberCanvas rc = new RehberCanvas(root);
            root.canvasManager.setCurrentCanvas(rc);
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_BIZ_KIMIZ))) {
            HakkimizdaCanvas hc = new HakkimizdaCanvas(root);
            root.canvasManager.setCurrentCanvas(hc);
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_KUPA))) {
        }
        if (ustundeMi(x, y, menuNesneleri.get(BUTON_SES))) {
            if (menuNesneleri.get(BUTON_SES).get(OBJE_RESIM_ID) != RESIM_SESSIZ_BUTON) {          //eğer butonun resim idsi sessiz değilse
                menuNesneleri.get(BUTON_SES).set(OBJE_RESIM_ID, RESIM_SESSIZ_BUTON);              //sessiz yap
                root.menuMuzik.pause();
            } else {                                                                        //sessizse
                menuNesneleri.get(BUTON_SES).set(OBJE_RESIM_ID, RESIM_SES_BUTON);                 //sesli yap
                root.menuMuzik.start();
            }
        }
    }

    public void surfaceChanged(int width, int height) {
    }

    public void surfaceCreated() {
    }

    public void surfaceDestroyed() {
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

}
