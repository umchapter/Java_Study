package me.OpenChallenge8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExerciseNo1 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fout = null;
        String file = "c:\\Temp\\phone.txt";

        try {
            fout = new FileWriter(file); // 파일과 연결된 출력 문자 스트림 생성
            System.out.println("전화번호 입력 프로그램입니다.");
            while (true) {
                System.out.print("이름 전화번호 >> ");
                String line = scanner.nextLine(); // 빈칸을 포함하여 한 줄 읽기. line에는 '\n'이 들어가지 않음

                if (line.equals("그만")) { // "그만"이라고 입력한 경우
                    System.out.println(file + "에 저장하였습니다.");
                    break;
                }
                
                fout.write(line, 0, line.length()); // 읽은 문자열을 파일에 저장
                fout.write("\r\n", 0, 2); // 한 줄 띄기 위해 \r\n을 파일에 저장
                //fout.write(line); fout.write("\r\n"); 과 동일
            }
            fout.close();
        } catch (IOException e) {
            System.err.println("입출력 오류");
        }
        scanner.close();
    }
}
