package me.OpenChallenge6;

import java.util.Scanner;

class Gamble2 {
    Person[] playerList;
    Scanner scanner;

    public Gamble2() {
        this.scanner = new Scanner(System.in);
        System.out.print("겜블링 게임에 참여할 선수 숫자>> ");
        int numberOfPlayers = this.scanner.nextInt();
        this.scanner.nextLine();

        playerList = new Person[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print((i + 1) + "번째 선수 이름>> ");
            String name = this.scanner.nextLine();
            playerList[i] = new Person(name);
        }
    }

    private Person switchPlayer(int counter) {
        int remainder = counter % this.playerList.length;
        return this.playerList[remainder];
    }

    private int[] role() {
        int[] diceList = new int[4];
        for (int i=0; i < 4; i++) {
            diceList[i] = (int)(Math.random()*3 + 1);
        }
        return diceList;
    }

    private boolean judge(int[] diceList) {
        if (diceList[0] == diceList[1] && diceList[0] == diceList[2] && diceList[0] == diceList[3]) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        int counter = 0;
        while (true) {
            Person currentPlayer = this.switchPlayer(counter);
            String name = currentPlayer.getName();
            System.out.print("[" + name + "]:<Enter>");
            this.scanner.nextLine();

            int[] diceList = this.role();
            String result = "       ";

            for (int dice : diceList) {
                result += dice + "  ";
            }

            if (this.judge(diceList)) {
                result += name + "님이 이겼습니다!";
                System.out.println(result);
                this.scanner.close();
                break;
            } else {
                result += "아쉽군요!";
                System.out.println(result);
                counter++;
                this.switchPlayer(counter);
            }
        }
    }

}

public class ExerciseNo10 {
    public static void main(String[] args) {
        Gamble2 gamble2 = new Gamble2();
        gamble2.run();
    }
}
