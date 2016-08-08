
public class Thing 
{
	private String name, description;
	
	Thing(String newName, String newDescription)
	{
		name = newName;
		description = newDescription;
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
}
