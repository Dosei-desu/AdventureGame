package common;

import items.Item;

import java.util.ArrayList;

public class Adventure {
    private Player player;
    private Map map;

    public Adventure() {
        player = new Player();
        map = new Map();
        map.buildMap();
        player.setPlayerLocation(map.starterRoom());
    }

    public Room getPlayerLocation() {
        return player.getPlayerLocation();
    }

    public void setPlayerLocation(Room room) {
        player.setPlayerLocation(room);
    }

    public Player getPlayer(){
        return player;
    }

    public ReturnMoveMessage moveNorth() {
        if (player.getPlayerLocation().getNeighbourNorth() != null) {
            if (player.getPlayerLocation().getNeighbourNorth().isLocked()) {
                return ReturnMoveMessage.DOOR_LOCKED;
            }
            player.moveNorth();
            return ReturnMoveMessage.CAN_MOVE;
        } else {
            return ReturnMoveMessage.CANT_MOVE;
        }
    }

    public ReturnMoveMessage moveSouth() {
        if (player.getPlayerLocation().getNeighbourSouth() != null) {
            if (player.getPlayerLocation().getNeighbourSouth().isLocked()) {
                return ReturnMoveMessage.DOOR_LOCKED;
            }
            player.moveSouth();
            return ReturnMoveMessage.CAN_MOVE;
        } else {
            return ReturnMoveMessage.CANT_MOVE;
        }
    }

    public ReturnMoveMessage moveEast() {
        if (player.getPlayerLocation().getNeighbourEast() != null) {
            if (player.getPlayerLocation().getNeighbourEast().isLocked()) {
                return ReturnMoveMessage.DOOR_LOCKED;
            }
            player.moveEast();
            return ReturnMoveMessage.CAN_MOVE;
        } else {
            return ReturnMoveMessage.CANT_MOVE;
        }
    }

    public ReturnMoveMessage moveWest() {
        if (player.getPlayerLocation().getNeighbourWest() != null) {
            if (player.getPlayerLocation().getNeighbourWest().isLocked()) {
                return ReturnMoveMessage.DOOR_LOCKED;
            }
            player.moveWest();
            return ReturnMoveMessage.CAN_MOVE;
        } else {
            return ReturnMoveMessage.CANT_MOVE;
        }
    }

    public int addItem(String name) {
        Item item = null;
        for (Item i : player.getPlayerLocation().getRoomItems()) {
            if (i.getName().toLowerCase().contains(name.toLowerCase())) {
                item = i;
            }
        }
        if (player.getPlayerLocation().getRoomItems().contains(item)) {
            if (player.getInventory().contains(item)) {
                //doesnt add item if it already exists
                //except it doesn't work...
                return 0;
            } else {
                //successfully taken an  item
                player.takeItem(item); //adds to player inventory
                getPlayerLocation().removeItemFromRoom(item); //removes from room item list
                return 1;
            }
        } else {
            //item doesn't exist
            return 2;
        }
    }

    public int dropItem(String name) {
        Item item = null;
        for (Item i : player.getInventory()) {
            if (i.getName().toLowerCase().contains(name.toLowerCase())) {
                item = i;
            }
        }
        if (player.getInventory().contains(item)) {
            //successfully dropped item
            player.dropItem(item); //removes to player inventory
            getPlayerLocation().addItemToRoom(item); //adds from room item list
            return 1;
        } else {
            //item doesn't exist
            return 0;
        }
    }

    public EatDTO eatItem(String name){
        Item item = null;
        for (Item i : player.getInventory()) {
            if (i.getName().toLowerCase().contains(name.toLowerCase())) {
                item = i;
            }
        }
        return player.eatItem(item);
    }
    public int heal(int healValue){
        return player.heal(healValue);
    }
    public int takeDamage(int damageValue){
        return player.takeDamage(damageValue);
    }
    public int getPlayerHealth(){
        return player.getHealthPoints();
    }
    public Item findItem(String name){
        return player.findItem(name);
    }

    public ArrayList<Item> getPlayerInventory(){
        return player.getInventory();
    }

    public Room getRoomNorth(){
        return getPlayerLocation().getNeighbourNorth();
    }

    public Room getRoomSouth(){
        return getPlayerLocation().getNeighbourSouth();
    }

    public Room getRoomEast(){
        return getPlayerLocation().getNeighbourEast();
    }

    public Room getRoomWest(){
        return getPlayerLocation().getNeighbourWest();
    }
}
