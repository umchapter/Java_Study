package me.chapter7;

public class GenericMethodEx {
    // 타입 매개변수는 메소드의 리턴 타입 앞에 선언됨
    public static <T> GStack<T> reverse(GStack<T> a) { // T가 타입 매개변수인 제네릭 메소드
        GStack<T> s = new GStack<>(); // 스택 a를 반대로 저장할 목적 GStack 생성
        while(true) {
            T tmp;
            tmp = a.pop(); // 원래 스택에서 요소 하나를 꺼냄

            if (tmp == null) { // 스택이 비었음
                break;
            } else {
                s.push(tmp); // 새 스택에 요소를 삽입
            }
        }
        return s; // 새 스택을 리턴
    }

    public static void main(String[] args) {
        GStack<Double> gs = new GStack<>();

        for (int i = 0; i < 5; i++) { // 5개의 요소를 스택에 push
            gs.push(Double.valueOf(i));
        }
        // stack 순서는 0, 1, 2, 3, 4 -> pop()은 역순

        gs = reverse(gs); // 컴파일러는 제네릭 메소드 reverse()의 타입 매개변수를 Double로 유추
        for (int i = 0; i < 5; i++) {
            System.out.println(gs.pop());
        }
        // stack 순서를 뒤집었기 때문에 4, 3, 2, 1, 0
    }
}
