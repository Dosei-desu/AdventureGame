import java.util.ArrayList;


public class RoomLayout {

    private Room current;

    public void buildMap() {
        // Rooms

        // Middle section
        Room outerSpace = new Room("Outer Space", "You ejected yourself into the space and died.");
        Room room0 = new Room("East Airlock", """
                                    Entrance into 'Discovery Vessel Hildebrand'.
                                    Connected to the Discovery Vessel via a door to the West.
                                    You could leave out the docking port to the East, but it would kill you.""");
        Room room1 = new Room("East Vestibule", """
                                    Spacesuits and oxygen tanks hang from the walls.
                                    Connected to rooms via three doors to the North, West, and South.
                                    Connected to an Airlock to the East.""");
        Room room2 = new Room("Central Room", """ 
                                    A large support column stands in the centre of the room, and along the walls are
                                    memorials to a mutiny that happened long ago.
                                    Connected to rooms via two doors to the East and South.""");
        Room room3 = new Room("West Vestibule", """
                                    For some reason there is a broken urinal next to rows of spacesuits and oxygen tanks.
                                    A note above the urinal states: 'Goddamn Dr. Fluke Hawkins and his experiments!'
                                    Connected to a room via a door to the North.
                                    Connected to an Airlock to the West.""");
        Room room4 = new Room("Hallway", """
                                    Motivational posters line the walls of the hall-way. Your eye stops on a picture of
                                    a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'
                                    Connected to rooms via doors to the North and West.
                                    The door to the North is locked.""");
        Room room5 = new Room("Room 5", "A showcase ");
        Room room6 = new Room("Room 6", "A hallway with dirty and stinky floor");
        Room room7 = new Room("Room 7", "");
        Room room8 = new Room("Room 8", "");
        Room room9 = new Room("Room 9", "");
        Room room10 = new Room("Room 10", "");
        Room room11 = new Room("Room 11", "");
        Room room12 = new Room("Room 12", "");
        Room room13 = new Room("Room 13", "");
        Room room14 = new Room("Room 14", "");
        Room room15 = new Room("Room 15", "");

        // Bottom section
        Room room16 = new Room("Room 16", "");
        Room room17 = new Room("Room 17", "");
        Room room18 = new Room("Room 18", "");
        Room room19 = new Room("Room 19", "");
        Room room20 = new Room("Room 20", "");
        Room room21 = new Room("Room 21", "");

        // Top section
        Room room22 = new Room("Room 22", "");
        Room room23 = new Room("Room 23", "");
        Room room24 = new Room("Room 24", "");
        Room room25 = new Room("Room 25", "");
        Room room26 = new Room("Room 26", "");
        Room room27 = new Room("Room 27", "");
        Room room28 = new Room("Room 28", "");
        Room room29 = new Room("Room 29", "portraits of retired captains");
        Room room30 = new Room("Room 30", "Showcase with Darth Vader mask and his red lightsaber");
        Room room31 = new Room("Room 31", "");
        Room room32 = new Room("Room 32", "");
        Room room33 = new Room("Room 33", "The captain's office");
        Room room34 = new Room("Room 34", "The bridge");

        // Outer Rooms

        Room room35 = new Room("West Airlock", """
                                     Entrance into 'Discovery Vessel Hildebrand'.
                                     Connected to the Discovery Vessel via a door to the East.
                                     You could leave out the docking port to the West, but it would kill you.""");
        Room room37 = new Room("Room 32", "");
        Room room38 = new Room("Room 32", "");
        Room room39 = new Room("Room 32", "");
        Room room40 = new Room("Room 32", "");
        Room room41 = new Room("Room 32", "");
        Room room42 = new Room("Room 32", "");
        Room room43 = new Room("Room 32", "");
        Room room44 = new Room("Room 32", "");
        Room room45 = new Room("Room 32", "");
        Room room46 = new Room("Room 32", "");
        Room room47 = new Room("Room 32", "");
        Room room48 = new Room("Room 32", "");
        Room room49 = new Room("Room 32", "");
        Room room50 = new Room("Room 32", "");
        Room room51 = new Room("Room 32", "");
        Room room52 = new Room("Room 32", "");
        Room room53 = new Room("Room 32", "");
        Room room54 = new Room("Room 32", "");
        Room room55 = new Room("Room 32", "");

        //--------------------------------------------------------------
        // Room Connections


        // Middle section

        room0.setNeighbours(null, null, room1, outerSpace);
        room1.setNeighbours(room4, room10, room2, room0);
        room2.setNeighbours(null, room11, null, room1);
        room3.setNeighbours(room6, null, null, null);
        room4.setNeighbours(room7, room1, room5, null);
        room5.setNeighbours(null, null, room6, room4);
        room6.setNeighbours(null, room3, null, room5);
        room7.setNeighbours(null, room4, room8, null);
        room8.setNeighbours(null, null, room9, room7);
        room9.setNeighbours(room24, null, null, room8);
        room10.setNeighbours(room1, room13, null, null);
        room11.setNeighbours(room2, null, room12, null);
        room12.setNeighbours(null, room15, null, room11);
        room13.setNeighbours(room10, null, room14, null);
        room14.setNeighbours(null, null, room15, room13);
        room15.setNeighbours(room12, null, null, room14);

        // Bottom section

        room16.setNeighbours(null, room19, room17, null);
        room17.setNeighbours(room14, null, room18, room16);
        room18.setNeighbours(null, room21, null, room17);
        room19.setNeighbours(room16, null, room20, null);
        room20.setNeighbours(null, null, room21, room19);
        room21.setNeighbours(room18, null, null, room20);

        // Top section

        room22.setNeighbours(room25, null, room23, null);
        room23.setNeighbours(room26, null, room24, room22);
        room24.setNeighbours(null, room9, null, room23);
        room25.setNeighbours(null, room22, null, null);
        room26.setNeighbours(null, room23, room27, null);
        room27.setNeighbours(room30, null, null, room26);
        room28.setNeighbours(room31, null, room29, null);
        room29.setNeighbours(null, null, room30, room28);
        room30.setNeighbours(room33, room27, null, room29);
        room31.setNeighbours(null, room28, room32, null);
        room32.setNeighbours(room34, null, null, room31);
        room33.setNeighbours(null, room30, null, null);

        // Outer Rooms

        room35.setNeighbours(null, null, outerSpace, room3);

        // Start Room
        current = room0;
    }

    public Room starterRoom() {
        return current;
    }
}
