package me.cahpter3;

public class ReturnArray {
    static int[] makeArray() { // 정수형 배열을 리턴하는 메소드 -> 배열 공간 전체가 아니라 배열에 대한 레퍼런스만 리턴
        int[] temp = new int[4];
        for(int i=0; i<temp.length; i++) {
            temp[i] = i; // 배열의 원소를 0, 1, 2, 3으로 초기화
        }
        return temp; // 배열 리턴 -> makeArray가 수행되고 나면 지역변수인 temp는 사라지지만 temp가 가르키는 배열 메모리는 남음
                    //            -> 이 배열 메모리의 주소를 레퍼런스함
    }

    public static void main(String[] args) {
        int[] intArray = makeArray(); // 메소드로부터 배열을 전달받아 초기화
        for(int i=0; i<intArray.length; i++) {
            System.out.print(intArray[i] + " "); // 배열의 모든 원소 출력
        }
    }
}
