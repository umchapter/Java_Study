package me.chapter5;

import com.test.exam02.C;

class Shape { // 슈퍼 클래스
    public Shape next;
    public Shape() {next = null;}

    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() { // 슈퍼 클래스의 draw 메소드와 이름(draw), 리턴 타입(void), 매개변수 리스트(매개변수 없음) 동일 -> 메소드 오버라이딩
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() { // 메소드 오버라이딩
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() { // 메소드 오버라이딩
        System.out.println("Circle");
    }
}
public class UsingOverride {
    /* Line, Rect, Line, Circle 객체들을 생성하여 링크드 리스트로 연결함
     * 생성된 각 도형 객체에는 Shape의 draw()와 오버라이딩한 draw() 메소드가 존재
     * start 변수는 링크드 리스트의 시작 주소(레퍼런스)를 저장
     * last는 링크드 리스트에 연결된 마지막 도형 객체의 주소(레퍼런스)를 저장
     * obj는 새로 생긴 도형 객체의 주소(레퍼런스)를 저장
     * start에서부터 연결된 모든 도형 객체를 방문하면서 draw() 메소드를 호출
     */

     public static void main(String[] args) {
        Shape start, last, obj;

        // 링크드 리스트로 도형 생성하여 연결
        start = new Line(); // Line 객체 연결
        last = start;
        obj = new Rect(); // Rect 객체 연결
        last.next = obj;
        last = obj;
        obj = new Line(); // Line 객체 연결
        last.next = obj;
        last = obj;
        obj = new Circle(); // Circle 객체 연결
        last.next = obj;
    
        // 모든 도형 출력
        Shape p = start;
        while (p != null) {
            p.draw();;
            p = p.next;
        }
     }
}
