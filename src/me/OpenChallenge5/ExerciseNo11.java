package me.OpenChallenge5;

import java.util.Scanner;

abstract class Calc {
    protected int a, b;
    abstract void setValue(int a, int b);
    abstract int calculate();
}

class Add extends Calc {
    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int calculate() {
        return a + b;
    }
}

class Sub extends Calc {
    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int calculate() {
        return a - b;
    }
}

class Mul extends Calc {
    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int calculate() {
        return a * b;
    }
}

class Div extends Calc {
    @Override
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int calculate() {
        return a / b;
    }
}

public class ExerciseNo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("두 정수와 연산자를 입력하시오 >> ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();

        switch (operator) {
            case "+":
                Add add = new Add();
                add.setValue(a, b);
                System.out.println(add.calculate());
                break;
            case "-":
                Sub sub = new Sub();
                sub.setValue(a, b);
                System.out.println(sub.calculate());
                break;
            case "*":
                Mul mul = new Mul();
                mul.setValue(a, b);
                System.out.println(mul.calculate());
                break;
            case "/":
                Div div = new Div();
                if (b == 0 ) {
                    System.err.println("Can not divided by Zero");
                    break;
                }
                div.setValue(a, b);
                System.out.println(div.calculate());
                break;
        
            default:
                break;
        }

        scanner.close();
    }
}
