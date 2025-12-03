package PetSim.Observer;

public class ConsoleUI implements PetObserver {
    public void update(Pet pet) {
        System.out.println("+--------------------------+");
        System.out.println(" Virtual Pet Game");
        System.out.println("+--------------------------+");
        System.out.println(pet.getStatus());
        System.out.println("[ Feed ] [ Play ] [ Rest ]");
        System.out.println("[ Save ] [ Load ]");
        System.out.println("+--------------------------+");
    }
}

