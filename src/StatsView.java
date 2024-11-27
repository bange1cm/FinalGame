import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class StatsView extends BorderPane{
	static Label ppStat;
	static Label bugsStat;
	static Label atkStat;
	static Label defStat;
	static Label[] extNames;
	static TextArea[] extDescs;
	static String[] extNameStrings, extDescStrings;
	static Pagination extSelect;
	
	public StatsView() {
		
		FlowPane ppFlowPane = new FlowPane(20, 20);
		Label ppLabel = new Label("PP: ");
		ppLabel.getStyleClass().add("h1");
		ppStat = new Label();
		ppStat.getStyleClass().add("h1");
		ppFlowPane.getChildren().addAll(ppLabel, ppStat);
		
		FlowPane atkFlowPane = new FlowPane(20, 20);
		Label atkLabel = new Label("ATK: ");
		atkLabel.getStyleClass().add("h1");
		atkStat = new Label();
		atkStat.getStyleClass().add("h1");
		atkFlowPane.getChildren().addAll(atkLabel, atkStat);
		
		FlowPane defFlowPane = new FlowPane(20, 20);
		Label defLabel = new Label("DEF: ");
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
		
		Button inventory = new Button("Inventory");
		inventory.setOnAction(e -> WebsiteTemplate.enterInventory("tab"));
		inventory.getStyleClass().add("normal-buttons");
		
		VBox left = new VBox();
		left.setSpacing(50);
		left.getChildren().addAll(ppFlowPane, atkFlowPane, defFlowPane, bugsFlowPane, inventory);
		
		extNameStrings = new String[6];
		for(int i = 0; i < extNameStrings.length; i++) {
			extNameStrings[i] = "???";
		}
		
		extDescStrings = new String[6];
		extDescStrings[0] = "Carried by a strange, unnatural looking bug...\n\nIt seems fond of Unc. He reminds it of Samsa.";
		extDescStrings[1] = "Carried by a magical bug...\n\nMessengers of the Lag Witch tend to cause loading failures.";
		extDescStrings[2] = "Carried by a small, innocent seeming bug...\n\nIt enjoys hiding in plain sight, a trait learned from its boss, the Trojan Horse.";
		extDescStrings[3] = "Carried by Samsa...\n\nHis abnormal form has been said to impact his surroundings.";
		extDescStrings[4] = "Carried by the Lag Witch...\n\nHer powers often make her victims lose patience with a faulty button.";
		extDescStrings[5] = "Carried by the Trojan Horse...\n\nA cunning foe, this virus lures in its victims with the promise of enticing rewards.";
		
		extNames = new Label[6];
		extDescs = new TextArea[6];
		
		for(int i = 0; i < 6; i++) {
			extNames[i] = new Label(extNameStrings[i]);
			extDescs[i] = new TextArea(extDescStrings[i]);
			
			extNames[i].setFont(Font.font("", FontWeight.BOLD, 20));
			extDescs[i].setFont(new Font(16));
			extDescs[i].setEditable(false);  
		}
		
		extSelect = new Pagination(6, 0);
		extSelect.setPageFactory(new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				return createExtPage(pageIndex);
			}
		});
		
		Label extTitle = new Label("Extensions");
		extTitle.getStyleClass().add("h1");
		
		VBox right = new VBox(extTitle, extSelect);
		right.setAlignment(Pos.TOP_CENTER);
		
		this.getStyleClass().add("main-padding");
		this.setLeft(left);
		this.setRight(right);
		update();
		
	}
	
	public static Node createExtPage(int pageIndex) {
		if(pageIndex >= 0 && pageIndex < extNames.length) {
			VBox page = new VBox(extNames[pageIndex], extDescs[pageIndex]);
			page.setAlignment(Pos.TOP_CENTER);
			return page;
		} 
		
		return null;
	}
	
	public static void addExtension(int id, String name, String description) {
        if (id >= 0 && id < extNames.length) {
        	extNames[id].setText(name);
        	extDescs[id].setText(description);
        }
        
        extSelect.setPageFactory(new Callback<Integer, Node>() {
            public Node call(Integer pageIndex) {
                return createExtPage(pageIndex);
            }
        });
        
        System.out.println("Page " + id + " updated.");
    }

	public static void update() {
		ppStat.setText(String.valueOf(Utility.getPlayerHP()));
		atkStat.setText(String.valueOf(Utility.getPlayerATK() + "(" + String.valueOf(Utility.getTempATK()) + ")"));
		defStat.setText(String.valueOf(Utility.getPlayerDEF() + "(" + String.valueOf(Utility.getTempDEF()) + ")"));
		bugsStat.setText(String.valueOf(Utility.bugsDefeated));
		
	}
}
