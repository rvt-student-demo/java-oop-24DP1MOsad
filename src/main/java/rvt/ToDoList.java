package rvt;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
import java.util.ArrayList;
// import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTable;

public class ToDoList extends JFrame {
    // private final String filePath = "data/todo.csv";
    // private final ArrayList<String[]> list = new ArrayList<>();
    private ArrayList<String[]> list;
    private TodoDB db;

    public ToDoList() {
        db = new TodoDB();
        list = db.findAll();
    }

    public void add(String text) {
        String input = text.trim();
        if (!input.isEmpty()) {
            db.add(input);
            refresh();
        }
    }

    public JTable createTable() {
        String[] columnNames = { "ID", "Task" };
        String[][] data = new String[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i)[0];
            data[i][1] = list.get(i)[1];
        }
        JTable table = new JTable(data, columnNames);
        table.setBounds(30, 40, 50, 50);
        return table;
    }

    public void remove(int id) {
        db.removeById(id);
        refresh();
    }

    public void refresh() {
        list = db.findAll();
    }

    public boolean checkEventString(String value) {
        final String regex = "^[a-zA-Z0-9 ]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
    }
}