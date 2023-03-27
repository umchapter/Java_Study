package me.cahpter3;

import java.util.Scanner;

public class ArrayAccess {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int[] intArray = new int[5];
        int largest = -99999999;

        System.out.println("정수 다섯개를 입력해주세요");

        for(int cnt=0; cnt<5; cnt++) {
            System.out.print(">>");
            int input = scanner.nextInt();

            intArray[cnt] = input;
            if(input > largest) {
                largest = input;
            } else {
                continue;
            }
        }

        System.out.println("가장 큰 수는 " + largest + "입니다");

        scanner.close();
    }
}
