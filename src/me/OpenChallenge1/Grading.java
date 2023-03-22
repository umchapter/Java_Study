package me.OpenChallenge1;

import java.util.Scanner;

public class Grading {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String grade;
        System.out.println("성적을 입력해주세요.");
        int score = scanner.nextInt();

        if(score >= 90) {
            grade = "A";
        }else if((score < 90) & (score >= 80)) {
            grade = "B";
        }else if((score < 80) & (score >= 70)) {
            grade = "C";
        }else if((score < 70) & (score >= 60)) {
            grade = "D";
        }else {
            grade = "F";
        }

        System.out.println("학점은 " + grade + "입니다.");

        scanner.close();
    }
}
