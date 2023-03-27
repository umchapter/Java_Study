package me.cahpter3;

public class NestedLoop {
    
    public static void main(String[] args) { // 세로로 한단
        for(int i=1; i<10; i++) {
            for(int j=1; j<10; j++) {
                System.out.printf("%d * %d = %d \t", j, i, i*j);
            }
            System.out.println();
        }
    }
}
