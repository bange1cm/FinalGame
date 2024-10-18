/*
 * WebsiteTemplate.java
 * CPS 240 Final Project
 * Cora Bangert
 * This outlines the overall look of the website. Edit the body to change the individual webpage
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class WebsiteTemplate extends Application{
	
	public void start(Stage stage) {
		
        //create Header
        Header header = new Header();
        
        //create navigation bar
        NavSidebar navBar = new NavSidebar();
        
        //create the body 
        //this is the part that will change for each page of the website
        BorderPane body = new BorderPane();
        Text title = new Text("Welcome");
        title.setStyle("-fx-font: 45 arial");
        body.setMargin(title, new Insets(50));
        body.setTop(title);;
        Rectangle temp = new Rectangle(10, 1000);
        body.setCenter(temp);
        
        
		//create website layout
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

