package me.OpenChallenge6;

import java.util.Scanner;
import java.util.StringTokenizer;

class WordCounter {
    String machine;
    Scanner scanner;

    public WordCounter(String machine) {
        this.machine = machine;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print(">> ");
            String input = this.scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("종료합니다...");
                scanner.close();
                break;
            }

            int count;
            if (this.machine.equals("tokenizer")) {
                StringTokenizer st = new StringTokenizer(input, " ");
                count = st.countTokens();
            } else {
                count = input.split(" ").length;
            }

            System.out.println("어절 개수는 " + count);
        }
    }
}

public class ExerciseNo5 {
    public static void main(String[] args) {
        WordCounter wc = new WordCounter("split");
        wc.run();
    }
}
