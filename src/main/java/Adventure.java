public class Adventure {
    private Player player;
    private Map map;

    public Adventure(){
        player = new Player();
        map = new Map();
        map.buildMap();
        player.setPlayerLocation(map.starterRoom());
    }

    public Room getPlayerLocation(){
        return player.getPlayerLocation();
    }

    public void setPlayerLocation(Room room){
        player.setPlayerLocation(room);
    }

    public int moveNorth() {
        if (player.getPlayerLocation().getNeighbourNorth() != null) {
            if (player.getPlayerLocation().getNeighbourNorth().isLocked()) {
                return 0;
            }
            player.moveNorth();
            return 1;
        }else {
            return 2;
        }
    }

    public int moveSouth() {
        if (player.getPlayerLocation().getNeighbourSouth() != null) {
            if (player.getPlayerLocation().getNeighbourSouth().isLocked()) {
                return 0;
            }
            player.moveSouth();
            return 1;
        }else {
            return 2;
        }
    }

    public int moveEast() {
        if (player.getPlayerLocation().getNeighbourEast() != null) {
            if (player.getPlayerLocation().getNeighbourEast().isLocked()) {
                return 0;
            }
            player.moveEast();
            return 1;
        }else {
            return 2;
        }
    }

    public int moveWest() {
        if (player.getPlayerLocation().getNeighbourWest() != null) {
            if (player.getPlayerLocation().getNeighbourWest().isLocked()) {
                return 0;
            }
            player.moveWest();
            return 1;
        }else {
            return 2;
        }
    }
}
