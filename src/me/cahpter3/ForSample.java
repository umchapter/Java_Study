package me.cahpter3;

public class ForSample {
    
    public static void main(String[] args) {
        
        int result = 0;

        for(int i=1; i<11; i++) { // for(초기문 1 ; 조건식 2 ; 반복후 작업 4) { 작업문 3 } (숫자는 실행 순서)
            result += i;
            System.out.print(i); // 더하는 수 출력
            if(i<10) { // 9까지는 + 출력
                System.out.print("+");
            } else { // i=10 이면
                System.out.print("="); // = 출력하고
                System.out.print(result); // 합계 출력
            }
        }
        
    }
}
