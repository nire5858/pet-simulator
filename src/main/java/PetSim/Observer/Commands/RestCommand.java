package PetSim.Observer.Commands;

import PetSim.Observer.Pet;

public class RestCommand implements Command {
    private Pet pet;

    public RestCommand(Pet pet) {
        this.pet = pet;
    }

    public void execute() {
        pet.rest();
    }
}
