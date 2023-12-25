package me.OpenChallenge6;

import java.util.Scanner;

class RSP {
    private String interpret(int rsp) {
        switch (rsp) {
            case 1:
                return "가위";
            case 2:
                return "바위";
            case 3:
                return "보";
            default :
                return "잘못된 입력입니다.";
        }
    }

    private String judge(int player, int computer) {
        if (player == computer) {
            return "비겼습니다.";
        } else if (player == 3 && computer == 1) {
            return "컴퓨터가 이겼습니다.";
        } else if (player == 1 && computer == 3) {
            return "철수가 이겼습니다.";
        } else if (player < computer) {
            return "컴퓨터가 이겼습니다.";
        } else {
            return "철수가 이겼습니다.";
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>> ");
            int player = scanner.nextInt();
            if (player == 4) {
                scanner.close();
                break;
            }
            int computer = (int)(Math.random()*3 + 1);
            String interpreted = String.format("철수(%s) : 컴퓨터(%s)", interpret(player), interpret(computer));
            System.out.println(interpreted);
            System.out.println(judge(player, computer));
        }
    }
}

public class ExerciseNo7 {
    public static void main(String[] args) {
        RSP rsp = new RSP();
        rsp.run();
    }
}
