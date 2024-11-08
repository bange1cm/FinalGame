
public class Utility {

	private static int playerHP;
	private static int playerATK;
	private static int playerDEF;
	
	public static void damage(int dmg) {
		playerHP -= (dmg - (playerDEF/2));
		System.out.println("You take damage");
	}
	
	public static void heal(int hp) {
		playerHP += hp;
		System.out.println("You heal");
	}
	
	public static void attack(Enemy e) {
		e.setHp(e.getHp() - (playerATK - (e.getDef() / 2)));
		System.out.println("You attack");
	}
}
