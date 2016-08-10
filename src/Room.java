/*
 * Room class: This room keeps track of a room 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   antiGravDesc   String		any			 Room desc. when gravity is off
   exists		  boolean		t/f		     Checks if room exists
   item[]		  Thing array   any			 Items in that room
   gravDesc       String		any			 Room desc. when gravity is on
   locked		  boolean		t/f			 Whether or not the door is locked
   name			  String		any			 Room name
 *
 *
 */
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
	/*
 *  createRoom(String roomName)
 * Creates a room
 * Pre: none
 * Post: Room is created
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   roomName		  String		any			 Room name
   
 *
 *
 */
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
		/*
 * addThing(Thing newThing)
 * Adds an item
 * Pre: none
 * Post: Item added to room
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   newThing		  Thing			any			 Item added
   
 *
 *
 */
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
			/*
 * deleteRoom()
 * Deletes a room
 * Pre: none
 * Post: Room is deleted
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
  
 *
 *
 */
	public void deleteRoom()
	{
		exists = false;
	}
			/*
 * setInventory(Thing things[])
 * Sets inventory for room
 * Pre: none
 * Post: inventory set
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   things[]		  Thing 		any		     Items being added
   
 */
	public void setInventory(Thing things[])
	{
		item = things;
	}
				/*
 * setLocked(boolean lockIt)
 * Locks a room or unlocks
 * Pre: none
 * Post: door lock state changed
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   things[]		  Thing 		any		     Items being added
   
 */
	public void setLocked(boolean lockIt)
	{
		locked = lockIt;
	}
/*
 * changeName(String newName))
 * Sets the name
 * Pre: none
 * Post: name changes 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   newName		  String		any			 New name
   
 */
	public void changeName(String newName)
	{
		name = newName;
	}
	/*
 * changeDescription(String newDesc, boolean gravity)
 * Sets the description(s)
 * Pre: none
 * Post: description changes 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   gravity		  boolean		t/f			 Gravity on/off
   newDesc		  String		any			 New description
   
 */
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
		/*
 * getName()
 * Gets the name
 * Pre: none
 * Post: name is returned
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
 */
	public String getName()
	{
		return name;
	}
	
	
	/*
 * setDescription(String withGrav, String noGrav)
 * Sets both descriptions
 * Pre: none
 * Post: description changes 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   noGrav		  String		any			 No Grav. desc
   withGrav		  String		any		     Grav. on desc
   n
   
 */
	public void setDescription(String withGrav, String noGrav)
	{
		gravDescr = withGrav;
		antiGravDescr = noGrav;
	}
		/*
 * getDescription(boolean gravity)
 * Gets the description
 * Pre: none
 * Post: dec returned
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   gravity		  boolean		any			 Gravity on/off
   
 */
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
			/*
 * exists()
 * Gets exist
 * Pre: none
 * Post: exists returned 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   
 */
	public boolean exists()
	{
		return exists;
	}
	/*
 * locked()
 * Gets locked
 * Pre: none
 * Post: locked returned 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   
 */
	public boolean locked()
	{
		return locked;
	}
		/*
 * getRoomInventory()
 * Gets inventory
 * Pre: none
 * Post: locked returned 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   
 */
	public Thing[] getRoomInventory()
	{
		return item;
	}
			/*
 * getVisibleInventory()
 * Gets inventory
 * Pre: none
 * Post: inv returned 
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   
 */
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
/*
 * removeThing(Thing thisThing)
 * removes a thing
 * Pre: none
 * Post: thing removed
 *  NAMETYPE       VALUE        RANGE	      DESCRIPTION
   =========      ===========   ===========  ====================
   thisThing	  any		    any			 Item to be removed
   
 */
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
