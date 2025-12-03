package PetSim.Observer;

import PetSim.Observer.Commands.FeedCommand;
import PetSim.Observer.Commands.PlayCommand;
import PetSim.Observer.Commands.RestCommand;

public class GameFacade {
    private Pet pet;

    public GameFacade(String petName) {
        pet = PetFactory.createPet(petName);
        pet.addObserver(new ConsoleUI());
    }

    public void feed() { new FeedCommand(pet).execute(); }
    public void play() { new PlayCommand(pet).execute(); }
    public void rest() { new RestCommand(pet).execute(); }

    public void save() throws Exception {
        PetSaveLoad.save(pet);
    }

    public void load() throws Exception {
        PetSaveLoad.load(pet);
        pet.addObserver(new ConsoleUI());
    }
}
