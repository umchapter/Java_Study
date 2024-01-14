package me.chapter7;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(); // 정수 값만 다루는 벡터 생성
        v.add(5);
        v.add(4);
        v.add(-1);

        // 벡터 중간에 삽입
        v.add(2, 100); // 4와 -1 사이에 정수 100 삽입

        System.out.println("벡터 내의 요소 객체 수 : " + v.size());
        System.out.println("벡터의 현재 용량 : " + v.capacity()); // 벡터 용량 10

        // Iterator를 이용한 모든 정수 출력
        Iterator<Integer> it = v.iterator(); // iterator 객체 얻기
        while(it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }

        // Iterator를 이용하여 벡터 속의 모든 정수 더하기
        int sum = 0;
        it = v.iterator(); // it 다시 설정 -> iterator는 한 번 사용하면 소모됨
        while(it.hasNext()) {
            int n = it.next();
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합 : " + sum);
    }
}
