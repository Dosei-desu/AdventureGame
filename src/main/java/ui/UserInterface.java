package ui;

import common.Adventure;
import common.EatDTO;
import items.Food;
import items.Item;



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


        System.out.print(Colours.BLUE_BOLD + """
                Welcome aboard the Discovery Vessel 'Hildebrand'.
                """ + Colours.RESET);
        do {
            if(adventure.getPlayerHealth() == 0){
                System.out.println(Colours.RED_BOLD+"You have died!\nGame Over!"+Colours.RESET);
                System.exit(666);
            }
            //checks if it is a newroom, if it is the same room, it will not print the room name again
            if (newRoom) {
                System.out.printf(Colours.BLUE_BOLD + """
                        You are currently in %s
                        """ + Colours.RESET, adventure.getPlayerLocation().getName());
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
            if (stringArray[0].equalsIgnoreCase("eat")) {
                eatItem(stringArray);
            } else if (stringArray[0].equalsIgnoreCase("use")) {
                useItem(stringArray);
            } else if (stringArray[0].equalsIgnoreCase("take")) {
                takeItem(stringArray);
            } else if (stringArray[0].equalsIgnoreCase("drop")) {
                dropItem(stringArray);
            } else if (stringArray[0].equalsIgnoreCase("inspect")) {
                inspectItem(stringArray);
            } else {
                //enhanced switch case
                switch (choice.toLowerCase()) {
                    //movement
                    case "go north", "north", "go n", "n" -> {
                        //nested switch case to handle several scenarios (can move | cant move | locked room)
                        switch (adventure.moveNorth()) {
                            case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case CAN_MOVE -> newRoom = true;
                            case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go south", "south", "go s", "s" -> {
                        switch (adventure.moveSouth()) {
                            case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case CAN_MOVE -> newRoom = true;
                            case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go east", "east", "go e", "e" -> {
                        switch (adventure.moveEast()) {
                            case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case CAN_MOVE -> newRoom = true;
                            case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    case "go west", "west", "go w", "w" -> {
                        switch (adventure.moveWest()) {
                            case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                            case CAN_MOVE -> newRoom = true;
                            case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                        }
                    }
                    //actions
                    case "look", "l" -> look();
                    case "help", "h" -> help();
                    case "inventory", "inv", "i" -> inventory();
                    case "status" -> status();
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
        System.out.print(Colours.CYAN_BOLD+"""
                - You can move in the cardinal direction (North, East, South, West) by typing "Go direction" or just "Direction".
                - "Look" allows you to see more in-depth information about the room you are currently in.
                - "Take ___" to take an item from a room
                - "Drop ___" to discard an item from inventory
                - "Inventory" to view all items in inventory
                - "Use ___" to use an item from inventory
                - "Eat ___" to consume an item from inventory
                - "Inspect ___" to inspect an item from inventory
                - "Status" to view player status, such as health
                - Locked rooms require specific keys.
                - Dark rooms require a flashlight.
                - "Exit" makes you commit self-die by leaping from the airlock. Why would you do that?
                """+Colours.RESET);
    }

    //exits the common.Adventure by quite literally throwing yourself out the airlock
    private void exit() {
        System.out.println(Colours.RED + "You have taken the easy way out and shunted yourself out the airlock." + Colours.RESET);
        System.exit(1);
    }

    //allows you to see the description of a room
    //TODO make dynamic to show items (and maybe locked rooms)
    private void look() {
        String string = "";
        if (adventure.getPlayerLocation().isLitUp()) {
            string += adventure.getPlayerLocation().getDescription();
            if (!adventure.getPlayerLocation().getRoomItems().isEmpty()) {
                string += "\nItems found in the room:" +
                        "\n------------------------";
                for (Item item : adventure.getPlayerLocation().getRoomItems()) {
                    string += "\n" + item.getName() + ": " + item.getROOM_DESCRIPTION();
                }
                string += "\n------------------------";
            }
            System.out.println(Colours.GREEN_BOLD + string + Colours.RESET);
        } else { //unless it is a dark room (note that you can still navigate dark rooms, but it may be fatal later on)
            System.out.println(Colours.RED + "It is too dark to see anything." + Colours.RESET);
        }
    }

    private void status(){
        String string;
        if(adventure.getPlayerHealth() <= 25){
            string = Colours.RED_BRIGHT + adventure.getPlayerHealth();
        }else if(adventure.getPlayerHealth() <= 74){
            string = Colours.BLUE_BRIGHT + adventure.getPlayerHealth();
        }else{
            string = Colours.GREEN_BRIGHT + adventure.getPlayerHealth();
        }
        System.out.println(Colours.CYAN + "Your health is at " + string + Colours.RESET);
    }

    private void inventory() {
        String string = "----------------------\n";
        string += adventure.getPlayer().viewInventory();
        if (string.equals("----------------------\n") || string.equals("----------------------\n----------------------")) {
            System.out.println(Colours.RED + "Inventory is empty!" + Colours.RESET);
        } else {
            System.out.println(Colours.CYAN + string + "----------------------" + Colours.RESET);
        }
    }

    private void inspectItem(String[] stringArray) {
        String itemDescription = "";
        if (stringArray.length > 1) {
            String itemName = "";
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();

            for (Item item : adventure.getPlayerInventory()) {
                if (item.getName().toLowerCase().contains(itemName.toLowerCase())) {
                    itemDescription += item.getItemBrief() + "\n" + Colours.CYAN + item.getDescription() + "\n";
                }
            }
            if (itemDescription.equals("")) {
                System.out.println(Colours.RED + "Item not found!" + Colours.RESET);
            } else {
                System.out.print(Colours.BLUE + itemDescription + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void passphraseToRoom14() {
        if (adventure.getRoomEast() != null) {
            if (adventure.getRoomEast().getName().equals("Engine common.Room Vestibule")) {
                System.out.println(Colours.GREEN_BOLD + "A " + Colours.BLUE + "beep" + Colours.GREEN_BOLD  +
                        " sounds from the door. Then it says, in a robotic voice:\n" + Colours.BLUE +
                        "\"Pass-phrase Correct!\"" + Colours.RESET);
                adventure.getRoomEast().setLocked(false);
            }
        }
    }

    //TODO implement keycard objects as keys for doors, disabling the unlock command unless you have the correct key
    private void unlockRoom(String input) {
        if (input.contains("unlock n")) {
            if (adventure.getRoomNorth() != null &&
                    adventure.getRoomNorth().isLocked()) {
                adventure.getRoomNorth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD + adventure.getRoomNorth().getName() +
                        " unlocked!" + Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock s")) {
            if (adventure.getRoomSouth() != null &&
                    adventure.getRoomSouth().isLocked()) {
                adventure.getRoomSouth().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD + adventure.getRoomSouth().getName() +
                        " unlocked!" + Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock e")) {
            if (adventure.getRoomEast() != null &&
                    adventure.getRoomEast().isLocked()) {
                adventure.getRoomEast().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD + adventure.getRoomEast().getName() +
                        " unlocked!" + Colours.RESET);
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock w")) {
            if (adventure.getRoomWest() != null &&
                    adventure.getRoomWest().isLocked()) {
                adventure.getRoomWest().setLocked(false);
                System.out.println(Colours.PURPLE_BOLD + adventure.getRoomWest().getName() +
                        " unlocked!" + Colours.RESET);
            } else {
                invalidCommand();
            }
        } else {
            invalidCommand();
        }
    }

    private void eatItem(String[] stringArray) {
        if (stringArray.length > 1) {
            String itemName = "";
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();

            EatDTO eatDTO = adventure.eatItem(itemName); //returns a DTO (Data Transfer Object) which contains
            //the ReturnEatMessage Enum and the FoodHealValue integer

            switch (eatDTO.getReturnEatMessage()) {
                case CANT_EAT -> System.out.println(Colours.RED + "You cannot consume that!" + Colours.RESET);
                case EAT_JUNK -> System.out.println(Colours.PURPLE_BOLD + "Nom nom nom." + Colours.RESET);
                case EAT_MAP -> System.out.println(Colours.PURPLE_BOLD + "You eat the only map of the spacecraft.\n" +
                        Colours.RED + "That was pretty stupid."+ Colours.RESET);
                case EAT_HEAL_FOOD -> {
                    System.out.println(Colours.GREEN + "You are healed " + eatDTO.getFoodHealValue() +
                            "!" + Colours.CYAN);
                    status();
                }
                case EAT_DAMAGE_FOOD -> {
                    System.out.println(Colours.RED + "You are damaged " + eatDTO.getFoodHealValue() +
                            "!" + Colours.CYAN);
                    status();
                }
            }
        } else {
            invalidCommand();
        }
    }

    private void useItem(String[] stringArray) {
        if (stringArray.length > 1) { //checks if the stringArray has more than 1 index point, to avoid arrayIndexOutOfBounds
            String itemName = "";
            //takes everything from the stringArray (except the first index point and adds it to 'itemName', since index0 is
            //the command prompt (in this case "use")
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();
            Item item = adventure.findItem(itemName); //search function to find the item based on inputted name
            if (item != null) {
                //if the item used is food, the item is pushed to the "eatItem()" method
                if(item instanceof Food){
                    eatItem(stringArray);
                }
                switch (stringArray[1].toLowerCase()) {
                    //unique scenario
                    case "flashlight" -> {
                        System.out.println(Colours.PURPLE_BOLD + "Using " + item.getName() + Colours.RESET);
                        adventure.getPlayerLocation().setLitUp(true);
                    }
                    case "map" -> System.out.println(item.getDescription());
                }
            } else {
                System.out.println(Colours.RED + "Item doesn't exist!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void takeItem(String[] stringArray) {
        if (stringArray.length > 1) {
            String itemName = "";
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();
            switch (adventure.addItem(itemName)) {
                case 0 -> System.out.println(Colours.RED + "Item already acquired!" + Colours.RESET); //this doesn't seem to work
                case 1 -> System.out.println(Colours.PURPLE_BOLD + "Item acquired!" + Colours.RESET);
                case 2 -> System.out.println(Colours.RED + "Item doesn't exist!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void dropItem(String[] stringArray) {
        if (stringArray.length > 1) {
            String itemName = "";
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();
            switch (adventure.dropItem(itemName)) {
                case 0 -> System.out.println(Colours.RED + "Item not in inventory!" + Colours.RESET);
                case 1 -> System.out.println(Colours.PURPLE_BOLD + "Item discard!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void invalidCommand() {
        System.out.println(Colours.RED + "Invalid Command!" + Colours.RESET);
    }

    private void skeletonKey() {
        System.out.println(Colours.PURPLE_BOLD + "You used the Skeleton Key to open all nearby locked doors!" + Colours.RESET);
        if (adventure.getRoomNorth() != null) {
            adventure.getRoomNorth().setLocked(false);
        }
        if (adventure.getRoomSouth() != null) {
            adventure.getRoomSouth().setLocked(false);
        }
        if (adventure.getRoomEast() != null) {
            adventure.getRoomEast().setLocked(false);
        }
        if (adventure.getRoomWest() != null) {
            adventure.getRoomWest().setLocked(false);
        }
    }

    private void magicLanternCalledBob() {
        System.out.println(Colours.PURPLE_BOLD + "You cast a magic spell to summon a floating ethereal " +
                "lantern inexplicably named Bob" + Colours.RESET);
        adventure.getPlayerLocation().setLitUp(true);
    }
}
