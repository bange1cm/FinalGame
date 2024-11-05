package FrontEndGUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Fight extends VBox{
	public Fight() {
		//temp items idk it doesn't look good
		ImageView bugImg = new ImageView("https://www.koppertus.com/content/_processed_/5/e/csm_southern_green_stink_bug_nezara_viridula_nymph_3_koppert_4e0725bc70.jpg");
		Label hpLabel = new Label("HP");
		Button endFight = new Button("won");
		endFight.setOnAction(e -> WebsiteTemplate.endFight(e));
		
		this.getChildren().addAll(bugImg, hpLabel, endFight);
		
		
	}
}
