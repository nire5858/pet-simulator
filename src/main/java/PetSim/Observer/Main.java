package PetSim.Observer;

public class Main {
    public static void main(String[] args) throws Exception {
        GameFacade game = new GameFacade("Mochi");

        game.feed();
        game.play();
        game.save();
        game.load();
    }
}
