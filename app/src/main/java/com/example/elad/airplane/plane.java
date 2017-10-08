package com.example.elad.airplane;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by elad on 17/05/2017.
 */

public class plane {
    int length;
    float x;
    float y;
    int step;
    Boolean drawflag;


    public plane(int length, float x, float y, int step) {
        this.length = length;
        this.x = x;
        this.y = y;
        this.step = step;
        drawflag=true;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Boolean getDrawflag() {
        return drawflag;
    }

    public void setDrawflag(Boolean drawflag) {
        this.drawflag = drawflag;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void drawPlane(Canvas canvas){
     Paint p1 = new Paint();
        p1.setStrokeWidth(20);



            Matrix m = new Matrix();
            m.setScale((float) (length +(length/10))/MainActivity.planeDrawA.getWidth(), (float)(length/3) /MainActivity.planeDrawA.getHeight());
            m.postTranslate(x-(length/20),y-(length/8));

          canvas.drawBitmap(MainActivity.planeDrawA, m, null);






         //   canvas.drawLine(x,y,x+length,y,p1);


    }


    }




