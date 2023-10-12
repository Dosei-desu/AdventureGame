package common;

import items.*;
import ui.Colours;

public class Map {
    //very long list of all standard rooms
    //i made them all global objects, such that I can handle them outside the "buildMap()" method in order to do more
    //interesting things, such as allowing patrolling enemies and whatnot
    private Room room0, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12, room13,
            room14, room15, room16, room17, room18, room19, room20, room21, room22, room23, room24, room25, room26, room27,
            room28, room29, room30, room31, room32, room33, room34, room35, room36, room37, room38, room39, room40, room41,
            room42, room43, room44, room45, room46, room47, room48, room49, room50, room51, room52, room53, room54, room55;

    //unique rooms
    private Room outerSpace; //technically any place that is outside the boundaries of the spaceship
    private Room startRoom;
    private Room roomToTeleportTo; //currently just used for implementation testing of room features
    //unique enemies
    private Enemy mechHound = new Enemy("Mech-Hound 'Nibbles'", "An imposing canine mech " +
            "that lets out a synthesised growl that makes the\nfloor shake. It seems to be guarding the Engine area of" +
            " the Discovery Vessel. It has blood on its claws\nand sharp-toothed maw.", 60,
            new MeleeWeapon("Nibbles' Claws", "Weapon", "Deadly flensing claws.",
                    "The front claws of the Mech-Hound named 'Nibbles'. They look like they could" +
                            " easily cut through steel.", 8, 15));
    private boolean turnAroundSpiderBot;
    private Enemy spiderBot = new Enemy("Experimental Spider Bot", "A creepy metallic ball supported on" +
            " five spiky legs with a large glowing eye in its centre.\nIt seems to be patrolling the area outside of the command" +
            " deck, as though looking for something or someone.", 40,
            new RangedWeapon("Spider Bot Eye", "Laser Eye", "The eye torn from the Experimental" +
                    " Spider Bot. By tapping the wires\ntogether, you might be able to fire it. Once.",
                    "The Eye of the Experimental Spider Bot", 1, 22));

    public void buildMap() {
        // Rooms

        // Outside ship
        outerSpace = new Room("Outer Space",
                "You ejected yourself into the space and died.");

        // Middle section
        room0 = new Room("East Airlock", """
                Entrance into 'Discovery Vessel Hildebrand'.
                Connected to the Discovery Vessel via a door to the West.""" +
                "\nYou could leave out the docking port to the East, but it would " +
                Colours.RED + "kill" + Colours.GREEN_BOLD + " you.");
        //enemies: Welcome Droid 'Kass'
        //look closer event
        room1 = new Room("East Vestibule", """
                Spacesuits and oxygen tanks hang from the walls. The smell of ozone is strong here, but at least the air-
                filtration systems aboard the vessel seem to function, as you feel a slight breeze of stagnant air brush
                over your skin.
                Connected to rooms via three doors to the North, West, and South.
                Connected to an Airlock to the East.""");
        room2 = new Room("Memorial Room", """ 
                A large support column stands in the centre of the room, and along the walls are
                memorials to a mutiny that happened long ago, with epitaphs and pictures of marines.
                Connected to rooms via two doors to the East and South.
                There used to be a doorway to the West, but it has been permanently welded shut.""");
        room3 = new Room("West Vestibule", """
                For some reason there is a broken urinal next to rows of spacesuits and oxygen tanks.
                A note above the urinal states: 'Goddamn Dr. Fluke Hawkins and his experiments!'
                Under the broken urinal lies a filthy keycard with the words 'Engine Room' on it.
                Connected to a room via a door to the North.
                Connected to an Airlock to the West.""");
        //items: Keycard to room14
        room4 = new Room("Motivational Hallway", """
                Motivational posters line the walls of the hallway. Your eye stops on a picture of
                a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'
                Connected to rooms via doors to the North and West.
                The door to the North is locked and requires a keycard to enter.""");
        //items: Motivational Poster
        room5 = new Room("Suspiciously-narrow Hallway", """
                The hallway is so narrow that you would have to crawl to get through. On the floor is
                a well-crafted origami unicorn.
                Connected to rooms via doors to the East and West.""");
        //items: Origami Unicorn
        room6 = new Room("Origami Room", """
                The floor is absolutely littered with origami animals of all shapes and sizes and
                colours. One of the pieces is so tall that it touches the ceiling and it depicts a
                giraffe. One piece is so tiny that you would need a microscope to tell what animal it
                depicts. Many of the pieces resemble a unicorn.
                Connected to rooms via doors to the East and South.""");
        room7 = new Room("Dirty Hallway", """
                The lights in this dirty hallway are flickering ominously. Meal-trays lay discarded
                all over the place and the smell of rotten Synthmeat fill the air.
                Connected to rooms via doors to the West, South, and East.
                The door to the East lead to darkness, but a sign above the doorway reads 'Crew
                Quarters B'.""", true);
        room8 = new Room("Vandalised Hallway", """
                Some hooligan has smashed the lights and drawn a lewd image of the Emperor of Man
                cuddling with two very muscular green-skinned orcs.
                Connected to rooms via doors to the East and West.""", false, false);
        room9 = new Room("Vandalised Common Room", """
                All the lights in the room have been smashed and graffiti covers the walls and even
                the ceiling. Most of the graffiti are lewd acts performed by either the Captain of the
                Discover Vessel, the Emperor of Man, or other important figures. Couches and bookshelves
                are scattered across the room, and there is even a mini-fridge full of beer, although
                all the bottles are empty.
                Connected to rooms via doors to the North, East, and West.""", false, false);
        //items: Beer Bottle (empty)
        //look closer event: contains the password to special door from room15 to room14
        room10 = new Room("Hallway of Mirrors", """
                Highly-reflective mirrors cover every inch of the hallway, making it very disorienting
                to walk through. At first you believe there are twelve doors, but it turns out there
                are in fact only two.
                Connected to rooms via doors to the North and South.""");
        room11 = new Room("Trophy Room", """
                Trophies sit in display cases all over the room. There are signed baseballs, footballs,
                and even a signed computer mouse, for some reason. One display case catches your eye,
                it is full of ancient Pokémon cards in protective cases. Even in the far future of 2548,
                everybody knows what Pokémon is.
                Connected to rooms via doors to the North and West.""");
        room12 = new Room("Screen Room", """
                Screens cover the walls and ceiling, showing dozens of different shows, such as your
                favourite show 'Flim-Flam the Fabulous', as well as Anime horribly dubbed into Polish.
                The room would be quite dark if the power was off, but the many screens light it up.
                Connected to rooms via doors to the East and South.""");
        room13 = new Room("Utility Closet", """
                For some reason, there is a utility closet here. As soon as you entered the room, you
                stepped in a bucket of dirty water and knocked over a mop.
                Connected to rooms via doors to the North and West.
                The door to the West is locked and requires a keycard to enter.""");
        room14 = new Room("Engine Room Vestibule", """
                This room connects to the Engine Room through the South door and, even from here, the
                noise is overwhelmingly loud. Someone has set-up a high-tech PC in the corner on a
                floating desk, and next to it is a comfortable-looking chair. On the monitor a game
                is running, displaying a pause-menu that says 'Farmville 47'. You recognise the game
                because your grandmother always plays it at home.
                Connected to rooms via doors to the East, West, and South.""", true);
        room15 = new Room("The Empty Room", """
                This room is disconcertingly-empty. It is as if all the furniture and whatever-else
                might have been within was simply stripped away, leaving not a trace behind.
                Connected to rooms via doors to the East, West, and North.
                The door to the West is locked and requires a keycard.
                The door to the East has a vocal pass-phrase scanner and seems to require a specific
                password to open."""); //found in room9

        // Bottom section
        //Patrolling Enemy: Mech-Hound (rooms 16-21)
        room16 = new Room("Server Room", """
                Server banks line the walls and there are terminals here, although they are inaccessible
                since the power to this entire area is switched off. It seems that calculations for FTL
                jumps might have been handled here. There is a lab-coat draped across a chair with a name-
                tag that says 'Nigel'.
                Connected to rooms via doors to the South and West.""", false, false);
        //items: Nigel's Lab-coat (junk)
        room17 = new Room("Engine Room Hallway", """
                The first thing you notice is that the power is off to this part of the ship. Near the doorway
                to the Vestibule out the North lays a ruined Mech-Hound. It is difficult to determine what
                destroyed the Mech, but it has been torn to pierces by something very sharp. You might be able
                to scavenge something from its remains.
                Connected to rooms via doors to the North, East, and West.""", false, false);
        //weapon: Mech-Hound Leg (improvised weapon)
        room18 = new Room("Engineer Break-Room", """
                A cozy break-room with two tables, with a Monopoly game on the larger of the two and a Regicide
                board on the smaller one. Like everywhere else, the fridges and cupboards have been thoroughly
                raided. However, there is a Caffeine Brewer that somehow seems functional, despite the power to
                the entire area being off.
                Connected to rooms via doors to the South and East.""", false, false);
        //look closer event : You could probably fill up a container with the caffeine brew from this
        //unique use event : can fill up empty beer bottle making the strongest damage item in the game
        room19 = new Room("Engine Bay C", """
                Large cables and hoses connect from the southern wall to various plugs in the ceiling and floor.
                During normal ship activity, these would supply electricity and fuel to the thrusters that propel
                the Discovery Vessel through the darkness of space. There are large gouges in the floor, seeming to
                indicate that something regularly walks through this corridor. A sign over the West doorway reads
                'Hydroponics Lab'.
                Connected to rooms via doors to the North, East, and West.""", false, false);
        room20 = new Room("Engine Bay B", """
                The cables and hoses that should have connected the thrusters through the southern wall have been
                torn apart or disconnected, lying in a disarray on the floor. Large gouges in the floor suggests that
                something regularly walks through here. There is a large rust-red dried stain on the floor and the
                remains of someone's trousers, with a pocket from which the corner a Keycard is visible.
                Connected to rooms via doors to the East, and West.""", false, false);
        //items: Keycard to room30
        room21 = new Room("Engine Bay A", """
                The entire room is a mess of burn-scars on the metallic walls, torn cables and hoses, and large rust-
                red dried stains. It seems as though this room had a fierce battle take place within it at some point
                however, there are no bodies to prove who took part in it nor who won. A sign over the East doorway
                reads 'Experimental R&D'.
                Connected to rooms via doors to the North, East, and West.""", false, false);

        // Top section
        //----- Patrolling enemy (rooms 22-27, excluding 24): Experimental Spider Bot
        room22 = new Room("Medical Bay", """
                A room full of the stench of antiseptics and with eight beds lining the wall in a row. There is a Surgery-
                Assistant Robot, but it has been destroyed with several blasts of a laser. You were hoping to raid the stash
                of healing items in here, but someone get there before you, leaving just a single Medipen in the centre of
                the room.
                Connected to rooms via doors to the North and West.""");
        //items: medipen (heal item)
        //trap: motion sensor trap
        room23 = new Room("Canteen", """
                Long picnic tables line the room and there is a buffet counter where, in theory, people could take a plate
                and end up with a filling, albeit disappointing, meal. However, the buffet has been thoroughly raided and
                only a tiny scrap of potato salad is left. There are marks on the floor that seem to suggest something often
                enters the room and walks through, as though on a patrol.
                Connected to rooms via doors to the North, East, and West.""");
        //items: Potato Salad Leftovers (food)
        room24 = new Room("Security Checkpoint", """
                Under normal circumstances, a security officer would be checking all the crew-members who visit this part
                of the ship, however, the security door at the far end is open and the officer is not at his post. There
                are two turrets hanging from the ceiling however.
                Connected to rooms via doors to the South and East.""");
        //enemies: two ceiling turrets
        room25 = new Room("Gravity Control", """
                The gravity aboard the vessel is handled here. It thankfully is working automatically, otherwise you would
                be upside down right now. For some reason, all the objects in the room are welded firm. Perhaps there was
                once a disaster when the gravity was switched off and afterwards they took the precaution of keeping every-
                thing grounded. After all, it would be difficult to turn the gravity back on if all the chairs and tables
                were floating about.
                Connected to rooms via doors to the South and East.""");
        room26 = new Room("Astrometrics", """
                The mapping and courses the Discovery Vessel might take seem to have been handled here, as several star-
                charts and diagrams are plastered onto the walls. Parts of the FTL jumps might have been handled here,
                before being sent back to the Engine Rooms. There are marks on the floor, indicating that something often
                comes through here.
                Connected to rooms via doors to the South and West.""");
        room27 = new Room("Oxygen Control", """
                Large filters cycle the air and feed in oxygen from large tanks that fortunately still have oxygen left in
                them, although who knows how long they will last. Without the oxygen you would have to wear your spacesuit,
                which would limit your mobility and hamper exploration. Plus, a tiny leak in your spacesuit in an anaerobic
                environment result in immediate death. That is all to say: do not turn off the oxygen.
                Connected to rooms via doors to the North, East, and West.""");

        room28 = new Room("Communications", """
                                
                Connected to rooms via doors to the North and West.""");
        room29 = new Room("Officer's Lounge", """
                """);
        room30 = new Room("Robotics Workshop", """
                                
                Connected to rooms via doors to the North and West.""", true);
        room31 = new Room("Escape Pods", """
                                
                Connected to rooms via doors to the North and West.""");
        room32 = new Room("Command Deck Vestibule", """
                                
                Connected to rooms via doors to the North and West.""");
        room33 = new Room("Observation Lounge", """
                                
                Connected to rooms via doors to the North and West.""");
        room34 = new Room("Command Deck", """
                                
                Connected to rooms via doors to the North and West.""", true);

        // Outer Rooms
        room35 = new Room("West Airlock", """
                Entrance into 'Discovery Vessel Hildebrand'.
                Someone has made a lewd piece of graffiti on the wall, which depicts the Captain and
                a Xenomorph french-kissing passionately. Taped to the wall is a keycard that reads
                'Navigator's Quarters' on it.
                Connected to the Discovery Vessel via a door to the East.""" +
                "\nYou could leave out the docking port to the West, but it would " +
                Colours.RED + "kill" + Colours.GREEN_BOLD + " you.");
        //items: Keycard to room53
        //enemies: Welcome Droid Hass
        //look closer event
        room36 = new Room("Engine Crew Quarters A", """
                One enormous bed covers half the room, and on the bed are twelve separate pillows
                and duvets. It seems as though the Engine Crew used to snuggle when they slept here.
                Connected to a room via a door to the South.""");
        room37 = new Room("Engine Crew Quarters A", """
                A large table takes up most of the room. Nearby is a bunsen-burner with a cooking
                pot on top of it and the remains of a stew inside it. On the central table are cards
                and it looks as though whatever game was being played was abandoned in a hurry.
                The bets lie in a pile in the middle of the table, and you notice a shiny flashlight.
                Connected to rooms via doors to the East and North.""", true);
        //items: Flashlight
        room38 = new Room("Crew Quarters A", """
                The smell of burnt meat, as well as copious amount of smoke, fills the air and you
                see that the source is a BBQ grill that someone has left unattended. Red solo cups
                that smell of beer are scattered across the room, but there is no alcohol left for
                you. It seems that a party might have been underway before the party-goers suddenly
                left the Crew Quarters.
                Connected to rooms via doors to the West and South.""");
        //items: Red Solo Cup (empty)
        room39 = new Room("Vandalised Crew Quarters A", """
                The vandal from previous rooms has seemingly been in here as well, as the lights have
                been torn out of their sockets. There is also a battle-droid lying in several pieces
                all over the bunkbeds and floor. A clown-face has been graffitied onto its face-plate.
                Connected to a room via the door to the North.""", false, false);
        room40 = new Room("Crew Quarters B", """
                A small stovetop that seems to never have been used and microwave with a sparking
                power supply stand on a table in the corner. Next to it is an open fridge. Beer
                bottles lie discarded on the ground, as well as several meal-trays.
                Connected to rooms via doors to the West and South.""", false, false);
        //items: Beer Bottle (empty) | Meal-Tray Leftovers
        room41 = new Room("Crew Quarters B", """
                Six bunkbeds line the room, three along each of the two walls. Between the bunks is
                a mess of dirty clothes, empty bottles, and half-eaten meal-trays. Mould covers the
                backwall and there are a few mushrooms sprouting from a pair of socks. Next to the
                socks lies a keycard that reads 'Engine Crew Quarters A'.
                Connected to a room via a door to the North.""", false, false);
        //items: Keycard to room37 | Nasty Sock-Mushrooms (poisoned)
        //enemy: Ceiling Turret
        room42 = new Room("Engine Crew Quarters B", """
                Several machines are playing synth music formed from many differently-pitched beeps
                and a massive totem of machine parts stands along the backwall, and it seems to have
                an offering bowl in front of it. Within the bowl are light-bulbs, cables, and a keycard
                that reads 'Hallway to Crew Quarters'.
                Connected to a room via a door to the South.""");
        //items: Keycard to room7
        room43 = new Room("Engine Crew Quarters B", """
                Three cleaner bots shuffle around on the floor, each of them with a knife taped in front
                of it and a balloon on its back. Credsticks a piled on a nearby table and it seemed
                the engineers might have been betting on which of the cleaner bots would be the last
                with balloons on it. You have no idea how long the bots have been at it, but no winner
                has yet to emerge.
                Connected to rooms via doors to the North and West.""");
        //item : Pile of Credsticks worth 350 credits
        room44 = new Room("Experimental R&D Storage", """
                Empty creates, overturned databanks, and other miscellaneous items lay all around. Looters
                have been through here, but they have left two items behind on one of the item racks on the wall.
                Connected to a room via a door to the East.""");
        //items: Darklight (anti flashlight weapon that turns rooms dark) | Nova Ray (one shot weapon with 1 shot)
        room45 = new Room("Experimental R&D Lab", """
                Computers and microscopes and many other specialised tools flood the room and make it hard
                to move around.One of the computers is on and there is a note written on it. For some reason,
                chairs have been welded to the ceiling. Shoved away atop a shelf is a generator that seem to
                be the source of power for the power in this part of the ship.
                Connected to rooms via doors to the North and South.""");
        //look closer : find some password or something
        room46 = new Room("Experimental R&D Common Room", """
                Floating couches and furniture fill the room, and for some reason the power is still on
                in this part of the stern of the Discovery Vessel. The fridges have been raided, but there
                are still some things left in one of them.
                Connected to rooms via doors to the East and West.""");
        //items: Chewy Leaves (food) | Glowing Cheetos (food) | Suspicious Goop (poisoned)
        room47 = new Room("Hydroponics Lab Common Room", """
                Since the power to this area is off and seems to have been off for a while, the fridges
                are full of decayed food, mostly vegetables and fruits, but there are some synth-gummies on
                one of the tables next to some overturned chairs. There's a Caffeine Brewer next to the
                fridges, but a note is plasted on it that says, 'Broken'.
                Connected to rooms via doors to the East and West.""", false, false);
        //items: Green Synth-Gummies (food) | Melted Blue Synth-Gummies (food)
        room48 = new Room("Hydroponics Lab Greenhouse A", """
                Tall plastic boxes run along the walls of the room, but the contents of the boxes are all
                wilted and decayed and mouldy. Murky water is covering the floor and the air is buzzing with
                fat flies. Within a pile of gloopy mulch half a Keycard is visible.
                Connected to rooms via doors to the North and South.""", false, false);
        //items: Keycard to room52
        room49 = new Room("Hydroponics Lab Greenhouse B", """
                You immediately come face-to-face with an enormous Pitcher Plant, from which pokes two skeletal legs. It
                is the first body of the vanished crew you have come across, and unfortunately, as you stare at the plant,
                it swallows the skeleton with a gulp and then seems to look towards you. On the floor, vines suddenly shift,
                before lifting into the air and preparing to attack you.
                Connected to a room via a door to the West.""", false, false);
        //enemies: Giant Pitcher Plant
        room50 = new Room("Captain's Bedroom", """
                An enormous King-sized bed takes up most of the room and several plushies lie next to the fancy pillows,
                however your attention is drawn to the large locker that stands up against the back-wall.
                Connected to a room via a door to the West.""");
        //item : Panda plushie
        //look closer event : the locker requires a passphrase
        room51 = new Room("Captain's Walk-In Closet", """
                A very opulent room with rows-upon-rows of fancy outfits, coats, shoes, and what-have-you. You could take
                some of it with you, but you feel like it would be too heavy with all the jewels and gold sown into the
                fabric. No, you prefer the comfortable feel of your worn bodyglove and decade-old spacesuit.
                Connected to rooms via doors to the North and South.""");
        //trap: a heat-sensor trap and a claymore
        room52 = new Room("Captain's Quarters", """
                If you took a photo from a magazine of what a wealthy person's common looked like and compared it to this
                room, then you would not see any distinctions between the two. It is so utterly lacking in personality and
                takes that your eyes gloss over in boredom.
                Connected to rooms via doors to the East and West.""", true);
        room53 = new Room("Navigator's Quarters", """
                The room is impressively minimalist. Aside from a rusted metallic stool and round table, there is nothing
                of interest inside this room, except for a cleaner bot.
                Connected to rooms via doors to the East and West.""", true);
        //enemies: cleaner bot
        room54 = new Room("Navigator's Prayer Room", """
                This room is full of blueprints and schematics of robots, as well as books about AI and fiction novels about
                the 'Robot Uprising'. Obviously, everyone in the galaxy knows that the robot uprising that had been prophesied
                never actually happened, but you still got some nutjobs worshipping their future 'overlords' like the
                Navigator had clearly done.
                Connected to rooms via doors to the North and South.""");
        //item: robot uprising book
        room55 = new Room("Navigator's Bedroom", """
                There is a hammock attached to the walls with a nail at each end and a pile of sand and lint lies inside it.
                You get the feeling that the Navigator was a very strange person.
                Connected to a room via a door to the East.""", false, false);
        //enemies : sentient pile of sand and lint
        //items: Keycard to room34(goal)

        //--------------------------------------------------------------

        // Make connections, place items, place enemies (separated into methods for easier bug fixing, since there is a
        // lot of info that is otherwise completely unwieldy in one giant list of just "buildMap".
        makeConnections();
        placeItems();
        placeEnemies();
        placeTraps();

        // Start Room
        startRoom = room0;
        roomToTeleportTo = room24;
    }

    public Room starterRoom() {
        return startRoom;
    }

    public Room teleportRoom() {
        return roomToTeleportTo;
    }

    //for placing items
    private void placeItems() {
        room3.addItemToRoom(new Keycard("Engine Room Keycard", "Keycard", "Grants access to " +
                "the Engine Room to the South.", "A filthy keycard with " +
                "the words 'Engine Room' on it.", "Engine Room Vestibule"));
        room4.addItemToRoom(new Item("Motivational Poster", "Junk", "A motivational poster with " +
                "picture of a cute kitten hanging from a cliff, which states, encouragingly, 'Hang in there!'",
                "A poster with a kitten on it that reads 'Hang in there!'.'"));
        room5.addItemToRoom(new Item("Origami Unicorn", "Junk", "A well-crafted origami sculpture " +
                "depicting a unicorn. You are unsure how it is possible to fold something so meticulously.",
                "A well-crafted origami unicorn."));
        room9.addItemToRoom(new Item("Beer Bottle (empty)", "Container", "This bottle smells of beer, " +
                "but it is now empty. It could probably be filled with something else.",
                "An empty beer bottle."));
        room16.addItemToRoom(new Item("Nigel's Lab-coat", "Clothing",
                "A lab-coat with a name-tag that says 'Nigel'. It smells faintly of synth-apples.",
                "A lab-coat."));
        room17.addItemToRoom(new MeleeWeapon("Mech-Hound Leg", "Improvised Club",
                "The back-leg of a Mech-Hound that has been torn from its original body.\nIt might serve as a" +
                        " simple club to bash enemies with.", "The back-leg of a Mech-Hound that might work" +
                " as a club.", 3, 10));
        room20.addItemToRoom(new Keycard("Bridge Keycard", "Keycard", "Grants access to " +
                "the Bridge of Discovery Vessel 'Hildebrand' to the North.",
                "A keycard that reads 'Bridge' on it.", "Room 30"));
        room22.addItemToRoom(new Food("Medipen", "Consumable", "The Medipen is an invention" +
                " that revolutionised the medical profession, by making most doctors obsolete.", "A Medipen.",
                25));
        room23.addItemToRoom(new Food("Potato Salad Leftovers", "Consumable", "Some sad" +
                " remains of what might once have been an 'okay' potato salad.", "Leftovers from the buffet.",
                12));
        room35.addItemToRoom(new Keycard("Navigator's Quarters Keycard", "Keycard", "Grants access to " +
                "the Navigator's Quarters to the North.",
                "A keycard that reads 'Navigator's Quarters' on it.", "Navigator's Quarters"));
        room37.addItemToRoom(new MeleeWeapon("Flashlight", "Tool", "A shiny flashlight that looks " +
                "very expensive. As you look closer, you realise it is made of polished silver.",
                "A shiny flashlight.", 1, 5));
        room38.addItemToRoom(new Item("Red Solo Cup (empty)", "Container", "This cup smells of beer, " +
                "but it is now empty. It could probably be filled with something else.",
                "An empty red solo cup."));
        room40.addItemToRoom(new Item("Beer Bottle (empty)", "Container", "This bottle smells of beer, " +
                "but it is now empty. It could probably be filled with something else.",
                "An empty beer bottle."));
        room40.addItemToRoom(new Food("Meal-Tray Leftovers", "Consumable", "Leftovers from a meal-tray.",
                "A Meal-Tray with some leftovers inside.", 20));
        room41.addItemToRoom(new Keycard("Engine Crew Quarters Keycard", "Keycard", "Grants access to " +
                "the Engine Crew Quarters to the South.",
                "A keycard that reads 'Engine Crew Quarters A'.", "Engine Crew Quarters A"));
        room41.addItemToRoom(new Food("Nasty Sock-Mushrooms", "Consumable", "Why would you pick this up? " +
                "It is clearly bad for you...", "Mushrooms sprouting from a sock.",
                -100));
        room42.addItemToRoom(new Keycard("Hallway Keycard", "Keycard", "Grants access to " +
                "the locked hallway near the Crew Quarters to the North.",
                "A keycard that reads 'Hallway to Crew Quarters'.", "Dirty Hallway"));
        room43.addItemToRoom(new Item("Pile of Credsticks", "Currency", "A pile of Credsticks" +
                " worth 350 Credits. Given rising inflation, it is about enough to buy three synth-apples from a grocer.",
                "A pile of Credsticks."));
        room44.addItemToRoom(new MeleeWeapon("Darklight", "Tool", "A black cylindrical tool" +
                " with an on-off switch on the side.", "A black cylindrical tool.", 1, 5));
        room44.addItemToRoom(new RangedWeapon("Nova Ray", "Experimental Gun",
                "A smooth white banana-shaped gun with a soft trigger and a black bead at its tip that might" +
                        "\nfire some kind of beam. The fact that it has been left behind probably means it is dangerous.",
                "A smooth white banana-shaped experimental gun.", 1, 999));
        room46.addItemToRoom(new Food("Chewy Leaves", "Consumable",
                "Some kind of basil leaves that might have been grown in the hydroponics lab.",
                "Some kind of basil leaves.", 10));
        room46.addItemToRoom(new Food("Glowing Cheetos", "Consumable",
                "An open and half-emptied bag of Cheetos. For some reason the Cheetos glow. It's probably\n" +
                        "safe to eat?", "An opened bag of glowing Cheetos.", 15));
        room46.addItemToRoom(new Food("Suspicious Goop", "Consumable",
                "It looks like cursed mashed potatoes and gives off an earthy smell. It seems to move on its own\n" +
                        "when you prod it with your fingers.", "A mass of goop.", -25));
        room47.addItemToRoom(new Food("Green Synth-Gummies", "Consumable",
                "Some rather tough synth-gummies, which tastes of Green Number 7.", "Stale-looking" +
                " green synth-gummies.", 5));
        room47.addItemToRoom(new Food("Melted Blue Synth-Gummies", "Consumable",
                "A goopy conglomerated mess of synth-gummies, which tastes of Blue Number 92.",
                "A melted-together mass of blue synth-gummies.", 1));
        room48.addItemToRoom(new Keycard("Captain's Quarters Keycard", "Keycard", "Grants access to " +
                "the Captain's Quarters to the North.", "A keycard with " +
                "the words 'Captain's Quarters' on it.", "Captain's Quarters"));
        room50.addItemToRoom(new Item("Panda Plushie", "Plushie", "A well-worn plushie." +
                " You get the feeling that its name is 'Pandamonium', but you're unsure why.",
                "A well-worned plushie."));
        room54.addItemToRoom(new Item("\'The Robot Uprising\'", "Junk", "The book is written" +
                " entirely in machine-code. Have fun deciphering six-hundred pages of that!",
                "A fiction novel."));
        room55.addItemToRoom(new Keycard("Command Deck Keycard", "Keycard", "Grants access to " +
                "the Command Deck to the North.", "A keycard with the words 'Command Deck' on it.",
                "Command Deck"));
    }

    //for placing enemies
    private void placeEnemies() {
        room0.addEnemyToRoom(new Enemy("Welcome Droid 'Kass'", "A silvery spherical robot that dangles " +
                "from the ceiling on a sparking cable.\nIt keeps repeating, \"Welcome.\"", 1,
                new MeleeWeapon("Kass' Feather-Duster", "Tool", "It's a feather-duster.",
                        "A dusty feather-duster covered in cobwebs.", 1, 1)));

        room17.addEnemyToRoom(mechHound);

        room24.addEnemyToRoom(new Enemy("Dart Turret #1", "A matte dark round turret with two barrels" +
                " and a white '#1' sprayed onto it.", 8, new RangedWeapon("Dart Gun #1", "Gun",
                "One of the gun barrels belonging to Dart Turret #1. It somehow works as a gun.",
                "One of Dart Turret #1's barrels.", 2, 4)));
        room24.addEnemyToRoom(new Enemy("Dart Turret #2", "A matte dark round turret with two barrels" +
                " and a white '#2' sprayed onto it.", 8, new RangedWeapon("Dart Gun #2", "Gun",
                "One of the gun barrels belonging to Dart Turret #2. It somehow works as a gun.",
                "One of Dart Turret #2's barrels.", 2, 4)));

        room25.addEnemyToRoom(spiderBot);

        room35.addEnemyToRoom(new Enemy("Welcome Droid 'Hass'", "A silvery spherical robot that dangles " +
                "from the ceiling on a yellow cable.\nIt keeps repeating, \"Please leave.\"", 1,
                new MeleeWeapon("Stunner", "Weapon", "It's a stun-gun covered in yellow" +
                        " danger tape and lightning-bolt symbols.", "A yellow stun-gun.",
                        4, 3)));

        room41.addEnemyToRoom(new Enemy("Ceiling Turret",
                "An automated turret hanging from a socket in the ceiling. A glowing targeting" +
                        "beam sweeps\nback and forth across the room, before settling on you.", 10,
                new RangedWeapon("Lance Shot", "Laser Gun",
                        "A rusted pipe-shaped laser gun torn from a dead turret. It has a simple firing" +
                                " mechanism, but no shoulder\nstock. It fires laser lances through from the optical" +
                                " lens at the front.", "A rusted pipe-shaped laser gun.", 4,
                        6)));

        room49.addEnemyToRoom(new Enemy("Giant Pitcher Plant", "A sentient and very hungry-looking" +
                "Pitcher Plant shaped like an upside-down bell\nand sloshing with some kind of acidic fluid inside its 'mouth'.",
                22, new MeleeWeapon("Vine Whip", "Organic Weapon", "A torn-off vine" +
                " of the Giant Pitcher Plant. It has quite some reach on it.", "A long vine torn from the " +
                "Giant Pitcher Plant.", 2, 8)));

        room53.addEnemyToRoom(new Enemy("Cleaner Bot", "A Cleaner Bot armed with a vacuum. It looks " +
                "sturdy.", 12, new RangedWeapon("Vacuum", "Tool", "It's literally " +
                "just a vacuum, so unless you're fighting a sentient\npile of sand or lint, you're unlikely to get much use " +
                "out of it.", "", 10, 2)));

        room55.addEnemyToRoom(new Enemy("A Sentient Pile of Sand & Lint", "<--", 2,
                new RangedWeapon("Fistful of Sand", "Junk", "It's a handful of sand. " +
                        "What could this be good for??", "Just enough sand to fit in your hand.",
                        1, 1)));
    }

    //for placing traps
        //extends from enemy
    private void placeTraps() {
        Enemy heatSensorTrap = new Trap("Heat-Sensor Trap", "A little black box that hangs from the ceiling and" +
                " might go off if you try to leave.", 1, new RangedWeapon("Explosion", "Bomb",
                "Boom!", "It's a bomb!", 1, 80));
        Enemy motionSensorTrap = new Trap("Motion-Sensor Trap", "A black box that lets out a pulsing" +
                " red light. One wrong move might set it off.", 1, new RangedWeapon("Explosion", "Bomb",
                "Boom!", "Booom!", 1, 75));
        Enemy claymore = new Trap("Claymore Trap", "A rectangular box on four legs that emits a small red" +
                " beam.", 1, new RangedWeapon("Explosion", "Bomb",
                "Bang!", "Pow!!", 1, 50));

        room1.addEnemyToRoom(heatSensorTrap);
        room22.addEnemyToRoom(motionSensorTrap);
        room51.addEnemyToRoom(heatSensorTrap);
        room51.addEnemyToRoom(claymore);
    }

    //this definitely works
    public void mechHoundMoves(Room room) {
        if (!room.getRoomEnemies().contains(mechHound)) {
            if (room17.getRoomEnemies().contains(mechHound)) {
                room17.getRoomEnemies().remove(mechHound);
                room16.getRoomEnemies().add(mechHound);
            } else if (room16.getRoomEnemies().contains(mechHound)) {
                room16.getRoomEnemies().remove(mechHound);
                room19.getRoomEnemies().add(mechHound);
            } else if (room19.getRoomEnemies().contains(mechHound)) {
                room19.getRoomEnemies().remove(mechHound);
                room20.getRoomEnemies().add(mechHound);
            } else if (room20.getRoomEnemies().contains(mechHound)) {
                room20.getRoomEnemies().remove(mechHound);
                room21.getRoomEnemies().add(mechHound);
            } else if (room21.getRoomEnemies().contains(mechHound)) {
                room21.getRoomEnemies().remove(mechHound);
                room18.getRoomEnemies().add(mechHound);
            } else if (room18.getRoomEnemies().contains(mechHound)) {
                room18.getRoomEnemies().remove(mechHound);
                room17.getRoomEnemies().add(mechHound);
            }
        }
    }

    //i think this works, but im not 100% sure... but whatever it takes too long to manually test
    public void spiderBotMoves(Room room) {
        if (!room.getRoomEnemies().contains(spiderBot)) {
            if (room25.getRoomEnemies().contains(spiderBot)) {
                turnAroundSpiderBot = false;
                room25.getRoomEnemies().remove(spiderBot);
                room22.getRoomEnemies().add(spiderBot);
            }
            else if (room22.getRoomEnemies().contains(spiderBot)) {
                room22.getRoomEnemies().remove(spiderBot);
                if (!turnAroundSpiderBot) {
                    room23.getRoomEnemies().add(spiderBot);
                } else room25.getRoomEnemies().add(spiderBot);
            }
            else if (room23.getRoomEnemies().contains(spiderBot)) {
                room23.getRoomEnemies().remove(spiderBot);
                if (!turnAroundSpiderBot) {
                    room26.getRoomEnemies().add(spiderBot);
                } else room22.getRoomEnemies().add(spiderBot);
            }
            else if (room26.getRoomEnemies().contains(spiderBot)) {
                room26.getRoomEnemies().remove(spiderBot);
                if (!turnAroundSpiderBot) {
                    room27.getRoomEnemies().add(spiderBot);
                } else room23.getRoomEnemies().add(spiderBot);
            }
            else if (room27.getRoomEnemies().contains(spiderBot)) {
                turnAroundSpiderBot = true;
                room27.getRoomEnemies().remove(spiderBot);
                room26.getRoomEnemies().add(spiderBot);
            }
        }
    }

    public boolean mechHoundIsNear(Room room) {
        return room.getRoomEnemies().contains(mechHound);
    }

    public boolean spiderBotIsNear(Room room) {
        return room.getRoomEnemies().contains(spiderBot);
    }

    private void makeConnections() { //basically, 'Tinder' for Room objects
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
    }
}
