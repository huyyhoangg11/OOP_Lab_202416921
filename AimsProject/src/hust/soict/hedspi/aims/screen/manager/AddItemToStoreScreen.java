package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(new MenuListener());
        menu.add(viewStoreMenu);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(new MenuListener());
        smUpdateStore.add(addBookMenu);

        JMenuItem addCDMenu = new JMenuItem("Add CD");
        addCDMenu.addActionListener(new MenuListener());
        smUpdateStore.add(addCDMenu);

        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        addDVDMenu.addActionListener(new MenuListener());
        smUpdateStore.add(addDVDMenu);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS - Update System");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    protected abstract JPanel createCenter();

    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("View store")) {
                new StoreManagerScreen(store);
                dispose();
            } else if (command.equals("Add Book")) {
                new AddBookToStoreScreen(store);
                dispose();
            } else if (command.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store);
                dispose();
            } else if (command.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        }
    }
}