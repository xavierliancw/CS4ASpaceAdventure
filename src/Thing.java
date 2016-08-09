
public class Thing 
{
	private String name, description;	//Name and description
	private boolean hidden;				//Controls visibility
	
	Thing(String newName, String newDescription, boolean isHidden)
	{
		name = newName;
		description = newDescription;
		hidden = isHidden;
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
	public boolean isHidden()
	{
		return hidden;
	}
}
