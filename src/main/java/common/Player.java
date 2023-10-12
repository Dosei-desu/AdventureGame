package common;

import items.*;
import ui.Colours;

import java.util.ArrayList;

public class Player {
    private Room playerLocation;
    private ArrayList<Item> inventory;
    private int healthPoints;
    private final int MAX_HEALTH_VALUE = 100;
    private final int MIN_HEALTH_VALUE = 0;

    //unique items player starts with
    private Item hildebrandMap;
    private Item missionBrief;
    private Item fists;
    private Item trustyNeedler;

    public Player() {
        inventory = new ArrayList<>();
        startingInventory();
        healthPoints = 85;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public boolean dropItem(Item item) {
        if(item != null) {
            if (item != fists) {
                inventory.remove(item);
                item.setEquipped(false);
                return true;
            }
        }
        return false;
    }

    public Item findItem(String name) {
        Item item = null;
        for (Item i : getInventory()) {
            if (i.getName().toLowerCase().contains(name.toLowerCase())) {
                item = i;
            }
        }
        return item;
    }

    public EatDTO eatItem(Item item) {
        EatDTO eatDTO;
        if (item instanceof Keycard) {
            eatDTO = new EatDTO(ReturnEatMessage.CANT_EAT, 0);
            return eatDTO;
        } else if (item instanceof Food) {
            int foodValue = ((Food) item).getFoodHealthPoints();
            inventory.remove(item);
            if (foodValue > 0) { //heals player
                foodValue = ((Food) item).getFoodHealthPoints();
                heal(foodValue);
                eatDTO = new EatDTO(ReturnEatMessage.EAT_HEAL_FOOD, foodValue);
                return eatDTO;
            } else { //damages player
                foodValue = ((Food) item).getFoodHealthPoints();
                takeDamage((-1*foodValue));
                eatDTO = new EatDTO(ReturnEatMessage.EAT_DAMAGE_FOOD, (foodValue * -1));
                return eatDTO;
            }
        } else if (item == hildebrandMap) {
            inventory.remove(item);
            eatDTO = new EatDTO(ReturnEatMessage.EAT_MAP, 0);
            return eatDTO;
        } else if(item.getName().equalsIgnoreCase("Caffeine Bottle")){
            takeDamage(999);
            eatDTO = new EatDTO(ReturnEatMessage.EAT_CAFFEINE_BOTTLE,-999);
            return eatDTO;
        }
        inventory.remove(item);
        eatDTO = new EatDTO(ReturnEatMessage.EAT_JUNK, 0);
        return eatDTO;
    }

    public String viewInventory() {
        String string = "";
        for (Item item : inventory) {
            string += item.getItemBrief();
            if(item instanceof Weapon) {
                if (item.isEquipped()) {
                    string += " (Equipped)";
                }
                if (item.getNumberOfUses() == 0) {
                    string += " "+item.breakStatus();
                }
            }
            string += "\n";
        }
        return string;
    }

    public Room getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Room room) {
        playerLocation = room;
    }

    public void moveNorth() {
        setPlayerLocation(playerLocation.getNeighbourNorth());
    }

    public void moveSouth() {
        setPlayerLocation(playerLocation.getNeighbourSouth());
    }

    public void moveEast() {
        setPlayerLocation(playerLocation.getNeighbourEast());
    }

    public void moveWest() {
        setPlayerLocation(playerLocation.getNeighbourWest());
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int takeDamage(int damageValue) {
        healthPoints -= damageValue;
        if (healthPoints < MIN_HEALTH_VALUE) {
            healthPoints = MIN_HEALTH_VALUE;
        }
        return healthPoints;
    }

    public int heal(int healValue) {
        healthPoints += healValue;
        if (healthPoints > MAX_HEALTH_VALUE) {
            healthPoints = MAX_HEALTH_VALUE;
        }
        return healthPoints;
    }

    public EquipDTO equip(String name) {
        EquipDTO equipDTO;
        Item itemToEquip = findItem(name);
        if(itemToEquip != null) {
            if (itemToEquip.isEquippable()) { //can it be equipped?
                for (Item item : inventory) {
                    if (item.isEquipped()) {
                        if (item == itemToEquip) { //if item is already equipped and matches name, it sends an error message
                            equipDTO = new EquipDTO(ReturnEquipMessage.ALREADY_EQUIPPED, item);
                            return equipDTO;
                        }
                    }
                    item.setEquipped(false); //sets all items to not equipped
                }
            }
            for (Item item : inventory) {
                if (itemToEquip.isEquippable()) {
                    if (item == itemToEquip) { //set matched item to equipped
                        item.setEquipped(true);
                        equipDTO = new EquipDTO(item.equip(), item);
                        return equipDTO;
                    }
                }
            }
        }
        equipDTO = new EquipDTO(ReturnEquipMessage.CANT_EQUIP,null); //if not equippable
        return equipDTO;
    }

    private void startingInventory() {
        //useful map because the play area is quite big and confusing without hints
        String map = Colours.RED + """
                            34
                """ + Colours.GREEN_BOLD + """
                            ||
                        33  32--31
                        ||      ||
                        30--29--28
                        ||
                ||--52--27--26  25--53--||
                51          ||  ||      54
                ||--50  24--23--22  55--||
                        ||
                    38--09--08--07--40
                    ||          ||  ||
                    39  06--05--04  41
                        ||      ||
                    35--03  02--01--""" +
                Colours.RED + "00" + Colours.GREEN_BOLD +
                """
                            
                            ||  ||
                    36  12--11  10  42
                    ||  ||      ||  ||
                    37--15--14--13--43
                            ||
                ||--49  18--17--16  44--||
                48      ||      ||      45
                ||--47--21--20--19--46--||
                """ + Colours.RED + """
                You have to get to room 34.
                Your starting position is room 00.""" + Colours.RESET;
        hildebrandMap = new Item("Map of Hildebrand", "Map", map,
                "A Map of the Discovery Vessel 'Hildebrand'.");

        String brief = Colours.CYAN+"""
                The Discovery Vessel 'Hildebrand' came upon a
                unique Artefact of unknown origins that I wish
                to possess.
                
                As my foremost Derelict Wanderer, I expect you
                to bring this Artefact to me.
                
                But beware, the 'Hildebrand' has fallen into
                chaos and all attempts to hail it has proven
                unsuccessful. I do not know what you will find
                aboard the vessel, but I recommend keeping your
                weapon close at hand.
                
                To find the Artefact, it seems that seeking out
                the Command Deck is the best course of action,
                as I heard the Captain never let the Artefact
                out of his sights.
                
                You know what happens if you do not deliver.
                
                - Winchester"""+Colours.RESET;
        missionBrief = new Item("Mission Brief","Instruction",brief,
                "Instructions for your mission aboard the Hildebrand");

        fists = new MeleeWeapon("Fists","Your fists","These are your fists. They are quite dainty.",
                "You'll never see this, because you can't drop your fists...",24,1);
        //was originally limitless uses, but i thought it would be funny if someone persistent enough kept swinging their fists
        //and ended up breaking them as a result

        trustyNeedler = new RangedWeapon("Trusty Needler","Needler Gun","A trusty Needler Gun that has "+
                "saved you more times than you can remember.","A worn Needler Gun with a maximum capacity of three shots",
                3,8);

        inventory.add(fists);
        equip("fists");
        inventory.add(trustyNeedler);
        inventory.add(missionBrief);
        inventory.add(hildebrandMap);


        inventory.add(new Food("Suspicious Goop", "Consumable",
                "It looks like cursed mashed potatoes and gives off an earthy smell. It seems to move on its own\n" +
                        "when you prod it with your fingers.", "A mass of goop.", -25));
    }
}