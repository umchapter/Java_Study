package me.OpenChallenge7;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ExerciseNo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v= new Vector<>();

        System.out.print("정수(-1이 입력될 때까지)>>");
        while (true) {
            int intInput = scanner.nextInt();

            if (intInput == -1) {
                break;
            } else {
                v.add(intInput);
            }
        }

        System.out.println("가장 큰 수는 " + Collections.max(v));
        scanner.close();
    }
}
