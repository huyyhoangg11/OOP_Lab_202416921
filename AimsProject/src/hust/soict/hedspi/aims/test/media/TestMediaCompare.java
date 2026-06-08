package hust.soict.hedspi.aims.test.media;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestMediaCompare {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        System.out.println("dvd1 equals dvd2: " + dvd1.equals(dvd2));
        System.out.println("dvd1 compareTo dvd2: " + dvd1.compareTo(dvd2));
        System.out.println("dvd1 compareTo dvd3: " + dvd1.compareTo(dvd3));
    }
}