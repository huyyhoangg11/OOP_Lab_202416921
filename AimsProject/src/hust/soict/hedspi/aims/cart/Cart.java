package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    // Sử dụng ArrayList thay vì mảng tĩnh để chứa Media (gồm cả Book, CD, DVD)
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total Cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found match: " + m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No match found for title: " + title);
    }

    // Tìm kiếm theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found match: " + m.toString());
                found = true;
                break; // Tìm thấy rồi thì thoát vòng lặp luôn
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }
}