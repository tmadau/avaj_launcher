package com.avaj_launcher.simulator.aircrafts;
import com.avaj_launcher.weather.Coordinates;

public abstract class AircraftFactory {
    
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        
        switch (type) {
            case "Baloon":
                return new Baloon(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            default:
                throw new RuntimeException("invalid flyable type: " + type);
        }
    }
}
