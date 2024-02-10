package me.OpenChallenge8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class ExerciseNo11 {
    public static void main(String[] args) throws FileNotFoundException {
        var wordVector = new Vector<String>();
        Scanner fileReader = new Scanner(new FileReader("./src/me/OpenChallenge8/words.txt"));
        while(fileReader.hasNext()) { // 파일의 끝까지 반복하여 읽는다.
            String word = fileReader.nextLine(); // 한 라인 단위로 읽는다. word에 '\n'은 없음
            wordVector.add(word); // 단어를 벡터에 저장한다.
        }
        fileReader.close();
        
        System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...");
        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.print("단어>> ");
            String prefix = inputScanner.nextLine();
            var wordList = new ArrayList<String>();
            if (prefix.equals("그만")) {
                System.out.println("종료합니다...");
                inputScanner.close();
                break;
            } else {
                for (String word : wordVector) {
                    if (word.startsWith(prefix)) {
                        wordList.add(word);
                    } else {
                        continue;
                    }
                }
            }
            if (wordList.size() == 0) {
                System.out.println("발견할 수 없음");
            } else {
                for (String word : wordList) {
                    System.out.println(word);
                }
            }
        }

    }
    
}
