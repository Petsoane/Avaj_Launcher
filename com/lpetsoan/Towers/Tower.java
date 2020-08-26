package com.lpetsoan.Towers;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

import com.lpetsoan.Aircrafts.Aircraft;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;

public abstract class Tower {
    private List<Flyable> registeredFlyers = new CopyOnWriteArrayList<Flyable>();//ArrayList<Flyable>();

    public Tower(){

    }

    public void register(Flyable flyable){
        Aircraft tmp = (Aircraft)flyable;

        registeredFlyers.add(flyable);
        System.out.println("Tower says: " + tmp.getName()+ " registered");
    }
    
    public void unregister(Flyable flyable){
        Aircraft  tmp = (Aircraft)flyable;

        registeredFlyers.remove(flyable);
        System.out.println("Tower says: " + tmp.getName() +" unregistered");
    }

    protected void conditionsChanged(){
        if (registeredFlyers.size() != 0){
            for (Flyable flyer : registeredFlyers){
                flyer.updateConditions();
            }
        }
    }
}