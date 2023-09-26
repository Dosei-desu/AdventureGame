import java.util.ArrayList;

public class RoomLayout {//TODO rette descriptions / names (vi fixer det senere, tænker jeg)
    private Room outerSpace = new Room("Outer Space","This environment will literally kill you");

    // Mid sektion
    private Room room0 = new Room("Docking Port","Entrance into 'Discovery Vessel Hildebrand'"+
                                    "\nConnected to the Discovery Vessel via a door to the west."+
                                    "\nYou could leave out the docking port to the East, but it would kill you.");
    private Room room1 = new Room("Room 1","A room");
    private Room room2 = new Room("Room 2","A smelly room");
   // private Room room3 = new Room("Room 3","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
  //  private Room room5 = new Room("Room 5","A cramped room");
  //  private Room room6 = new Room("Room 6","A cramped room");
  // private Room room7 = new Room("Room 7","A cramped room");
  //  private Room room8 = new Room("Room 8","A cramped room");
  //  private Room room9 = new Room("Room 9","A cramped room");
    private Room room10 = new Room("Room 10","A cramped room");
    //  private Room room11 = new Room("Room 11","A cramped room");
    //  private Room room12 = new Room("Room 12","A cramped room");
    //  private Room room13 = new Room("Room 13","A cramped room");
    //  private Room room14 = new Room("Room 14","A cramped room");
    // private Room room15 = new Room("Room 15","A cramped room");

   /* // Top sektion
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");

    // Bund sektion
    private Room room10 = new Room("Room 10","A large room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room"); */

    public RoomLayout(){
        setConnections();
    }

    public void setConnections(){ //guess the error :D look at the connections (why cant i go west??)
        // Set Mid sektion
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
