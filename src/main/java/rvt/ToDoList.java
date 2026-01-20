package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private final String filePath = "data/todo.csv";
    private final ArrayList<String> list = new ArrayList<>();

    public TodoList() {
        try (Scanner reader = new Scanner(new File(filePath))) {
            if (reader.hasNextLine()) {
                reader.nextLine();
            }
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void save() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("id,task");
            writer.write(System.lineSeparator());
            for (String row : list) {
                writer.write(row);
                writer.write(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void add(String text) {
        int id = 1;
        if (!list.isEmpty()) {
            String[] row = list.get(list.size() - 1).split(",");
            id = Integer.valueOf(row[0]) + 1;
        }
        list.add((id) + "," + text);
        save();
    }

    public void print() {
        for (String row: list) {
            System.out.println(row);
        }
    }

    public void remove(int id) {
        for (int i = 0; i < list.size(); i++) {
            String[] row = list.get(i).split(",");
            if (Integer.valueOf(row[0]) == id){
                list.remove(i);
                break;
            }
        }
        save();
    }
}
