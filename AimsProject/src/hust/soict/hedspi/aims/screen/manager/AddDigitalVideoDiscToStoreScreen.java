package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));

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

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());

                // Khởi tạo DVD và thêm vào Store
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(null, "DVD added successfully!");
                new StoreManagerScreen(store);
                dispose();
            }
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}