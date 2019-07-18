package com.avaj_launcher.simulator.aircrafts;
import com.avaj_launcher.simulator.WeatherTower;

public interface Flyable {
    
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
