package com.lpetsoan.Towers;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

import com.lpetsoan.Aircrafts.Interfaces.Flyable;

public abstract class Tower {
    private List<Flyable> registeredFlyers = new CopyOnWriteArrayList<Flyable>();//ArrayList<Flyable>();

    public Tower(){

    }

    public void register(Flyable flyable){
        registeredFlyers.add(flyable);
    }
    
    public void unregister(Flyable flyable){
        registeredFlyers.remove(flyable);
    }

    protected void conditionsChanged(){
        System.out.println("[The Vector size]: " + registeredFlyers.size());
        if (registeredFlyers.size() != 0){
            for (Flyable flyer : registeredFlyers){
                flyer.updateConditions();
            }
        }
    }
}