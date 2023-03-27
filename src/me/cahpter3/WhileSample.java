package me.cahpter3;

import java.util.Scanner;

public class WhileSample {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        int sum = 0;

        while(true) { // 조건식이 먼저
        System.out.printf("평균을 구하고자 하는 정수를 입력하십시오. 종료하려면 -1을 입력하십시오. (현재 입력된 정수의 갯수 %d) \n", cnt);
        int n = scanner.nextInt();
        //작업문이 나중. do-while과 차이
        if(n == -1) {
            break;
        }

        else {
            cnt++;
            sum += n;
        }
        }
        System.out.printf((cnt==0) ?
                            "입력된 정수가 없습니다." :
                            "입력된 정수의 개수는 %d개 이고 평균은 %.2f입니다.", cnt, ((float)sum/(float)cnt));


        scanner.close();
        
    }
}
