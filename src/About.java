
import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class About extends VBox implements HasBug{
	static Button bugButton;
	public About() {
		//main title
		Label title = new Label("About");
		title.getStyleClass().add("h1");
		this.getChildren().add(title);
		
		//text about unc's business
		Label aboutText = new Label("We are a small business run by a very hardworking old man. All products are made and handled with love and care. Please look at the products page and buy something and share with your friends.");
		aboutText.setWrapText(true);
		aboutText.setPrefWidth(400);
		aboutText.getStyleClass().add("p");
		
		//img of unc
		File file = new File("src/Images/uncle.jpg");
		Image image = new Image(file.toURI().toString());
		ImageView uncImg = new ImageView(image);
		uncImg.setFitWidth(300);
		uncImg.setPreserveRatio(true);
		
		Bug bug = new Bug(20, 5, 5);
		bugButton = new Button("Bug");
		bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this, bug));

        
		Button itemButton = new Button("Item");
		itemButton.setOnAction(e -> System.out.println("Item collected"));
		
		//create a flowpane for this section
		FlowPane flow = new FlowPane(aboutText, uncImg, bugButton);
		this.getChildren().add(flow);
		flow.setHgap(20);
		
		//faqs
		Label FAQTitle = new Label("FAQs");
		FAQTitle.getStyleClass().add("h2");
		this.getChildren().add(FAQTitle);
		
		
		Label q1 = new Label("Q: Why is everything so expensive?");
		Label a1 = new Label("A: We are a small business. The products are made with love and care in my home, so you are paying for my love and care");
		Label q2 = new Label("Q: Is there free shipping?");
		Label a2 = new Label("A: No, that would be expensive.");
		Label q3 = new Label("Q: Why do the pictures look edited?");
		Label a3 = new Label("A: As a small business, we can’t afford to hire models to show off our products.");
		Label q4 = new Label("Q: Is this website a scam?");
		Label a4 = new Label("A: Of course not.");
		
		
		Label[] FAQs = new Label[] {q1, a1, q2, a2, q3, a3, q4, a4};
		for(int i = 0; i<FAQs.length; i++) {
			this.getChildren().add(FAQs[i]);
			FAQs[i].getStyleClass().add("p");
			FAQs[i].setWrapText(true);
		}
		
		this.getChildren().add(itemButton);
		this.getStyleClass().add("main-padding");
		this.setSpacing(20);
	}

	@Override
	public void removeBug() {
		bugButton.setVisible(false);
	}
}
