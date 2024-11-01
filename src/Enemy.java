
public class Enemy {
	// health, attack, and defense variables
	protected int hp;
	protected int atk;
	protected int def;

	// constructor
	public Enemy(int hp, int atk, int def) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}

	// attacks player
	public void attack() {
		// player hp - enemy attack variable, calls from utility class method

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
}

class Bug extends Enemy {

	public Bug(int hp, int atk, int def) {
		super(hp, atk, def);
	}

}

class Virus extends Enemy {
	// extension id
	private int extId;

	public Virus(int hp, int atk, int def, int extId) {
		super(hp, atk, def);
		this.extId = extId;
		// TODO Auto-generated constructor stub
	}

}

class Samsa extends Virus {
	
	private static int metaRNG;
	private static int trackBoost;
	
	public Samsa(int hp, int atk, int def, int extId) {
		super(hp, atk, def, extId);
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
	
	public LagWitch(int hp, int atk, int def, int extId) {
		super(hp, atk, def, extId);
	}
	
	@Override
	public void attack() {
		//call utility method to attack player
		trackVenom = true;
	}
	
	public static void venom() {
		if(trackVenom) {
			// call utility method to attack player for half of atk stat
			trackVenom = false;
		}
	}
}

class Trojan extends Virus{ //unsure how to implement currently. probably depends on combat interface
	
	public Trojan(int hp, int atk, int def, int extId) {
		super(hp, atk, def, extId);
	}
}
