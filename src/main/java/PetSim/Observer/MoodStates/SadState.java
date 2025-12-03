package PetSim.Observer.MoodStates;

import PetSim.Observer.Pet;

public class SadState implements MoodState {
    public void onFeed(Pet pet) {
        pet.setMood(new HappyState());
    }

    public void onPlay(Pet pet) {
        pet.setMood(new HappyState());
    }

    public String getName() {
        return "Sad 😢";
    }
}

