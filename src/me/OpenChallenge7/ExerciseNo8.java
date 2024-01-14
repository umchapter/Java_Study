package me.OpenChallenge7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class PointManagement {
    HashMap<String, Integer> data;
    Scanner scanner;

    public PointManagement() {
        this.data = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("** 포인트 관리 프로그램입니다 **");
        while (true) {
            System.out.print("이름과 포인트 입력>> ");
            String inputString = this.scanner.nextLine();

            if (inputString.equals("그만")) {
                System.out.println("종료합니다...");
                this.scanner.close();
                break;
            }

            String[] splittedInput = inputString.split(" ");
            String name = splittedInput[0];
            Integer point;
            try {
                point = Integer.parseInt(splittedInput[1]);
            } catch (NumberFormatException e) {
                System.err.println("입력을 확인하세요.");
                continue;
            }

            Integer oldPoint = this.data.get(name);

            if (oldPoint != null) {
                this.data.put(name, oldPoint + point);
            } else {
                this.data.put(name, point);
            }

            Iterator<String> keyIterator = this.data.keySet().iterator();
            
            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                Integer value = this.data.get(key);
                
                System.out.print(String.format("(%s,%d)", key, value));
            }
            System.out.print("\n");
        }
    }
}

public class ExerciseNo8 {
    public static void main(String[] args) {
        PointManagement pm = new PointManagement();
        pm.run();
    }
}
