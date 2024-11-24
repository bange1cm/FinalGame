
public abstract class Item {
	// item id, name to show in ui
	protected int id;
	protected String name, description;

	public Item(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}

}

class Cookie extends Item {

	public Cookie(int id) {
		super(id);
		switch(id) {
			case 0:
				this.name = "Web Cookie";
				this.description = "Cookie: Restore 5 HP.";
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

	public void useCookie() {
		
	}

}

class Extension extends Item {

	public Extension(int id) {
		super(id);
		switch(id) {
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

	public void install() {
		Utility.install(id);
	}

}
