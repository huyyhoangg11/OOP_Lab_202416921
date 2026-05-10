package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    // MỤC 16: CLASS MEMBERS VÀ INSTANCE MEMBERS

    // Thuộc tính của Lớp (Class member) - Dung chung cho tất cả đối tượng
    private static int nbDigitalVideoDiscs = 0;

    // Thuộc tính của Đối tượng (Instance members) - Riêng biệt cho từng đối tượng
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // -------------------------------------------------------------------
    // CÁC HÀM KHỞI TẠO (CONSTRUCTORS)
    // Cập nhật: Tăng biến đếm tổng và gán ID mỗi khi tạo đối tượng mới
    // -------------------------------------------------------------------

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++; // Tăng tổng số lượng DVD lên 1
        this.id = nbDigitalVideoDiscs; // Gán ID bằng số lượng hiện tại
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // -------------------------------------------------------------------
    // GETTERS VÀ SETTERS
    // -------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Setter tạm thời từ Mục 15
    public void setTitle(String title) {
        this.title = title;
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