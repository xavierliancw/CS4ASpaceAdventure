import java.util.Scanner;

public class GameMain 
{
	public static void main(String[] args)
	{
		//First thing to do is make the map
		//Map should be a 2d array of objects
		//For now it's just int
		Room map[][];
		map = new Room[10][10]; //There are 100 available slots
		Player player = new Player(3,0);	//Player will start at 3,0
		//These 100 slots aren't rooms yet though
		for (int x = 0; x < map.length; x++)
		{
			for (int y = 0; y < map[x].length; y++)
			{
				map[x][y] = new Room();
			}
		}
		
		//The first thing the main will do is build the entire world
		//To prototype, I'm just going to make a looped map
		
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
		
		while (1<2)
		{
			player.prompt(map);
		}
		
		
		//Then the main will enter a game loop that will give the user
		//control.
	}
}
