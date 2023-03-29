package me.cahpter3;

public class SkewedArray {
    
    public static void main(String[] args) {
        int[][] intArray = new int[4][]; // 각 행의 레퍼런스 배열 생성
        intArray[0] = new int[3]; // 첫번째 행은 정수 3개의 배열
        intArray[1] = new int[2];
        intArray[2] = new int[3];
        intArray[3] = new int[2]; // 네번째 행은 정수 2개의 배열

        for(int i=0; i<intArray.length; i++) {
            for(int j=0; j<intArray[i].length; j++) {
                intArray[i][j] = (i+1)*10 + j;
            }
        }

        for(int i=0; i<intArray.length; i++) {
            for(int j=0; j<intArray[i].length; j++) {
                System.out.print(intArray[i][j] + " "); // 배열의 요소 출력
            }
            System.out.println(); // 다음줄로 넘어감
        }
    }
}
