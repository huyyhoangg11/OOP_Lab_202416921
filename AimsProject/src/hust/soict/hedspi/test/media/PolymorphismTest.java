package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các đối tượng CD, DVD, Book
        CompactDisc cd = new CompactDisc("Tieng hat chim da da", "Music", 15.5f, 45, "Unknown", "Quang Le");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Harry Potter", "Fantasy", 25.5f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Duyệt qua danh sách và gọi phương thức toString()
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}