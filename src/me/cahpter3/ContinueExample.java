package me.cahpter3;
import java.util.Scanner;

public class ContinueExample {
    
    public static void main(String[] args) { // 정수 5개 받아서 양수 합만 출력
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("정수 5개를 입력하세요.");
        int sum = 0;

        for(int i=0; i<5; i++) {
            int n = scanner.nextInt();
            if(n<=0) {
                continue; // 반복문을 빠져나가지 않은채로 반복 후 작업(i++)로 분기
            } else {
                sum += n; // 양수인 경우에만 덧셈
            }
        }
        System.out.println("양수의 합은" + sum);

        scanner.close();
    }
}
