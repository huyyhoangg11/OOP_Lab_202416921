package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));
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

        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());

                Book book = new Book(title, category, cost);
                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully!");
                new StoreManagerScreen(store);
                dispose();
            }
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}