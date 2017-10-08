package com.example.elad.airplane;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by elad on 07/06/2017.
 */

public class HitPath {
    int x1;
    int y1;
    int x2;
    int y2;
    int Strokewidth;

    public HitPath(int x1, int y1, int x2, int y2,int Strokewidth) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.Strokewidth = Strokewidth;



    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getStrokewidth() {
        return Strokewidth;
    }

    public void setStrokewidth(int strokewidth) {
        Strokewidth = strokewidth;
    }

    public void DrawHitPath(Canvas canvas, Paint p1) {

        canvas.drawLine(x1,y1,x2,y2,p1);
    }
}
