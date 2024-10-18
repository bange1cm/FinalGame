
public class Item {
	// item id, name to show in ui
	protected int id;
	protected String name;

	public Item(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

class Cookie extends Item {
	//quantity 
private int qty;
	
	public Cookie(int id, String name) {
		super(id, name);
	}
	
	public void useCookie() {
		// reduces qty by 1 and increases player hp
	}

}

class Extension extends Item {

	public Extension(int id, String name) {
		super(id, name);
	}
	
	public void Extension() {
		//adds extension to player and modifies player stats
	}

}
