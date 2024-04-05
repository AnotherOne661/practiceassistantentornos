package org.anotherone661.ma.ui;
import org.anotherone661.ma.Settings;
import org.anotherone661.ma.ui.widgets.GradientButton;
import org.anotherone661.ma.ui.widgets.GradientLabel;
import org.anotherone661.ma.classes.Events;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JPanel panel;
    private JLabel label;
    private ImageIcon background;
    private JLabel bglabel;
    private JButton nostalgia_button;

    Window(){
     this(Settings.TITLE, Settings.WIDTH, Settings.HEIGHT, Settings.WINDOW_RESIZABLE, Settings.ALWAYS_ON_TOP, Settings.ICON_PATH);
    }


    public Window(String title, int width, int height, boolean windowResizable, boolean alwaysOnTop, String iconPath) {
        setTitle(title);
        setSize(width, height);
        setPreferredSize(Settings.WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(windowResizable);
        setAlwaysOnTop(alwaysOnTop);
        setLocationRelativeTo(null);
        init();
        setUpUI();
        pack();
        loadIcon(iconPath);

    }
    private void loadIcon(String path) {
        Image icon = new ImageIcon(Window.class.getResource(path)).getImage();
        setIconImage(icon);
    }
    protected void init() {
        // Override this method to initialize the window
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Paint the background image
                Image background = new ImageIcon(Window.class.getResource(Settings.BG_PATH)).getImage();
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        label = new GradientLabel("Remember when you were happy?", Color.decode("#adffc8"), Color.decode("#f79eab"));
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

        nostalgia_button = new GradientButton("Nostalgia", Color.decode("#c7eefc"), Color.decode("#f79eab"));
        nostalgia_button.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        nostalgia_button.setSize(100, 100);

        nostalgia_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // openURL("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); Copilot rickrolled me
                // openURL("https://www.youtube.com/watch?v=2ZIpFytCSVc"); //copilot bruh sound effect
                Events.openURL("https://www.youtube.com/watch?v=tajDxBaPBBM");
            }
        });

    }
        // fruitiger aero main palette adffc8 green c7eefc blue f79eab red


    protected void setUpUI() {
        // Create a nested panel to hold the label in the top-right corner
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        labelPanel.setOpaque(false); // Make the panel transparent

        // Add the label to the nested panel
        labelPanel.add(label);

        // Create another nested panel to hold the label panel at the top
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false); // Make the panel transparent

        // Add the label panel to the nested top panel, aligned to the right
        topPanel.add(labelPanel, BorderLayout.EAST);

        // Add the nested top panel to the main panel
        panel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        labelPanel.add(nostalgia_button);

        add(panel);
    }

}
