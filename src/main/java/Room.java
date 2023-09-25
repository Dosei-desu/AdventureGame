public class Room {
    private String name;
    private String description;
    private Room neighbourNorth;
    private Room neighbourSouth;
    private Room neighbourWest;
    private Room neighbourEast;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
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

    public void setNeighbourNorth(Room neighbourNorth) {
        this.neighbourNorth = neighbourNorth;
    }

    public Room getNeighbourSouth() {
        return neighbourSouth;
    }

    public void setNeighbourSouth(Room neighbourSouth) {
        this.neighbourSouth = neighbourSouth;
    }

    public Room getNeighbourWest() {
        return neighbourWest;
    }

    public void setNeighbourWest(Room neighbourWest) {
        this.neighbourWest = neighbourWest;
    }

    public Room getNeighbourEast() {
        return neighbourEast;
    }

    public void setNeighbourEast(Room neighbourEast) {
        this.neighbourEast = neighbourEast;
    }
}
