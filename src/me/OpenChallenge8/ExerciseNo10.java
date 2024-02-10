package me.OpenChallenge8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Scanner;

public class ExerciseNo10 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("./src/me/OpenChallenge8/phone.txt", Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(fr);
        var phoneBook = new HashMap<String, String>();
        try {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] splittedStrings = line.split(" ");
                    phoneBook.put(splittedStrings[0], splittedStrings[1]);
                }
            } 
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("총 " + phoneBook.size() + "개의 전화번호를 읽었습니다.");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("이름>> ");
            String name = scanner.nextLine();
            if (name.equals("그만")) {
                scanner.close();
                break;
            } else {
                String phone = phoneBook.getOrDefault(name, "찾는 이름이 없습니다.");
                System.out.println(phone);
            }
        }
    }
}
