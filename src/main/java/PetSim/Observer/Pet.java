package PetSim.Observer;


import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.MoodState;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private int hunger;
    private int energy;
    private int health;
    private String type;
    private MoodState mood;
    private double objective = 0;
    private boolean alive = true;

    private final List<PetObserver> observers = new ArrayList<>();

    public Pet(String name, String type, MoodState mood) {
        this.name = name;
        this.mood = mood;
        this.type = type;
        this.hunger = 50;
        this.energy = 50;
        this.health = 50;
        this.objective = 0;
    }

    public double getObjective() { return objective; }
    public boolean isAlive() { return alive; }

    public void feed() {
        hunger -= 10;
        health += 10;
        energy += 5;
        objective += 1.5;
        mood.onFeed(this);
        checkState();
        if (alive) notifyObservers();
    }

    public void play() {
        hunger += 10;
        health -= 5;
        energy -= 10;
        objective += 1.5;
        mood.onPlay(this);
        checkState();
        if (alive) notifyObservers();
    }

    public void rest() {
        hunger += 10;
        health += 5;
        energy += 15;
        objective += 1.5;
        mood.onRest(this);
        checkState();
        if (alive) notifyObservers();
    }

    private void checkState() {

        if (energy <= 0) {
            energy = 0;
            System.out.println("Your pet is resting due to exhaustion.");
            rest();
            return;
        }

        if (hunger >= 100) {
            alive = false;
            System.out.println("Your pet died from starving. Game over.");
            return;
        }
        if (health >= 100) {
            alive = false;
            System.out.println("Your pet died from obesity. Game over.");
            return;
        }


        if (health <= 0) {
            alive = false;
            System.out.println("Your pet died from losing health. Game over.");
            return;
        }

        if (objective >= 10 && (mood instanceof HappyState)) {
            System.out.println("Your pet is fully happy! You win!");
            alive = false;
        }
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

    public String getType() { return type; }

    public void showInitialUI() {
        for (PetObserver obs : observers) {
            obs.update(this);
        }
    }

    public String getName() {
        return name;
    }
}

