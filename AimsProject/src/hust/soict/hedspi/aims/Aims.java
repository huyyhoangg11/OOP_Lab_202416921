package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Playable;

import java.util.Collections;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm vài dữ liệu mẫu để test
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new Book("Harry Potter", "Fantasy", 20.0f));
        store.addMedia(new CompactDisc("25", "Music", 15.0f, 45, "Adele", "Adele"));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua ký tự xuống dòng
            switch (choice) {
                case 1:
                    viewStoreMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    seeCurrentCartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // --- CÁC HÀM XỬ LÝ LOGIC ---

    public static void viewStoreMenu() {
        store.printStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // See media's details
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = findMediaInStore(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsInteraction(media);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Enter media title to add to cart: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = findMediaInStore(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter media title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = findMediaInStore(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            try {
                                ((Playable) mediaPlay).play();
                            } catch (PlayerException e) {
                                System.err.println(e.getMessage());
                                System.err.println(e.toString());
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("This media is not playable (e.g., Book).");
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 4: // See current cart
                    seeCurrentCartMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void mediaDetailsInteraction(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                            System.err.println(e.toString());
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void updateStoreMenu() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter title of new DVD to add:");
            String title = scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title)); // Thêm DVD cơ bản
        } else if (choice == 2) {
            System.out.println("Enter title to remove:");
            String title = scanner.nextLine();
            Media m = findMediaInStore(title);
            if (m != null) store.removeMedia(m);
            else System.out.println("Not found!");
        }
    }

    public static void seeCurrentCartMenu() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        cart.searchById(scanner.nextInt());
                        scanner.nextLine();
                    } else if (filterChoice == 2) {
                        System.out.print("Enter Title: ");
                        cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                        System.out.println("Sorted by Title.");
                        cart.print();
                    } else if (sortChoice == 2) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                        System.out.println("Sorted by Cost.");
                        cart.print();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media m = findMediaInCart(title);
                    if (m != null) cart.removeMedia(m);
                    else System.out.println("Not found in cart!");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String titlePlay = scanner.nextLine();

                    Media mPlay = findMediaInCart(titlePlay);

                    if (mPlay != null && mPlay instanceof Playable) {
                        try {
                            ((Playable) mPlay).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                            System.err.println(e.toString());
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Not found or not playable.");
                    }
                    break;
                case 5:
                    System.out.println("An order is created. Your cart is now empty!");
                    cart.getItemsOrdered().clear();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Helper functions
    private static Media findMediaInStore(String title) {
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    private static Media findMediaInCart(String title) {
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}