package com.lpetsoan.WeatherProvider;

import java.util.Random;

import com.lpetsoan.Coordinates;

enum conditions{
    SUN, RAIN,FOG, SNOW
}


public class WeatherProvider {
    
    private static WeatherProvider weatherProvider = null;
    private String quads[];
    
    private WeatherProvider(){
        quads = new String[6];

        Random rand = new Random();
        int choice;

        conditions[] w = conditions.values();
        
        
        for (int i=0; i < 6; i++){
            choice = rand.nextInt(4);
            quads[i] = w[choice].toString();
        }


    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){

        if (coordinates.getHeight() < 25){
            return quads[0];
        }
        if (coordinates.getHeight() < 50) return quads[1];
        if (coordinates.getHeight() < 75) return quads[2];
        else return quads[3];
        
    }
    
}