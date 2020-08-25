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
        quads = new String[7];

        Random rand = new Random();
        int choice;

        conditions[] w = conditions.values();
        
        System.out.println("Setting up quadrants");
        for (int i=0; i < 7; i++){
            choice = rand.nextInt(4);
            System.out.println("[Random choice] " + choice);

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
            if (coordinates.getLongitude() < 100)
                return quads[0];
            return quads[1];
        }
        if (coordinates.getHeight() < 50){
            if (coordinates.getLongitude() < 200)
                return quads[2];
            return quads[3];
        }
        if (coordinates.getHeight() < 75) {
            if (coordinates.getLongitude() < 400)
                return quads[4];
            return quads[5];
        }
        else return quads[6];
        
    }
    
}