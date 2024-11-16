
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Fight extends VBox{
	static HasBug mainPage;
	static Enemy enemy;
	
	private static Text updateText;
	private static Label hpLabel, ppLabel; 
	
	public Fight(Enemy enemy) {
		//rough temporary fight scene using temp image
		ImageView bugImg = new ImageView();
		hpLabel = new Label("HP: " + enemy.getHp());
		ppLabel = new Label("PP: " + Utility.getPlayerHP());
		Button endFight = new Button("FLEE");
		Button attackEnemy = new Button("ATTACK");
		Button useItem = new Button("ITEM");
		Button scanEnemy = new Button("SCAN");
		
		//changes fonts and size
		hpLabel.setFont(new Font("", 20));
		ppLabel.setFont(new Font("", 20));
		endFight.setFont(new Font("", 40));
		attackEnemy.setFont(new Font("", 40));
		useItem.setFont(new Font("", 40));
		scanEnemy.setFont(new Font("", 40));
		
		// sets size of all buttons
		bugImg.setFitWidth(500);
		bugImg.setPreserveRatio(true);
		endFight.setMinSize(250, 50);
		attackEnemy.setMinSize(250, 50);
		useItem.setMinSize(250, 50);
		scanEnemy.setMinSize(250, 50);
		
		//sets up scrollpane to update damage, attacks, etc
		updateText = new Text("ENEMY encountered!");
		ScrollPane updateBox = new ScrollPane(updateText);
		
		VBox bugInfo = new VBox(20, bugImg, hpLabel, updateBox);
		VBox buttons = new VBox(20, ppLabel, attackEnemy, useItem, scanEnemy, endFight);
		buttons.setMinSize(100, 100);
		buttons.setAlignment(Pos.TOP_CENTER);
		
		GridPane gp = new GridPane();
		gp.addRow(0, bugInfo, buttons);
		
		gp.setMinSize(500, 500);
		gp.setHgap(20);
		gp.setAlignment(Pos.CENTER);
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(50);
		gp.getColumnConstraints().add(cc);
		
		endFight.setOnAction(e -> WebsiteTemplate.endFight(e, mainPage));
		attackEnemy.setOnAction(e -> attackEnemy());
		scanEnemy.setOnAction(e -> scanEnemy());
		useItem.setOnAction(e -> WebsiteTemplate.enterInventory(e) );
		
		
		this.getChildren().addAll(gp);
			
	}
	
	private static void scanEnemy() {
		System.out.println("Scan enemy");
		updateText.setText(updateText.getText() + "\n Scanning enemy...\n" + "Attack: " + enemy.getAtk() + "\nDefense: " + enemy.getDef());
	}
	
	//get the main page from websitetemplate
	public static void startedFightPage(HasBug page, Enemy e) {
		mainPage = page;
		enemy = e;
	}
	
	private static void attackEnemy() {
		enemy = Utility.attack(enemy);
		System.out.println("YOU attack the enemy!");
		hpLabel.setText("HP: " + enemy.getHp());
	}
}
