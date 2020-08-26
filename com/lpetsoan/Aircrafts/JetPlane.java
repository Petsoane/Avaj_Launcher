package com.lpetsoan.Aircrafts;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.*;
import com.lpetsoan.Towers.WeatherTower;

public class JetPlane extends Aircraft {
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
                print("Lemme see if i can get out of this."); 
                break;
            case "FOG":
                this.coordinates.incLongitude(1);
                print("Moving for sight.");
                break;
            case "SNOW":
                this.coordinates.incHeight(7);
                print("Above the clouds must be better");
                break;
            case "SUN":
                this.coordinates.incLongitude(10);
                this.coordinates.incHeight(2);
                print("Tis a great day.");
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