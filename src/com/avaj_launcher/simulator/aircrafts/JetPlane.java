package com.avaj_launcher.simulator.aircrafts;
import com.avaj_launcher.simulator.WeatherTower;
import com.avaj_launcher.weather.Coordinates;
import com.avaj_launcher.simulator.Logger;

class JetPlane extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (this.weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                coordinates.setLatitude(10);
                coordinates.setHeight(2);
                Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): Ahh! Sunshine is the best medicine, let me just put on my sunglasses 😎");
                break;
            case "RAIN":
                coordinates.setLatitude(5);
                Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): Good thing I have cover, take that rain. 😅");
                break;
            case "FOG":
                coordinates.setLatitude(1);
                Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): I am literally blind, I think I might land this thing.");
                break;
            case "SNOW":
                coordinates.setHeight(-7);
                Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): I am cold as ice, I might end up freezing brrr.. 🥶");
                break;
            default:
                Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): Oh!!! Snap I can't reach the weather tower");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            Logger.getLogger().logtofile("JetPlane#" + this.name + "(" + this.id + "): Landing...... 🛬");
            Logger.getLogger().logtofile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower 🏢");
        }
    }
    
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.getLogger().logtofile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower   ✅");
    }
}
