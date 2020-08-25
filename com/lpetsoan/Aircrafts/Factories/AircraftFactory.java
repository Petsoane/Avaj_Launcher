package com.lpetsoan.Aircrafts.Factories;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.*;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;


import java.lang.Exception;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
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
            throw new Exception("There is no Flyable object");
        }
        return ret;
    }
    
}