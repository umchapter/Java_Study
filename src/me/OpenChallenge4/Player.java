package me.OpenChallenge4;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner scanner;
    String playerName;
    String word;
    ArrayList<Long> timeInterval = new ArrayList<Long>();

    public Player(String name) { // 생성자
        this.playerName = name;
        scanner = new Scanner(System.in);
    }

    protected String getName() { // 이름 메소드
        return playerName;
    }

    protected String getWordFromUser() { // 입력 받는 메소드
        Instant start = Instant.now();
        System.out.print(playerName + ">>");
        word = scanner.next();
        Instant finish = Instant.now();
        timeInterval.add(Duration.between(start, finish).toMillis());
        return word;
    }

    protected long getAverageInputInterval() {
            long sum = 0;
            for(Long i : timeInterval) {
                sum += i;
            }
        return sum / timeInterval.size();
    }
   
    protected boolean checkSuccess(String lastWord) { // 결과 확인 메소드
        int lastIndex = lastWord.length() - 1;
        char lastChar = lastWord.charAt(lastIndex);

        return lastChar==word.charAt(0)?true:false;
    }
}
