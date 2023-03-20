package com.test.exam04;

public class AbstractClassExam {
    
    public static void main(String[] args) {
        
        ATeam aTeam = new ATeam();
        aTeam.manager();
        aTeam.companyGoal();
        aTeam.departGoal();

    }
}

abstract class SalesPaln {

    public void companyGoal() {
        System.out.println("2023년 전사 목표 300억 달성");
    }

    abstract public void departGoal(); // 추상 메소드
    abstract public void product(); // 추상 메소드
}


class ATeam extends SalesPaln {

    public void manager() {
        System.out.println("A팀 팀장 : 김철우");
    }

    @Override
    /* Annotation -> 컴파일러에게 앞으로 무슨 일을 하겠다고 통보
     * 주석문(//) or @(Override)
     * Override -> 부모로부터 상속 받은 메소드를 그대로 쓰지 않고 바꿔서 사용함 
     */ 
    public void departGoal() {
        System.out.println("A팀 판매 목표 70억 달성!");
    }

    @Override
    public void product() {
       System.out.println("A팀 주력 상품은 TV입니다.");
    }

}

class BTeam extends SalesPaln {

    public void manager() {
        System.out.println("B팀 팀장 : 김민수");
    }
    
    @Override
    public void departGoal() {
        System.out.println("B팀 판매 목표 100억 달성!");
    }

    @Override
    public void product() {
        System.out.println("B팀 주력 상품은 냉장고입니다.");
    }

}