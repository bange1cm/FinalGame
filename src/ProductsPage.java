import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ProductsPage extends GridPane implements HasBug, EnemyConstants {

    public ProductsPage() {
        // Set up the layout
        this.setPadding(new Insets(20));
        this.setVgap(15);
        this.setHgap(15);

        // Header for the page
        Label productsHeader = new Label("Exclusive Deals Just for You!");
        productsHeader.getStyleClass().add("products-header");
        this.add(productsHeader, 0, 0, 3, 1);

        // Add products
      
        
        
        
        addProduct(
                "Luxury Bag - 99% Off!",
                "Gucci bag replica",
                "aiProductPic.png",
                0, 1,true
            );

        addProduct(
            "Exclusive Brand Pants - Only $19.99!",
            "Super comfortable pants",
            "productPants.png",
            1, 1,false
        );

        addProduct(
            "Fire Hat - 90% Discount!",
            "Fits any head",
            "productHat.png",
            0, 2,false
        );

        addProduct(
            "Designer T-shirt - Only $40.99!",
            "Perfect for any weather  ",
            "productShirt.png",
            1, 2,false
        );

        // Reviews Section
        VBox reviewsSection = new VBox(10);
        reviewsSection.setPadding(new Insets(10));
        reviewsSection.getStyleClass().add("reviews-section");

        Label reviewsCaption = new Label("Customers love us! Rated 4.9/5 by thousands.");
        reviewsCaption.getStyleClass().add("reviews-caption");

        Button reviewsButton = new Button("Reviews");
        reviewsButton.getStyleClass().add("reviews-button");

        reviewsSection.getChildren().addAll(reviewsCaption, reviewsButton);
        this.add(reviewsSection, 2, 1, 1, 2); // Add to the right, spanning two rows
        GridPane.setMargin(reviewsSection, new Insets(0, 0, 0, 20));
        reviewsButton.setOnAction(e -> WebsiteTemplate.navigation(e));
    }

    private void addProduct(String title, String description, String imageFileName, int col, int row, boolean isImageClickable) {
        VBox productBox = new VBox(5);
        productBox.setPadding(new Insets(10));
        productBox.getStyleClass().add("product-box");

        // Title
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("product-title");

        // Description
        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyleClass().add("product-description");

        if (isImageClickable) {
            // Image as a button
            Button imageButton = new Button();
            try {
                String resourcePath = "Images/" + imageFileName; // Relative path to the image
                Image image = new Image(getClass().getResourceAsStream(resourcePath));
                ImageView productImage = new ImageView(image);
                productImage.setFitHeight(120);
                productImage.setPreserveRatio(true);
                imageButton.setGraphic(productImage);
            } catch (Exception e) {
                System.err.println("Could not load image: " + imageFileName);
                e.printStackTrace();
            }
            imageButton.getStyleClass().add("image-button");

            // Set action for the image button
            imageButton.setOnAction(e -> System.out.println("Clicked on: " + title));
            
            Virus samsa = new Trojan(100, 10, 10, SAMSA);
            imageButton.setOnAction(e -> {
                WebsiteTemplate.startFight(e, this, samsa);
            });
            Button buyButton = new Button("Buy Now");
            buyButton.getStyleClass().add("buy-button");

            // Add elements to product box
            productBox.getChildren().addAll(imageButton, titleLabel, descriptionLabel, buyButton);
        } else {
            // Product Image
            ImageView productImage = new ImageView();
            try {
                String resourcePath = "Images/" + imageFileName; // Relative path to the image
                Image image = new Image(getClass().getResourceAsStream(resourcePath));
                productImage.setImage(image);
            } catch (Exception e) {
                System.err.println("Could not load image: " + imageFileName);
                e.printStackTrace();
                // Optionally set a placeholder image
                productImage.setImage(new Image(getClass().getResourceAsStream("Images/placeholder.png")));
            }
            productImage.setFitHeight(120);
            productImage.setPreserveRatio(true);

            // "Buy Now" Button
            Button buyButton = new Button("Buy Now");
            buyButton.getStyleClass().add("buy-button");

            // Add elements to product box
            productBox.getChildren().addAll(productImage, titleLabel, descriptionLabel, buyButton);
        }

        // Place product box in the grid
        this.add(productBox, col, row);
        
    }

    public void removeBug() {
    	addProduct(
                "Luxury Bag - 99% Off!",
                "Gucci bag replica",
                "productBag.png",
                0, 1,false
            );
		
	}
}
