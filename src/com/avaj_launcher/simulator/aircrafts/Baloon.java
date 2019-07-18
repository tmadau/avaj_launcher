package com.avaj_launcher.simulator.aircrafts;
import com.avaj_launcher.simulator.WeatherTower;
import com.avaj_launcher.weather.Coordinates;
import com.avaj_launcher.simulator.Logger;

class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                coordinates.setLongitude(2);
                coordinates.setHeight(4);
                Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + "): Ahh! Sunshine is the best medicine, let me just put on my sunglasses 😎");
                break;
            case "RAIN":
                coordinates.setHeight(-5);
                Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + "): I can feel this rain and I am also wet, why me??? 😭");
                break;
            case "FOG":
                coordinates.setHeight(-3);
                Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + "): I am literally blind, I think I might land this thing.");
                break;
            case "SNOW":
                coordinates.setHeight(-15);
                Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + "): I am cold as ice, I might end up freezing brrr.. 🥶");
                break;
            default:
                Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + "): Oh!!! Snap I can't reach the weather tower.");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            Logger.getLogger().logtofile("Baloon#" + this.name + "(" + this.id + ") Landing...... 🛬");
            Logger.getLogger().logtofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower 🏢");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.getLogger().logtofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower     ✅");
    }
}
