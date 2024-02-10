package me.OpenChallenge8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExerciseNo2 {
    public static void main(String[] args) {
        String file = "c:\\Temp\\phone.txt";
        try {
            Scanner scanner = new Scanner(new FileReader(file));
            System.out.println(file + "을 출력합니다.");
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }        
    }
}
