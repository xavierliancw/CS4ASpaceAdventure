
public class Room 
{
	//Every room has an inventory of items (temporarily int)
	private int items[];
	//Every item should have a name and a description
	
	private boolean exists;	//Controls if a room exists or not
	
	//Every room has a name
	String name;
	
	//Every room has a description
	String description;
	
	Room()
	{
		exists = false;
	}
	
	public void createRoom(String roomName)
	{
		if (!exists)
		{
			exists = true;
			name = roomName;
		}
		else
		{
			System.out.print("Room::createRoom: This room already "
					+ "exists.\n");
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	
}
