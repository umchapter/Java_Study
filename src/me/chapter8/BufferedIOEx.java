package me.chapter8;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) {
        FileReader fin = null;
        int c;
        try {
            fin = new FileReader("c:\\Temp\\test2.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            // BufferedOutputStream은 바이트 단위로 출력하므로, ANSI 코드(영어는 한 바이트, 한글은 2바이트)의
            // 영문만 출력할 수 있음. 한글까지 출력하려면 아래와 같이 수정
            // new BufferedOutputStream(new OutputStreamWriter(System.out), 5)
            while((c = fin.read()) != -1) { // 파일 데이터를 모두 스크린에 출력
                out.write(c);
            }
            // 파일 데이터가 모두 출력된 상태
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // <Enter> 키 입력
            scanner.close();
            out.flush(); // 버퍼에 남아 있던 문자 모두 출력
            fin.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
