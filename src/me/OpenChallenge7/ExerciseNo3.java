package me.OpenChallenge7;

import java.util.HashMap;
import java.util.Scanner;

public class ExerciseNo3 {
    HashMap<String, Integer> nations;
    Scanner scanner;

    public ExerciseNo3() {
        nations = new HashMap<>();
        scanner = new Scanner(System.in);

        this.insertNations();
    }

    private void insertNations() {
        System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");

        while (true) {
            System.out.print("나라 이름, 인구 >> ");
            String stringInput = this.scanner.nextLine();

            if (stringInput.equals("그만")) {
                break;
            }
            
            String[] splittedStrings = stringInput.split(" ");
            String nation = splittedStrings[0];
            Integer population = Integer.valueOf(splittedStrings[1]);

            this.nations.put(nation, population);
        }
    }

    private void getPopulation() {
        while (true) {
            System.out.print("인구 검색 >>");
            String nation = this.scanner.nextLine();

            if (nation.equals("그만")) {
                this.scanner.close();
                break;
            }

            if (this.nations.get(nation) == null) {
                System.out.println(nation + " 나라는 없습니다.");
            } else {
                System.out.println(nation + "의 인구는 " + this.nations.get(nation));
            }
        }
    }
    public static void main(String[] args) {
        ExerciseNo3 ex = new ExerciseNo3();
        ex.getPopulation();        
    }
}
