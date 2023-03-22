package com.test.thread;

class ExamClass1 extends Thread { // 클래스 상속 방식

    @Override
    public void run() {
        System.out.println(("Thread가 시작"));
    }
}

public class ThreadExam2 {
    
    public static void main(String[] args) {
        ExamClass1 examClass1 = new ExamClass1(); // 그냥 쓰레드 객체 상속 받은 클래스 사용
        examClass1.start();
    }
}
