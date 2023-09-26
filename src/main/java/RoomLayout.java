import java.util.ArrayList;



public class RoomLayout {//TODO rette descriptions / names (vi fixer det senere, tænker jeg)

    private Room current;

    public void buildMap(){


        //TODO skrive alt der mangles med noget det refencerer noget fra kendt film eller spil.
        // Mid sektion
        Room outerSpace = new Room("Outer Space", "You ejected yourself into the space and died");
        Room room0 = new Room("Docking Port","Entrance into 'Discovery Vessel Hildebrand'"+
                "\nConnected to the Discovery Vessel via a door to the west."+
                "\nYou could leave out the docking port to the East, but it would kill you.");
        Room room1 = new Room("Room 1", "A ordinary room");
        Room room2 = new Room("Room 2", "showcase with spaceship marines who betrayed the captain, each shows how the marines are badly hurt");
        Room room3 = new Room("Room 3","Broken toilets with a sign that says 'The toilets are destroyed by Dr. Fluke Hawkins'");
        Room room4 = new Room("Room 4","A hallway");
        Room room5 = new Room("Room 5","A showcase ");
        Room room6 = new Room("Room 6","A hallway with dirty and stinky floor");
        Room room7 = new Room("Room 7","");
        Room room8 = new Room("Room 8","");
        Room room9 = new Room("Room 9","");
        Room room10 = new Room("Room 10","");
        Room room11 = new Room("Room 11","");
        Room room12 = new Room("Room 12","");
        Room room13 = new Room("Room 13","");
        Room room14 = new Room("Room 14","");
        Room room15 = new Room("Room 15","");

        // Bottom sektion
        Room room16 = new Room("Room 16","");
        Room room17 = new Room("Room 17","");
        Room room18 = new Room("Room 18","");
        Room room19 = new Room("Room 19","");
        Room room20 = new Room("Room 20","");
        Room room21 = new Room("Room 21","");

        // Top sektion
        Room room22 = new Room("Room 22","");
        Room room23 = new Room("Room 23","");
        Room room24 = new Room("Room 24","");
        Room room25 = new Room("Room 25","");
        Room room26 = new Room("Room 26","");
        Room room27 = new Room("Room 27","");
        Room room28 = new Room("Room 28","");
        Room room29 = new Room("Room 29","portraits of retired captains");
        Room room30 = new Room("Room 30","Showcase with Darth Vader mask and his red lightsaber");
        Room room31 = new Room("Room 31","");
        Room room32 = new Room("Room 32","");
        Room room33 = new Room("Room 33","\u001B[33mThe captain's office\u001B[0m");
        Room room34 = new Room("Room 34","The bridge");



//Mid section
        room0.setNeighbours(null,null,room1,outerSpace);
        room1.setNeighbours(room4,room10,room2,room0);
        room2.setNeighbours(null,room11,null,room1);
        room3.setNeighbours(room6,null,null,null);
        room4.setNeighbours(room7,room1,room5,null);
        room5.setNeighbours(null,null,room6,room4);
        room6.setNeighbours(null,room3,null,room5);
        room7.setNeighbours(null,room4,room8,null);
        room8.setNeighbours(null,null,room9,room7);
        room9.setNeighbours(room24,null,null,room8);
        room10.setNeighbours(room1,room13,null,null);
        room11.setNeighbours(room2, null, room12, null);
        room12.setNeighbours(null,room15,null,room11);
        room13.setNeighbours(room10,null,room14,null);
        room14.setNeighbours(null,null,room15,room13);
        room15.setNeighbours(room12,null,null,room14);

        //Bottom section

        room16.setNeighbours(null,room19,room17,null);
        room17.setNeighbours(room14,null,room18,room16);
        room18.setNeighbours(null,room21,null,room17);
        room19.setNeighbours(room16,null,room20,null);
        room20.setNeighbours(null,null,room21,room19);
        room21.setNeighbours(room18,null,null,room20);

        //Top section

        room22.setNeighbours(room25,null,room23,null);
        room23.setNeighbours(room26,null,room24,room22);
        room24.setNeighbours(null,room9,null,room23);
        room25.setNeighbours(null,room22,null,null);
        room26.setNeighbours(null,room23,room27,null);
        room27.setNeighbours(room30,null,null,room26);
        room28.setNeighbours(room31,null,room29,null);
        room29.setNeighbours(null,null,room30,room28);
        room30.setNeighbours(room33,room27,null,room29);
        room31.setNeighbours(null,room28,room32,null);
        room32.setNeighbours(room34,null,null,room31);
        room33.setNeighbours(null,room30,null,null);




        // Start Room i Spaceship
        current = room0;
    }


   /* private Room outerSpace = new Room("Outer Space","This environment will literally kill you");

    // Mid sektion
    private Room room0 = new Room("Docking Port","Entrance into 'Discovery Vessel Hildebrand'"+
                                    "\nConnected to the Discovery Vessel via a door to the west."+
                                    "\nYou could leave out the docking port to the East, but it would kill you.");
    private Room room1 = new Room("Room 1","A room");
    private Room room2 = new Room("Room 2","A smelly room");
    private Room room3 = new Room("Room 3","A cramped room");
    private Room room4 = new Room("Room 4","A cramped room");
    private Room room5 = new Room("Room 5","A cramped room");
    private Room room6 = new Room("Room 6","A cramped room");
    private Room room7 = new Room("Room 7","A cramped room");
    private Room room8 = new Room("Room 8","A cramped room");
    private Room room9 = new Room("Room 9","A cramped room");
    private Room room10 = new Room("Room 10","A cramped room");
    //  private Room room11 = new Room("Room 11","A cramped room");
    //  private Room room12 = new Room("Room 12","A cramped room");
    //  private Room room13 = new Room("Room 13","A cramped room");
    //  private Room room14 = new Room("Room 14","A cramped room");
    // private Room room15 = new Room("Room 15","A cramped room");

    // Top sektion
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

     /*public RoomLayout(){
        setConnections();
    }

    public void setConnections(){ //guess the error :D look at the connections (why cant i go west??)
        // Set Mid sektion
        // north - south - west - east
        room0.setNeighbours(null,null,room1,outerSpace);
        room1.setNeighbours(room4,room10,room2,room0);
        room2.setNeighbours(null,null,null,room1);
        room3.setNeighbours(room6,null,null,null);
        room4.setNeighbours(room7,room1,room5,null);
        room5.setNeighbours(room7,room1,room5,null);
        room4.setNeighbours(null,room1,null,null);

        room8.setNeighbours(null, null, room9, room7);
        room10.setNeighbours(room1,null,null,null);
    }*/

    public Room starterRoom(){
        return current;
    }
}
