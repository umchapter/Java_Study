package com.test.thread;

public class SyncExam {
    
    public static void main(String[] args) {
        ExamA examA = new ExamA();

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            examA.ExamA1("tread1");
        }
    });
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            examA.ExamA2("thread2");
        }
    });
    thread1.start();
    thread2.start();
    // 순서상 thread1이 먼저 들어왔지만 thread1은 동기화가 적용되지 않기 때문에 thread2가 한번에 다 실행되고 thread1 실행
    }
}
