
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
		item = new Thing[50];	//Initialize rooms with 50 slots
		
		//Initialize empty room inventories
		for (int x = 0; x < item.length; x++)
		{
			item[x] = new Thing();
		}
	}
	
	public void createRoom(String roomName)
	{
		if (!exists)
		{
			exists = true;
			name = roomName;
			locked = false;
			item = new Thing[50];	//Initialize rooms with 50 slots
			
			//Initialize empty room inventories
			for (int x = 0; x < item.length; x++)
			{
				item[x] = new Thing();
			}
		}
		else
		{
			System.err.print("\tRoom::createRoom(): Room creation "
					+ "attempted on an existing room. Fatal error.\n");
			System.exit(0);
		}
	}
	
	public void addThing(Thing newThing)
	{
		//Variables
		int i = 0;
		
		//Look for first available slot to add an item into
		while (item[i].exists() && i < item.length)
		{
			i++;
		}
		item[i] = newThing;
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
	public void setDescription(String withGrav, String noGrav)
	{
		gravDescr = withGrav;
		antiGravDescr = noGrav;
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
	
	public Thing[] getVisibleInventory()
	{
		//Variables
		Thing[] returnThis;
		int sizeCounter;
		
		//Initialize
		sizeCounter = 0;
		
		//Look through inventory and count the number of visible items
		for (int x = 0; x < item.length; x++)
		{
			//If an item isn't hidden, count it
			if (!item[x].isHidden() && item[x].exists())
			{
				sizeCounter++;
			}
		}
		//Initialize the return array's size and reset sizeCounter
		returnThis = new Thing[sizeCounter];
		sizeCounter = 0;
		
		//Loop and add visible items
		for (int x = 0; x < item.length; x++)
		{
			//Add it if it's not hidden
			if (!item[x].isHidden() && item[x].exists())
			{
				returnThis[sizeCounter] = item[x];
				sizeCounter++;
			}
		}
		return returnThis;
	}
	public Thing removeThing(Thing thisThing)
	{
		Thing transferThis;	//Object that's getting returned
		boolean found;		//Controls if item is found or not
		
		//Initialize
		found = false;
		transferThis = new Thing();
		
		//Search for the item
		for (int x = 0; x < item.length; x++)
		{
			if (thisThing.equals(item[x]))
			{
				transferThis = item[x];
				found = true;
				x = item.length;	//Exit loop
			}
		}
		if (found)
		{
			int THISNEEDSWORK;
		}
		else
		{
			System.err.print("Room::removeThing(): Item not found. "
					+ "Critical error!\n");
		}
		return transferThis;
	}
}
