package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Sefa on 10.11.2018.
 */

public class RehberCanvas extends BaseCanvas {

    public RehberCanvas(NgApp ngApp) {
        super(ngApp);
    }

    Canvas canvas;
    private Bitmap rehberResim;

    @Override
    public void setup() {
        rehberResim = Utils.loadImage(root, "nasil_oynanir.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        rehberResimCiz();
    }

    private void rehberResimCiz() {
        canvas.drawBitmap(rehberResim, 0, 0, null);
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public boolean backPressed() {
        return false;
    }

    @Override
    public void touchDown(int x, int y, int id) {

    }

    @Override
    public void touchMove(int x, int y, int id) {

    }

    @Override
    public void touchUp(int x, int y, int id) {
        if(x <= 200 && y <= 160){   // Çıkış için touchUp alanı
            //oyuna gecis kısmı
            MenuCanvas mc = new MenuCanvas(root);
            root.canvasManager.setCurrentCanvas(mc);
        }
    }

    @Override
    public void surfaceChanged(int width, int height) {

    }

    @Override
    public void surfaceCreated() {

    }

    @Override
    public void surfaceDestroyed() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void reloadTextures() {

    }

    @Override
    public void showNotify() {

    }

    @Override
    public void hideNotify() {

    }
}
