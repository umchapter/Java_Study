package me.OpenChallenge6;

import java.util.Scanner;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Gamble {
    Person player1;
    Person player2;
    Scanner scanner;

    public Gamble() {
        this.scanner = new Scanner(System.in);
        System.out.print("첫번째 선수 이름>> ");
        this.player1 = new Person(this.scanner.nextLine());

        System.out.print("두번째 선수 이름>> ");
        this.player2 = new Person(this.scanner.nextLine());
    }

    private Person switchPlayer(Person currentPlayer) {
        if (currentPlayer.equals(this.player1)) {
            return this.player2;
        } else {
            return this.player1;
        }
    }

    private int[] role() {
        int[] diceList = new int[3];
        for (int i=0; i < 3; i++) {
            diceList[i] = (int)(Math.random()*3 + 1);
        }
        return diceList;
    }

    private boolean judge(int[] diceList) {
        if (diceList[0] == diceList[1] && diceList[0] == diceList[2]) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        while (true) {
            Person currentPlayer = player1;
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
                this.switchPlayer(currentPlayer);
            }
        }
    }
}

public class ExerciseNo8 {
    public static void main(String[] args) {
        Gamble gamble = new Gamble();
        gamble.run();
    }
}
