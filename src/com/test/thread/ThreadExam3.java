package com.test.thread;

public class ThreadExam3 {
    public static void main(String[] args) throws InterruptedException {
        
        new Thread( // 비동기 방식 쓰레드 설정
            new Runnable() {

                @Override
                public void run() {

                    for(int i=0; i<10; i++)
                    try {
                        Thread.sleep(1000);
                        System.out.println("Hello World!!!");
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }).start();

        for(int i=0; i<10; i++) { // 이거까지는 동시 실행됨
            Thread.sleep(1000);
            System.out.println("Hello Catalina!!!");
        }

        for(int i=0; i<10; i++) { // 위 작업 다 끝나고 이 구문 실행됨
            Thread.sleep(1000);
            System.out.println("Hello Xavier!!");
        }
    }
}
