package rvt;

import javax.swing.JFrame;

public class majas_izvade {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Happy Coding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		GrafiskaisPanelis grafiks = new GrafiskaisPanelis();
        frame.add(grafiks);
        
        frame.setVisible(true);
    }
    
}
