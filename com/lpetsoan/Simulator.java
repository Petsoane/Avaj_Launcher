package com.lpetsoan;

import java.io.PrintStream;

import com.lpetsoan.Aircrafts.Factories.AircraftFactory;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;
import com.lpetsoan.Towers.WeatherTower;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Simulator {

    public static void main(String[] args){

        WeatherTower t = new WeatherTower();
        List<String> list;
        int limit;
 
        try{
            System.setOut(new PrintStream(new File("Simulation.txt")));
                   
        
            list = getInstances();
            limit = Integer.parseInt(list.get(0));
            list.remove(0);

            initObjects(t, list);

            for (int i = 0; i <limit; i++)
                t.changeWeather();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Tries to get the strings from the given file. 
     * @return
     */
    private static List<String> getInstances(){
        Scanner file = null;
        List<String> list = null;

        try{
            file = new Scanner(new File("com/lpetsoan/scenario.txt"));
            list = new ArrayList<String>();
            String line;

            while (file.hasNextLine()){
                line = file.nextLine();
                if (line.length() > 0)
                    list.add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if (file != null){
                file.close();
            }
        }
        return list;
       
    }

    /**
     * This will try to create all the objects and register them to the 
     * tower.
     * @param weatherTower
     */
    private static void initObjects(WeatherTower weatherTower, List<String> list){
        AircraftFactory af = new AircraftFactory();
        Flyable f;

        for (String str: list){
            String[] options = str.split(" ", str.length());
            try{
                f = af.newAircraft(options[0], options[1], Integer.parseInt(options[2]), Integer.parseInt(options[3]), Integer.parseInt(options[4]));
                f.registerTower(weatherTower);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return;
    }
}