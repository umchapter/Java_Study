package me.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i < 4; i++) {
            System.out.print("이름을 입력하세요>>");
            String s = scanner.next(); // 키보드로부터 이름을 입력
            a.add(s); // ArrayList 컬렉션에 삽입
        }

        for(int i = 0; i < a.size(); i++) {
            String name = a.get(i); // ArrayList의 i번째 문자열 얻어오기
            System.out.print(name + " ");
        }

        // 가장 긴 이름 출력
        int longestIndex = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(longestIndex).length() < a.get(i).length()) { // 이름 길이 비교
                longestIndex = i;
            }
        }
        System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));
        scanner.close();
    }
}
