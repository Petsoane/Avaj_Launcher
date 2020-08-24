package com.lpetsoan.Towers;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;
import com.lpetsoan.WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower{

    @Override
    public void register(Flyable flyable){
        super.register(flyable);
        flyable.registerTower(this);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}