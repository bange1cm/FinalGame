
/*
 * GCAM Devs - Cora Bangert, Meagan Callahan, Adam Kuhn, Gage Lefevre
 * Final Project, 12/1
 * 
 * NotFound.java
 * A hidden page of the website which extends VBox, contains a bug, and can be created as an instance so it can be added to the scene in WebsiteTemplate
 */
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class NotFound extends VBox implements HasBug, EnemyConstants {
	Button bugButton;
	Bug bug;

	public NotFound() {
		// main title
		Label title = new Label("404 Error: Page Not Found");
		title.getStyleClass().add("h1");

		// bug and bug button
		bugButton = new Button();
		bug = new Bug(20, 4, 5, BUG3);
		ImageView img = new ImageView(new Image(getClass().getResource(bug.getImgURL()).toExternalForm()));
		img.setScaleX(2);
		img.setScaleY(2);
		bugButton.setGraphic(img);

		// bug formatting and action
		bugButton.setMinHeight(100);
		bugButton.setPrefHeight(100);
		bugButton.setScaleX(.5);
		bugButton.setScaleY(.5);
		bugButton.getStyleClass().add("enemy-buttons");
		bugButton.setOnAction(e -> WebsiteTemplate.startFight(this, bug));

		this.getChildren().addAll(title, bugButton);
		this.setSpacing(100);
		this.setPadding(new Insets(100, 100, 100, 100));
		this.setMinHeight(700);
	}

	// contract to remove 404 error
	@Override
	public void removeBug() {
		About.removeRandom();
		WebsiteTemplate.toAbout();
	}

}
