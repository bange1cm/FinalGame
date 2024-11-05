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
	static TestHome mainHome;
	static BorderPane mainProducts;
	static TabPane tabPane;
	static Scene websiteScene;
	static Scene fightScene;
	
	private static Stage primaryStageRef;
	
	
	public void start(Stage primaryStage) {
		//create reference to stage so we can change the scenes outside of start method
		primaryStageRef = primaryStage;
		
		//create StartHelp
		StartHelp startHelp = new StartHelp();
		
        //create Header
        header = new Header();
        
        //create navigation bar
        navBar = new NavSidebar();
        
        //create the bodies 
        //this is the part that will change for each page of the website
        mainHome = new TestHome();
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
        
        //create fighting scene
        Fight fight = new Fight();
        fightScene = new Scene(fight);
        
        //set scene and stage
		websiteScene = new Scene(tabPane);
		websiteScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		primaryStage.setScene(websiteScene);
		primaryStage.setWidth(1200);
		primaryStage.setHeight(800);
		primaryStage.show();
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
	
	public static void startFight(ActionEvent e) {
		primaryStageRef.setScene(fightScene);
	}
	
	public static void endFight(ActionEvent e) {
		primaryStageRef.setScene(websiteScene);
	}

}

