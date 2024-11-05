package FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Header extends HBox{
	
	public Header() {
		Text logo = new Text("Your Unc's Clothing");
	    logo.setId("logo");
	    this.getChildren().add(logo);
	    HBox.setMargin(logo, new Insets(40, 50, 40, 50));
	    this.setStyle("-fx-background-color: grey");
	}

}
