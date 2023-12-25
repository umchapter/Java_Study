package me.OpenChallenge6;

import java.util.Scanner;

public class ExerciseNo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.");
        System.out.print(">> ");
        String input = scanner.nextLine();

        for (int i=1; i < input.length() + 1; i++) {
            System.out.println(input.substring(i, input.length()) + input.substring(0, i));
        }

        scanner.close();
    }
}
