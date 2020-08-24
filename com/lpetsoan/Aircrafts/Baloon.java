package com.lpetsoan.Aircrafts;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.*;
import com.lpetsoan.Towers.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
        // this.weatherTower = null;
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions(){
        String condition = this.weatherTower.getWeather(coordinates);

        switch(condition){
            case "RAIN": 
                this.coordinates.dcrHeight(5);
                System.out.println("BOOHOO ITS RAINING"); 
                break;
            default: System.out.println("OKAY WTF!!! FOR REAL..... This ain't faaaiiirr");
        }
        System.out.println(this.name + " height " + this.coordinates.getHeight());
        if (this.coordinates.getHeight() == 0){
            System.out.println("Unregister Baloon: " + this.name);
        }
    }

}