
/*
 * GCAM Devs - Cora Bangert, Meagan Callahan, Adam Kuhn, Gage Lefevre
 * Final Project, 12/1
 * 
 * Header.java
 * The header of the website which extends HBox, contains a bug, and can be created as an instance so it can be added to the scene in WebsiteTemplate
 */
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Header extends HBox implements HasBug, EnemyConstants {
	static Button bugButton;

	public Header() {
		// logo
		Text logo = new Text("Your Unc's Clothing");
		logo.setId("logo");

		// bug and bug button
		Bug bug = new Bug(20, 5, 1, TROJAN_HORSE_BUG);
		bugButton = new Button();
		ImageView img = new ImageView(new Image(getClass().getResource(bug.getImgURL()).toExternalForm()));
		img.setScaleX(2);
		img.setScaleY(2);
		bugButton.setGraphic(img);

		// bugButton formatting and sizing
		bugButton.setMinHeight(10);
		bugButton.setPrefHeight(10);
		bugButton.setScaleX(0.1);
		bugButton.setScaleY(0.1);
		bugButton.getStyleClass().add("enemy-buttons");
		bugButton.setOnAction(e -> WebsiteTemplate.startFight(this, bug));

		// stackpane to hold logo and button
		StackPane stackPane = new StackPane(logo, bugButton);

		this.getChildren().add(stackPane);
		HBox.setMargin(stackPane, new Insets(40, 50, 40, 50));
		this.setStyle("-fx-background-color: grey");
	}

	// contract to remove bug
	@Override
	public void removeBug() {
		bugButton.setVisible(false);
	}

}
