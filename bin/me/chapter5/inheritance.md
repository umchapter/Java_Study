상속
===

## 1. 상속의 개념
* 객체 지향 언어에서 상속은 부모의 생물학적 특성을 물려받는 유전에 가까움.
* 부모 클래스에서 만들어진 필드와 메소드를 자식 클래스가 물려 받는 것.
* 상속은 클래스 사이의 상속이지 객체 사이의 상속이 아님.
* 자식 객체는 자식 클래스와 부모 클래스에 만들어진 모든 멤버를 가지고 생성됨.

### 상속의 필요성
* 코드가 중복을 제거할 수 있어 클래스의 유지 보수가 간결함.

## 2. 클래스 상속과 객체

### 자바의 상속 선언
* 자바에서는 부모 클래스를 슈퍼 클래스(Super Class), 상속받는 자식 클래스를 서브 클래스(Sub Class)라고 부름.
* 상속을 선언할 때 확장한다는 뜻을 가진 extends 키워드를 사용함.
```JAVA
public class Person {
    ...
}

public class Student extends Person { /// Person을 상속받는 클래스 Student 선언
    ...
}

public class StudentWorker extends Student {
    // Student를 상속받는 클래스 StudentWorker 선언 -> Person 자동 상속
    ...
}
```

### 상속과 객체
* ColorPointEx 예제
#### 상속 선언
* Point를 상속받는 ColorPoint 클래스의 상속 선언은 다음과 같음
```JAVA
class ColorPoint extends Point {
    ...
}
```
#### 서브 클래스 객체 생성
* 상속에서 일차적으로 이해해야 하는 것은 바로 서브 클래스 객체의 모양
```JAVA
Point p = new Point();
ColorPoint cp = new ColorPoint(); // 서브 클래스 객체 생성
```
* p 객체는 Point 클래스의 멤버만 가짐.
* cp 객체는 슈퍼 클래스(Point)의 멤버와 서브 클래스(ColorPoint)의 멤버를 모두 갖고 탄생 -> 상속
#### 서브 클래스 객체 활용
* ColorPointEx 클래스의 main() 메소드에서는 cp 객체를 구성하는 ColorPoint 클래스의 public 멤버와
슈퍼 클래스인 Point 클래스의 public 멤버를 모두 접근할 수 있음.
* 그러나 x, y, color 필드는 private 속성이기 때문에 접근할 수 없음
```JAVA
cp.x - 10         // private 멤버 x 접근 불가
cp.color = "red"; // private 멤버 color 접근 불가
```
#### 서브 클래스에서 슈퍼 클래스 멤버 접근
* 서브 클래스는 슈퍼 클래스의 private 멤버를 제외하고 모든 멤버에 접근할 수 있음.

### 자바 상속의 특징
* 자바에서는 클래스의 다중 상속(multiple inheritance)을 지원하지 않음
    - extends 다음에는 클래스 이름을 하나만 지정할 수 있음.
* 자바에서는 상속의 횟수에 제한을 두지 않음.
* 자바에서 계층 구조의 최상위에 java.lang.Object 클래스가 있음.
    - 사용자가 만들든 자바패키지에서 제공하든, 자바에서 모든 클래스는 Object 클래스를 자동으로 상속받도록 컴파일 됨.

## 3. 상속과 protected 접근 지정자

### 슈퍼 클래스에 대한 접근 지정
* 슈퍼클래스의 멤버 접근 지정에 따라, 서브 클래스나 다른 클래스에서 슈퍼 클래스의 멤버를 접근할 수 있는지 여부

|슈퍼 클래스 멤버에 접근하는클래스 종류|private|default|protected|public|
|:---:|:---:|:---:|:---:|:---:|
|같은 패키지에 있는 클래스|X|O|O|O|
|다른 패키지에 있는 클래스|X|X|X|O|
|같은 패키지에 있는 서브 클래스|X|O|O|O|
|다른 패키지에 있는 서브 클래스|X|X|O|O|

#### 슈퍼 클래스의 private 멤버
* 슈퍼 클래스의 멤버가 private으로 선언되면, 서브 클래스를 포함하여 다른 어떤 클래스에서도 접근할 수 없음. private은 오직 '현재 클래스의 멤버들에게만 접근을 허용한다'는 의미.

#### 슈퍼 클래스의 default 멤버
* 슈퍼 클래스의 멤버가 default로 선언되면, 패키지에 있는 모든 클래스가 접근 가능함. 서브 클래스라도 다른 패키지에 있다면, 슈퍼 클래스의 디폴트 멤버는 접근할 수 없음.

#### 슈퍼 클래스의 public 멤버
* 슈퍼 클래스의 멤버가 public으로 선언되면, 같은 패키지에 있든 다른 패키지에 있든 모든 클래스에서 접근할 수 있음.

### 슈퍼 클래스의 protected 멤버
* 슈퍼 클래스의 protected 멤버는 다음 두 가지 경우에 접근을 허용함.
    - 같은 패키지에 속한 모든 클래스들
    - 같은 패키지든 다른 패키지든 상속받는 서브 클래스
* 따라서 default에서 서로 다른 패키지일 경우 접근이 불가능한 멤버에 대해 protected에서는 접근이 가능함.
* InheritanceEx 예제.

## 4. 상속과 생성자

### 서브 클래스와 슈퍼 클래스의 생성자 호출 및 실행
* 서브 클래스와 슈퍼 클래스는 각각 생성자를 가지고 있음.
    1. 서브 클래스 객체가 생성될 때 서브 클래스의 생성자와 슈퍼 클래스의 생성자 모두가 실행됨.
    서브 클래스의 객체가 생성되면 이 객체 속에 서브 클래스와 멤버와 슈퍼 클래스의 멤버가 모두 들어있음. 생성자의 목적은 객체 초기화에 있으므로, 서브 클래스의 생성자는 생성된 객체 속에 들어 있는 서브 클래스의 멤버 초기화나 필요한 초기화를 수행하고, 슈퍼 클래스의 생성자는 생성된 객체 속에 있는 슈퍼 클래스의 멤버 초기화나 필요한 초기화를 각각 수행함.
    2. 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자가 실행됨.
* 아래와 같이 컴파일러는 생성자를 호출하면서 슈퍼 클래스의 생성자를 다시 호출함. 결과적으로 최상위 슈퍼 클래스의 생성자가 먼저 실행됨.
```JAVA
public class ConstructorEX {
    public static void main(String[] args) {
        C c;
        c = new C(); // -> 생성자를 호출함(호출 번호 1)
    }
}

class C extends B {
    public C() { // -> 슈퍼 클래스인 B의 생성자를 호출함(호출 번호 2)
        System.out.print("생성자C"); // -> C 생성자를 실행함(리턴 3)
    }
}

class B extends A {
    public B() { // -> 슈퍼 클래스인 A의 생성자를 호출함(호출 번호 3)
        System.out.print("생성자B"); // -> B 생성자를 실행함(리턴 2)
    }
}

class A {
    public A() {
        System.out.print("생성자A"); // -> A 생성자를 실행함(리턴 1)
    }
}
```
* 슈퍼 클래스가 먼저 초기화된 후, 이를 활용하는 서브 클래스가 초기화되어야 하기 때문임.

### 서브 클래스에서 슈퍼 클래스 생성자 선택
* 원칙적으로 서브 클래스의 개발자가 서브 클래스의 각 생성자에 대해, 함께 실행될 슈퍼 클래스의 생성자를 지정해야 함. 하지만, 개발자가 슈퍼 클래스의 생성자를 명시적으로 지정하지 않은 경우, 컴파일러는 자동으로 슈퍼 클래스의 기본 생성자를 호출하도록 컴파일함.

#### 슈퍼 클래스의 기본 생성자가 자동 선택되는 경우
* 개발자의 명시적 지시가 없으면, 서브 클래스의 생성자가 기본 생성자이든 매개변수를 가진 것이든, 슈퍼 클래스에 만들어진 기본 생성자가 선택됨. 이 선택은 자바 컴파일러에 의해 강제로 이루어짐.
```JAVA
class A {
    public A() { // 4. 기본 생성자 호출 ->
    // 컴파일러는 서브 클래스의 기본 생성자에 대해 자동으로 슈퍼클래스의 기본 생성자와 짝을 맺음
        System.out.println("생성자A");
    }
    public A(int x) { // 만약 기본 생성자 A()가 없으면 클래스 B의 생성자와 짝을 이룰 기본 생성자가
    // 클래스 A에 없기 때문에 컴파일러는 오류 띄움.
    /* "Implicit super constructor A() is undefined. Must explicitly invoke another constructor" */
        ...
    }
}
class B extends A { // 3. A 생성자 호출
    public B() { // 2. 기본 생성자
        System.out.println("생성자B");
    }
}
public class ConstructorEx2 {
    public static void main(String[] args) {
        B b;
        b = new B(); // 1. 생성자 호출
    }
}
```

#### super()를 이용하여 명시적으로 슈퍼 클래스의 생성자 선택
* 서브 클래스의 생성자에서 슈퍼 클래스의 생성자를 명시적으로 선택하는 것이 원칙.
* 서브 클래스의 생성자에서 super()를 이용하면, 슈퍼 클래스 생성자를 명시적으로 선택할 수 있음.
* super()는 슈퍼 클래스 생성자를 호출하는 코드. 괄호 안에 인자를 전달하여 슈퍼 클래스의 생성자를 호출할 수도 있음.
```JAVA
class A {
    public A() { 
        System.out.println("생성자A");
    }
    public A(int x) {
        System.out.println("매개변수생성자A" + x);
    }
}
class B extends A {
    public B() {
        System.out.println("생성자B");
    }
    public B(int x) {
        super(x); // 첫줄에 와야 함 -> x에 5를 전달하여 A(5) 생성
        System.out.println("매개변수생성자B" + x);
    }
}
public class ConstructorEx2 {
    public static void main(String[] args) {
        B b;
        b = new B(5);
    }
}
```
* SuperEx 예제

## 5. 업캐스팅과 instanceof 연산자
* 캐스팅(casting)
