package me.OpenChallenge7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class ExerciseNo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Double> iv = new Vector<>();
        HashMap<String, Double> score = new HashMap<>();
        score.put("A", 4.0);
        score.put("B", 3.0);
        score.put("C", 2.0);
        score.put("D", 1.0);
        score.put("F", 0.0);

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/E/F)>>");
        while (iv.size() < 6) {
            String stringInput = scanner.next();
            
            iv.add(score.get(stringInput));
        }

        double sum = 0.0;
        for (int i = 0; i < iv.size(); i++) {
            sum += iv.get(i);
        }

        System.out.println(sum / iv.size());

        scanner.close();
    }
}
