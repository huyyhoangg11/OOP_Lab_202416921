package hust.soict.hedspi.aims.screen.customer;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AimsCustomerApp extends Application {

    private static Stage primaryStage;
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        store = new Store();
        cart = new Cart();

        addDataToStore();

        showStoreScreen();
    }

    public static void showStoreScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    AimsCustomerApp.class.getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml")
            );

            ViewStoreController controller = new ViewStoreController(store, cart);
            loader.setController(controller);

            Parent root = loader.load();

            primaryStage.setTitle("AIMS Store");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showCartScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    AimsCustomerApp.class.getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml")
            );

            CartController controller = new CartController(cart);
            loader.setController(controller);

            Parent root = loader.load();

            primaryStage.setTitle("AIMS Cart");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addDataToStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 10.5f);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "Fantasy", 11.5f);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "Fantasy", 12.5f);

        CompactDisc cd1 = new CompactDisc("Best Hits", "Music", 15.0f, 60, "Various Director", "Various Artist");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}