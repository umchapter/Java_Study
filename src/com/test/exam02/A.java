package com.test.exam02;

public class A{
    A(){}
    int a = 1; //멤버 변수
    int b = 2;
    String str;
    /* 클래스의 생성자는 자동 생성됨. ex) A(){}
     * 생성자는 클래스의 이름과 같음. ex) A(String str){System.out.println("스트링 생성자")}
     * 생성자의 형태에 따라 객체를 생성하는 방법이 결정됨.
     */
    public int sum(int i, int j){
        return i + j;
    }
    A(String str){
        this.str = str; //입력받은 변수를 사용, 단, 멤버 변수 먼저 있어야 함.
    }
}