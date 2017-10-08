package com.example.elad.airplane;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by elad on 18/05/2017.
 */

public class Missle {
    int x;
    int y;
    int StepX;
    int StepY;
    int Color;


    boolean  drawflag;


    public Missle(int x, int y, int stepX, int stepY) {
        this.x = x;
        this.y = y;
        StepX = stepX;
        StepY = stepY;
        Color = android.graphics.Color.GRAY;
    }

    public Missle(int x, int y) {
        this.x = x;
        this.y = y;
        drawflag=true;
    }

    public int getStepX() {
        return StepX;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public void setStepX(int stepX) {
        StepX = stepX;
    }

    public int getStepY() {
        return StepY;
    }

    public void setStepY(int stepY) {
        StepY = stepY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Boolean getDrawflag() {
        return drawflag;
    }

    public void setDrawflag(boolean drawflag) {
        this.drawflag = drawflag;
    }

    public void DrawMissle (Canvas myCanvas) {
        Paint pn1 = new Paint();
             pn1.setColor(Color);
          myCanvas.drawCircle(x, y, 15, pn1);


    //    Matrix m = new Matrix();
  //      m.setScale((float) (40)/MainActivity.missle.getWidth(), (float)(80) /MainActivity.missle.getHeight());
    //    m.postTranslate(x-20,y-80);

    //    myCanvas.drawBitmap(MainActivity.missle, m, null);
//
    }
}

