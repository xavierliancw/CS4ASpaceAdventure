
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

	Thing(String newName, String newDescription, boolean isHidden, boolean newPocketable)
	{
		name = newName;
		description = newDescription;
		hidden = isHidden;
		pocketable = newPocketable;
		exists = true;
	}

	Thing mk27PDW("Mk_27 PDW", "Small lightweight automatic weapon designed for low gravity use. Commonly seen in Camorran boarding parties. Fires small lightweight rounds at very high rate of fire.", false, true);
	backpack.addThing(mk27PDW);

	Thing mk3Pistol("Mk_3 Light Pistol", "Standard issue sidearm of the Camorran navy, fires an intermediate caliber. Useful on world on in low gravity environments.", false, true);
	backpack.addThing(mk3LightPistol);

	//GALLEY ITEMS
	Thing AgedSideronWine("Aged Sideron Wine", "Some of the finest wine found the Collective, the Sideron family of Pavela are some the last of the wine producers that don’t grow their grapes in artificial farms. A bottle this old and of this winery would be worth a good chunk of credits. ", false, true);
	map[1][3].addThing(agedSideronWine);

	Thing KitchenTerminal("Kitchen Terminal", "I am beginning to think that I shouldn’t have taken this job. Yes I was paid twice of what I am worth but something is just odd. Not to mention that I have had to make full on meals at least 3 nights in a row, on top of the rest of the meals. Yesterday they had some guys come on to meet with the captain, looked they were from Tamarain, with their robotic arms, I’ll admit they looked scary, but they didn’t talk much. But they sure do eat a lot. I think that they are in the cargo bay now for their deal or whatever. Wait is that gunfire? WHat IS HA-", false, false);
	map[1][3].addThing(kitchenTerminal);

	Thing bodiesKitchen("Bodies", "Two men dressed in chef's attire, cause of death: suffocation from depressurization.", false, false);
	map[1][3].addThing(bodiesKitchen);

	Thing agedSideronWine("Aged Sideron Wine", "Some of the finest wine found the Collective, the Sideron family of Pavela are some the last of the wine producers that don’t grow their grapes in artificial farms. A bottle this old and of this winery would be worth a good chunk of credits. ", false, true);
	backpack.addThing(mk3LightPistol);

	//PARTY COMMONS
	Thing officerBody("Officer's Body", "The floating body is dressed in his officer uniform... His key card seems to be in his pocket! That could prove useful.", false, false);
	map[2][3].addThing(officerBody);

	Thing keyCard("Officer's Key Card", "Keycard that unlocks the bridge.  Found in officer body's pocket.", false, true);
	map[2][3].addThing(keyCard);

	Thing partyTablet("Partygoer's Tablet", "This seems enjoyable to take... Better not let temptation set in.  Ah, the good ol' days.", false, true);
	map[2][3].addThing(partyTablet);

	//MED BAY
	Thing painkillers("Painkillers", "Advanced pain pills that completely block pain", false, true);
	map[3][3].addThing(painkillers);
	
	Thing radAway("Anti Rad meds", "Pills designed to minimize the effects of radiation, popular amongst drive core engineers during emergencies.", false, true);
	map[3][3].addThing(radAway);
	
	Thing bloodPack("Transfusion Pack", "Advanced synthetic blood pack that works with any blood type in the event that a blood transfusion is needed.", false, true);
	map[3][3].addThing(bloodPack);

	//QUARTERS
	Thing survivalRifle("Survival Rifle", "High caliber rifle meant for exploring unknown planets and self defense against humans if need be. Collapses down small enough to fit in the small cargo chambers of any small fighter.", false, true);
	map[2][5].addThing(survivalRifle);

	//CAPTAIN'S QUARTERS
	Thing deskComputer("Desk Computer", "There's a sticky note on the desktop, it says server room password: 1234. Not too secure if you ask me.", false, false);
	map[3][6].addThing(deskComputer);

	Thing diaryEntry("Diary Entry", "The diary reads: Tamarainians are coming today, lets hope this deal goes smoothly. I like to think I make good deals, maybe even the best deals in the entire collective. But I may be going up against some very good negotiators, so let’s-", false, true);
	map[3][6].addThing(diaryEntry);

	//FRONT RESTROOM
	Thing vertigo("Vertigo", "Highly addictive drug that simulates weightlessness and relaxes the muscles. ", false, true); 
	map[1][6].addThing(vertigo);

	//SERVER ROOM
	Thing serverTerm("Server Terminal", "You insert your sd card and gather all information that the ship has on it's computer.", false , false);
	map[2][7].addThing(serverTerm);
	
	//CARGO ROOM
	Thing weapCrate("Weapons crate", "You see a large variety of military grade weapons and ammunition, as well as full combat suits.", false, false);
	Tmap[2][1].addThing(weapCrate);
	Thing tmrAr("Tamaraini Assault Rifle", "Standard issue weapon for the Tamaraini army. The weapon is a large caliber bullpup, firing conventional bullets capable of various fire modes.", false, true);
	Tmap[2][1].addThing(tmrAr);
	Thing pdp("Pilot’s defense pistol", "Small pistol designed to be easily carried in pilot suit. Fires small, low penetration bullets to avoid critical damage to a ship components in case of a firefight.", false, true);
	map[2][1].addThing(pdp);
	Thing plp("Pavelan light pistol.", "Standard issue sidearm for the Pavelan military that fires a small burst of solist energy. Extremely versatile due to its ability to simulate many different calibers of its conventional counterparts but very expensive to produce.", false, true);
	map[2][1].addThing(plp);
	
	//REACTOR ROOM
	Thing reactTerm("Reactor terminal", "Downloading diagnostics now", false, false);
	map[2][0].addThing(reactTerm);

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
