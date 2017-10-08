package com.example.elad.airplane;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by elad on 23/05/2017.
 */

public class Circle {
    float x;
    float y;
    float StepX;
    float StepY;
    float Radius;
    String CircleID;

       // constructors
    public Circle(float x, float y, float stepX, float stepY, float radius, String circleID) {
        this.x = x;
        this.y = y;
        StepX = stepX;
        StepY = stepY;
        Radius = radius;
        CircleID = circleID;
    }

    public Circle(float x, float y, float stepX, float stepY, float radius) {
        this.x = x;
        this.y = y;
        StepX = stepX;
        StepY = stepY;
        Radius = radius;
        CircleID = null;

    }

    public Circle(float x, float y, float stepX,float radius) {
        this.x = x;
        this.y = y;
        StepX = stepX;
        StepY = 0;
        Radius = radius;
        CircleID = null;

    }

    public Circle(float x, float y,float radius) {
        this.x = x;
        this.y = y;
        StepX = 0;
        StepY = 0;
        Radius = radius;
        CircleID = null;

    }

    public Circle() {
        this.x = 0;
        this.y = 0;
        StepX = 0;
        StepY = 0;
        Radius = 0;
        CircleID = null;

    }


    // getter setter

    public void setStepY(float stepY) {
        StepY = stepY;
    }

    public String getCircleID() {
        return CircleID;
    }

    public void setCircleID(String circleID) {
        CircleID = circleID;
    }

    public float getRadius() {
        return Radius;
    }

    public void setRadius(float radius) {
        Radius = radius;
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

    public float getStepX() {
        return StepX;
    }

    public void setStepX(float stepX) {
        StepX = stepX;
    }

    public float getStepY() {
        return StepY;
    }

    public void setStepY(double stepY) {
        StepY = (float)stepY;
    }




    // drawers

    public void DrawCircle(Canvas canvas,int Color){
        Paint paint = new Paint();
        paint.setColor(Color);
        canvas.drawCircle(x,y,Radius,paint);
    }

    public void DrawGold(Canvas canvas, Paint paint){

        Matrix m = new Matrix();
        m.setScale((float) (Radius*2)/MainActivity.treasureBox.getWidth(), (float)(Radius*2) /MainActivity.treasureBox.getHeight());
        m.postTranslate(x-Radius,y-Radius);
        canvas.drawBitmap(MainActivity.treasureBox, m, null);
    }

    public void DrawAmo(Canvas canvas, Paint paint){
        Matrix m = new Matrix();
        m.setScale((float) (Radius*2)/MainActivity.amo.getWidth(), (float)(Radius*2) /MainActivity.amo.getHeight());
        m.postTranslate(x-Radius,y-Radius);
        canvas.drawBitmap(MainActivity.amo, m, null);
    }

    public void DrawUpgrade(Canvas canvas, Paint paint){
        Matrix m = new Matrix();
        m.setScale((float) (Radius*2)/MainActivity.upg.getWidth(), (float)(Radius*2) /MainActivity.upg.getHeight());
        m.postTranslate(x-Radius,y-Radius);
        canvas.drawBitmap(MainActivity.upg, m, null);
    }

    public void DrawBomb(Canvas canvas, Paint paint){

        Matrix m = new Matrix();
        m.setScale((float) (Radius*2)/MainActivity.bomb.getWidth(), (float)(Radius*2.5) /MainActivity.bomb.getHeight());
        m.postTranslate(x-Radius,y-(Radius+(Radius/2)));
        canvas.drawBitmap(MainActivity.bomb, m, null);

    }




}
