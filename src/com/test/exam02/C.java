package com.test.exam02;

public class C {
    
    private int i = 10; // 멤버 변수
    private int j = 11;
    private int k = 12;

    public C(){} // 기본 생성자
    
    public C(int i){
        this.i = i;
        System.out.println("C클래스 i = " + this.i);

    }

    public C(int j, int k){
        this.j = j;
        this.k = k;
        System.out.println("C클래스 j = " + this.j);
        System.out.println("C클래스 k = " + this.k);
    }

    public void ccc(int i){
        System.out.println("인자가 하나!");
    }

    public void ccc(int i, int j){
        System.out.println("인자가 둘!!");
    }

    public void ccc(int i, int j, int k){
        System.out.println("인자가 셋!!!");
    }
    // 생성자는 클래스를 메모리에 생성
    // 생성자의 인자를 달리하여 여러 생성자 구성 가능 = 오버로딩

    
}
