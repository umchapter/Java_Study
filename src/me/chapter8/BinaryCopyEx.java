package me.chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Windows\\img0.jpg"); // 원본 파일 경로명
        File dest = new File("c:\\Temp\\copyimg.jpg"); // 복사 파일 경로명

        int c;
        try {
            FileInputStream fi = new FileInputStream(src); // 파일 입력 바이트 스트림 생성
            FileOutputStream fo = new FileOutputStream(dest); // 파일 출력 바이트 스트림 생성

            while((c = fi.read()) != -1) {
                fo.write((byte)c);
            }
            fi.close();
            fo.close();
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사했습니다.");
        } catch (IOException e) {
            System.err.println("파일 복사 오류");
        }
    }
}
