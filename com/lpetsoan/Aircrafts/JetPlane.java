package com.lpetsoan.Aircrafts;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.*;
import com.lpetsoan.Towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
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
                this.coordinates.incLatitude(5);
                print("BOOHOO ITS RAINING"); 
                break;
            case "FOG":
                this.coordinates.incLongitude(1);
                print("I cant see shit up here.");
                break;
            case "SNOW":
                this.coordinates.incHeight(7);
                print("Saint nick must be in a hurry!!");
                break;
            case "SUN":
                this.coordinates.incLongitude(10);
                this.coordinates.incHeight(2);
                print("Up we gooooo....");
                break;
                
        }
        if (this.coordinates.getHeight() == 0){
            System.out.println("Unregister JetPlane: " + this.name);
            this.weatherTower.unregister(this);
            return;
        }
    }

    private void print(String string){
        System.out.println("JetPlane#" + this.name + "("+ this.id + "):" + string);
    }
}