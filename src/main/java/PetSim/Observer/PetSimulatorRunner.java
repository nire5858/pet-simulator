package PetSim.Observer;

import java.util.Scanner;
import java.util.logging.Logger;

public class PetSimulatorRunner {

    private static final Logger logger = Logger.getLogger(PetSimulatorRunner.class.getName());

    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        logger.info("Welcome to Virtual Pet Game!");
        logger.info("Enter your pet's name: ");
        String petName = scanner.nextLine().trim();

        logger.info("Choose a pet type: cat, dog, bird, fish, hamster");
        String type;

        while (true) {
            type = scanner.nextLine().trim().toLowerCase();
            if (type.matches("cat|dog|bird|fish|hamster")) break;
            logger.warning("Invalid type. Choose: cat, dog, bird, fish, hamster");
        }

        GameFacade game = new GameFacade(petName, type);

        logger.info("\n--- Pet Simulator Started ---");
        game.showUI();

        while (true) {

            if (!game.isAlive()) {
                logger.info("Game ended.");
                return;
            }

            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "feed" -> {
                    game.feed();
                    logger.info("Fed " + game.getPetName() +".\n");
                }
                case "play" -> {
                    game.play();
                    logger.info("Played with " + game.getPetName() +".\n");
                }
                case "rest" -> {
                    game.rest();
                    logger.info(game.getPetName() + " is rested.\n");
                }
                case "save" -> {
                    game.save();
                    logger.info("Game saved.");
                }
                case "load" -> {
                    game.load();
                    logger.info("Game loaded.\n");
                }
                case "quit" -> {
                    logger.info("Goodbye!");
                    return;
                }
                default -> logger.warning("Unknown command.");
            }
        }
    }
}