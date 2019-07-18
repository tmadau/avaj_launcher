package com.avaj_launcher.weather;
import com.avaj_launcher.weather.Coordinates;

public class WeatherProvider {
	
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {}
    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(((coordinates.getLatitude()) % 3) + (coordinates.getLongitude() % 4) + ((coordinates.getHeight()) % 7)) % 4];
    }
}
