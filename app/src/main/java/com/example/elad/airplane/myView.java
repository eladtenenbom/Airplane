package com.example.elad.airplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by elad on 17/05/2017.
 */


public class myView extends View {
    public List <RGB> ColorBG;
    public task1 t;
    public boolean dataFlag = true;
    public Matrix m;
    int thisScore=0;
    int BGcounter = 0;
    int MoonAlpha = 00;
    int BGColor=0;


    public myView(Context context) {

        super(context);

    }

   // creators functions

    public void CreateData(Canvas canvas) {
        MainActivity.DataCircles[0] = new Circle(canvas.getWidth() - 90, canvas.getHeight() - 150, 80);
        MainActivity.DataCircles[1] = new Circle(canvas.getWidth() - 210, canvas.getHeight() - 210, 80);
        MainActivity.DataCircles[2] = new Circle(180, canvas.getHeight() - 150, 80);
        MainActivity.DataCircles[3] = new Circle(canvas.getWidth() - 400, canvas.getHeight() - 150, 80);
     //   MainActivity.DataCircles[4] = new Circle(canvas.getWidth() - 70, canvas.getHeight() - 450, 60);
       // MainActivity.DataCircles[5] = new Circle(canvas.getWidth() - 230, canvas.getHeight() - 410, 60);

        StarsCreation(canvas);
       ColorBG = new ArrayList<RGB>();
       RGB ColorA = new RGB(21,178,255);
        RGB ColorB = new RGB(195,255,255);
        RGB ColorC = new RGB(129,180,255);
        RGB ColorD = new RGB(137,216,255);
        RGB ColorE= new RGB(255,149,104);
        RGB ColorF = new RGB(0,0,102);
        RGB ColorG = new RGB(21,178,255);
        ColorBG.add(ColorA);
        ColorBG.add(ColorB);
        ColorBG.add(ColorC);
        ColorBG.add(ColorD);
        ColorBG.add(ColorE);
        ColorBG.add(ColorF);
        ColorBG.add(ColorG);

        MainActivity.Sun = new Circle(canvas.getWidth()/2,0-((MainActivity.TotalSunRound-canvas.getHeight())/2),0,0,170,"Sun");
        MainActivity.Moon = new Circle((canvas.getWidth()/5)*4,canvas.getHeight()/5,0,0,120,"Moon");
        MainActivity.MoonCover = new Circle(MainActivity.Moon.getX()+20,MainActivity.Moon.getY()-20,0,0,120,"MoonCover");

    }
    public void RocksCreation(int x,int y, int StepX,int StepY,int Color) {
        Missle ThisMissle= new Missle(x,y,(int)StepX/10,(int)StepY/10);

            ThisMissle.setDrawflag(true);
            MainActivity.Missles.add(ThisMissle);

    }

    public void MissleCreation(int x,int y, int StepX,int StepY,int Color) {

            Missle ThisMissle= new Missle(x,y,(int)StepX/10,(int)StepY/10);
            if ( MainActivity.MissleQuantity>0) {
                ThisMissle.setColor(Color);
                ThisMissle.setDrawflag(true);
                MainActivity.MissleQuantity--;
                MainActivity.Missles.add(ThisMissle);
                }
                else {
                Toast.makeText(getContext(), "You have no more Missles..", Toast.LENGTH_SHORT).show();

            }



        }

    public void StarsCreation(Canvas canvas) {

       for (int i = 0;i<MainActivity.Stars.length;i++) {
           float x = (float) (Math.random() * canvas.getWidth());
           float y = (float) (Math.random() * canvas.getHeight()) / 2;
           int StepX = (int) (Math.random() * 2) + 1;
           int Radius = (int) (Math.random() * 5) + 2;
           MainActivity.Stars[i] = new Circle(x, y, StepX, 0, Radius);
       }
    }



    public void SmokeCreation(plane ThisPlane) {
        // for (int j=0;j<3;j++){
        if ((int) ThisPlane.getX() % 12 == 0) {
            Circle ThisSmoke = new Circle(ThisPlane.getX() - (10), ThisPlane.getY()+20, 0, (float) Math.random() * 7 + 3, (float) Math.random() * 3 + 2);
            MainActivity.Smoke.add(ThisSmoke);
            //      }
        }
    }

    public void GiftCreation(Missle ThisMissle) {
        int w = (int)(Math.random()*20);
        int x = (int)(Math.random()*6);

        int y = (int)(Math.random()*12);
        int z = (int)(Math.random()*10);

        if (w==3) {   // id == bomb
            Circle  ThisGift = new Circle(ThisMissle.getX(),ThisMissle.getY(),(int)(Math.random()*MainActivity.LevelFactor-(MainActivity.LevelFactor/2)),0-MainActivity.LevelFactor-10,15,"BOMB");
            MainActivity.Gift.add(ThisGift);
        }
        if (x==3) {   // id == gold
            Circle  ThisGift = new Circle(ThisMissle.getX(),ThisMissle.getY(),(int)(Math.random()*MainActivity.LevelFactor-(MainActivity.LevelFactor/2)),0-MainActivity.LevelFactor-10,15,"GOLD");
            MainActivity.Gift.add(ThisGift);
        }
        if (y==3) {   // id == AMO
            Circle  ThisGift = new Circle(ThisMissle.getX(),ThisMissle.getY(),(int)(Math.random()*MainActivity.LevelFactor-(MainActivity.LevelFactor/2)),0-MainActivity.LevelFactor-10,15,"AMO");
            MainActivity.Gift.add(ThisGift);
        }
        if (z==3 && MainActivity.UpgradeFlag) {   // id == UPGRADE

            Circle  ThisGift = new Circle(ThisMissle.getX(),ThisMissle.getY(),(int)(Math.random()*MainActivity.LevelFactor-(MainActivity.LevelFactor/2)),0-MainActivity.LevelFactor-10,15,"UPGRADE");
            MainActivity.Gift.add(ThisGift);
            MainActivity.UpgradeFlag = false;

        }




        //      }
    }

    public void ExplodeCreation(Missle ThisMissle) {
        try {
            for (int j = 0; j < 5; j++) {
                //if ((int)ThisPlane.getX()%6==0) {
                Circle ThisExplode = new Circle(ThisMissle.getX(), ThisMissle.getY(), (float) Math.random() * 10 - 5, (float) Math.random() * 10 - 5, (float) Math.random() * 7 + 4);
                MainActivity.Explosion.add(ThisExplode);

            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "no explode", Toast.LENGTH_SHORT);
        }
    }

    public void CloudCreation() {
        float x = (float)(Math.random()*400) + 2000;
        float y = (float)(Math.random()*500);
        int StepX = (int)(Math.random()*2) +1;
        int Radius = (int)(Math.random()*60) + 20;
        Cloud1 ThisCloud = new Cloud1(x,y,StepX,Radius);
        MainActivity.Clouds.add(ThisCloud);

    }

    public void PlaneCreation() {

        int x = 0 - 300;
        int y = (int) (Math.random() * 500) + 100;
        int length = (int) (Math.random() * 130) + 170 - (MainActivity.LevelFactor * 2);
        int StepX = (int) (Math.random() * (6 + MainActivity.LevelFactor)) + 5;
        plane p1 = new plane(length, x, y, StepX);
        MainActivity.Planes.add(p1);
    }

    public void BombCreation() {

    if (MainActivity.BombsQuantity > 0) {
        MainActivity.BombsQuantity--;
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 1000);//MainActivity.CanvasWidth);
            int y = 0 - (int) (Math.random()* 1600);//* MainActivity.CanvasHeight);
            Missle ThisMissle= new Missle(x,y,0,0);
            ThisMissle.setDrawflag(true);
                ThisMissle.setColor(Color.BLACK);
                MainActivity.Missles.add(ThisMissle);


        }

    } else {
        Toast.makeText(getContext(), "You have no Bombs..", Toast.LENGTH_SHORT).show();
    }
}

    // movers functions

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void MovePlanes(Canvas canvas, Paint pn1) {
        for (int i = 0; i < MainActivity.Planes.size(); i++) {
            MainActivity.Planes.get(i).setX(MainActivity.Planes.get(i).getX() + MainActivity.Planes.get(i).getStep());
            plane ThisPlane = MainActivity.Planes.get(i);
            pn1.setColor(Color.DKGRAY);
            if (ThisPlane.getDrawflag()) {
                ThisPlane.drawPlane(canvas);
                SmokeCreation(ThisPlane);
            }
            if (ThisPlane.getX() > (canvas.getWidth() + 1000)) {
                MainActivity.Planes.remove(i);

                if (ThisPlane.getDrawflag() ) {
                    MainActivity.EnemyReachedBase++;
                    if (MainActivity.EnemyReachedBase==10) {
                        GameOver(canvas,pn1);
                    }
                }



            }


        }
    }

    public void DrawHits(Canvas canvas, Paint pn1) {
        if (MainActivity.AimHitPath.getY1()<700 || MainActivity.AimHitPath.getY1()>MainActivity.AimHitPath.getY2()) {
            pn1.setColor(Color.RED);
        }
        else {
            pn1.setColor(Color.GREEN);
        }
       MainActivity.AimHitPath.DrawHitPath(canvas,pn1);
        for (int i = 0; i < MainActivity.hits.size(); i++) {
       pn1.setStrokeWidth(MainActivity.hits.get(i).getStrokewidth());
           MainActivity.hits.get(i).DrawHitPath(canvas,pn1);
            MainActivity.hits.get(i).setStrokewidth(MainActivity.hits.get(i).getStrokewidth()-1) ;

            if (MainActivity.hits.get(i).getStrokewidth()==0) {
                MainActivity.hits.remove(i);
            }


        }
    }

    public void MoveFrontClouds(Canvas canvas, Paint pn1) {

        for (int i = 0; i < MainActivity.Clouds.size(); i++) {
            MainActivity.Clouds.get(i).setX(MainActivity.Clouds.get(i).getX() - MainActivity.Clouds.get(i).getStepX());
            if (MainActivity.Clouds.get(i).getRadius() % 2 == 0) {
                MainActivity.Clouds.get(i).DrawCloud(canvas);
            }
            if (MainActivity.Clouds.get(i).getX() < 0 - 300) {
                MainActivity.Clouds.remove(i);

            }
        }
    }

    public void MoveBackClouds(Canvas canvas, Paint pn1) {
        for (int i = 0; i < MainActivity.Clouds.size(); i++) {
            MainActivity.Clouds.get(i).setX(MainActivity.Clouds.get(i).getX() - MainActivity.Clouds.get(i).getStepX());
            if (MainActivity.Clouds.get(i).getRadius() % 2 != 0) {
                MainActivity.Clouds.get(i).DrawCloud(canvas);
            }
            if (MainActivity.Clouds.get(i).getX() < 0 - 300) {
                MainActivity.Clouds.remove(i);

            }
        }
    }

    public void MoveMissles(Canvas canvas, Paint pn1) {
        for (int i = 0; i < MainActivity.Missles.size(); i++) {

            MainActivity.Missles.get(i).setY(MainActivity.Missles.get(i).getY() + MainActivity.Missles.get(i).getStepY());
            MainActivity.Missles.get(i).setX(MainActivity.Missles.get(i).getX() + MainActivity.Missles.get(i).getStepX());

            MainActivity.Missles.get(i).setStepY(MainActivity.Missles.get(i).getStepY() + 1);
            if (MainActivity.Missles.get(i).getColor()==Color.RED ) {   // Gravitation
                MainActivity.Missles.get(i).setStepY(MainActivity.Missles.get(i).getStepY() - 1);
            }
            Missle ThisMissle = MainActivity.Missles.get(i);
            if (ThisMissle.getDrawflag()) {
                ThisMissle.DrawMissle(canvas);

                for (int j = 0; j < MainActivity.Planes.size(); j++) {


                    if (ThisMissle.getY() - 30 < MainActivity.Planes.get(j).getY() && ThisMissle.getY() + 60 > MainActivity.Planes.get(j).getY()) {


                        if (ThisMissle.getX() > MainActivity.Planes.get(j).getX() && ThisMissle.getX() < MainActivity.Planes.get(j).getX() + MainActivity.Planes.get(j).getLength()) {

                            // hit!
                            if (MainActivity.Planes.get(j).getDrawflag()) {

                                MainActivity.Missles.get(i).setDrawflag(false);
                                Hit(ThisMissle, j);

                            }


                        }


                    }
                }
            }
                if (ThisMissle.getY() >canvas.getHeight()) {
                    ExplodeCreation(ThisMissle);
                    MainActivity.Missles.remove(i);
                    if (ThisMissle.getDrawflag()) {
                        MainActivity.MissedMissle++;
                    }


                }
            if (ThisMissle.getX() >canvas.getWidth()+200 || ThisMissle.getX() < 0-200) {
                MainActivity.Missles.remove(i);
                if (ThisMissle.getDrawflag()) {
                    MainActivity.MissedMissle++;
                }


            }
            if (ThisMissle.getY() <0-50 && ThisMissle.getColor()==Color.RED) {
                try {
                    MainActivity.Missles.remove(i);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "BAG CATCHED", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                if (ThisMissle.getDrawflag()) {
                    MainActivity.MissedMissle++;
                }


            }

        }
    }

    public void MoveSmoke(Canvas canvas, Paint pn1) {

        for (int i = 0; i < MainActivity.Smoke.size(); i++) {
            int SmokeColor = (int) (Math.random() * 70) + 180;
            pn1.setColor(Color.rgb(SmokeColor, SmokeColor, SmokeColor));
            MainActivity.Smoke.get(i).setY(MainActivity.Smoke.get(i).getY() + MainActivity.Smoke.get(i).getStepY());
            MainActivity.Smoke.get(i).setStepY(MainActivity.Smoke.get(i).getStepY() - 1);
            Circle ThisSmoke = MainActivity.Smoke.get(i);
            canvas.drawCircle(ThisSmoke.getX(), ThisSmoke.getY(), ThisSmoke.getRadius(), pn1);
     //       if (ThisSmoke.getY() < 0 - 50) {
    //            MainActivity.Smoke.remove(i);
      //      }
        }
    }

    public void MoveGift(Canvas canvas, Paint pn1) {

        for (int i = 0; i < MainActivity.Gift.size(); i++) {
            MainActivity.Gift.get(i).setY(MainActivity.Gift.get(i).getY() + MainActivity.Gift.get(i).getStepY());
           MainActivity.Gift.get(i).setStepY(MainActivity.Gift.get(i).getStepY() + 2);
            MainActivity.Gift.get(i).setX(MainActivity.Gift.get(i).getX() + MainActivity.Gift.get(i).getStepX());
            Circle ThisGift = MainActivity.Gift.get(i);
            if (ThisGift.getCircleID().equals("GOLD")) {
                ThisGift.DrawCircle(canvas,Color.YELLOW);
            }
            if (ThisGift.getCircleID().equals("AMO")) {
                ThisGift.DrawAmo(canvas,pn1);
            }
            if (ThisGift.getCircleID().equals("UPGRADE")) {
                ThisGift.DrawCircle(canvas,Color.GREEN);
            }
            if (ThisGift.getCircleID().equals("BOMB")) {
                ThisGift.DrawCircle(canvas,Color.BLACK);
            }
            if (ThisGift.getY() > canvas.getHeight()) {
                MainActivity.Gift.remove(i);
                if (ThisGift.getCircleID().equals("GOLD")) {
                    MainActivity.GoldQuantity++;
                }
                if (ThisGift.getCircleID().equals("AMO")) {

                    MainActivity.MissleQuantity += 20;

                }
                if (ThisGift.getCircleID().equals("UPGRADE")) {
                    MainActivity.UpgradeQuantity++;
                }
                if (ThisGift.getCircleID().equals("BOMB")) {
                    MainActivity.BombsQuantity++;
                }

            }
        }
    }

    public void MoveExplosion(Canvas canvas, Paint pn1) {

        for (int i = 0; i < MainActivity.Explosion.size(); i++) {
            int FireColor = (int) (Math.random() * 145) + 70;
            pn1.setColor(Color.rgb(255, FireColor, 0));
            MainActivity.Explosion.get(i).setY(MainActivity.Explosion.get(i).getY() + MainActivity.Explosion.get(i).getStepY());
            MainActivity.Explosion.get(i).setX(MainActivity.Explosion.get(i).getX() + MainActivity.Explosion.get(i).getStepX());
           // MainActivity.Explosion.get(i).setRadius(MainActivity.Explosion.get(i).getRadius() -1);
            Circle ThisExplode = MainActivity.Explosion.get(i);
            canvas.drawCircle(ThisExplode.getX(), ThisExplode.getY(), ThisExplode.getRadius(), pn1);


        }
    }

    public void MoveMessegePlanes(Canvas canvas) {

        for (int i = 0; i < MainActivity.MessegePlanes.size(); i++) {
            MainActivity.MessegePlanes.get(i).setStepX(MainActivity.MessegePlanes.get(i).getStepX() + 10);
            MainActivity.MessegePlanes.get(i).drawPlane(canvas);
            if (MainActivity.MessegePlanes.get(i).getStepX() > canvas.getWidth() + 4500) {
                MainActivity.MessegePlanes.remove(i);

            }
        }
    }



   public void MoveSun(Canvas canvas) {
          BGcounter++;

          MainActivity.Sun.setY( MainActivity.Sun.getY()+1);
          MainActivity.SunRound =  (int) MainActivity.Sun.getY() + ((MainActivity.TotalSunRound-canvas.getHeight())/2);
          if (MainActivity.SunRound < 500) {
              BGColor = RGBtoRGB(ColorBG.get(0), ColorBG.get(1), 500, BGcounter);
          }
          if (MainActivity.SunRound == 500) {
              BGcounter = 1;
          }
       if (MainActivity.SunRound >= 500 && MainActivity.SunRound < 1000) {
           BGColor = RGBtoRGB(ColorBG.get(1), ColorBG.get(2), 500, BGcounter);
       }
       if (MainActivity.SunRound == 1000) {
           BGcounter = 1;
       }
       if (MainActivity.SunRound >= 1000 && MainActivity.SunRound < 1800) {
           BGColor = RGBtoRGB(ColorBG.get(2), ColorBG.get(3),800, BGcounter);
       }
       if (MainActivity.SunRound == 1800) {
           BGcounter = 1;
       }
       if (MainActivity.SunRound >= 1800 && MainActivity.SunRound < 2000) {
           BGColor = RGBtoRGB(ColorBG.get(3), ColorBG.get(4), 200, BGcounter);
       }
       if (MainActivity.SunRound == 2000) {
           BGcounter = 1;
       }
       if (MainActivity.SunRound >= 2000 && MainActivity.SunRound < 2500) {
           BGColor = RGBtoRGB(ColorBG.get(4), ColorBG.get(5), 500, BGcounter);

       }
       if (MainActivity.SunRound == 2500) {
           BGcounter = 1;
       }
       if (MainActivity.SunRound >= 2500 && MainActivity.SunRound <= 3000) {
           BGColor = RGBtoRGB(ColorBG.get(5), ColorBG.get(6), 500, BGcounter);
       }
       if (MainActivity.SunRound == MainActivity.TotalSunRound) {
           BGcounter = 1;
           MainActivity.Sun.setY(0-(MainActivity.TotalSunRound-canvas.getHeight())/2);
       }


       this.setBackgroundColor(BGColor);

       MainActivity.Sun.DrawCircle(canvas,Color.YELLOW);


    }

    public void MoveMoon(Canvas canvas) {

        if (MainActivity.SunRound >= 2000 && MainActivity.SunRound < 2250) {
            MoonAlpha++;
        }
        if (MainActivity.SunRound >= 2700 && MainActivity.SunRound < 2950) {
            MoonAlpha--;
        }







        MainActivity.Moon.DrawCircle(canvas,Color.argb(MoonAlpha,253,250,232));

       MainActivity.MoonCover.setStepX(280);
       MainActivity.MoonCover.setX((MainActivity.Moon.getX()+MainActivity.Moon.getRadius()*2)-MainActivity.MoonCover.getStepX());
        MainActivity.MoonCover.setY((MainActivity.Moon.getY()-20));

        MainActivity.MoonCover.DrawCircle(canvas,BGColor);

for (int i =0;i<MainActivity.Stars.length;i++){
    MainActivity.Stars[i].DrawCircle(canvas,Color.argb(MoonAlpha,253,250,232));
}


    }

     // others

    public void DrawData(Canvas canvas, Paint pn1) {
        if (thisScore<MainActivity.score) {
            thisScore+=25;
        }
        if (thisScore>MainActivity.score) {
            thisScore-=25;
        }



        pn1.setTextSize(50);
        Missle x = new Missle(0,0,0,0);
        if (MainActivity.Missles.size()>0) {
            x = MainActivity.Missles.get(MainActivity.Missles.size()-1);
        }
        pn1.setStrokeWidth(5);
        pn1.setColor(Color.LTGRAY);
        canvas.drawLine(0,700,canvas.getWidth(),700,pn1);

        pn1.setColor(Color.BLACK);
        canvas.drawText(MainActivity.Missles.size()+"",300,650,pn1);


     //   pn1.setColor(Color.rgb(0,100,0));
    //    canvas.drawCircle(canvas.getWidth()-80,canvas.getHeight()-250,310,pn1);
    //    pn1.setColor(Color.rgb(34,139,34));
   //     canvas.drawCircle(canvas.getWidth()-80,canvas.getHeight()-250,300,pn1);
        pn1.setColor(Color.rgb(0,76,153));
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()+1100,1410,pn1);
        pn1.setColor(Color.rgb(102,178,255));
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()+1100,1400,pn1);

        pn1.setColor(Color.rgb(51,102,0));
        canvas.drawCircle(canvas.getWidth()-100,canvas.getHeight()+400,750,pn1);
        pn1.setColor(Color.rgb(102,204,0));
        canvas.drawCircle(canvas.getWidth()-100,canvas.getHeight()+400,740,pn1);
        pn1.setColor(Color.rgb(51,102,0));
        canvas.drawCircle(0-300,canvas.getHeight()+600,1000,pn1);
        pn1.setColor(Color.rgb(102,204,0));
        canvas.drawCircle(0-300,canvas.getHeight()+600,990,pn1);



        pn1.setColor(Color.BLACK);
        canvas.drawText("Survivals   " + MainActivity.EnemyReachedBase, canvas.getWidth()-350, 80, pn1);
   //     canvas.drawText("Missed Missles    " + MainActivity.MissedMissle, 35, canvas.getHeight() - 240, pn1);
   //     canvas.drawText("Missle Left     " + MainActivity.RocksQuantity, 35, canvas.getHeight() - 190, pn1);
        canvas.drawText("Score:" + MoonAlpha, 35, 80, pn1);
        pn1.setTextSize(100);
        pn1.setFakeBoldText(true);
        pn1.setColor(Color.MAGENTA);
        canvas.drawText("" + MainActivity.LevelFactor, 35, canvas.getHeight() - 50, pn1);
    //    canvas.drawText("level start counter: :      " + MainActivity.countBeforeLevelStart, 35, canvas.getHeight() - 40, pn1);

        MainActivity.DataCircles[0].DrawBomb(canvas,pn1);
        pn1.setColor(Color.BLACK);
        pn1.setTextSize(50);
        canvas.drawText("" + MainActivity.BombsQuantity, MainActivity.DataCircles[0].getX()- MainActivity.DataCircles[0].getRadius(), MainActivity.DataCircles[0].getY()+(MainActivity.DataCircles[0].getRadius()+50), pn1);


        MainActivity.DataCircles[1].DrawGold(canvas,pn1);
        canvas.drawText("" + MainActivity.GoldQuantity,  MainActivity.DataCircles[1].getX()- MainActivity.DataCircles[0].getRadius(), MainActivity.DataCircles[1].getY()+(MainActivity.DataCircles[1].getRadius()+50), pn1);

       //       MainActivity.DataCircles[2].DrawUpgrade(canvas,pn1);
      //  canvas.drawText("" + MainActivity.UpgradeQuantity,  MainActivity.DataCircles[2].getX()- MainActivity.DataCircles[0].getRadius(), MainActivity.DataCircles[2].getY()+(MainActivity.DataCircles[2].getRadius()+50), pn1);

        MainActivity.DataCircles[3].DrawAmo(canvas,pn1);
        canvas.drawText("" + MainActivity.MissleQuantity,  MainActivity.DataCircles[3].getX()- MainActivity.DataCircles[0].getRadius(), MainActivity.DataCircles[3].getY()+(MainActivity.DataCircles[3].getRadius()+50), pn1);

  //      MainActivity.DataCircles[4].DrawCircle(canvas,Color.YELLOW);


    //    MainActivity.DataCircles[5].DrawCircle(canvas,Color.GRAY);
        //canvas.drawText("" + MainActivity.MissleQuantity,  MainActivity.DataCircles[5].getX()- MainActivity.DataCircles[5].getRadius(), MainActivity.DataCircles[5].getY()+(MainActivity.DataCircles[5].getRadius()+50), pn1);

    }

    public void GameOver(Canvas canvas, Paint pn1) {
        pn1.setTextSize(80);
        MainActivity.MessegePlanes.add(new MessegePlane("GAME OVER -- YOUR SCORE IS: " + MainActivity.score + "                                                                                           TOUCH THE SCREEN FOR NEW GAME!",0));
        MainActivity.flagGameOver = false;
        for (int i = 0;i<MainActivity.Planes.size();i++){
            MainActivity.Planes.remove(i);
        }
        for (int i = 0;i<MainActivity.Missles.size();i++){
            MainActivity.Missles.remove(i);
        }
    }

    public void NewGame(){

        MainActivity.LevelFactor=0;
        MainActivity.MissedMissle = 0;
        MainActivity.EnemyReachedBase = 0;
        MainActivity.MassiveFactor = 0;
        MainActivity.flagGameOver = true;
        MainActivity.MissleQuantity=100;
        MainActivity.BombsQuantity = 10;
        MainActivity.UpgradeQuantity = 0;
        MainActivity.NumofMissleOneShot = 1;
        MainActivity.MissleFactor = 1;
        MainActivity.score= 0;
        thisScore =0;
        MainActivity.planeCreated =0;
        ChangeLevel();
        for (int i = 0;i<MainActivity.MessegePlanes.size();i++){
            MainActivity.MessegePlanes.remove(i);
        }

    }

    public void ChangeLevel(){

        MainActivity.LevelFactor++;
        MainActivity.MessegePlanes.add(new MessegePlane("Level "+MainActivity.LevelFactor,0));
        Toast.makeText(getContext(),"Level "+MainActivity.LevelFactor,Toast.LENGTH_SHORT).show();
        MainActivity.UpgradeFlag = true;
        if (MainActivity.LevelFactor % 3 ==0) {
            MainActivity.MassiveFactor+=15;
        }
        if (MainActivity.MissedMissle == 0 && MainActivity.EnemyReachedBase == 0 && MainActivity.LevelFactor != 1) {
            MainActivity.score = MainActivity.score + 200;
            Toast.makeText(getContext(),"No Survivals & no Missed Missles, 200 BONUS",Toast.LENGTH_SHORT).show();
        }
        MainActivity.planeCreated=0;
        MainActivity.countBeforeLevelStart = 200;

    }

    public void Hit (Missle ThisMissle,int j) {

        MainActivity.Planes.get(j).setDrawflag(false);

        ExplodeCreation(ThisMissle);

        GiftCreation(ThisMissle);

        MainActivity.score+=100;
    }


    public int RGBtoRGB (RGB colorA,RGB colorB,int rounds,float index){

        int ThisColor=0;
        double r1,g1,b1,r2,g2,b2;
        int Nr,Ng,Nb;
        double stepR,stepG,stepB;

        r1 = colorA.getR();g1 = colorA.getG();b1 = colorA.getB();
        r2 = colorB.getR();g2 = colorB.getG();b2 = colorB.getB();

       stepR = ( (r2-r1) / rounds );stepG = ( (g2-g1) / rounds );
       stepB = ( (b2-b1) / rounds );

        Nr = (int)(r1+(stepR*index));
        Ng = (int)(g1+(stepG*index));
        Nb = (int)(b1+(stepB*index));

        ThisColor = Color.rgb(Nr,Ng,Nb);



        return ThisColor;
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {



        super.onDraw(canvas);
        Paint pn1 = new Paint();
        MainActivity.flag11 = true;

        if (dataFlag) {
            CreateData(canvas);
            dataFlag = false;
        }



        MoveMoon(canvas);

        MoveSun(canvas);

        DrawData(canvas, pn1);

        MoveBackClouds(canvas, pn1);

        MovePlanes(canvas, pn1);

        MoveSmoke(canvas, pn1);

        MoveExplosion(canvas, pn1);

        MoveGift( canvas,  pn1);

        MoveMissles(canvas, pn1);

        MoveFrontClouds(canvas, pn1);

        MoveMessegePlanes(canvas);

        if (MainActivity.DrawHitsFlag) {
            DrawHits(canvas,pn1);
        }


        t = new task1();
        t.execute();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (MainActivity.flagGameOver && MainActivity.Buttonflag ) {

            //BOMBS

            if (event.getY() > MainActivity.DataCircles[0].getY() - MainActivity.DataCircles[0].getRadius() && event.getY() < MainActivity.DataCircles[0].getY() + MainActivity.DataCircles[0].getRadius()) {
                if (event.getX() > MainActivity.DataCircles[0].getX() - MainActivity.DataCircles[0].getRadius() && event.getX() < MainActivity.DataCircles[0].getX() + MainActivity.DataCircles[0].getRadius()) {
                    BombCreation();
                    return false;
                }
            }
            if (event.getY() > MainActivity.DataCircles[1].getY() - MainActivity.DataCircles[1].getRadius() && event.getY() < MainActivity.DataCircles[1].getY() + MainActivity.DataCircles[1].getRadius()) {
                if (event.getX() > MainActivity.DataCircles[1].getX() - MainActivity.DataCircles[1].getRadius() && event.getX() < MainActivity.DataCircles[1].getX() + MainActivity.DataCircles[1].getRadius()) {
                    if (MainActivity.GoldQuantity > 5) {
                        MainActivity.GoldQuantity -= 5;
                        MainActivity.BombsQuantity += 2;
                        MainActivity.MissleQuantity += 20;
                        Toast.makeText(getContext(), "you bought 30 Missles and 2 bombs", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "not enough gold..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            if (event.getY() > MainActivity.DataCircles[2].getY() - MainActivity.DataCircles[2].getRadius() && event.getY() < MainActivity.DataCircles[2].getY() + MainActivity.DataCircles[2].getRadius()) {
                if (event.getX() > MainActivity.DataCircles[2].getX() - MainActivity.DataCircles[2].getRadius() && event.getX() < MainActivity.DataCircles[2].getX() + MainActivity.DataCircles[2].getRadius()) {

                    if (MainActivity.UpgradeQuantity > 0) {
                        MainActivity.UpgradeQuantity--;
                        Toast.makeText(getContext(), "Upgraded", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(getContext(), "No Upgrade availibale", Toast.LENGTH_SHORT).show();
                    }
                }
            }


                }

        MainActivity.Buttonflag = true;

        if (MainActivity.flagGameOver) {
            switch  (event.getAction()) {
                case (MotionEvent.ACTION_DOWN) :
                    MainActivity.x1 = MainActivity.XtouchPos = (int) event.getX();
                    MainActivity.y1 = (int) event.getY();


                    break;
                case (MotionEvent.ACTION_MOVE) :
                    MainActivity.Buttonflag = false;
                    MainActivity.XtouchPos = (int) event.getX();
                    MainActivity.YtouchPos = (int) event.getY();
                    MainActivity.AimHitPath = new HitPath(MainActivity.x1 ,MainActivity.y1, (int) event.getX(),(int) event.getY(),20);
                        if ((int) event.getY()<MainActivity.y1-20 && MainActivity.MissleFlag && (int) event.getY()>700) {
                            MissleCreation((int)event.getX(),(int) event.getY(),(MainActivity.x1-(int) event.getX())*-8,(MainActivity.y1-(int) event.getY())*-8,Color.RED);
                           MainActivity.MissleFlag = false;
                        }
                    break;
                case (MotionEvent.ACTION_UP) :
                    MainActivity.AimHitPath = new HitPath (0,0,0,0,0);
                    MainActivity.x2 = MainActivity.XtouchPos = (int) event.getX();
                    MainActivity.y2 = MainActivity.YtouchPos = (int) event.getY();

                    if (MainActivity.y2 > MainActivity.y1+100 && MainActivity.y1>700) {
                        MainActivity.hits.add(new HitPath(MainActivity.x1,MainActivity.y1,MainActivity.x2,MainActivity.y2,15));
                        RocksCreation(MainActivity.x2,MainActivity.y2,MainActivity.x1-MainActivity.x2,MainActivity.y1-MainActivity.y2,0);


                    }
                    if (MainActivity.y2 < MainActivity.y1 && MainActivity.y2>700 && MainActivity.MissleFlag) {
                        //MainActivity.hits.add(new HitPath(MainActivity.x1,MainActivity.y1,MainActivity.x2,MainActivity.y2,15));
                        MissleCreation(MainActivity.x2,MainActivity.y2,(MainActivity.x1-MainActivity.x2)*-8,(MainActivity.y1-MainActivity.y2)*-8,Color.RED);


                    }
                    MainActivity.MissleFlag = true;
                    break;

            }
        }
        else {
            NewGame();
        }
        return true;
    }


class  task1 extends AsyncTask<Integer,Void,Void>
{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        MainActivity.count++;

        if (MainActivity.countBeforeLevelStart>0 ) {
            MainActivity.countBeforeLevelStart--;
        }
     //   if (MainActivity.count % (10)==0 && MainActivity.countBeforeLevelStart == 0){
        if (MainActivity.count % (110-(MainActivity.LevelFactor*5))==0 && MainActivity.countBeforeLevelStart == 0){
       // if (MainActivity.count % 40 ==0){
            PlaneCreation();
            MainActivity.planeCreated ++;
            if (MainActivity.planeCreated == MainActivity.LevelFactor*5 && MainActivity.LevelFactor<10){
                ChangeLevel();
            }
        }

        if (MainActivity.count % 100 == 0 && MainActivity.Clouds.size()<4) {
            CloudCreation();
        }

            if (MainActivity.count % 5 == 0) {
            for (int i = 0;i<MainActivity.Explosion.size();i++){
                MainActivity.Explosion.get(i).setRadius(MainActivity.Explosion.get(i).getRadius()-1);
                if (MainActivity.Explosion.get(i).getRadius()<1) {
                    MainActivity.Explosion.remove(i);
                }

            }

                for (int i = 0;i<MainActivity.Smoke.size();i++){
                    MainActivity.Smoke.get(i).setRadius(MainActivity.Smoke.get(i).getRadius()-1);
                    if (MainActivity.Smoke.get(i).getRadius()<1) {
                        MainActivity.Smoke.remove(i);
                    }

                }
        }

        if (MainActivity.count == 100000) {
            MainActivity.count = 1;
        }
        MainActivity.flag11 = false;
        invalidate();
    }



    @Override
    protected Void doInBackground(Integer... params) {
        try {
            while (MainActivity.flag11)
            {


                publishProgress();
                Thread.sleep(30);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
}
