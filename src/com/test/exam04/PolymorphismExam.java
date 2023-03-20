package com.test.exam04;

class Family {
    void hello() { // void hello() -> 추상 메소드
        System.out.println("가족들과 인사합시다.");
        /* 자식 메소드에서는 가상 메소드화. 실행 안 함.
         * 다만, 부모 클래스에서 정의되지 않은 메소드는 자식 클래스에서
         * 메소드로 사용할 수 없음. 추상 메소드를 상속 받았으면 반드시 구현해야함.
         */
    }
}

class KimFamily extends Family {
    void hello() { //오버라이딩
        System.out.println("김선생님 안녕하세요?");
    }
    void dinner() {
        System.out.println("같이 식사나 한 번 하시죠.");
    }
    void drink() {
        System.out.println("술 한 잔 하시죠.");
    }
}

class ParkFamily extends Family {
    void hello() {
        System.out.println("박선생님 안녕하세요?");
    }
    void fishing() {
        System.out.println("낚시 한 번 하시죠.");
    }
}

public class PolymorphismExam {
    public static void main(String[] args) {
        Family f;
        f = new Family();
        f.hello();

        f = new KimFamily();
        f.hello();
        // f.dinner();
        /* 오류남. 왜냐하면 부모 클래스에서 해당 메소드가 정의되어 있지 않기 때문에.
         * 다형성의 기본은 부모 객체에서 추상 메소드를 형성해 두고, 자식에게 상속시킨 
         * 메소드를 구현시키고 업캐스팅을 통해 부모 클래스에서 자식 멤버를 사용하는 것.
         * 하나의 타입으로 다양한 결과를 얻음.
         * 예를 들어, 게임 캐릭터의 이름, 이동 및 공격 방식 등을 추상적으로 정의하고,
         * 다양한 자식 객체에서 개별 케릭터들을 구체적으로 구현 및 정의.
         * 이것을 부모 클래스로 업캐스팅하여 추상적 객체가 구체성을 가지고 동작함.
         * 모든 캐릭터 별로 공통되는 부분을 구현할 필요 없음.
         */ 

        f = new ParkFamily();
        f.hello();
    }
}
