package PetSim.Observer.MoodStates;

import PetSim.Observer.Pet;

public interface MoodState {
    void onFeed(Pet pet);
    void onPlay(Pet pet);
    String getName();
}
