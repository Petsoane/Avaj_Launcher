package com.lpetsoan.Aircrafts.Interfaces;

import com.lpetsoan.Towers.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    
}