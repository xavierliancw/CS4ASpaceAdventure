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
	}


}
