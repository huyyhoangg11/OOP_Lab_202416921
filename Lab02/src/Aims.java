public class Aims {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo các đối tượng DVD với dữ liệu mẫu từ tài liệu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // 3. Hiển thị giỏ hàng và tổng chi phí trước khi xóa
        anOrder.displayCart();

        // 4. Mục 13: Thử nghiệm xóa một DVD và kiểm tra lại
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("\nAfter removing Star Wars:");
        anOrder.displayCart();

        // Test Mục 16: Kiểm tra ID của các đĩa DVD
        // System.out.println("ID of dvd1 (The Lion King): " + dvd1.getId());
        // System.out.println("ID of dvd2 (Star Wars): " + dvd2.getId());
        // System.out.println("ID of dvd3 (Aladin): " + dvd3.getId());
    }
}