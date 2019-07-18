package com.avaj_launcher.simulator;
import com.avaj_launcher.simulator.aircrafts.Flyable;
import java.util.ArrayList;

public abstract class Tower {
    
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
    protected void conditionsChanged() {
        int store;
        for (int i = 0; i < observers.size() ; i++) {
            store = observers.size();
            observers.get(i).updateConditions();
            if (store != observers.size()) {
                i--;
            }
        }
    }
}
