package FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Header extends HBox{
	
	public Header() {
		Text logo = new Text("Your Unc's Clothing");
	    logo.setId("logo");
	    
	    Button bugButton = new Button("Bug");
	    bugButton.setOnAction(e -> WebsiteTemplate.startFight(e));
	    
		StackPane stackPane = new StackPane(logo, bugButton);
	    
	    this.getChildren().add(stackPane);
	    HBox.setMargin(stackPane, new Insets(40, 50, 40, 50));
	    this.setStyle("-fx-background-color: grey");
	}

}
