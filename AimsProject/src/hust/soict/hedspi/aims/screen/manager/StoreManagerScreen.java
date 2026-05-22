package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Import Store và Media từ dự án của bạn
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

public class StoreManagerScreen extends JFrame { // Kế thừa JFrame để làm cửa sổ ứng dụng
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel(); //
        center.setLayout(new GridLayout(3, 3, 2, 2)); //

        // Lưu ý: Đảm bảo class Store của bạn đã có hàm getItemsInStore() trả về ArrayList<Media>
        ArrayList<Media> mediaInStore = store.getItemsInStore(); //

        // Cần đảm bảo cửa hàng có tối thiểu 9 items, hoặc dùng math.min để tránh lỗi OutOfBounds
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) { //
            MediaStore cell = new MediaStore(mediaInStore.get(i)); //
            center.add(cell); //
        }

        return center; //
    }

    public static void main(String[] args) {
        // Khởi tạo một đối tượng Store
        Store store = new Store();

        // TODO: Thêm dữ liệu giả (mock data) vào Store ở đây để test giao diện
        // store.addMedia(new DigitalVideoDisc(...));

        // Khởi chạy giao diện StoreManagerScreen
        new StoreManagerScreen(store);
    }
}