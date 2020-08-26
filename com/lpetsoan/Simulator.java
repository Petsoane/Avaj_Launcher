package com.lpetsoan;

import java.io.PrintStream;

import com.lpetsoan.Aircrafts.Factories.AircraftFactory;
import com.lpetsoan.Aircrafts.Interfaces.Flyable;
import com.lpetsoan.Towers.WeatherTower;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Simulator {

    public static void main(String[] args){

        if (args.length == 0){
            System.out.println("Provide a file name!");
            System.exit(0);
        }

        WeatherTower t = new WeatherTower();
        List<String> list;
        int limit;
 
        try{
            System.setOut(new PrintStream(new File("Simulation.txt")));
                   
            
            list = getInstances(args[0]);
            limit = Integer.parseInt(list.get(0));
            list.remove(0);

            initObjects(t, list);

            for (int i = 0; i <limit; i++)
                t.changeWeather();
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Tries to get the strings from the given file. 
     * @return
     */
    private static List<String> getInstances(String filename) throws FileNotFoundException
    {
        Scanner file = null;
        List<String> list = null;

        try{
            file = new Scanner(new File(filename));
            list = new ArrayList<String>();
            String line;

            while (file.hasNextLine()){
                line = file.nextLine();
                if (line.length() > 0)
                    list.add(line);
            }
        }
        catch (FileNotFoundException e){
            throw e;
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
    private static void initObjects(WeatherTower weatherTower, List<String> list) throws Exception
    {
        AircraftFactory af = new AircraftFactory();
        Flyable f;
        int longitude, latitude, height;

        for (String str: list){
            String[] options = str.split(" ", str.length());
            System.out.println(options.length);
            
            if (options.length < 5 || options.length > 5){
                throw new Exception("Invalid input length");
            }
            longitude = Integer.parseInt(options[2]);
            latitude = Integer.parseInt(options[3]);
            height = Integer.parseInt(options[4]);

            if (longitude > 1000 || latitude > 1000){
                throw new Exception("Invalid size for one of your coordinates....");
            }
            
            try{
                f = af.newAircraft(options[0], options[1], longitude, latitude, height);
                f.registerTower(weatherTower);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return;
    }
}