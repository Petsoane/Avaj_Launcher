package com.lpetsoan;

public class Coordinates{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        
        if (height > 100) height = 100;
        this.height = height;

    }

    public final int getLongitude(){
        return this.longitude;
    }
    public void incLongitude(int amnt){
        if (this.longitude + amnt > 260){
            this.longitude = 260;
        }
        else this.longitude += amnt;
    }
    public void dcrLongitude(int amnt){
        if (this.longitude - amnt < 0){
            this.longitude = 0;
        }
        else this.longitude -= amnt;
    }

    public final int getLatitude(){
        return this.latitude;
    }
    public void incLatitude(int amnt){
        if (this.longitude + amnt > 260){
            this.longitude = 260;
        }
        else this.longitude += amnt;
    }
    public void dcrLatitude(int amnt){
        if (this.longitude - amnt < 0){
            this.longitude = 0;
        }
        else this.longitude -= amnt;
    }

    public final int getHeight(){
        return this.height;
    }
    public void incHeight(int amnt){
        if (this.height + amnt > 100){
            this.height = 100;
        }
        else this.height += amnt;
    }
    public void dcrHeight(int amnt){
        if (this.height - amnt < 0){
            this.height = 0;
        }
        else this.height -= amnt;
    }
}