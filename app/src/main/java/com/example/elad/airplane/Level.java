package com.example.elad.airplane;

/**
 * Created by elad on 28/05/2017.
 */

public class Level {
    int NumOfPlanes;
    int LevelFactor;

    public Level(int numOfPlanes, int levelFactor) {
        NumOfPlanes = numOfPlanes;
        LevelFactor = levelFactor;
    }

    public int getNumOfPlanes() {
        return NumOfPlanes;
    }

    public void setNumOfPlanes(int numOfPlanes) {
        NumOfPlanes = numOfPlanes;
    }

    public int getLevelFactor() {
        return LevelFactor;
    }

    public void setLevelFactor(int levelFactor) {
        LevelFactor = levelFactor;
    }

}
