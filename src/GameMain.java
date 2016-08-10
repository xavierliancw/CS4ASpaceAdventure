import java.util.Scanner;

public class GameMain 
{
	public static void main(String[] args)
	{
		//Variables
		Room map[][];		//2D array of rooms
		Player player;		//The player
		Scanner sc;			//Keyboard
		String storyCode;	//Game event trigger
		boolean gravity;	//Controls if the map has gravity
		
		//Initialize
		sc = new Scanner(System.in);
		map = new Room[10][10];		//Map with 100 slots for rooms maybe shring thisla;jre
		player = new Player(3,0);	//Player will start at 3,0
		storyCode = "";
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
		//Primary game loop
		while (1<2)	//<- This should be something like while (!gameOver)
		{
			storyCode = player.prompt(map, gravity, sc);
			
			if (storyCode == "antelope") //Example cutscene
			{
				//Release the snakes on the plane!
				//Turn the gravity off!
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
		map[0][2].createRoom("Cargo");
		map[7][2].createRoom("Reactor");
	}
}
