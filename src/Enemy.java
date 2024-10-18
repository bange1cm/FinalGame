
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
