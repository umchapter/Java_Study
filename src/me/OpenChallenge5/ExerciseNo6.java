package me.OpenChallenge5;

class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class CP extends Point {
    private String color;
    public CP() {
        super(0, 0);
        color = "BLACK";
    }

    public CP(int x, int y) {
        super(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("%s색의 (%d,%d)의 점", color, getX(), getY());
    }

    public void setXY(int x, int y) {
        move(x, y);
    }
}

public class ExerciseNo6 {
    public static void main(String[] args) {

        CP zeroPoint = new CP();
        System.out.println(zeroPoint.toString() + "입니다.");

        CP cp = new CP(10, 10);
        cp.setXY(5, 5);
        cp.setColor("RED");
        System.out.println(cp.toString() + "입니다.");
    }
}
