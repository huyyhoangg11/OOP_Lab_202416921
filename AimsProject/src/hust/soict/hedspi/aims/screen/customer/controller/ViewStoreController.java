package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.customer.AimsCustomerApp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ViewStoreController {

    private Store store;
    private Cart cart;

    @FXML
    private GridPane gridPane;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        final int NUM_COLUMNS = 3;

        int column = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Item.fxml")
                );

                ItemController itemController = new ItemController(cart);
                loader.setController(itemController);

                Node item = loader.load();
                itemController.setData(media);

                gridPane.add(item, column, row);

                column++;
                if (column == NUM_COLUMNS) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        AimsCustomerApp.showCartScreen();
    }
}