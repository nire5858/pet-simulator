package PetSim.Observer;

import PetSim.Observer.MoodStates.HappyState;

public class PetFactory {
    public static Pet createPet(String name) {
        return new Pet(name, new HappyState());
    }
}
