package me.chapter7;

import java.util.HashMap;
import java.util.Scanner;

class Student {
    private int id;
    private String tel;
    public Student(int id, String tel) {
        this.id = id;
        this.tel = tel;
    }
    public int getId() {
        return this.id;
    }
    public String getTel() {
        return this.tel;
    }
}

public class HashMapStudentEx {
    public static void main(String[] args) {
        // (학생 이름, Student 객체)를 저장하는 해시맵 생성
        HashMap<String, Student> map = new HashMap<>();
        map.put("황기태", new Student(1, "010-1111-1111"));
        map.put("이재문", new Student(2, "010-2222-2222"));
        map.put("김남유", new Student(3, "010-3333-3333"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 이름?");
            String name = scanner.next();
            if(name.equals("exit")) {
                break;
            }
            Student student = map.get(name);
            if(student == null) {
                System.out.println(name + "은 없는 사람입니다.");
            } else {
                System.out.println("id : " + student.getId() + ", 전화 : " + student.getTel());
            }
        }
        scanner.close();
    }
}
