package PetSim;

import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.SadState;
import PetSim.Observer.Pet;
import PetSim.Observer.PetSaveLoad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetPersistenceTest {

    @Test
    void saveAndLoadRestoreStatsAndMood() throws Exception {
        Pet original = new Pet("Mochi", "cat", new SadState());

        original.feed();
        original.play();

        original.setMood(new HappyState());

        PetSaveLoad.save(original);

        Pet reloaded = new Pet("Mochi", "cat", new SadState());
        PetSaveLoad.load(reloaded);

        assertEquals(original.getHunger(), reloaded.getHunger());
        assertEquals(original.getEnergy(), reloaded.getEnergy());
        assertEquals(original.getHealth(), reloaded.getHealth());
        assertEquals(original.getMoodName(), reloaded.getMoodName());
    }
}
