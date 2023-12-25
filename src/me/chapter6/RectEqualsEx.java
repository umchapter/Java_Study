package me.chapter6;

class RectEqualsExRect {
    private int width;
    private int height;
    public RectEqualsExRect(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public boolean equals(Object obj) {
        RectEqualsExRect rect = (RectEqualsExRect) obj; // obj를 RectEqualsRect로 다운캐스팅
        if(width * height == rect.width * rect.height) {
            return true;
        } else {
            return false;
        }
    }
}

public class RectEqualsEx {
    public static void main(String[] args) {
        RectEqualsExRect a = new RectEqualsExRect(2, 3);
        RectEqualsExRect b = new RectEqualsExRect(3, 2);
        RectEqualsExRect c = new RectEqualsExRect(3, 4);

        if(a.equals(b)) {
            System.out.println("a is equal to b");
        }
        if(a.equals(c)) {
            System.out.println("a is equal to c");
        }
        if(b.equals(c)) {
            System.out.println("b is equal to c");
        }
    }
}
