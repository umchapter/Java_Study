package me.OpenChallenge4;

import java.util.Scanner;

class Add {
    private int a;
    private int b;

    protected void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected int calculate() {
        return this.a + this.b;
    }
}

class Sub {
    private int a;
    private int b;

    protected void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected int calculate() {
        return this.a - this.b;
    }
}

class Mul {
    private int a;
    private int b;

    protected void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected int calculate() {
        return this.a * this.b;
    }
}

class Div {
    private int a;
    private int b;

    protected void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected int calculate() {
        return this.a / this.b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 정수와 연산자를 입력하시오>>");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();

        switch(operator){
            case "/" : {
                if(b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }else {
                    Div div = new Div();
                    div.setValue(a, b);
                    System.out.println(div.calculate());
                }
                break;
            }
            case "+" : {
                Add add = new Add();
                add.setValue(a, b);
                System.out.println(add.calculate());
                break;
            }
            case "-" : {
                Sub sub = new Sub();
                sub.setValue(a, b);
                System.out.println(sub.calculate());
                break;
            }
            case "*" : {
                Mul mul = new Mul();
                mul.setValue(a, b);
                System.out.println(mul.calculate());
                break;
            }
            default : {
                System.out.println("연산자를 정확히 입력해 주십시오.");
            }
        }

        scanner.close();
    }
}
