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
	private Header header;
	private NavSidebar navBar;
	private static BorderPane layout;
	private static TestHome mainHome;
	private static About mainAbout;
	private static BorderPane mainProducts;
	private static Reviews mainReviews;
	private static TabPane tabPane;
	private static Scene websiteScene;
	private static Scene fightScene;
	private static Scene endScene;
	
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
        mainAbout = new About();
        mainReviews = new Reviews();
        
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
        Tab helpTab = new Tab("email.com");
        helpTab.setContent(startHelp);
        helpTab.setClosable(false);
        tabPane.getTabs().add(helpTab);
        //tab 2 for website
        Tab mainTab = new Tab("notascam.com");
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
			layout.setCenter(mainAbout);
			break;
		case "Contact":
			layout.setCenter(mainHome);
			break;
		case "Reviews":
			layout.setCenter(mainReviews);
			break;
		}
		
		
	}
	
	public static void startFight(ActionEvent e) {
		primaryStageRef.setScene(fightScene);
	}
	
	public static void endFight(ActionEvent e) {
		primaryStageRef.setScene(websiteScene);
	}

}

