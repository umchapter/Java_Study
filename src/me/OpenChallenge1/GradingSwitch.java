package me.OpenChallenge1;

import java.util.Scanner;

public class GradingSwitch {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        char grade;
        byte score;

        System.out.println("성적을 입력해주십시오.");
        score = scanner.nextByte();

        switch(score / 10) { // case 문의 값은 정수 리터럴, 문자 리터럴, 문자열 리터럴만 허용함.
            case 10 : {} // score = 100
            case 9 : { // 90 <= score < 100
                grade = 'A'; // char의 경우 '' 사용
                break; // case 10, 9 모두 실행
            }
            case 8 : {
                grade = 'B';
                break;
            }
            case 7 : {
                grade = 'C';
                break;
            }
            case 6 : {
                grade = 'D';
                break;
            }
            default : { // 그 이외를 의미
                grade = 'F';
            }
        }
        System.out.println(("학점은 " + grade + "입니다."));

        scanner.close();

    }
}
