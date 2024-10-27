package fxml; // Package name set to fxml

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WebsiteTemplate extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("TestScrollTab.fxml"));
        Scene scene = new Scene(root);
        

        // Add scrolling
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(root);
//        scrollPane.setFitToWidth(true);

        // Set scene and stage
        stage.setScene(scene);
        stage.setTitle("https.notascam.com");
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
