package me.OpenChallenge4;

import java.util.Arrays;
import java.util.Scanner;

class Seats {
    char seatClass;
    String[] seat = "---,".repeat(10).split(",");

    public Seats(char seatClass) {
        this.seatClass = seatClass;
    }

    public void reserveASeat(String name, int seatNum) {
        this.seat[seatNum-1] = name;
    }

    public boolean cancelASeat(String name) {
        for(int i=0; i<10; i++) {
            if(this.seat[i].equals(name)) {
                this.seat[i] = "---";
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public void showSeats() {
        System.out.println(this.seatClass + ">> " + Arrays.toString(this.seat));
    }
}

class ConcertDay {
    int day;
    Seats S = new Seats('S');
    Seats A = new Seats('A');
    Seats B = new Seats('B');

    public ConcertDay(int day) {
        this.day = day;
    }
}

public class ReservationSystem {
    Scanner scanner = new Scanner(System.in);

    public void reservation(ConcertDay selectedDay) {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatClass = scanner.nextInt();

        if((seatClass < 1)||(3 < seatClass)){
            System.out.println("입력을 확인해주십시오.");
            return ;
        }
        
        Seats selectedSeats;           

        if(seatClass == 1){selectedSeats = selectedDay.S;}
        else if(seatClass == 2){selectedSeats = selectedDay.A;}
        else{selectedSeats = selectedDay.B;}
        
        selectedSeats.showSeats();
        System.out.print("이름>>");
        String name = scanner.next();

        while(true) {
            System.out.print("번호>>");
            int seatNum = scanner.nextInt();

            if(seatNum < 1 || 10 < seatNum ) {
                System.out.println("입력을 확인해주십시오.");
            } else {
                selectedSeats.reserveASeat(name, seatNum);
                return ;
            }
        }
    }

    public void cancelation(ConcertDay selectedDay) {
        System.out.print("좌석 S(1), A(2), B(3)>>");
        int seatClass = scanner.nextInt();

        if((seatClass < 1)||(3 < seatClass)){
            System.out.println("입력을 확인해주십시오.");
            return ;
        }
        
        Seats selectedSeats;           

        if(seatClass == 1){selectedSeats = selectedDay.S;}
        else if(seatClass == 2){selectedSeats = selectedDay.A;}
        else{selectedSeats = selectedDay.B;}
        
        selectedSeats.showSeats();

        while(true) {
            System.out.print("이름>>");
            String name = scanner.next();

            if(selectedSeats.cancelASeat(name)) {
                selectedSeats.showSeats();
                return ;
            } else {
                System.out.println("입력을 확인해주십시오.");
                continue;
            }
        }
    }

    public void run() {
        ConcertDay[] month = new ConcertDay[30];
        for(int i=0; i<30; i++) {
            month[i] = new ConcertDay(i+1);
        }        
        System.out.println("명품콘서트홀 예약 시스템입니다.");

        System.out.print("날짜를 선택해주세요(1~30)>>");
        int day = scanner.nextInt();
        ConcertDay selectedDay = month[day-1];

        while(true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int menuNum = scanner.nextInt();
            
            if(menuNum == 4) {
                break;
            }else if(menuNum == 1) {
                reservation(selectedDay);
            }else if(menuNum == 2) {
                selectedDay.S.showSeats();
                selectedDay.A.showSeats();
                selectedDay.B.showSeats();
                System.out.println("<<<조회를 완료하였습니다.>>>");
            }else if(menuNum == 3) {
                cancelation(selectedDay);
            }else {
                System.out.println("입력을 확인해주십시오.");
                continue;
            }
            
        }
        
    }

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        reservationSystem.run();
    }
}
