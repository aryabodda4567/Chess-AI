package com.chess.ui;

import com.chess.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class UiUtil {
    public static void showMessage(String message) {
        JWindow window = new JWindow(); // Borderless popup
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setOpaque(true);
        label.setBackground(new Color(0, 0, 0, 180)); // Semi-transparent black
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        window.add(label);
        window.setSize(300, 50);

        // Get screen width and calculate the center position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - window.getWidth()) / 2; // Center horizontally
        int y = 50; // Fixed position at the top
        window.setLocation(x, y);
        window.setVisible(true);

        // Timer to fade out the label
        Timer timer = new Timer(50, e -> {
            float opacity = window.getOpacity();
            if (opacity > 0.05f) {
                window.setOpacity(opacity - 0.05f); // Reduce opacity gradually
            } else {
                ((Timer) e.getSource()).stop();
                window.dispose(); // Close window when fully transparent
            }
        });

        // Delay before fading starts
        new Timer(1500, e -> timer.start()).setRepeats(false); // Start fade after 1.5s
        timer.setInitialDelay(1500);
        timer.start();
    }


    public static String showPromotionDialog(com.chess.models.Color color) {
        String[] options = {"Queen", "Rook", "Bishop", "Knight"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Promote your pawn to:"));
        // Create radio buttons
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[options.length];
        for (int i = 0; i < options.length; i++) {
            radioButtons[i] = new JRadioButton(options[i], i == 0); // Default to Queen
            group.add(radioButtons[i]);
            panel.add(radioButtons[i]);
        }

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Pawn Promotion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            for (JRadioButton radioButton : radioButtons) {
                if (radioButton.isSelected()) {
                    return radioButton.getText();
                }
            }
        }
        return null; // If canceled
    }
}
