package com.test.exam04;

interface SalePlanInterfaceExam { // 완전한 설계도(요약)
    
    public void manager();
    public void goal();
    public void product();    
    }

class A1Team implements SalePlanInterfaceExam{

    @Override
    public void manager() {
        System.out.println("A팀 팀장 : 김철우");
    }    

    @Override
    public void goal() {
        System.out.println("A팀 판매 목표 70억 달성!");
    }

    @Override
    public void product() {
        System.out.println("A팀 주력 상품은 TV입니다.");
    }

}

public class InterfaceExam {

    public static void main(String[] args) {
        A1Team aTeam = new A1Team();
        aTeam.manager();
        aTeam.goal();
        aTeam.product();

    }    
}


