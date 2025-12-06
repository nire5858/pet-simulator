package PetSim.Observer;


import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.MoodState;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private static final int DEFAULT_STAT_VALUE = 50;

    private static final int MAX_HUNGER = 100;
    private static final int MAX_HEALTH = 100;
    private static final int MIN_STAT = 0;

    private static final int FEED_HUNGER_CHANGE = -10;
    private static final int FEED_HEALTH_CHANGE = 10;
    private static final int FEED_ENERGY_CHANGE = 5;

    private static final int PLAY_HUNGER_CHANGE = 10;
    private static final int PLAY_HEALTH_CHANGE = -5;
    private static final int PLAY_ENERGY_CHANGE = -10;

    private static final int REST_HUNGER_CHANGE = 10;
    private static final int REST_HEALTH_CHANGE = 5;
    private static final int REST_ENERGY_CHANGE = 15;

    private static final double OBJECTIVE_INCREMENT = 1.5;
    private static final double OBJECTIVE_WIN_THRESHOLD = 10.0;

    private String name;
    private int hunger;
    private int energy;
    private int health;
    private String type;
    private MoodState mood;
    private double objective = 0.0;
    private boolean alive = true;

    private final List<PetObserver> observers = new ArrayList<>();

    public Pet(String name, String type, MoodState mood) {
        this.name = name;
        this.mood = mood;
        this.type = type;
        this.hunger = DEFAULT_STAT_VALUE;
        this.energy = DEFAULT_STAT_VALUE;
        this.health = DEFAULT_STAT_VALUE;
        this.objective = 0.0;
    }

    public double getObjective() { return objective; }
    public boolean isAlive() { return alive; }

    public void feed() {
        hunger += FEED_HUNGER_CHANGE;
        health += FEED_HEALTH_CHANGE;
        energy += FEED_ENERGY_CHANGE;
        objective += OBJECTIVE_INCREMENT;

        mood.onFeed(this);
        checkState();
        if (alive) notifyObservers();
    }

    public void play() {
        hunger += PLAY_HUNGER_CHANGE;
        health += PLAY_HEALTH_CHANGE;
        energy += PLAY_ENERGY_CHANGE;
        objective += OBJECTIVE_INCREMENT;

        mood.onPlay(this);
        checkState();
        if (alive) notifyObservers();
    }

    public void rest() {
        hunger += REST_HUNGER_CHANGE;
        health += REST_HEALTH_CHANGE;
        energy += REST_ENERGY_CHANGE;
        objective += OBJECTIVE_INCREMENT;

        mood.onRest(this);
        checkState();
        if (alive) notifyObservers();
    }

    private void checkState() {

        if (energy <= MIN_STAT) {
            energy = MIN_STAT;
            System.out.println("Your pet is resting due to exhaustion.");
            rest();
            return;
        }

        if (hunger >= MAX_HUNGER) {
            alive = false;
            System.out.println("Your pet died from starving. Game over.");
            return;
        }

        if (health >= MAX_HEALTH) {
            alive = false;
            System.out.println("Your pet died from obesity. Game over.");
            return;
        }

        if (health <= MIN_STAT) {
            alive = false;
            System.out.println("Your pet died from losing health. Game over.");
            return;
        }

        if (objective >= OBJECTIVE_WIN_THRESHOLD && (mood instanceof HappyState)) {
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

    public int getHunger() { return hunger; }
    public int getEnergy() { return energy; }
    public int getHealth() { return health; }
    public String getMoodName() { return mood.getName(); }

    public void setStats(int hunger, int energy, int health) {
        this.hunger = hunger;
        this.energy = energy;
        this.health = health;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public void showInitialUI() {
        for (PetObserver obs : observers) {
            obs.update(this);
        }
    }

    public String getName() {
        return name;
    }
}


