package me.chapter4;

class Calc { // static method만 가진 class
    public static int abs(int a) {
        return (a>0)?a:-a;
    }
    public static int max(int a, int b) {
        return (a>b)?a:b;
    }
    public static int min(int a, int b) {
        return (a>b)?b:a;
    }
}

public class CalcEx {
    public static void main(String[] args) {
        System.out.println((Calc.abs(-5))); // static한 방법으로 메소드 불러옴
        System.out.println((Calc.max(10, 8)));
        System.out.println((Calc.min(-3, -8)));
    }
}