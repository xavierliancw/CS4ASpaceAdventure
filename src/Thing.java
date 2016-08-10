
public class Thing 
{
	private boolean exists;
	private String name, description;	//Name and description
	private boolean hidden;				//Controls visibility
	private boolean pocketable;			//Controls if this can be grabbed

	Thing(String newName, String newDescription)
	{
		name = newName;
		description = newDescription;
		exists = true;
		pocketable = true;
	}

	
	Thing(String newName, String newDescription, boolean isHidden)
	{
		name = newName;
		description = newDescription;
		hidden = isHidden;
		pocketable = true;
		exists = true;
	}

	public Thing()
	{
		name = "";
		description = "";
		exists = false;
		hidden = false;
	} 

	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}

	public boolean exists()
	{
		return exists;
	}

	public void setExists(boolean newExists)
	{
		exists = newExists;
	}

	public void setPocketable(boolean isPocketable)
	{
		pocketable = isPocketable;
	}
	public boolean isHidden()
	{
		return hidden;
	}
	public boolean isPocketable()
	{
		return pocketable;
	}
	public String toString()
	{
		return name;
	}
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
