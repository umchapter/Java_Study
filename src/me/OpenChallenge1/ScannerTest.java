package me.OpenChallenge1;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println("합을 구할 정수를 빈칸으로 구별하여 두 개 입력하세요.");
        
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("합계는 " + (a + b));
        scanner.close(); // 잊지말고 닫기
    }
}
