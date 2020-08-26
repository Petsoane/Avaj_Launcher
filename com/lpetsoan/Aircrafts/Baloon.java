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
        this.weatherTower.register(this);
    }

    @Override
    public void updateConditions(){
        String condition = this.weatherTower.getWeather(coordinates);

        switch(condition){
            case "RAIN": 
                this.coordinates.dcrHeight(5);
                print("Booho its raining");
                break;
            case "FOG":
                this.coordinates.dcrHeight(3);
                print("I cant see shit up here.");
                break;
            case "SNOW":
                this.coordinates.dcrHeight(15);
                print("Saint nick must be in a hurry!!");
                break;
            case "SUN":
                this.coordinates.incLongitude(2);
                this.coordinates.incHeight(4);
                print("Up we gooooo....");
                break;
                
        }

        if (this.coordinates.getHeight() == 0){
            System.out.println("Unregister Baloon: " + this.name);
            this.weatherTower.unregister(this);
            return;
        }
    }

    private void print(String string){
        System.out.println("Ballon#" + this.name + "("+ this.id + "):" + string);
    }

}