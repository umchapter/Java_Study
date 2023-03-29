package me.cahpter3;

import java.util.Scanner;

public class DevideByZeroHandling {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("나뉨수를 입력하시오 : ");
            int dividened = scanner.nextInt();

            System.out.print("나눗수를 입력하시오 : ");
            int divisor = scanner.nextInt();
        
            try{
                System.out.println(dividened + "를 " + divisor + "로 나누면 몫은 " + dividened/divisor + "입니다.");
                break; // 정상적 나누기 작업 이후 while문 벗어남
            } catch(ArithmeticException e) { // ArithmeticException 예외 처리 코드
                System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요.");
            }
        }
        scanner.close();
    }
}
