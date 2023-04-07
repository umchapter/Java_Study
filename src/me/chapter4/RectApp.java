package me.chapter4;

import java.util.Scanner;

class Rectangle {
    int width;
    int height;
    public int getArea() {
        return width * height ;
    }
}

public class RectApp {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(); // 자동으로 기본 생성자 만들어짐 -> 객체 생성가능
        Scanner scanner = new Scanner(System.in);
        System.out.print("사각형의 밑변과 높이를 입력하세요>> ");
        rect.width = scanner.nextInt();
        rect.height = scanner.nextInt();
        System.out.println("사각형의 면적은 " + rect.getArea());
        scanner.close();
    }
    
}
