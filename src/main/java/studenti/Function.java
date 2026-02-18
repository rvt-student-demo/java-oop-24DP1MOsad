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

            if (!checker.checkEmail(email)) {
                System.out.println("E-pasts nav korekts. Megini velreiz.");
                continue;
            }
            
            boolean dublicate = false;
            
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getEmail().equals(email)) {
                    dublicate = true;
                    break;
                }
            }

            if (dublicate) {
                System.out.println("Tads email jau eksiste.");
                continue;
            }

            break;
        }

        while (true) {
            System.out.println("Ievadi personal kodu:");
            personalCode = scanner.nextLine();

            if (!checker.checkPersonCode(personalCode)) {
                System.out.println("Personal kods nav korekts. Megini velreiz.");
                continue;
            }

            if (searchStudent(personalCode) != -1){
                System.out.println("Tads person code jau eksiste.");
                continue;
            }

            break;
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
            int studentID = searchStudent(code);
            if (studentID != -1) {
                String firstName;
                String lastName;
                String email;

                System.out.println("Ko tu gribi izmainit: firstname, lastname, email?");
                String comand = scanner.nextLine();

                if (comand.equals("firstname")) {
                    while (true) {
                        System.out.println("Ievadi vardu:");
                        firstName = scanner.nextLine();

                        if (checker.checkWord(firstName)) {
                            break;
                        }
                        System.out.println("Vards nav korekts. Megini velreiz.");
                    }
                    students.get(studentID).editFirstname(firstName);
                } else if (comand.equals("lastname")) {
                    while (true) {
                        System.out.println("Ievadi uzvardu:");
                        lastName = scanner.nextLine();

                        if (checker.checkWord(lastName)) {
                            break;
                        }
                        System.out.println("Uzvards nav korekts. Megini velreiz.");
                    }
                    students.get(studentID).editLastname(lastName);
                } else if (comand.equals("email")) {
                    while (true) {
                        System.out.println("Ievadi e-pastu:");
                        email = scanner.nextLine();

                        if (checker.checkEmail(email)) {
                            break;
                        }
                        System.out.println("E-pasts nav korekts. Megini velreiz.");
                    }
                    students.get(studentID).editEmail(email);
                } else {
                    System.out.println("Ta komanda ne eksiste!");
                }

            } else {
                System.out.println("Tads student neeksiste.");
            }
        } else {
            System.out.println("Nepareizi ierakstits personal kods.");
        }
        save();
    }
}
