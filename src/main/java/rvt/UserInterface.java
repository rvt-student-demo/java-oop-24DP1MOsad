package rvt;

import java.util.Scanner;

public class UserInterface {
    ToDoList list;
    Scanner scanner;

    public UserInterface(ToDoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
}
