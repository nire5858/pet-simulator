package PetSim.Observer.Commands;

import PetSim.Observer.Pet;

public class PlayCommand implements Command {
    private Pet pet;

    public PlayCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.play();
    }
}

