/*
 * WebsiteTemplate.java
 * This is the main controller for the entire game, connecting different UI scenes and panes and calling methods from different classes
 */


import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;




public class WebsiteTemplate extends Application implements EnemyConstants{
	//declare website components that need to be accessed outside of start
	private Header header;
	private NavSidebar navBar;
	private static BorderPane layout;
	private static HomePageContent mainHome;
	private static About mainAbout;
	private static ProductsPage mainProducts;
	private static Reviews mainReviews;
	private static ContactPage mainContact;
	private static NotFound mainNotFound;
	private static InventoryMenu inventory;
	private static End end;
	private static TabPane tabPane;
	private static Tab mainTab;
	private static Tab inventoryTab;
	private static Scene websiteScene;
	private static Scene fightScene;
	private static Scene inventoryScene;
	private static Scene endScene;
	private static Stage primaryStageRef;
	
	private static String enterInventoryFrom;
	
	
	public void start(Stage primaryStage) {
		//initialize stats and player inventory slots
		Utility.initialize();
		
		//create reference to stage so we can change the scenes outside of start method
		primaryStageRef = primaryStage;
		
		//create StartHelp which is the email from unc
		StartHelp startHelp = new StartHelp();
		
		//create inventory 
		inventory = new InventoryMenu();
		
		//create stats
		StatsView statsView = new StatsView();
		
        //create Header
        header = new Header();
        
        //create navigation bar
        navBar = new NavSidebar();
        
        //create the bodies 
        //this is the part that will change for each page of the website
        mainHome = new HomePageContent();
        mainProducts = new ProductsPage();
        mainAbout = new About();
        mainReviews = new Reviews();
        mainContact = new ContactPage();
        mainNotFound = new NotFound();
        
		//create website layout
        layout = new BorderPane();
        layout.setTop(header);
        layout.setLeft(navBar);
        layout.setCenter(mainHome);
        
        //add scrolling
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);
        
        //add tab pane
        tabPane = new TabPane();
        //tab 1 for the intro and help
        Tab helpTab = new Tab("email.com");
        helpTab.setContent(startHelp);
        helpTab.setClosable(false);
        tabPane.getTabs().add(helpTab);
        //tab 2 for website
        mainTab = new Tab("notascam.com");
        mainTab.setContent(scrollPane);
        mainTab.setClosable(false);
        tabPane.getTabs().add(mainTab);
        //tab 3 for inventory
        inventoryTab = new Tab("fightinginventory.local");
        inventoryTab.setContent(statsView);
        inventoryTab.setClosable(false);
        tabPane.getTabs().add(inventoryTab);
        
        //create fighting scene and sets the enemy to a default bug
        Fight fight = new Fight(new Bug(20,5,5,BUG4));
        fightScene = new Scene(fight);
        
        //create inventory scene
        inventoryScene = new Scene(inventory);
        
        //create end scene
        end = new End();
        endScene = new Scene(end);
        endScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        //set scene and stage
		websiteScene = new Scene(tabPane);
		websiteScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
		primaryStage.setScene(websiteScene);
		primaryStage.setWidth(1200);
		primaryStage.setHeight(800);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	
	//main method for entire game. Launch the UI
	public static void main(String[] args) {
		Application.launch(args);

	}

	//general page navigation inside of the webpage
	//take the text of the source button and use that to decide what the center of the webpage layout should be
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
			layout.setCenter(mainContact);
			break;
		case "Reviews":
			layout.setCenter(mainReviews);
			break;
		case "110010100":
			layout.setCenter(mainNotFound);
			break;
		}
		
		
	}
	
	//start scene for inventory
	public static void enterInventory(String where) {
		InventoryMenu.updateMenu();
		enterInventoryFrom = where;
		primaryStageRef.setScene(inventoryScene);		
	}
	
	//end scene or switch tabs for inventory
	public static void backInventory() {
		StatsView.update();
		if(enterInventoryFrom.equals("fight")) {
			primaryStageRef.setScene(fightScene);
		}
		else if(enterInventoryFrom.equals("tab")) {
			 primaryStageRef.setScene(websiteScene);
			 tabPane.getSelectionModel().select(inventoryTab);
		}
		
	}
	
	//change scene to start fight
	public static void startFight(HasBug page, Enemy enemy) {
		fightScene = new Scene(new Fight(enemy));
		primaryStageRef.setScene(fightScene);
		Fight.startedFightPage(page);
		System.out.println("Enemy encountered!");
	}
	
	//change scenes when the fight in done, whether won or loss
	public static void endFight(HasBug page) {
		Utility.resetTempStats();
		InventoryMenu.updateMenu();
		StatsView.update();
		if(!(Utility.bugsDefeated > Utility.totalBugs))
			primaryStageRef.setScene(websiteScene);
	}
	
	//remove bug if the fight is won
	public static void winFight(HasBug page) {
		page.removeBug();
		// Create a 1-second delay before ending the fight
	    PauseTransition delay = new PauseTransition(Duration.seconds(1));
	    delay.setOnFinished(event -> endFight(page)); 
	    delay.play(); 
	    System.out.println(Utility.bugsDefeated);
		
	}
	
	//change scene to end scene
	public static void endScene() {
		End.updateEnd();
		primaryStageRef.setScene(endScene);
	}
	
	//navigate away from 404 page
	public static void toAbout() {
		layout.setCenter(mainAbout);
	}
}

