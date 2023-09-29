import java.util.ArrayList;

public class Player {
    private Room playerLocation;
    private ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
        startingInventory();
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void takeItem(Item item){
        inventory.add(item);
    }

    public void dropItem(Item item){
        inventory.remove(item);
    }

    public String viewInventory(){
        String string = "";
        for (Item item: inventory) {
            string += item.getItemBrief()+"\n";
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

    private void startingInventory(){
        String map = Colours.RED+"""
                            34
                """+Colours.GREEN_BOLD+"""
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
                    35--03  02--01--00
                            ||  ||
                    36  12--11  10  42
                    ||  ||      ||  ||
                    37--15--14--13--43
                            ||
                ||--49  18--17--16  44--||
                48      ||      ||      45
                ||--47--21--20--19--46--||
                """+Colours.RED+"""
                You have to get to room 34.
                Your starting position is room 00."""+Colours.RESET;
        inventory.add(new Item("Map of Hildebrand","Map",map,
                "A Map of the Discovery Vessel 'Hildebrand'."));
    }
}