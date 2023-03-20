package com.test.singletone;

public class Company {

    private static Company instance = new Company(); // 멤버 변수를 클래스 변수로
    private Company(){} // constructor

    public static Company getInstance(){ // method 명 앞의 값(Company)은 리턴하는 데이터 타입

        if(instance == null){
            instance = new Company();
        }

        return instance;
    }
    
}
