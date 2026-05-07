package rvt;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ToDoList list = new ToDoList();
        UserInterface i = new UserInterface(list, scanner);
        i.start();
	}
}

