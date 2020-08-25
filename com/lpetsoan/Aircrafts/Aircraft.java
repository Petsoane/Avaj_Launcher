package com.lpetsoan.Aircrafts;

import com.lpetsoan.*;

public abstract class Aircraft{
    static private long idCount;
    protected long id;

    protected String name;
    protected Coordinates coordinates;


    public Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCount++;
    }

    public long nextId(){
        return this.idCount;
    }

}

