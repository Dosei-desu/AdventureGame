import java.util.Scanner;

public class Player {
    private Room playerLocation;
    private Map roomLayout;
    private boolean newRoom;

    public Player() {
        roomLayout = new Map();
        roomLayout.buildMap();
        playerLocation = roomLayout.starterRoom();
    }
    public Room getPlayerLocation(){
        return playerLocation;
    }
    //move methods should probably be returning something that can be used to decide which message is played, since
    //having printline in anything but UserInterface class is bad manners
    public void moveNorth(Room room) {
        if (room.getNeighbourNorth() != null) {
            if (room.getNeighbourNorth().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
            }
            newRoom = true;
            playerLocation = room.getNeighbourNorth();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
        }
    }

    public void moveSouth(Room room) {
        if (room.getNeighbourSouth() != null) {
            if (room.getNeighbourSouth().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
            }
            newRoom = true;
            playerLocation = room.getNeighbourSouth();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
        }
    }

    public void moveWest(Room room) {
        if (room.getNeighbourWest() != null) {
            if (room.getNeighbourWest().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
            }
            newRoom = true;
            playerLocation = room.getNeighbourWest();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);
        }
    }

    public void moveEast(Room room) {
        if (room.getNeighbourEast() != null) {
            if (room.getNeighbourEast().isLocked()) {
                System.out.println(Colours.RED + "The door is locked!" + Colours.RESET);
            }
            newRoom = true;
            playerLocation = room.getNeighbourEast();
        } else {
            System.out.println(Colours.RED + "You cannot move that way!" + Colours.RESET);

        }
    }



}