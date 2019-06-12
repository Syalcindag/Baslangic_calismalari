package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Furkan on 17.11.2018.
 */

public class HakkimizdaCanvas extends BaseCanvas {

    public HakkimizdaCanvas(NgApp ngApp) {
        super(ngApp);
    }

    Canvas canvas;
    private Bitmap hakkimizdaResim;

    @Override
    public void setup() {
        hakkimizdaResim = Utils.loadImage(root, "hakkimizda.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        hakkimizdaResimCiz();
    }

    private void hakkimizdaResimCiz() {
        canvas.drawBitmap(hakkimizdaResim, 0, 0, null);
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
