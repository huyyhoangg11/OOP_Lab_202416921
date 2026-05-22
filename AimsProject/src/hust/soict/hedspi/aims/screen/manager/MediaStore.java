package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tạo một JDialog để hiển thị cửa sổ phát media
                    JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(MediaStore.this), "Play Media", true);
                    dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

                    JLabel labelPlaying = new JLabel("Playing: " + media.getTitle());
                    labelPlaying.setAlignmentX(Component.CENTER_ALIGNMENT);
                    labelPlaying.setFont(new Font(labelPlaying.getFont().getName(), Font.BOLD, 14));

                    JLabel labelCost = new JLabel("Cost: " + media.getCost() + " $");
                    labelCost.setAlignmentX(Component.CENTER_ALIGNMENT);

                    JButton btnClose = new JButton("Close");
                    btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
                    btnClose.addActionListener(event -> dialog.dispose());

                    dialog.add(Box.createRigidArea(new Dimension(0, 10)));
                    dialog.add(labelPlaying);
                    dialog.add(Box.createRigidArea(new Dimension(0, 5)));
                    dialog.add(labelCost);
                    dialog.add(Box.createRigidArea(new Dimension(0, 15)));
                    dialog.add(btnClose);

                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(MediaStore.this);
                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}