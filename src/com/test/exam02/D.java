package com.test.exam02;

public class D {
    
    public static int d; // 멤버 변수에 static 쓸 경우, 다른 인스턴스에서 불러가도 같은 값을 공유
    public int e;

    public static void ddd(){
        System.out.println("D클래스의 ddd 메소드"); // static method는 별도 인스턴스 없이 실행 가능

        final int a = 3; // const 선언. data가 아닌 instruction으로 분류.

        System.out.println("상수값 a = " + a);
    }
    /* 자바 애플리케이션이 작동되는 순서
     * 1.JVM(자바가상머신)이 작동
     * 2.가상머신이 자바 프로그램 내에 있는 main 메소드를 메모리에 로딩
     *   --> static main 메소드가 실행됨. main method --> 자바 애플리케이션의 entry point(시작점)
     * 3.동시에 static 예약어가 붙어있는 method, variable, class 등을 메모리에 로딩
     */

}