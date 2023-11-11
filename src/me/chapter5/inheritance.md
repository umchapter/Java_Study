# 상속

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
  * extends 다음에는 클래스 이름을 하나만 지정할 수 있음.
* 자바에서는 상속의 횟수에 제한을 두지 않음.
* 자바에서 계층 구조의 최상위에 java.lang.Object 클래스가 있음.
  * 사용자가 만들든 자바패키지에서 제공하든, 자바에서 모든 클래스는 Object 클래스를 자동으로 상속받도록 컴파일 됨.

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
  * 같은 패키지에 속한 모든 클래스들
  * 같은 패키지든 다른 패키지든 상속받는 서브 클래스
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

* 캐스팅(casting)이란 타입 변환을 말함.
* 자바에서 클래스에 대한 캐스팅은 업캐스팅(upcasting)과 다운캐스팅(downcasting)으로 나뉨.

### 업캐스팅

* 자바에서 서브 클래스는 슈퍼 클래스의 속성을 상속받기 때문에, 서브 클래스의 객체는 슈퍼 클래스의 멤버를 모두 가짐.
* 그러므로 서브 클래스의 객체를 슈퍼 클래스의 객체로 취급할 수 있음.
* 예를 들어, 코끼리나 사람을 생물 박스에 넣고 박스 앞에 '생물'을 가리키는 팻말을 사용해도 됨.

```JAVA
Person p;
Student s = new Student();
p = s; // 업캐스팅
```

* 슈퍼 클래스 타입의 레퍼런스 p가 서브 클래스 객체(s)를 가리키도록 치환되는 것이 업캐스팅.
* 그러나 레퍼런스 p로는 Person 클래스의 멤버만 접근 가능 -> p는 Person타입이기 때문.
* Student 내부의 grade 필드는 Person 클래스의 멤버가 아니므로 다음 문장은 오류

```JAVA
p.grade = "A"; // 컴파일 오류
```

* 업캐스팅한 레퍼런스로는 객체 내의 모든 멤버에 접근할 수 없고, 슈퍼 클래스의 멤버만 접근할 수 있음.
* Student 객체가 Person 타입으로 업캐스팅되면, Person 타입의 객체로 취급되며 Student 클래스의 필드나 메소드는 접근할 수 없음.
* 업캐스팅은 명시적 타입 변환 불필요 -> Student 객체는 Person 타입이기도 하기 때문.

```JAVA
// 예시
class Person {
    String name;
    String id;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    String grade;
    String department;

    public Student(String name) {
        super(name);
    }
}

public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("이재문");
        p = s; // 업캐스팅

        System.out.println(p.name); // 오류 없음

        g.grade = "A"; // 컴파일 오류
        p.department = "Com"; // 컴파일 오류
    }
}
```

### 다운캐스팅

* 업캐스팅과 반대로 캐스팅하는 것을 다운캐스팅이라 함.

```JAVA
Student s = (Student)p; // 다운캐스팅, (Student)의 타입 변환을 반드시 표시
```

* s를 통해 Student 객체 전체를 접근할 수 있게 됨.

```JAVA
public static void main(String[] args) {
    Person p = new Student("이재문"); // 업캐스팅
    Student s;

    s = (Student)p; // 다운캐스팅

    System.out.println(s.name); // 오류 없음
    s.grade = "A"; // 오류 없음
}
```

### 업캐스팅과 instanceof 연산자

* 앞서의 예시처럼 '생물' 팻말(레퍼런스)이 가리키는 박스에 들엉 있는 객체의 타입이 무엇인지, 사람인지 동물인지 팻말만 보고서는 알 수 없음.
* 이와 같이 업캐스팅을 한 경우, 레퍼런스가 가리키는 객체의 진짜 클래스 타입을 구분하기 어려움.
* 즉, 다양한 서브 클래스들이 하나의 슈퍼 클래스를 상속 받고 있을 때, 슈퍼 클래스를 가리키는 레퍼런스는 정확히 어떤 클래스를 가리키는지 알 수 없음.

#### instanceof 연산자 사용

* 레퍼런스가 가리키는 객체가 어떤 클래스 타입인지 구분하기 위해, 자바에서는 instanceof 연산자를 두고 있음.
* instanceof는 이항 연산자로서 다음과 같이 사용됨

```JAVA
레퍼런스 instanceof 클래스명
```

* instanceof 연산자의 결과 값은 boolean 값 -> '레퍼런스'가 가리키는 객체가 해당 '클래스' 타입의 객체이면 true 아니면 false

```JAVA
// 예시

Person jee = new Student();
Person kim = new Professor();
Person lee = new Researcher();
if (jee instanceof Person) // jee는 Person 타입이므로 true
if (jee instanceof Student) // true
if (kim instanceof Student) // false
if (kim instanceof Researcher) // Professor 객체는 Researcher 타입이기도 하므로 true
if (lee instanceof Professor) // lee는 Professor 타입이 아니므로 false

if (3 instanceof int) // 문법 오류. instanceof는 객체에 대한 레퍼런스만 사용

if ("java" instanceof String) // true
```

## 6. 메소드 오버라이딩

### 메소드 오버라이딩의 개념

* 메소드 오버라이딩(method overriding)은 슈퍼 클래스와 서브 클래스의 메소드 사이에 발생하는 관계
* 슈퍼 클래스에 선언된 메소드와 같은 이름, 같은 리턴 타입, 같은 매개 변수 리스트를 갖는 메소드를 서브 클래스에서 재작성 하는 것
* 서브 클래스의 개발자는 슈퍼 클래스에 있는 메소드로 목적하는 바를 이룰 수 없을 때 동일한 이름의 메소드를 서브 클래스에 다시 작성할 수 있음
* 슈퍼 클래스의 메소드를 무시하고 서브 클래스에서 오버라이딩된 메소드가 무조건 실행되도록 함 -> 동적 바인딩

### 오버라이딩 사례로 이해하기

```JAVA
// 예시

class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() { // 슈퍼 클래스의 draw 메소드와 이름(draw), 리턴 타입(void), 매개변수 리스트(매개변수 없음) 동일
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() { // 오버라이딩
        System.out.println("Circle");
    }
}
```

#### 오버라이딩 된 메소드 호출

```JAVA
Line line = new Line();
line.draw(); // Line
```

* new Line()에 의해 생성된 객체에는 2개의 draw() 메소드가 존재하며, 레포런스 line이 Line 타입이므로, 컴파일러는 당연히 line.draw()가 Line 클래스의 draw() 메소드를 호출하도록 하고 실행 시에도 Line 클래스의 draw()가 호출됨

```JAVA
Shape shape = new Line(); // 업캐스팅
shape.draw(); // Line
```

* 위와 같은 경우 new Line()에 의해 생성된 Line 객체에는 2개의 draw() 메소드가 존재하지만, 첫번째 경우와 다른 것은 레퍼런스 shape이 Shape 타입임
* 따라서 shape.draw()를 컴파일 할 때, 컴파일러는 Shape 클래스에 draw() 멤버가 있는지 확인하고 Shape의 draw()를 호출하도록 컴파일함
* 하지만 shape.draw()의 실행시 shape이 가리키는 객체에는 Shape의 draw()를 오버라이딩한 Line의 draw()가 존재하기 때문에, Shape의 draw()가 아닌 Line의 draw()가 실행됨
* 이 과정이 동적 바인딩(dynamic binding)
* 즉, 어떻게 호출되든 객체 안에 오버라이딩된 메소드 draw()의 호출이 무조건 보장된다는 점 -> 오버라이딩의 진정한 목적이자 실현

### 오버라이딩의 목적, 다형성 실현

* 오버라이딩은 슈퍼 클래스에 선언된 메소드를, 각 서브 클래스들이 자신만의 내용으로 새로 구현하는 기능
* 오버라이딩은 상속을 통해 '하나의 인터페이스(같은 이름)에 서로 다른 내용 구현'이라는 객체 지향의 다형성을 실현하는 도구
* MethodOverridingEx.java

#### @Override

* JDK 1.5부터 @Override annotation 제공 -> 오버라이딩이 정확한지 컴파일러가 확인

### 메소드 오버라이딩의 제약사항

#### 1. 슈퍼 클래스의 메소드와 *동일한 원형*으로 작성

* 슈퍼 클래시의 메소드와 동일한 이름, 동일한 매개변수 타입과 개수, 동일한 리턴 타입을 갖는 메소드를 작성해야 함

#### 2. 슈퍼 클래스 메소드의 접근 지정자보다 *접근의 범위를 좁혀* 오버라이딩 할 수 없음

* 접근 지정자는 public, protected, default, private 순으로 접근의 범위가 좁아짐
* 슈퍼 클래스에 protected로 선언된 메소드는 서브 클래스에서 protected나 public으로만 오버라이딩할 수 있고, public으로 선언된 메소드는 서브 크랠스에서 public으로만 오버라이딩할 수 있음

#### 3. static이나 private 또는 final로 선언된 메소드는 서브 클래스에서 오버라이딩 할 수 없음

### 메소드 오버라이딩 활용

* 메소드 오버라이딩은 서브 클래스 개발자가 슈퍼 클래스의 특정 메소드를 자신의 특성에 맞게 새로 만들어 사용하고자 하는 경우에 활용됨
* UsingOverride.java

### 동적 바인딩: 오버라이딩된 메소드 호출

* 동적 바인딩(dynamic binding)은 실행할 메소드를 컴파일 시(compile time)에 결정하지 않고 실행 시(run time)에 결정하는 것을 말함
* 자바에서는 동적 바인딩을 통해 오버라이딩된 메소드가 항상 실행되도록 보장함

```JAVA
Shape a = new Shape();
a.paint(); // paint()는 Shape의 draw()를 호출함

Shape b = new Circle();
b.paint(); // paint()는 Circle에서 오버라이딩한 draw() 호출
```

* 어떤 경우이든 자바에서 오버라이딩된 메소드가 있다면 동적 바인딩을 통해 오버라이딩된 메소드가 무조건 실행됨

### 오버라이딩과 super 키워드

* 무조건 오버라이딩된 메소드가 호출된다면 슈퍼 클래스의 메소드는 이제 더 이상 쓸모없게 된 것인가?
* 서브 클래스에서 super 키워드를 이용하면 정적 바인딩을 통해 슈퍼 클래스의 멤버에 접근할 수 있음

```JAVA
super.슈퍼클래스의멤버
```

* super는 자바 컴파일러에 의해 지원되는 것으로 **슈퍼 클래스에 대한 레퍼런스**임
* super를 이용하면 슈퍼 클래스의 필드와 메소드 모두 접근 가능함

```JAVA
name = "Circle";      // Circle 클래스의 name에 "Circle" 기록
super.name = "Shape"; // Shape 클래스의 name에 "Shape" 기록
super.draw();         // Shape 클래스의 draw() 호출 -> 정적 바인딩
```

* 위와 같은 코드는 2개의 name 필드에 각각 다른 문자열이 들어 있게 됨
* SuperKeywordEx.java

#### this와 super

* this, this(), super, super()의 차이는 다음과 같음
* this와 super는 모두 레퍼런스로서, this로는 현재 객체의 모든 멤버를, super로는 현재 객체 내에 있는 슈퍼 클래스 멤버를 접근할 수 있음

```JAVA
this.객체내의멤버
super.객체내의슈퍼클래스의멤버
```

* 그리고 super로 메소드를 호출하면 정적 바인딩을 실행함
* 한편, this()와 super()는 모두 메소드 호출이며, this()는 생성자에서 다른 생성자를 호출할 때 사용하고, super()는 서브 클래스의 생성자에서 슈퍼 클래스의 생성자를 호출할 때 사용

### 오버로딩(overloading)과 오버라이딩(overriding)

* 오버로딩과 오버라이딩은 자바에서 다형성을 이루는 방법들

|비교 요소|메소드 오버로딩(overloading)|메소드 오버라이딩(overriding)|
|:---:|:---:|:---:|
|선언|같은 클래스나 상속 관계에서 동일한 이름의 메소드 중복 작성|서브 클래스에서 슈퍼 클래스에 있는 메소드와 동일한 이름의 메소드 재작성|
|관계|동일한 클래스 내 혹은 상속 관계|상속 관계|
|목적|이름이 같은 여러 개의 메소드를 중복 작성하여 사용의 편리성 향상. 다형성 실현|슈퍼 클래스에 구현된 메소드를 무시하고 서브 클래스에서 새로운 기능의 메소드를 재정의하고자 함. 다형성 실현|
|조건|메소드 이름은 반드시 동일하고, 매개변수 타입이나 개수가 달라야 성립|메소드의 이름, 매개변수 타입과 개수, 리턴 타입이 모두 동일해야 성립|
|바인딩|정적 바인딩. 호출될 메소드는 컴파일 시에 결정|동적 바인딩. 실행 시간에 오버라이딩된 메소드 찾아 호출|

## 7. 추상 클래스

* 추상 클래스는 상속에서 슈퍼 클래스로 사용됨

### 추상 메소드

* 추상 메소드(abstract method)란 선언은 되어 있으나 코드가 구현되어 있지 않은, 즉 껍데기만 있는 메소드
* 추상 메소드를 작성하려면 abstract 키워드와 함께 원형만 선언하고 코드는 작성하지 않음

```JAVA
// 추상 메소드의 선언 예시
public abstract String getName();
public abstract void setName(String s);

// 컴파일 오류 예시
public abstract String fail() {return "Good bye";}
// 코드가 작성되어 있으므로 오류발생
```

### 추상 클래스 만들기

* 추상 클래스(abstract class)가 되는 경우는 다음 2가지로서, 모두 abstract 키워드로 선언해야 함
* 추상 메소드를 포함하는 클래스

```JAVA
abstract class Shape { // 추상 클래스 선언
    public Shape() {}
    public void paint() {draw();}
    abstract public void draw(); // 추상 메소드 선언
}
```

* 추상 메소드가 없지만 abstract로 선언한 클래스

```JAVA
abstract class MyComponent { // 추상 클래스 선언
    String name;
    public void load(String name) {
        this.name = name;
    }
}
```

* 앞의 Shape와 MyComponent 모두 추상 클래스이지만 추상 메소드를 가졌는지 여부의 차이가 있음
* **추상 메소드**를 가지고 있으면 반드시 **추상 클래스**로 선언되어야 함

```JAVA
class Fault { // 오류. 추상 클래스로 선언되지 않았음
    abstract public void f(); // 추상 메소드
}
```

### 추상 클래스는 객체를 생성할 수 없다

* 응용프로그램은 추상 클래스의 객체(인스턴스)를 생성할 수 없음
* 추상 클래스는 본디 객체를 생성할 목적으로 만드는 클래스가 아니기 때문
* 추상 클래스에는 실행 코드가 없는 미완성 상태인 추상 메소드가 있을 수 있기 때문에, 다음과 같이 추상 클래스의 객체를 생성하는 코드에는 컴파일 오류가 발생

```JAVA
public class AbstractError {
    public static void main(String[] args) {
        Shape shape; // 오류 아님
        shape = new Shape(); // 컴파일 오류, 추상 클래스 Shape의 객체를 생성할 수 없음
    }
}
```

* 추상 클래스의 레퍼런스 변수를 선언하는 것은 오류가 아님에 유의

### 추상 클래스의 상속

* 추상 클래스를 단순히 상속받는 서브 클래스는 추상 클래스가 됨
* 추상 클래스의 추상 메소드를 그대로 상속받기 때문
* 따라서 서브 클래스에 abstract를 붙여 추상 클래스임을 명시해야 컴파일 오류가 발생하지 않음
* 따라서 오버라이딩 필요

```JAVA
abstract class Shape { // 추상 클래스
    public Shape() {}
    public void paint() {draw();}
    abstract public void draw(); // 추상 메소드
}
abstract class Line extends Shape { // 추상 클래스. draw()를 그대로 상속 받았기 때문
    public String toString() {return "Line";}
}
```

### 추상 클래스의 구현과 못적

* 추상 클래스의 구현이란, 슈퍼 클래스에 선언된 모든 추상 메소드를 서브 클래스에서 오버라이딩하여 실행 가능한 코드로 구현하는 것을 말함

```JAVA
abstract class Shape { // 추상 클래스
    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}
```

* Line, Rect는 추상클래스 Shape를 상속받아 만든 서브 클래스들로, draw()를 오버라이딩하여 구현한 사례
* 그러므로 Line, Rect는 추상 클래스가 아니며 이들의 인스턴스를 생성할 수 있음
* 추상 클래스는 메소드의 오버라이딩을 강제함. 따라서 추상 클래스는 추상 메소드를 통해 서브 클래스가 구현할 메소드를 명료하게 알려주는 인터페이스의 역할을 하고, 서브 클래스는 추상 메소드를 목적에 맞게 구현하는 다형성을 실현할 수 있음

### 추상 클래스의 용도

* 추상 클래스를 상속받은 서브 클래스는 개발자에 따라 다양하게 구현됨
* 그러나 한가지 분명한 것은 모든 개발자들이 서브 클래스에서 추상 클래스에 선언된 추상 메소드를 모두 구현해야 한다는 사실
* 추상 클래스를 이용하면 응용프로그램의 설계와 구현을 분리할 수 있음
* 추상 클래스는 계층적 상속 관계를 가지는 클래스들의 구조를 만들 때 적합함

## 8. 인터페이스

* 인터페이스(interface)는 컴퓨터 주변 장치에서 많이 사용하는 용어
* 여기서 인터페이스는 서로 다른 하드웨어 장치들이 상호 데이터를 주고받을 수 있는 규격을 의미함
* 인터페이스의 개념은 소프트웨어에도 적용됨
* 소프트웨러를 규격화된 모듈로 만들고, 서로 인터페이스가 맞는 모듈을 조립하듯이 응용프로그램을 작성할 수 있음

### 자바의 인터페이스

* 자바에도 인터페이스의 개념이 있음
* 자바의 인터페이스는 interface 키워드를 사용하여 클래스를 선언하듯이 선언함

```JAVA
interface PhoneInterface { // 인터페이스 선언
    public static final int TIMEOUT = 10000; // 상수 필드. public static final 생략 가능
    public abstract void sendCall(); // 추상 메소드. public abstract 생략 가능
    public abstract void receiveCall(); // 위와 동일
    public default void printLogo() { //default 메소드. public 생략 가능
        System.out.println("** Phone **");
    }; // 디폴트 메소드
}
```

#### 인터페이스 구성

* Java 10 기준으로 인터페이스는 다음 5종류의 멤버로 구성되며, 필드(멤버 변수)를 만들 수 없음
  * 상수와 추상 메소드(Java 7까지)
  * default 메소드(Java 8부터)
  * private 메소드(Java 9부터)
  * static 메소드(Java 9부터)
* 추상 메소드는 public abstract로 정해져 있으며, 생략될 수 있고, 다른 접근 지정으로 지정될 수 없음
* default, private, static 메소드들은 모두 인터페이스 내에 코드가 작성되어 있어야 함
* default 메소드의 접근 지정은 public으로 고정되어 있음
* private 메소드는 인터페이스 내에서만 호출 가능
* static 메소드의 경우 접근 지정이 생략되면 public이며, private으로 지정될 수 있음

#### 인터페이스는 객체를 생성할 수 없다

* 인터페이스에 구현되지 않은 추상 메소드를 가질 수 있기 때문에 객체를 생성할 수 없음

```JAVA
new PhoneInterface(); // 오류. 인터페이스 PhoneInterface 객체 생성 불가
```

#### 인터페이스 타입의 레퍼런스 변수는 선언 가능하다

```JAVA
PhoneInterface galaxy; // galaxy는 인터페이스에 대한 레퍼런스 변수
```

#### 인터페이스끼리 상속된다

* 인터페이스는 다른 인터페이스를 상속할 수 있음

#### 인터페이스를 상속받아 클래스를 작성하면 인터페이스의 모든 추상 메소드를 구현하여야 한다

* 자바의 인터페이스는 상속받을 서브 클래스에게 구현할 메소드들의 원형을 모두 알려주어, 클래스가 스스로의 목적에 맞게 메소드를 구현하도록 하는 것이 목적

### 인터페이스 구현

* 인터페이스 구현이란 implements 키워드를 사용하여 인터페이스의 모든 추상 메소드를 구현한 클래스를 작성하는 것을 말함

```JAVA
class SamsungPhone implements PhoneInterface { // 인터페이스 구현
    // PhoneInterface의 모든 추상 메소드 구현
    public void sendCall() {System.out.println("따르릉");}
    public void receiveCall() {System.out.println("전화가 왔습니다.");}

    // 메소드 추가 작성
    public void flash() {System.out.println("전화기에 불이 켜졌습니다.");}

    // PhoneInterface에 구현된 default 메소드인 printLogo()는 그대로 물려받음
}
```

### 인터페이스 상속

* 클래스는 인터페이스를 상속받을 수 없고, 인터페이스끼리만 상속이 가능함
* 상속을 통해 기존 인터페이스에 새로운 규격을 추가한 새로운 인터페이스를 만들 수 있으며, 인터페이스의 상속은 extends 키워드를 사용함

```JAVA
interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS(); // 추상 메소드
    void receiveSMS(); // 추상 메소드
}
```

* 이를 통해, MobilePhoneInterface 인터페이스는 TIMEOUT, sendCall(), reveiveCall(), printLogo(), sendSMS(), receiveSMS()의 총 6개 멤버를 가지게 됨
* 자바는 인터페이스의 다중 상속을 허용함

```JAVA
interface MP3Interface {
    void play(); // 추상메소드
    void stop(); // 추상메소드
}

interface MusicPhoneInterface extends MobilePhoneInterface, MP3Interface { // 다중 상속
    void playMP3RingTone(); // 추상 메소드
}
```

### 인터페이스의 목적

* 자바에서 인터페이스를 두는 진정한 목적은 다형성을 실현하기 위함
* 인터페이스를 구현하는 클래스들은 동일한 이름의 메소드를 구현하지만 그 내용은 서로 다를 수 있음 -> 다형성 실현
  
### 다중 인터페이스 구현

* 클래스는 하나 이상의 인터페이스를 구현할 수 있음
* 이 경우 콤마로 각 인터페이스를 구분하여 나열하며, 각 인터페이스에 선언된 모든 추상 메소드를 구현해야 함 -> 그렇지 않으면 컴파일 오류 발생
* InterfaceEx2.java 참고

### 클래스 상속과 함께 인터페이스 구현

* 클래스를 상속 받으면서 동시에 인터페이스를 구현할 수 있음
* 다중 상속, 다중 인터페이스 구현은 유용하나 자칫 너무 남용하면 클래스, 인터페이스 간의 관계가 너무 복잡해져 프로그램 전체 구조를 파악하기 어려울 수 있으므로 주의

### 인터페이스와 추상 클래스 비교

* 인터페이스와 추상 클래스는 다음 점에서 유사
  * 객체를 생성할 수 없고, 상속을 위한 슈퍼 클래스로만 사용됨
  * 클래스의 다형서응ㄹ 실현하기 위한 목적
* 차이점은 다음과 같음

|비교|목적|구성|
|:---:|:---:|:---:|
|추상 클래스| 추상 클래스는 서브 클래스에서 필요로 하는 대부분의 기능을 구현하여 두고 서브 클래스가 상속받아 활용할 수 있도록 하되, 서브 클래스에서 구현할 수밖에 없는 기능만을 추상 메소드로 선언하여, 서브 클래스에서 구현하도록 하는 목적(다형성)|추상 메소드와 일반 메소드 모두 포함 / 상수, 변수 필드 모두 포함|
|인터페이스|인터페이스는 객체의 기능을 모두 공개한 표준화 문서와 같은 것으로, 개발자에게 인터페이스를 상속받는 클래스의 목적에 따라 인터페이스의 모든 추상 메소드를 만들도록 하는 목적(다형성)|변수 필드(멤버 변수)는 포함하지 않음 / 상수, 추상 메소드, 일반 메소드, default 메소드, static 메소드 모두 포함 / protected 접근 지정 선언 불가 / 다중 상속 지원|