package me.OpenChallenge7;

import java.util.Scanner;
import java.util.Vector;

public class ExerciseNo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();

        while (true) {
            System.out.print("강수량 입력 (0 입력시 종료)>> ");
            int intInput = scanner.nextInt();

            if (intInput == 0) {
                break;
            }

            v.add(intInput);

            String output = "";
            int sum = 0;
            for (int element : v) {
                output += element + " ";
                sum += element;
                System.out.println(output);
                System.out.println("현재 평균 " + sum / v.size());
            }
        }
        
        scanner.close();
    }
}
