package FrontEndGUI;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NavSidebar extends VBox{
	public NavSidebar() {
		Button[] navigationButtons = new Button[4];
		Button homeButton = new Button("Home");
		Button productsButton = new Button("Products");
		Button aboutButton = new Button("About");
		Button contactButton = new Button("Contact");
		
        navigationButtons[0] = homeButton;
        navigationButtons[1] = productsButton;
        navigationButtons[2] = aboutButton;
        navigationButtons[3] = contactButton;
        this.setSpacing(10);
        for (int i = 0; i < navigationButtons.length; i++) {
        	navigationButtons[i].setMaxWidth(Double.MAX_VALUE - 10);
        	navigationButtons[i].getStyleClass().add("navigation-buttons");
        	this.getChildren().add(navigationButtons[i]);
        }
        this.setStyle("-fx-background-color: indianred");
        this.setPadding(new Insets(10));
        
        //set on actions
        homeButton.setOnAction(e -> WebsiteTemplate.navigation(e));
        productsButton.setOnAction(e -> WebsiteTemplate.navigation(e));
        aboutButton.setOnAction(e -> WebsiteTemplate.navigation(e));
        contactButton.setOnAction(e -> WebsiteTemplate.navigation(e));
	}
}
