package me.chapter4;

import java.util.Scanner;

class CurrencyConverter {

    private static double rate; // $1에 대한 원화
    public static double toDollar(double won) {
        return won/rate; // 원화를 달러로 변환
    }

    public static double toKWR(double dollar) {
        return dollar*rate; // 달러를 원화로 변환
    }

    public static void setRate(double r) { // -> static 메소드는 static 필드를 사용할 수 있음. 
        rate = r; // 환율 설정. 원/$1
    }

}

public class StaticMember {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("환율(1달러)>>");
        double rate = scanner.nextDouble();
        CurrencyConverter.setRate(rate); // 미국 달러 환율 설정 -> static 메소드는 static 하게 사용 (like Math.sqrt())
        System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다.");
        System.out.println("$100는" + CurrencyConverter.toKWR(100) + "원입니다.");

        scanner.close();
    }
}
