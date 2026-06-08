package hust.soict.hedspi.aims.test.screen.customer.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {

    private Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        cart = new Cart();

        addDataToCart();

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml")
        );

        CartController controller = new CartController(cart);
        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("AIMS Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void addDataToCart() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 10.5f);

        CompactDisc cd1 = new CompactDisc("Best Hits", "Music", 15.0f, 60, "Various Director", "Various Artist");

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book1);
        cart.addMedia(cd1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}