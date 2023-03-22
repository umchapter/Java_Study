package me.OpenChallenge1;

import java.util.Scanner;

public class SuccessOrFail {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("시험 점수를 정수로 입력하십시오.");
        int score = scanner.nextInt();
        
        if(score>=80){
            System.out.println("합격입니다.");
        }else{
            System.out.println("사형");
        }

        scanner.close();
    }
}
