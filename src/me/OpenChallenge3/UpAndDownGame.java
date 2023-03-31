package me.OpenChallenge3;

import java.util.Random;
import java.util.Scanner;

public class UpAndDownGame {

    public static void main(String[] args) {
        Random random = new Random();
        int randInt = random.nextInt(100); // 0~99까지 임의의 정수 생성
        Scanner scanner = new Scanner(System.in);
        
        int i = 1;

        
        while(true) {

            if(i == 1) {
                System.out.println("수를 결정하였습니다. 맞추어 보세요.");
                System.out.println("0 ~ 99");
            }

            System.out.print(i+">>");
            int inputInt = scanner.nextInt();
            i++;

            if(randInt == inputInt) {
                System.out.println("맞았습니다.");
                System.out.print("다시하시겠습니까?(y/n)>>");
                String str = scanner.next();
                
                if(str.equals("y")) {
                    randInt = random.nextInt(100);
                    i = 1;
                    continue;
                }
                else {
                    break;
                }
            }
            else if(randInt > inputInt) {
                System.out.println("Up");
                continue;
            } else {
                System.out.println("Down"); 
                continue;
            }
        }
        scanner.close();
    }
    
}
