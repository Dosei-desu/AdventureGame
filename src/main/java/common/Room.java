package common;

import items.Item;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean locked;
    private boolean litUp;
    private Room neighbourNorth;
    private Room neighbourSouth;
    private Room neighbourWest;
    private Room neighbourEast;
    private ArrayList<Item> roomItems;
    private ArrayList<Enemy> roomEnemies;

    //standard constructor with just name and description (default values are set for Locked and LitUp)
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.locked = false;
        this.litUp = true;
        roomItems = new ArrayList<>();
        roomEnemies = new ArrayList<>();
    }

    //constructor for rooms that are locked (LitUp is defaulted to False)
    public Room(String name, String description, boolean locked) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.litUp = true;
        roomItems = new ArrayList<>();
        roomEnemies = new ArrayList<>();
    }

    //constructor for rooms where you want to set Locked and LitUp manually
    public Room(String name, String description, boolean locked, boolean litUp) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.litUp = litUp;
        roomItems = new ArrayList<>();
        roomEnemies = new ArrayList<>();
    }

    public void addItemToRoom(Item item){
        roomItems.add(item);
    }

    public ArrayList<Item> getRoomItems(){
        return roomItems;
    }

    public void removeItemFromRoom(Item item){
        roomItems.remove(item);
    }

    public void addEnemyToRoom(Enemy enemy){
        roomEnemies.add(enemy);
    }

    public ArrayList<Enemy> getRoomEnemies() {
        return roomEnemies;
    }

    public boolean hasTrap(){
        for (Enemy enemy: roomEnemies) {
            if(enemy instanceof Trap){
                return true;
            }
        }
        return false;
    }

    public void removeEnemyFromRoom(Enemy enemy){
        roomEnemies.remove(enemy);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLitUp() {
        return litUp;
    }

    public void setLitUp(boolean litUp) {
        this.litUp = litUp;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setNeighbours(Room roomNorth, Room roomSouth, Room roomWest, Room roomEast){
        neighbourNorth = roomNorth;
        neighbourSouth = roomSouth;
        neighbourWest = roomWest;
        neighbourEast = roomEast;
    }
    public Room getNeighbourNorth() {
        return neighbourNorth;
    }

    public Room getNeighbourSouth() {
        return neighbourSouth;
    }

    public Room getNeighbourWest() {
        return neighbourWest;
    }

    public Room getNeighbourEast() {
        return neighbourEast;
    }
}
