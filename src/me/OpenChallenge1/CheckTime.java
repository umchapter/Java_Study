package me.OpenChallenge1;

public class CheckTime {
    public static void main(String[] args) {
        int x = 2, y = 10, z = 0;
        z = x++*2+--y-5+x*(y%2);
        /* postfix와 prefix를 고려
         * x++*2 = 4, x -> 3
         * y -> 9
         * 4 + 9 - 5 + 3(1) = 11
         */
        System.out.println(z);
    }
}
