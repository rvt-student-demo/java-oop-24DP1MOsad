package rvt;

public class App {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        UserInterface i = new UserInterface(list);
        i.start();
	}
}

