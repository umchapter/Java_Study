package com.test.exam02;

public class ClassExam {
    public static void main(String[] args) {
        
        A classA = new A(); //int[] a = new int[3];
        /* 같은 패키지 안에 있는 클래스 사용 가능, 디폴트 값은 같은 패키지 내에서는 퍼블릭
         * A : 만들어져 있는 클래스
         * classA : A라는 클래스의 타입을 따르는 클래스 변수
         * 개발자가 새로운 A 클래스 타입을 만들었고,
         * 이걸 classA라는 참조변수의 타입으로 적용.
         * new라는 예약어를 통해 만들어진 메모리를 할당
         * A() : 생성자
         */
        System.out.println(classA.sum(classA.a, classA.b));
        // 메소드와 멤버 변수 사용 가능
        System.out.println(classA.sum(5, 11));
        // 임의 변수 지정 가능
        A classAA = new A("안녕하세요");
        // String을 입력하여 새로운 생성자 적용
        System.out.println(classAA.str + Integer.toString(classAA.a));

        B b = new B();
        System.out.println("b.b = " + b.getB());
        //b.b는 private이므로 접근 불가하지만, public인 getB method를 통해 b.b를 얻을 수 있음.
        b.setB(100); //setter method를 통해 b.b를 100으로 설정해줌.
        System.out.println("b.b = " + b.getB());

        new C(20); /* new만 가지고도 인스턴스 생성가능. 생성자는 인스턴스 변수들 초기화.
                        익명클래스 */

        C c = new C();
        c.ccc(0);
        c.ccc(0,1);

        D.ddd(); // static method

        D d1 = new D(); // d1 인스턴스
        D d2 = new D(); // d2 인스턴스
        
        d1.d = 4;
        System.out.println("d2.d = " + d2.d); // d1.d에 값을 넣었으나 d2.d에 영향을 줌

        d1.e = 23;
        System.out.println("d2.e = " + d2.e); // static이 아닌 인스턴스는 서로 영향 없음

    }
}