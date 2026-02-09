package studenti;

import java.util.Scanner;

public class Interface {
    Scanner scanner;
    Regex checker;
    Function f;

    public Interface() {
        scanner = new Scanner(System.in);
        f = new Function();
    }
    
    public void start() {
        String command;
        while(true) {
            System.out.println("Command list: register, show, remove, edit, exit");
            System.out.println("Command: ");
            command = scanner.nextLine();
            if (command.equals("register")){

            } else if(command.equals("show")) {

            } else if(command.equals("remove")) {

            } else if(command.equals("edit")) {

            } else if(command.equals("exit")) {
                break;
            } else {
                System.out.println("Nav tada command");
            }
        }
    }
}
