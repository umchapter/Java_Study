package me.OpenChallenge8;

import java.io.File;

public class ExerciseNo8 {
    public static void main(String[] args) {
        File[] files = new File("c:\\").listFiles();
        File largest = null;

        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }

            if (largest == null) {
                largest = file;
            }
            
            if(file.length() > largest.length()) {
                largest = file;
            }
        }

        System.out.println("가장 큰 파일은 " + largest.getAbsolutePath() + " " + largest.length() + "바이트");
    }
}
