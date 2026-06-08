package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.exception.PlayerException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {

    private Media media;
    private Cart cart;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        cart.addMedia(media);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add to Cart");
        alert.setHeaderText(null);
        alert.setContentText(media.getTitle() + " has been added to the cart.");
        alert.showAndWait();
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Player Exception");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(e.toString());
                alert.showAndWait();

                System.err.println(e.getMessage());
                System.err.println(e.toString());
                e.printStackTrace();
            }
        }
    }
}