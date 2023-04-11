package me.OpenChallenge4;

import java.util.Scanner;

public class WordGameApp {
    Scanner scanner;
    String startWord = "아버지";
    Player[] players;

    public WordGameApp() { // 생성자
        scanner = new Scanner(System.in);
    }

    private void createPlayers() { // 참가 인원 입력
        System.out.print("게임에 참가하는 인원은 몇명입니까?>>");
        int n = scanner.nextInt();
        players = new Player[n]; // Players 배열 생성

        for(int i=0; i < n; i++) { // 개별 참가자 Players 객체 생성
            System.out.print("참가자의 이름을 입력하세요>>");
            players[i] = new Player(scanner.next());
        }
    }

    public void run() { // 실행 메소드
        System.out.println("끝말잇기 게임을 시작합니다..");
        createPlayers();
        String lastWord = startWord;

        System.out.println("시작하는 단어는 " + lastWord + "입니다.");
        
        int next = 0;

        while(true) {
            String newWord = players[next].getWordFromUser(); // 끝말잇기 입력 받아옴

            if(players[next].checkSuccess(lastWord)) { // 끝말잇기 성공여부 체크
                lastWord = newWord;
                next++;
                next %= players.length;
            } else {
                System.out.print(players[next].getName() + "이(가) 졌습니다.");
                break;
            }
        }

    }

    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();
    }
    
}
