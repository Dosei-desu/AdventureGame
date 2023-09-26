import java.util.Scanner;

public class Adventure {
    private Room playerLocation;
    private RoomLayout roomLayout;

    public Adventure() {
        roomLayout = new RoomLayout();
        roomLayout.buildMap();
        playerLocation = roomLayout.starterRoom();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.print("""
                Welcome aboard the Discovery Vessel 'Hildebrand'
                """);
        do {
            //martin foreslår at vi har en dybere beskrivelse med Look() vi kan fjerne beskrivelsen far introbeskeden
            //vi burde lavet noget sådan så hvis man bevæger sig East i airlocken, så dør man
            System.out.printf("""
                You are currently in %s
                """, playerLocation.getName());

            if(playerLocation.getName().equals("Outer Space")){
                System.out.println("You have ejected yourself into outer space, where you blew up and died from the vacuum" +
                        "\nof outer space! You are the imposter!?");
                System.exit(-1);
            }

            choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "go north", "north", "n" -> playerLocation = moveNorth(playerLocation);
                case "go south", "south", "s" -> playerLocation = moveSouth(playerLocation);
                case "go east", "east", "e" -> playerLocation = moveEast(playerLocation);
                case "go west", "west", "w" -> playerLocation = moveWest(playerLocation);
                case "look" -> look();
                case "help" -> help();
                case "exit" -> exit();
                //denne type switch case, hedder "Enhanced Switch" pga. "->"
            }


        } while (true);
    }

    private void help(){
        //vi skal bruge en hjælpe besked der beskriver commands
        System.out.print("""
                - You can move in the cardinal direction (North, East, South, West) by typing "Go direction" or just "Direction".
                - "Look" allows you to see more in-depth information about the room you are currently in.
                - "Exit" makes you commit suicide by leaping from the airlock. Why would you do that?
                """);
    }

    private void exit() { //i stedet for public, kan vi gøre den private til klassen, da kun klassen skal tilgå den
        System.out.println("You have taken the easy way out and shunted yourself out the airlock.");
        System.exit(1);
    }

    private void look() { //look metode til at se hvilket rum man er i og dets beskrivelse
        System.out.printf("""
                %s : %s
                """, playerLocation.getName(), playerLocation.getDescription());
    }

    private Room moveNorth(Room room) {
        if (room.getNeighbourNorth() != null) {
            return room.getNeighbourNorth();
        } else {
            System.out.println("You cannot move that way!");
            return room;
        }
    }

    private Room moveSouth(Room room) {
        if (room.getNeighbourSouth() != null) {
            return room.getNeighbourSouth();
        } else {
            System.out.println("You cannot move that way!");
            return room;
        }
    }

    private Room moveWest(Room room) {
        if (room.getNeighbourWest() != null) {
            return room.getNeighbourWest();
        } else {
            System.out.println("You cannot move that way!");
            return room;
        }
    }

    private Room moveEast(Room room) {
        if (room.getNeighbourEast() != null) {
            return room.getNeighbourEast();
        } else {
            System.out.println("You cannot move that way!");
            return room;
        }
    }
}
