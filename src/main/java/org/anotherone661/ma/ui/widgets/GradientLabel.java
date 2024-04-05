package org.anotherone661.ma.ui.widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GradientLabel extends JLabel {
    private Color startColor, endColor;


    public GradientLabel(String text, Color startColor, Color endColor) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Create a gradient for the text color
        LinearGradientPaint gradientPaint = new LinearGradientPaint(
                new Point2D.Float(0, 0),
                new Point2D.Float(width, height),
                new float[]{0.5f, 1},
                new Color[]{startColor, endColor});

        // Set the paint to the graphics context
        g2d.setPaint(gradientPaint);

        // Set rendering hints for better quality
         g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Set font and draw the text with the gradient color
        g2d.setFont(getFont());
        FontMetrics metrics = g2d.getFontMetrics();
        Rectangle2D bounds = metrics.getStringBounds(getText(), g2d);
        int x = (int) ((width - bounds.getWidth()) / 2);
        int y = (int) ((height - bounds.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}
