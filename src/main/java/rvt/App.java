package rvt;

// import java.sql.DriverManager;

// import java.sql.Statement;
// import java.sql.Connection;
// import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        UserInterface user = new UserInterface(list);
        user.show();
    }
}
