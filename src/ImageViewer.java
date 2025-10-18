import clothingitem.ClothingItem;

import javax.swing.*;
import java.awt.*;

public class ImageViewer {
    public static void showOutfit(Outfit outfit) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("오늘의 코디");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(2, 2, 10, 10));
            frame.add(makePanel("상의", outfit.getTop()));
            frame.add(makePanel("하의", outfit.getBottom()));
            frame.add(makePanel("신발", outfit.getShoes()));
            frame.add(makePanel("악세사리", outfit.getAccessory()));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


    private static JPanel makePanel(String title, ClothingItem item) {
        JPanel panel = new JPanel(new BorderLayout());
        String name = (item != null && item.getName() != null) ? item.getName() : "(없음)";
        panel.add(new JLabel(title + " — " + name, SwingConstants.CENTER), BorderLayout.NORTH);

        JLabel img = new JLabel("이미지 없음", SwingConstants.CENTER);

        String path = (item != null) ? item.getImagePath() : null;
        if (path != null && !path.isBlank()) {
            java.net.URL url = ImageViewer.class.getResource(path);
            if (url != null) {
                ImageIcon raw = new ImageIcon(url);
                Image scaled = raw.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                img.setText(null);
                img.setIcon(new ImageIcon(scaled));
            }
        }

        panel.add(img, BorderLayout.CENTER);
        return panel;
    }
}
