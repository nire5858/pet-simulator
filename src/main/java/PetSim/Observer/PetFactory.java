package PetSim.Observer;

import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.MoodState;
import PetSim.Observer.MoodStates.SadState;

public class PetFactory {
    public static Pet createPet(String name, String type) {
        return new Pet(name,type, new SadState());
    }
}
