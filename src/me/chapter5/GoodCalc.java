package me.chapter5;

import java.util.stream.IntStream;

abstract class Calculator {
    public abstract int add(int a, int b);      // 두 정수의 합을 구하여 리턴
    public abstract int subtract(int a, int b); // 두 정수의 차를 구하여 리턴
    public abstract double average(int[] a);    // 배열에 저장된 정수의 평균을 리턴    
}

public class GoodCalc extends Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
    @Override
    public double average(int[] a) {
        return (double) IntStream.of(a).sum() / a.length;
    }

    public static void main(String[] args) {
        GoodCalc c = new GoodCalc();
        System.out.println(c.add(2,3));
        System.out.println(c.subtract(2,3));
        System.out.println(c.average(new int[] {2,3,4,5}));
    }
}
