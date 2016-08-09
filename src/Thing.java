
public class Thing 
{
	private String name, description;
	private boolean exists;

	Thing(String newName, String newDescription)
	{
		name = newName;
		description = newDescription;
		exists = true;
	}

	public Thing()
	{
		name = "";
		description = "";
		exists = false;
	} 

	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public void changeName(String newName)
	{
		name = newName;
	}
	public void changeDescription(String newDescription)
	{
		description = newDescription;
	}

	public boolean exists()
	{
		return exists;
	}
}
