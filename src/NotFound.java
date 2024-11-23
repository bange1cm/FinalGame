
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class NotFound extends VBox implements HasBug, EnemyConstants{
	Button bugButton;
	Bug bug;
	public NotFound() {
		// main title
		Label title = new Label("404 Error: Page Not Found");
		title.getStyleClass().add("h1");
		
		//bug
		bugButton = new Button();
        bug = new Bug(20, 4, 5, BUG3);
	    File file = new File(bug.getImgURL());
	    ImageView img = new ImageView(new Image(file.toURI().toString()));
	    img.setScaleX(2);
	    img.setScaleY(2);
	    bugButton.setGraphic(img);
	    
	    bugButton.setMinHeight(100);
	    bugButton.setPrefHeight(100);
	    bugButton.setScaleX(.5);
	    bugButton.setScaleY(.5);
	    bugButton.getStyleClass().add("enemy-buttons");
	    bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this, bug));
	    
	    this.getChildren().addAll(title, bugButton);
	    this.setSpacing(100);
	    this.setPadding(new Insets(100, 100, 100, 100));
        this.setMinHeight(700);
	}
	
	
	@Override
	public void removeBug() {
		About.removeRandom();
		WebsiteTemplate.toAbout();
	}
	
}

