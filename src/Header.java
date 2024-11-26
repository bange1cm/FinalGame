
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Header extends HBox implements HasBug, EnemyConstants{
	static  Button bugButton;
	public Header() {
		//logo
		Text logo = new Text("Your Unc's Clothing");
	    logo.setId("logo");
	    
	    //bug
	    Bug bug = new Bug(20, 5, 1, TROJAN_HORSE_BUG);
	    bugButton = new Button();
	    File file1 = new File(bug.getImgURL());
	    ImageView img = new ImageView(new Image(file1.toURI().toString()));
	    img.setScaleX(2);
	    img.setScaleY(2);
	    bugButton.setGraphic(img);
	    
	    bugButton.setMinHeight(10);
	    bugButton.setPrefHeight(10);
	    bugButton.setScaleX(0.1);
	    bugButton.setScaleY(0.1);    
	    bugButton.getStyleClass().add("enemy-buttons");
	    bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this, bug));
	    
		StackPane stackPane = new StackPane(logo, bugButton);
	    
	    this.getChildren().add(stackPane);
	    HBox.setMargin(stackPane, new Insets(40, 50, 40, 50));
	    this.setStyle("-fx-background-color: grey");
	}

	//contract to remove bug
	@Override
	public void removeBug() {
		 bugButton.setVisible(false);		
	}

}
