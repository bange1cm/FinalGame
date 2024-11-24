import java.util.Map;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InventoryMenu extends VBox{
	
	private static final Map<Item, Integer> inventory = ItemMap.getItemMap();
	private static TableView<Map.Entry<Item, Integer>> itemTable = new TableView<>();
	private static BorderPane bp = new BorderPane();
	
	public InventoryMenu(){
		
		TableColumn<Map.Entry<Item, Integer>, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().getName()));
		
        TableColumn<Map.Entry<Item, Integer>, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey().getDescription()));

        TableColumn<Map.Entry<Item, Integer>, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getValue()).asObject());
        
        itemTable.getColumns().addAll(nameColumn, descriptionColumn, quantityColumn);
        
        itemTable.getItems().addAll(inventory.entrySet());
        
        Text itemDescription = new Text("Select an item.");
        
        Button useButton = new Button("Use");
        useButton.setDisable(true);
        
        Button backButton = new Button("Back");
		
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
        
        bp.setLeft(new Label("PP: " + Utility.getPlayerHP() + "/" + Utility.getPlayerMaxHP()));
        bp.setRight(new Label("ATK: " + Utility.getPlayerATK() + "(+" + Utility.getTempATK() + ")   DEF: " + Utility.getPlayerDEF() + "(+" + Utility.getTempDEF() + ")"));
        
        useButton.setOnAction(event -> {
            Map.Entry<Item, Integer> selectedEntry = itemTable.getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                Item selectedItem = selectedEntry.getKey();
                ItemMap.use(selectedItem);

                // Refresh the TableView to reflect the change
                itemTable.getItems().clear();
                itemTable.getItems().addAll(inventory.entrySet());
                
                bp.setLeft(new Label("PP: " + Utility.getPlayerHP() + "/" + Utility.getPlayerMaxHP()));
                bp.setRight(new Label("ATK: " + Utility.getPlayerATK() + "(+" + Utility.getTempATK() + ")   DEF: " + Utility.getPlayerDEF() + "(+" + Utility.getTempDEF() + ")"));
            }
        });
        
        backButton.setOnAction(event -> {
        	WebsiteTemplate.backInventory();
        });
        
        VBox layout = new VBox(10);  // 10px spacing between elements
        layout.getChildren().addAll(itemTable, itemDescription, bp, useButton, backButton);
        
        this.getChildren().add(layout);
	}
	
	public static void updateMenu() {
		itemTable.getItems().clear();
        itemTable.getItems().addAll(inventory.entrySet());
        bp.setLeft(new Label("PP: " + Utility.getPlayerHP() + "/" + Utility.getPlayerMaxHP()));
        bp.setRight(new Label("ATK: " + Utility.getPlayerATK() + "(+" + Utility.getTempATK() + ")   DEF: " + Utility.getPlayerDEF() + "(+" + Utility.getTempDEF() + ")"));
	}
}
