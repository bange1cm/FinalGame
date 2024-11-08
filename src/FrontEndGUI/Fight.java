package FrontEndGUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Fight extends VBox{
	public Fight() {
		//rough temporary fight scene using temp image
		
		ImageView bugImg = new ImageView("https://www.koppertus.com/content/_processed_/5/e/csm_southern_green_stink_bug_nezara_viridula_nymph_3_koppert_4e0725bc70.jpg");
		Label hpLabel = new Label("HP: ");
		Label ppLabel = new Label("PP: ");
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
		Text updateText = new Text("BUG encountered!");
		ScrollPane updateBox = new ScrollPane();
		
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
		
		endFight.setOnAction(e -> WebsiteTemplate.endFight(e));
		// change packages to allow utility class to be used
		//attackEnemy.setOnAction(e -> Utility.attack());
		//add in use item method/allow access to items
		//useItem.setOnAction(e -> useItemMethod);
		
		this.getChildren().addAll(gp);
			
	}
}
