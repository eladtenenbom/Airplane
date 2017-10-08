package com.example.elad.airplane;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {

    static List<Missle> Score = new ArrayList<Missle>();
    static List<Missle> Missles = new ArrayList<Missle>();
    static List<plane>  Planes= new ArrayList<plane>();
    static List<MessegePlane>  MessegePlanes= new ArrayList<MessegePlane>();
    static List<Circle> Smoke = new ArrayList<Circle>();
    static List<Circle> Explosion = new ArrayList<Circle>();
    static List<Circle> Gift = new ArrayList<Circle>();
    static List<Cloud1> Clouds = new ArrayList<Cloud1>();
    static List<HitPath> hits = new ArrayList<HitPath>();

    static Circle[] DataCircles = new Circle[6];
    static Circle[] Stars = new Circle[20];
    static Circle Sun = new Circle();
    static Circle Moon = new Circle();
    static Circle MoonCover = new Circle();
    static int SunRound;

    static Missle mp1;

    static HitPath AimHitPath = new HitPath(0,0,0,0,0);
    static int score;

    static int GoldQuantity=1;
    static int BombsQuantity=10;
    static int UpgradeQuantity=0;
    static int MissleQuantity=100;
    static int RocksQuantity=100;
    static int LaserQuantity=5;



    static int planeCreated=0;
    static List <Level>levels = new ArrayList<Level>();
    static int MassiveFactor = 0;

    static int x1 ;
    static int y1;
    static int x2;
    static int y2;

    static Bitmap planeDrawA;
    static Bitmap treasureBox;
    static Bitmap bg;
    static Bitmap bomb;
    static Bitmap upg;
    static Bitmap cloud;
    static Bitmap missle;
    static Bitmap amo;
    static Bitmap coin;
    static Bitmap grass1;


    static int XtouchPos=0;
    static int YtouchPos=0;

    static int CanvasWidth=0;
    static int CanvasHeight=0;

    static int count=0;
    static int MissedMissle=0;

    static int countBeforeLevelStart = 0;
    static int LevelFactor=1;
    static int MissleFactor=1;
    static int NumofMissleOneShot = 1;

    static int DrawPlaneFlag=0;
    static int EnemyReachedBase=0;

    static int y =100;
    static     int rnd=0;
    static int BGfactor =0;

    static int BGColor =0;

    static double stepR;
    static double stepG;
    static double stepB;

    static int Nr,Ng,Nb;


    static float MissleX;
    static float MisseleY;


    static boolean Buttonflag = true;
    static boolean DrawHitsFlag = true;
    static boolean flag11 = true;
    static boolean UpgradeFlag = true;
    static boolean flagGameOver = true;
    static boolean MissleFlag = true;


    static boolean Sunflag = true;
    static int TotalSunRound = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView mv1 = new myView(this);
        CanvasWidth = mv1.getWidth();
        CanvasHeight = mv1.getHeight();
       // mv1.setBackgroundColor(Color.rgb(195-alpha,225-alpha,255-alpha));

        Color.argb(255, 118, 118, 188);

        planeDrawA = BitmapFactory.decodeResource(getResources(),R.drawable.plane7);
        treasureBox = BitmapFactory.decodeResource(getResources(),R.drawable.tb1);

        bomb = BitmapFactory.decodeResource(getResources(),R.drawable.bomb1);
        upg = BitmapFactory.decodeResource(getResources(),R.drawable.upg);


        amo = BitmapFactory.decodeResource(getResources(),R.drawable.amo);



        setContentView(mv1);
        WindowManager m = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display d = m.getDefaultDisplay();


       // Toast.makeText(getApplicationContext(), "Level 1", Toast.LENGTH_LONG).show();


    }





}


