package me.cahpter3;

import java.util.Random;
import java.util.Scanner;

public class ArrayLength {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Random randInt = new Random();

        int rNum = randInt.nextInt(10);
        while(rNum <2) {
            rNum = randInt.nextInt(10);
        }

        int[] intArray = new int[rNum];

        int sum = 0;

        System.out.printf("%d개의 정수를 입력해주세요>>", rNum);

        for(int i=0; i<rNum; i++) {
            int inputInt = scanner.nextInt();
            intArray[i] = inputInt;
            sum += inputInt;
        }
        System.out.printf("%d개 정수의 평균은 %.2f입니다.", rNum, ((float)sum/(float)rNum));
        // or sum/intArray.length

        scanner.close();
    }
}
