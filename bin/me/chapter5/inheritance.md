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
