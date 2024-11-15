
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class StartHelp extends ScrollPane{
	public StartHelp() {
		//subject title
		Label subject = new Label("Subject: Fix my website");
		subject.setStyle("-fx-font: 50 arial");
		
		//email 1 is from unc to you explaining that you need to fix the website
		VBox email1 = new VBox();
		
		//create everything for email 1
		File file1 = new File("src/Images/unc.png");
		Image unc = new Image(file1.toURI().toString());
		ImageView uncImg = new ImageView(unc);
		Label toFrom1 = new Label("From: Unc \nTo: You ", uncImg);
		toFrom1.setWrapText(true);
		toFrom1.setStyle("-fx-font: 20 arial");
		
		TextArea content1 = new TextArea("Hey kid. Unc here. I need yur help on my website 4 my business.\n"
				+ "I'm tellin you there be something wrong with it. Nobody is buying my clothes and there be strange stuff happenin I didnt ever add.\n"
				+ "I hired someone to make me this website a some time ago but they ghosted me and aint fixing it now.\n\n\n"
				+ "Instructions: go to my website notascam.com and see what u can find. "
				+ "If you find anything that looks wrong like a bug in my website, click on it and see what happends. "
				+ "Resolve any bugs or viruses you find, and collect items to help you.\n"
				+ "When yur done, respond to this here email so i know.");
		content1.setWrapText(true);
		content1.setEditable(false);
		content1.getStyleClass().add("email-content-area");
		content1.setFocusTraversable(false);
		
		email1.getChildren().addAll(toFrom1, content1);
		email1.setPrefWidth(900);
		email1.getStyleClass().add("starthelp-labels");
		
		
		//line divider
		Line line = new Line();
		line.setStartX(0);
		line.setEndX(1050);
		
		
		//email 2 is from you to unc when you're done
		VBox email2 = new VBox();
		
		//create everything for email 2
		File file2 = new File("src/Images/you.png");
		Image you = new Image(file2.toURI().toString());
		ImageView youImg = new ImageView(you);
		Label toFrom2 = new Label("From: You \nTo: Unc ", youImg);
		toFrom2.setWrapText(true);
		toFrom2.setStyle("-fx-font: 20 arial");
		
		TextArea content2 = new TextArea("Hey I'm done.");
		content2.setWrapText(true);
		content2.setEditable(false);
		content2.setPrefHeight(BASELINE_OFFSET_SAME_AS_HEIGHT);
		content2.getStyleClass().add("email-content-area");
		content2.setFocusTraversable(false);
		
		email2.getChildren().addAll(toFrom2, content2);
		email2.setPrefWidth(900);
		email2.getStyleClass().add("starthelp-labels");

		
		//button to guide user to website
		Button done = new Button("Send Response");
		done.getStyleClass().add("normal-buttons");
		done.setOnAction(e -> WebsiteTemplate.navigation(e));
		
		//the overall content for ScrollPane
		VBox content = new VBox();
		content.getChildren().addAll(subject, email1, line, email2, done);
		content.setSpacing(60);
		content.setPadding(new Insets(40, 40, 100, 40));
		this.setContent(content);
		
		
		
		
	}
}