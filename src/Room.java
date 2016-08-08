
public class Room 
{
	private Thing item[];	//Every room can have items in it
	private boolean exists;	//Controls if a room exists or not
	private boolean locked;	//Controls if a room is locked or not
	private String name;	//Room's name
	String description;		//Detailed information about the room
	
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
			locked = false;
		}
		else
		{
			System.out.print("\tRoom::createRoom(): This room already "
					+ "exists.\n");
		}
	}
	
	public void deleteRoom()
	{
		exists = false;
	}
	
	public void setInventory(Thing things[])
	{
		item = things;
	}
	
	public void setLocked(boolean lockIt)
	{
		locked = lockIt;
	}
	
	public void changeName(String newName)
	{
		name = newName;
	}
	
	public void changeDescription(String newDesc)
	{
		description = newDesc;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public boolean exists()
	{
		return exists;
	}
	
	public boolean locked()
	{
		return locked;
	}
}
