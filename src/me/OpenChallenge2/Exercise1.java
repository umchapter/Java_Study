package me.OpenChallenge2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 1번 문제 - 달러 환전
        // System.out.print("원화를 입력하세요(단위 원)>>>");
        // int won = scanner.nextInt();
        // float dollar = (float)won / 1100;
        // System.out.println(won + "원은 $" + dollar + "입니다");

        // 2번 문제 - 2자리 정수(10~99)를 입력 받아 각 자리수의 숫자가 동일한지 출력
        // System.out.print("2자리수 정수 입력(10~99)>>>");
        // short n = scanner.nextShort();
        // System.out.println(
        //     (n / 10) == (n % 10) ? //// 사실 11로 나누어 떨어지면 동일함
        //     "Yes ! 10의 자리와 1의 자리가 같습니다." :
        //     "10의 자리와 1의 자리가 서로 다릅니다"
        // );

        // 3번 문제 - 정수로 된 돈의 액수를 입력 받아 고액권부터 몇 개 필요한지 출력
        // System.out.print("금액을 입력하시오>>");
        // int money = scanner.nextInt();
        // int[] wonArray = {50000, 10000, 1000, 100, 50, 10, 1};
        // String[] wonNameArray = {"오만원", "만원", "천원", "백원", "오십원", "십원", "일원"};
        // for(int i = 0; i < wonArray.length; i++) {
        //     if((wonArray[i]>=1000) & (money / wonArray[i] != 0)) {
        //         System.out.println(wonNameArray[i] + "권 " + money / wonArray[i] + "매");
        //         money = money % wonArray[i];
        //     } else if((wonArray[i]<1000) & money / wonArray[i] != 0) {
        //         System.out.println(wonNameArray[i] + " " + money / wonArray[i] + "개");
        //         money = money % wonArray[i];
        //     } else {
        //         continue;
        //     }
        // }

        // 4번 문제 - 정수 3개 입력 받아 중간 크기의 수를 출력
        // System.out.print("정수 3개 입력>>");

        // int firstInt = Integer.parseInt(scanner.next());
        // int secondtInt = Integer.parseInt(scanner.next());
        // int thirdInt = Integer.parseInt(scanner.next());

        // int[] intArray = {firstInt, secondtInt, thirdInt};
        // Arrays.sort(intArray); // void 메소드

        // System.out.println("중간 값은 " + intArray[1]);

        // 5번 문제 - 삼각형의 변의 길이를 지정하는 정수 3개 입력 받아 삼각형 만들 수 있는지 판별 
        // System.out.print("정수 3개 입력>>");

        // int firstLength = Integer.parseInt(scanner.next());
        // int secondtLength = Integer.parseInt(scanner.next());
        // int thirdLength = Integer.parseInt(scanner.next());

        // int det = firstLength + secondtLength + thirdLength - 2 * Math.max(firstLength, Math.max(secondtLength, thirdLength));

        // System.out.println(
        //     det>0 ?
        //     "삼각형이 됩니다."
        //     : "삼각형이 되지 않습니다."
        //     );


        scanner.close();
    }
}
