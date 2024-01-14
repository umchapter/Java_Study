package me.OpenChallenge7;

import java.util.Vector;

interface IStack<T> {
    T pop();
    boolean push(T obj);
}

class MyStack<T> implements IStack<T> {
    Vector<T> v = new Vector<>();

    public T pop() {
        if (this.v.isEmpty()) {
            return null;
        }

        T lastElement = this.v.lastElement();
        this.v.remove(v.size() - 1);
        return lastElement;
    }

    public boolean push(T obj) {
        this.v.add(obj);
        return true;
    }
}

public class ExerciseNo9 {
    public static void main(String[] args) {
        IStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (true) {
            Integer n = stack.pop();
            if (n == null) {
                break;
            }
            System.out.print(n + " ");
        }
    }
}
