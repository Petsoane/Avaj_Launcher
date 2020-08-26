package com.lpetsoan.Aircrafts.Factories.Exceptions;

import java.lang.Exception;

public class InvalidFlyableType extends Exception{
    public InvalidFlyableType(String type){
        super(type + " is not a valid aircraft type");
    }
    
}