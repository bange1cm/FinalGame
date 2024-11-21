import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ProductsPage extends GridPane {

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
            "Gucci bag fake",
            "productBag.png",
            0, 1
        );

        addProduct(
            "Exclusive Brand Pants - Only $19.99!",
            "Example description",
            "productPants.png",
            1, 1
        );

        addProduct(
            "Fire Hat - 90% Discount!",
            "Example description",
            "productHat.png",
            0, 2
        );

        addProduct(
            "Designer T-shirt - Only $40.99!",
            "Example description",
            "productShirt.png",
            1, 2
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

    private void addProduct(String title, String description, String imageFileName, int col, int row) {
        VBox productBox = new VBox(5);
        productBox.setPadding(new Insets(10));
        productBox.getStyleClass().add("product-box");

        // Title
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("product-title");

        // Description
        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyleClass().add("product-description");

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

        // Place product box in the grid
        this.add(productBox, col, row);
    }

}
