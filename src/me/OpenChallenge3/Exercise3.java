package me.OpenChallenge3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Exercise3 {
    public static void main(String[] args) {
        // 1. 반복문 연습
        // int sum = 0, i = 1;
        // for(int i=0; i>10; i++) sum++; // i>10 조건에서 즉시 벗어나므로 sum = 0
        // for(int i=0; i<10; sum+=1, i++); // 반복 결과 두 개 이상 넣을 수 있음

        // while(true) {
        //     if(i > 50) {
        //         break;
        //     }
            
        //     sum += i;
        //     i++;
        //     }
        
        // System.out.println(sum);
        
        // 2. 배열 연습
        // boolean[] boolArray = {true, false, false, true};

        // int[][] intArray = new int[4][3];
        // for(int i=0; i<intArray.length; i++) {
        //     for(int j=0; j<intArray[i].length; j++){
        //         intArray[i][j] = (i*3) + (j+1);
        //     }
        //     System.out.println(Arrays.toString(intArray[i]));
        // }


        // int sum=0, i=0;
        // do {
        //     sum += i;
        //     i += 2; 
        // } while(i<100);
        // System.out.println(sum);

        // 3. scanner 활용 영어 소문자 출력
        // Scanner scanner = new Scanner(System.in);

        // System.out.print("소문자 알파벳 하나를 입력하시오>>");
        // String inputStr = scanner.next(); // 문자열 읽기
        // char chr = inputStr.charAt(0);
        // scanner.close();

        // for(;0<=(chr-'a'); chr--) {
        //     for(char a ='a'; a<=chr; a++) {
        //         System.out.print(a);
        //     }
        //     System.out.println();
        // }
        
        // 4. 1~10 범위의 정수 10개 랜덤 생성 & 배열의 평균
        // int[] intArray = new int[10];

        // for(int i=0; i<intArray.length; i++) {
        //     intArray[i] = (int)(Math.random()*10 + 1);
        //     System.out.print(intArray[i] + " ");
        // }System.out.println();
        
        // float avg = ((float)IntStream.of(intArray).sum() / (float)intArray.length);

        // System.out.println(avg);

        // 5. 정수의 저장 개수 입력받아(1~99) 정수배열 생성. 랜덤한 정수 삽입. 배열에 같은 수가 없게하고 배열 출력
        // Scanner scanner = new Scanner(System.in);

        // System.out.print("정수 몇개?(1~99)>>");
        // int inputRange = scanner.nextInt();

        // int[] intArray = new int[inputRange];
        // int i=0;
        // while(i<inputRange) {
        //     int randInt = (int)(Math.random()*100 + 1);

        //     if(Arrays.asList(intArray).contains(randInt)) {
        //         continue;
        //     }
        //     else {
        //         intArray[i] = randInt;
        //         i++;
        //     }
        // }
        // for(int j : intArray) {
        //     System.out.print(j + " ");
        // }
        // scanner.close();

        // 6. 4x4 배열 만들고 1~10 범위의 정수 10개를 중복을 허용하여 랜덤 생성하고 임의의 위치에 삽입. 나머지 0.
        // int[][] intMatrix = new int[4][4];
        // int cnt = 0;
        
        // while(cnt<10) {
        //     int randVal = (int)(Math.random()*10 + 1);
        //     int randRow = (int)(Math.random()*10 + 1) % 4;
        //     int randCol = (int)(Math.random()*10 + 1) % 4;

        //     if(intMatrix[randRow][randCol] == 0) {
        //         intMatrix[randRow][randCol] = randVal;
        //         cnt += 1;
        //     }
        //     else {
        //         continue;
        //     }

        // }


        // for(int[] i : intMatrix) {
        //     for(int j : i) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // 7. 369 박수치기
        // int i = 1;

        // while(i<100) {
        //     int clap = 0;
        //     int tenthDigit = i / 10;
        //     int unitsDigit = i % 10;

        //     if((tenthDigit != 0) & (tenthDigit % 3) == 0) {
        //         clap +=1;
        //     }
        //     if((unitsDigit != 0) & (unitsDigit % 3) == 0) {
        //         clap += 1;
        //     }
        //     if(clap>0) {
        //     System.out.println(i + " 박수 " + "짝".repeat(clap));
        //     }
                              
        //     i++;
        // }

        // or 스트링 형식으로 이중 반복. 뭐가 더 빠른지는 모르겠음
        int i = 1;

        while(i<100) {
            int clap = 0;
            String callNum = String.valueOf(i);

            for(int j = 0; j<callNum.length(); j++) {
                char chr = callNum.charAt(j);
                if((chr == '3') | (chr == '6') | (chr == '9')) {
                    clap++;
                }                
            }

            if(clap>0) {
                System.out.println(i + " 박수 " + "짝".repeat(clap));
                }
                                
            i++;
        }


    }
    
    
}
