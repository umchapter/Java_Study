package me.OpenChallenge8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Vector;

public class ExerciseNo12 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>> ");
        String fileName = inputReader.readLine();

        while (true) {
            BufferedReader br = new BufferedReader(new FileReader(fileName, Charset.forName("UTF-8")));
            System.out.print("검색할 단어나 문장>> ");
            String inputString = inputReader.readLine();
            if (inputString.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                inputReader.close();
                break;
            } else {
                var stringVector = new Vector<String>();
                int lineCount = 1;
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }

                    if (line.contains(inputString)){
                        stringVector.add(lineCount + ": " + line);
                    }
                    lineCount ++;
                }
                if (stringVector.size() == 0) {
                    System.out.println("검색 결과가 없습니다.");
                } else {
                    for (String line : stringVector) {
                        System.out.println(line);
                    }
                }
            }
            br.close();
        }
    }
}
