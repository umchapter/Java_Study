package me.OpenChallenge1;

import java.util.Scanner;

public class ArithmeticOperator { // 초단위의 정수를 입력 받아 시간 형식 표시
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력하세요.");
        int time = scanner.nextInt(); // 정수 입력
        int second = time % 60; // 60으로 나눈 나머지는 초
        int minute = (time / 60) % 60;
        // 초를 60으로 나눠 분을 구하고 다시 60으로 나누어 몫을 시간으로, 나머지를 분으로 표현
        int hour = (time / 60) / 60;

        System.out.println(time + "초는 ");
        System.out.println(hour + "시간 ");
        System.out.println(minute + "분 ");
        System.out.println(second + "초입니다.");
        scanner.close();
    }
}
