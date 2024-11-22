
public class Enemy {
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

	public static void dropItem() {
		ItemMap.obtain(new Cookie((int) Math.random() * 3));
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
	
	public void metamorphosize() {
		metaRNG = (int) Math.random() * 3;
		
		if(metaRNG == 0) {
			this.atk = this.atk - trackBoost;
			this.def = this.def - trackBoost;
			trackBoost = 0;
		} else {
			this.atk += metaRNG;
			this.def += metaRNG;
			trackBoost += metaRNG;
		}
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
		//call utility method to attack player
		Utility.damage(atk);
		trackVenom = true;
	}
	
	public void venom() {
		if(trackVenom) {
			// call utility method to attack player for half of atk stat
			Utility.damage(atk/2);
			trackVenom = false;
		}
	}
}

class Trojan extends Virus{ //unsure how to implement currently. probably depends on combat interface
	
	public Trojan(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 5;
	}
}
