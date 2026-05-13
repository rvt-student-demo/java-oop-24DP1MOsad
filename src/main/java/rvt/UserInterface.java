package rvt;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserInterface {
    ToDoList list;

    public UserInterface(ToDoList list) {
        this.list = list;
    }

    public void start() {
        JFrame frame = new JFrame("Happy Coding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = list.createTable();
        JScrollPane sp = new JScrollPane(table);
        
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Add");
        panel.add(sp);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);

        
        frame.setSize(500, 200);
        frame.setVisible(true);
        
    }
}

        // String command;
        // while(true) {
        //     System.out.println("Command: ");
        //     command = scanner.nextLine();
        //     if (command.equals("stop")) {
        //         break;
        //     } else if (command.equals("add")) {
        //         System.out.println("To add: ");
        //         list.add(scanner.nextLine());
        //     } else if (command.equals("list")) {
        //         list.print();
        //     } else if (command.equals("remove")) {
        //         System.out.println("Which one is removed?");
        //         list.remove(Integer.valueOf(scanner.nextLine()));
        //     } else {
        //         System.out.println("Nav tada command");
        //     }
        // }