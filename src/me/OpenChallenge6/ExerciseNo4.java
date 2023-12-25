package me.OpenChallenge6;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TimeGame {
    String[] participants;
    Map<String, Integer> scoreBoard;
    Scanner scanner;

    public TimeGame() {
        this.scanner = new Scanner(System.in);
        this.participants = new String[2];
        this.scoreBoard = new HashMap<>();

        System.out.println("게임 참가자의 이름을 입력하세요.");
        for (int i = 0; i < 2; i++) {
            System.out.printf("참가자%d >>", i+1);
            String participant = this.scanner.nextLine();
            this.participants[i] = participant;
            this.scoreBoard.put(participant, 0);
        }
        
        System.out.println("참가자 " + this.participants[0] + ", " + this.participants[1]);
    }

    public void game() {
        for (String participant : this.participants) {
            System.out.print(participant + " 시작 <Enter>키 >>");
            this.scanner.nextLine();
            int start = Calendar.getInstance().get(Calendar.SECOND);
            System.out.println("    현재 초 시간 = " + start);

            System.out.print("10초 예상 후 <Enter>키 >>");
            this.scanner.nextLine();
            int end = Calendar.getInstance().get(Calendar.SECOND);
            System.out.println("    현재 초 시간 = " + end);

            int score = end - start > 0 ? end - start : 60 - end + start;
            this.scoreBoard.put(participant, score);
            System.out.println("");
        }
    }

    public void result() {
        int score1 = Math.abs(10 - scoreBoard.get(participants[0]));
        int score2 = Math.abs(10 - scoreBoard.get(participants[1]));

        for (String participant : this.participants) {
            System.out.print(participant + "의 결과 " + this.scoreBoard.get(participant) + ", ");
        }
        String winner = score1 < score2 ? participants[0] : participants[1];
        System.out.print(score1 == score2 ? "무승부" : "승자는 " + winner);
        
        this.scanner.close();
    }

    public void run() {
        
        this.game();
        this.result();
    }
}

public class ExerciseNo4 {
    public static void main(String[] args) {
        TimeGame game = new TimeGame();
        game.run();

        // Scanner scanner = new Scanner(System.in);

        // System.out.println("아무거나 입력");
        // String input = scanner.nextLine();

        // System.out.println(input);
    }
}
