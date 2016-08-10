/* Program Alien created by Nabil Farooqi

- - - - - - - - - -
Problem Statement:
- - - - - - - - - - 
This class represents items that are within the game.  Items may or may not be put in the user's inventory, examined or used.

- - - - - - - -  
Overall Plan:
- - - - - - - - 
1. Instance variables for thing are in class
2. Instance variables are instantiated, accompanied by getter and setter methods as well as constructors
3. Booleans and toString and equals method are invoked

- - - - - - - - - 
Main Class Used:
- - - - - - - - - 
class Thing
- - - - - - - - - - 
Main Methods Used:
- - - - - - - - - - 
public boolean equals(Object other)
public boolean exists()
public boolean isHidden()
public boolean isPocketable()
public void setDescription(String newDescription)
public void setExists(boolean newExists)
public void setName(String newName)
public void setPocketable(boolean isPocketable)
public String toString()
public String getDescription()
public String getName()
public Thing()
Thing(String newName, String newDescription)
Thing(String newName, String newDescription, boolean isHidden)
Thing(String newName, String newDescription, boolean isHidden, boolean newPocketable)
Thing(String newName, String newDescription, boolean isHidden, boolean newPocketable)


- - - - - - - - - - - - - - - - - - - - - - - - - -
Data Dictionary can be found at each method below.
- - - - - - - - - - - - - - - - - - - - - - - - - -
*/


public class Thing 
{
		//mutator methods below for health, name and damage
	/*
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	Data Dictionary:
	NAME 			TYPE 		RANGE 		DESCRIPTION
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	description  	String 		none 		Descrip. text of item
	exists 			boolean 	T or F 		Whether an item is existing
	name 			String 		none 		Name text of item
	pocketable 		boolean  	T or F 		Whether an item can be kept
	*/

	private boolean exists;
	private String name, description;	//Name and description
	private boolean hidden;				//Controls visibility
	private boolean pocketable;			//Controls if this can be grabbed

	/*
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	Data Dictionary:
	NAME 			TYPE 		RANGE 		DESCRIPTION
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	newDescription	String 		none 		Descrip. var of item
	newName 		String 		none 		Name variable of item
	
	[PreCond]- No constructor for thing
	[PostCond]- Constructor for thing
	*/
	Thing(String newName, String newDescription)
	{
		name = newName;
		description = newDescription;
		exists = true;
		pocketable = true;
	}

	/*
	[PreCond]- No constructor for thing with third parameter
	[PostCond]- Constructor for thing with third parameter
	*/
	Thing(String newName, String newDescription, boolean isHidden)
	{
		name = newName;
		description = newDescription;
		hidden = isHidden;
		pocketable = true;
		exists = true;
	}

	/*
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	Data Dictionary:
	NAME 			TYPE 		RANGE 		DESCRIPTION
	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	newDescription	String 		none 		Descrip. var of item
	newName 		String 		none 		Name variable of item
	
	[PreCond]- No constructor for thing with pocketable parameter
	[PostCond]- Constructor for thing with pocketable parameter
	*/
	Thing(String newName, String newDescription, boolean isHidden, boolean newPocketable)
	{
		name = newName;
		description = newDescription;
		hidden = isHidden;
		pocketable = newPocketable;
		exists = true;
	}

	/*
	[PreCond]- No no-arg constructor for thing
	[PostCond]- No-arg constructor for for thing
	*/
	public Thing()
	{
		name = "";
		description = "";
		exists = false;
		hidden = false;
		pocketable = true;
	} 

	/*
	[PreCond]- accessor method for name not present
	[PostCond]- accessor metho for name is present
	*/
	public String getName()
	{
		return name;
	}
	
	/*
	[PreCond]- accessor method for description not present
	[PostCond]- accessor metho for description is present
	*/
	public String getDescription()
	{
		return description;
	}

	/*
	[PreCond]- mutator method for name not present
	[PostCond]- mutator metho for name is present
	*/
	public void setName(String newName)
	{
		name = newName;
	}
	
	/*
	[PreCond]- mutator method for descrip. not present
	[PostCond]- mutator metho for descip. is present
	*/
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}

	/*
	[PreCond]- boolean method for exists not present
	[PostCond]- boolean method for exists is present
	*/
	public boolean exists()
	{
		return exists;
	}

	/*
	[PreCond]- mutator method for exists not present
	[PostCond]- mutator metho for exists is present
	*/
	public void setExists(boolean newExists)
	{
		exists = newExists;
	}

	/*
	[PreCond]- mutator method for pocketable not present
	[PostCond]- mutator method for pocketable is present
	*/
	public void setPocketable(boolean isPocketable)
	{
		pocketable = isPocketable;
	}
	
	/*
	[PreCond]- isHidden method not present
	[PostCond]- isHidden method present
	*/
	public boolean isHidden()
	{
		return hidden;
	}
	
	/*
	[PreCond]- accessor method for pocketable not present
	[PostCond]- accessor methor for pocketable is present
	*/
	public boolean isPocketable()
	{
		return pocketable;
	}
	
	/*
	[PreCond]- toString not present
	[PostCond]- toString present
	*/
	public String toString()
	{
		return name;
	}
	
	/*
	[PreCond]- boolean method with parameter not present
	[PostCond]- boolean method with parameter present
	*/
	public boolean equals(Object other)
	{
		if (toString().equals(other.toString()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
