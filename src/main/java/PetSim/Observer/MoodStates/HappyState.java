package PetSim.Observer.MoodStates;

import PetSim.Observer.Pet;

public class HappyState implements MoodState {
    public void onFeed(Pet pet) {
        // stays happy
    }

    public void onPlay(Pet pet) {
        // stays happy
    }

    public String getName() {
        return "Happy 😊";
    }
}

