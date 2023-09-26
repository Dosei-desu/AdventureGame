import java.util.Scanner;

public class Adventure {
    private Room playerLocation;
    private RoomLayout roomLayout;
    private boolean newRoom;

    public Adventure() {
        roomLayout = new RoomLayout();
        roomLayout.buildMap();
        playerLocation = roomLayout.starterRoom();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        newRoom = true;
        System.out.print("""
                Welcome aboard the Discovery Vessel 'Hildebrand'.
                """);
        do {
            //checks if it is a newroom, if it is the same room, it will not print the room name again
            if (newRoom) {
                System.out.printf("""
                        You are currently in %s
                        """, playerLocation.getName());
            }
            newRoom = false; //this is only set to true if the player successfully moves to a new room

            //if player ejects themselves into outer space (hint: they die)
            if (playerLocation.getName().equals("Outer Space")) {
                System.out.println("You have ejected yourself into outer space. You blew up and died from the vacuum!" +
                        Colours.RED + "\nYou were not the imposter!" + Colours.RESET);
                System.exit(6);
            }

            //this is where the player inputs their command (a wrong command will trigger default response)
            choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                //movement
                case "go north", "north", "n" -> playerLocation = moveNorth(playerLocation);
                case "go south", "south", "s" -> playerLocation = moveSouth(playerLocation);
                case "go east", "east", "e" -> playerLocation = moveEast(playerLocation);
                case "go west", "west", "w" -> playerLocation = moveWest(playerLocation);
                //actions
                case "look", "l" -> look();
                case "help", "h" -> help();
                case "exit" -> exit(); //aka diving head-first out the airlock
                //special actions
                case "captain delaine suxx!", "delaine suxx", "captain suxx" -> passphraseToRoom14();
                //test methods for unlocking and lighting-up rooms
                case "skeleton key" -> skeletonKey();
                case "lantern bob" -> magicLanternCalledBob();
                //default
                default -> System.out.println(Colours.RED + "Invalid Command!" + Colours.RESET);
                //default is something useful to have a Switch Case, since it is a default response if none of the
                //other options are chosen, in this case it is simply a service message to inform the user of a bad input
            }


        } while (true);
    }

    //help provides a list of instructions and hints
    private void help() {
        System.out.print("""
                - You can move in the cardinal direction (North, East, South, West) by typing "Go direction" or just "Direction".
                - "Look" allows you to see more in-depth information about the room you are currently in.
                - "Exit" makes you commit suicide by leaping from the airlock. Why would you do that?
                - Locked rooms require specific keys.
                - Dark rooms require a flashlight.
                """);
    }

    //exits the Adventure by quite literally throwing yourself out the airlock
    private void exit() {
        System.out.println(Colours.RED + "You have taken the easy way out and shunted yourself out the airlock." + Colours.RESET);
        System.exit(1);
    }

    //allows you to see the description of a room
    private void look() {
        if (playerLocation.isLitUp()) {
            System.out.printf("""
                    %s
                    """, playerLocation.getDescription());
        } else { //unless it is a dark room (note that you can still navigate dark rooms, but it may be fatal later on)
            System.out.println(Colours.RED+"It is too dark to see anything."+Colours.RESET);
        }
    }

    private Room moveNorth(Room room) {
        if (room.getNeighbourNorth() != null) {
            if (room.getNeighbourNorth().isLocked()) {
                System.out.println(Colours.RED+"The door is locked!"+Colours.RESET);
                return room;
            }
            newRoom = true;
            return room.getNeighbourNorth();
        } else {
            System.out.println(Colours.RED+"You cannot move that way!"+Colours.RESET);
            return room;
        }
    }

    private Room moveSouth(Room room) {
        if (room.getNeighbourSouth() != null) {
            if (room.getNeighbourSouth().isLocked()) {
                System.out.println(Colours.RED+"The door is locked!"+Colours.RESET);
                return room;
            }
            newRoom = true;
            return room.getNeighbourSouth();
        } else {
            System.out.println(Colours.RED+"You cannot move that way!"+Colours.RESET);
            return room;
        }
    }

    private Room moveWest(Room room) {
        if (room.getNeighbourWest() != null) {
            if (room.getNeighbourWest().isLocked()) {
                System.out.println(Colours.RED+"The door is locked!"+Colours.RESET);
                return room;
            }
            newRoom = true;
            return room.getNeighbourWest();
        } else {
            System.out.println(Colours.RED+"You cannot move that way!"+Colours.RESET);
            return room;
        }
    }

    private Room moveEast(Room room) {
        if (room.getNeighbourEast() != null) {
            if (room.getNeighbourEast().isLocked()) {
                System.out.println(Colours.RED+"The door is locked!"+Colours.RESET);
                return room;
            }
            newRoom = true;
            return room.getNeighbourEast();
        } else {
            System.out.println(Colours.RED+"You cannot move that way!"+Colours.RESET);
            return room;
        }
    }

    private void passphraseToRoom14() {
        if(playerLocation.getNeighbourEast() != null) {
            if (playerLocation.getNeighbourEast().getName().equals("Engine Room Vestibule")) {
                System.out.println("A " + Colours.BLUE + "beep" + Colours.RESET + " sounds from the door. " +
                        "Then it says, in a robotic voice:\n" + Colours.BLUE + "\"Pass-phrase Correct!\"" + Colours.RESET);
                playerLocation.getNeighbourEast().setLocked(false);
            }
        }
    }

    private void skeletonKey() {
        System.out.println(Colours.PURPLE_BOLD+"You used the Skeleton Key to open all nearby locked doors!"+Colours.RESET);
        if (playerLocation.getNeighbourNorth() != null) {
            playerLocation.getNeighbourNorth().setLocked(false);
        }
        if (playerLocation.getNeighbourSouth() != null) {
            playerLocation.getNeighbourSouth().setLocked(false);
        }
        if (playerLocation.getNeighbourEast() != null) {
            playerLocation.getNeighbourEast().setLocked(false);
        }
        if (playerLocation.getNeighbourWest() != null) {
            playerLocation.getNeighbourWest().setLocked(false);
        }
    }

    private void magicLanternCalledBob() {
        System.out.println(Colours.PURPLE_BOLD+"You cast a magic spell to summon a floating ethereal " +
                            "lantern inexplicably named Bob"+Colours.RESET);
        playerLocation.setLitUp(true);
    }
}
