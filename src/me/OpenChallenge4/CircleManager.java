package me.OpenChallenge4;

import java.util.Scanner;

class Circle {
    protected double x;
    protected double y;
    protected int radius;
    
    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.printf("(%.1f,%.1f) %d %n", x, y, radius);
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];
        for(int i=0; i<c.length; i++) {
            System.out.print("x, y, radius>>");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int radius = scanner.nextInt();
            c[i] = new Circle(x, y, radius);
        }

        Circle big = new Circle(0, 0, 0);
        for(Circle j : c) {
            if(j.radius > big.radius) {
                big = j;
            }
        }
        System.out.printf("가장 면적이 큰 원은 (%.1f,%.1f)%d", big.x, big.y, big.radius);
        scanner.close();
    }
}
