package com.lpetsoan.Aircrafts;

import com.lpetsoan.Towers.Tower;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.*;
import com.lpetsoan.Towers.WeatherTower;

public class Helicopter extends Aircraft{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        // this.weatherTower = null;
    }

    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public void updateConditions(){
        String condition = this.weatherTower.getWeather(coordinates);

        switch(condition){
            case "RAIN": 
                this.coordinates.incLongitude(5);
                print("Time to find greener pastures."); 
                break;
            case "FOG":
                this.coordinates.incLongitude(1);
                print("Meh");
                break;
            case "SNOW":
                this.coordinates.dcrHeight(12);
                print("Going down.");
                break;
            case "SUN":
                this.coordinates.incLongitude(10);
                this.coordinates.incHeight(2);
                print("Perfect day for booty watching.");
                break;
                
        }
        if (this.coordinates.getHeight() == 0){
            System.out.println("Unregister Helicopter: " + this.name);
            this.weatherTower.unregister(this);
            return;
        }
    }

    private void print(String string){
        System.out.println("Helicopter#" + this.name + "("+ this.id + "):" + string);
    }
}