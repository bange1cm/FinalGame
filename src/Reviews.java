
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Reviews extends BorderPane implements HasBug{
	VBox scam;
	
	
	public Reviews() {
		//reviews on the center
		VBox reviews = new VBox();
		Label title = new Label("Reviews from Customers");
		title.getStyleClass().add("h1");
		reviews.getChildren().add(title);
		
		Label buyer1 = new Label("Anonymous Buyer bought: : White Graphic Tee Cool Awesome T-Shirt Band Shirt....");
		Label review1 = new Label("1/5 Stars: This review has been deleted.");
		buyer1.getStyleClass().add("h2");
		review1.getStyleClass().add("h2");
		
		Label buyer2 = new Label("Real Customer bought: White Plain No Text Men’s Women’s Unisex Shirt");
		Label review2 = new Label("5/5 Stars: This is the best White Plain No Text Men’s Women’s Unisex Shirt ever! It works so well and was so cheap. I’ll be buying this again!");
		buyer2.getStyleClass().add("h2");
		review2.getStyleClass().add("h2");
		
		reviews.getChildren().addAll(buyer1, review1, buyer2, review2);
		reviews.setSpacing(20);
		
		//scam on the right
		scam = new VBox();
		Label text = new Label("You have won a $100 gift card. Claim your prize now!");
		Button bug = new Button("CLICK ME");
		bug.setStyle("-fx-text-fill: #FF0000;"
				+ "    -fx-border-color: #FF0000;"
				+ "    -fx-border-radius: 20;"
				+ "    -fx-background-radius: 20;"
				+ "    -fx-padding: 5;");
		scam.getChildren().addAll(text,bug);
		
		this.getStyleClass().add("main-padding");
		this.setCenter(reviews);
		this.setLeft(scam);
	
	}

	@Override
	public void removeBug() {
		scam.setVisible(false);
		
	}
}
