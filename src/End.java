
/*
 * GCAM Devs - Cora Bangert, Meagan Callahan, Adam Kuhn, Gage Lefevre
 * Final Project, 12/1
 * 
 * End.java
 * This is the End scene of the game which extends VBox so an instance can be created and added to the stage in WebsiteTemplate and checks which ending the player receives
 */

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class End extends VBox{
  //making msg, image, and file static so they can be updated
  static TextArea msg;
  static ImageView image;
	
	public End() {
		// general title
		Label text = new Label("End of Game");
		text.getStyleClass().add("h1");

		// text and label
		msg = new TextArea();
		msg.setText(
				"Wow you really suck. You didn't fix anything on Unc's website.\nUnc says you're a horrible nephew. He loses all of his customers because you couldn't fix his website.");
		msg.setStyle("-fx-text-fill: red; -fx-font: 20 arial");

		msg.setWrapText(true);
		msg.setEditable(false);
		msg.setFocusTraversable(false);
		msg.setPrefHeight(80);

		image = new ImageView(new Image(End.class.getResource("Images/uncle_angry.jpg").toExternalForm()));
		image.setFitWidth(300);
		image.setPreserveRatio(true);

		TextArea background = new TextArea(
				"You realized the developer that Unc hired to create his website made all of the bugs to try and scam Unc's loyal customers.\nPoor Unc was just a victim");
		background.setWrapText(true);
		background.setEditable(false);
		background.setFocusTraversable(false);
		background.setPrefHeight(100);
		background.setStyle("-fx-font: 18 arial");

		// add components to end
		this.getChildren().addAll(text, msg, image, background);
		this.setSpacing(20);
		this.setPadding(new Insets(60, 100, 80, 80));
	}

	// method to check the amount of bugsDefeated and update the end scene
	public static void updateEnd() {
		if (Utility.bugsDefeated == 0) {
			msg.setText(
					"Wow you really suck. You didn't fix anything on Unc's website.\nUnc says you're a horrible nephew. He loses all of his customers because you couldn't fix his website.");
			msg.setStyle("-fx-text-fill: red; -fx-font: 20 arial");
			image = new ImageView(new Image(End.class.getResource("Images/uncle_angry.jpg").toExternalForm()));
		}
		else if (Utility.bugsDefeated < Utility.totalBugs) {
			msg.setText("Good job I guess. You found some bugs.\nUnc wants you to know that he has lost some of his customers because you couldn't fix everything on his website.");
			msg.setStyle("-fx-text-fill: orange; -fx-font: 20 arial;");
			image = new ImageView(new Image(End.class.getResource("Images/uncle_angry.jpg").toExternalForm()));
		}
		else {
			msg.setText("Great job! You found all of the bugs and saved Unc's website.\nUnc thanks you <3");
			msg.setStyle("-fx-text-fill: green; -fx-font: 20 arial");
			image = new ImageView(new Image(End.class.getResource("Images/uncle_happy.png").toExternalForm()));
		}
	}
}
