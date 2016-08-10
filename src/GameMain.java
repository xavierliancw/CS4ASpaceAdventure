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
		player = new Player(3,0);	//Player will start at 3,0
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
		
		/*
		System.out.print("You are a soldier in the Camorran Navy. Your "
				+ "ship, the Kandar was patrolling an area of space on "
				+ "the edge of the collective known for piracy and "
				+ "trafficking. Kandar has come across what appears to "
				+ "be a small luxury liner by the name of Serenity, an "
				+ "elite of the collective systems that would be used as "
				+ "a  getaway, among other things. The Kandar has "
				+ "attempted to make contact with Serenity but their "
				+ "bridge hasn’t answered and it appears their "
				+ "artificial gravity is offline. As Navy protocol "
				+ "states, the Kandar is obligated to investigate.\n\n"
				+ "~\n"
				+ "Ship: “Captain this is Kandar, we are "
				+ "registering, anything we should be worried about?”\n"
				+ "You: “Not yet, call this in with command just in "
				+ "case, if you see anything unusual let me know let me "
				+ "know and we will back off. We’ll need more manpower "
				+ "to fully investigate this.”\nShip: “Yes Sir, Kandar "
				+ "out.”\n\n"
				+ "OBJECTIVES:\n"
				+ "\t - Investigate what happened\n"
				+ "\t - Copy the data on the ship's computers\n"
				+ "\t - Optional: Investigate the strange reactor "
				+ "readings, and copy reactor diagnostics\n\n");
		*/
		
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
		map[5][0].createRoom("Player Ship Airlock");
		map[5][1].createRoom("Serenity Port Airlock");
		map[5][2].createRoom("Foyer");
		map[5][3].createRoom("Starboard Airlock");
		map[4][1].createRoom("Galley");
		map[4][2].createRoom("Party Commons");
		map[4][3].createRoom("Med Bay");
		map[3][2].createRoom("Hallway");
		map[2][2].createRoom("Quarters");
		map[1][2].createRoom("Bridge");
		map[1][3].createRoom("Captain's Quarters");
		map[1][1].createRoom("Front Restroom");
		map[0][2].createRoom("Cargo Room");
		map[7][2].createRoom("Reactor Room");
	}


}
