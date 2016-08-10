import java.util.Scanner;

public class GameMain 
{
	public static void main(String[] args)
	{
		//Variables
		Room map[][];		//2D array of rooms
		Player player;		//The player
		Scanner sc;			//Keyboard
		Player trigger;		//Game event trigger
		boolean gravity;	//Controls if the map has gravity
		
		//Initialize
		sc = new Scanner(System.in);
		map = new Room[10][10];		//Map with 100 slots for rooms maybe shring thisla;jre
		player = new Player(0,2);	//Player will start at 3,0
		gravity = false;
		for (int x = 0; x < map.length; x++)
		{
			for (int y = 0; y < map[x].length; y++)
			{
				map[x][y] = new Room();
			}
		}

		//Build the world
		buildWorld(map);
		
		//Intro cutscene

		
		//Primary game loop
		while (1<2)	//<- If you have the final item && you're in your ship. you win. OR SELECT QUIT
		{
			trigger = player.prompt(map, gravity, sc);
			
			//THESE AREE EXAMPLE TRIGGERSFEKJ:sdfjkawejajl;kfjajl;fjas;fj;asjfj;lasjd;lj;lkajf
			if (trigger.hasStoryItem("pizzaz"))
			{
				//Unlock the living room
				map[3][1].setLocked(false);
			}
			else
			{
				map[3][1].setLocked(true);
			}
		}
	}

	public static void buildWorld(Room map[][])
	{
		//Initialize a room with a name
		map[0][2].createRoom("Player Ship Airlock");  //this is good
		map[1][2].createRoom("Serenity Port Airlock"); //this is good
		map[2][2].createRoom("Foyer"); //this is good
		map[3][2].createRoom("Starboard Airlock"); //this is good
		map[1][3].createRoom("Galley");            // is this correct?
		map[2][3].createRoom("Party Commons");     //correcT?
		map[3][3].createRoom("Med Bay");    //correct?
		map[2][4].createRoom("Hallway");	
		map[2][5].createRoom("Quarters");
		map[2][6].createRoom("Bridge");
		map[3][6].createRoom("Captain's Quarters");
		map[1][6].createRoom("Front Restroom");
		map[2][1].createRoom("Cargo Room");
		map[2][0].createRoom("Reactor Room");
		map[2][7].createRoom("Server Room");

		map[0][2].setDescription("The airlock of the Kandar is nothing special: a small grey room with a control panel on the wall. You can see the the port airlock of the Serenity ahead of you. ", "The airlock of the Kandar is nothing special: a small grey room with a control panel on the wall. You can see the the port airlock of the Serenity ahead of you.");
		map[1][2].setDescription("The port airlock of the Serenity is even smaller than the one on the Kandar, only wide enough for two people to stand aside. Its walls are painted white and covered with small pipes. Once outside the airlock chamber, there is a small plain room with a steel bench in it. Towards the center of the ship you can see the foyer.", "The port airlock of the Serenity is even smaller than the one on the Kandar, only wide enough for two people to stand aside. Its walls are painted white and covered with small pipes. Once outside the airlock chamber, there is a small plain room with a steel bench in it. Towards the center of the ship you can see the foyer.");
		map[2][2].setDescription("The Foyer of the Serenity is what passengers see when they first exit the cargo bay. The room itself was larger than most families lived in. The room had beige carpet and plain tan walls with a few abstract paintings magnetically held on the wall. A couple or red leather couches line the walls and there are two thin supports in the center of the room. Towards the center of the ship is the party commons; towards the port is the port airlock; towards the starboard, the starboard airlock.", "The Foyer of the Serenity is what passengers see when they first exit the cargo bay. The room itself was larger than most families lived in. The room had beige carpet and plain tan walls with a few abstract paintings magnetically held on the wall. A couple or red leather couches line the walls and there are two thin supports in the center of the room. Towards the center of the ship is the party commons; towards the port is the port airlock; towards the starboard, the starboard airlock."); //this is good
		map[3][2].setDescription("The starboard airlock of the Serenity is even smaller than the one on the Kandar, only wide enough for two people to stand aside. Its walls painted white and and covered with small pipes. Once outside the airlock chamber, there is a small plain room with a steel bench in it. Towards the center of the ship you can see the foyer.", "The starboard airlock of the Serenity is even smaller than the one on the Kandar, only wide enough for two people to stand aside. Its walls painted white and and covered with small pipes. Once outside the airlock chamber, there is a small plain room with a steel bench in it. Towards the center of the ship you can see the foyer."); //this is good
		map[1][3].setDescription("The galley of the Serenity is a fully equipped kitchen with all of the necessary tools to make any meal imaginable while flying through space. Various ingredients, food and utensils are floating all around the room. There are two bodies elegantly floating in the kitchen dressed in kitchen attire.", "The galley of the Serenity is a fully equipped kitchen with all of the necessary tools to make any meal imaginable while flying through space. Various ingredients, food and utensils are floating all around the room. There are two bodies elegantly floating in the kitchen dressed in kitchen attire.");            // is this correct?
		map[2][3].setDescription("The party commons is the main communal area of the Serenity. The room is lit like a nightclub, and located in the center of the room is a large bar, home to enough of the finest alcohol in the Collective to host multiple large parties. The walls are lined with deep red booths. You can see the bodies of most of the passengers and crew members here all floating, with blue skin and blank faces. Towards the port of the ship you can see the galley. Towards the front you can see the hallway that leads to the bridge and quarters. Towards the port side, the galley. Towards starboard, the galley.", "The party commons is the main communal area of the Serenity.  The room is lit like a nightclub, and located in the center of the room is a large bar, home to enough of the finest alcohol in the Collective to host multiple large parties. The walls are lined with deep red booths. You can see the bodies of most of the passengers and crew members here all floating, with blue skin and blank faces. Towards the port of the ship you can see the galley. Towards the front you can see the hallway that leads to the bridge and quarters. Towards the port side, the galley. Towards starboard, the galley.");     //correcT?
		map[3][3].setDescription("The medbay is a small white room with two hospital beds and full autodoc setup, enough equipment and medicine to keep someone alive long enough to get to a station with an actual hospital. Towards the center of the ship is the party commons room.", "The medbay is a small white room with two hospital beds and full autodoc setup, enough equipment and medicine to keep someone alive long enough to get to a station with an actual hospital. Towards the center of the ship is the party commons room.");    //correct?
		map[2][4].setDescription("The hallway to the front is nothing special. The room is not all decorated, with a plain steel floor and uncovered walls with exposed pipes. The body of what appears to be a crew member unceremoniously floats in the center of the small room. Towards the front of the ship is the bridge and towards the back is the party commons.", "The hallway to the front is nothing special. The room is not all decorated, with a plain steel floor and uncovered walls with exposed pipes. The body of what appears to be a crew member unceremoniously floats in the center of the small room. Towards the front of the ship is the bridge and towards the back is the party commons.");	
		map[2][5].setDescription("Extravagantly designed queen sized beds for each room, Each room was larger than many apartments. Towards the front of the ship is the bridge, towards the back is the hallway.", "Extravagantly designed queen sized beds for each room, Each room was larger than many apartments. Towards the front of the ship is the bridge, towards the back is the hallway.");
		map[2][6].setDescription("The bridge is a large room with a variety of control panels and screens, used for ship navigation, or at least it was. The bodies of most of the crew are splayed out on the ground, clearly killed by violent forces. The once floating beads of blood have splattered, giving the carpeting dramatic contrasts and flair. Towards the front of the ship is the server room towards the back is the quarters hallway.", "The bridge is a large room with a variety of control panels and screens, used for ship navigation, or at least it was. The bodies of most of the crew are splayed out on the ground, clearly killed by violent forces. The once floating beads of blood have splattered, giving the carpeting dramatic contrasts and flair. Towards the front of the ship is the server room towards the back is the quarters hallway.");
		map[3][6].setDescription("The captain's quarters is a small dark room with dark blue walls. It has a small bed and desk with a lot of clutter floating about. There is a small window that looks out into space.", "The captain's quarters is a small dark room with dark blue walls. It has a small bed and desk with a lot of clutter floating about. There is a small window that looks out into space.");
		map[1][6].setDescription("The front restroom is a plain white room with 3 stalls, and 4 urinals, fortunately whoever built the bathroom accounted for the fact the gravity might be off, or else this would be a crappy situation. Towards the center of the ship is the bridge.", "The front restroom is a plain white room with 3 stalls, and 4 urinals, fortunately whoever built the bathroom accounted for the fact the gravity might be off, or else this would be a crappy situation. Towards the center of the ship is the bridge.");
		map[2][1].setDescription("The computer room is a very small room, its walls covered with electronic equipment to make the walking space only large enough for 2 small people to walk. The amount of equipment here is way more than a civilian ship would ever need. There is a small access terminal on the side of one of the servers. Towards the back is the bridge.", "The computer room is a very small room, its walls covered with electronic equipment to make the walking space only large enough for 2 small people to walk. The amount of equipment here is way more than a civilian ship would ever need. There is a small access terminal on the side of one of the servers. Towards the back is the bridge.");
		map[2][0].setDescription("The Cargo room of the Serenity  is a large empty room that doubles as a storage area and docking area for 2 small ships. There is only one shuttle in the docking bay. There are a lot of crates lying around as well. There are bodies lying around everywhere, most obviously killed by gunshots. A variety of military grade weapons are on the floor. Towards the back of the ship is the reactor chamber, towards the front is the foyer.", "The Cargo room of the Serenity  is a large empty room that doubles as a storage area and docking area for 2 small ships. There is only one shuttle in the docking bay. There are a lot of crates lying around as well. There are bodies lying around everywhere, most obviously killed by gunshots. A variety of military grade weapons are on the floor. Towards the back of the ship is the reactor chamber, towards the front is the foyer.");
		map[2][7].setDescription("The reactor control room is a small closed off area with a glass window that looks down into the reactor chamber. There is an alarm going off and the terminal is flashing, warning of a meltdown. Towards the front of the ship is the cargo room.", "The reactor control room is a small closed off area with a glass window that looks down into the reactor chamber. There is an alarm going off and the terminal is flashing, warning of a meltdown. Towards the front of the ship is the cargo room.");


		//GALLEY ITEMS
		Thing AgedSideronWine = new Thing("Aged Sideron Wine", "Some of the finest wine found the Collective, the Sideron family of Pavela are some the last of the wine producers that do not grow their grapes in artificial farms. A bottle this old and of this winery would be worth a good chunk of credits. ", false, true);
		map[1][3].addThing(AgedSideronWine);

		Thing KitchenTerminal = new Thing("Kitchen Terminal", "I am beginning to think that I should not have taken this job. Yes I was paid twice of what I am worth but something is just odd. Not to mention that I have had to make full on meals at least 3 nights in a row, on top of the rest of the meals. Yesterday they had some guys come on to meet with the captain, looked they were from Tamarain, with their robotic arms, I will admit they looked scary, but they did not talk much. But they sure do eat a lot. I think that they are in the cargo bay now for their deal or whatever. Wait is that gunfire? WHat IS HA-", false, false);
		map[1][3].addThing(KitchenTerminal);

		Thing bodiesKitchen = new Thing("Bodies", "Two men dressed in chef attire, cause of death: suffocation from depressurization.", false, false);
		map[1][3].addThing(bodiesKitchen);

		//PARTY COMMONS
		Thing officerBody = new Thing("Officer's Body", "The floating body is dressed in his officer uniform... His key card seems to be in his pocket! That could prove useful.", false, false);
		map[2][3].addThing(officerBody);

		Thing keyCard = new Thing("Officer's Key Card", "Keycard that unlocks the bridge.  Found in the pocket of the officer.", false, true);
		map[2][3].addThing(keyCard);

		Thing partyTablet = new Thing("Partygoer's Tablet", "This seems enjoyable to take... Better not let temptation set in.  Ah the good old days.", false, true);
		map[2][3].addThing(partyTablet);

		//MED BAY
		Thing painkillers = new Thing("Painkillers", "Advanced pain pills that completely block pain", false, true);
		map[3][3].addThing(painkillers);
		
		Thing radAway = new Thing("Anti Rad meds", "Pills designed to minimize the effects of radiation, popular amongst drive core engineers during emergencies.", false, true);
		map[3][3].addThing(radAway);
		
		Thing bloodPack = new Thing("Transfusion Pack", "Advanced synthetic blood pack that works with any blood type in the event that a blood transfusion is needed.", false, true);
		map[3][3].addThing(bloodPack);

		//QUARTERS
		Thing survivalRifle = new Thing("Survival Rifle", "High caliber rifle meant for exploring unknown planets and self defense against humans if need be. Collapses down small enough to fit in the small cargo chambers of any small fighter.", false, true);
		map[2][5].addThing(survivalRifle);

		//CAPTAIN'S QUARTERS
		Thing deskComputer = new Thing("Desk Computer", "There's a sticky note on the desktop, it says server room password: 1234. Not too secure if you ask me.", false, false);
		map[3][6].addThing(deskComputer);

		Thing diaryEntry = new Thing("Diary Entry", "The diary says Tamarainians are coming today and we pray hope this deal goes smoothly I like to think I make good deals, maybe even the best deals in the entire collective. But I may be going up against some very good negotiators, so let’s-", false, true);
		map[3][6].addThing(diaryEntry);

		//FRONT RESTROOM
		Thing vertigo = new Thing("Vertigo", "Highly addictive drug that simulates weightlessness and relaxes the muscles. ", false, true); 
		map[1][6].addThing(vertigo);

		//SERVER ROOM
		Thing serverTerm = new Thing("Server Terminal", "You insert your sd card and gather all information that the ship has on it's computer.", false , false);
		map[2][7].addThing(serverTerm);
		
		//CARGO ROOM
		Thing weapCrate = new Thing("Weapons crate", "You see a large variety of military grade weapons and ammunition, as well as full combat suits.", false, false);
		map[2][1].addThing(weapCrate);
		Thing tmrAr = new Thing("Tamaraini Assault Rifle", "Standard issue weapon for the Tamaraini army. The weapon is a large caliber bullpup, firing conventional bullets capable of various fire modes.", false, true);
		map[2][1].addThing(tmrAr);
		Thing pdp = new Thing("Pilot’s defense pistol", "Small pistol designed to be easily carried in pilot suit. Fires small, low penetration bullets to avoid critical damage to a ship components in case of a firefight.", false, true);
		map[2][1].addThing(pdp);
		Thing plp = new Thing("Pavelan light pistol.", "Standard issue sidearm for the Pavelan military that fires a small burst of solist energy. Extremely versatile due to its ability to simulate many different calibers of its conventional counterparts but very expensive to produce.", false, true);
		map[2][1].addThing(plp);
		
		//REACTOR ROOM
		Thing reactTerm = new Thing("Reactor terminal", "Downloading diagnostics now", false, false);
		map[2][0].addThing(reactTerm);
	}

	
}
