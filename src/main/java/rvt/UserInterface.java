package rvt;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UserInterface {
    ToDoList list;
    Scanner scanner;

    public UserInterface(ToDoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        JFrame frame = new JFrame("Happy Coding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea rows = list.print();
        frame.add(rows);
        frame.setSize(300, 300);	
		frame.setVisible(true);
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
    }
}
