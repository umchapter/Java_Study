package me.cahpter3;
import java.util.Scanner;

public class BreakExample {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("exit를 입력하면 종료합니다.");
        
        while(true) {
            System.out.print(">>");
            String input = scanner.nextLine();
            if(input.equals("exit")) {
                break;
            }
        }
        
        System.out.println("종료합니다.");

        scanner.close();
    }
}
