package com.test.exam04;

class OuterClass {
    
    public int a = 3; //멤버 변수
    
    class InnerClass { // 내부 클래스

        public int d = 5;

        public void innerPrint(){
            System.out.println("내부 클래스");
        }
    }
}
