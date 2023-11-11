package me.chapter5;

class Shape {
    protected String name;
    public void paint() {
        draw();
    }
    public void draw() {
        System.out.println(name);
    }
}

public class Circle extends Shape {
    protected String name;
    
    @Override
    public void draw() {
        name = "Circle";
        super.name = "Shape";
        super.draw();
        System.out.println(name);
    }
    public static void main(String[] args) {
    Shape b = new Circle();
    b.paint();
    }
}
// 메인용으로 다른 public class 만들 경우
// Shape 클래스를 package내의 다른 클래스에서 참조할 수 있음
// -> java.lang.NoSuchMethodError 발생 