
public class Utility {

	private static int playerHP;
	private static int playerATK;
	private static int playerDEF;
	
	public static void damage(int dmg) {
		playerHP -= (dmg - (playerDEF/2));
	}
	
	public static void heal(int hp) {
		playerHP += hp;
	}
	
	public static int attack(Enemy e) {
		e.setHP(e.getHP - (playerATK - (e.getDef() / 2)));
	}
}
