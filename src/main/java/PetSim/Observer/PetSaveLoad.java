package PetSim.Observer;


import PetSim.Observer.MoodStates.HappyState;
import PetSim.Observer.MoodStates.SadState;

import java.io.*;

public class PetSaveLoad {
    public static void save(Pet pet) throws IOException {
        try (PrintWriter out = new PrintWriter("pet.txt")) {
            out.println(pet.getHunger());
            out.println(pet.getEnergy());
            out.println(pet.getHealth());
            out.println(pet.getMoodName());
        }
    }

    public static void load(Pet pet) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("pet.txt"))) {
            int h = Integer.parseInt(in.readLine());
            int e = Integer.parseInt(in.readLine());
            int he = Integer.parseInt(in.readLine());
            String mood = in.readLine();

            pet.setStats(h, e, he);
            pet.setMood(mood.contains("Happy") ? new HappyState() : new SadState());
        }
    }
}
