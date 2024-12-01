/*
 * GCAM Devs - Cora Bangert, Meagan Callahan, Adam Kuhn, Gage Lefevre
 * Final Project, 12/1
 * 
 * StatsView.java
 * The stats page of the game which extends BorderPane and can be created as an instance so it can be added to the scene in WebsiteTemplate. shows stats and allows access to the player inventory
 */

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class StatsView extends BorderPane {
	static Label ppStat;
	static Label bugsStat;
	static Label atkStat;
	static Label defStat;
	static Label[] extNames, extDescs;
	static String[] extNameStrings, extDescStrings;
	static Pagination extSelect;
	static VBox left, right;

	public StatsView() {

		FlowPane ppFlowPane = new FlowPane(20, 20); // Health display
		Label ppLabel = new Label("PP: ");
		ppLabel.getStyleClass().add("h1");
		ppStat = new Label();
		ppStat.getStyleClass().add("h1");
		ppFlowPane.getChildren().addAll(ppLabel, ppStat);

		FlowPane atkFlowPane = new FlowPane(20, 20); // ATK display
		Label atkLabel = new Label("ATK: ");
		atkLabel.getStyleClass().add("h1");
		atkStat = new Label();
		atkStat.getStyleClass().add("h1");
		atkFlowPane.getChildren().addAll(atkLabel, atkStat);

		FlowPane defFlowPane = new FlowPane(20, 20); // DEF display
		Label defLabel = new Label("DEF: ");
		defLabel.getStyleClass().add("h1");
		defStat = new Label();
		defStat.getStyleClass().add("h1");
		defFlowPane.getChildren().addAll(defLabel, defStat);

		FlowPane bugsFlowPane = new FlowPane(20, 20); // progress display
		Label bugsLabel = new Label("Bugs Defeated: ");
		bugsLabel.getStyleClass().add("h1");
		bugsStat = new Label();
		bugsStat.getStyleClass().add("h1");
		bugsFlowPane.getChildren().addAll(bugsLabel, bugsStat);

		Button inventory = new Button("Inventory"); // access inventory button
		inventory.setOnAction(e -> WebsiteTemplate.enterInventory("tab"));
		inventory.getStyleClass().add("normal-buttons");

		left = new VBox(); // VBox containing stats and inventory button
		left.setSpacing(50);
		left.getChildren().addAll(ppFlowPane, atkFlowPane, defFlowPane, bugsFlowPane, inventory);

		extNameStrings = new String[6]; // extension names for Pagination (start as ???)
		for (int i = 0; i < extNameStrings.length; i++) {
			extNameStrings[i] = "???";
		}

		extDescStrings = new String[6]; // extension descriptions for Pagination (start as hints)
		extDescStrings[0] = "Carried by a strange, unnatural looking bug...\n\nIt seems fond of Unc. He reminds it of Samsa.";
		extDescStrings[1] = "Carried by a magical bug...\n\nMessengers of the Lag Witch tend to cause loading failures.";
		extDescStrings[2] = "Carried by a small, innocent seeming bug...\n\nIt enjoys hiding in plain sight, a trait learned from its boss, the Trojan Horse.";
		extDescStrings[3] = "Carried by Samsa...\n\nHis abnormal form has been said to impact his surroundings.";
		extDescStrings[4] = "Carried by the Lag Witch...\n\nHer powers often make her victims lose patience with a faulty button.";
		extDescStrings[5] = "Carried by the Trojan Horse...\n\nA cunning foe, this virus lures in its victims with the promise of enticing rewards.";

		extNames = new Label[6]; // Labels for names
		extDescs = new Label[6]; // TextAreas for descs

		for (int i = 0; i < 6; i++) { // initialize labels and text areas
			extNames[i] = new Label(extNameStrings[i]);
			extDescs[i] = new Label(extDescStrings[i]);

			extNames[i].setFont(Font.font("", FontWeight.BOLD, 20));
			extDescs[i].setFont(new Font(16));
			extDescs[i].setMinHeight(200);
			extDescs[i].setMinWidth(600);
		}

		extSelect = new Pagination(6, 0); // Pagination to show all extensions
		extSelect.setPageFactory(new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				return createExtPage(pageIndex);
			}
		});

		Label extTitle = new Label("Extensions"); // Extension title label
		extTitle.getStyleClass().add("h1");

		right = new VBox(40, extTitle, extSelect); // Extension menu
		right.setAlignment(Pos.TOP_CENTER);

		BorderPane layout = new BorderPane();

		layout.setLeft(left);
		layout.setRight(right);
		BorderPane.setMargin(layout, new Insets(80, 100, 20, 100));

		this.getStyleClass().add("main-padding");
		this.setCenter(layout);
		update();

	}

	public static Node createExtPage(int pageIndex) { // Pagination page creation
		if (pageIndex >= 0 && pageIndex < extNames.length) {
			VBox page = new VBox(10, extNames[pageIndex], extDescs[pageIndex]);
			page.setAlignment(Pos.TOP_CENTER);
			return page;
		}

		return null;
	}

	public static void addExtension(int id, String name, String description) { // Pagination update for added extensions

		Platform.runLater(() -> {
			if (id >= 0 && id < extNames.length) {
				extNames[id].setText(name);
				extDescs[id].setText(description);
			}

		});
	}

	public static void update() { // refresh stats
		ppStat.setText(String.valueOf(Utility.getPlayerHP()));
		atkStat.setText(String.valueOf(Utility.getPlayerATK() + "(" + String.valueOf(Utility.getTempATK()) + ")"));
		defStat.setText(String.valueOf(Utility.getPlayerDEF() + "(" + String.valueOf(Utility.getTempDEF()) + ")"));
		bugsStat.setText(String.valueOf(Utility.bugsDefeated));

	}
}
