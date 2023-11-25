package me.OpenChallenge5;

import java.util.Scanner;

interface Stack {
    int length();
    int capacity();
    String pop();
    boolean push(String val);
}

class StringStack implements Stack {
    private String[] stack;

    public StringStack(int length) {
        this.stack = new String[length];

    }
    public int length() {
        for (int i=0; i < stack.length; i++) {
            if(stack[i] == null) {
                return i;
            }
        }
        return stack.length;
    }
    public int capacity() {
        return stack.length - this.length();
    }
    public String pop() {
        if(this.length() > 0) {
            String top = stack[this.length() - 1];
            stack[this.length() - 1] = null;
            return top;
        } else {
            return "Stack is empty";
        }
    }
    public boolean push(String val) {
        if(this.capacity() > 0) {
            stack[this.length()] = val;
            return true;
        } else {
            return false;
        }
    }
}

public class ExerciseNo9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("총 스택 저장 공간의 크기 입력 >> ");
        int length = scanner.nextInt();

        StringStack stack = new StringStack(length);

        while (true) {
            System.out.print("문자열 입력 >> ");
            String element = scanner.next();

            if(element.equals("그만")) {
                break;
            }

            if(stack.capacity() == 0) {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            } else {
                stack.push(element);
            }
        }

        String result = "";

        while (stack.length() > 0) {
            result += " " + stack.pop();
        }

        System.out.println("스택에 저장된 모든 문자열 팝 :" + result);

        scanner.close();
    }
}
