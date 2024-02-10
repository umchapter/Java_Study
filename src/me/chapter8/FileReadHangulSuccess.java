package me.chapter8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangulSuccess {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("c:\\Temp\\hangul.txt");
            in = new InputStreamReader(fin, "UTF-8"); // 올바른 문자 집합 지정
            int c;

            System.out.println("인코딩 문자 집합은 " + in.getEncoding()); // 문자 집합 이름 리턴
            while((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            in.close();
            fin.close();
        } catch (IOException e) {
            System.err.println("입출력 오류");
        }
    }
}
