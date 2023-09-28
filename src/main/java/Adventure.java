import java.util.Scanner;

//what is the point of this class now??
public class Adventure {
    private Room playerLocation;
    private Room previousLocation; //not used currently, but might be useful later
    private Map roomLayout;
    private boolean newRoom;

    public Adventure() {
        roomLayout = new Map();
        roomLayout.buildMap();
        playerLocation = roomLayout.starterRoom();
        previousLocation = playerLocation;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        newRoom = true;
        System.out.print(Colours.BLUE_BOLD+"""
                Welcome aboard the Discovery Vessel 'Hildebrand'.
                """+Colours.RESET);
        do {
            //checks if it is a newroom, if it is the same room, it will not print the room name again
            if (newRoom) {
                System.out.printf(Colours.BLUE_BOLD+"""
                        You are currently in %s
                        """+Colours.RESET, playerLocation.getName());
            }
            newRoom = false; //this is only set to true if the player successfully moves to a new room

            //if player ejects themselves into outer space (hint: they die)
            if (playerLocation.getName().equals("Outer Space")) {
                System.out.println("You have ejected yourself into outer space. You blew up and died from the vacuum!" +
                        Colours.RED + "\nYou were not the imposter!" + Colours.RESET);
                System.exit(6);
            }

            //this is where the player inputs their command (a wrong command will trigger default response)
            System.out.print(">");
            choice = scanner.nextLine();

            //test to see if useItem works
            String[] stringArray = choice.split(" ");
            if (stringArray[0].toLowerCase().equals("use")) {
                useItem(choice);
            } else {
                //enhanced switch case
                switch (choice.toLowerCase()) {
                    //movement
                    case "go north", "north", "go n", "n" -> playerLocation = moveNorth(playerLocation);
                    case "go south", "south", "go s", "s" -> playerLocation = moveSouth(playerLocation);
                    case "go east", "east", "go e", "e" -> playerLocation = moveEast(playerLocation);
                    case "go west", "west", "go w", "w" -> playerLocation = moveWest(playerLocation);
                    //actions
                    case "look", "l" -> look();
                    case "help", "h" -> help();
                    case "exit" -> exit(); //aka diving head-first out the airlock
                    //special actions
                    case "unlock north", "unlock n" -> unlockRoom(choice);
                    case "unlock south", "unlock s" -> unlockRoom(choice);
                    case "unlock east", "unlock e" -> unlockRoom(choice);
                    case "unlock west", "unlock w" -> unlockRoom(choice);
                    case "captain delaine suxx!" -> passphraseToRoom14();
                    //test methods for unlocking and lighting-up rooms
                    case "skeleton key" -> skeletonKey();
                    case "lantern bob" -> magicLanternCalledBob();
                    //default
                    default -> invalidCommand();
                    //default is something useful to have a Switch Case, since it is a default response if none of the
                    //other options are chosen, in this case it is simply a service message to inform the user of a bad input
                }
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
            System.out.printf(Colours.GREEN_BOLD+"""
                    %s
                    """+Colours.RESET, playerLocation.getDescription());
        } else { //unless it is a dark room (note that you can still navigate dark rooms, but it may be fatal later on)
            System.out.println(Colours.RED + "It is too dark to see anything." + Colours.RESET);
        }
    }

    private Room moveNorth(Room room) {
        if (room.getNeighbourNorth() != null) {
            if (room.getNeighbourNorth().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                return room;
            }
            newRoom = true;
            previousLocation = room;
            return room.getNeighbourNorth();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
            return room;
        }
    }

    private Room moveSouth(Room room) {
        if (room.getNeighbourSouth() != null) {
            if (room.getNeighbourSouth().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                return room;
            }
            newRoom = true;
            previousLocation = room;
            return room.getNeighbourSouth();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
            return room;
        }
    }

    private Room moveWest(Room room) {
        if (room.getNeighbourWest() != null) {
            if (room.getNeighbourWest().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                return room;
            }
            newRoom = true;
            previousLocation = room;
            return room.getNeighbourWest();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
            return room;
        }
    }

    private Room moveEast(Room room) {
        if (room.getNeighbourEast() != null) {
            if (room.getNeighbourEast().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                return room;
            }
            newRoom = true;
            previousLocation = room;
            return room.getNeighbourEast();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
            return room;
        }
    }

    private void passphraseToRoom14() {
        if (playerLocation.getNeighbourEast() != null) {
            if (playerLocation.getNeighbourEast().getName().equals("Engine Room Vestibule")) {
                System.out.println("A " + Colours.BLUE + "beep" + Colours.RESET + " sounds from the door. " +
                        "Then it says, in a robotic voice:\n" + Colours.BLUE + "\"Pass-phrase Correct!\"" + Colours.RESET);
                playerLocation.getNeighbourEast().setLocked(false);
            }
        }
    }

    private void unlockRoom(String input) {
        if (input.contains("unlock n")) {
            if (playerLocation.getNeighbourNorth() != null && playerLocation.getNeighbourNorth().isLocked()) {
                playerLocation.getNeighbourNorth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+playerLocation.getNeighbourNorth().getName()+" unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock s")) {
            if (playerLocation.getNeighbourSouth() != null && playerLocation.getNeighbourSouth().isLocked()) {
                playerLocation.getNeighbourSouth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+playerLocation.getNeighbourSouth().getName()+" unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock e")) {
            if (playerLocation.getNeighbourEast() != null && playerLocation.getNeighbourEast().isLocked()) {
                playerLocation.getNeighbourEast().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+playerLocation.getNeighbourEast().getName()+" unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock w")) {
            if (playerLocation.getNeighbourWest() != null && playerLocation.getNeighbourWest().isLocked()) {
                playerLocation.getNeighbourWest().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+playerLocation.getNeighbourWest().getName()+" unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else {
            invalidCommand();
        }
    }

    private void useItem(String input) { //dummy method for now
        String[] stringArray = input.split(" ");
        if (stringArray.length > 1) {
            String itemName = stringArray[1];
            System.out.println(Colours.PURPLE_BOLD+"Using " + itemName+Colours.RESET);
        } else {
            invalidCommand();
        }
    }

    private void invalidCommand() {
        System.out.println(Colours.RED + "Invalid Command!" + Colours.RESET);
    }

    private void skeletonKey() {
        System.out.println(Colours.PURPLE_BOLD + "You used the Skeleton Key to open all nearby locked doors!" + Colours.RESET);
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
        System.out.println(Colours.PURPLE_BOLD + "You cast a magic spell to summon a floating ethereal " +
                "lantern inexplicably named Bob" + Colours.RESET);
        playerLocation.setLitUp(true);
    }
}
