package me.OpenChallenge2;

import java.text.Format;
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

        // int firstLength = scanner.nextInt();
        // int secondtLength = scanner.nextInt();
        // int thirdLength = scanner.nextInt();

        // int det = firstLength + secondtLength + thirdLength -2*Math.max(firstLength, Math.max(secondtLength, thirdLength));

        // System.out.println(
        //     det>0 ?
        //     "삼각형이 됩니다."
        //     : "삼각형이 되지 않습니다."
        //     );

        // 6번 문제 - 입력받은 정수(1~99)에 대해 369게임
        // System.out.print("1~99사이의 정수를 입력하시오>>");
        // String[] inputStr = scanner.next().split("");
        
        // int cnt = 0;

        // for(String i : inputStr) { // 더 쉬운 방법 없나?
        //     if(i.equals("3") | i.equals("6") | i.equals("9")){
        //         ++cnt;
        //     }
        // }
        
        // System.out.println(
        //     cnt!=0?
        //     "박수" + "짝".repeat(cnt):
        //     " ");

        // 7번 문제 - 2차원 평면에서 입력 받은 (x,y) 좌표가 (100,100), (200,200) 두 점으로 이루어진 직사각형 내부에 있는지 판별
        // System.out.print("점 (x,y)의 좌표를 입력하시오>>");
        
        // int xCoord = scanner.nextInt();
        // int yCoord = scanner.nextInt();

        // if((xCoord >= 100) & (xCoord <= 200) & (yCoord >=100) & (yCoord <=200)) {
        //     System.out.printf("(%d, %d)는 사각형 안에 있습니다", xCoord, yCoord);
        // } else {
        //     System.out.printf("(%d, %d)는 사각형 밖에 있습니다", xCoord, yCoord);
        // }

        // 8번 문제 - 입력 받은 두 점 (x1, y1), (x2, y2)로 이루어진 직사각형이 두 점 (100, 100), (200, 200)으로 이루어진 직사각형과 충돌하는지 판별
        // System.out.print("점 (x1,y1)의 좌표를 입력하시오>>");
        
        // int x1Coord = scanner.nextInt();
        // int y1Coord = scanner.nextInt();

        // System.out.print("점 (x2,y2)의 좌표를 입력하시오>>");

        // int x2Coord = scanner.nextInt();
        // int y2Coord = scanner.nextInt();

        // if((Math.min(x1Coord, x2Coord) > 200 || Math.max(x1Coord, x2Coord) < 100)
        //   || (Math.min(y1Coord, y2Coord) > 200 || Math.max(y1Coord, y2Coord) < 100)){
        //     System.out.println("두 사각형이 충돌하지 않습니다.");
        // } else {
        //     System.out.println("두 사각형이 충돌합니다.");
        // }

        // 9번 문제 - 원의 중심과 반지름을 실수 값으로 입력받고, 다른 점(x, y)를 입력받아 이 점이 원의 내부에 있는지 판별
        // System.out.print("원의 중심과 반지름 입력>>");
        
        // Double centerXCoord = scanner.nextDouble();
        // Double centerYCoord = scanner.nextDouble();
        // Double circleRadius = scanner.nextDouble();

        // System.out.print("점 입력>>");

        // Double xCoord = scanner.nextDouble();
        // Double yCoord = scanner.nextDouble();

        // Double dist = Math.sqrt(Math.pow((centerXCoord - xCoord), 2) + Math.pow((centerYCoord - yCoord), 2));

        // System.out.printf(
        //     (dist <= circleRadius ?
        //     "점 (%.1f, %.1f)는 원 안에 있다." :
        //     "점 (%.1f, %.1f)는 원 밖에 있다."), xCoord, yCoord
        // );

        // 10번 문제 - 두 개의 원의 중심과 반지름을 각각 입력 받아 두 원이 겹치는지 판별
        // System.out.print("첫번째 원의 중심과 반지름 입력>>");
        
        // Double firstCenterXCoord = scanner.nextDouble();
        // Double firstCenterYCoord = scanner.nextDouble();
        // Double firstCircleRadius = scanner.nextDouble();

        // System.out.print("두번째 원의 중심과 반지름 입력>>");

        // Double secondCenterXCoord = scanner.nextDouble();
        // Double secondCenterYCoord = scanner.nextDouble();
        // Double secondCircleRadius = scanner.nextDouble();

        // Double dist = Math.sqrt(Math.pow((firstCenterXCoord - secondCenterXCoord), 2) + Math.pow((firstCenterYCoord - secondCenterYCoord), 2));

        // System.out.println(
        //     (dist <= (firstCircleRadius + secondCircleRadius) ?
        //     "두 원은 서로 겹친다" :
        //     "두 원은 서로 겹치지 않는다.")
        // );

        // 11번 문제 - 숫자를 입력 받아 해당 월이 속한 계절 출력
        // System.out.print("달을 입력하세요(1~12)>>");
        // int month = scanner.nextInt();

        // 11-1. if문 형태
        // if((month < 1) || (month > 12)) {
        //     System.out.println("잘못입력");
        // } else if((month >= 3) && (month < 6)) {
        //     System.out.println("봄");
        // } else if((month >= 6) && (month < 9)) {
        //     System.out.println("여름");
        // } else if((month >= 9) && (month < 12)) {
        //     System.out.println("가을");
        // } else {
        //     System.out.println("겨울");
        // }

        // 11-2. switch-case 형태
        // switch(month) {
        //     case 3 : case 4 : case 5 : {
        //         System.out.println("봄");
        //         break;
        //     }
        //     case 6 : case 7 : case 8 : {
        //         System.out.println("여름");
        //         break;
        //     }
        //     case 9 : case 10 : case 11 : {
        //         System.out.println("가을");
        //         break;
        //     }
        //     case 12 : case 1 : case 2 : {
        //         System.out.println("겨울");
        //         break;
        //     }
        //     default : {
        //         System.out.println("잘못입력");
        //     }
        // }

        // 12번 문제 - 사칙연산식을 입력 받아 결과 출력
        System.out.print("연산>>"); // 빈칸으로 분리하여 입력
        int firstInt = scanner.nextInt();
        String operator = scanner.next();
        int secondInt = scanner.nextInt();

        // if-else 형식
        // if(operator.equals("/") && (secondInt == 0)) {
        //     System.out.println("0으로 나눌 수 없습니다.");
        // } else if(operator.equals("/")) {
        //     float result = (float)firstInt / (float)secondInt;
        //     System.out.printf("%d%s%d의 계산 결과는 %.2f" , firstInt, operator, secondInt, result);
        // } else if(operator.equals("+")) {
        //     int result = (firstInt + secondInt);
        //     System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
        // } else if(operator.equals("-")) {
        //     int result = (firstInt - secondInt);
        //     System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
        // } else if(operator.equals("*")) {
        //     int result = (firstInt + secondInt);
        //     System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
        // } else if(operator.equals("*")) {
        //     int result = (firstInt * secondInt);
        //     System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
        // } else {
        //     System.out.println("잘못입력");
        // }

        // switch-case 형식
        switch(operator) {
            case("/") : {
                if(secondInt == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                } else {
                    float result = (float)firstInt / (float)secondInt;
                    System.out.printf("%d%s%d의 계산 결과는 %.2f" , firstInt, operator, secondInt, result);
                    break;
                }
            } case("+") : {
                int result = (firstInt + secondInt);
                System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
                break;
            } case("-") : {
                int result = (firstInt - secondInt);
                System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
                break;
            } case("*") : {
                int result = (firstInt * secondInt);
                System.out.printf("%d%s%d의 계산 결과는 %d" , firstInt, operator, secondInt, result);
                break;
            } default : {
                System.out.println("잘못입력");
            }

        }

        scanner.close();
    }
}
