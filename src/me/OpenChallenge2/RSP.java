package me.OpenChallenge2;

import java.util.Scanner;

public class RSP {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String chulString;
        String youngString;
        String result = "영희가 이겼습니다.";

        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
        System.out.print("철수 >>");
        chulString = scanner.next();
        System.out.print("영희 >>");
        youngString = scanner.next();

        // 중첩 조건문 대신 더 간단히 짜는 법은?
        // String result = "비겼습니다.";
        // if(chulString.equals("가위")) {
        //     if(youngString.equals("보")) {
        //         result = "철수가 이겼습니다.";
        //     }else if(youngString.equals("바위")) {
        //         result = "영희가 이겼습니다.";
        //     } 
        // } else if(chulString.equals("바위")) {
        //     if(youngString.equals("보")) {
        //         result = "영희가 이겼습니다.";
        //     }else if(youngString.equals("가위")) {
        //         result = "철수가 이겼습니다.";
        //     }
        // } else {
        //     if(youngString.equals("바위")) {
        //         result = "철수가 이겼습니다.";
        //     }else if(youngString.equals("가위")) {
        //         result = "영희가 이겼습니다.";
        //     }
        // }

        // 두 명만 게임을 하기 때문에 비기는 경우를 두고 철수의 승리조건만을 조건화 하면 더 짧게 가능
            if(chulString.equals(youngString)) {
                
                result = "비겼습니다.";
            }

            if(((chulString.equals("가위")) & (youngString.equals("보"))) 
             | ((chulString.equals("바위")) & (youngString.equals("가위"))) 
             | ((chulString.equals("보")) & (youngString.equals("바위")))) {
                      
                result = "철수가 이겼습니다.";
            }

        System.out.println(result);
        scanner.close();
    }
}
