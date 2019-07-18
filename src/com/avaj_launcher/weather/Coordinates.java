package com.avaj_launcher.weather;
import com.avaj_launcher.simulator.Logger;

public class Coordinates {
    
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates (int longitude, int latitude, int height) {
        setLongitude(longitude);
        setLatitude(latitude);
        setHeight(height);
    }

    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }

    public	void setLongitude(int longitude) {
	    this.longitude += longitude;
	}
	public	void setLatitude(int latitude) {
		this.latitude += latitude;
	}
	public	void setHeight(int height) {
		this.height += height;
		if(this.height > 100) {
            this.height = 100;
        }
	}
}
