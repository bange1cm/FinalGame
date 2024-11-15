
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Header extends HBox implements HasBug{
	static  Button bugButton;
	public Header() {
		Text logo = new Text("Your Unc's Clothing");
	    logo.setId("logo");
	    
	    bugButton = new Button("Bug");
	    bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this));
	    
		StackPane stackPane = new StackPane(logo, bugButton);
	    
	    this.getChildren().add(stackPane);
	    HBox.setMargin(stackPane, new Insets(40, 50, 40, 50));
	    this.setStyle("-fx-background-color: grey");
	}

	@Override
	public void removeBug() {
		 bugButton.setVisible(false);		
	}

}
