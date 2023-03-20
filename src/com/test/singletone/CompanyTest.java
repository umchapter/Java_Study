package com.test.singletone;

public class CompanyTest {
    
    public static void main(String[] args) {
        
        Company myCompany1 = Company.getInstance();
        Company myCompany2 = Company.getInstance();
        System.out.println(myCompany1 == myCompany2);
    }

    /* Singletone pattern 객체 지향 프로그램에서 인스턴스를 하나만 구현하는 방식
     * 데이터의 일관성 등을 위해 사용함
     */

}
