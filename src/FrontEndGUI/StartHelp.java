package FrontEndGUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class StartHelp extends GridPane{
	public StartHelp() {
		//text
		Label welcome = new Label("Welcome!");
		FlowPane background = new FlowPane();
		Label backgroundText = new Label("You’ve just been recruited by your uncle to fix up his rinky-dinky old website for his small business. "
				+ "He insists that something must be wrong, because no one seems to be buying his clothes and there are strange features he never meant to add. "
				+ "He tells you that he hired someone else to make it for him, but he can’t get into contact with them anymore to fix any of the bugs.");
		backgroundText.setWrapText(true);
		backgroundText.setPrefWidth(950);
		background.getChildren().add(backgroundText);
		
		FlowPane instructions = new FlowPane();
		Label instructionText = new Label("Instructions: You should go into your uncle’s website and try to find the bugs he’s talking about. "
				+ "Click on bugs and viruses to resolve the issues, and collect items to aid you on this project");
		instructionText.setWrapText(true);
		instructionText.setPrefWidth(950);
		instructions.getChildren().add(instructionText);
		
		//button to guide user to website
		Button go = new Button("Go");
		go.getStyleClass().add("normal-buttons");
		go.setOnAction(e -> WebsiteTemplate.navigation(e));
		
		//add nodes
		this.addColumn(0, welcome, background, instructions, go);
		this.setVgap(60);
		this.setPadding(new Insets(100, 40, 100, 40));
		
		//styles
		welcome.setStyle("-fx-font: 50 arial");
		background.setMaxWidth(1000);
		background.getStyleClass().add("starthelp-labels");
		instructions.setPrefWidth(1000);
		instructions.getStyleClass().add("starthelp-labels");
		
		
	}
}
