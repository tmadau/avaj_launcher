package com.avaj_launcher.simulator.aircrafts;
import com.avaj_launcher.weather.Coordinates;

public abstract class Aircraft {    

    protected long id;
    protected final String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private long nextId() {
        return (Aircraft.idCounter)++;
    }
}
