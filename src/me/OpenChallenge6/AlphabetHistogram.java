package me.OpenChallenge6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

class LineReader {
    public String readString() {
        StringBuffer sb = new StringBuffer(); // 키 입력을 받을 스트링버퍼 생성
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine(); // 텍스트 한 라인을 읽음
            if(line.equals(";")) { // ';'만 있는 라인이면
                scanner.close();
                break; // 입력 끝
            }
            sb.append(line); // 읽은 라인 문자열을 스트링버퍼에 추가
        }
        return sb.toString(); // 스트링버퍼의 문자열을 스트링으로 리턴
    }
}

public class AlphabetHistogram {
    String targetString;
    Map<Character, Integer> historgramMap;

    public AlphabetHistogram(String targetString) {
        this.targetString = targetString.toUpperCase();
        this.historgramMap = new HashMap<>();

        for(int i = (int)'A'; i < (int)'Z' + 1; i++) {
            this.historgramMap.put((Character)(char)i, 0);
        }

        for(int i = 0; i < this.targetString.length(); i++) {
            char chr = this.targetString.charAt(i);
            Integer value = this.historgramMap.get((Character)chr);
            
            if (value != null) {
                this.historgramMap.put((Character)chr, value + 1);
            } else {
                continue;
            }
        }
    }

    public void draw() {
        Set<Entry<Character, Integer>> entrySet = historgramMap.entrySet();
        
        System.out.println("히스토그램을 그립니다.");

        for (Entry<Character, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "-".repeat(entry.getValue()));
        }
    }

    public static void main(String[] args) {
        LineReader lr = new LineReader();
        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
        String targetString = lr.readString();

        AlphabetHistogram hist = new AlphabetHistogram(targetString);
        
        hist.draw();
    }
}