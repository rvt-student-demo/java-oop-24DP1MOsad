package rvt;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GrafiskaisPanelis extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        // g.drawLine(10, 70, 60, 70);
        // g.drawLine(10, 70, 10, 30);
        // g.drawLine(60, 30, 60, 70);
        // g.drawLine(10, 30, 60, 30);
        g.setColor(Color.RED);
        g.fillRect(10, 30, 50, 40);
    }
}
