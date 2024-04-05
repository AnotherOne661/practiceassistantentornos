package org.anotherone661.ma.ui.widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GradientButton extends JButton {
    private Color startColor, endColor;

    public GradientButton(String text, Color startColor, Color endColor) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        setContentAreaFilled(false);
        setForeground(Color.CYAN);
        setBorderPainted(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Create a gradient paint for button background
        LinearGradientPaint gradientPaint = new LinearGradientPaint(
                new Point2D.Float(0, 0),
                new Point2D.Float(0, height),
                new float[]{0.0f, 1.0f},
                new Color[]{startColor, endColor});

        // Set the paint to the graphics context
        g2d.setPaint(gradientPaint);

        // Fill the button background with the gradient
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        super.paintComponent(g);
    }
}
