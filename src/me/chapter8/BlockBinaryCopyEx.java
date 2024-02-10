package me.chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Windows\\img0.jpg"); // 원본 파일 경로명
        File dest = new File("c:\\Temp\\block_copy.jpg"); // 복사 파일 경로명

        try {
            FileInputStream fi = new FileInputStream(src); // 파일 입력 바이트 스트림 생성
            FileOutputStream fo = new FileOutputStream(dest); // 파일 출력 바이트 스트림 생성
            byte[] buf = new byte[1024*10]; // 10KB 버퍼 -> 추가
            while(true) {
                int n = fi.read(buf); // 버퍼 크기만큼 읽기
                fo.write(buf, 0, n); // buf[0]부터 n 바이트 쓰기
                if(n < buf.length) {
                    break; // 버퍼 크기보다 작게 읽었기 때문에 파일 끝에 도달. 복사 종료
                }
            }
            fi.close();
            fo.close();
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사했습니다.");
        } catch (IOException e) {
            System.err.println("파일 복사 오류");
        }
    }
}
