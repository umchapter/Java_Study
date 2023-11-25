package me.OpenChallenge5;

interface Shape2 {
    final double PI = 3.14;         // 상수
    void draw();                    // 도형을 그리는 추상 메소드
    double getArea();               // 도형의 면적을 리턴하는 추상 메소드
    default public void redraw() {  // 디폴트 메소드
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle2 implements Shape2 {
    int radius;
    public Circle2(int radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return radius * radius * PI;
    }
    @Override
    public void draw() {
        System.out.printf("반지름이 %d인 원입니다. \n", radius);
    }
    
}

public class ExerciseNo13 {
    public static void main(String[] args) {
        Shape2 donut = new Circle2(10);
        donut.redraw();
        System.out.println("면적은 " + donut.getArea());
    }
}
