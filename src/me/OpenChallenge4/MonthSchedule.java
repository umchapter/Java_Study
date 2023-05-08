package me.OpenChallenge4;

import java.util.Scanner;

class Day {
    
    private String work;
    
    public void set(String work) {
        this.work = work;
    }

    public String get() {
        return work;
    }

    public void show() {
        if(work == null) {
            System.out.print("없습니다.");
        }else {
            System.out.print(work + "입니다.");
        }
    }
}


public class MonthSchedule {
    public Day[] monthDays;
    
    public MonthSchedule(int days) {
        this.monthDays = new Day[days];

        for (int i=0; i<monthDays.length; i++) {
            monthDays[i] = new Day();
        }
    }

    public void input(int day, String work) {
        this.monthDays[day].set(work);
    }

    public void view(int day) {
        System.out.printf("%d일의 할일은 ", day);
        this.monthDays[day].show();
        System.out.println("");
    }

    public boolean finish() {
        System.out.println("프로그램을 종료합니다");
        return false;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이번달 스케쥴 관리 프로그램.");
        
        while(true) {
            System.out.print("스케쥴(입력:1, 보기:2, 끝내기:3) >>");
            int order = scanner.nextInt();
            
            if (order == 1) {
                System.out.print("날짜(1~30)?");
                int day = scanner.nextInt();

                System.out.print("할일(빈칸없이입력)?");
                String work = scanner.next();

                this.input(day, work);
                         
                
            }else if (order == 2) {
                System.out.print("날짜(1~30)?");
                int day = scanner.nextInt();

                this.view(day);

            } else if (order == 3) {
                this.finish();
                break;

            } else {
                System.out.println("1부터 3까지의 숫자를 입력해주세요.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {

        MonthSchedule april = new MonthSchedule(31);
        april.run();
    }
}
