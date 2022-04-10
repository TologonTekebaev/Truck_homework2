package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Truck {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");

    private int ID;
    private String name;
    private String driver;
    private StateOfTrucks state;

    public Truck(){

    }

    public Truck(int ID, String name, String driver, StateOfTrucks state) {
        this.ID = ID;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public StateOfTrucks getState() {
        return state;
    }

    public void setState(StateOfTrucks state) {
        this.state = state;
    }
    public static void getTruck(){
        Truck[]trucks = {new Truck(1, "MAN", "", StateOfTrucks.BASE),
        new Truck(2, "BELAZ", "", StateOfTrucks.BASE),
        new Truck(3, "MAZ", "", StateOfTrucks.BASE)
        };
        Gson gson = new Gson();
        String json = GSON.toJson(trucks);
        System.out.println(readTruckFile());
        writeCarFile(json);


        Truck[] truck = GSON.fromJson(readTruckFile(),Truck[].class);
        for (Truck t :truck) {
            System.out.println(truck.toString());
        }
    }

    private static void writeCarFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write,object, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTruckFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int id;
            while ((id = fileReader.read())!=-1){
                json += (char)id;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    @Override
    public String toString() {
        return  ID +" "+ name + "   |"    + state + "     |" + driver;
    }
}
