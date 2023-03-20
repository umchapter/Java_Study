package com.test.exam04;

import com.test.exam04.OuterClass.InnerClass;

public class InnerClassTest {
    
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();
        /* usingClass method는 OutClass의 내부 클래스(InClass)의
         * inTest method를 참조함.
         * inTest method는 다시 OutClass의 멤버 변수를 참조하고 있음.
         */

        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.a);

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass.d);
        innerClass.innerPrint();

    }
}
