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
		player = new Player(0,5);	//Player will start at 3,0
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
		map[0][5].createRoom("Player Ship Airlock");
		map[1][5].createRoom("Serenity Port Airlock");
		map[2][5].createRoom("Foyer");
		map[3][5].createRoom("Starboard Airlock");
		map[1][4].createRoom("Galley");
		map[2][4].createRoom("Party Commons");
		map[3][4].createRoom("Med Bay");
		map[2][3].createRoom("Hallway");
		map[2][2].createRoom("Quarters");
		map[2][1].createRoom("Bridge");
		map[3][1].createRoom("Captain's Quarters");
		map[1][1].createRoom("Front Restroom");
		map[2][0].createRoom("Cargo Room");
		map[2][7].createRoom("Reactor Room");
	}


}
