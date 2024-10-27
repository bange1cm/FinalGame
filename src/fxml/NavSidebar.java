/**package fxml; // Package name set to fxml

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class NavSidebar extends VBox {
    public NavSidebar() {
        Button[] navigationButtons = new Button[4];
        navigationButtons[0] = new Button("Home");
        navigationButtons[1] = new Button("Products");
        navigationButtons[2] = new Button("About");
        navigationButtons[3] = new Button("Contact");
        
        this.setSpacing(10);
        for (Button button : navigationButtons) {
            button.setMaxWidth(Double.MAX_VALUE - 10);
            button.setStyle("-fx-font: 20 arial; -fx-padding:10");
            this.getChildren().add(button);
        }
        this.setStyle("-fx-background-color: indianred");
        this.setPadding(new Insets(10));
    }
}
**/