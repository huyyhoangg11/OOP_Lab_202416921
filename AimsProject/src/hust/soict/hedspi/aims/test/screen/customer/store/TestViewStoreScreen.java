package hust.soict.hedspi.aims.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private Store store;
    private Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        store = new Store();
        cart = new Cart();

        addDataToStore();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml")
        );

        ViewStoreController controller = new ViewStoreController(store, cart);
        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void addDataToStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 10.5f);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "Fantasy", 11.5f);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "Fantasy", 12.5f);

        CompactDisc cd1 = new CompactDisc(
                "Best Hits",
                "Music",
                15.0f,
                60,
                "Various Artists",
                "Various Artists"
        );

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