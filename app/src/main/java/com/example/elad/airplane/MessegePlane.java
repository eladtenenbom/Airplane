package com.example.elad.airplane;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by elad on 05/06/2017.
 */

public class MessegePlane {

    String Messege;
    float StepX;

    public MessegePlane(String messege, float stepX) {
        Messege = messege;
        StepX = stepX;
    }

    public String getMessege() {
        return Messege;
    }

    public void setMessege(String messege) {
        Messege = messege;
    }

    public float getStepX() {
        return StepX;
    }

    public void setStepX(float stepX) {
        StepX = stepX;
    }

    public void drawPlane(Canvas canvas){
        Paint p1 = new Paint();
        p1.setStrokeWidth(20);

        p1.setTextSize(50);
        canvas.drawText("" + Messege, canvas.getWidth()+400 - StepX, 200, p1);



    }
}
