package me.cahpter3;

public class CheckTime {
    
    public static void main(String[] args) {
        
        for(int i=5; i>0; i--) {
            System.out.println("*".repeat(i));
        }
        
        int i = 5;
        while(i>0) {
            System.out.println("*".repeat(i));
            i--;
        }

        int j = 5;
        do {
            System.out.println("*".repeat(j));
            j--;
        } while(j>0);

        // for(;;); //// 무한반복

        int sum = 0;
        for(int k=1; k<101; k++) {
            if(k%3==0) {
                sum += k;
            } else {
                continue;
            }
        }
        System.out.println(sum);

        int[] tenArray = new int[10];
        System.out.println(tenArray.length);

        for(int l=0; l<10; l++) {
            tenArray[l] = l+1;
        }
        int sum2 = 0;
        for(int m : tenArray) {
            sum2 += m;
        }
        System.out.println(sum2);
    }
}