package me.OpenChallenge7;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Nation {
    String country;
    String capital;

    public Nation(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }
}

class CapitalGame {
    Vector<Nation> data;
    Scanner scanner;

    public CapitalGame() {
        data = new Vector<>();
        scanner = new Scanner(System.in);
    }

    private void inputData() {
        int dataSize = this.data.size();
        System.out.println("현재 " + dataSize + "개 나라와 수도가 입력되어 있습니다.");

        while (true) {
            System.out.print("나라와 수도 입력" + (dataSize + 1) + ">> ");
            String inputString = this.scanner.nextLine();

            if (inputString.equals("그만")) {
                break;
            }

            String[] splittedString = inputString.split(" ");
            String country = splittedString[0];
            String capital = splittedString[1];

            Iterator<Nation> nationIterator = this.data.iterator();
            boolean hasNation = false;
            while (nationIterator.hasNext()) {
                Nation nation = nationIterator.next();
                if (nation.country.equals(country)) {
                    System.out.println(country + "는 이미 있습니다!!");
                    hasNation = true;
                    break;
                }
            }
            if (hasNation) {
                continue;
            } else {
                this.data.add(new Nation(country, capital));
                dataSize += 1;
            }
        }
    }

    private void quiz() {
        Random random = new Random();

        while (true) {
            int randInt = random.nextInt(this.data.size());
            Nation nation = this.data.get(randInt);

            System.out.print(nation.country + "의 수도는? ");
            String inputString = this.scanner.nextLine();

            if (inputString.equals("그만")) {
                break;
            }

            if (inputString.equals(nation.capital)) {
                System.out.println("정답!!");
            } else {
                System.out.println("아닙니다!!");
            }
        }
    }

    public void run() {
        System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");

        loop:
        while (true) {
            System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
            int input = this.scanner.nextInt();

            switch (input) {
                case 1:
                    this.scanner.nextLine();
                    this.inputData();
                    break;
                case 2:
                    this.scanner.nextLine();
                    this.quiz();
                    break;
                case 3:
                    System.out.println("게임을 종료합니다.");
                    this.scanner.close();
                    break loop;
                default:
                    System.out.println("입력을 확인하세요.");
                    break;
            }
        }
    }
}

public class ExerciseNo10 {
    public static void main(String[] args) {
        CapitalGame game = new CapitalGame();
        game.run();
    }
}
