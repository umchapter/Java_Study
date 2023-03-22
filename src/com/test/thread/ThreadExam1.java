package com.test.thread;

class ExamClass implements Runnable { // interface
    
    @Override
    public void run() {
        System.out.println("Thread가 실행");
    }
}

public class ThreadExam1 {
    
    public static void main(String[] args) {
        
        Thread thread = new Thread(new ExamClass()); // Runnaable 쓰는 경우 Thread 객체 선언하면서 Runable 도입
        thread.start();
    }
}
