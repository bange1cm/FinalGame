
public class Utility {

	public static int bugsDefeated = 0;
	public static int totalBugs = 5;

	//keeps track of turns and enemy turns
	private static int combatTurn = 0;
	private static boolean enemyAttacked = false;

	private static int playerMaxHP;
	private static int playerHP;
	private static int playerATK;
	private static int playerDEF;

	private static int tempATK = 0;
	private static int tempDEF = 0;

	private static boolean hasRngSeed = false;
	private static boolean hasConnection = false;
	private static boolean hasFirewall = false;
	private static boolean hasAIAssistant = false;
	private static boolean hasVpn = false;
	private static boolean hasAdBlock = false;

	public static void initialize() {
		ItemMap.initializeMap();
		playerMaxHP = 10;
		playerHP = playerMaxHP;
		playerATK = 10;
		playerDEF = 10;
	}

	public static void damage(int dmg) {
		playerHP -= (dmg - ((playerDEF + tempDEF) / 2));
	}

	public static void heal(int hp) {
		if (playerHP + hp > playerMaxHP) {
			playerHP = playerMaxHP;
		} else {
			playerHP += hp;
		}
	}

	public static void useSearch() {
		tempATK += 5;
	}

	public static void usePassword() {
		tempDEF += 5;
	}

	public static void resetTempStats() {
		tempATK = 0;
		tempDEF = 0;
	}

	public static void attack(Enemy e) {
		if (!enemyAttacked) {
			e.setHp(e.getHp() - ((playerATK + tempATK) - (e.getDef() / 2)));
		}
	}

	public static void install(int id) {
		switch (id) {
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
			if (!hasAIAssistant) {
				hasAIAssistant = true;
				playerMaxHP *= 2;
			}
			break;
		case 4:
			if (!hasVpn) {
				hasVpn = true;
				playerATK *= 2;
			}
			break;
		case 5:
			if (!hasAdBlock) {
				hasAdBlock = true;
				playerDEF *= 2;
			}
			break;
		}
	}

	public static int getPlayerMaxHP() {
		return playerMaxHP;
	}

	public static int getPlayerHP() {
		return playerHP;
	}

	public static int getPlayerATK() {
		return playerATK;
	}

	public static int getPlayerDEF() {
		return playerDEF;
	}

	public static int getTempATK() {
		return tempATK;
	}

	public static int getTempDEF() {
		return tempDEF;
	}

	public static boolean hasRngSeed() {
		return hasRngSeed;
	}

	public static boolean hasConnection() {
		return hasConnection;
	}

	public static boolean hasFirewall() {
		return hasFirewall;
	}
}
