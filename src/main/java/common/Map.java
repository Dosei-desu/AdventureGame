package common;

import items.*;
import ui.Colours;

public class Map {

    private Room current;
    private Room roomToTeleportTo;

    public void buildMap() {
        // Rooms

        // Middle section
        Room outerSpace = new Room("Outer Space",
                          "You ejected yourself into the space and died.");
        Room room0 = new Room("East Airlock", """
                                    Entrance into 'Discovery Vessel Hildebrand'.
                                    Connected to the Discovery Vessel via a door to the West."""+
                                    "\nYou could leave out the docking port to the East, but it would "+
                                    Colours.RED+"kill"+Colours.GREEN_BOLD+" you.");
        Room room1 = new Room("East Vestibule", """
                                    Spacesuits and oxygen tanks hang from the walls.
                                    Connected to rooms via three doors to the North, West, and South.
                                    Connected to an Airlock to the East.""");
        Room room2 = new Room("Memorial Room", """ 
                                    A large support column stands in the centre of the room, and along the walls are
                                    memorials to a mutiny that happened long ago, with epitaphs and pictures of marines.
                                    Connected to rooms via two doors to the East and South.
                                    There used to be a doorway to the West, but it has been permanently welded shut.""");
        Room room3 = new Room("West Vestibule", """
                                    For some reason there is a broken urinal next to rows of spacesuits and oxygen tanks.
                                    A note above the urinal states: 'Goddamn Dr. Fluke Hawkins and his experiments!'
                                    Under the broken urinal lies a filthy keycard with the words 'Engine Room' on it.
                                    Connected to a room via a door to the North.
                                    Connected to an Airlock to the West.""");
                                    //items: Keycard to room14
        room3.addItemToRoom(new Keycard("Engine Room Keycard","Keycard","Grants access to " +
                                                 "the Engine Room to the South.","a filthy keycard with " +
                                                 "the words 'Engine Room' on it.","Engine Room Vestibule"));
        Room room4 = new Room("Motivational Hallway", """
                                    Motivational posters line the walls of the hallway. Your eye stops on a picture of
                                    a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'
                                    Connected to rooms via doors to the North and West.
                                    The door to the North is locked and requires a keycard to enter.""");
                                    //items: Motivational Poster
        room4.addItemToRoom(new Item("Motivational Poster","Junk","A motivational poster with " +
                                        "picture of a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'",
                "A poster with a kitten on it that reads 'Hang in there!'.'"));
        Room room5 = new Room("Suspiciously-narrow Hallway", """
                                    The hallway is so narrow that you would have to crawl to get through. On the floor is
                                    a well-crafted origami unicorn.
                                    Connected to rooms via doors to the East and West.""");
                                    //items: Origami Unicorn
        room5.addItemToRoom(new Item("Origami Unicorn","Junk","A well-crafted origami sculpture " +
                                          "depicting a unicorn. You are unsure how it is possible to fold something so meticulously.",
                "A well-crafted origami unicorn."));
        Room room6 = new Room("Origami Room", """
                                    The floor is absolutely littered with origami animals of all shapes and sizes and
                                    colours. One of the pieces is so tall that it touches the ceiling and it depicts a
                                    giraffe. One piece is so tiny that you would need a microscope to tell what animal it
                                    depicts. Many of the pieces resemble a unicorn.
                                    Connected to rooms via doors to the East and South.""");
        Room room7 = new Room("Dirty Hallway", """
                                    The lights in this dirty hallway are flickering ominously. Meal-trays lay discarded
                                    all over the place and the smell of rotten Synthmeat fill the air.
                                    Connected to rooms via doors to the West, South, and East.
                                    The door to the East lead to darkness, but a sign above the doorway reads 'Crew
                                    Quarters B'.""",true);
        Room room8 = new Room("Vandalised Hallway", """
                                    Some hooligan has smashed the lights and drawn a lewd image of the Emperor of Man
                                    cuddling with two very muscular green-skinned orcs.
                                    Connected to rooms via doors to the East and West.""",false,false);
        Room room9 = new Room("Vandalised Common Room", """
                                    All the lights in the room have been smashed and graffiti covers the walls and even
                                    the ceiling. Most of the graffiti are lewd acts performed by either the Captain of the
                                    Discover Vessel, the Emperor of Man, or other important figures. Couches and bookshelves
                                    are scattered across the room, and there is even a mini-fridge full of beer, although
                                    all the bottles are empty. Scrawled above the fridge is the phrase 'Captain Delaine
                                    Suxx!' It is underscored with red lines for some reason.
                                    Connected to rooms via doors to the North, East, and West.""",false, false);
                                    //contains the password to special door from room15 to room14
        Room room10 = new Room("Hallway of Mirrors", """
                                    Highly-reflective mirrors cover every inch of the hallway, making it very disorienting
                                    to walk through. At first you believe there are twelve doors, but it turns out there
                                    are in fact only two.
                                    Connected to rooms via doors to the North and South.""");
        Room room11 = new Room("Trophy Room", """
                                    Trophies sit in display cases all over the room. There are signed baseballs, footballs,
                                    and even a signed computer mouse, for some reason. One display case catches your eye,
                                    it is full of ancient Pokémon cards in protective cases. Even in the far future of 2548,
                                    everybody knows what Pokémon is.
                                    Connected to rooms via doors to the North and West.""");
        Room room12 = new Room("Screen Room", """
                                    Screens cover the walls and ceiling, showing dozens of different shows, such as your
                                    favourite show 'Flim-Flam the Fabulous', as well as Anime horribly dubbed into Polish.
                                    The room would be quite dark if the power was off, but the many screens light it up.
                                    Connected to rooms via doors to the East and South.""");
        Room room13 = new Room("Utility Closet", """
                                    For some reason, there is a utility closet here. As soon as you entered the room, you
                                    stepped in a bucket of dirty water and knocked over a mop.
                                    Connected to rooms via doors to the North and West.
                                    The door to the West is locked and requires a keycard to enter.""");
        Room room14 = new Room("Engine Room Vestibule", """
                                    This room connects to the Engine Room through the South door and, even from here, the
                                    noise is overwhelmingly loud. Someone has set-up a high-tech PC in the corner on a
                                    floating desk, and next to it is a comfortable-looking chair. On the monitor a game
                                    is running, displaying a pause-menu that says 'Farmville 47'. You recognise the game
                                    because your grandmother always plays it at home.
                                    Connected to rooms via doors to the East, West, and South.""",true);
        Room room15 = new Room("The Empty Room", """
                                    This room is disconcertingly-empty. It is as if all the furniture and whatever-else
                                    might have been within was simply stripped away, leaving not a trace behind.
                                    Connected to rooms via doors to the East, West, and North.
                                    The door to the West is locked and requires a keycard.
                                    The door to the East has a vocal pass-phrase scanner and seems to require a specific
                                    password to open."""); //found in room9

        // Bottom section
        Room room16 = new Room("Room 16", "");
        Room room17 = new Room("Room 17", "");
        Room room18 = new Room("Room 18", "");
        Room room19 = new Room("Room 19", "");
        Room room20 = new Room("Room 20", "");
                                    //items: Keycard to room30
        room20.addItemToRoom(new Keycard("Bridge Keycard","Keycard","Grants access to " +
                                                  "the Bridge of Discovery Vessel 'Hildebrand' to the North.",
                "A keycard that reads 'Bridge' on it.","Room 30"));

        Room room21 = new Room("Room 21", "");

        // Top section
        Room room22 = new Room("Pile of machines and computers", """
                                    There are unused computers and cables everywhere in the room.
                                    Some of them which is turned on, and some cables are shaking among the computers.
                                    One of the computer screen shows a login screen.
                                    A wild Edward Wong emerges from the pile of machines,
                                    'AWESOME! So many Computer machines!!', 'I am going to hack the Space Ship for fun!!'
                                    Connected to rooms via doors to the North and West.""");
                                    /*additional information can be accessed by typing in the right password
                                    When you open the computer with a password, Edward going wild and attack you because
                                    she wants to use that. Weak enemy. */
        Room room23 = new Room("Room 23", """
                                    """);
        Room room24 = new Room("Room 24", """
                                    """);
        Room room25 = new Room("The Space Bar", """
                                    The room reeks of smoke from cigarettes and alcohols like vodka, gin and rum.
                                    The barterner is cleaning the glasses for the bar.
                                    He is looking at you as if you want to order something.
                                    Spike Spiegel is sitting by the bar and smokes cigarette while talking to Faye Valentine
                                    about love,
                                    but Faye is ignoring him and drinking like there is no tomorrow.""");
                                    //If take the alcohol the player would be unable to move for some time.
        Room room26 = new Room("Hallway", """
                                    The hallway is just a ordinary room but there are some people speaking high tone nearby.
                                    Rei and Asuka are discussing and arguing with each other about something, Shinji is
                                    trying to calm them down.
                                    They're in their plugsuits getting ready for piloting the Evangelions.""");
        Room room27 = new Room("Room 27", """
                                    """);
        Room room28 = new Room("Room 28", """
                                    """);
        Room room29 = new Room("Room 29", """
                                    """);
        Room room30 = new Room("Room 30", """
                                    Showcase with Darth Vader mask and his red lightsaber
                                    """,true);
        Room room31 = new Room("Captain Space Nemo's Office", """
                                    The room reeks of refined flowers on an office table with a picture of the Captain's grandmother.
                                    The grandmother looks like some on 150 years, she could use some wrinkle cream.
                                    There are portraits of family by the Captain. Those are some ugly kids!
                                    A cupboard full of gine glasses and alcohol. The computer on the table is turned on and shows a login screen.""");
                                    // Password til computeren er i computeren hos Edward i room22.
        Room room32 = new Room("Room 32", """
                                    """);
        Room room33 = new Room("Stinky Locked Toilets", """
                                    The room reeks awful with effluvia on the floor.
                                    An alien maid is scrubbing the floor and complaining about how some mad doctor did that.
                                    The toilets are locked with a sign that says
                                    'The toilets were destroyed by a mad doctor, Dr. Fluke Hawkins.'""");
        Room room34 = new Room("The Command Deck", """
                                    There is a reeeeally big window to the outer space,
                                    You can see some killer klowns are raging in war with the martians with googly eyes 
                                    and featuring their brains in glass helmets on some asteroids.
                                    The bridge is filled with weapons-control officer and their subordinates, and a 
                                    communications technician.
                                    Captain Space Nemo is focused on observing the bridge.
                                    He pays no mind to you since you're a nobody who has no meaning in the whole space.""",true);

        // Outer Rooms
        Room room35 = new Room("West Airlock", """
                                     Entrance into 'Discovery Vessel Hildebrand'.
                                     Someone has made a lewd piece of graffiti on the wall, which depicts the Captain and
                                     a Xenomorph french-kissing passionately. Taped to the wall is a keycard that reads
                                     'Navigator Quarters' on it.
                                     Connected to the Discovery Vessel via a door to the East."""+
                                     "\nYou could leave out the docking port to the West, but it would "+
                                     Colours.RED+"kill"+Colours.GREEN_BOLD+" you.");
                                     //items: Keycard to room53
        room35.addItemToRoom(new Keycard("Navigator Quarters Keycard","Keycard","Grants access to " +
                                                  "the Navigator Quarters to the North.",
                "A keycard that reads 'Navigator Quarters' on it.","Navigator Quarters"));
        Room room36 = new Room("Engine Crew Quarters A", """
                                     One enormous bed covers half the room, and on the bed are twelve separate pillows
                                     and duvets. It seems as though the Engine Crew used to snuggle when they slept here.
                                     Connected to a room via a door to the South.""");
        Room room37 = new Room("Engine Crew Quarters A", """
                                     A large table takes up most of the room. Nearby is a bunsen-burner with a cooking
                                     pot on top of it and the remains of a stew inside it. On the central table are cards
                                     and it looks as though whatever game was being played was abandoned in a hurry.
                                     The bets lie in a pile in the middle of the table, and you notice a shiny flashlight.
                                     Connected to rooms via doors to the East and North.""",true);
                                     //items: Flashlight
        Item flashlight = new MeleeWeapon("Flashlight","Tool","A shiny flashlight that looks " +
                                     "very expensive. As you look closer, you realise it is made of polished silver.",
                "A shiny flashlight.", 1);
        room37.addItemToRoom(flashlight);
        Room room38 = new Room("Crew Quarters A", """
                                     The smell of burnt meat, as well as copious amount of smoke, fills the air and you
                                     see that the source is a BBQ grill that someone has left unattended. Red solo cups
                                     that smell of beer are scattered across the room, but there is no alcohol left for
                                     you. It seems that a party might have been underway before the party-goers suddenly
                                     left the Crew Quarters.
                                     Connected to rooms via doors to the West and South.""");
                                     //items: Red Solo Cup (empty)
        room38.addItemToRoom(new Item("Red Solo Cup (empty)","Container","This cup smells of beer, " +
                                           "but it is now empty. It could probably be filled with something else.",
                "An empty red solo cup."));
        Room room39 = new Room("Vandalised Crew Quarters A", """
                                     The vandal from previous rooms has seemingly been in here as well, as the lights have
                                     been torn out of their sockets. There is also a battle-droid lying in several pieces
                                     all over the bunkbeds and floor. A clown-face has been graffitied onto its face-plate.
                                     Connected to a room via the door to the North.""",false,false);
        Room room40 = new Room("Crew Quarters B", """
                                     A small stovetop that seems to never have been used and microwave with a sparking
                                     power supply stand on a table in the corner. Next to it is an open fridge. Beer
                                     bottles lie discarded on the ground, as well as several meal-trays.
                                     Connected to rooms via doors to the West and South.""",false,false);
                                     //items: Beer Bottle (empty) | Meal-Tray Leftovers
        room40.addItemToRoom(new Item("Beer Bottle (empty)","Container","This bottle smells of beer, " +
                                                  "but it is now empty. It could probably be filled with something else.",
                                 "An empty beer bottle."));
        room40.addItemToRoom(new Food("Meal-Tray Leftovers","Consumable","Leftovers from a meal-tray.",
                                "A Meal-Tray with some leftovers inside.",20));
        Room room41 = new Room("Crew Quarters B", """
                                     Six bunkbeds line the room, three along each of the two walls. Between the bunks is
                                     a mess of dirty clothes, empty bottles, and half-eaten meal-trays. Mould covers the
                                     backwall and there are a few mushrooms sprouting from a pair of socks. Next to the
                                     socks lies a keycard that reads 'Engine Crew Quarters A'.
                                     Connected to a room via a door to the North.""",false,false);
                                     //items: Keycard to room37 | Nasty Sock-Mushrooms (poisoned)
        room41.addItemToRoom(new Keycard("Engine Crew Quarters Keycard","Keycard","Grants access to " +
                                                  "the Engine Crew Quarters to the South.",
                "A keycard that reads 'Engine Crew Quarters A'.","Engine Crew Quarters A"));
        room41.addItemToRoom(new Food("Nasty Sock-Mushrooms","Consumable","Why would you pick this up? " +
                                                  "It is clearly bad for you...", "Mushrooms sprouting from a sock.",
                                                  -100));
        Room room42 = new Room("Engine Crew Quarters B", """
                                     Several machines are playing synth music formed from many differently-pitched beeps
                                     and a massive totem of machine parts stands along the backwall, and it seems to have
                                     an offering bowl in front of it. Within the bowl are light-bulbs, cables, and a keycard
                                     that reads 'Hallway to Crew Quarters'.
                                     Connected to a room via a door to the South.""");
                                     //items: Keycard to room7
        room42.addItemToRoom(new Keycard("Hallway Keycard","Keycard","Grants access to " +
                                                  "the locked hallway near the Crew Quarters to the North.",
                "A keycard that reads 'Hallway to Crew Quarters'.","Dirty Hallway"));
        Room room43 = new Room("Engine Crew Quarters B", """
                                     Three cleaner bots shuffle around on the floor, each of them with a knife taped in front
                                     of it and a balloon on its back. Credsticks a piled on a nearby table and it seemed
                                     the engineers might have been betting on which of the cleaner bots would be the last
                                     with balloons on it. You have no idea how long the bots have been at it, but no winner
                                     has yet to emerge.
                                     Connected to rooms via doors to the North and West.""");
        Room room44 = new Room("Room 44", "");
        Room room45 = new Room("Room 45", "");
        Room room46 = new Room("Room 46", "");
        Room room47 = new Room("Room 47", "");
        Room room48 = new Room("Room 48", "");
        Room room49 = new Room("Room 49", "");
        Room room50 = new Room("Captain's Quarters", "");
        Room room51 = new Room("Captain's Quarters", "");
        Room room52 = new Room("Captain's Quarters", "");
        Room room53 = new Room("Navigator Quarters", "",true);
        Room room54 = new Room("Navigator Quarters", "");
        Room room55 = new Room("Navigator Quarters", "");
                                     //items: Keycard to room34(goal)
        room55.addItemToRoom(new Keycard("Command Deck Keycard","Keycard","Grants access to " +
                "the Command Deck to the North.","","The Command Deck"));

        //--------------------------------------------------------------
        // Room Connections

        // Middle section
        room0.setNeighbours(null, null, room1, outerSpace);
        room1.setNeighbours(room4, room10, room2, room0);
        room2.setNeighbours(null, room11, null, room1);
        room3.setNeighbours(room6, null, room35, null);
        room4.setNeighbours(room7, room1, room5, null);
        room5.setNeighbours(null, null, room6, room4);
        room6.setNeighbours(null, room3, null, room5);
        room7.setNeighbours(null, room4, room8, room40);
        room8.setNeighbours(null, null, room9, room7);
        room9.setNeighbours(room24, null, room38, room8);
        room10.setNeighbours(room1, room13, null, null);
        room11.setNeighbours(room2, null, room12, null);
        room12.setNeighbours(null, room15, null, room11);
        room13.setNeighbours(room10, null, room14, room43);
        room14.setNeighbours(null, room17, room15, room13);
        room15.setNeighbours(room12, null, room37, room14);

        // Bottom section
        room16.setNeighbours(null, room19, room17, null);
        room17.setNeighbours(room14, null, room18, room16);
        room18.setNeighbours(null, room21, null, room17);
        room19.setNeighbours(room16, null, room20, room46);
        room20.setNeighbours(null, null, room21, room19);
        room21.setNeighbours(room18, null, room47, room20);

        // Top section
        room22.setNeighbours(room25, null, room23, null);
        room23.setNeighbours(room26, null, room24, room22);
        room24.setNeighbours(null, room9, null, room23);
        room25.setNeighbours(null, room22, null, room53);
        room26.setNeighbours(null, room23, room27, null);
        room27.setNeighbours(room30, null, room52, room26);
        room28.setNeighbours(room31, null, room29, null);
        room29.setNeighbours(null, null, room30, room28);
        room30.setNeighbours(room33, room27, null, room29);
        room31.setNeighbours(null, room28, room32, null);
        room32.setNeighbours(room34, null, null, room31);
        room33.setNeighbours(null, room30, null, null);

        // Outer Rooms
        room35.setNeighbours(null, null, outerSpace, room3);
        room36.setNeighbours(null, room37, null, null);
        room37.setNeighbours(null, null, null, room15);
        room38.setNeighbours(null, room39, null, room9);
        room39.setNeighbours(room38, null, null, null);
        room40.setNeighbours(null, room41, room7, null);
        room41.setNeighbours(room40, null, null, null);
        room42.setNeighbours(null, room43, null, null);
        room43.setNeighbours(room42, null, room13, null);
        room44.setNeighbours(null, null, null, room45);
        room45.setNeighbours(room44, room46, null, null);
        room46.setNeighbours(null, null, room19, room45);
        room47.setNeighbours(null, null, room48, room21);
        room48.setNeighbours(room49, room47, null, null);
        room49.setNeighbours(null, null, room48, null);
        room50.setNeighbours(null, null, room51, null);
        room51.setNeighbours(room52, room50, null, null);
        room52.setNeighbours(null, null, room51, room27);
        room53.setNeighbours(null, null, room25, room54);
        room54.setNeighbours(room53, room55, null, null);
        room55.setNeighbours(null, null, null, room54);

        //--------------------------------------------------------------
        // Room items

        Item testItem = new Item("Test Item","Test Item","This is a test item",
                "A pixellated JPG that says '404'.");
        Keycard testKeycard1 = new Keycard("Test Keycard 1","Dummy Keycard","This is a test object.",
                "A pixellated Keycard that says 'Room -1.","Room -1'");
        Keycard testKeycard2 = new Keycard("Test Keycard 2","Dummy Keycard","This is a test object.",
                "A pixellated Keycard that says 'Room -2.","Room -2'");
        Weapon testRangedWeapon = new RangedWeapon("Test Gun","Ranged Weapon","This is a test gun.",
                "A square box missing textures.",2);
        Weapon testMeleeWeapon = new MeleeWeapon("Test Blade","Melee Weapon","This is a test blade.",
                "A stick. Like, literally just a stick.",1);

        room0.addItemToRoom(testItem);
        room0.addItemToRoom(testKeycard1);
        room0.addItemToRoom(testKeycard2);
        room0.addItemToRoom(testRangedWeapon);
        room0.addItemToRoom(testMeleeWeapon);
        room0.addItemToRoom(flashlight);

        // Start Room
        current = room0;
        roomToTeleportTo = room20;
    }

    public Room starterRoom() {
        return current;
    }

    public Room teleportRoom(){
        return roomToTeleportTo;
    }
}
