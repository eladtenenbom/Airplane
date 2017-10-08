package com.example.elad.airplane;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by elad on 28/05/2017.
 */

public class Cloud1 extends Circle{

    public Cloud1(float x, float y, float stepX, float radius) {
        super(x, y, stepX, radius);
    }

    public void DrawCloud(Canvas canvas) {

            Paint pn1 = new Paint();
            pn1.setColor(Color.WHITE);
            canvas.drawCircle(x,y,Radius,pn1);
            canvas.drawCircle(x+(Radius*2),y,Radius,pn1);
            canvas.drawCircle(x-(Radius*2),y,Radius,pn1);
            canvas.drawCircle(x+(Radius),y-(Radius),Radius,pn1);
            canvas.drawCircle(x+(Radius),y+(Radius),Radius,pn1);
            canvas.drawCircle(x-(Radius),y+(Radius),Radius,pn1);
            canvas.drawCircle(x-(Radius),y-(Radius),Radius,pn1);




    }
}
