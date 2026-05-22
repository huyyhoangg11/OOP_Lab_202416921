package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfDirector, tfLength, tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add Compact Disc to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 200, 20, 200));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        center.add(tfCost);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField();
        center.add(tfLength);

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        center.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường nhập liệu
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                String artist = tfArtist.getText();

                // Khởi tạo CD và thêm vào Store (đảm bảo class CompactDisc có constructor này)
                CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully!");
                new StoreManagerScreen(store);
                dispose();
            }
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}