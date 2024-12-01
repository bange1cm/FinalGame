/*
 * GCAM Devs - Cora Bangert, Meagan Callahan, Adam Kuhn, Gage Lefevre
 * Final Project, 12/1
 * 
 * Item.java
 * The Item class which has children Cookie and Extension and contains an id, name, and description. Item objects can be used by the player
 */

public abstract class Item {
	// item id, name to show in ui
	protected int id;
	protected String name, description;

	// constructor
	public Item(int id) {
		this.id = id;
	}

	// getters, no setters since the id determines the name/description
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	// checks if an item is equal to another Item
	@Override
	public boolean equals(Object obj) {
		Item item = (Item) obj;
		return this.name.equals(item.name);
	}

	// gets item hashcode
	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

}

// cookie item class which extends Item and acts as a healing item
class Cookie extends Item {

	// constructor, checks id of the cookie and determines the name and description
	public Cookie(int id) {
		super(id);
		switch (id) {
		case 0:
			this.name = "Web Cookie";
			this.description = "Cookie: Restore 7 HP.";
			break;
		case 1:
			this.name = "Search";
			this.description = "Cookie: Raise ATK by 5 for duration of one fight.";
			break;
		case 2:
			this.name = "Password";
			this.description = "Cookie: Raise DEF by 5 for duration of one fight.";
			break;

		}
	}

}

//Extension class which extends Item and acts as power-up items, must be "installed"
class Extension extends Item {

	// constructor which checks the id of the item and determines the name and
	// description
	public Extension(int id) {
		super(id);
		switch (id) {
		case 0:
			this.name = "RNG Seed";
			this.description = "Extension: Makes Samsa more likely to reset his stats.";
			break;
		case 1:
			this.name = "High-Speed Connection";
			this.description = "Extension: Disables Lag Witch's venom.";
			break;
		case 2:
			this.name = "Firewall";
			this.description = "Extension: Sets Trojan Horse's DEF to 0.";
			break;
		case 3:
			this.name = "AI Assistant";
			this.description = "Extension: Permanently double PP.";
			break;
		case 4:
			this.name = "VPN";
			this.description = "Extension: Permanently double ATK.";
			break;
		case 5:
			this.name = "AdBlock";
			this.description = "Extension: Permanently double DEF.";
			break;
		}
	}

	// installs extension so it can be active
	public void install() {
		Utility.install(id);
	}

}
