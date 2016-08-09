
public class Room 
{
	private Thing item[];			//Every room can have items in it
	private boolean exists;			//Controls if a room exists or not
	private boolean locked;			//Controls if a room is locked or not
	private String name;			//Room's name
	private String gravDescr;		//Detailed information about the room
	private String antiGravDescr;	//Room description without gravity
	
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
			item = new Thing[0];	//Initialize with an empty array
		}
		else
		{
			System.err.print("\tRoom::createRoom(): Room creation "
					+ "attempted on an existing room. Fatal error.\n");
			System.exit(0);
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
	
	public void changeDescription(String newDesc, boolean gravity)
	{
		if (gravity)
		{
			gravDescr = newDesc;
		}
		else
		{
			antiGravDescr = newDesc;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription(boolean gravity)
	{
		if (gravity)
		{
			return gravDescr;
		}
		else
		{
			return antiGravDescr;
		}
	}
	
	public boolean exists()
	{
		return exists;
	}
	
	public boolean locked()
	{
		return locked;
	}
	
	public Thing[] getRoomInventory()
	{
		return item;
	}
}
