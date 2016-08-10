import java.util.Scanner;

public class Player 
{
	Scanner keyboard = new Scanner(System.in);

	private int x, y;	//Where the player currently is
	String verbBank[];	//Bank of verbs that a player can do
	private Thing[] backpack; //Array of backpack items
	private final int bagCap = 5;	//Bag capacity
	String backpackVerbs[];

	Player(int xStart, int yStart)
	{
		x = xStart;
		y = yStart;
		backpack = new Thing[bagCap];
		for (int i = 0; i < bagCap; i++)
		{
			backpack[i] = new Thing();
		}
		backpackVerbs = new String[3];
		backpackVerbs[0] = "exit";
		backpackVerbs[1] = "inspect";
		backpackVerbs[2] = "drop";
		verbBank = new String[6];
		verbBank[0] = "move";
		verbBank[1] = "look";
		verbBank[2] = "search";
		verbBank[3] = "pickup";
		verbBank[4] = "backpack";
		verbBank[5] = "help"; //we will add drop
	}

	public void addThing(Thing newThing)
	{
		int i = 0;	
		while (backpack[i].exists())
		{
			i++;
		}
		backpack[i] = newThing;
	}

	public Thing[] getThings()
	{
		return backpack;
	}

	public void listItems(Scanner keyboard) 
	{
		int i = 0;
		while (backpack[i].exists())
		{
			System.out.println("Items Inventory: ");
			for (i = 0; i < backpack.length; i++)
			{
				if (backpack[i].exists())
					System.out.println((i + 1) + ". " + backpack[i].getName());
				else 
					System.out.println((i + 1) + ". " + "-EMPTY-");
			}
		}
	}

	public void dropThing(Thing obtainedThing, Scanner keyboard, Room map[][])
	{
		Thing transfer = new Thing();
		int choice = -2;
		boolean pass = false;
		do	
		{
			System.out.println("Select item to drop:");
			choice = keyboard.nextInt();

			if (choice > -1 && choice < backpack.length + 1)
			{
				pass = true;
			}
			if (!pass)
			{
				System.out.println("I can't seem to find that!");
			}
			keyboard.nextLine();
		} while (!pass);
		
		choice--;
		
		if (choice != -1)
		{
			transfer = backpack[choice];
			map[x][y].addThing(transfer); 		//adding item to the room from the backpack
			backpack[choice].setExists(false);
		}
		else
			System.out.println("Guess I didn't want to drop anything.");
	}

	public void backpackPrompt(Scanner keyboard)
	{
		boolean pass;
		String choice;
		String storyCode;

		pass = false;
		storyCode = "";

		do
		{
			listItems(keyboard);
			System.out.println("What would you like to do with your backpack items?");

			choice = keyboard.nextLine();
			choice = choice.toLowerCase();
			choice = choice.trim();

			//check to see if the choice exists in the verb bank SPECIFIC to backpack
			for (int x = 0; x < backpackVerbs.length; x++)
			{
				if (choice.equals(backpackVerbs[x]))
				{
					pass = true;
					x = backpackVerbs.length;
				}
			}
			if (!pass)
			{
				System.out.println("It doesn't seem I can't do that with this item.");
			}
		} while (!pass);

		switch (choice)
		{
			case "exit":
				break;
			case "inspect":
				break;    // add prompt for inspect
			case "drop":
				break;   // add prompt for drop
		}
	}

	public String prompt(Room map[][], boolean gravity, Scanner sc)
	{
		//Variables
		boolean pass;		//Controls prompt validation
		String choice;		//Player command input
		String storyCode;	//Story code that triggers things in caller

		//Initialize
		pass = false;
		storyCode = "";
		
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
		case "search":
			searchAction(map);
			break;
		case "pickup":
			pickupPrompt(map, sc);
			break;
		case "backpack":
			backpackPrompt(sc);
			break;
		default:
			//Help
		}
		return storyCode;
	}

	public boolean backPackFull()
	{
		//Look through all backpack slots and look for an empty slot
		for (int x = 0; x < backpack.length; x++)
		{
			//If there's an empty spot
			if (!backpack[x].exists())
			{
				return false; //Return immediately
			}
		}
		//If no empty spots are found, the bag is full
		return true;
	}
	
	public void pickupPrompt(Room map[][], Scanner sc)
	{
		//Variables
		boolean pass;		//Prompt validation
		int choice;			//User item selection to pick up
		Thing inventory[];	//Visible items to player
		Thing newInvent[];	//New inventory to replace room's
		int itr;			//Array iterator
		
		//Initialize
		pass = false;
		choice = -1;
		itr = 0;
		inventory = map[x][y].getVisibleInventory();
		
		//Only do the prompt if there are visible items
		if (searchAction(map))
		{
			if (!backPackFull())
			{
				System.out.print("\t0. Nevermind\n");
				do
				{
					System.out.print("What do you want to pick up?\n");
					if (sc.hasNextInt())
					{
						choice = sc.nextInt();
						if (-1 < choice && choice < inventory.length + 1)
						{
							pass = true;
						}
					}
					//Show an error
					if (!pass)
					{
						System.out.print("Hmm... Maybe I should choose "
								+ "more carefully.\n");
					}
					sc.nextLine();
				} while (!pass);
				choice--;	//Choice correction
				
				//If choice isn't exit prompt, transfer an item
				if (choice != -1)
				{
					//Move the item from the room into player's inventory
					addThing(inventory[choice]);
					
					//Delete the thing from the room by creating a new 
					//array with no gaps in contiguous data
					newInvent = new Thing[inventory.length - 1];
					for (int x = 0; x < newInvent.length; x++)
					{
						//If the deleted index is attained, skip it
						if (itr == choice)
						{
							itr++;
						}
						//Make sure that itr is within bounds
						if (itr < inventory.length)
						{
							newInvent[x] = inventory[itr];
						}
						itr++;
					}
					map[x][y].setInventory(newInvent);
				}
				else
				{
					System.out.print("Maybe I won't pick anything up.\n");
				}
			}
			//Output bag full error
			else
			{
				System.out.print("My bag is so full. I can't carry any "
						+ "more stuff!\n");
			}
		}
		//There's nothing to pick up
		else
		{
			System.out.print("So there's nothing to pick up.\n");
		}
	}
	public boolean searchAction(Room map[][])
	{
		//Variables
		Thing roomItems[];	//Things that are in the current room
		boolean something;	//Controls if items are seen or not
		
		//Initialize
		roomItems = map[x][y].getRoomInventory();
		something = false;
		
		//Display the room's contents (or lack of) to the console
		System.out.print("You search the room...\n");

		//Look for things
		for (int x = 0; x < roomItems.length; x++)
		{
			if (!roomItems[x].isHidden() && roomItems[x].exists())
			{
				System.out.print("\t" + (x + 1) + ". " 
						+ roomItems[x].getName() + " found.\n");
				something = true;
			}
		}
		//Display a message if nothing is seen
		if (!something)
		{
			System.out.print("There's nothing of interest.\n");
		}
		return something;
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
				//Only move in that direction if all criteria are met.
				//That is if the array index is valid, the room exists,
				//and if it's not a locked room
				switch (input)
				{
				case "forward":
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
					System.err.print("\tPlayer::movePrompt(): Critical "
							+ "movement switch default\n");
				}
			}
		} while (!pass);
	}
}
