package me.OpenChallenge4;

import java.util.Scanner;

public class Player {
    Scanner scanner;
    String playerName;
    String word;

    public Player(String name) { // 생성자
        this.playerName = name;
        scanner = new Scanner(System.in);
    }

    protected String getName() { // 이름 메소드
        return playerName;
    }

    protected String getWordFromUser() { // 입력 받는 메소드
        System.out.print(playerName + ">>");
        word = scanner.next();
        return word;
    }
   
    protected boolean checkSuccess(String lastWord) { // 결과 확인 메소드
        int lastIndex = lastWord.length() - 1;
        char lastChar = lastWord.charAt(lastIndex);

        return lastChar==word.charAt(0)?true:false;
    }
}
