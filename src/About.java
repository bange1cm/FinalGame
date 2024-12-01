import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class About extends VBox implements HasBug, EnemyConstants {
	static Button bugButton;
	static Button randomNavButton;
	static FlowPane randomHolder;

	public About() {
		// main title
		Label title = new Label("About");
		title.getStyleClass().add("h1");
		this.getChildren().add(title);

		// text about unc's business
		Label aboutText = new Label(
				"We are a small business run by a very hardworking old man. All products are made and handled with love and care. Please look at the products page and buy something and share with your friends.");
		aboutText.setWrapText(true);
		aboutText.setPrefWidth(400);
		aboutText.getStyleClass().add("p");

		// img of unc
		ImageView uncImg = new ImageView(new Image(getClass().getResource("Images/uncle.jpg").toExternalForm()));
		uncImg.setFitWidth(300);
		uncImg.setPreserveRatio(true);

		//bug
		Bug bug = new Bug(20, 5, 5, BUG1);
		bugButton = new Button("Bug");
		ImageView img = new ImageView(new Image(getClass().getResource(bug.getImgURL()).toExternalForm()));
		bugButton.setGraphic(img);
		bugButton.setScaleX(0.1);
		bugButton.setScaleY(0.1);
		bugButton.getStyleClass().add("enemy-buttons");
		bugButton.setOnAction(e -> WebsiteTemplate.startFight(this, bug));
		
		StackPane uncleStack = new StackPane(uncImg, bugButton);

//		Button itemButton = new Button("Item");
//		itemButton.setOnAction(e -> System.out.println("Item collected"));

		// create a flowpane for this section
		FlowPane flow = new FlowPane(aboutText, uncleStack);
		this.getChildren().add(flow);
		flow.setHgap(20);

		// faqs
		Label FAQTitle = new Label("FAQs");
		FAQTitle.getStyleClass().add("h2");
		this.getChildren().add(FAQTitle);

		Label q1 = new Label("Q: Why is everything so expensive?");
		Label a1 = new Label(
				"A: We are a small business. The products are made with love and care in my home, so you are paying for my love and care");
		Label q2 = new Label("Q: Is there free shipping?");
		Label a2 = new Label("A: No, that would be expensive.");
		Label q3 = new Label("Q: Why do the pictures look edited?");
		Label a3 = new Label("A: As a small business, we can’t afford to hire models to show off our products.");
		Label q4 = new Label("Q: Is this website a scam?");
		Label a4 = new Label("A: Of course not.");

		Label[] FAQs = new Label[] { q1, a1, q2, a2, q3, a3, q4, a4 };
		for (int i = 0; i < FAQs.length; i++) {
			this.getChildren().add(FAQs[i]);
			FAQs[i].getStyleClass().add("p");
			FAQs[i].setWrapText(true);
		}
		
		//navigation to notfound
		randomNavButton = new Button("110010100");
		randomNavButton.setOnAction(e -> WebsiteTemplate.navigation(e));
		Rectangle emptyRec = new Rectangle(1, 350);
		emptyRec.setFill(Color.TRANSPARENT);
		randomHolder = new FlowPane(Orientation.VERTICAL , emptyRec, randomNavButton);
		

//		this.getChildren().add(itemButton);
		this.getChildren().add(randomHolder);
		this.getStyleClass().add("main-padding");
		this.setSpacing(20);
	}
	
	//contract to remove bug
	@Override
	public void removeBug() {
		bugButton.setVisible(false);
	}
	
	//method to remove button that leads to notfound
	public static void removeRandom() {
		randomHolder.setVisible(false);
	}
}
