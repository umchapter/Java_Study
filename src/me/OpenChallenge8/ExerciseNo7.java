package me.OpenChallenge8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExerciseNo7 {
    public static void main(String[] args) {
        File a = new File("./src/me/OpenChallenge8/a.jpg");
        File b = new File("./src/me/OpenChallenge8/b.jpg");
        long size = a.length();
        System.out.println("a.jpg를 b.jpg로 복사합니다.");
        System.out.println("10%마다 *를 출력합니다.");
        try {
            FileInputStream fi = new FileInputStream(a); // 파일 입력 바이트 스트림 생성
            FileOutputStream fo = new FileOutputStream(b); // 파일 출력 바이트 스트림 생성
            byte[] buf = new byte[1024]; // 1KB 버퍼 -> 추가
            int total = size % buf.length == 0 ? (int)size / buf.length : (int)(size / buf.length) + 1;
            int count = 1;
            while(true) {
                int n = fi.read(buf); // 버퍼 크기만큼 읽기
                if (n == -1) { // 파일 끝에 도달
                    System.out.print("*\r\n");
                    break;
                }
                fo.write(buf, 0, n); // buf[0]부터 n 바이트 쓰기
                if(n < buf.length) {
                    System.out.print("*\r\n");
                    break; // 버퍼 크기보다 작게 읽었기 때문에 파일 끝에 도달. 복사 종료
                }
                if(count > (double)total/10) {
                    System.out.print('*');
                    count = 1;
                } else {
                    count += 1;
                }
            }
            fi.close();
            fo.close();
        } catch (IOException e) {
            System.err.println("파일 복사 오류");
        }
    }
}
