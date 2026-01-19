package rvt;

import java.util.Scanner;

public class UserInterface {
    ToDoList list;
    Scanner scanner;

    public UserInterface(ToDoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        String command;
        while(true) {
            System.out.println("Command: ");
            command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.println("To add: ");
                list.add(scanner.nextLine());
            } else if (command.equals("list")) {
                list.print();
            } else if (command.equals("remove")) {
                System.out.println("Which one is removed?");
                list.remove(Integer.valueOf(scanner.nextLine()));
            } else {
                System.out.println("X");
            }
        }
    }
}
