package me.chapter8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fout = null;

        try {
            fout = new FileWriter("c:\\Temp\\test.txt"); // 파일과 연결된 출력 문자 스트림 생성
            
            while (true) {
                String line = scanner.nextLine(); // 빈칸을 포함하여 한 줄 읽기. line에는 '\n'이 들어가지 않음
                if (line.length() == 0) { // 한 줄에 <Enter> 키만 입력한 경우
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
