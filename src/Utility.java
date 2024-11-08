
public class Utility {

	private static int playerHP;
	private static int playerATK;
	private static int playerDEF;

	private static boolean hasRngSeed = false;
	private static boolean hasConnection = false;
	private static boolean hasFirewall = false;
	private static boolean hasAIAssistant = false;
	private static boolean hasVpn = false;
	private static boolean hasAdBlock = false;
	
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

	public static void install(int id) {
		switch(id) {
			case 0:
				hasRngSeed = true;
				break;
			case 1:
				hasConnection = true;
				break;
			case 2:
				hasFirewall = true;
				break;
			case 3:
				if(!hasAIAssistant) {
					hasAIAssistant = true;
					playerHP *= 2;
				}
				break;
			case 4:
				if(!hasVpn) {
					hasVpn = true;
					playerATK *= 2;
				} 
				break;
			case 5:
				if(!hasAdBlock) {
					hasAdBlock = true;
					playerDEF *= 2;
				} 
				break;
		}
}
