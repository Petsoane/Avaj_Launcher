package com.lpetsoan.Towers;

import java.util.Vector;

import com.lpetsoan.Aircrafts.Interfaces.Flyable;

public abstract class Tower {
    private Vector<Flyable> registeredFlyers;

    public Tower(){
        registeredFlyers = new Vector<Flyable>();

    }

    public void register(Flyable flyable){
        registeredFlyers.add(flyable);
    }
    
    private void unregister(Flyable flyable){
        registeredFlyers.remove(flyable);
    }

    protected void conditionsChanged(){
        registeredFlyers.forEach((flyer) -> flyer.updateConditions());
    }
}