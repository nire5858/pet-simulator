package PetSim.Observer;


import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.SadState;
import java.io.*;

public class PetSaveLoad {
    public static void save(Pet pet) throws IOException {
        try (PrintWriter out = new PrintWriter("pet.txt")) {
            out.println(pet.getType());
            out.println(pet.getHunger());
            out.println(pet.getEnergy());
            out.println(pet.getHealth());
            out.println(pet.getMoodName());
        }
    }

    public static void load(Pet pet) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("pet.txt"))) {
            String type = in.readLine();
            int hunger = Integer.parseInt(in.readLine());
            int energy = Integer.parseInt(in.readLine());
            int health = Integer.parseInt(in.readLine());
            pet.setStats(hunger, energy, health);

            String mood = in.readLine();

            pet.setType(type);
            pet.setStats(hunger, energy, health);
            pet.setMood(mood.contains("Happy") ? new HappyState() : new SadState());
        }
    }
}
