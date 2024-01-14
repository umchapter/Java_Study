package me.OpenChallenge7;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Word {
    private String eng;
    private String kor;

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    public String getEng() {
        return this.eng;
    }

    public String getKor() {
        return this.kor;
    }
}


public class WordQuiz {
    Vector<Word> v;
    Random random;
    Scanner scanner;

    public WordQuiz() {
        v = new Vector<>();
        random = new Random();
        scanner = new Scanner(System.in);

        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("painting", "그림"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("society", "사회"));
        v.add(new Word("emotion", "감정"));
        v.add(new Word("baby", "아기"));
        v.add(new Word("error", "오류"));
        v.add(new Word("doll", "인형"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("photograph", "사진"));
        v.add(new Word("human", "인간"));
        v.add(new Word("statue", "조각상"));
    }

    private int[] makeAnExampleList() {
        int[] exampleList = this.random.ints(0, this.v.size())
                                .distinct()
                                .limit(4)
                                .toArray();
        return exampleList;
    }

    private int chooseAnswer(int[] exampleList) {
        int randomInt = this.random.nextInt(exampleList.length);
        return exampleList[randomInt];
    }

    private String makeAQuestionString(int[] exampleList) {
        String questionString = "";

        for (int i = 0; i < exampleList.length; i++) {
            String kor = this.v.get(exampleList[i]).getKor();
            questionString += String.format("(%d)%s ", i + 1, kor);
        }

        questionString += ":>";

        return questionString;
    }

    private void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + this.v.size() + "개의 단어가 들어 있습니다.");

        while (true) {
            int[] exampleList = this.makeAnExampleList();
            int answerNumber = this.chooseAnswer(exampleList);
            String question = v.get(answerNumber).getEng();

            System.out.println(question + "?");
            System.out.print(this.makeAQuestionString(exampleList));

            int inputInt = this.scanner.nextInt();

            if (inputInt == -1) {
                System.out.println("\"명품영어\"를 종료합니다...");
                scanner.close();
                break;
            }

            if (inputInt - 1 < 0 || inputInt - 1 >= exampleList.length) {
                System.out.println("입력 오류입니다!");
                continue;
            }

            if (this.v.get(exampleList[inputInt - 1]).getEng().equals(question)) {
                System.out.println("Excellent !!");
                continue;
            } else {
                System.out.println("No. !!");
                continue;
            }   
        }
    }

    public static void main(String[] args) {
        WordQuiz wordQuiz = new WordQuiz();
        wordQuiz.run();
    }

}
