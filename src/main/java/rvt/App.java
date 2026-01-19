package rvt;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList list = new ToDoList();
        UserInterface n = new UserInterface(list, scanner);
        n.start();
    }
}
