package rvt;

import java.io.File;
import java.io.FileNotFoundException;
// import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTable;

public class ToDoList extends JFrame{
    private final String filePath = "data/todo.csv";
    private final ArrayList<String[]> list = new ArrayList<>();
    
    public ToDoList() {
        try (Scanner reader = new Scanner(new File(filePath))) {
            if (reader.hasNextLine()) {
                reader.nextLine();
            }
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                list.add(row.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // private void save() {
    //     try (FileWriter writer = new FileWriter(filePath)) {
    //         writer.write("id,task");
    //         writer.write(System.lineSeparator());
    //         for (String row : list) {
    //             writer.write(row);
    //             writer.write(System.lineSeparator());
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Error: " + e.getMessage());
    //     }
    // }

    // public void add(String text) {
    //     String input = text.trim();
    //     if (checkEventString(input) == true){
    //         int id = 1;
    //         if (!list.isEmpty()) {
    //             String[] row = list.get(list.size() - 1).split(",");
    //             id = Integer.valueOf(row[0]) + 1;
    //         }
    //         list.add((id) + "," + text);
    //         save();
    //     } else {
    //         System.out.println("Nederigaievade!");
    //     }
       
    // }

    public JTable createTable() {
        String[] columnNames = { "ID", "Task"};
        String[][] data = new String[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i)[0];
            data[i][1] = list.get(i)[1];
        }
        JTable table = new JTable(data, columnNames);
        table.setBounds(30, 40, 50, 50);
        return table;
    }

    // public void remove(int id) {
    //     for (int i = 0; i < list.size(); i++) {
    //         String[] row = list.get(i).split(",");
    //         if (Integer.valueOf(row[0]) == id){
    //             list.remove(i);
    //             break;
    //         }
    //     }
    //     save();
    // }

    public boolean checkEventString(String value) {
        final String regex = "^[a-zA-Z0-9 ]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
}
}



// public class TodoList {

//     private final TodoDB db;

//     public TodoList() {
//         this.db = new TodoDB();
//         createTableIfNeeded();
//     }
    
//     private Connection getConnection() throws SQLException {
//         return db.connect();
//     }

//     private void createTableIfNeeded(){
//         String sql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL)";
//         try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
//             stmt.executeUpdate(sql);
//         } catch ( Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }

//     public void add(String task){
//         if(!checkEventString(task)) {
//             return;
//         }

//         String sql = "INSERT INTO todo(task) VALUES(?)";
//         try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//             pstmt.setString(1, task);
//             pstmt.executeUpdate();
//             System.out.println("Task added: " + task);
//         } catch(SQLException e){
//             System.out.println(e.getMessage());
//         }
//     }

//     public void findAll(){
//         String sql = "SELECT id, task FROM todo ORDER BY id";
//         try (Connection conn = db.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
//             while(rs.next()){
//                 System.out.println(rs.getInt("id") + ": " + rs.getString("task"));
//             }
//         } catch(SQLException e){  
//             System.out.println(e.getMessage());
//         }
//     }


//     public void deleteOne(int id){
//         String sql = "DELETE FROM todo WHERE id = ?";
//         try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//             pstmt.setInt(1, id);
//             int deletedRows = pstmt.executeUpdate();
//             if (deletedRows > 0) {
//                 System.out.println("Task deleted.");
//             } else {
//                 System.out.println("No task found with id: " + id);
//             }
//         } catch(SQLException e){
//             System.out.println(e.getMessage());
//         }

//         // this.tasks.remove(id);
//         // updateFile();
//     }

//     public boolean checkEventString(String value){

//         String input = "[a-zA-Z0-9 ]+";
//         if(!value.matches(input)){
//             System.out.println("Aktivitāte drīkst saturēt tikai burtus, ciparus un atstarpes.");
//             return false;
//         }
//         if(value.length() < 3){
//             System.out.println("Aktivitātes garums ir mazaks par 3 simboliem.");
//             return false;
//         }
//         return true;
//     }

// }

// public class TodoDB {
//     private static final String DB_URL = "jdbc:sqlite:todo.db";

//     public TodoDB(){
//         initSchema();
//     }

//     public Connection connect() throws SQLException{
//         return DriverManager.getConnection(DB_URL);
//     }
//     private void initSchema(){
//         String sql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL)";
//         try(Connection conn = connect(); Statement stmt = conn.createStatement()){
//             stmt.execute(sql);
//         } catch(SQLException e){
//             throw new RuntimeException("Schema init failed: " + e.getMessage());
//         }
//     }
// }
