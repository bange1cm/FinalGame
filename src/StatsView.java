import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class StatsView extends VBox{
	static Label ppStat;
	static Label bugsStat;
	static Label atkStat;
	static Label defStat;
	
	public StatsView() {
		
		FlowPane ppFlowPane = new FlowPane(20, 20);
		Label ppLabel = new Label("Your HP: ");
		ppLabel.getStyleClass().add("h1");
		ppStat = new Label();
		ppStat.getStyleClass().add("h1");
		ppFlowPane.getChildren().addAll(ppLabel, ppStat);
		
		FlowPane atkFlowPane = new FlowPane(20, 20);
		Label atkLabel = new Label("Your Atack: ");
		atkLabel.getStyleClass().add("h1");
		atkStat = new Label();
		atkStat.getStyleClass().add("h1");
		atkFlowPane.getChildren().addAll(atkLabel, atkStat);
		
		FlowPane defFlowPane = new FlowPane(20, 20);
		Label defLabel = new Label("Your Defense: ");
		defLabel.getStyleClass().add("h1");
		defStat = new Label();
		defStat.getStyleClass().add("h1");
		defFlowPane.getChildren().addAll(defLabel, defStat);
		
		FlowPane bugsFlowPane = new FlowPane(20, 20);
		Label bugsLabel = new Label("Bugs Defeated: ");
		bugsLabel.getStyleClass().add("h1");
		bugsStat = new Label();
		bugsStat.getStyleClass().add("h1");
		bugsFlowPane.getChildren().addAll(bugsLabel, bugsStat);
		
		Button inventory = new Button("See item inventory");
		inventory.setOnAction(e -> WebsiteTemplate.enterInventory("tab"));
		inventory.getStyleClass().add("normal-buttons");
		
		  
		this.setSpacing(50);
		this.getStyleClass().add("main-padding");
		this.getChildren().addAll(ppFlowPane, atkFlowPane, defFlowPane, bugsFlowPane, inventory);
		update();
		
	}

	public static void update() {
		ppStat.setText(String.valueOf(Utility.getPlayerHP()));
		atkStat.setText(String.valueOf(Utility.getPlayerATK()));
		defStat.setText(String.valueOf(Utility.getPlayerDEF()));
		bugsStat.setText(String.valueOf(Utility.bugsDefeated));
		
	}
}
