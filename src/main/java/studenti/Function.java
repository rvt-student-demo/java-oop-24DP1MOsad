package studenti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    private final String filePath = "data/student.csv";
    private ArrayList<Student> students = new ArrayList<>();
    Scanner scanner;
    Regex checker;

    public Function() {
        try (Scanner reader = new Scanner(new File(filePath))) {
            while (reader.hasNextLine()) {
                String[] row = reader.nextLine().split(",");
                Student student = new Student(row[0], row[1], row[2], row[3], row[4]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner = new Scanner(System.in);
        checker = new Regex();
    }

    private void save() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : students) {
                writer.write(student.toCsv());
                writer.write(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int searchStudent(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonalCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void remove() {
        System.out.println("Ievadi personal kodu: ");
        String code = scanner.nextLine();
        if (checker.checkPersonCode(code)) {
            if (searchStudent(code) != -1) {
                students.remove(searchStudent(code));
                System.out.println("Students bija dzests.");
            } else {
                System.out.println("Tads student neeksiste.");
            }
        } else {
            System.out.println("Nepareizi ierakstits personal kods.");
        }
        save();
    }

    public void register() {
        String firstName;
        String lastName;
        String email;
        String personalCode;

        while (true) {
            System.out.println("Ievadi vardu:");
            firstName = scanner.nextLine();

            if (checker.checkWord(firstName)) {
                break;
            }
            System.out.println("Vards nav korekts. Megini velreiz.");
        }

        while (true) {
            System.out.println("Ievadi uzvardu:");
            lastName = scanner.nextLine();

            if (checker.checkWord(lastName)) {
                break;
            }
            System.out.println("Uzvards nav korekts. Megini velreiz.");
        }

        while (true) {
            System.out.println("Ievadi e-pastu:");
            email = scanner.nextLine();

            if (checker.checkEmail(email)) {
                break;
            }
            System.out.println("E-pasts nav korekts. Megini velreiz.");
        }
        while (true) {
            System.out.println("Ievadi personal kodu:");
            personalCode = scanner.nextLine();

            if (checker.checkPersonCode(personalCode)) {
                break;
            }
            System.out.println("Personal kods nav korekts. Megini velreiz.");
        }

        Student student = new Student(firstName, lastName, email, personalCode, String.valueOf(LocalDateTime.now()));
        students.add(student);
        save();
        System.out.println("Students bija izvejdots");
    }

    public void edit() {
        System.out.println("Ievadi personal kodu: ");
        String code = scanner.nextLine();
        if (checker.checkPersonCode(code)) {
            if (searchStudent(code) != -1) {
                String firstName;
                String lastName;
                String email;

                while (true) {
                    System.out.println("Ievadi vardu:");
                    firstName = scanner.nextLine();

                    if (checker.checkWord(firstName)) {
                        break;
                    }
                    System.out.println("Vards nav korekts. Megini velreiz.");
                }

                while (true) {
                    System.out.println("Ievadi uzvardu:");
                    lastName = scanner.nextLine();

                    if (checker.checkWord(lastName)) {
                        break;
                    }
                    System.out.println("Uzvards nav korekts. Megini velreiz.");
                }

                while (true) {
                    System.out.println("Ievadi e-pastu:");
                    email = scanner.nextLine();

                    if (checker.checkEmail(email)) {
                        break;
                    }
                    System.out.println("E-pasts nav korekts. Megini velreiz.");
                }

                students.get(searchStudent(code)).editStudent(firstName, lastName, email);

            } else {
                System.out.println("Tads student neeksiste.");
            }
        } else {
            System.out.println("Nepareizi ierakstits personal kods.");
        }
        save();
    }

    public void show(){
        String line = "+" + "-".repeat(20) + "+" + "-".repeat(20) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+";

        System.out.println(line);
        System.out.printf("|%-20s|%-20s|%-30s|%-15s|%n", "Firstname", "Lastname", "Email", "Personalcode");
        System.out.println(line);

        for(Student student: students) {
            System.out.printf("|%-20s|%-20s|%-30s|%-15s|%n", student.getFirstName(), student.getLastName(), student.getEmail(), student.getPersonalCode());
        }

        System.out.println(line);
    }
}
