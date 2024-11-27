import java.util.LinkedHashMap;
import java.util.Map;

public class ItemMap {

	private static Map<Item, Integer> itemMap = new LinkedHashMap<Item, Integer>();

	public static void initializeMap() {
		itemMap.put(new Cookie(0), 0);
		itemMap.put(new Cookie(1), 0);
		itemMap.put(new Cookie(2), 0);
	}

	public static Map<Item, Integer> getItemMap() {
		return itemMap;
	}

	public static void obtain(Item item) {
		if (itemMap.containsKey(item)) {
			itemMap.put(item, itemMap.get(item) + 1);
			System.out.println("Item found in map - incremented");
		} else {
			itemMap.put(item, 1);
			System.out.println("Item added to map");
		}
		
	}

	public static void use(Item item) {
		if (itemMap.get(item) == 0) {
			return;
		}

		switch (item.getName()) {
		case "Web Cookie":
			Utility.heal(7);
			itemMap.put(item, itemMap.get(item) - 1);
			break;
		case "Search":
			Utility.useSearch();
			itemMap.put(item, itemMap.get(item) - 1);
			break;
		case "Password":
			Utility.usePassword();
			itemMap.put(item, itemMap.get(item) - 1);
			break;
		case "RNG Seed":
			Utility.install(0);
			itemMap.remove(item);
			break;
		case "High-Speed Connection":
			Utility.install(1);
			itemMap.remove(item);
			break;
		case "Firewall":
			Utility.install(2);
			itemMap.remove(item);
			break;
		case "AI Assistant":
			Utility.install(3);
			itemMap.remove(item);
			break;
		case "VPN":
			Utility.install(4);
			itemMap.remove(item);
			break;
		case "AdBlock":
			Utility.install(5);
			itemMap.remove(item);
			break;
		}
	}
}
