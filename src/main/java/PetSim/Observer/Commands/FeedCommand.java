package PetSim.Observer.Commands;

import PetSim.Observer.Pet;

public class FeedCommand implements Command {
    private Pet pet;

    public FeedCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.feed();
    }
}

