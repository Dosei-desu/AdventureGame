import java.util.ArrayList;

public class Player {
    private Room playerLocation;
    private ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public String viewInventory(){
        String string = "";
        for (Item item: inventory) {
            string += item;
        }
        return string;
    }
    public Room getPlayerLocation(){
        return playerLocation;
    }
    public void setPlayerLocation(Room room){
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
}