package me.cahpter3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 세 개를 입력하세요.");
        int sum = 0, n = 0;
        for(int i=0;i<3;i++) {
            System.out.print(i+1+">>");
        try {
            n = scanner.nextInt(); // 정수 입력
        } catch(InputMismatchException e) {
            System.out.println("정수가 아닙니다. 다시 입력하세요!");
            scanner.nextLine(); // 현재 입력 스트림에 남아있는 토큰을 지움
            i--; // 인덱스가 증가하지 않도록 미리 감소
            continue; // 다음루프 
        }
        sum += n;
        }
        System.out.println("합은 " + sum);
        scanner.close();
    }
}
