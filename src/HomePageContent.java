
import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomePageContent extends BorderPane implements HasBug, EnemyConstants {
	static  Button bugButton;
    public HomePageContent() {
        // Top Header Section
        Label headerLabel = new Label("Welcome to Your UNC'S Clothing");
        headerLabel.setFont(Font.font("Arial", 24));
        headerLabel.setTextFill(Color.DARKRED);
        headerLabel.setPadding(new Insets(20));
        
        VBox headerBox = new VBox(headerLabel);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setStyle("-fx-background-color: #f2f2f2;");
        this.setTop(headerBox);

        // Center Content with Product Display
        VBox centerContent = new VBox(20);
        centerContent.setAlignment(Pos.TOP_CENTER);
        centerContent.setPadding(new Insets(20, 40, 40, 40));

        // Product Section Title
        Text productsTitle = new Text("Featured Products");
        productsTitle.setFont(Font.font("Verdana", 20));
        productsTitle.setFill(Color.DARKBLUE);

        // Grid for Product Images and Descriptions
        GridPane productsGrid = new GridPane();
        productsGrid.setHgap(20);
        productsGrid.setVgap(20);
        productsGrid.setAlignment(Pos.CENTER);

        // Add sample products with images
        ImageView imageView1 = createImageView("https://gallery.yopriceville.com/downloadfullsize/send/6461");
        Label productLabel1 = new Label("Top Hat\n$49.99");
        VBox productBox1 = new VBox(10, imageView1, productLabel1);
        productBox1.setAlignment(Pos.CENTER);

        ImageView imageView2 = createImageView("https://pics.clipartpng.com/Green_Hoodie_PNG_Clipart-936.png");
        Label productLabel2 = new Label("Stylish Hoodie\n$39.99");
        VBox productBox2 = new VBox(10, imageView2, productLabel2);
        productBox2.setAlignment(Pos.CENTER);

        ImageView imageView3 = createImageView("https://cdn-icons-png.flaticon.com/512/6122/6122876.png");
        bugButton = new Button();
        Bug bug = new Bug(20, 5, 1, BUG3);
	    bugButton = new Button();
	    bugButton.setGraphic(imageView3);    
	    bugButton.getStyleClass().add("enemy-buttons");
	    bugButton.setOnAction(e -> WebsiteTemplate.startFight(e, this, bug));
        Label productLabel3 = new Label("Denim Jeans\n$59.99");
        VBox productBox3 = new VBox(10, bugButton, productLabel3);
        productBox3.setAlignment(Pos.CENTER);

        // Add products to the grid
        productsGrid.add(productBox1, 0, 0);
        productsGrid.add(productBox2, 1, 0);
        productsGrid.add(productBox3, 2, 0);

        // Sales and Discount Section
        VBox salesSection = new VBox(10);
        salesSection.setAlignment(Pos.CENTER);
        Text saleText = new Text("ON SALE!!!");
        saleText.setFill(Color.RED);
        saleText.setFont(Font.font("Arial Bold", 22));

        Text discountText = new Text("60% off all apparel this season!");
        discountText.setFont(Font.font("Arial", 16));
        discountText.setFill(Color.DARKGREEN);

        Text noteText = new Text("*Excludes shirts, pants, and hats");
        noteText.setFont(Font.font("Arial Italic", 12));
        noteText.setFill(Color.DARKGRAY);

        salesSection.getChildren().addAll(saleText, discountText, noteText);

        // Assemble the center content
        centerContent.getChildren().addAll(productsTitle, productsGrid, salesSection);
        this.setCenter(centerContent);

        // Footer Section
        Label footerLabel = new Label("©2024 Your UNC'S Clothing - All rights reserved");
        footerLabel.setFont(Font.font("Arial", 12));
        footerLabel.setTextFill(Color.GRAY);
        footerLabel.setPadding(new Insets(10, 0, 10, 0));  // Ensure top and bottom padding is minimal
        
        HBox footerBox = new HBox(footerLabel);
        //footerBox.setAlignment(Pos.CENTER);
        footerBox.setAlignment(Pos.BOTTOM_CENTER);
        footerBox.setStyle("-fx-background-color: #e6e6e6;");
        this.setBottom(footerBox);
    }

    // Helper method to create an ImageView with consistent sizing
    private ImageView createImageView(String imagePath) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(150);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        return imageView;
    }

	@Override
	public void removeBug() {
		bugButton.setVisible(false);	
	}
}
