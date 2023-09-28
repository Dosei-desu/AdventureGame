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
    public void setPlayerLocation(Room room){
        playerLocation = room;
    }

    public int moveNorth(Room room) {
        if (room.getNeighbourNorth() != null) {
            if (room.getNeighbourNorth().isLocked()) {
                return 0;
            }
            return 1;
        }else {
            return 2;
        }
    }

    public int moveSouth(Room room) {
        if (room.getNeighbourSouth() != null) {
            if (room.getNeighbourSouth().isLocked()) {
                return 0;
            }
            return 1;
        }else {
            return 2;
        }
    }

    public int moveEast(Room room) {
        if (room.getNeighbourEast() != null) {
            if (room.getNeighbourEast().isLocked()) {
                return 0;
            }
            return 1;
        }else {
            return 2;
        }
    }

    public int moveWest(Room room) {
        if (room.getNeighbourWest() != null) {
            if (room.getNeighbourWest().isLocked()) {
                return 0;
            }
            return 1;
        }else {
            return 2;
        }
    }
}