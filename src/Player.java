import java.util.Scanner;

public class Player 
{
	private int x, y;	//Where the player currently is
	String verbBank[];	//Bank of verbs that a player can do
	
	Player(int xStart, int yStart)
	{
		x = xStart;
		y = yStart;
		verbBank = new String[6];
		verbBank[0] = "move";
		verbBank[1] = "look";
		verbBank[2] = "search";
		verbBank[3] = "pickup";
		verbBank[4] = "backpack";
		verbBank[5] = "help";
	}
	
	public void prompt(Room map[][], Scanner sc)
	{
		//Variables
		boolean pass;
		String choice;

		//Initialize
		pass = false;
		
		//Prompt and validate
		do
		{
			System.out.print("\nWhat do you want to do?\n");
			
			choice = sc.nextLine();
			choice = choice.toLowerCase();
			choice = choice.trim();
			
			//Check to see if the verb exists in the verb bank
			for (int x = 0; x < verbBank.length; x++)
			{
				if (choice.equals(verbBank[x]))
				{
					pass = true;
					x = verbBank.length;
				}
			}
			if (!pass)
			{
				System.out.print("That isn't something you are able to "
						+ "do.\n");
			}
		} while (!pass);
		
		switch (choice)
		{
		case "move":
			movePrompt(map, sc);
			break;
		case "look":
			lookAction(map);
			break;
		}
	}
	public void lookAction(Room map[][])
	{
		System.out.print("You look around for doors...\n");
		//Look forward
		if (y + 1 < map[x].length && map[x][y + 1].exists())
		{
			System.out.print("There's one in front of you.\n");
		}
		//Look backward
		if (y - 1 > -1 && map[x][y - 1].exists())
		{
			System.out.print("There's one behind you.\n");
		}
		//Look right
		if (x + 1 < map.length && map[x + 1][y].exists())
		{
			System.out.print("There's one to your right.\n");
		}
		//Look left
		if (x - 1 < map.length && map[x - 1][y].exists())
		{
			System.out.print("There's one to your left.\n");
		}
	}
	public void movePrompt(Room map[][], Scanner sc)
	{
		//Variables
		boolean pass;
		String input;
		
		//Initialize
		pass = false;
		
		//Prompt and validate
		do
		{
			System.out.print("Should I move (forward), (back), (left), "
					+ "(right), or should I (stay)?\n");
			input = sc.nextLine();
			input = input.toLowerCase();
			input = input.trim();
			
			//Check if input is valid
			if (input.equals("forward") ||input.equals("back") 
				|| input.equals("left") || input.equals("right")  
				|| input.equals("stay") )
			{
				pass = true;
			}
			else
			{
				System.out.print("I can't move like that.\n");
			}
			//Check if a room is available to move to
			if (pass)
			{
				switch (input)
				{
				case "forward":
					//If the array location exists, the room exists, and not
					//locked
					if (y + 1 < map[x].length && map[x][y + 1].exists()
						&& !map[x][y + 1].locked())
					{
						y += 1;
					}
					else if (y + 1 < map[x].length 
							 && map[x][y + 1].locked())
					{
						System.out.print("The door's locked.\n");
					}
					else
					{
						System.out.print("There's no door that way.\n");
					}
					break;
				case "back":
					if (y - 1 > -1 && map[x][y - 1].exists()
						&& !map[x][y - 1].locked())
					{
						y -= 1;
					}
					else if (y - 1 > -1 && map[x][y - 1].locked())
					{
						System.out.print("The door's locked.\n");
					}
					else
					{
						System.out.print("There's no door that way.\n");
					}
					break;
				case "left":
					if (x - 1 > -1 && map[x - 1][y].exists()
						&& !map[x - 1][y].locked())
					{
						x -= 1;
					}
					else if (x - 1 > -1 && map[x - 1][y].locked())
					{
						System.out.print("The door's locked.\n");
					}
					else
					{
						System.out.print("There's no door that way.\n");
					}
					break;
				case "right":
					if (x + 1 < map[x].length && map[x + 1][y].exists()
						&& !map[x + 1][y].locked())
					{
						x += 1;
					}
					else if (x + 1 < map[x].length 
							 && map[x + 1][y].locked())
					{
						System.out.print("The door's locked.\n");
					}
					else
					{
						System.out.print("There's no door that way.\n");
					}
					break;
				case "stay":
					System.out.print("Maybe I won't move after all.\n");
					break;
				default:
					System.out.print("\tPlayer::movePrompt(): Critical "
							+ "movement switch default\n");
				}
			}
		} while (!pass);
	}
}
