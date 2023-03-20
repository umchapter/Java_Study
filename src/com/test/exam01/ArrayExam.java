package com.test.exam01;

import java.util.Arrays;

public class ArrayExam {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        /* new : 메모리를 할당시켜서 객체를 생성하는 예약어.
                 그 객체가 위치한 주소를 할당.
         */
        for(int i=0; i<a.length; i++) System.out.print(a[i] + " ");
        System.out.println("\n");
        for(int i: a) System.out.print(i + " ");
        System.out.println("\n");
        System.out.println(Arrays.toString(a));
        
        int[][] b = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("b[0][2] = " + b[0][2]);
        System.out.println("b[1][2] = " + b[1][2]);
        System.out.println("b[2][0] = " + b[2][0]);
        for(int i=0; i<b.length; i++) System.out.println(Arrays.toString(b[i]));
        
        float[] m = new float[]{0.2f, 1/4f, 0.5f};
        for(float q : m)
            System.out.print(q + " ");
    
    }
}
