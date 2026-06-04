package rvt;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        this.list = list;
        initialize();
    }

    private void initialize() {
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        BorderLayout bl = new BorderLayout();
        window.setLayout(bl);

        JPanel panel = new JPanel();
        JTable table = list.createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        JPanel inputPanel = new JPanel();

        // add
        JPanel addPanel = new JPanel();
        JTextField addTf = new JTextField(10); // addTf.getText()
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(addTf.getText());
                table.setModel(list.createTable().getModel());
                table.revalidate();
                table.repaint();
            }
        });
        addPanel.add(addTf);
        addPanel.add(addBtn);

        inputPanel.add(addPanel);

        // remove
        JPanel removePanel = new JPanel();
        JTextField removeTf = new JTextField(2);
        JButton removeBtn = new JButton("Remove");
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list.remove(Integer.parseInt(removeTf.getText()));
                    table.setModel(list.createTable().getModel());
                    table.revalidate();
                    table.repaint();
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid ID: " + removeTf.getText());
                }
            }
        });
        removePanel.add(removeTf);
        removePanel.add(removeBtn);

        inputPanel.add(removePanel);

        window.add(panel, BorderLayout.CENTER);
        window.add(inputPanel, BorderLayout.SOUTH);

    }

    public void show() {
        window.setVisible(true);
    }
}