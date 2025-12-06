package PetSim;

import PetSim.Observer.MoodStates.SadState;
import PetSim.Observer.Pet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetMoodTest {

    @Test
    void petBecomesHappyAfterEnoughCare() {
        Pet pet = new Pet("Mochi", "cat", new SadState());

        for (int i = 0; i < 3; i++) {
            pet.feed();
        }
        for (int i = 0; i < 3; i++) {
            pet.play();
        }
        pet.rest();

        assertEquals("Happy", pet.getMoodName());
    }
}

