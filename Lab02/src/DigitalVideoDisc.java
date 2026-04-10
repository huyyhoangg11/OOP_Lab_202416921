public class DigitalVideoDisc {
    // Mục 8: Khai báo các thuộc tính private
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Mục 10: Các hàm khởi tạo nạp chồng (Constructor Overloading)

    // 10.1. Khởi tạo qua Tiêu đề
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    // 10.2. Khởi tạo qua Thể loại, Tiêu đề và Giá
    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // 10.3. Khởi tạo qua Đạo diễn, Thể loại, Tiêu đề và Giá
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // 10.4. Khởi tạo qua tất cả các thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Mục 9: Các phương thức Getter (Chỉ lấy dữ liệu, không thay đổi dữ liệu)
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}