package me.OpenChallenge4;

import java.util.Arrays;

class ArrayUtil {
    
    public static int[] concat(int[] a, int[] b) {
        /* 배열 a와 b를 연결한 새로운 배열 리턴 */

        int newLength = a.length + b.length;

        int[] resultArray = new int[newLength];

        System.arraycopy(a, 0, resultArray, 0, a.length);
        System.arraycopy(b, 0, resultArray, a.length, b.length);

        return resultArray;
    }

    public static void print(int[] a) {
        /* 배열 a 출력 */

        System.out.println(Arrays.toString(a));
    }
}

public class StaticEx {
    
    public static void main(String[] args) {
        int[] array1 = { 1, 5, 7, 9 };
        int[] array2 = { 3, 6,-1, 100, 77 };
        int[] array3 = ArrayUtil.concat(array1, array2);  
        ArrayUtil.print(array3);
    }
}
