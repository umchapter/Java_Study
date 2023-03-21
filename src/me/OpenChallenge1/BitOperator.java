package me.OpenChallenge1;

public class BitOperator {
    public static void main(String[] args) {
        short a = (short)0x55ff;
        short b = (short)0x00ff;
        // 비트 논리 연산
        System.out.println("[비트 연산 결과]");
        System.out.printf("%04x\n", (short)(a & b)); // 공통 부분인 ff만 남음
        System.out.printf("%04x\n", (short)(a | b)); // 하나라도 1이면 -> 55ff
        System.out.printf("%04x\n", (short)(a ^ b)); // XOR 서로 다를 때 -> 5500
        System.out.printf("%04x\n", (short)(~a)); // a의 비트 바꿈 -> 더해서 15 되는 값으로 치환

        byte c = 20; //0x14
        byte d = -8; //0xf8
        // 비트 시프트 연산
        System.out.println(c << 2); // c를 2비트 왼쪽 시프트 x4.
        System.out.println(c >> 2); // c를 2비트 오른쪽 시프트 /4. 0삽입
        System.out.println(d >> 2); // d를 2비트 오른쪽 시프트. /4 1삽입(음수)
        System.out.printf("%x\n", (d >>> 2));
        /* d를 2비트 오른쪽 시프트. 0삽입. 
         * 시프트 연산 전에 int 타입으로 바뀌어 32비트(2^32 = 16^8)의 
         * fffffff8(1111 1111 1111 1111 1111 1111 1111 1000 : -8)이 됨. 
         * 그이후 >>> 연산이 이루어지면 0이 두 번 삽입되어 3ffffffe (0011 1111 1111 1111 1111 1111 1111 1110 : 1073741822)
         */
    }
}
