package me.chapter4;

import java.util.Arrays;

public class MethodSample {
    public int getSum(int i, int j) { // 오버로딩 성공 조건 -> 1. 메소드 이름이 같을 것. & 2. 매개변수의 개수나 타입이 서로 다를 것.
        return i + j;
    }
    public int getSum(int i, int j, int k) { // 매개변수의 개수가 다른 경우
        return i + j + k;
    }
    public double getSum(double i, double j) { // 매개변수의 타입이 다른 경우
        return i + j;
    }
    /*
    public double getSum(int i, int j) { -> 매개변수의 개수, 타입이 모두 같기 때문에 오버로딩 실패
        return (double)(i + j);          -> 리턴 타입이 더블이라도 매개변수 인트이기 때문에 실패함
    }
     */
    public double getSum(double[] doubleArr) { // 매개변수의 개수와 타입 모두 다른 경우
        double sum = Arrays.stream(doubleArr).sum();
        return sum;
    }

    public static void main(String[] args) {
        MethodSample methodSample = new MethodSample();
        double[] doubleArr = {1.4, 2.6, 8.5, 9.1, 0.235, 4.6512, 0.8984};   
        System.out.println(methodSample.getSum(doubleArr));
    }
}
