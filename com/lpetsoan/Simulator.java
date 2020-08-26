package com.lpetsoan;

import com.lpetsoan.Aircrafts.Factories.AircraftFactory;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;
import com.lpetsoan.Towers.WeatherTower;


public class Simulator {

    public static void main(String[] args){

        AircraftFactory af = new AircraftFactory();
        WeatherTower t = new WeatherTower();

        try{
            Flyable b = af.newAircraft("Baloon", "Boobies baloon", 340, 400, 100);
            Flyable hc = af.newAircraft("Helicopter", "Boobies Helipcopter", 34, 12, 10);
            Flyable jp = af.newAircraft("JetPlane", "Boobies Jet", 34, 12, 10);

            b.registerTower(t);
            jp.registerTower(t);
            hc.registerTower(t);

            for (int i = 0; i < 5; i++)
                t.changeWeather();
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
}