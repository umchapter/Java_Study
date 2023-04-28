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
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Day[] monthDays = new Day[30];

        for (int i=0; i<monthDays.length; i++) {
            monthDays[i] = new Day();
        }

        System.out.println("이번달 스케쥴 관리 프로그램.");
        
        while(true) {
            System.out.print("스케쥴(입력:1, 보기:2, 끝내기:3) >>");
            int order = scanner.nextInt();
            
            if (order == 1) {
                System.out.print("날짜(1~30)?");
                int day = scanner.nextInt();

                System.out.print("할일(빈칸없이입력)?");
                String work = scanner.next();

                monthDays[day].set(work);                           
                
            }else if (order == 2) {
                System.out.print("날짜(1~30)?");
                int day = scanner.nextInt();

                System.out.printf("%d의 할일은", day);
                monthDays[day].show();
                System.out.println("");

            } else if (order == 3) {
                System.out.println("프로그램을 종료합니다");
                break;

            } else {
                System.out.println("1부터 3까지의 숫자를 입력해주세요.");
            }
        }

        scanner.close();
    }
}
