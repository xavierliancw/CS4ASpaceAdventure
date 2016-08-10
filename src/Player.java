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
		verbBank = new String[7];
		verbBank[0] = "move";
		verbBank[1] = "look";
		verbBank[2] = "search";
		verbBank[3] = "inspect";
		verbBank[4] = "pickup";
		verbBank[5] = "backpack";
		verbBank[6] = "quit";
		
		//Add starting items
		Thing mk27PDW = new Thing("Mk_27 PDW", "Small lightweight automatic weapon designed for low gravity use. Commonly seen in Camorran boarding parties. Fires small lightweight rounds at very high rate of fire.", false, true);
		addThing(mk27PDW);

		Thing mk3Pistol = new Thing("Mk_3 Light Pistol", "Standard issue sidearm of the Camorran navy, fires an intermediate caliber. Useful on world on in low gravity environments.", false, true);
		addThing(mk3Pistol);
		
		Thing agedSideronWine = new Thing("Aged Sideron Wine", "Some of the finest wine found the Collective, the Sideron family of Pavela are some the last of the wine producers that do not grow their grapes in artificial farms. A bottle this old and of this winery would be worth a good chunk of credits. ", false, true);
		addThing(agedSideronWine);
	}
	public Player prompt(Room map[][], boolean gravity, Scanner sc)
	{
		//Variables
		boolean pass;		//Controls prompt validation
		String choice;		//Player choice input

		//Initialize
		pass = false;
		
		//Prompt and validate
		do
		{
			System.out.print("\nWhat do you want to do?\n"
					+ "(move)(look)(search)\n"
					+ "(inspect)(pickup)(backpack)\n");
			
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
			lookAction(map, gravity);
			break;
		case "search":
			searchAction(map);
			break;
		case "inspect":
			inspectRoomPrompt(map, sc);
			break;
		case "pickup":
			pickupPrompt(map, sc);
			break;
		case "backpack":
			backpackPrompt(keyboard, map);
			break;
		default:
			System.out.print("IT'S GAME OVER MAN!\n");
			System.exit(0);
		}
		return this;
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
	public void lookAction(Room map[][], boolean gravity)
	{
		System.out.print("You're in the " + map[x][y].getName() + ".\n"
				+ map[x][y].getDescription(gravity) + "\n"
				+ "You look around for doors...\n");
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
		if (x - 1 > -1 && map[x - 1][y].exists())
		{
			System.out.print("There's one to your left.\n");
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
	public void inspectRoomPrompt(Room[][] map, Scanner sc)
	{
		//Variables
		boolean pass;		//Prompt validation
		int choice;			//User item selection to pick up
		Thing inventory[];	//Visible items to player
		
		//Initialize
		pass = false;
		choice = -1;
		inventory = map[x][y].getVisibleInventory();
		
		//Only do the prompt if there are visible items
		if (searchAction(map))
		{
			System.out.print("\t0. Nevermind\n");
			if (!backPackFull())
			{
				do
				{
					System.out.print("What do you want to inspect?\n");
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
				
				//If choice isn't exit prompt
				if (choice != -1)
				{
					//Inspect the object
					System.out.print("You inspect the " 
					+ inventory[choice].getName() + "...\n"
					+ inventory[choice].getDescription() + "\n");
				}
				else
				{
					System.out.print("Maybe I won't inspect anything "
							+ "after all.\n");
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
			System.out.print("So there's nothing to inspect.\n");
		}
	}
	public void pickupPrompt(Room map[][], Scanner sc)
	{
		//Variables
		boolean pass;		//Prompt validation
		int choice;			//User item selection to pick up
		Thing inventory[];	//Visible items to player
		int itr;			//Array iterator
		
		//Initialize
		pass = false;
		choice = -1;
		itr = 0;
		inventory = map[x][y].getVisibleInventory();
		
		//Only do the prompt if there are visible items
		if (searchAction(map))
		{
			System.out.print("\t0. Nevermind\n");
			if (!backPackFull())
			{
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
				
				//If choice isn't exit prompt and if the item is 
				//pocketable, transfer an item
				if (choice != -1 && inventory[choice].isPocketable())
				{
					//Move the item from the room into player's inventory
					Thing add = new Thing(inventory[choice].getName(),
							inventory[choice].getDescription(), false);
					addThing(add);
					
					//Delete the thing from the room and fill in the hole
					String deleteThis = inventory[choice].toString();
					Thing newInv[] = map[x][y].getRoomInventory();
					//Find deletion point
					for (int x = 0; x < newInv.length; x++)
					{
						//When found
						if (deleteThis.equals(newInv[x].toString()))
						{
							itr = x;
							x = newInv.length;
						}
					}
					Thing swap = new Thing();;
					//Bubble deletion to bottom
					while (itr + 1 < newInv.length)
					{
						swap = newInv[itr];
						newInv[itr] = newInv[itr + 1];
						newInv[itr + 1] = swap;
						itr++;
					}
					newInv[newInv.length - 1].setExists(false);
					map[x][y].setInventory(newInv);
				}
				else
				{
					if (!inventory[choice].isPocketable())
					{
						System.out.print("I can't pick that up!\n");
					}
					if (choice == -1)
					{
						System.out.print("Maybe I won't pick anything "
								+ "up.\n");
					}
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
	public void backpackPrompt(Scanner keyboard, Room map[][])
	{
		//Variables
		boolean pass;
		String choice;
		
		//Initialize
		pass = false;
		choice = "";

		//Only prompt if the bag is not empty
		if (!backPackEmpty())
		{
			//Prompt and validate
			do
			{
				listItems(keyboard);
				System.out.print("What would you like to do with your "
						+ "backpack items?\n"
						+ "(exit)(inspect)(drop)\n");
				choice = keyboard.nextLine();
				choice = choice.toLowerCase();
				choice = choice.trim();
	
				//Check to see if the choice exists in the verb bank 
				//SPECIFIC to backpack
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
					System.out.println("I can't do that.");
				}
			} while (!pass);
	
			//Call appropriate method depending on user's choice
			switch (choice)
			{
			case "exit":
				break;
			case "inspect":
				inspectPrompt(map, keyboard);
				break;    
			case "drop":
				dropPrompt(map, keyboard);
				break;   
			default:
				System.err.print("Player::backpackPrompt(): "
						+ "Critical default!\n");
				System.exit(0);
			}
		}
		//Otherwise say that it's pointless to look in bag
		else
		{
			System.out.print("Your backpack is empty. There's not really "
					+ "anything you can do with it now.\n");
		}
	}
	public void addThing(Thing newThing)
	{
		int i = 0;	
		while (backpack[i].exists())
		{
			i++;
		}
		backpack[i] = newThing;
		backpack[i].setExists(true);
	}
	public Thing[] getThings()
	{
		return backpack;
	}
	public void listItems(Scanner keyboard) 
	{
		int i = 0;
		while (i < backpack.length && backpack[i].exists())
		{
			System.out.println("Your backpack has: ");
			for (i = 0; i < backpack.length; i++)
			{
				if (backpack[i].exists())
				{
					System.out.println("\t" + (i + 1) + ". " 
							+ backpack[i].getName());
				}
				else 
				{
					System.out.println("\t" + (i + 1) + ". " + "EMPTY");
				}
			}
		}
	}

	public void inspectPrompt(Room map[][], Scanner keyboard)
	{
		//Variables
		int choice;
		boolean pass;
		
		//Initialize
		choice = -2;
		pass = false;
		
		//Prompt for inspection and validate
		do
		{
			listItems(keyboard);
			System.out.print("\t0. Nevermind\n"
					+ "I'm going to inspect item... ");
			if (keyboard.hasNextInt())
			{
				choice = keyboard.nextInt();
			}
			if (choice > -1 && choice < backpack.length + 1)
			{
				pass = true;
			}
			if (!pass)
			{
				System.out.println("That's not something I can inspect!");
			}
			keyboard.nextLine();
		} while (!pass);

		choice--;	//Choice correction

		//If player didn't select quit prompt
		if (choice != -1)
		{
			if (backpack[choice].exists())
			{
				System.out.print(backpack[choice].getName() + ":\n"
						+ backpack[choice].getDescription() + "\n");
			}
			else
			{
				System.out.print("Yep. That's some empty space right "
						+ "there.\n");
			}
		}
		else
			System.out.println("Guess there's nothing worth inspecting.");
	}
	public void dropPrompt(Room map[][], Scanner keyboard)
	{
		//Variables
		Thing transfer;
		int choice;
		boolean pass;
		
		//Initialize
		choice = -2;
		pass = false;
		
		//Prompt for drop and validate
		do
		{
			listItems(keyboard);
			System.out.print("\t0. Nevermind\n"
					+ "I'm going to drop... ");
			if (keyboard.hasNextInt())
			{
				choice = keyboard.nextInt();
			}
			if (choice > -1 && choice < backpack.length + 1)
			{
				pass = true;
			}
			if (!pass)
			{
				System.out.println("Whoa, my hand slipped!");
			}
			keyboard.nextLine();
		} while (!pass);
		
		choice--;	//Choice correction
		
		//If choice isn't quit prompt
		if (choice != -1)
		{
			//Drop the item
			transfer = new Thing(backpack[choice].getName(), 
					backpack[choice].getDescription(), false);
			map[x][y].addThing(transfer); 		
			backpack[choice] = new Thing();
		}
		else
			System.out.println("Guess I didn't want to drop anything.");
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
	public boolean backPackEmpty()
	{
		//Look through all backpack slots and see if all slots are empty
		for (int x = 0; x < backpack.length; x++)
		{
			if (backpack[x].exists())
			{
				return false;	//If an item is found, it's not empty
			}
		}
		return true;	//If no items are found, the bag is empty
	}
	public boolean hasStoryItem(String item)
	{
		//Search the backpack for the item
		for (int x = 0; x < backpack.length; x++)
		{
			//If the item is found in the inventory, then return true
			if (backpack[x].equals(item))
			{
				return true;
			}
		}
		//Otherwise the item has not been found yet, and no story triggers
		//should happen
		return false;
	}
}