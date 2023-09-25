import java.util.ArrayList;

public class RoomLayout {//TODO rette descriptions / names (vi fixer det senere, tænker jeg)
    private Room outerSpace = new Room("Outer Space","This environment will literally kill you");
    private Room room0 = new Room("Docking Port","Entrance into 'Discovery Vessel Hildebrand'"+
                                    "\nConnected to the Discovery Vessel via a door to the west."+
                                    "\nYou could leave out the docking port to the East, but it would kill you.");
    private Room room1 = new Room("Room 1","A room");
    private Room room2 = new Room("Room 2","A smelly room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room10 = new Room("Room 10","A large room");

    public RoomLayout(){
        setConnections();
    }

    public void setConnections(){ //guess the error :D look at the connections (why cant i go west??)
        room0.setNeighbours(null,null,room1,outerSpace);
        room1.setNeighbours(room4,room10,room2,room0);
        room2.setNeighbours(null,null,null,room1);
        room4.setNeighbours(null,room1,null,null);
        room10.setNeighbours(room1,null,null,null);
    }

    public Room starterRoom(){
        return room0;
    }
}
