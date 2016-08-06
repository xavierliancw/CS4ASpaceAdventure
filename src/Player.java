import java.util.Scanner;

public class Player 
{
	//Player's gotta do things like
	//move to a new room
	//remember which room he's in
	//do the verbs
	
	private int x, y;	//Where the player currently is
	
	
	//Verbs
	//
	
	Player(int xStart, int yStart)
	{
		x = xStart;
		y = yStart;
	}
	
	public void prompt(Room map[][])
	{
		System.out.print("Pick\n");	//Full prompt goes here that will ask what player wants to do
		Scanner sc = new Scanner(System.in);
		int choice;	//This should be changed to string
		
		choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice)
		{
		case 1:
			//This case would be "move"
			//movePrompt();
			x = 3;
			y = 1;
			System.out.print(map[x][y].getName());
		}
	}
	public void movePrompt()
	{
		System.out.print("Where do you want to move? ");
		
	}
}
