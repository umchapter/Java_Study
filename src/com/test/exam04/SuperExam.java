package com.test.exam04;

class Point {
    int i = 10;
    int j = 20;
    Point(int x, int y) {
        this.i = x;
        this.j = y;
    }
}

class Point3D extends Point {
    int k = 30;
    Point3D() { // 인자가 없는 경우의 Point3D 생성자(기본 생성자)
        this(100, 200, 300); // x,y,z 가 나오는 이유는 아래의 생성자에서 사용하는 패러미터이기 때문
    }

    Point3D(int x, int y, int z) { // 인자가 3개인 Point3D의 생성자
        super(x, y); // 부모 클래스인 Point 클래스의 Point(int x, int y 의미)
        this.k = z;
    }
}

public class SuperExam {
    public static void main(String[] args) {
        Point3D point3d = new Point3D();
        System.out.println("point3d의 값 = " + point3d.i + " " + point3d.j + " " + point3d.k);

        Point3D point3d2 = new Point3D(5,6,7);
        System.out.println("point3d2의 값 = " + point3d2.i + " " + point3d2.j + " " + point3d2.k);
    }    
}
