package ui;

import common.Adventure;
import common.EatDTO;
import common.Enemy;
import common.Trap;
import items.*;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO
 * add enemies to rooms
 * finish room descriptions
 * add more items and food to rooms
 * fix attack message appearing after death (only works with non-target attack)
 * fix switch case handling inputs from scanner, since right now it's a mess
 * makes it so a room returns to darkness if it was dark when you entered
 * Finally:
 * Make UML Class Diagrams that dont look like crap
 * Make activity diagram of attack method
 */


public class UserInterface {
    private boolean newRoom;
    private Adventure adventure;
    private Scanner scanner;
    private boolean enemyHasAttacked;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void run() {
        scanner = new Scanner(System.in);
        String choice;
        newRoom = true;

        welcome();

        do {
            //if player ejects themselves into outer space (hint: they die)
            if (adventure.getPlayerLocation().getName().equals("Outer Space")) {
                System.out.println(Colours.RED + "You have ejected yourself into outer space. You blew up and died from the vacuum!" +
                        "\nYou were not the imposter!" + Colours.RESET);
                adventure.getPlayer().takeDamage(999);
            }
            if (adventure.getPlayerHealth() == 0) { //You died
                playerDeath();
            }
            enemyHasAttacked = false;
            //checks if it is a newroom, if it is the same room, it will not print the room name again
            if (newRoom) {
                System.out.printf(Colours.BLUE_BOLD + """
                        You are currently in %s
                        """ + Colours.RESET, adventure.getPlayerLocation().getName());
            }
            newRoom = false; //this is only set to true if the player successfully moves to a new room

            //this is where the player inputs their command (a wrong command will trigger default response)
            System.out.print(">");
            choice = scanner.nextLine();

            //actions that require a unique input
            String[] stringArray = choice.split(" ");
            boolean choicePicked = false; //very jank way to handle default "invalidCommand" in the following switch case
            //TODO fix this mess so we dont need two switch cases to handle the same user input
            switch (stringArray[0]) {
                case "eat" -> {
                    eatItem(stringArray);
                    roomEnemiesAttack(); //doing this action will make the enemy attack
                    choicePicked = true;
                }
                case "use" -> {
                    useItem(stringArray);
                    roomEnemiesAttack();
                    choicePicked = true;
                }
                case "take" -> {
                    takeItem(stringArray);
                    roomEnemiesAttack();
                    choicePicked = true;
                }
                case "drop" -> {
                    dropItem(stringArray);
                    roomEnemiesAttack();
                    choicePicked = true;
                }
                case "inspect" -> {
                    inspectItem(stringArray);
                    choicePicked = true;
                }
                case "equip" -> {
                    equipItem(stringArray);
                    roomEnemiesAttack();
                    choicePicked = true;
                }
                case "attack" -> {
                    attackEnemy(stringArray);
                    roomEnemiesAttack();
                    choicePicked = true;
                }
            }
            //enhanced switch case
            switch (choice.toLowerCase()) {
                //movement
                case "go north", "north", "go n", "n" -> {
                    roomEnemiesAttack();
                    roomTrapsGoOff();
                    //nested switch case to handle several scenarios (can move | cant move | locked room)
                    switch (adventure.moveNorth()) {
                        case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                        case CAN_MOVE -> newRoom = true;
                        case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                    }
                }
                case "go south", "south", "go s", "s" -> {
                    roomEnemiesAttack();
                    roomTrapsGoOff();
                    switch (adventure.moveSouth()) {
                        case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                        case CAN_MOVE -> newRoom = true;
                        case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                    }
                }
                case "go east", "east", "go e", "e" -> {
                    roomEnemiesAttack();
                    roomTrapsGoOff();
                    switch (adventure.moveEast()) {
                        case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                        case CAN_MOVE -> newRoom = true;
                        case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                    }
                }
                case "go west", "west", "go w", "w" -> {
                    roomEnemiesAttack();
                    roomTrapsGoOff();
                    switch (adventure.moveWest()) {
                        case DOOR_LOCKED -> System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
                        case CAN_MOVE -> newRoom = true;
                        case CANT_MOVE -> System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
                    }
                }
                //actions
                case "look", "l" -> look();
                case "look closer", "lc" -> lookCloser();
                case "help", "h" -> help();
                case "inventory", "inv", "i" -> inventory();
                case "status" -> status();
                case "exit" -> exit(); //aka diving head-first out the airlock
                //special actions
                case "unlock n", "unlock north" -> unlockRoom(choice);
                case "unlock s", "unlock south" -> unlockRoom(choice);
                case "unlock e", "unlock east" -> unlockRoom(choice);
                case "unlock w", "unlock west" -> unlockRoom(choice);
                case "captain delaine suxx!" -> passphraseToRoom14();
                case "chaotic convergence" -> {
                    adventure.teleport();
                    newRoom = true;
                }
                //test methods for unlocking and lighting-up rooms
                case "skeleton key" -> skeletonKey();
                case "lantern bob" -> magicLanternCalledBob();
                //default
                default -> {
                    if (!choicePicked) {
                        invalidCommand();
                    }
                }
            }
        }
        while (true);
    }

    //help provides a list of instructions and hints
    private void help() {
        System.out.print(Colours.CYAN_BOLD + """
                - You can move in the cardinal direction (North, East, South, West).
                  by typing "Go direction" or just "Direction".
                - "Look" allows you to see more in-depth information about the room you are currently in.
                - "Look Closer" allows you to see further info on certain rooms.
                - "Take ___" to take an item from a room.
                - "Drop ___" to discard an item from inventory.
                - "Inventory" to view all items in inventory.
                - "Use ___" to use an item from inventory.
                - "Eat ___" to consume an item from inventory.
                - "Inspect ___" to inspect an item from inventory.
                - "Equip ___" to equip an item from inventory.
                - "Attack ___" to use equipped weapon to attack a target.
                - "Status" to view player status, such as health.
                - Locked rooms require specific keys.
                - Dark rooms require a flashlight.
                - "Exit" makes you commit self-die by leaping from the airlock. Why would you do that?
                """ + Colours.RESET);
    }

    //exits the common.Adventure by quite literally throwing yourself out the airlock
    private void exit() {
        System.out.println(Colours.RED + "You have taken the easy way out and shunted yourself out the airlock." + Colours.RESET);
        try {
            Thread.sleep(2500); //waits 2.5 seconds before shutting down, so there's time to read message
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(1);
    }

    //allows you to see the description of a room
    //TODO make dynamic to show items (and maybe locked rooms)
    private void look() {
        String string = "";
        if (adventure.getPlayerLocation().isLitUp()) {
            string += adventure.getPlayerLocation().getDescription();
            if (!adventure.getPlayerLocation().getRoomItems().isEmpty()) {
                string += Colours.BLUE +
                        "\nItems found in the room:" +
                        "\n------------------------";
                for (Item item : adventure.getPlayerLocation().getRoomItems()) {
                    string += "\n" + item.getName() + ": " + item.getROOM_DESCRIPTION();
                }
                string += "\n------------------------";
            }
            if (!adventure.getPlayerLocation().getRoomEnemies().isEmpty()) {
                string += Colours.RED +
                        "\nEnemies in the room:" +
                        "\n------------------------";
                for (Enemy enemy : adventure.getPlayerLocation().getRoomEnemies()) {
                    string += "\n" + enemy.getName() + " (" + enemy.getHealth() + "/" + enemy.getMaxHealth() + ")" +
                            " : " + enemy.getDescription();
                }
                string += "\n------------------------";
            }
            System.out.println(Colours.GREEN_BOLD + string + Colours.RESET);
        } else { //unless it is a dark room (note that you can still navigate dark rooms, but it may be fatal later on)
            System.out.println(Colours.RED + "It is too dark to see anything." + Colours.RESET);
        }
    }

    private void lookCloser() {
        switch (adventure.getPlayerLocation().getName()) {
            case "East Airlock" -> System.out.print(Colours.GREEN_BOLD + """
                    Through a porthole in the wall, you can see the dark of space and the spaceship that brought you here
                    disappearing into the vastness of the asteroid field where the Hildebrand has become derelict.
                    """ + Colours.RESET);
            case "West Airlock" -> {
                System.out.print(Colours.GREEN_BOLD + """
                        Through a porthole in the wall, you see an eye. Yes, a giant swirling eye that seems to contain a galaxy
                        within its iris. You take a step back from the porthole and wonder just how big the creature that stares
                        at you really is. A shiver escapes your body and you leave the room.
                        """ + Colours.RESET);
                adventure.moveEast(); //forces player to leave room as a result of looking closer
                newRoom = true;
            }
            case "Vandalised Common Room" -> //unique password to get into Engine Room Vestibule
                    System.out.println(Colours.GREEN_BOLD + "Scrawled above the fridge is the phrase " +
                            Colours.RED_UNDERLINED + "\'Captain Delaine Suxx!\'" + Colours.RESET + Colours.GREEN_BOLD +
                            " It is underscored with red \nlines for some reason." + Colours.RESET);
            case "Experimental R&D Lab" ->
                    System.out.println(Colours.GREEN_BOLD + "As you look closer at the screen, you see a note that says " +
                            Colours.RED_UNDERLINED + "\'Open Sesame!\'" + Colours.RESET + Colours.GREEN_BOLD +
                            " Under it is written "+ Colours.RED_UNDERLINED + "\'Weapons Locker\'" + Colours.RESET +
                            Colours.GREEN_BOLD + "." + Colours.RESET);
            default -> System.out.println(Colours.GREEN_BOLD+"There is nothing more to see here."+Colours.RESET);
        }
    }

    private void status() {
        String string;
        if (adventure.getPlayerHealth() <= 25) {
            string = Colours.RED_BRIGHT + adventure.getPlayerHealth();
        } else if (adventure.getPlayerHealth() <= 74) {
            string = Colours.BLUE_BRIGHT + adventure.getPlayerHealth();
        } else {
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
                    itemDescription += item.getItemBrief();
                    if (item.isEquipped()) {
                        itemDescription += " (Equipped)";
                    }
                    itemDescription += "\n" + Colours.CYAN + item.getDescription() + "\n";
                    if(item instanceof Weapon){
                        itemDescription += Colours.RED_BRIGHT+"Damage: "+((Weapon) item).getDamage()+"\n";
                    }
                    itemDescription += Colours.BLUE + "Number of uses: ";
                    if (item.getNumberOfUses() >= 0) {
                        itemDescription += item.getNumberOfUses() + "\n";
                    } else {
                        itemDescription += "∞\n";
                    }
                    if (item.getNumberOfUses() == 0) {
                        itemDescription += Colours.RED + item.breakStatus() + "\n";
                    }
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
            if (adventure.getRoomEast().getName().equals("Engine Room Vestibule")) {
                System.out.println(Colours.GREEN_BOLD + "A " + Colours.BLUE + "beep" + Colours.GREEN_BOLD +
                        " sounds from the door. Then it says, in a robotic voice:\n" + Colours.BLUE +
                        "\"Pass-phrase Correct!\"" + Colours.RESET);
                adventure.getRoomEast().setLocked(false);
            }
        }
    }

    //TODO implement keycard objects as keys for doors, disabling the unlock command unless you have the correct key
    private void unlockRoom(String input) {
        ArrayList<Item> inventory = adventure.getPlayerInventory();
        boolean canOpen = false;
        if (input.contains("unlock n")) {
            if (adventure.getRoomNorth() != null && adventure.getRoomNorth().isLocked()) {
                for (Item item : inventory) {
                    if (item instanceof Keycard) {
                        if (((Keycard) item).getKeycardRoomName().equalsIgnoreCase(adventure.getRoomNorth().getName())) {
                            canOpen = true;
                        }
                    }
                }
                if (canOpen) {
                    adventure.getRoomNorth().setLocked(false);
                    System.out.println(Colours.PURPLE_BOLD + adventure.getRoomNorth().getName() +
                            " unlocked!" + Colours.RESET);
                } else {
                    invalidCommand();
                }
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock s")) {
            if (adventure.getRoomSouth() != null && adventure.getRoomSouth().isLocked()) {
                for (Item item : inventory) {
                    if (item instanceof Keycard) {
                        if (((Keycard) item).getKeycardRoomName().equalsIgnoreCase(adventure.getRoomSouth().getName())) {
                            canOpen = true;
                        }
                    }
                }
                if (canOpen) {
                    adventure.getRoomSouth().setLocked(false);
                    System.out.println(Colours.PURPLE_BOLD + adventure.getRoomSouth().getName() +
                            " unlocked!" + Colours.RESET);
                } else {
                    invalidCommand();
                }
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock e")) {
            if (adventure.getRoomEast() != null && adventure.getRoomEast().isLocked()) {
                for (Item item : inventory) {
                    if (item instanceof Keycard) {
                        if (((Keycard) item).getKeycardRoomName().equalsIgnoreCase(adventure.getRoomEast().getName())) {
                            canOpen = true;
                        }
                    }
                }
                if (canOpen) {
                    adventure.getRoomEast().setLocked(false);
                    System.out.println(Colours.PURPLE_BOLD + adventure.getRoomEast().getName() +
                            " unlocked!" + Colours.RESET);
                } else {
                    invalidCommand();
                }
            } else {
                invalidCommand();
            }
        } else if (input.contains("unlock w")) {
            if (adventure.getRoomWest() != null && adventure.getRoomWest().isLocked()) {
                for (Item item : inventory) {
                    if (item instanceof Keycard) {
                        if (((Keycard) item).getKeycardRoomName().equalsIgnoreCase(adventure.getRoomWest().getName())) {
                            canOpen = true;
                        }
                    }
                }
                if (canOpen) {
                    adventure.getRoomWest().setLocked(false);
                    System.out.println(Colours.PURPLE_BOLD + adventure.getRoomWest().getName() +
                            " unlocked!" + Colours.RESET);
                } else {
                    invalidCommand();
                }
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
                        Colours.RED + "That was pretty stupid." + Colours.RESET);
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
                if (item instanceof Food) {
                    eatItem(stringArray);
                } else if (item instanceof Weapon) {
                    equipItem(stringArray);
                } else {
                    switch (itemName.toLowerCase()) {
                        //unique scenarios
                        case "flash" -> {
                            if (item.getNumberOfUses() > 0) {
                                System.out.println(Colours.PURPLE_BOLD + "Using " + item.getName() + " to light up the room." + Colours.RESET);
                                adventure.getPlayerLocation().setLitUp(true);
                            } else {
                                System.out.println(Colours.RED + "You broke your " + item.getName() + " because you used it as a " +
                                        "weapon!" + Colours.RESET);
                            }
                        }
                        case "map", "brief" -> System.out.println(item.getDescription());
                        default -> System.out.println(Colours.RED + "Item cannot be used!" + Colours.RESET);
                    }
                }
            } else {
                System.out.println(Colours.RED + "Item doesn't exist!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    //attack with no target (still uses ammo and decreases durability)
    private void attack() {
        Item attackItem = null;
        for (Item item : adventure.getPlayerInventory()) {
            if (item.isEquipped()) {
                attackItem = item;
            }
        }
        if (attackItem != null) {
            ReturnAttackMessage message = attackItem.attack().getReturnAttackMessage();
            switch (message) {
                case CANT_ATTACK -> System.out.println(Colours.RED + "Cannot attack with that weapon!" + Colours.RESET);
                case MELEE_ATTACK -> {
                    System.out.println(Colours.PURPLE_BOLD + "You swing your " + attackItem.getName() + "!" + Colours.RESET);
                    System.out.println(Colours.RED + attackItem.getName() + " produces a *swoosh* through the air " +
                            "hitting nothing!" + Colours.RESET);
                    attackItem.useOnce();
                }
                case CANT_MELEE_ATTACK ->
                        System.out.println(Colours.RED + attackItem.getName() + " is broken!" + Colours.RESET);
                case RANGED_ATTACK -> {
                    System.out.println(Colours.PURPLE_BOLD + "You fire your " + attackItem.getName() + "!" + Colours.RESET);
                    System.out.println(Colours.RED + attackItem.getName() + " fires and strikes the wall in front of you, " +
                            "hitting nothing!" + Colours.RESET);
                    attackItem.useOnce();
                }
                case CANT_RANGED_ATTACK ->
                        System.out.println(Colours.RED + attackItem.getName() + " is out of ammunition!" + Colours.RESET);
            }
        } else {
            System.out.println(Colours.RED + "No weapon equipped!" + Colours.RESET);
        }
    }

    //attack a target
    private void attackEnemy(String[] stringArray) {
        if (stringArray.length > 1) {
            String enemyName = "";
            for (int i = 1; i < stringArray.length; i++) {
                enemyName += stringArray[i] + " ";
            }
            enemyName = enemyName.trim();
            Enemy enemyInRoom = null;
            for (Enemy enemy : adventure.getPlayerLocation().getRoomEnemies()) {
                if (enemy.getName().toLowerCase().contains(enemyName.toLowerCase())) {
                    enemyInRoom = enemy;
                }
            }
            if (enemyInRoom != null) {
                Item attackItem = null;
                for (Item item : adventure.getPlayerInventory()) {
                    if (item.isEquipped()) {
                        attackItem = item;
                    }
                }
                if (attackItem != null) {
                    ReturnAttackMessage message = attackItem.attack().getReturnAttackMessage();
                    switch (message) {
                        case CANT_ATTACK ->
                                System.out.println(Colours.RED + "Cannot attack with that weapon!" + Colours.RESET);
                        case MELEE_ATTACK -> {
                            System.out.println(Colours.PURPLE_BOLD + "You swing your " + attackItem.getName() + " and deal "
                                    + attackItem.attack().getDamage() + " damage to " + Colours.RED + enemyInRoom.getName() +
                                    Colours.PURPLE_BOLD + "!" + Colours.RESET);
                            attackItem.useOnce();
                            if (enemyInRoom instanceof Trap) {
                                roomTrapsGoOff();
                            }
                            enemyInRoom.takeDamage(attackItem.attack().getDamage());
                            if (enemyInRoom.getHealth() < 1) {
                                System.out.println(Colours.PURPLE_BOLD + "Your attack killed " + enemyInRoom.getName() +
                                        "!" + Colours.RESET);
                                adventure.enemyDies(enemyInRoom);
                            }
                        }
                        case CANT_MELEE_ATTACK ->
                                System.out.println(Colours.RED + attackItem.getName() + " is broken!" + Colours.RESET);
                        case RANGED_ATTACK -> {
                            enemyInRoom.takeDamage(attackItem.attack().getDamage());
                            System.out.println(Colours.PURPLE_BOLD + "You fire your " + attackItem.getName() + " and deal "
                                    + attackItem.attack().getDamage() + " damage to " + Colours.RED + enemyInRoom.getName() +
                                    Colours.PURPLE_BOLD + "!" + Colours.RESET);
                            attackItem.useOnce();
                            if (enemyInRoom.getHealth() < 1) {
                                System.out.println(Colours.PURPLE_BOLD + "Your attack killed " + enemyInRoom.getName() +
                                        "!" + Colours.RESET);
                                adventure.enemyDies(enemyInRoom);
                            }
                        }
                        case CANT_RANGED_ATTACK ->
                                System.out.println(Colours.RED + attackItem.getName() + " is out of ammunition!" + Colours.RESET);
                    }
                } else {
                    System.out.println(Colours.RED + "No weapon equipped!" + Colours.RESET);
                }
            } else {
                System.out.println(Colours.RED + "No such enemy in the room!" + Colours.RESET);
            }
        } else if (stringArray.length == 1) {
            attack();
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
                //this doesn't seem to work
                case ALREADY_HAVE -> System.out.println(Colours.RED + "Item already acquired!" + Colours.RESET);
                case CAN_TAKE -> System.out.println(Colours.PURPLE_BOLD + "Item acquired!" + Colours.RESET);
                case DOESNT_EXIST -> System.out.println(Colours.RED + "Item doesn't exist!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void equipItem(String[] stringArray) {
        if (stringArray.length > 1) {
            String itemName = "";
            for (int i = 1; i < stringArray.length; i++) {
                itemName += stringArray[i] + " ";
            }
            itemName = itemName.trim();

            EquipDTO equipDTO = adventure.equip(itemName);
            switch (equipDTO.getReturnEquipMessage()) {
                case CANT_EQUIP -> System.out.println(Colours.RED + "Item cannot be equipped!" + Colours.RESET);
                case ALREADY_EQUIPPED -> System.out.println(Colours.RED + equipDTO.getItem().getName()+" already equipped!"
                        + Colours.RESET);
                case EQUIP_MELEE, EQUIP_RANGED -> System.out.println(Colours.PURPLE_BOLD + equipDTO.getItem().getName()+
                        " equipped!" + Colours.RESET);
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
            switch (adventure.dropItem(itemName)) { //TODO make this Enum
                case DOESNT_EXIST -> System.out.println(Colours.RED + "Item not in inventory!" + Colours.RESET);
                case CAN_DROP -> System.out.println(Colours.PURPLE_BOLD + "Item discarded!" + Colours.RESET);
                case CANT_DROP -> System.out.println(Colours.RED + "You cannot drop this item!" + Colours.RESET);
            }
        } else {
            invalidCommand();
        }
    }

    private void roomEnemiesAttack() {
        if (!adventure.getPlayerLocation().getRoomEnemies().isEmpty() && !enemyHasAttacked) {
            String string = "";
            for (Enemy enemy : adventure.getPlayerLocation().getRoomEnemies()) {
                if (!(enemy instanceof Trap)) {
                    if (enemy.attack() > 0) {
                        adventure.takeDamage(enemy.attack());
                        string += enemy.getName() + " attacks you, dealing " + enemy.attack() + " damage!";
                    }
                }
            }
            if (!string.equals("")) {
                System.out.printf(Colours.RED + """
                        ----------------------
                        %s
                        ----------------------
                        """ + Colours.RESET, string);
            }
            enemyHasAttacked = true;
        }
    }

    private void roomTrapsGoOff() {
        if (!adventure.getPlayerLocation().getRoomEnemies().isEmpty() && !enemyHasAttacked) {
            String string = "";
            for (Enemy enemy : adventure.getPlayerLocation().getRoomEnemies()) {
                if (enemy.attack() > 0) {
                    if (enemy instanceof Trap) {
                        adventure.takeDamage(enemy.attack());
                        string += enemy.getName() + " goes off, dealing " + enemy.attack() + " damage!";
                    }
                }
            }
            if (!string.equals("")) {
                System.out.printf(Colours.RED + """
                        ----------------------
                        %s
                        ----------------------
                        """ + Colours.RESET, string);
            }
            enemyHasAttacked = true;
        }
    }

    private void playerDeath() {
        scanner = new Scanner(System.in);
        System.out.println(Colours.RED_BOLD + "You have died!\nGame Over!\n" +
                Colours.BLUE_BOLD + "Would you like to continue?" + Colours.RESET);
        String answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
            //if you want to continue (added a lot of ways to say yes)
            case "ye", "yarp", "yass", "yes", "dah", "oui", "jahwol", "yep", "ja", "jaja" -> {
                //resets game, prints welcome message, and sets newRoom to "true"
                adventure = new Adventure();
                welcome();
                newRoom = true;
            }
            //if you say no (exits game after waiting half a second)
            case "no", "nope", "im out of here", "narp", "cya" -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.exit(2);
            }
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

    private void welcome() {
        System.out.print(Colours.BLUE_BOLD + """
                Welcome aboard the Discovery Vessel 'Hildebrand'.
                """ + Colours.RESET);
    }
}
