package me.OpenChallenge6;

class MyPoint {
    int x, y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("Point(%d,%d)", this.x, this.y);
    }

    public boolean equals(MyPoint point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        } else {
            return false;
        }
    }
}

public class ExerciseNo1 {
    public static void main(String[] args) {
        MyPoint p = new MyPoint(3, 50);
        MyPoint q = new MyPoint(4, 50);

        System.err.println(p);

        if (p.equals(q)) {
            System.out.println("같은 점");
        } else {
            System.out.println("다른 점");
        }
    }
}
