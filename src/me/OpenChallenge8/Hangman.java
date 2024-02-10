package me.OpenChallenge8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Hangman {
    Vector<String> wordVector;
    Scanner fileReader;
    Scanner inputScanner;
    Random random;

    String word;
    Integer[] indexes;
    HashMap<String, Vector<Integer>> answerMap;
    String quiz;
    int counter;

    public Hangman() throws FileNotFoundException {
        this.wordVector = new Vector<>();
        this.random = new Random();
        this.fileReader = new Scanner(new FileReader("./src/me/OpenChallenge8/words.txt"));
        while(fileReader.hasNext()) { // 파일의 끝까지 반복하여 읽는다.
            String word = fileReader.nextLine(); // 한 라인 단위로 읽는다. word에 '\n'은 없음
            wordVector.add(word); // 단어를 벡터에 저장한다.
        }
        this.fileReader.close();
        this.inputScanner = new Scanner(System.in);
    }

    private void pickAWord() {
        int index = this.random.nextInt(this.wordVector.size());
        this.word = this.wordVector.get(index);
    }

    private void pickIndexes() {
        Set<Integer> indexSet = new HashSet<>();
        while(true) {
            if(indexSet.size() == 2) {
                break;
            }
            int index = this.random.nextInt(this.word.length());
            indexSet.add(index);
        }
        Integer[] result = indexSet.toArray(new Integer[2]);
        Arrays.sort(result);
        this.indexes = result;
    }

    private void makeQuiz() {
        String quiz = this.word;
        for(Integer index : this.indexes) {
            quiz = quiz.substring(0, index) + "-" + quiz.substring(index + 1);
        }
        this.quiz = quiz;
    }

    private void makeAnswerMap() {
        this.answerMap = new HashMap<>();
        for(Integer index : this.indexes) {
            String key = String.valueOf(this.word.charAt(index));
            Vector<Integer> value = this.answerMap.getOrDefault(key, new Vector<>());
            value.add(index);
            this.answerMap.put(key, value);
        }
    }

    private void checkAnswer(String input) {
        Vector<Integer> indexes = this.answerMap.get(input);
        if (indexes != null) {
            for (int index : indexes) {
                this.quiz = this.quiz.substring(0, index) + input + this.quiz.substring(index + 1);
            }
            this.answerMap.remove(input);
        } else {
            this.counter ++;
        }
    }

    private void init() {
        this.pickAWord();
        this.pickIndexes();
        this.makeQuiz();
        this.makeAnswerMap();
        this.counter = 0;
    }

    private void game() {
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        while(true) {
            this.init();
            
            while (this.answerMap.size() > 0) {
                if (this.counter >= 5) {
                    System.out.println("5번 실패하였습니다.");
                    break;
                }
                System.out.println(this.quiz);
                System.out.print(">> ");
                String input = this.inputScanner.next();
                checkAnswer(input);
            }

            System.out.println(this.word);
            System.out.print("Play again(y/n)?>> ");
            String next = this.inputScanner.next();
            
            if (next.equals("n")) {
                System.out.println("게임을 종료합니다...");
                this.inputScanner.close();
                break;
            }
        }
    }

    public void run() {
        this.game();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Hangman hangman = new Hangman();
        hangman.run();
    }
}
