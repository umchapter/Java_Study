package me.OpenChallenge7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

class ScholarshipManagement {
    HashMap<String, Double> data;
    Scanner scanner;
    
    public ScholarshipManagement() {
        this.data = new HashMap<>();
        this.scanner = new Scanner(System.in);

        this.init();
    }

    private void init() {
        System.out.println("미래장학금관리시스템입니다.");

        while (true) {
            if (this.data.size() >= 5) {
                break;
            }
            System.out.print("이름과 학점>> ");
            String[] splittedInput = this.scanner.nextLine().split(" ");

            String name = splittedInput[0];
            try {
                Double score = Double.parseDouble(splittedInput[1]);
                this.data.put(name, score);
            } catch (NumberFormatException e) {
                System.err.println("입력을 확인하세요.");
                continue;
            }
        }        
    }

    private ArrayList<String> searchStudentsAboveThreshold() {
        Double threshold;
        ArrayList<String> students = new ArrayList<>();
        while (true) {
            System.out.print("장학생 선발 학점 기준 입력>> ");
            try {
                threshold = this.scanner.nextDouble();
                this.scanner.close();
                break;
            } catch (InputMismatchException e) {
                System.err.println("입력을 확인하세요.");
                continue;
            }
        }

        Iterator<String> keyIterator = this.data.keySet().iterator();

        while (keyIterator.hasNext()) {
            String name = keyIterator.next();
            Double score = this.data.get(name);
            if (score >= threshold) {
                students.add(name);
            } else {
                continue;
            }
        }
        return students;
    }

    private String studentsListToString(ArrayList<String> students) {
        String resultString = "";
        for (String student : students) {
            resultString += student + " ";
        }
        return resultString.substring(0, resultString.length() - 1);
    }

    public void run() {
        ArrayList<String> students = this.searchStudentsAboveThreshold();
        System.out.println("장학생 명단 : " + this.studentsListToString(students));
    }
}

public class ExerciseNo7 {
    public static void main(String[] args) {
        ScholarshipManagement sm = new ScholarshipManagement();
        sm.run();
    }
}
