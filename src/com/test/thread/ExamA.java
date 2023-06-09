package com.test.thread;

class ExamA {
    public void ExamA1(String thread) {
        System.out.println("ExamA1 시작");
        synchronized (this) {
            for(int i=0; i < 3; i++) {
                System.out.println("thread : " + thread + ", ExamA1 : " + i);
            }
            System.out.println("ExamA1 끝");
        }
    }
    public synchronized void ExamA2(String thread) { // A2는 동기처리 함
        System.out.println("ExamA2 시작");
        for(int i=0; i < 3; i++) {
            System.out.println("thread : " + thread + ", ExamA2 : " + i);
        }
        System.out.println("ExamA2 끝");
    }
}
