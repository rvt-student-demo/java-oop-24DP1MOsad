package rvt;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserInterface {
    private ToDoList list;
    private JFrame window;

    public UserInterface(ToDoList list) {
        list = new ToDoList();
        initialize();
    }

    private void initialize() {
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1024, 768);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

    public void show() {
        window.setVisible(true);
    }

    public void start() {
        JFrame frame = new JFrame("Happy Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = list.createTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(1000, 400)); // +

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // +
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Add");
        panel.add(sp);
        JPanel inputPanel = new JPanel(); // +-
        inputPanel.add(textField);
        inputPanel.add(button);
        panel.add(inputPanel); // +-
        frame.add(panel);

        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}