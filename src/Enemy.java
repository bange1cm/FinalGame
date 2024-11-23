
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

	// checks the enemy's hp and determines if it's dead or not
	public boolean isDead() {
		return this.hp <= 0;
	}

}

// bug class used for minor enemies, drops items and has hp, atk, def variables for the health, attack, and defense
class Bug extends Enemy {

//bug constructor
	public Bug(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
	}

	// drop item method - determines which item is dropped when killed
	public void dropItem() {
		if (this.imgURL.equals(BUG1)) {
			ItemMap.obtain(new Extension(0));
		} else if (this.imgURL.equals(BUG2)) {
			ItemMap.obtain(new Extension(1));
		} else if (this.imgURL.equals(TROJAN_HORSE_BUG)) {
			ItemMap.obtain(new Extension(2));
		}

		ItemMap.obtain(new Cookie((int) Math.random() * 3));
	}
}

//abstract virus class to be used for major enemies/bosses
abstract class Virus extends Enemy {
	// extension id
	protected int extId;

	// virus constructor
	public Virus(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
	}

	// drop item method, used to gain items to help with other boss fights
	public void dropItem() {
		ItemMap.obtain(new Extension(extId));
		ItemMap.obtain(new Cookie((int) Math.random() * 3));
	}

	// abstract attack method to be implemented by children
	public abstract void attack();

}

//boss virus called Samsa, uses singleton design pattern and has unique attack method
class Samsa extends Virus {
	private static Samsa instance;

	// variables used in attack method
	private static int metaRNG;
	private static int trackBoost;

	private Samsa(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 3;
	}

	// attack method from abstract virus class, determines how much damage samsa
	// does when attacking
	@Override
	public void attack() {
		metaRNG = (int) Math.random() * 3;

		if (metaRNG == 0 || (metaRNG == 1 && Utility.hasRngSeed())) {
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

	// getInstance method to create and get the only instance of Samsa
	public static synchronized Samsa getInstance() {
		if (instance == null) {
			instance = new Samsa(100, 10, 5, SAMSA);
		}

		return instance;
	}
}

//boss virus called LagWitch, uses singleton design pattern and has unique attack method
class LagWitch extends Virus {
	private static LagWitch instance;

	private static Boolean trackVenom;

	private LagWitch(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 4;
	}

	// attack method from abstract virus class, determines how much damage lag witch
	// does when attacking and whether venom is active
	@Override
	public void attack() {
		if (!Utility.hasConnection() && trackVenom) {
			// call utility method to attack player for half of atk stat
			Utility.damage(atk / 2);
		}
		// call utility method to attack player
		Utility.damage(atk);
		trackVenom = true;
	}

	// getInstance method to create and get the only instance of LagWitch
	public static synchronized LagWitch getInstance() {
		if (instance == null) {
			instance = new LagWitch(100, 10, 5, LAG_WITCH);
		}

		return instance;
	}
}

//boss virus called Trojan, uses singleton design pattern and has unique attack method
class Trojan extends Virus { // unsure how to implement currently. probably depends on combat interface
	private static Trojan instance;

	private static Boolean statsLowered = false;

	private Trojan(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
		this.extId = 5;
	}

	// attack method from virus class, determines if player has the firewall
	// extension and if so, lowers Trojan's defense
	public void attack() {
		if (!statsLowered && Utility.hasFirewall()) {
			this.def = 0;
			statsLowered = true;
		}
		Utility.damage(atk);
	}

	// getInstance method to create and get the only instance of Trojan
	public static synchronized Trojan getInstance() {
		if (instance == null) {
			instance = new Trojan(100, 10, 5, TROJAN_HORSE);
		}

		return instance;
	}
}

class BossDev extends Enemy {
	private static BossDev instance;

	private BossDev(int hp, int atk, int def, String imgURL) {
		super(hp, atk, def, imgURL);
	}

	// getInstance method to create and get the only instance of BossDev
	public static synchronized BossDev getInstance() {
		if (instance == null) {
			instance = new BossDev(100, 10, 5, "uncle_anrgy.png");
		}

		return instance;

	}
}

