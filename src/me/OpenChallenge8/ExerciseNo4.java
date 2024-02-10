package me.OpenChallenge8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExerciseNo4 {
    public static void main(String[] args) {
        String file = "c:\\windows\\system.ini";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int rowNum = 1;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    System.out.println(String.format("%2d", rowNum) + ": " + line);
                    rowNum ++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
