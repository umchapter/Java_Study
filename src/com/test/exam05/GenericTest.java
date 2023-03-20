package com.test.exam05;

import java.util.Map;
import java.util.HashMap;

class GStack<T> {
    int tos;
    Object [] stck;
    /* Object 모든 자바 클래스의 최상위 부모 클래스
     * []는 배열을 의미
     */

    public GStack() {
        tos = 0; // 시작값 0
        stck = new Object[10]; // Object의 배열 길이 설정
    }

    public void push(T item) {
        if(tos == 10) return; // tos가 꽉 차있으면 실행 하지 않음(빠져 나옴)
        stck[tos] = item; // tos가 꽉차있지 않으면 tos에 item 넣음
        tos ++; // tos 하나 늘림
    }

    public T pop() { // stack의 pop
        if(tos == 0) return null; // 꺼낼 것이 없으면 null 반환
        tos --; // 값이 있다면 tos를 하나 줄이고
        return (T)stck[tos]; // T타입으로 stck[tos]번째 아이템 강제 캐스팅
        // 왜냐하면 처음 선언 때 Object [] 배열로 선언하엿기 때문에 타입 매개변수의 타입으로 변환필요
        // 예를 들어, T가 String 이라면 스택의 tos번째 아이템을 String 타입으로 반환함
    }
}

class KeyValue {

    Map<String, String> map = new HashMap<String, String>();
}

public class GenericTest {
    public static void main(String[] args) {
        GStack<String> stringStack = new GStack<String>();

        stringStack.push("Seoul");
        stringStack.push("Busan");
        stringStack.push("LA");

        for(int i=0;i<3;i++){
            System.out.println(stringStack.pop());
        }

        Map<String,String> map = new HashMap<String, String>();
        map.put("userid", "MasterOfPuppets");
        map.put("name", "양흠례");

        System.out.println(map.get("userid"));
        
    }
}
