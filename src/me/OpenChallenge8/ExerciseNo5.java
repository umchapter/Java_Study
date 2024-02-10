package me.OpenChallenge8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExerciseNo5 {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("첫번째 파일 이름을 입력하세요>> ");
        String firstFile = inputReader.readLine();
        System.out.print("두번째 파일 이름을 입력하세요>> ");
        String secondFile = inputReader.readLine();
        inputReader.close();

        BufferedReader br1 = new BufferedReader(new FileReader(firstFile));
        BufferedReader br2 = new BufferedReader(new FileReader(secondFile));

        System.out.println(firstFile + "와 " + secondFile + "를 비교합니다.");
        while (true) {
            if (!br1.readLine().equals(br2.readLine())) {
                System.out.println("파일이 서로 다릅니다.");
                break;
            } else if (br1.readLine() == null || br2.readLine() == null){
                System.out.println("파일이 같습니다.");
                break;
            } else {
                continue;
            }
        }
        br1.close(); br2.close();
    }
}
