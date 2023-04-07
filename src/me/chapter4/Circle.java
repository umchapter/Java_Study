package me.chapter4;

public class Circle {
    int radius; // 원의 반지름 필드
    String name; // 원의 이름 필드

    // 생성자 이름은 클래스 이름과 동일 & 리턴 타입 없음 -> void를 사용할 수 없음
    // 다만 return; 구문을 통해 생성자 실행 끝낼 수 있음
    public Circle() { // 매개 변수 없는 생성자
        radius = 1;
        name = ""; // 필드 초기화
    } 

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int r, String n) { // 매개 변수를 가진 생성자 -> 오버로딩
        radius = r;
        name = n; // 필드를 매개 변수로 초기화
    } 

    public double getArea() { // 원의 면적 계산 메소드
        return 3.14*Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Circle pizza;                   // 레퍼런스 변수 pizza 선언
        pizza = new Circle();           // Circle 객체 생성, 반지름 1, 이름 ""으로 초기화.
        pizza.radius = 10;              // 피자의 반지름을 10으로 설정
        pizza.name = "자바피자";         // 피자의 이름설정
        double area = pizza.getArea();  // 피자의 면적 알아내기
        System.out.println(pizza.name + "의 면적은 " +area);

        Circle doughnut = new Circle();    // Circle 객체 생성, 반지름 1, 이름 ""으로 초기화.
        doughnut.radius = 2;              // 도넛의 반지름을 2로 설정
        doughnut.name = "자바도넛";         // 도넛의 이름설정
        area = doughnut.getArea();         // 도넛의 면적 알아내기
        System.out.println(doughnut.name + "의 면적은 " +area);

        Circle pi = new Circle(1, "pi"); // 객체 생성, 반지름을 1, 이름을 "pi"로 초기화
        area = pi.getArea();
        System.out.println(pi.name + "의 면적은 " +area);

        Circle[] c; // Circle 배열에 대한 레퍼런스 c 선언
        c = new Circle[5]; // 5개의 레퍼런스 배열 생성

        for(int i=0; i<c.length; i++) { // 배열의 개수 만큼
            c[i] = new Circle(i); // i 번째 원소 객체 생성
        }

        for(int i=0; i<c.length; i++) { // 배열의 모든 Circle 객체의 면적 출력
            System.out.print((int)(c[i].getArea()) + " ");
        }


    }
}
