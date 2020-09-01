package com.lpetsoan.Towers;

import com.lpetsoan.Coordinates;
import com.lpetsoan.WeatherProvider.WeatherProvider;

public class WeatherTower extends Tower{

    public void changeWeather(){
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}