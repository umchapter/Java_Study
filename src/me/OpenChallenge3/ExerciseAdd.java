package me.OpenChallenge3;


// args 받아서 정수합만 출력하는 파일
public class ExerciseAdd {
    
    public static void main(String[] args) {
        
        int sum = 0;

        for(String str : args) {
            try {
                sum += Integer.parseInt(str);
            }
            catch (NumberFormatException ex) {
                continue;
            }
        }

        System.out.println(sum);
    }
}
