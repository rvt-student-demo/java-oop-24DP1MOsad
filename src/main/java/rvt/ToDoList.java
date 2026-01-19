package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    
    public void add(String text) {
        try (FileWriter writer = new FileWriter("data/todo.csv", true)) {
            writer.write(text);
            writer.write(System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void print() {
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            int x = 1;
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                System.out.println(x + ": " + row);
                x++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void remove(int number) {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        list.remove(number - 1);

        try (FileWriter writer = new FileWriter("data/todo.csv")) {
            for (String row : list) {
                writer.write(row);
                writer.write(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // public void remove(int number) {
    //     try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
    //         ArrayList<String> list = new ArrayList<>();

    //         while (reader.hasNextLine()) {
    //             String row = reader.nextLine();
    //             list.add(row);
    //         }

    //         list.remove(number - 1);

    //         for (String row : list) {
    //             try (FileWriter writer = new FileWriter("data/todo.csv")) {
    //                 writer.write(row);
    //                 writer.write(System.lineSeparator());
    //             } catch (Exception e) {
    //                 System.out.println("Error: " + e.getMessage());
    //             }
    //         }
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Error: " + e.getMessage());
    // }
    // }
}
