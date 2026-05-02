package rvt;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GrafiskaisPanelis extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(20, 140, 120, 140);
        g.drawLine(20, 140, 20, 60);
        g.drawLine(120, 60, 120, 140);
        g.drawLine(20, 60, 120, 60);
        
        g.setColor(Color.black);
        g.drawLine(40, 90, 60, 90);
        g.drawLine(40, 140, 40, 90);
        g.drawLine(40, 140, 60, 140);
        g.drawLine(60, 90, 60, 140);
        
        g.drawLine(80, 90, 110, 90);
        g.drawLine(80, 120, 110, 120);
        g.drawLine(80, 90, 80, 120);
        g.drawLine(110, 90, 110, 120);

        g.setColor(Color.red);
        g.drawLine(20, 60, 70, 20);
        g.drawLine(70, 20, 120, 60);

        g.setColor(Color.yellow);
        g.fillOval(60, 30, 20, 20);

    }
}
