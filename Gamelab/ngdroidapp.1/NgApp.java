package com.ngdroidapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import istanbul.gamelab.ngdroid.base.BaseActivity;
import istanbul.gamelab.ngdroid.core.AppManager;
import istanbul.gamelab.ngdroid.base.BaseApp;
import istanbul.gamelab.ngdroid.core.NgMediaPlayer;
import istanbul.gamelab.ngdroid.core.SoundManager;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;
import com.pddstudio.preferences.encrypted.EncryptedPreferences;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */

public class NgApp extends BaseApp {

    public NgApp(BaseActivity nitraBaseActivity, AppManager appManager) {
        super(nitraBaseActivity, appManager);
    }

    final public int RESIM_AYARLAR = 0, RESIM_SES = 1, RESIM_GERI = 2, RESIM_SESSIZ = 3, RESIM_GERI_TIK = 4,RESIM_AYARLAR_TIK=5;

    public Bitmap slotOzellikCerceve, slotOzellikCan, slotOzellikHiz, slotOzellikGuc;

    public int sesEfekleri[] = new int[9];
    public SoundManager sesEfekti = new SoundManager(this);

    public Bitmap butonResimleri[] = new Bitmap[6];
    public NgMediaPlayer menuMuzik = new NgMediaPlayer(this);
    public NgMediaPlayer oyunMuzik = new NgMediaPlayer(this);
    public void setup() {


        butonResimleri[RESIM_AYARLAR] = Utils.loadImage(this, "ayarlar_buton.png");
        butonResimleri[RESIM_AYARLAR_TIK] = Utils.loadImage(this, "ayarlar_butonu_tiklandi.png");
        butonResimleri[RESIM_SES] = Utils.loadImage(this, "ses_buton.png");
        butonResimleri[RESIM_SESSIZ] = Utils.loadImage(this, "sessiz_buton.png");
        butonResimleri[RESIM_GERI] = Utils.loadImage(this, "geri_buton.png");
        butonResimleri[RESIM_GERI_TIK] = Utils.loadImage(this, "geri_buton_tiklandi.png");

        //oyuniçi ses efekleri listesi
        try {
            sesEfekleri[0] = sesEfekti.load("sounds/lazeratesi.mp3");
            sesEfekleri[1] = sesEfekti.load("sounds/dusmanates.wav");
            sesEfekleri[2] = sesEfekti.load("sounds/gemidogmasesi.wav");
            sesEfekleri[3] = sesEfekti.load("sounds/game_music.mp3");
            sesEfekleri[4] = sesEfekti.load("sounds/menu_muzigi.mp3");
            sesEfekleri[5] = sesEfekti.load("sounds/motor_sesi.wav");
            sesEfekleri[6] = sesEfekti.load("sounds/oyun_arkaplan_muzik.mp3");
            sesEfekleri[7] = sesEfekti.load("sounds/patlama.mp3");
            sesEfekleri[8] = sesEfekti.load("sounds/buton_ses.mp3");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //region Gemi Özellik
        slotOzellikCerceve = Utils.loadImage(this, "gemi_ozellik_arkaplan.png");
        slotOzellikCan = Utils.loadImage(this, "can_icon.png");
        slotOzellikHiz = Utils.loadImage(this, "hedef_icon.png");
        slotOzellikGuc = Utils.loadImage(this, "dayaniklilik_icon.png");
        //endregion Gemi Özellik

        menuMuzik.load("sounds/menu_muzigi.mp3");
        menuMuzik.prepare();
        oyunMuzik.load("sounds/game_music.mp3");

        appManager.setUnitResolution(AppManager.RESOLUTION_QFHD);
        appManager.setFrameRateTarget(30);
// root setup sonuna ekle
        SplashCanvas mc = new SplashCanvas(this);
        canvasManager.setCurrentCanvas(mc);
    }


    public void update() {

    }
    public float xOranla(float x) {
        x = x * (getWidth() / 1080f);
        return x;
    }
    public float yOranla(float y) {
        y = y * (getHeight() / 1920f);
        return y;
    }
    public void draw(Canvas canvas) {

    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void touchDown(int x, int y, int id) {


    }

    public void touchMove(int x, int y, int id) {

    }

    public void touchUp(int x, int y, int id) {

    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void pause() {
        Log.i("NGAPP", "pause");
    }

    public void resume() {
        Log.i("NGAPP", "resume");
    }

    public void reloadTextures() {
        Log.i("NGAPP", "reloadTextures");
    }
}
