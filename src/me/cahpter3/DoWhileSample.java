package me.cahpter3;

public class DoWhileSample {
    
    public static void main(String[] args) {
        char base = 'a';

        do { // do-while 문의 경우, do는 while문에 들어가기 전에 무조건 한 번은 실행됨. 실행순서 1
            System.out.print(base);
            base += 1; // char에서 영문의 경우 1을 더하면 다음 문자의 코드 값이 됨. 캐스팅 안해줘도 잘 나옴.
        } while(base < 'z'+1) ; // 실행순서 2 -> 실행하고 조건 검사
    }
}
