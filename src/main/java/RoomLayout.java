


public class RoomLayout {

    private Room current;

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
        Room room4 = new Room("Motivational Hallway", """
                                    Motivational posters line the walls of the hallway. Your eye stops on a picture of
                                    a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'
                                    Connected to rooms via doors to the North and West.
                                    The door to the North is locked and requires a keycard to enter.""");
                                    //items: Motivational Poster
        Room room5 = new Room("Suspiciously-narrow Hallway", """
                                    The hallway is so narrow that you would have to crawl to get through. On the floor is
                                    a well-crafted origami unicorn.
                                    Connected to rooms via doors to the East and West.""");
                                    //items: Origami Unicorn
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
        Room room16 = new Room("Food storage", """
                The room is filled with freezers, coolers and cupboards most are open and serverely damaged,
                this food storage has been emptied by creatures foraging for sustenance, only food left is rotten,
                on the wall someone have graffitied 'THE CAKE IS A LIE', a kitchen knife is on the floor and a flashlight 
                is at the bottom of a freezer. 
                Connected via doors to the West and South.""");
        Room room17 = new Room("Hallway",
                """
                        You see a lit up hallway, with artwork hanging on the wall, you attention get caught be a
                        painting of an oldschool warrior with the quote 'i used to be an adventurer like you'.
                        Connected to rooms via doors to the North, East and West""");
        Room room18 = new Room("Communication room", """
                A room filled with computer screens giving 'coomunication unavailable' message, an old message is being
                replayed over and over again 'All your base are belong to us' maybe it explains what happened on this vessel.
                A notepad is on the table, besides a package of dehydrated fruits.
                Connected to rooms via East and South.""");
        Room room19 = new Room("Power station", """
                A dimly lit room with a red light blinking, seems to be running on backup energy, Huge generators are
                striking sparks, the floor is wet with thick liquid looking poisonous if you didn't have your spacesuit,
                maybe theres a way to restart the generators?
                Connected to rooms via North and West."""); // You must construct additional pillons will appear when trying to restart generators
        Room room20 = new Room("Security room", """
                A room full of folders and security screens, only few screens are still working, revaeling empty hallways,
                most drawers in the room are empty, the ones with items in them contains a keycard and a bottle of soda
                named nuke cola.
                Connected to rooms via West and East.""");
                                    //items: Keycard to room30
        Room room21 = new Room("Weaponry", """
                This is a room full of lockers torn open, and have a few rounds of ammunition scattered around the tables
                and a small container of pills the brand names 'Pills Here'.
                Only weapons left are nonfunctioning rifles, drained from plasma, it seems like a bigger fight have taken
                place in this room.
                Connected to rooms via doors North and East.""");

        // Top section
        Room room22 = new Room("Pile of machines and computers", """
                                    Connected to rooms via doors to the North and West.
                                    There are unused computers and cables everywhere in the room.
                                    Some of them are already turned on, one of the computer screen shows a login screen.
                                    The pile of cables are shaking among the computers.
                                    \033[1;33mA wild Edward Wong emerges from the pile of machines\033[0m
                                    \033[0;36m''So many computer machines!! AWESOME!''
                                    ''I am going to hack the Space Ship for fun!!''\033[0m
                                    \033[0;32mConnected to rooms via doors North and West.\033[0m""");
                                    /*additional information on a password to the Captain's computer can be accessed by typing in the right password.
                                    When you open the computer with a password, Edward goes wild and attacks you because she wants to use that. Weak enemy. */
        Room room23 = new Room("Training center", """
                                    There are workout stuffs in here and some are pumping their muscles and drink their proteins.
                                    Buggy Bunny are playing basketball with Daffy Duck and the others, Michael Jordan is there as well.
                                    Lola Bunny is drinking water, the water is running down her throat wetting her shirt, she had a nice workout with the basketball guys.
                                    YoRHa No.2 Type B is training her legs with the leg curl, her ass is .... wow can you imagine that?
                                    Samus Aran from Metroid is pumping her arms, she's sweating and hot.
                                    Neo and Morpheus is training to dodge each other in a martial arts fight.
                                    Connected to rooms via doors North, West and East.""");
                                    //If the player choose to train here, gains str++
        Room room24 = new Room("Refreshment Stand", """
                                    That is a shop for selling drinking stuffs and snacks for the ones that goes in the training center.
                                    There is a bench by the stand, an AI robot David and E-Wall is sitting there and have fun talking to each other.
                                    Some Wookies are screaming out of joy because the drinks are delicious.
                                    Trinity is standing by the stand and is buying something for the guys in the training center.
                                    Connected to rooms via doors South and East.""");
                                    // Drinks (Healing potions) can be purchased here.
        Room room25 = new Room("The Space Bar", """
                                    The room reeks of smoke from cigarettes and alcohols like vodka, gin and rum.
                                    The barterner is cleaning the glasses for the bar.
                                    He noticed you as if he knows you want to order something.
                                    Spike Spiegel is sitting by the bar and smokes cigarette.
                                    He is talking to Faye Valentine about love,
                                    but Faye is ignoring him and drinking like there is no tomorrow.
                                    Connected to rooms via doors South.""");
                                    //If the player takes the alcohol the player would be unable to move for some time. (Just a idea, how to do that?)
        Room room26 = new Room("Hallway", """
                                    The hallway is just a ordinary room but there are some people speaking in high tone nearby.
                                    Rei and Asuka are discussing and arguing with each other about something, Shinji is
                                    trying to calm them down.
                                    They're in their plugsuits getting ready for piloting the Evangelions.
                                    Connected to rooms via doors West and South.""");
                                    // knockout the player if trying to seduce the girls or Shinji (for girls to enjoy)
        Room room27 = new Room("Dexter's laboratory in the space", """
                                    That is a big laboratory here. There are experiment table and a lot of computer screens that show a observation.
                                    The observation on the screen shows experiments on Predators, Aliens, Martians, Klowns, E.T..
                                    Three of them show three different games, Pac-man, Bombman and Pokemon Red & Blue.
                                    Dexter, Rick Sanchez, Professor Charles Xavier and Dr. Fluke Hawkins are discussing about a science project.
                                    Dr. Zoidberg is screaming as he's being held hostage by some weird tentacles.
                                    Connected to rooms via doors North and East.""");
                                    // if the player helps Dr. Zoidberg, the player would get a weapon by the doctor.
        Room room28 = new Room("Office entrance with guards", """
                                    There are guards by the door to the Captain's office.
                                    Nothing aside these guards are in the room.
                                    Connected to rooms via doors North and West.""");
                                    //Guards attacks you if they suspected you for having access into the computer.
        Room room29 = new Room("Big Hallway", """
                                    There are three way around you, there are guards everywhere and they're patrolling around.
                                    Buzz Lightyear is ordering some Stormtroppers to do as he says.
                                    \033[0;36m''DO WHAT I SAID!! STAND UP AND GIVE ME A 'YES'!'' the soldiers roars ''YES SIR!!''\033[0m
                                    \033[0;32mAt a bench to the south the Jetsons family are sitting and eat their picnic basket.
                                    Connected to rooms via doors North, West and East.""");
                                    // If ask the Jetsons about they're having fun, they would offer you food.
        Room room30 = new Room("Weapon gallery", """
                                    Gallery with different lightsabers, and other Sci-Fi weapon.
                                    Ratchet and Clank are discussing what to use for their next adventure.
                                    Ellie and Eleven are looking at the weapons. Are they up to something??
                                    Solid Snake and the mens in black are discussing about how to use weapon the most effective way.
                                    Connected to rooms via doors North, South and East.""",true);
                                    // If you're trying to take any weapon, Solid Snake and Mens in Black would attack you.
        Room room31 = new Room("Captain Space Nemo's Office", """
                                    The room reeks of refined flowers on an office table with a picture of the Captain's grandmother.
                                    The grandmother looks like one on their 150s, she could use some wrinkle cream.
                                    There are portraits of family by the Captain. Those are some ugly kids!
                                    A cupboard full of gine glasses and alcohol. The computer on the table is turned on and shows a login screen.
                                    Connected to rooms via doors South.""");
                                    // Password for the captain computer is in the computer on room22.
                                    // If player got access, then the player would get password for the gate between 32 and 34.
        Room room32 = new Room("Bridge Guard Post", """
                                    There are two Terminators guarding the gate for the bridge,
                                    they're aiming at you to be sure you're not up to something.
                                    There is a bench at each wall.
                                    Philip J. Fry is french kissing with Turanga Leela on the west bench.
                                    Bender are flirting with R2D2 on the other bench.
                                    Connected to rooms via doors South.""");
                                    //The player would get a password for the computer in Room22 from Bender if asked.
                                    // instant death if trying to be under suspicion. If the player dies then the body is shattered everywhere.
        Room room33 = new Room("Stinky Locked Toilets", """
                                    The room reeks awful with effluvia from the toilets on the floor.
                                    An alien maid is scrubbing the floor and complaining about how some mad doctor did that.
                                    The toilets are locked with a sign that says
                                    \033[1;36m'The toilets were destroyed by a mad doctor, Dr. Fluke Hawkins.'
                                    \033[0;32mConnected to rooms via doors South.""");
                                    // lost 1 hp every sec while standing in the room. PANIC!
        Room room34 = new Room("The Command Deck", """
                                    There is a reeeeally big window to the outer space,
                                    You can see some killer klowns are raging in war with the martians with googly eyes
                                    and featuring their brains in glass helmets on some asteroids.
                                    The bridge is filled with weapons-control officer and their subordinates,
                                    and a communications technician.
                                    Captain Space Nemo is focused on observing the bridge.
                                    He pays no mind to you since you're a nobody who has no meaning in the whole space.
                                    Feels bad for you.
                                    Connected to rooms via doors South.""",true);
                                    // Guess quest completed here?
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
        Room room38 = new Room("Crew Quarters A", """
                                     The smell of burnt meat, as well as copious amount of smoke, fills the air and you
                                     see that the source is a BBQ grill that someone has left unattended. Red solo cups
                                     that smell of beer are scattered across the room, but there is no alcohol left for
                                     you. It seems that a party might have been underway before the party-goers suddenly
                                     left the Crew Quarters.
                                     Connected to rooms via doors to the West and South.""");
                                     //items: Red Solo Cup (empty)
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
                                     //items: Beer Bottle (empty)
        Room room41 = new Room("Crew Quarters B", """
                                     Six bunkbeds line the room, three along each of the two walls. Between the bunks is
                                     a mess of dirty clothes, empty bottles, and half-eaten meal-trays. Mould covers the
                                     backwall and there are a few mushrooms sprouting from a pair of socks. Next to the
                                     socks lies a keycard that reads 'Engine Crew Quarters A'.
                                     Connected to a room via a door to the North.""",false,false);
                                     //items: Keycard to room37 | Nasty Sock-Mushrooms (poisoned)
        Room room42 = new Room("Engine Crew Quarters B", """
                                     Several machines are playing synth music formed from many differently-pitched beeps
                                     and a massive totem of machine parts stands along the backwall, and it seems to have
                                     an offering bowl in front of it. Within the bowl are light-bulbs, cables, and a keycard
                                     that reads 'Hallway to Crew Quarters'.
                                     Connected to a room via a door to the South.""");
                                     //items: Keycard to room7
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

        //--------------------------------------------------------------
        // Room Connections (North, South, West, East)

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
        room29.setNeighbours(room32, null, room30, room28);
        room30.setNeighbours(room33, room27, null, room29);
        room31.setNeighbours(null, room28, null, null);
        room32.setNeighbours(room34, room29, null, null);
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

        // Start Room
        current = room0;
    }

    public Room starterRoom() {
        return current;
    }
}
