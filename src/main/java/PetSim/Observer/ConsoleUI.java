package PetSim.Observer;

public class ConsoleUI implements PetObserver {
    public void update(Pet pet) {
        System.out.println("+--------------------------+");
        System.out.println(" Virtual Pet Game");
        System.out.println("+--------------------------+");

        System.out.println(getAsciiArt(pet.getType()));

        System.out.println(pet.getStatus());
        System.out.println("[ Feed ] [ Play ] [ Rest ]");
        System.out.println("[ Save ] [ Load ]");
        System.out.println("+--------------------------+");
    }

    private String getAsciiArt(String type) {
        return switch (type.toLowerCase()) {
            case "cat" -> """
                     /\\_/\\
                    ( o.o )
                     > ^ <
                    """;

            case "dog" -> """
                      /‾‾‾‾‾‾‾\\
                     (  •ᴥ•  )
                      \\_____/
                    """;

            case "bird" -> """
                      \\  /
                      (•>
                      / )
                     """;

            case "fish" -> """
                      ><(((º>
                    """;

            case "hamster" -> """
                     (\")_(\")
                    (='.'=)
                    (')_(')
                    """;

            default -> "(unknown pet)";
        };
    }
}

