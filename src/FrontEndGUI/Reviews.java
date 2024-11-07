package FrontEndGUI;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Reviews extends VBox{
	public Reviews() {
		Label title = new Label("Reviews from Customers");
		title.getStyleClass().add("h1");
		this.getChildren().add(title);
		
		Label buyer1 = new Label("Anonymous Buyer bought: : White Graphic Tee Cool Awesome T-Shirt Band Shirt....");
		Label review1 = new Label("1/5 Stars: This review has been deleted.");
		buyer1.getStyleClass().add("h2");
		review1.getStyleClass().add("h2");
		
		Label buyer2 = new Label("Real Customer bought: White Plain No Text Men’s Women’s Unisex Shirt");
		Label review2 = new Label("5/5 Stars: This is the best White Plain No Text Men’s Women’s Unisex Shirt ever! It works so well and was so cheap. I’ll be buying this again!");
		buyer2.getStyleClass().add("h2");
		review2.getStyleClass().add("h2");
		
		this.getChildren().addAll(buyer1, review1, buyer2, review2);
		this.getStyleClass().add("main-padding");
		this.setSpacing(20);
	}
}
