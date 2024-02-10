package me.OpenChallenge8;

import java.io.File;

public class ExerciseNo9 {
    public static void main(String[] args) {
        File[] files = new File("c:/temp").listFiles();
        System.out.println("c:\\temp 디렉터리의 .txt 파일을 모두 삭제합니다...");
        int count = 0;
        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getAbsolutePath() + "삭제");
                file.delete();
                count ++;
            }
        }
        System.out.println("총 " + count + "개의 .txt 파일을 삭제하였습니다.");
    }
}
