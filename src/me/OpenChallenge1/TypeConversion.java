package me.OpenChallenge1;

public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        int i = 100;
        System.out.println(b+i); // b가 int 타입으로 자동 전환 -> 큰 타입으로는 자동 전환됨.
        System.out.println(10/4); // 정수끼리 나눔 -> 결과값도 정수이므로 2
        System.out.println(10.0/4); // 4가 자동으로 4.0으로 변하여 실수 나누기(double) = 2.5
        System.out.println((char)0x12340041); //(char)를 통해 강제 타입 변환. char로 변환된 결과 문자 A
        System.out.println((byte)(b+i)); // b+i는 227, 16진수로 0xE3 = -29. byte의 범위인 127을 초과함. 이때 저장값은 256-227.
        System.out.println((int)2.9+1.8); // 2.9를 먼저 정수화 ->2 + 1.8 = 3.8
        System.out.println((int)(2.9+1.8)); // 4.7를 정수화 -> 4
        System.out.println((int)2.9+(int)1.8); // 2 + 1 -> 3
    }
}
