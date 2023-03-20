package com.test.exam04;

class Parent {
    

    int a = 3;
    int b = 4;
    
    protected void parentPrint(){
        System.out.println("부모 클래스");
    }
}

class Child extends Parent{ //extends를 통해 부모 클래스 상속

    int c = 5;
    int d = 6;
    public void childPrint(){
        System.out.println("자식 클래스");
    }
}

public class InheritanceExam {
    
    public static void main(String[] args) {
        Child child = new Child();
        child.parentPrint();
        child.childPrint();
    }
}
