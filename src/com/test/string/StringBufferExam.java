package com.test.string;

public class StringBufferExam {
    
    /* StringBuffer는 멀티스레드 환경에서 안전.
     * StringBuilder는 성능면에서 StringBuffer보다 우수
     * 따라서 동기/비동기 상황을 구별할 필요가 없는 상황에서는 StringBuild를 권장
     * 비동기 상황에서는 StringBuffer를 권장
     */

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.insert(0, "Everyone ");

        System.out.println(sb);
        System.out.println(sb.substring(0,8));
    }
}
