package PetSim.Observer;


import PetSim.Observer.MoodStates.MoodState;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private int hunger;
    private int energy;
    private int health;
    private MoodState mood;

    private final List<PetObserver> observers = new ArrayList<>();

    public Pet(String name, MoodState mood) {
        this.name = name;
        this.mood = mood;
        this.hunger = 50;
        this.energy = 50;
        this.health = 50;
    }

    public void feed() {
        hunger -= 10;
        mood.onFeed(this);
        notifyObservers();
    }

    public void play() {
        energy -= 10;
        mood.onPlay(this);
        notifyObservers();
    }

    public void rest() {
        energy += 15;
        notifyObservers();
    }

    public void setMood(MoodState mood) {
        this.mood = mood;
    }

    public String getStatus() {
        return "Pet: " + name +
                " | Mood: " + mood.getName() +
                "\nHunger: " + hunger +
                " Energy: " + energy +
                " Health: " + health;
    }

    public void addObserver(PetObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers() {
        for (PetObserver obs : observers) {
            obs.update(this);
        }
    }

    // getters & setters for save/load
    public int getHunger() { return hunger; }
    public int getEnergy() { return energy; }
    public int getHealth() { return health; }
    public String getMoodName() { return mood.getName(); }

    public void setStats(int h, int e, int he) {
        hunger = h;
        energy = e;
        health = he;
    }
}

