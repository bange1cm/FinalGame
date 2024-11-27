import java.io.File;
import java.util.concurrent.TimeUnit;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Fight extends VBox {
	static HasBug mainPage;
	static Enemy enemy;

	public static Text updateText;
	public static Label hpLabel, ppLabel, enemyName;

	// get the main page from websitetemplate
	public static void startedFightPage(HasBug page) {
		mainPage = page;
	}

	public Fight(Enemy newEnemy) {
		enemy = newEnemy;
		try {
			File file1 = new File(enemy.getImgURL());
			ImageView img = new ImageView(new Image(file1.toURI().toString()));
			
			Pane background = new Pane();
			

			// enemy and player stats
			enemyName = new Label("");
			hpLabel = new Label("HP: " + enemy.getHp());
			ppLabel = new Label("PP: " + Utility.getPlayerHP());

			// menu buttons
			Button endFight = new Button("FLEE");
			Button attackEnemy = new Button("ATTACK");
			Button useItem = new Button("ITEM");
			Button scanEnemy = new Button("SCAN");

			// checks if enemy is a virus and names it
			if (enemy instanceof Trojan)
				enemyName.setText("TROJAN HORSE");
			else if (enemy instanceof Samsa)
				enemyName.setText("SAMSA");
			else if (enemy instanceof LagWitch)
				enemyName.setText("LAG WITCH");
			else
				enemyName.setText("BUG");

			// changes fonts and size
			hpLabel.setFont(new Font("", 20));
			ppLabel.setFont(new Font("", 20));
			enemyName.setFont(new Font("", 20));
			endFight.setFont(new Font("", 40));
			attackEnemy.setFont(new Font("", 40));
			useItem.setFont(new Font("", 40));
			scanEnemy.setFont(new Font("", 40));

			// sets size of all buttons
			img.setFitWidth(500);
			img.setPreserveRatio(true);
			endFight.setMinSize(250, 50);
			attackEnemy.setMinSize(250, 50);
			useItem.setMinSize(250, 50);
			scanEnemy.setMinSize(250, 50);

			// sets up scrollpane to update damage, attacks, etc
			updateText = new Text("ENEMY encountered!");
			ScrollPane updateBox = new ScrollPane(updateText);

			// puts gui into vboxes for neater formatting
			VBox bugInfo = new VBox(20, img, enemyName, hpLabel, updateBox);
			VBox buttons = new VBox(20, ppLabel, attackEnemy, useItem, scanEnemy, endFight);
			buttons.setMinSize(100, 100);
			buttons.setAlignment(Pos.TOP_CENTER);

			GridPane gp = new GridPane();
			gp.addRow(0, bugInfo, buttons);

			// gridpane formatting
			gp.setMinSize(500, 500);
			gp.setHgap(20);
			gp.setAlignment(Pos.TOP_CENTER);
			ColumnConstraints cc = new ColumnConstraints();
			cc.setPercentWidth(50);
			gp.getColumnConstraints().add(cc);

			// hands button presses
			endFight.setOnAction(e -> WebsiteTemplate.endFight(mainPage));
			attackEnemy.setOnAction(e -> attackEnemy());
			scanEnemy.setOnAction(e -> scanEnemy());
			useItem.setOnAction(e -> WebsiteTemplate.enterInventory("fight"));
			
			if(enemy instanceof BossDev) {
				endFight.setVisible(false);
				enemyName.setText("BOSS DEV");
				updateText.setText("YOU...\nDID YOU DO THIS..?\nI NEVER THOUGHT HE WOULD HIRE SOMEONE TO FIX WHAT I DID.\nVERY WELL THEN. GO AHEAD. TRY TO GET RID OF ME.");
				background.setStyle("-fx-background-color: black");
				background.setPrefSize(USE_COMPUTED_SIZE, BASELINE_OFFSET_SAME_AS_HEIGHT);
				background.setMinSize(4000, 4000);
				updateText.setStyle("-fx-text-color: white");
				hpLabel.setStyle("-fx-text-color: white");
				ppLabel.setStyle("-fx-text-color: white");
				enemyName.setStyle("-fx-text-color: white");
				
			}
			
			StackPane sp = new StackPane(background, gp);
			sp.setAlignment(Pos.TOP_CENTER);
			sp.setMinSize(500, 500);

			this.getChildren().addAll(sp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// helper method to provide information about the enemy
	private static void scanEnemy() {
		System.out.println("Scan enemy");
		updateText.setText(updateText.getText() + "\n Scanning enemy...\n");
		if (enemy instanceof Trojan)
			updateText.setText(updateText.getText()
					+ "This is a VIRUS called the TROJAN HORSE. It seems like an extension might help...\nMaybe something to block viruses?\n");
		else if (enemy instanceof Samsa)
			updateText.setText(updateText.getText()
					+ "This is a VIRUS called SAMSA. It seems like an extension might help...\nMaybe something that will reset his stats?");
		else if (enemy instanceof LagWitch)
			updateText.setText(updateText.getText()
					+ "This is a VIRUS called the LAG WITCH. It seems like an extension might help...\nMaybe something that reduces lag?");
		updateText.setText(updateText.getText() + "Attack: " + enemy.getAtk() + "\nDefense: " + enemy.getDef() + "\n");

	}

	// attacks enemy
	private static void attackEnemy() {
		System.out.println("Trying to attack...");
		if (!enemy.isDead()) {
			if (Utility.getBugAttacked()) {
				Utility.attack(enemy);
				System.out.println("Enemy hp reduced");
				hpLabel.setText("HP: " + enemy.getHp());
				updateText.setText(updateText.getText() + "\nYOU attack the enemy!");

				PauseTransition delay = new PauseTransition(Duration.seconds(1));
				delay.setOnFinished(event -> enemyAttacks());
				delay.play();
			}
		}
	}

	//enemy attacks you if it's the enemy's turn and it's not dead
	private static void enemyAttacks() {
		if (!Utility.getBugAttacked() && !enemy.isDead()) {
			updateText.setText(updateText.getText() + "\nThe ENEMY attacks!");
			enemy.attack();
			System.out.println("player hp reduced");
			ppLabel.setText("PP: " + Utility.getPlayerHP());
			if(Utility.getPlayerHP() <= 0) {
				WebsiteTemplate.endScene();
			}
		} else {
			updateText.setText(updateText.getText() + "\nYOU win!");
			Utility.bugsDefeated++;
			enemy.dropItem();
			System.out.println("Fight won - bugs defeated: " + Utility.bugsDefeated);
			WebsiteTemplate.winFight(mainPage);
		}

	}
}
