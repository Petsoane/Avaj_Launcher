package com.lpetsoan;

import com.lpetsoan.Aircrafts.Factories.AircraftFactory;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;
import com.lpetsoan.Towers.Tower;
import com.lpetsoan.Towers.WeatherTower;
import com.lpetsoan.WeatherProvider.WeatherProvider;


public class Simulator {

    public static void main(String[] args){
        System.out.println("This is a simple compilation test");

        AircraftFactory af = new AircraftFactory();
        WeatherTower t = new WeatherTower();

        try{
            Flyable f = af.newAircraft("Baloon", "Boobies baloon", 58, 12, 12);

            t.register(f);

            for (int i = 0; i < 5; i++)
                t.changeWeather();
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
}