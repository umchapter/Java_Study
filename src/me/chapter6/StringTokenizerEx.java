package me.chapter6;

import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/"); // 구분자로 '/' 사용

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer("2+3+5+66+88+323", "+");

        int sum = 0;
        while (st2.hasMoreTokens()) {
            sum += Integer.parseInt(st2.nextToken());
        }
        System.out.println(sum);
    }
}
