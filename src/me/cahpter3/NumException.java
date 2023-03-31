package me.cahpter3;

public class NumException {
    
    public static void main(String[] args) {
        String[] stringNumber = {"23", "12", "3.141592", "998"};

        for(int i=0; i<stringNumber.length; i++) {
            try {
                int j = Integer.parseInt(stringNumber[i]);
                System.out.println("정수로 변환된 값은" + j);
            }
            catch(NumberFormatException e) {
                System.out.println(stringNumber[i] + "는 정수로 변환될 수 없습니다.");
                continue;
            }
        }
    }
}
