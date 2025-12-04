package PetSim.Observer.MoodStates;

import PetSim.Observer.Pet;

public class SadState implements MoodState {
    public void onFeed(Pet pet) {
        if (pet.getObjective() >= 10)
            pet.setMood(new HappyState());
    }

    public void onPlay(Pet pet) {
        if (pet.getObjective() >= 10)
            pet.setMood(new HappyState());
    }

    public void onRest(Pet pet) {
        if (pet.getObjective() >= 10)
            pet.setMood(new HappyState());
    }

    public String getName() {
        return "Sad";
    }
}

