
public class Enemy implements EnemyConstants {
	// health, attack, and defense variables
	protected int hp;
	protected int atk;
	protected int def;
	
	protected String imgURL;

	// constructor
	public Enemy(int hp, int atk, int def, String imgURL) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.imgURL = imgURL;
	}

	// attacks player
	public void attack() {
		// player hp - enemy attack variable, calls from utility class method
		Utility.damage(atk);
	}

	// getters and setters
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public Boolean isDead() {
		return this.hp <= 0;
	}
	
}

class Bug extends Enemy {

	public Bug(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
	}

	public void dropItem() {
		if(this.imgURL.equals(BUG1)) {
			ItemMap.obtain(new Extension(0));
		} else if(this.imgURL.equals(BUG2)) {
			ItemMap.obtain(new Extension(1));
		} else if(this.imgURL.equals(TROJAN_HORSE_BUG)) {
			ItemMap.obtain(new Extension(2));
		} else {
			ItemMap.obtain(new Cookie((int) Math.random() * 3));
		}
	}
}

class Virus extends Enemy {
	// extension id
	protected int extId;

	public Virus(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
	}
	
	public void dropItem() {
		ItemMap.obtain(new Extension(extId));
	}

}

class Samsa extends Virus {
	
	private static int metaRNG;
	private static int trackBoost;
	
	public Samsa(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 3;
	}
	
	@Override
	public void attack() {
		metaRNG = (int) Math.random() * 3;
		
		if(metaRNG == 0 || (metaRNG == 1 && Utility.hasRngSeed())) {
			this.atk = this.atk - trackBoost;
			this.def = this.def - trackBoost;
			trackBoost = 0;
		} else {
			this.atk += metaRNG;
			this.def += metaRNG;
			trackBoost += metaRNG;
		}
		
		Utility.damage(atk);
	}
}

class LagWitch extends Virus{
	
	private static Boolean trackVenom;
	
	public LagWitch(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 4;
	}
	
	@Override
	public void attack() {
		if(!Utility.hasConnection() && trackVenom) {
			// call utility method to attack player for half of atk stat
			Utility.damage(atk/2);
		}
		//call utility method to attack player
		Utility.damage(atk);
		trackVenom = true;
	}
}

class Trojan extends Virus{ //unsure how to implement currently. probably depends on combat interface
	
	private static Boolean statsLowered = false;
	
	public Trojan(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 5;
	}
	
	public void attack() {
		if(!statsLowered && Utility.hasFirewall()) {
			this.def = 0;
			statsLowered = true;
		}
		Utility.damage(atk);
	}
}
