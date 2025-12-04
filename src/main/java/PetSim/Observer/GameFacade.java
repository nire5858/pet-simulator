package PetSim.Observer;

import PetSim.Observer.Commands.FeedCommand;
import PetSim.Observer.Commands.PlayCommand;
import PetSim.Observer.Commands.RestCommand;

public class GameFacade {
    private Pet pet;

    public GameFacade(String petName, String petType) {
        pet = PetFactory.createPet(petName, petType);
        pet.addObserver(new ConsoleUI());
    }
    public boolean isAlive() {
        return pet.isAlive();
    }
    public String getPetName() {return pet.getName();}

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
    public void showUI() {
        pet.showInitialUI();
    }
}
