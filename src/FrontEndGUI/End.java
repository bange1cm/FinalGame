package FrontEndGUI;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class End extends VBox{
	public End() {
		Label text = new Label("End of Game");
		text.getStyleClass().add("h1");
		this.getChildren().add(text);
	}
}
