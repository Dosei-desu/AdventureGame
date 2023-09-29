import java.util.Scanner;

public class UserInterface {
    private boolean newRoom;
    private Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
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
                        """+Colours.RESET, adventure.getPlayerLocation().getName());
            }
            newRoom = false; //this is only set to true if the player successfully moves to a new room

            //if player ejects themselves into outer space (hint: they die)
            if (adventure.getPlayerLocation().getName().equals("Outer Space")) {
                System.out.println("You have ejected yourself into outer space. You blew up and died from the vacuum!" +
                        Colours.RED + "\nYou were not the imposter!" + Colours.RESET);
                System.exit(6);
            }

            //this is where the player inputs their command (a wrong command will trigger default response)
            System.out.print(">");
            choice = scanner.nextLine();

            //test to see if useItem works
            String[] stringArray = choice.split(" ");
            if (stringArray[0].equalsIgnoreCase("use")) {
                useItem(choice);
            } else {
                //enhanced switch case
                switch (choice.toLowerCase()) {
                    //movement
                    case "go north", "north", "go n", "n" -> {
                        //nested switch case to handle several scenarios (can move | cant move | locked room)
                        switch (adventure.moveNorth()) {
                            case 0 -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case 1 -> {
                                newRoom = true;
                            }
                            case 2 -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go south", "south", "go s", "s" -> {
                        switch (adventure.moveSouth()) {
                            case 0 -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case 1 -> {
                                newRoom = true;
                            }
                            case 2 -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go east", "east", "go e", "e" -> {
                        switch (adventure.moveEast()) {
                            case 0 -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case 1 -> {
                                newRoom = true;
                            }
                            case 2 -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go west", "west", "go w", "w" -> {
                        switch (adventure.moveWest()) {
                            case 0 -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case 1 -> {
                                newRoom = true;
                            }
                            case 2 -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
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
        if (adventure.getPlayerLocation().isLitUp()) {
            System.out.printf(Colours.GREEN_BOLD+"""
                    %s
                    """+Colours.RESET, adventure.getPlayerLocation().getDescription());
        } else { //unless it is a dark room (note that you can still navigate dark rooms, but it may be fatal later on)
            System.out.println(Colours.RED + "It is too dark to see anything." + Colours.RESET);
        }
    }

    private void passphraseToRoom14() {
        if (adventure.getPlayerLocation().getNeighbourEast() != null) {
            if (adventure.getPlayerLocation().getNeighbourEast().getName().equals("Engine Room Vestibule")) {
                System.out.println("A " + Colours.BLUE + "beep" + Colours.RESET + " sounds from the door. " +
                        "Then it says, in a robotic voice:\n" + Colours.BLUE + "\"Pass-phrase Correct!\"" + Colours.RESET);
                adventure.getPlayerLocation().getNeighbourEast().setLocked(false);
            }
        }
    }

    //consider how you want to make this work, because i personally don't know
    private void teleportRoomXToRoomX(String input) {
        if (input.contains("Umbrella")) {
            if (adventure.getPlayerLocation().getName().equals("East Airlock")){
                System.out.println("The teleporter turns on and the room around you changes.");

            }
        }
    }

    private void unlockRoom(String input) {
        if (input.contains("unlock n")) {
            if (adventure.getPlayerLocation().getNeighbourNorth() != null &&
                    adventure.getPlayerLocation().getNeighbourNorth().isLocked()) {
                adventure.getPlayerLocation().getNeighbourNorth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+adventure.getPlayerLocation().getNeighbourNorth().getName()+
                        " unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock s")) {
            if (adventure.getPlayerLocation().getNeighbourSouth() != null &&
                    adventure.getPlayerLocation().getNeighbourSouth().isLocked()) {
                adventure.getPlayerLocation().getNeighbourSouth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+adventure.getPlayerLocation().getNeighbourSouth().getName()+
                        " unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock e")) {
            if (adventure.getPlayerLocation().getNeighbourEast() != null &&
                    adventure.getPlayerLocation().getNeighbourEast().isLocked()) {
                adventure.getPlayerLocation().getNeighbourEast().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+adventure.getPlayerLocation().getNeighbourEast().getName()+
                        " unlocked!"+Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock w")) {
            if (adventure.getPlayerLocation().getNeighbourWest() != null &&
                    adventure.getPlayerLocation().getNeighbourWest().isLocked()) {
                adventure.getPlayerLocation().getNeighbourWest().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD+adventure.getPlayerLocation().getNeighbourWest().getName()+
                        " unlocked!"+Colours.RESET);
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
        if (adventure.getPlayerLocation().getNeighbourNorth() != null) {
            adventure.getPlayerLocation().getNeighbourNorth().setLocked(false);
        }
        if (adventure.getPlayerLocation().getNeighbourSouth() != null) {
            adventure.getPlayerLocation().getNeighbourSouth().setLocked(false);
        }
        if (adventure.getPlayerLocation().getNeighbourEast() != null) {
            adventure.getPlayerLocation().getNeighbourEast().setLocked(false);
        }
        if (adventure.getPlayerLocation().getNeighbourWest() != null) {
            adventure.getPlayerLocation().getNeighbourWest().setLocked(false);
        }
    }

    private void magicLanternCalledBob() {
        System.out.println(Colours.PURPLE_BOLD + "You cast a magic spell to summon a floating ethereal " +
                "lantern inexplicably named Bob" + Colours.RESET);
        adventure.getPlayerLocation().setLitUp(true);
    }
}
