import java.util.Map;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InventoryMenu extends BorderPane{ // Class for displaying inventory as an interactive menu
	
	private static Map<Item, Integer> inventory; // Accesses ItemMap class for data modification
	private static TableView<Map.Entry<Item, Integer>> itemTable; // TableView to display items
	private static BorderPane bp; // BorderPane which displays health and stats
	private static Label ppDisplay, statDisplay;
	// these are private and static for sake of ease with updateMenu method
	
	public InventoryMenu(){ // Menu construction

		inventory = ItemMap.getItemMap(); // inventory holds data from ItemMap class
		itemTable = new TableView<>(); // creation of TableView
		bp = new BorderPane(); // creation of BorderPane to hold stats and health
		
		// initialize each column for item name, description, and quantity
		TableColumn<Map.Entry<Item, Integer>, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().getName()));
		
        TableColumn<Map.Entry<Item, Integer>, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().getDescription()));

        TableColumn<Map.Entry<Item, Integer>, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getValue()).asObject());
        
        itemTable.getColumns().addAll(nameColumn, descriptionColumn, quantityColumn); // add columns to itemTable
        
        // change column widths
        nameColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.15));
        descriptionColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.75));
        quantityColumn.prefWidthProperty().bind(itemTable.widthProperty().multiply(0.098));
        
        // do not allow user to resize columns
        nameColumn.setResizable(false);
        descriptionColumn.setResizable(false);
        quantityColumn.setResizable(false);
        
        itemTable.setFixedCellSize(30); // set row height
        
        itemTable.getItems().addAll(inventory.entrySet()); // add inventory items to table data set
        
        Text itemDescription = new Text("Select an item."); // creation of text to prompt user to select and use items
        itemDescription.setFont(new Font(20));
        itemDescription.setTextAlignment(TextAlignment.CENTER);
        
        StackPane sp = new StackPane(itemDescription); // StackPane allows text to be centered
        
        Button useButton = new Button("Use"); // button for user to use an item
        useButton.setDisable(true);
        
        Button backButton = new Button("Back"); // back button to leave inventory
        
        useButton.setFont(new Font(20)); // button font sizes
        backButton.setFont(new Font(20));
        
        useButton.setMinSize(125, 25); // button sizes
        backButton.setMinSize(125, 25);
		
        // listener to detect which item is highlighted, prompting user based on item information
        itemTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.getValue() != 0) {
                Item selectedItem = newValue.getKey();
                itemDescription.setText("Use " + selectedItem.getName() + "?");
                useButton.setDisable(false);
            } else if(newValue != null && newValue.getValue() == 0){
            	Item selectedItem = newValue.getKey();
            	itemDescription.setText("You do not have a " + selectedItem.getName() + ".");
            	useButton.setDisable(true);
            } else {    
                itemDescription.setText("Select an item.");
                useButton.setDisable(true);
            }
        });
        
        // Labels to display health and stats, respectively
        ppDisplay = new Label("PP: " + Utility.getPlayerHP() + "/" + Utility.getPlayerMaxHP());
        ppDisplay.setFont(new Font(20));
        statDisplay = new Label("ATK: " + Utility.getPlayerATK() + "(+" + Utility.getTempATK() + ")   DEF: " + Utility.getPlayerDEF() + "(+" + Utility.getTempDEF() + ")");
        statDisplay.setFont(new Font(20));
        
        // add Labels to BorderPane
        bp.setLeft(ppDisplay);
        bp.setRight(statDisplay);
        
        // useButton functionality
        useButton.setOnAction(event -> {
            Map.Entry<Item, Integer> selectedEntry = itemTable.getSelectionModel().getSelectedItem();
            if (selectedEntry != null) { // if player has item in inventory
                Item selectedItem = selectedEntry.getKey(); // get item from data map
                ItemMap.use(selectedItem); // use item
                
                if(selectedItem instanceof Extension) { // add obtained extension to StatsView menu
                	StatsView.addExtension(selectedItem.id, selectedItem.name, selectedItem.description);
                }

                updateMenu(); // refresh menu
            }
        });
        
        // back button functionality
        backButton.setOnAction(event -> { 
        	WebsiteTemplate.backInventory();
        });
        
        // BorderPane for use and back button alignment
        BorderPane useBack = new BorderPane();
        useBack.setLeft(useButton);
        useBack.setRight(backButton);
        
        // VBox for menu elements
        VBox layout = new VBox(10);  
        layout.getChildren().addAll(itemTable, sp, bp, useBack);
        
        // BorderPane for spacing
        this.setCenter(layout);
        BorderPane.setMargin(layout, new Insets(80, 200, 20, 200));
	}
	
	public static void updateMenu() { // updateMenu method to refresh display with new information
		Platform.runLater(() -> {
			itemTable.getItems().clear();
	        itemTable.getItems().addAll(inventory.entrySet());
	        Label ppDisplay = new Label("PP: " + Utility.getPlayerHP() + "/" + Utility.getPlayerMaxHP());
	        ppDisplay.setFont(new Font(20));
	        statDisplay = new Label("ATK: " + Utility.getPlayerATK() + "(+" + Utility.getTempATK() + ")   DEF: " + Utility.getPlayerDEF() + "(+" + Utility.getTempDEF() + ")");
	        statDisplay.setFont(new Font(20));
	        bp.setLeft(ppDisplay);
	        bp.setRight(statDisplay);
		});
	}
}
