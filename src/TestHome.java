
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TestHome extends VBox{
	public TestHome() {
		Label homeLabel = new Label("Home");
        Button bugButton = new Button("Bug");
        bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this));
        
        this.getChildren().addAll(homeLabel, bugButton);
	}
}
