package me.chapter4;

public class Circle {
    int radius; // 원의 반지름 필드
    String name; // 원의 이름 필드

    public Circle() {} // 생성자

    public double getArea() { // 원의 면적 계산 메소드
        return 3.14*Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Circle pizza;                   // 레퍼런스 변수 pizza 선언
        pizza = new Circle();           // Circle 객체 생성
        pizza.radius = 10;              // 피자의 반지름을 10으로 설정
        pizza.name = "자바피자";         // 피자의 이름설정
        double area = pizza.getArea();  // 피자의 면적 알아내기
        System.out.println(pizza.name + "의 면적은 " +area);

        Circle doughnut = new Circle();    // Circle 객체 생성
        doughnut.radius = 2;              // 도넛의 반지름을 2로 설정
        doughnut.name = "자바도넛";         // 도넛의 이름설정
        area = doughnut.getArea();         // 도넛의 면적 알아내기
        System.out.println(doughnut.name + "의 면적은 " +area);


    }
}
