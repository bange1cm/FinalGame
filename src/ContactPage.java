

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ContactPage extends GridPane implements HasBug, EnemyConstants{
	static Label ssnLabel, cardLabel, addressLabel;
	static TextField ssnField, cardField, addressField;
	
	static int counter = 0;
	static boolean defeated = false;
	
    public ContactPage() {
        // Set up the layout
        this.setPadding(new Insets(20));
        this.setVgap(10);
        this.setHgap(10);
        this.setMinHeight(1000);
        // Contact information
        Label contactHeader = new Label("Contact Our Support");
        contactHeader.getStyleClass().add("contact-header");

        // Sketchy information labels
        Label emailLabel = new Label("Email Address:");
        Label phoneLabel = new Label("Phone Number:");
        ssnLabel = new Label("Social Security Number:");
        cardLabel = new Label("Credit Card Number:");
        addressLabel = new Label("Home Address:");
        emailLabel.getStyleClass().add("contact-labels");
        phoneLabel.getStyleClass().add("contact-labels");
        ssnLabel.getStyleClass().add("contact-labels");
        cardLabel.getStyleClass().add("contact-labels");
        addressLabel.getStyleClass().add("contact-labels");

        // Fields for entering personal information
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email here...");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter your phone number here...");
        ssnField = new TextField();
        ssnField.setPromptText("Enter your SSN here...");
        cardField = new TextField();
        cardField.setPromptText("Enter your credit card number here...");
        addressField = new TextField();
        addressField.setPromptText("Enter your home address here...");

        // Message text area
        Label messageLabel = new Label("Additional Information:");
        TextArea messageArea = new TextArea();
        messageArea.setPromptText("Enter any additional details here...");
        messageArea.setPrefHeight(100);

        // Send button 
        LagWitch lagWitch = LagWitch.getInstance();
        Button sendButton = new Button("Submit Info");
        sendButton.getStyleClass().add("normal-buttons");

        // Add nodes to the grid
        this.add(contactHeader, 0, 0, 2, 1);
        this.add(emailLabel, 0, 1);
        this.add(emailField, 1, 1);
        this.add(phoneLabel, 0, 2);
        this.add(phoneField, 1, 2);
        this.add(ssnLabel, 0, 3);
        this.add(ssnField, 1, 3);
        this.add(cardLabel, 0, 4);
        this.add(cardField, 1, 4);
        this.add(addressLabel, 0, 5);
        this.add(addressField, 1, 5);
        this.add(messageLabel, 0, 6);
        this.add(messageArea, 0, 7, 2, 1);
        this.add(sendButton, 0, 8, 2, 1);

        // Action for the send button
        sendButton.setOnAction(e -> {
        	if(defeated) {
        		emailField.clear();
	            phoneField.clear();
	            messageArea.clear();
        	}
        	else if(clicks3()) {
	            counter = 0;
        		WebsiteTemplate.startFight(this, lagWitch);
	            emailField.clear();
	            phoneField.clear();
	            ssnField.clear();
	            cardField.clear();
	            addressField.clear();
	            messageArea.clear();
        	}
        });
    }
    
    //counter method to keep track of clicks, lagwitch bug is revealed after 3 clicks
    public boolean clicks3() {
    	counter++;
    	if(counter == 3) 
    		return true;
    	else
    		return false;
    		
    }
    
    
    //contract to remove bug
	@Override
	public void removeBug() {
		defeated = true;
		ssnField.setVisible(false);
		cardField.setVisible(false);
		addressField.setVisible(false);
		ssnLabel.setVisible(false);
		cardLabel.setVisible(false);
		addressLabel.setVisible(false);
		
	}
}
