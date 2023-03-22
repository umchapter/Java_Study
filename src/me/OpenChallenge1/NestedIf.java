package me.OpenChallenge1;

import java.util.Scanner;

public class NestedIf {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("학년을 입력하세요.");
        int year = scanner.nextInt();
        
        System.out.println("성적을 입력하세요.");
        int score = scanner.nextInt();

        if(score >= 60) {
            if(year < 4) {
                System.out.println("합격입니다");
            }else if(score >=70) {
                System.out.println("합격입니다");
            }else {
                System.out.println("사형");
            }
        }else {
            System.out.println("사형");
        }

        // 중첩 조건 쓰지 않고 더 간단히 짤 수 있게 노력
        // if(score < 60) {
        //     System.out.print("사형");
        // } else if((year >= 4) & (score < 70)) {
        //     System.out.print("사형");
        // }else {
        //     System.out.println("합격입니다");
        // }

        scanner.close();
    }
}
