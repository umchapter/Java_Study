package me.OpenChallenge8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExerciseNo6 {
    public static void main(String[] args) throws IOException{
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("첫번째 파일 이름을 입력하세요>> ");
        String firstFile = inputReader.readLine();
        System.out.print("두번째 파일 이름을 입력하세요>> ");
        String secondFile = inputReader.readLine();
        inputReader.close();

        BufferedReader br1 = new BufferedReader(new FileReader(firstFile));
        BufferedReader br2 = new BufferedReader(new FileReader(secondFile));
        FileWriter fw = new FileWriter("./src/me/OpenChallenge8/appended.txt", true);

        for (BufferedReader br : new BufferedReader[]{br1, br2}) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                else fw.write(line); fw.write("\r\n");
            }
            br.close();
        }
        System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
        fw.close();
    }
}
