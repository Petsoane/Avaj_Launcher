package com.lpetsoan.Aircrafts.Factories;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.*;
import com.lpetsoan.Aircrafts.Factories.Exceptions.InvalidFlyableType;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;



public abstract class AircraftFactory {

    public static  Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidFlyableType
    {
        Coordinates c = new Coordinates(longitude, latitude, height);
        Flyable ret = null;

        switch(type){
            case "Baloon":
                ret = new Baloon(name, c);
                break;
            case "Helicopter":
                ret = new Helicopter(name, c);
                break;
            case "JetPlane":
                ret = new JetPlane(name, c);
                break;
        }

        if (ret == null){
            throw new InvalidFlyableType(type);
        }
        return ret;
    }
    
}