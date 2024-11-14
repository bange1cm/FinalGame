package FrontEndGUI;

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

        // Sample sketchy products
        addProduct(
            "Luxury Designer Handbag - 99% Off!",
            "Example description",
            "https://example.com",
            0, 1
        );

        addProduct(
            "Exclusive Brand Sneakers - Only $19.99!",
            "Example description",      
            "https://example.com",
            1, 1
        );

        addProduct(
            "Latest Smartwatch - 90% Discount!",
            "Example description",
            "https://example.com",
            0, 2
        );

        addProduct(
            "Designer tshirt - Only $40.99!",
            "Example description",
            "https://static.vecteezy.com/system/resources/thumbnails/044/761/955/small/elegant-black-crew-neck-t-shirt-free-png.png",
            1, 2
        );
    }

    private void addProduct(String title, String description, String imageUrl, int col, int row) {
        VBox productBox = new VBox(5);
        productBox.setPadding(new Insets(10));
        productBox.getStyleClass().add("product-box");

        // Title
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("product-title");

        // Description
        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyleClass().add("product-description");

        // Product Image (placeholder)
        ImageView productImage = new ImageView(new Image(imageUrl));
        productImage.setFitHeight(120);

        productImage.preserveRatioProperty();
        //productImage.setFitWidth(120);

        // "Buy Now" Button
        Button buyButton = new Button("Buy Now");
        buyButton.getStyleClass().add("buy-button");

        // Add elements to product box
        productBox.getChildren().addAll(productImage, titleLabel, descriptionLabel, buyButton);

        // Place product box in the grid
        this.add(productBox, col, row);
    }
}
