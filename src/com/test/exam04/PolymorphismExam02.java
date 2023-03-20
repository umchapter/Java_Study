package com.test.exam04;

class Animal {
    public void move() { // 추상 메소드기 때문에 Animal 클래스 안의 추상 메소드를 없애면 아래 코드 작동 안됨.
        System.out.println("동물이 움직입니다.");
    }
}

class Human extends Animal {
    public void move() {
        System.out.println("사람이 두 발로 걷습니다.");
    }
}

class Tiger extends Animal {
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }
}

class Eagle extends Animal {
    public void move() {
        System.out.println("독수리가 하늘을 납니다.");
    }
}

public class PolymorphismExam02 {
    public static void main(String[] args) {
        PolymorphismExam02 animalTest = new PolymorphismExam02(); // animalTest는 PE02 객체
            animalTest.moveAnimal(new Human()); // Human 인자 받음.
            animalTest.moveAnimal(new Tiger());
            animalTest.moveAnimal(new Eagle());
    }
    public void moveAnimal(Animal animal) {
        /* PE02 객체 내에서 moveanimal이라는 메소드 생성
         * 인자(arguments)로 Animal 클래스의 종속 개체 받음.
         */
        animal.move();
    }
}
