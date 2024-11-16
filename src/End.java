

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class End extends VBox{
	public End() {
		//general title
		Label text = new Label("End of Game");
		text.getStyleClass().add("h1");
		
		//textfield for end game message
		TextArea msg =  new TextArea();
		
		if(Utility.bugsDefeated == 0) {
			msg.setText("Wow you really suck. You didn't fix anything on Unc's website. You're a horrible nephew.");
			msg.setStyle("-fx-text-fill: red; -fx-font: 20 arial; -fx-text-alignment: center;");
		}
		else if (Utility.bugsDefeated > Utility.totalBugs) {
			msg.setText("Good job I guess. You found some bugs. But Unc's website is still got some issues.");
			msg.setStyle("-fx-text-fill: orange; -fx-font: 20 arial; -fx-text-alignment: center;");
		}
		else {
			msg.setText("Great job! You found all of the bugs and saved Unc's website. He thanks you");
			msg.setStyle("-fx-font: 20 arial; -fx-text-alignment: center; ");
		}

		msg.setWrapText(true);
		msg.setEditable(false);
		msg.setFocusTraversable(false);

		
		//add components to end
		this.getChildren().addAll(text,msg);
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
	}
}
