package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // tao dvd de test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // them vao cart
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // in ra
        cart.print();

        // Test tìm kiếm theo ID
        cart.searchById(1); // Giả sử tìm DVD có ID là 1
        cart.searchById(5); // Tìm ID không tồn tại

        // Test tìm kiếm theo tiêu đề
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Harry Potter"); // Tìm title không tồn tại
    }
}