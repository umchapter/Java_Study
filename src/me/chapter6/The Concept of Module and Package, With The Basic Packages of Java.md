# 모듈과 패키지 개념, 자바 기본 패키지

## 6.1 패키지(Package)

### 패키지의 개념과 필요성

* 서로 같은 이름의 클래스라 하더라도 서로 다른 패키지에 담겨있을 경우, 경로명의 차이로 인해 서로 다른 파일로 인식됨
* 패키지(package)의 경로명은 점(.)을 통해 표현 및 구별함

### 자바의 모듀로가 패키지, 클래스 경로명

* 자바에서 패키지(package)란 서로 관련 있는 클래스나 인터페이스의 컴파일된 클래스(.class)파일들을 한 곳에 묶어 놓은 것
* 그러므로 패키지는 디렉터리와 연관됨
* 하나의 패키지는 관련된 클래스파일들이 들어 있는 디렉터리로 볼 수 있음
* JDK9부터는 패키지들을 모듈(module)이라는 단위로 묶어, 100개에 가까운 모듈을 제공
* 모듈은 JDK 설치 디렉터리 밑의 jmods 디렉터리에 .jmod 확장자를 가진 압축 파일 형태(ZIP 포맷)로 제공됨
* 모듈 중 가장 기본이 되면서 응용프로그램에 많이 사용되는 클래스들을 담고 있는 것이 java.base 모듈(io, lang, util등 포함)
* 클래스를 지칭할 때는 모듈명은 사용하지 않고, 패키지명을 포함하는 경로명으로 나타냄
* 예를 들어, Scanner 클래스의 경우 다음과 같이 표현

```JAVA
    java.util.Scanner
```

## 6.2 import와 클래스 경로

### 패키지 사용하기, import 문

* 응용프로그램에서 다른 패키지에 있는 클래스를 사용하고자 한다면 패키지명을 포함하는 경로명을 사용해야 함
* 이는 컴파일러로 하여금 클래스 파일의 위치를 정확히 찾을 수 있도록 하기 위함

```JAVA
    // 코드 예
    public class ImportExample {
        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println(scanner.next());
        }
    }
```

* Scanner 클래스를 사용하기 위해서는, 완전 경로명인 java.util.Scanner를 사용
* 만인 완전 경로명을 사용하지 않는다면 컴파일러가 Scanner 클래스가 어느 디렉터리(패키지)에 있는지 찾을 수 없음
* 그러나 Scanner를 사용하는 코드마다 완전 경로명을 입력한다면 번거롭고 실수가 발생할 확률이 상승함

* import 문을 사용하면 이러한 불편함을 해소할 수 있음
* 먼저, 다음과 같이 클래스마다 경로명을 알려줄 수 있음

```JAVA
    import 패키지.클래스; // 클래스의 경로명을 컴파일러에게 알려주는 문
```

* 다만, import 문은 반드시 소스 코드의 앞부분에 작성되어야 함

```JAVA
    // 코드 예
    import java.util.Scanner;

    public class ImportExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.next());
        }
    }
```

* 또는 한 패키지에 있는 여러 클래스를 import 하고자 하는 경우, 다음과 같이 *를 사용하여 한 번에 선언할 수 있음

```JAVA
    import 패키지.*;
```

```JAVA
    // 코드 예
    import java.util.*;

    public class ImportExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.next());
        }
    }
```

## 6.3 패키지 만들기

### 패키지 선언

* 자바 소스 파일(.java)이 컴파일되어 생기는 클래스 파일(.class 파일)은 반드시 패키지에 소속되어야 함
* 클래스가 소속될 패키지 명은 다음과 같이 package 키워드를 이용하여 소스 파일의 첫 줄에 선언해야 함

```JAVA
    package 패키지명;
```

* 예를 들어 Tools 클래스(Tools.class 파일)를 작성하여 UI 패키지(UI 디렉터리)에 저장하고자 하면 다음의 예시와 같이 작성 함

```JAVA
    package UI; // Tools 클래스를 컴파일하여 UI패키지에 저장할 것을 지시

    public class Tools { // 이제 이 클래스의 경로명은 UI.Tools가 됨
        ......
    }
```

### 디폴트 패키지(default package)

* package 선언문을 사용하지 않고 자바 클래스나 인터페이스를 작성하면, 자바 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속 시킴 -> 현재 디렉터리

### 패키지의 특징

* 자바 패키지의 특징은 다음과 같음

#### 1. 패키지 계층 구조

* JDK 패키지는 디렉터리 계층 구조로 만들어짐
* 상속 관계에 있는 클래스나 인터페이스의 경우, 서브 클래스 파일을 슈퍼 클래스 파일이 저장된 패키지의 서브 디렉터리에 패키지를 만들어 저장하여 **계층화**시키면 더욱 관리하기 쉬움

#### 2. 패키지별 접근 제한

* 디폴트(default) 접근 지정으로 선언된 클래스나 멤버는 동일 패키지 내의 클래스들이 자유롭게 접근하도록 허용함
* 패키지에 포함된 클래스들끼리는 자유롭게 접근하게 하고, 다른 패키지의 클래스들은 접근을 막음으로써 패키지를 접근 권한의 범위로도 이용할 수 있음

#### 3. 동일한 이름의 클래스를 다른 패키지에 작성 가능

* 같은 패키지 내에서는 동일한 이름을 가진 클래스나 인터페이스가 존재할 수 없음
* 그러나 다른 패키지에서는 가능함
* 클래스 이름은 패키지명을 포함한 전체 경로명을 사용하기 때문
* 파일 시스템이 같은 이름을 가진 파일이 다른 디렉터리에 있으면 서로 다른 파일로 인지하는 것과 같음

#### 4. 소프트웨어의 높은 재사용성

* 클래스와 인터페이스를 잘 분류하여 패키지로 관라하면, 나중에 같거나 유사한 기능을 수행하는 클래스나 인터페이스는 재작성할 필요 없이 프로그램에 포함하여 쉽게 사용할 수 있음
* 큰 규모의 프로젝트 수행 시 큰 도움이 되며, 소프트웨어 회사에서 이러한 패키지들은 큰 자산

## 6.4 모듈 개념

### 모듈

* 모듈(module)은 JAVA 9에서 처음 도입된 개념으로, 패키지(package)는 서로 관련 있는 클래스나 인터페이스의 컴파일된 클래스(.class) 파일들을 한 곳에 담는 컨테이너이고, 모듈은 패키지들을 담는 컨테이너로 모듈 파일(.jmod)로 저장함

### 자바 플랫폼의 모듈화

* 자바 플랫폼이란 자바 프로그램의 개발 환경과 실행 환경을 함께 지칭하는 것으로, JDK/JRE 형태로 자바 개발자에게 제공됨

### 모듈 기반의 자바 실행 환경

* 자바 실행 환경(java run time environment)이란 자바 응용프로그램이 실행되는데 필요한 제반 환경
* 응용프로그램이 실행 중에 사용하는 자바 API 클래스와 자바 가상 기계(JVM) 등으로 구성됨
* JAVA 9 이전까지 자바 API의 모든 클래스들은 rt.jar라는 하나의 단일체(monolithic)로 구성되었고, 자바 가상 기계는 응용프로그램 실행 도중, 필요한 클래스 파일을 rt.jar에서 풀어 메모리에 로딩하고 실행함
* 자바 응용프로그램이 일부 클래스만 사용하더라도 rt.jar 전체가 설치되는 구조였음
* JAVA 9 부터 자바 API는 많은 수의 모듈로 분할되어 자바 응용 프로그램을 컴파일할 때 실행에 필요한 모듈만으로 조립하여 구성하도록 함

### 자바 모듈화의 목적

* 자바 컴포넌트들을 필요에 따라 조립하여 사용한다면, 필요 없는 모듈이 로드되지 않게 하여 컴퓨터 시스템에 불필요한 부담을 줄임
* 특히 하드웨어가 열악한 소형 IoT 장치에서도 자바 응용프로그램이 실행되고 성능을 유지하게 함

## 6.5 자바 JDK에서 제공하는 패키지

* JDK에는 다양한 모듈이 제공되며 이 기본 클래스들을 자바 API라고 함

### 주요 패키지

#### 1. java.lang

* System을 비롯하여 문자열, 수학 함수, 입출력 등과 같이 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스를 제공
* 이 패키지의 클래스들은 import 문을 사용하지 않아도 자동으로 임포트 됨

#### 2. java.util

* 날짜, 시간, 벡터, 해시맵 등 다양한 유틸리티 클래스와 인터페이스를 제공

#### 3. java.io

* 키보드, 모니터, 프린터, 파일 등에 입출력하는 클래스와 인터페이스를 제공

#### 4. java.awt와 javax.swing

* 자바 AWT(Abstract Windowing Toolkit)와 swing 패키지로서 GUI 프로그래밍에 필요한 클래스와 인터페이스를 제공

### 자바 API 참조

* Oracle Technology Network

## 6.6 Object 클래스

### Object 생성과 특징

* Object는 java.lang 패키지에 속한 클래스이며, 모든 클래스에 강제로 상속됨
* Object 만이 아무 클래스도 상속받지 않는 유일한 클래스로 계층 구조 상 최상위 클래스
* 그러므로 Object 클래스에는 모든 클래스에서 상속받아 사용할 공통 기능이 구현되어 있음
* Object의 주요 메소드는 다음과 같음

|메소드|설명|
|:---|:---|
|boolean equals(Object obj)|obj가 가리키는 객체와 현재 객체를 비교하여 같으면 true 리턴|
|Class getClass()|현 객체의 런타임 클래스를 리턴|
|int hashCode()|현 객체에 대한 해시코드 값 리턴|
|String toString()|현 객체에 대한 문자열 표현을 리턴|
|void notify()|현 객체에 대해 대기하고 있는 하나의 스레드를 깨움|
|void notifyAll()|현 객체에 대해 대기하고 있는 모든 스레드를 깨움|
|void wait()|다른 스레드가 깨울 때까지 현재 스레드를 대기하게 함|

### 객체 속성

* Object는 모든 객체에게 공통적으로 있어야 할 메소드를 포함함
* 예제 1 -> ObjectPropertyEx.java
* Class 클래스는 주어진 객체의 클래스에 관한 정보를 담는 클래스
* Object의 getClass() 메소드를 호출하면 바로 이 Class 객체를 리턴
* getName() 메소드를 이용하면 obj 레퍼런스가 가리키는 객체의 클래스 타입을 알아낼 수 있음
* 객체는 생성될 때 객체를 유일하게 구분할 수 있는 정수 id 값이 할당됨 -> 해시 코드
* Object의 hashCode() 메소드로 객체 안에 담겨진 해시코드 값을 알 수 있음
* Object의 toString()은 객체를 문자열로 반환하여 리턴하는 메소드

### 객체를 문자열로 변환, toString() 메소드

* Object의 toString() 메소드는 객체를 문자열로 변환
* JDK의 원본 Object.java 소스는 다음과 같이 작성

```JAVA
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

* Object의 toString() 메소드는 객체의 클래스의 이름을 얻어 와서 '@'를 연결하고 다시 객체의 해시코드 값을 16진수로 변환하여 연결한 문자열을 리턴
* 또한 '객체 + 문자열' 연산이나 객체를 출력하는 경우, toString()이 자동으로 호출됨

### 클래스에 toString() 만들기

* 개발자는 클래스를 작성할 때, Object의 toString()을 오버라이딩하여 자신만의 문자열을 리턴할 수 있음

```JAVA
    public String toString(); // public으로 선언해야 함에 특히 주의
```

* 예제2 -> ToStringEx.java

### 객체 비교와 equals() 메소드

* 기본 타입의 값을 비교하기 위해서는 == 연산자를 사용하지만, 객체 비교를 위해서는 반드시 equals() 메소드를 사용해야 함

#### ● == 연산자

* == 연산자는 두 객체의 내용물이 같은지 비교하는 것이 아니라, 두 레퍼런스가 같은지, 즉 두 레퍼런스가 동일한 객체를 가리키는지 비교함
* 예제3 -> EqualsEx.java
  * a와 b는 서로 다른 Point3 객체를 가리키므로 레퍼런스 값이 달라 == 연산자는 같지 않다고 판단

#### ● boolean equals(Object obj)

* 예제3 -> EqualsEx.java
  * a와 b가 서로 다른 객체를 가리키지만, 두 객체의 내용은 동일함
* Object의 equals(Object obj)는 인자로 건네진 객체 obj와 자기 자신을 비교하여 두 객체의 내용이 같은지를 비교하는 메소드
* 내용의 동일성은 전적으로 클래스 작성자가 정의할 문제이기 때문에, 클래스 작성자가 클래스에 equals() 메소드를 오버라이딩 하는 것이 원칙
* Object의 equals(Object obj) 메소드는 obj와 this(자기자신)의 레퍼런스를 ==로 단순 비교하여 결과를 리턴하도록 작성 -> 내용에 대해서는 비교하지 않음
* String 클래스는 eqauls() 메소드를 오버라이딩하여 가지고 있음

## 6.7.Wrapper 클래스

### Wrapper 클래스 개념

* 이름이 Wrapper인 클래스는 존재하지 않음
* 다만 int, char, double 등 8개의 기본 타입을 객체로 다루기 위해 JDK에 만들어진 8개 클래스를 통칭하여 Wrapper 클래스라 함
* Byte, Short, Integer, Long, Character, Double, Float, Boolean 클래스가 기본 타입에 해당하는 값을 다룰 수 있게 하는 Wrapper 클래스
* JDK의 어떤 클래스는 객체만을 다루기 때문에 3, 'a' 등 기본 타입의 데이터는 사용할 수 없음
* 이런 문제를 해결하기 위해 기본 타입의 값을 객체로 만들어 사용할 수 있도록 Wrapper 클래스를 제공 -> java.lang 패키지

|기본타입|Wrapper 클래스|
|:---:|:---:|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|char|Character|
|float|Float|
|double|Double|
|boolean|Boolean|

### Wrapper 클래스의 객체 생성

* 8개의 Wrapper 클래스들은 거의 비슷함
* Wrapper 객체는 기본 타입의 값을 인자로 하여 다음 예와 같이 정적 메소드인 valueOf()를 호출하여 생성함

```JAVA
    Integer i = Integer.valueOf(10);      // 정수 10의 객체화
    Character c = Character.valueOf('c'); // 문자 'c'의 객체화
    Double d = Double.valueOf(3.14);      // 실수 3.14의 객체화
    Boolean b = Boolean.valueOf(true);    // 불린 값 true의 객체화
```

* Character를 제외한 나머지 Wrapper 클래스의 경우, 문자열로 Wrapper 객체를 생서할 수도 있음

```JAVA
    Integer i = Integer.valueOf("10");
```

* JDK 9 부터는 Wrapper 클래스의 객체를 생성할 때 생성자를 이용하는 방법(new Integer(10) 등)을 폐기(deprecated)시킴
* 대신 공간과 속도에 있어 성능이 높은 valueOf() 정적 메소드를 이용하도록 함

### Wrapper 클래스의 활용

* Wrapper 클래스는 많은 메소드를 제공하나, 대부분은 기본 타입 값을 문자열로 변환하거나, 문자열을 기본 타입 값으로 변환하는 것들이 주를 이루고 있음
* 가장 많이 사용되는 Integer 클래스의 주요 메소드는 다음과 같으며, 많은 메소드가 static 타입임

|메소드|설명|
|---|---|
|static int bitCount(int i)|정수 i의 이진수 표현에서 1의 개수 리턴|
|float floatValue()|float 타입으로 값 리턴|
|int intValue()|int 타입으로 값 리턴|
|static int parseInt(String s)|문자열 s를 10진수 정수로 변환한 값 리턴|
|static int parseInt(String s, int radix)|문자열 s를 지정된 진법의 정수로 변환한 값 리턴|
|static String toString(int t)|정수 i를 문자열로 변환하여 리턴|

#### ● Wrapper 객체에 들어 있는 기본 타입 값 알아내기

* Wrapper 객체에 들어 있는 기본 타입의 값을 알아내기 위해 다음 코드를 이용

```JAVA
    Integer i = Integer.valueOf(10);
    int ii = i.intValue(); // ii = 10
```

#### ● 문자열을 기본 타입으로 변환

* Wrapper 클래스는 다음과 같이 문자열을 기본 타입의 값으로 변환하는 메소드를 제공

```JAVA
    int i = Integer.parseInt("123"); // i = 123
```

* parseInt(), parseBoolean() 등 메소드는 모두 static 타입이므로 Wrapper 클래스의 이름으로 바로 메소드를 호출함
* Wrapper 클래스는 해당 타입으로 변환하는 메소드만을 제공함
* 예를 들어 Integer 클래스는 parseBoolean(), parseDouble()은 제공하지 않음

#### ● 기본 타입 값을 문자열로 변환

```JAVA
    String s1 = Integer.toString(123); // 정수 123을 문자열 "123"으로 변환
```

### 박싱(boxing)과 언박싱(unboxing)

* 기본 타입의 값을 Wrapper 객체로 변환하는 것을 박싱(boxing)이라 하고, 반대의 경우를 언박싱(unboxing)이라고 함

```JAVA
    Integer ten = Integer.valueOf(10);    // boxing
    int n = ten.intValue();               // unboxing
```

* 박싱과 언박싱은 JDK 1.5부터 자동으로 이루어지며, 이를 자동 박싱 및 자동 언박싱(auto -)이라고 부름

```JAVA
    Integer ten = 10; // auto boxing -> Integer ten = Integer.valueOf(10);로 자동 처리됨
    int n = ten;      // auto unboxing -> int n = ten.intValue();로 자동 처리됨
```

## 6.8 String 클래스

### String의 특징과 객체 생성

* java.lang 패키지에 포함된 클래스로서 String 클래스는 문자열을 나타냄
* 스트링 리터럴은 자바 컴파일러에 의해 모두 String 객체로 처리됨
* String 클래스는 다양한 생성자를 통해 여러 방법으로 String 객체를 생성할 수 있게 함
  
|생성자|설명|
|---|---|
|String()|빈 스트링 객체 생성|
|String(char[] value)|char 배열에 있는 문자들을 스트링 객체로 생성|
|String(String original)|매개변수로 주어진 문자열과 동일한 스트링 객체 생성|
|String(StringBuffer buffer)|매개변수로 주어진 스트링 버퍼의 문자열을 스트링 객체로 생성|

```JAVA
    // 스트링 리터럴로 String 객체 생성
    String str1 = "abcd";

    // String 클래스의 생성자를 이용하여 String 객체 생성
    char[] data = {'a', 'b', 'c', 'd'};
    String str2 = new String(data);
    String str3 = new String("abcd"); // str2와 str3는 모두 "abcd" 문자열
```

#### ● 스트링 리터럴과 new String()

* 문자열을 다루는 데에 있어 중요한 점은, 스트링 리터럴과 new String()으로 생성된 스트링 객체가 서로 다르게 관리된다는 점
* 스트링 리터럴은 자바 내부에서 리터럴 테이블로 특별히 관리하여, 동일한 리터럴을 공유시킴
* 하지만 new String()으로 생성된 스트링은 new를 이용하여 생성되는 다른 객체와 동일하게 힙 메모리에 생성됨

```JAVA
    String a = "Hello";
    String b = "Java";
    String c = "Hello";

    String d = new String("Hello");
    String e = new String("Java");
    String f = new String("Java");
```

* 스트링 리터럴 "Hello"와 "Java"는 JVM의 스트링 리터럴 테이블에 생성되며 각각 a, b가 가리키고, c는 리터럴 테이블에서 a와 "Hello"를 공유함
* 그러나 new String()에 의해 생성된 스트링 객체 d, e, f는 모두 힙 메모리에 독립적으로 생성됨
* 리터럴을 공유시키는 이유는 스트링을 생성하는 실행 시간을 줄이기 위함

#### ● 스트링 객체는 수정이 불가능하다

* 또 한 가지 중요한 것으로서, 리터럴이든 new String()으로 생성했든, 일단 생성된 스트링 객체는 수정이 불가능함

```JAVA
    String s = new String("Hello");
    String t = s.concat("Java"); // 스트링 s에 "Java"를 덧붙인 새로운 스트링 객체 리턴
```

* 위 코드의 실행 결과는 "HelloJava"를 리턴하는 t
* 하지만 s는 변함없이 "Hello" 그대로
* 한번 만들어진 스트링은 수정이 불가능하기 때문에, 스트링이 공유되어도 문제가 발생하지 않음

### String 활용

* 스트링은 자바에서 많이 사용되므로 String 클래스의 활용은 중요함
* String 클래스의 주요 메소드

|메소드|설명|
|---|---|
|char charAt(int index)|index 인덱스에 있는 문자 값 리턴|
|int codePointAt(int index)|index 인덱스에 있는 유니코드 값 리턴|
|int compareTo(String anotherString)|두 스트링을 사전 순으로 비교하여 두 스트링이 같으면 0, 현 스트링이 anotherString보다 먼저 나오면 음수, 아니면 양수 리턴|
|String concat(String str)|현재 스트링 뒤에 str 스트링을 덧붙인 새로운 스트링 리턴|
|boolean contains(CharSequence s)|s에 지정된 문자들을 포함하고 있으면 true 리턴|

## 6.9 StringBuffer 클래스

### StringBuffer의 생성과 특징

* StringBuffer 클래스도 java.lang 패키지에 포함되어 있음
* String클래스와 같이 문자열을 다룸
* String 객체와 달리 StringBuffer 객체는 저장된 문자열의 수정이 가능함 <- 문자열을 저장하는 가변 버퍼를 가지고 있기 때문
* 문자열의 크기가 늘어나면 내부 버퍼의 크기를 자동 조절

|생성자|설명|
|---|---|
|StringBuffer()|초기 버퍼의 크기가 16인 스트링 버퍼 객체 생성|
|StringBuffer(charSequence seq)|seq가 지정하는 일련의 문자들을 포함하는 스트링 버퍼 생성|
|StringBuffer(int capacity)|지정된 초기 크기를 갖는 스트링 버퍼 객체 생성|
|StringBuffer(String str)|지정된 스트링으로 초기화된 스트링 버퍼 객체 생성|

### StringBuffer의 활용

* StringBuffer 클래스는 문자열에 대한 다양한 조작을 할 수 있는 메소드를 제공함
* 문자열의 길이가 길거나 문자열이 수시로 변하는 경우 StringBuffer 클래스를 이용하는 것이 적합함

|메소드|설명|
|---|---|
|StringBuffer append(String str)|str 스트링을 스트링 버퍼에 덧붙임|
|StringBuffer append(StringBuffer sb)|sb 스트링 버퍼를 현재의 스트링 버퍼에 덧붙임 -> 그 결과 현재 스트링 버퍼의 내용이 변함|
|int capacity()|스트링 버퍼의 현재 크기 리턴|
|StringBuffer delete(int start, int end)|start 위치에서 end 위치 앞까지 부분 문자열 삭제|
|StringBuffer insert(int offset, String str)|str 스트링을 스트링 버퍼의 offset 위치에 삽입|
|StringBuffer replace(int start, int end, String str)|스트링 버퍼 내의 start 위치의 문자부터 end가 지정하는 문자 앞의 서브 스트링을 str로 대치|
|StringBuffer reverse()|스트링 버퍼 내의 문자들을 반대 순서로 변경|
|void setLength(int newLength)|스트링 버퍼 내 문자열 길이를 newLength로 재설정 -> 현재 길이보다 큰 경우 널 문자('')로 채우며 작은 경우는 기존 문자열이 잘림|

## 6.10 StringTokenizer 클래스

### StringTokenizer의 생성과 특징

* StringTokenizer 클래스는 java.lang 패키지에 포함되어 있으며, 하나의 문자열을 여러 개의 문자열로 분리하기 위해 사용됨
* 문자열을 분리할 때 사용되는 기준 문자를 구분 문자(delimiter)라고 하고, 구분 문자로 분리된 문자열을 토큰(token)이라고 함
* String 클래스의 split() 메소드를 이용하여 문자열을 분리하도록 권해짐

```JAVA
    String query = "name=kitae&addr=seoul&age=21";
    StringTokenizer st = new StringTokenizer(query, "&");

    // "name=kitae", "addr=seoul", "age=21" -> 세 토큰으로 분리

    StringTokenizer st2 = new StringTokenizer(query, "&="); // '&'와 '=' 모두 구분 문자로 사용
    
    // "name", "kitae", "addr", ... 등 여섯 토큰으로 분리

    int count = st.countTokens(); // 몇 개의 토큰으로 분리되었는지 확인

    String token = st.nextToken(); // 토큰을 하나씩 얻음
```

|생성자|설명|
|---|---|
|StringTokenizer(String str)|str 스트링의 각 문자를 구분 문자로 문자열을 분리하는 스트링 토크나이저 생성|
|StringTokenizer(String str, String delim)|str 스트링과 delim 구분 문자로 문자열을 분리하는 스트링 토크나이저 생성|
|StringTokenizer(String str, String delim, boolean returnDelims)|str 스트링과 delim 구분 문자로 문자열을 분리하는 스트링 토크나이저 생성, returnDelims가 true이면 delim이 포함된 문자도 토큰에 포함됨|

|메소드|설명|
|---|---|
|int countTokens()|스트링 토크나이저가 분리한 토큰의 개수 리턴|
|boolean hasMoreTokens()|스트링 토크나이저에 다음 토큰이 있으면 true 리턴|
|String nextToken()|스트링 토크나이저에 들어 있는 다음 토큰 리턴|

## 6.11 Math 클래스

### Math의 특징

* Math 클래스는 java.lang 패키지에 포함되어 있으며 기본적인 산술 연산을 제공함
* 모든 멤버 메소드는 static 타입이므로 다음과 같이 클래스 이름으로 바로 사용하면 됨

```JAVA
    double d = Math.random();
    double pi = Math.PI;
```

### Math 클래스를 활용한 난수 발생

* Math 클래스에서 가장 많이 사용하는 메소드는 난수를 발생하는 random()
* random()은 0.0보다 크거나 같고 1.0보다 작은 임의의 double 값을 리턴함

```JAVA
    for(int x=0, x<10; x++) {
        int n = (int)(Math.random()*100 + 1); // n은 [1~100] 사이의 랜덤 정수
        System.out.println(n);
    }
    // random()을 이용하여 1에서 100까지(100 포함)의 정수 난수를 10개 출력
```

* java.util.Random 클래스를 활용해도 난수를 발생할 수 있음
  
```JAVA
    Random r = new Random();
    int n = r.nextInt(); // 음수, 양수, 0을 포함하여 자바의 정수 범위(-2^31 ~ 2^31 - 1)의 난수 발생
    int m = r.nextInt(100); // 0~99(0과 99 포함)의 정수 난수 발생
```

## 6.12 Calendar 클래스

### Calendar 클래스의 특징

* Calendar 클래스는 java.util 패키지에 있는 추상 클래스
* 년, 월, 일, 요일, 시간, 분, 초, 밀리초까지 프로그램이 실행되는 동안 개발자가 기억하고자 하는 시간과 날짜 정보를 저장함
* set(), get() 메소드를 이용하여 날짜나 시간을 알아내거나 설정함

|필드|의미|
|---|---|
|YEAR|년도|
|DAY_OF_MONTH|한 달의 날짜|
|MONTH|달(0~11)|
|DAY_OF_WEEK|한 주의 요일|
|HOUR|시간(0~11)|
|AM_PM|오전인지 오후인지 구분|
|HOUR_OF_DAY|24시간을 기준으로 한 시간|
|MINUTE|분|
|SECOND|초|
|MILLISECOND|밀리초|

* 주의할 점은 Calendar로 컴퓨터의 현재 시간을 알아낼 수는 있지만, Calendar 객체에 날짜와 시간을 설정한다고 해서 현재 컴퓨터의 시간을 바꾸지는 못한다는 점
* 개발자는 프로그램 실행 동안에 자신이 기억하고 싶은 날짜와 시간을 관리하기 위해 Calendar 객체를 이용할 뿐

### Calendar 객체 생성 - 현재 날짜와 시간

* Calendar 클래스는 추상 클래스이므로, new Calendar()를 사용하지 않고 getInstance() 메소드를 통해 다음과 같이 Calendar 객체를 생성함

```JAVA
    Calendar now = Calendar.getInstance();
```

* getInstance()가 리턴한 now 객체는 현재 날짜와 시간 정보를 가짐
* now를 이용하여 현재의 년도와 달, 시간 정보를 알아낼 수 있음

### 날짜와 시간 알아내기

* Calendar 객체에서 날짜와 시간을 알아내기 위해서는 get() 메소드에 YEAR 등 필드를 이용함

```JAVA
    int year = now.get(Calendar.YEAR); // 현재 년도
    int month = now.get(Calendar.MONTH) + 1; // 현재 달
```

### 날짜와 시간 설정하기

* set() 메소드는 Calendar 객체에 날짜와 시간을 설정하는 메소드

```JAVA
    Calendar firstDate = Calendar.getInstance();
    firstDate.clear(); // 헌재 날짜와 시간 정보를 모두 지움
    firstDate.set(2016, 11, 25); // 2016년 12월 25일. 12월은 11로 설정함에 유의
    firstDate.set(Calendar.HOUR_OF_DAY, 20); // 저녁 8시로 설정
    firstDate.set(Calendar.MINUTE, 30); // 30분으로 설정
```