package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.customer.AimsCustomerApp;
import hust.soict.hedspi.aims.exception.PlayerException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {

    private Cart cart;
    private FilteredList<Media> filteredItems;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredItems = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredItems);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue,
                                        Media newValue) {
                        updateButtonBar(newValue);
                    }
                }
        );

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        radioBtnFilterId.setOnAction(event -> showFilteredMedia(tfFilter.getText()));
        radioBtnFilterTitle.setOnAction(event -> showFilteredMedia(tfFilter.getText()));
    }

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.trim().isEmpty()) {
            filteredItems.setPredicate(media -> true);
            return;
        }

        String lowerCaseFilter = filterText.toLowerCase().trim();

        if (radioBtnFilterId.isSelected()) {
            filteredItems.setPredicate(media ->
                    String.valueOf(media.getId()).contains(lowerCaseFilter)
            );
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredItems.setPredicate(media ->
                    media.getTitle().toLowerCase().contains(lowerCaseFilter)
            );
        }
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            return;
        }

        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            tblMedia.getSelectionModel().clearSelection();
            updateTotalCost();
            updateButtonBar(null);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
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

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        AimsCustomerApp.showStoreScreen();
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Place Order");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully!");
        alert.showAndWait();

        cart.clear();
        updateTotalCost();
        updateButtonBar(null);
    }
}