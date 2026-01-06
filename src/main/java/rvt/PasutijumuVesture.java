package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasutijumuVesture {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File("data/pasutijumu_vesture.csv"))) {
            
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                System.out.println("Pasutijums #" + parts[0] + ": " + parts[1] + " pasutija " + parts[3] + " x " + parts[2] + " (" + parts[4] + " EUR) -> Kopa: " + (Integer.valueOf(parts[3]) * Double.valueOf(parts[4])) + " EUR");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
