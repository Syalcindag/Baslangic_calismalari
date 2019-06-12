package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Sefa on 10.11.2018.
 */

public class SplashCanvas extends BaseCanvas {
    public SplashCanvas(NgApp ngApp) {
        super(ngApp);
    }

    private Canvas canvas;

    private int sayac = 0;
    private int secici = 0;
    private Bitmap splashResimleri[] = new Bitmap[2];



    public void setup() {
        splashResimleri[0] = Utils.loadImage(root, "gamelab-istanbul_logo.png");
        splashResimleri[1] = Utils.loadImage(root, "logo (2).png");
    }

    public void update() {
        if (sayac <= 125 ) {
            sayac++;
        } else {
            sayac = 0;
            if (secici < splashResimleri.length) {
                secici++;
            } else {
                //gecis fonk.
                MenuCanvas mc = new MenuCanvas(root);
                root.canvasManager.setCurrentCanvas(mc);
            }
        }
    }


    public void draw(Canvas canvas) {
        this.canvas = canvas;
        splashResimler();



    }

    private void splashResimler() {
        if (secici < 2) {
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(splashResimleri[secici], (getWidth()/2 - splashResimleri[secici].getWidth()/2) , (getHeight()/2 - splashResimleri[secici].getHeight()/2), null);
        }
    }


    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return false;
    }

    public void touchDown(int x, int y, int id) {

    }

    public void touchMove(int x, int y, int id) {

    }

    public void touchUp(int x, int y, int id) {
        if (secici < splashResimleri.length - 1) {
            secici++;
        } else {
            MenuCanvas mc = new MenuCanvas(root);
            root.canvasManager.setCurrentCanvas(mc);
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
