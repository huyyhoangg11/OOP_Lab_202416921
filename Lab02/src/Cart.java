public class Cart {
    // Số lượng DVD tối đa cho phép trong giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Mảng lưu trữ các đối tượng DigitalVideoDisc
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Số lượng DVD hiện có thực tế trong giỏ hàng
    private int qtyOrdered = 0;

    // PHƯƠNG THỨC GỐC VÀ NẠP CHỒNG (MỤC 11 & 14)

    // 1. Thêm MỘT DVD vào giỏ hàng (Phương thức gốc)
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // Kiểm tra xem giỏ hàng đã đầy chưa
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added"); // Thông báo thành công
        } else {
            System.out.println("The cart is almost full"); // Thông báo khi đầy [cite: 647]
        }
    }

    // 2. Thêm danh sách DVD sử dụng Varargs (Mục 14.1) [cite: 702]
    // Cho phép truyền vào số lượng tham số tùy ý (ví dụ: addDigitalVideoDisc(dvd1, dvd2, dvd3))
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc); // Gọi lại phương thức gốc để tận dụng logic kiểm tra số lượng
        }
    }

    // 3. Thêm chính xác 2 DVD vào giỏ hàng (Mục 14.2) [cite: 704, 706-708]
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); // Gọi lại phương thức gốc
        addDigitalVideoDisc(dvd2); // Gọi lại phương thức gốc
    }

    // CÁC PHƯƠNG THỨC KHÁC

    // Xóa một DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Dịch chuyển các phần tử phía sau lên để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    // Tính tổng chi phí của các DVD trong giỏ
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total; // Trả về tổng chi phí
    }

    // Phương thức bổ sung để hiển thị danh sách các mục (Yêu cầu Mục 12)
    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered[i].getTitle() +
                    " - " + itemsOrdered[i].getCategory() +
                    " : " + itemsOrdered[i].getCost() + " $");
        }
        System.out.println("Total Cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}