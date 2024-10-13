/*
 * WebsiteTemplate.java
 * CPS 240 Final Project
 * Cora Bangert
 * This outlines the overall look of the website
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebsiteTemplate extends Application{
	
	public void start(Stage stage) {
		//creating WebView and WebEngine
		//final WebView browser = new WebView();
        //final WebEngine webEngine = browser.getEngine();
		
        //create Header
        Text logo = new Text("Your Unc's Clothing");
        logo.setStyle("-fx-font: 36 Stencil; ");
        HBox header = new HBox(logo);
        HBox.setMargin(logo, new Insets(40, 50, 40, 50));
        header.setStyle("-fx-background-color: grey");
        
        //create navigation bar
        Button[] navigationButtons = new Button[4];
        navigationButtons[0] = new Button("Home");
        navigationButtons[1] = new Button("Products");
        navigationButtons[2] = new Button("About");
        navigationButtons[3] = new Button("Contact");
        VBox navBar = new VBox(10);
        for (int i = 0; i < navigationButtons.length; i++) {
        	navigationButtons[i].setMaxWidth(Double.MAX_VALUE - 10);
        	navigationButtons[i].setStyle("-fx-font: 20 arial; fx-padding:10");
        	navBar.getChildren().add(navigationButtons[i]);
        }
        navBar.setStyle("-fx-background-color: indianred");
        navBar.setPadding(new Insets(10));
        
        //create the body
        BorderPane body = new BorderPane();
        Text title = new Text("Welcome");
        title.setStyle("-fx-font: 45 arial");
        body.setMargin(title, new Insets(50));
        body.setTop(title);;
        Rectangle temp = new Rectangle(10, 1000);
        body.setCenter(temp);
        
        
		//create layout
        BorderPane layout = new BorderPane();
        layout.setTop(header);
        layout.setLeft(navBar);
        layout.setCenter(body);
        
        //add scrolling
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);
        
        
        
		
        //set scene and stage
		Scene scene = new Scene(scrollPane);
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

