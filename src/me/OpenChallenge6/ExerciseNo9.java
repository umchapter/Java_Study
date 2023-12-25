package me.OpenChallenge6;

import java.util.Scanner;

public class ExerciseNo9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> ");
        StringBuffer targetString = new StringBuffer(scanner.nextLine());

        while (true) {
            System.out.print("명령: ");
            String order = scanner.nextLine();
            if (order.equals("그만")) {
                System.out.println("종료합니다.");
                scanner.close();
                break;
            }

            String[] orderList = order.split("!");
            if (orderList.length != 2 || orderList[0].equals("")) {
                System.out.println("잘못된 명령입니다!");
                continue;
            }

            String target = orderList[0];
            int targetIndex = targetString.indexOf(target, 0);
            if (targetIndex == -1) {
                System.out.println("찾을 수 없습니다!");
                continue;
            }

            String value = orderList[1];
            targetString.replace(targetIndex, targetIndex + target.length(), value);
            System.out.println(targetString);
        }
    }
}
