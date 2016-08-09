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
		map[3][0].createRoom("Foyer");
		map[4][0].createRoom("Living Room");
		map[4][1].createRoom("Dining Room");
		map[3][1].createRoom("Family Room");
		map[3][2].createRoom("Breakfast Nook");
		map[4][2].createRoom("Kitchen");	//I need to implement an exception
		//for when creating a room that already exists
		//I need to create a method to delete a room
		map[2][0].createRoom("Stairs");
		map[1][0].createRoom("Stair Well");
	}
}
