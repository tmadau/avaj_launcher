package com.avaj_launcher.simulator;
import com.avaj_launcher.weather.Coordinates;
import com.avaj_launcher.weather.WeatherProvider;

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    void changeWeather() {
        this.conditionsChanged();
    }
}
