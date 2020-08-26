package com.lpetsoan.Aircrafts;

import com.lpetsoan.Coordinates;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;

public abstract class Aircraft implements Flyable{
    static private long idCount;
    protected long id;

    protected String name;
    protected Coordinates coordinates;


    public Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCount++;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }

    public long nextId(){
        return idCount;
    }

}

