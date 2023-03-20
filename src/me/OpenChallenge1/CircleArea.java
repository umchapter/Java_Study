package me.OpenChallenge1;

public class CircleArea {
    public static void main(String[] args) {
        final double PI = 3.14d; // 원주율 상수값 선언

        double radius = 10.0d; // 반지름
        double circleArea = radius * radius * PI; //원 넓이
    
        //원 넓이 출력
        System.out.println("원의 면적 = " + circleArea);
    }
   
}
