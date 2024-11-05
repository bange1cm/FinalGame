/*
 * WebsiteTemplate.java
 * CPS 240 Final Project
 * Cora Bangert
 * This outlines the overall look of the website. Edit the body to change the individual webpage
 */
package FrontEndGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class WebsiteTemplate extends Application{
	Header header;
	NavSidebar navBar;
	static BorderPane layout;
	static BorderPane mainHome;
	static BorderPane mainProducts;
	static TabPane tabPane;
	
	
	public void start(Stage stage) {
		
		//create StartHelp
		StartHelp startHelp = new StartHelp();
		
        //create Header
        header = new Header();
        
        //create navigation bar
        navBar = new NavSidebar();
        
        //create the bodies 
        //this is the part that will change for each page of the website
        mainHome = new BorderPane(new Label("Home"));
        mainProducts = new BorderPane(new Label("Products"));
        
        
		//create website layout
        layout = new BorderPane();
        layout.setTop(header);
        layout.setLeft(navBar);
        layout.setCenter(mainHome);
        
        //add scrolling
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);
        
        //add tab
        tabPane = new TabPane();
        //tab 1 for the intro and help
        Tab helpTab = new Tab("Help");
        helpTab.setContent(startHelp);
        helpTab.setClosable(false);
        tabPane.getTabs().add(helpTab);
        //tab 2 for website
        Tab mainTab = new Tab("https.notascam.com");
        mainTab.setContent(scrollPane);
        mainTab.setClosable(false);
        tabPane.getTabs().add(mainTab);
        
        //set scene and stage
		Scene scene = new Scene(tabPane);
		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
		stage.setWidth(1200);
		stage.setHeight(800);
		stage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);

	}

	public static void navigation(ActionEvent e) {
		Button sourceButton = (Button) e.getSource();
		String buttonText = sourceButton.getText();
		System.out.println(buttonText);
		switch(buttonText) {
		case "Home":
			layout.setCenter(mainHome);
			break;
		case "Products":
			layout.setCenter(mainProducts);
			break;
		case "About":
			layout.setCenter(mainHome);
			break;
		case "Contact":
			layout.setCenter(mainHome);
			break;
		case "Go":
			tabPane.getSelectionModel().select(1);
		}
		
	}

}

