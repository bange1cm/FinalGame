

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class End extends VBox{
	//making msg and image file static so they can be updated
  static TextArea msg;
	static File file;
	
	public End() {
		//general title
		Label text = new Label("End of Game");
		text.getStyleClass().add("h1");
		
		//text and label
		msg =  new TextArea();
		msg.setText("Wow you really suck. You didn't fix anything on Unc's website.\nUnc says you're a horrible nephew. He loses all of his customers because you couldn't fix his website.");
		msg.setStyle("-fx-text-fill: red; -fx-font: 20 arial");
		file = new File("src/Images/uncle_angry.jpg");

		msg.setWrapText(true);
		msg.setEditable(false);
		msg.setFocusTraversable(false);
		msg.setPrefHeight(80);
		
		Image img = new Image(file.toURI().toString());
		ImageView image = new ImageView(img);
		image.setFitWidth(300);
		image.setPreserveRatio(true);
		
		TextArea background = new TextArea("You realized the developer that Unc hired to create his website made all of the bugs to try and scam Unc's loyal customers.\nPoor Unc was just a victim");
		background.setWrapText(true);
		background.setEditable(false);
		background.setFocusTraversable(false);
		background.setPrefHeight(100);
		background.setStyle("-fx-font: 18 arial");
		
		//add components to end
		this.getChildren().addAll(text,msg, image, background);
		this.setSpacing(20);
		this.setPadding(new Insets(60, 100, 80, 80));
	}
	
  //method to check the amount of bugsDefeated and update the end scene
	public static void updateEnd() {
		if(Utility.bugsDefeated == 0) {
			msg.setText("Wow you really suck. You didn't fix anything on Unc's website.\nUnc says you're a horrible nephew. He loses all of his customers because you couldn't fix his website.");
			msg.setStyle("-fx-text-fill: red; -fx-font: 20 arial");
			file = new File("src/Images/uncle_angry.jpg");
		}
		else if (Utility.bugsDefeated < Utility.totalBugs) {
			msg.setText("Good job I guess. You found some bugs.\nUnc wants you to know that he has lost some of his customers because you couldn't fix everything on his website.");
			msg.setStyle("-fx-text-fill: orange; -fx-font: 20 arial;");
			file = new File("src/Images/uncle_angry.jpg");
		}
		else {
			msg.setText("Great job! You found all of the bugs and saved Unc's website.\nUnc thanks you <3");
			msg.setStyle("-fx-text-fill: green; -fx-font: 20 arial");
			file = new File("src/Images/uncle_happy.png");
		}
	}
}
