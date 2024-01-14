# 제네릭과 컬렉션

## 7.1 컬렉션과 제네릭

### 컬렉션의 개념

* 컬렉션(collection)은 안드로이드를 비롯한 자바 프로그램을 작성하는데 빼놓을 수 없는 중요한 도구.
* 자바의 JDK는 다양한 자료 구조들을 컬렉션으로 만들어 제공
* 또한 컬렉션은 제네릭(generics)이라는 기법으로 구현되어 있기 때문에 컬렉션을 공부하기 위해서는 제네릭에 대한 공부도 필요
* 예를 들어, 배열은 여러 개의 데이터를 다루는 데 편리한 자료구조이지만, 삽입 삭제가 빈번하고, 데이터의 크기를 예측할 수 없는 응용프로그램에서 사용하기에는 불편함
* 즉, 전화번호부 관리 프로그램과 같이 많은 사람의 이름과 전화번호가 저장되고 삽입 삭제가 빈번한 경우나, 선, 원, 타원, 사각형 등 빈번한 도형 생성과 삭제를 관리하는 그래픽 편집기 등은 고정 크기 배열을 사용할 경우 상당한 어려움에 직면
* 컬렉션은 배열이 가진 고정 크기의 단점을 극복하기 위해 객체들을 쉽게 삽입, 삭제, 검색할 수 있는 가변크기의 컨테이너(container)
  
|배열(array)|컬렉션(collection)|
|---|---|
|고정 크기 이상의 객체를 관리할 수 없음|가변 크기로서 객체의 개수를 염려할 필요가 없음|
|배열의 중간에 객체가 삭제되면 응용프로그램에서 자리를 옮겨야 함| 컬렉션 내의 한 객체가 삭제되면 컬렉션이 자동으로 자리를 옮겨줌|

### 컬렉션을 위한 자바 인터페이스와 클래스

* java.util 패키지는 다양한 컬렉션 인터페이스와 컬렉션 클래스를 제공
* 컬렉션 클래스는 개발자가 바로 사용할 수 있는 것들로서, Vector\<E>와 ArrayList\<E>는 가변 크기의 배열을 구현하며, LinkedList\<E>는 노드들이 링크로 연결되는 리스트를 구현
* Stack\<E>는 스택을 구현하며, HashSet\<E>는 집합을 구현
* 이들은 모두 Collection\<E>를 상속받고, 단일 클래스의 객체만을 요소로 다루는 공통점이 있음
* 이와 달리 HashMap<K, V>는 '키(K)'와 '값(V)'의 쌍으로 이루어지는 데이터를 저장하고, '키'로 쉽게 검색하도록 만든 컬렉션

### 컬렉션의 특징

* 컬렉션의 중요한 특징은 다음과 같음
  
1. 컬렉션은 제네릭(genrics)이라는 기법으로 만들어져 있음
   * 컬렉션 클래스의 이름에는 \<E>, \<K>, \<V> 등이 항상 포함됨
   * 이들은 '타입 매개 변수'라고 하며, Vector\<E>에서 E 대신 Integer와 같이 구체적인 타입을 지정하면, Vector\<Integer>라는 정수 값만 저장하는 벡터로, Vector\<String>은 문자열만 저장하는 벡터로 사용할 수 있음
   * 특정 타입만 다루지 ㅇ낳고 여러종류의 타입으로 변신할 수 있도록, 컬렉션을 일반화시키기 위해 \<E>를 사용하는 것
   * 그러므로 E를 일반화시킨 타입 혹은 제네릭 타입(generic type)이라고 부름
   * 컬렉션은 여러 타입의 값을 다룰 수 있도록 변신이 가능한 자료 구조이지만, 컬렉션을 사용할 때는 지정된 특정 타입의 값만 저장 가능
2. 컬렉션의 요소는 객체들만 가능함
   * int, char, double 등의 기본 타입의 데이터는 원칙적으로 컬렉션의 요소로 불가능함
   * 하지만, 기본 타입의 값이 삽입되면 자동 박싱(auto boxing)에 의해 Wrapper 클래스 타입으로 변환되어 객체로 저장함

```JAVA
    Vector<int> v = new Vector<int>(); // 컴파일 오류. int는 사용 불가
    Vector<Integer> v = new Vector<Integer>(); // 정상 코드
```

### 제네릭의 기본 개념

* 제네릭(generics)은 JDK 1.5 버전부터 도입됨
* 제네릭은 모든 종류의 타입을 다룰 수 있도록, 클래스나 메소드를 타입 매개변수(generic type)를 이용하여 선언하는 기법
* 자바의 제네릭은 C++의 템플릿(template)과 동일함
* 템플릿이란 '형판'
* 자바의 제네릭은 클래스 코드를 찍어내듯이 생산할 수 있도록 일반화(generic) 시키는 도구
* Stack\<E>에서 E에 구체적인 타입을 지정하면, 지정된 타입만 다룰 수 있는(push, pop) 구체화된(specialized) 스택이 됨

### 제네릭 타입 매개변수

* 컬렉션 클래스에서 타입 매개변수로 사용하는 문자는 다른 변수와 혼동을 피하기 위해 일반적으로 하나의 대문자를 사용

|관례적으로 사용되는 문자|의미|
|---|---|
|E|Element를 의미하며 컬렉션에서 요소임을 나타냄|
|T|Type을 의미|
|V|Value를 의미|
|K|Key를 의미|

### 7.1의 여담

* 2000년도 초반부터 제네릭 프로그래밍(generic programming)이라는 새로운 프로그래밍 패러다임이 도입됨
* 동일한 프로그램 코드에 다양한 데이터 타입을 적용할 수 있도록 클래스와 함수들을 일반화시켜 제네릭 함수와 제네릭 클래스를 만들고, 제네릭 함수나 제네릭 클래스에 개발자가 원하는 데이터 타입으로 구체화시켜 함수나 클래스의 프로그램 코드를 틀에서 찍어내는 듯이 생산하는 기법
* C++의 경우 제네릭은 템플릿(template)으로도 불리는데, 2003년 C++ 표준위에서는 입출력 라이브러리를 모두 제네릭 클래스와 제네릭 함수로 표준화함
* 자바의 컬렉션에 해당하는 컨테이너, 알고리즘 등을 일반화시킨 라이브러리를 STL(Standard Template Library)로 제공하는 등 대부분의 C++ 라이브러리는 제네릭으로 구성됨
* 자바는 뒤이어 2004년 JDK 1.5 beta 버전부터 제네릭을 도입
* 제네릭은 현재, 자바뿐만 아니라 C++, C#, VB, Delphi 등 다양한 언어에 도입되어 있으며, 점점 그 사용이 확산되고 있음
* 스택, 큐, 리스트, 링크드 리스트, 벡터, 해시맵, 셋(set) 등 웬만한 자료 구조나 알고리즘은 대부분의 언어에서 제네릭으로 구현되어 있음

## 7.2 제네릭 컬렉션 활용

### Vector\<E>

* Vector\<E>는 배열을 가변 크기로 다룰 수 있게 하고, 객체의 삽입, 삭제, 이동이 쉽도록 구성한 컬렉션 클래스
* 벡터는 삽입되는 요소의 개수에 따라 자동으로 크기를 조절하고, 요소의 삽입과 삭제에 따라 자동으로 요소들의 자리를 이동함

#### ● 벡터 생성

* 벡터를 생성할 때, Vector\<E>의 E에 요소로 사용할 타입을 지정해야 함

```JAVA
    Vector<Integer> v = new Vector<Integer>(); // Integer 타입 지정
```

* 레퍼런스 변수 선언과 벡터 생성을 분리하여 코드를 만들 수 있으며, 문자열만 다루는 벡터는 다음과 같이 생성할 수 있음

```JAVA
    Vector<String> stringVector;         // 제네릭 컬렉션에 대한 레퍼런스 변수 선언
    stringVector = new Vector<String>(); // 문자열 벡터 생성
```

* Vector\<E>에서 E에 구체적인 타입을 지정하지 않고 Vector로만 사용하면, 컴파일러가 raw type 경고 메세지 출력
* 개발자는 생성된 벡터의 용량을 굳이 알 필요가 없음
* 컬렉션은 자신의 용량을 스스로 조절하기 때문
* 만일, 용량을 초기에 설정하고자 한다면 다음과 같이 생성자에 용량을 지정하면 됨

```JAVA
    Vector<Integer> v = new Vector<Integer>(5); // 초기 용량이 5인 벡터 생성
```

* 벡터 클래스의 주요 메소드

|메소드|설명|
|---|---|
|boolean add(E element)|벡터의 맨 뒤에 element 추가|
|void add(int index, E elemnt)|index에 element를 삽입|
|int capacity()|벡터의 현재 용량 리턴|
|boolean addAll(Collection<? extends E> c)|컬렉션 c의 모든 요소를 벡터의 맨 뒤에 추가|
|void clear()|벡터의 모든 요소 삭제|
|boolean contains(Object o)|벡터가 지정된 객체 o를 포함하고 있으면 true 리턴|
|E elementAt(int index)|index의 요소 리턴|
|E get(int index)|index의 요소 리턴|
|int indexOf(object o)|o와 같은 첫 번째 요소의 인덱스 리턴, 없으면 -1 리턴|
|E remove(int index)|index의 요소 삭제|
|boolean remove(Object o)|객체 o와 같은 첫 번째 요소를 벡터에서 삭제|
|void removeAllElements()|벡터의 모든 요소를 삭제하고 크기를 0으로 만듦|
|int size()|벡터가 포함하는 요소의 개수 리턴|
|Object[] toArray()|벡터의 모든 요소를 포함하는 배열 리턴|

#### ● 벡터에 요소 삽입

* add() 메소드를 이요하면 벡터의 끝이나 중간에 요소를 삽입할 수 있음

```JAVA
    v.add(Integer.valueOf(5)); // 정수를 Integer 객체로 만들어 삽입
    v.add(5); // 5 -> new Integer(5)로 자동 박싱됨
```

* 자동 박싱에 의해 int 타입의 정수는 자동으로 Integer 객체로 변환되어 삽입됨
* 그러나 벡터 v에는 Integer 외의 다른 타입의 객체를 삽입할 수 없음

```JAVA
    v.add("hello"); // 컴파일 오류
    v.add(3.5);     // 컴파일 오류
```

* 벡터에는 null 도 삽입할 수 있기 때문에 벡터를 검색할 때 null이 존재할 수 있음을 염두에 두어야 함

```JAVA
    v.add(null); // null 삽입 가능
```

* add()를 이용하여 벡터의 중간에 객체를 삽입할 수 있음

```JAVA
    v.add(2, 100); // 인덱스 2의 위치에 정수 100을 삽입
```

#### ● 벡터 내의 요소 알아내기

* 벡터 내에 존재하는 요소를 알아내기 위해서는 get()이나 elementAt() 메소드를 이용

```JAVA
    Integer obj = v.get(1); // 벡터의 1번째 Integer 객체를 얻어냄
    int i = obj.intValue(); // obj에 있는 정수를 알아냄

    // 위의 코드 단순화
    int i = v.get(1); // 자동 언박싱
```

#### ● 벡터의 크기와 용량 알아내기

* size(), capacity()
* capacity와 size 구별 필요 -> capacity는 총 용량 / size는 현재 크기
* 따라서 현재 크기보다 큰 위치에 삽입 불가능 -> 맨 뒤에 추가는 가능

#### ● 벡터에서 요소 삭제

* remove()

```JAVA
    v.remove(1); // 인덱스 1의 위치에 있는 요소 삭제

    Integer m = Integer.valueOf(100); // m은 객체 레퍼런스
    v.add(m);
    ...
    v.remove(m); // 레퍼런스 m의 요소 삭제
```

* removeAllElemets()

### 컬렉션과 자동 박싱/언박싱

* 컬렉션은 객체들만 요소(element)로 다룸
* 그러므로 기본 타입의 값은 Wrapper 클래스로 객체화하여 삽입함

```JAVA
    Vector<Integer> v = new Vector<Integer>();
    v.add(Integer.valueOf(4));
    v.add(Integer.valueOf(-1));
```

* 그러나 자동 박싱(auto boxing)에 의해 int 타입의 값을 사용하면 자동으로 Integer 객체로 변환되어 삽입됨

```JAVA
    v.add(4);  // 정수 4가 Integer(4)로 자동 박싱됨
    v.add(-1); // 정수 -1이 Integer(-1)로 자동 박싱됨
```

* 컬렉션으로부터 값을 얻어내는 과정에서는 자동 언박싱(auto unboxing)이 일어남

```JAVA
    int k = v.get(0); // k = 4
```

* 자동 박싱/언박싱은 모든 컬렉션 클래스에서 작동함

### 컬렉션을 매개변수로 받는 메소드 만들기

```JAVA
    // Integer 벡터를 매개변수로 받아 원소를 모두 출력하는 메소드
    public void printVector(Vector<Integer> v) {
        for(int i = 0; i < v.size(); i++) {
            int n = v.get(i); // 벡터의 i 번째 정수
            System.out.println(n);
        }
    }

    Vector<Integer> v = new Vector<Integer>();
    printVector(v); // 메소드 호출
```

### 자바의 타입 추론 기능의 진화, Java 7, Java 10

```JAVA
    // 제네릭 컬렉션을 사용하여 객체를 생성하는 전형적인 문법
    Vector<Integer> v = new Vector<Integer>(); // Java 7 이전
```

* Java 7 부터 제네릭의 객체 생성부의 <> 내(다이아몬드 연산자)에 타입 매개변수를 생략하면 컴파일러가 추론하여 타입 매개변수를 찾아주도록 함
  
```JAVA
    Vector<Integer> v = new Vector<>(); // Java 7 부터
```

* Java 10은 아예 var 키워드를 도입하여 컴파일러에게 변수타입을 추론하도록 하는 기능을 더함

```JAVA
    var v = new Vector<Integer>(); // Java 10 부터
```

### ArrayList\<E>

* ArrayList\<E>는 가변 크기의 배열을 구현한 컬렉션 클래스로서 경로명은 java.util.ArrayList이며, Vector 클래스와 거의 동일함
* 크게 다른 점은 ArrayList는 스레드 간에 동기화를 지원하지 않기 때문에, 다수의 스레드가 동시에 ArrayList에 요소를 삽입하거나 삭제할 때 ArrayList의 데이터가 훼손될 우려가 있음
* 하지만 멀티스레드 동기화를 위한 시간 소모가 없기 때문에, ArrayList는 Vector보다 속도가 빨라, 단일 스레드 응용에는 더 효과적
* add()를 이용하여 요소를 삽입하고, get()을 이용하여 요소를 검색

|메소드|설명|
|---|---|
|boolean add(E element)|ArrayList의 맨 뒤에 element 추가|
|void add(int index, E element)|인덱스 index 위치에 element 삽입|
|boolean addAll(Collection<? extends E> c)|컬렉션 c의 모든 요소를 ArrayList의 맨 뒤에 추가|
|void clear()|ArrayList의 모든 요소 삭제|
|boolean contains(Object o)|ArrayList가 지정된 객체를 포함하고 있으면 true 리턴|
|E elementAt(int index)|index 인덱스의 요소 리턴|
|E get(int index)|index 인덱스의 요소 리턴|
|int indexOf(Object o)|o와 같은 첫 번째 요소의 인덱스 리턴, 없으면 -1 리턴|
|boolean isEmpty()|ArrayList가 비어있으면 true 리턴|
|E remove(int index)|index 인덱스의 요소 삭제|
|boolean remove(Object o)|o와 같은 첫 번째 요소를 ArrayList에서 삭제|
|int size()|ArrayList가 포함하는 요소의 개수 리턴|
|Object[] toArray()|ArrayList의 모든 요소를 포함하는 배열 리턴|

#### ● ArrayList에 요소 삽입

```JAVA
    var a = new ArrayList<String>();

    a.add(null); // ArrayList도 Vector와 마찬가지로 null을 삽입할 수 있음

    a.add(2, "Sahni"); // add()는 끝이나 중간에만 요소를 삽입하므로, ArrayList에 들어있는 요소의 개수가 2보다 작으면 예외 발생
```

#### ● ArrayList의 크기 알아내기

* ArrayList는 벡터와 달리 현재 용량을 리턴하는 메소드가 없음

```JAVA
    int len = a.size(); // ArrayList에 들어 있는 요소의 개수
```

### 컬렉션의 순차 검색을 위한 Iterator

* Vector, ArrayList, LinkedList, Set과 같은 요소가 순서대로 저장된 컬렉션에서 요소를 순차 검색할 때, java.util 패키지의 Iterator\<E> 인터페이스를 사용하면 편리함
* 여기서 \<E>에는 컬렉션의 매개변수와 동일한 타입을 지정해야 함

```JAVA
    Vector<Integer> v = new Vector<>();
    Iterator<Integer> it = v.iterator(); // 벡터 v의 요소를 순차 검색할 Iterator 객체 리턴

    while(it.hasNext()) { // it로 벡터의 끝까지 반복
        int n = it.next(); // it가 가리키는 요소 리턴. it의 요소 타입은 Integer이므로 정수 리턴
        ...
    }
```

|메소드|설명|
|---|---|
|boolean hasNext()|방문할 요소가 남아 있으면 true 리턴|
|E nex()|다음 요소 리턴|
|void remove()|마지막으로 리턴된 요소 제거|

### HashMap<K, V>

* HashMap<K, V> 컬렉션은 경로명이 java.util.HashMap이며, '키(key)'와 '값(value)'의 쌍으로 구성되는 요소를 다룸
* K는 '키'로 사용할 데이터 타입을, V는 '값'으로 사용할 데이터 타입의 타입매개변수
* HashMap 객체의 내부 구성은 key 테이블과 value 테이블로 나누어짐
* 내부에 '키'와 '값'을 저장하는 자료구조를 가지고, put(), get() 메소드를 이용하여 요소를 삽입하거나 검색함
  
```JAVA
    HashMap<String, String> h = new HashMap<>(); // 해시맵 생성
    h.put("apple", "사과");         // "apple" 키와 "사과" 값의 쌍을 h에 삽입
    String kor = h.get("apple");    // "apple" 키로 값 검색. kor는 검색된 값, "사과"
```

* put(key, value) 메소드는 '키'와 '값'을 받아, '키'를 이용하여 해시 함수(hash function)를 실행하고 해시 함수가 리턴하는 위치에 '키'와 '값'을 저장함
* 반대로 get(key)은 다시 '키'를 이용하여 동일한 해시 함수를 실행하여 '값'이 저장된 위치를 알아내어 '값'을 리턴함
* 해시맵은 해시 함수를 통해 '키'와 '값'이 저장되는 위치를 결정하므로, 사용자는 그 위치를 알 수 없고, 삽입되는 순서와 들어 있는 위치 또한 관계가 없음

|메소드|설명|
|---|---|
|void clear()|해시맵의 모든 요소 삭제|
|boolean containsKey(Object key)|지정된 키(key)를 포함하고 있으면 true 리턴|
|boolean containsValue(Object value)|지정된 값(value)에 일치하는 키가 있으면 true 리턴|
|V get(Object key)|지정된 키(key)의 값 리턴, 키가 없으면 null 리턴|
|boolena isEmpty()|해시맵이 비어있으면 true 리턴|
|Set\<K> keySet()|해시맵의 모든 키를 담은 Set\<K> 컬렉션 리턴|
|V put(K key, V value)|key와 value 쌍을 해시맵에 저장|
|V remove(Object key)|지정된 키(key)를 찾아 키와 값 모두 삭제|
|int size()|해시맵에 포함된 요소의 개수 리턴|

#### ● 해시맵의 장단점

* 해시맵은 List\<E> 인터페이스를 상속받은 Vector\<E>나 ArrayList\<E>와는 다른 점이 있음
    1. 요소의 삽입, 삭제 시간이 매우빠름
       * 요소의 위치를 결정하는 해시 함수가 간단한 코드로 이루어짐
       * Vector\<E>나 ArrayList\<E>와 달리 요소의 삽입 삭제 시 다른 요소들의 위치 이동이 필요 없기 때문
    2. 요소 검색은 더욱 빠름
       * 해시맵의 get(key) 메소드가 호출되면 해시 함수가 key가 저장된 위치를 단번에 찾아내므로, Vector\<E>나 ArrayList\<E>에서처럼 모든 요소들을 하나씩 비교하는 시간 낭비가 전혀 없기 때문
    3. 하지만 해시맵은 인덱스를 이용하여 요소에 접근할 수 없고 오직 '키'로만 검색해야 함
* 그러므로 해시맵은 빠른 삽입과 검색이 필요한 응용에 적합

#### ● 해시맵의 전체 검색

```JAVA
    Set<String> key = h.keySet(); // 해시맵 h에 있는 모든 키를 Set 컬렉션으로 리턴
    Iterator<String> it = keys.iterator(); // Set의 각 문자열들을 순차 검색하는 Iterator 리턴
    while(it.hasNext()) {
        String key = it.next(); // 키
        String value = h.get(key); // 값
        System.out.println("(" + key + "," value + ")") // 키와 값의 쌍 출력
    }
```

### LinkedList\<E>

* LinkedList\<E>는 List\<E> 인터페이스를 구현한 클래스로서 경로명이 java.util.LinkedList임
* LinkedList의 요소들은 양방향으로 연결하여 관리한다는 점을 제외하고 Vector, ArrayList와 거의 같음
* LinkedList는 맨 앞과 맨 뒤를 가리키는 head, tail 레퍼런스를 가지고 있어, 맨 앞이나 맨 뒤, 중간에 요소의 삽입이 가능하며 인덱스를 이용하여 요소에 접근할 수도 있음
* add(), get()

### Collections 클래스 활용

* java.util 패키지에 포함된 Collections 클래스는 다음고 ㅏ같이 컬렉션을 다루는 유용한 여러 메소드를 지원함
  * sort() - 컬렉션에 포함된 요소들의 정렬
  * reverse() - 요소를 반대 순으로 정렬
  * max(), min() - 요소들의 최댓값과 최솟값 찾아내기
  * binarySearch() - 이진 검색
* Collections 클래스의 메소드는 모두 static 타입이므로 Collections 객체를 생성할 필요는 없음
* 이 유틸리티 메소드들은 인자로 컬렉션 객체를 전달받아 처리함

### 7.2의 여담

* 본래 Collections 클래스는 java.lang.Comparable을 상속받는 element에 대해서만 작동함
* int, char, double 등의 기본 타입과 String 클래스는 이 조건을 충족하지만, 사용자가 클래스를 작성하는 경우 java.lang.Comparable을 상속받아야 함

## 7.3 제네릭 만들기

### 제네릭 클래스

* 제네릭 클래스를 작성하는 방법은 기존의 클래스 작성 방법과 유사함
* 클래스 이름 다음에 일반화된 타입(generic type)의 매개변수를 <와 > 사이에 추가한다는 차이가 있음

#### ● 제네릭 클래스 작성

```JAVA
    public class MyClass<T> { // 제네릭 클래스 MyClass, 타입 매개변수 T
        T val; // 변수 val의 타입은 T
        void set(T a) {
            val = a; // T 타입의 값 a를 val에 지정
        }
        T get() {
            return val; // T 타입의 값 val 리턴
        }
    }
```

#### ● 제네릭 객체 생성 - 구체화(specialization)

* 제네릭 클래스에 구체적인 타입을 대입하여 구체적인 객체를 생성하는 과정을 구체화라고 부르며, 이는 자바 컴파일러에 의해 이루어짐

```JAVA
    MyClass<String> s = new MyClass<>();
    s.set("Hello");
    System.out.println(s.get()); // "Hello" 출력

    MyCalss<Integer> n = new MyClass<>();
    n.set(5);
    System.out.println(n.get()); // 숫자 5 출력
```

* 제네릭의 구체화에는 기본 타입은 사용할 수 없음 -> Wrapper 클래스 활용

#### ● 타입 매개변수

* 제네릭 클래스 내에서 제네릭 타입을 가진 객체의 생성은 허용되지 않음

```JAVA
    public class MyVector<E> {
        E create() {
            E a = new E(); // 컴파일 오류. 제네릭 타입의 객체 생성 불가
            return a;
        }
    }
```

* 컴파일러가 MyVector\<E> 클래스의 new E() 라인을 컴파일 할 때, E에 대한 구체적인 타입을 알 수 없어, 호출될 생성자를 결정할 수 없고, 또한 객체 생성 시 어떤 크기의 메모리를 할당해야 할 지 전혀 알 수 없기 때문
* MyStack.java 참고

### 제네릭과 배열

* 제네릭에서는 배열에 대한 제한을 두고 있음
* 제네릭 클래스 또는 인터페이스 타입의 배열은 선언할 수 없음

```JAVA
    GStack<Integer>[] gs = new GStack<Integer>[10]; // 컴파일 오류
```

* 그러나 제네릭 타입의 배열 선언은 허용됨

```JAVA
    public void myArray(T[] a) {...} // 정상
```

### 제네릭 메소드

* 클래스의 일부 메소드만 제네릭으로 구현할 수도 있음

```JAVA
    class GenericMethodEx {
        static <T> void toStack(T[] a, GStack<T> gs) {
            for (int i = 0; i < a.length; i++) {
                gs.push(a[i])
            }
        }
    }
```

* 타입 매개변수는 메소드의 리턴 타입 앞에 선언됨
* 위의 toStack()에서 \<T>가 타입 매개변수의 선언
* 제네릭 메소드를 호출할 때는 컴파일러가 메소드의 인자를 통해 타입을 유추할 수 있어 제네릭 클래스나 인터페이스와는 달리 타입을 명시하지 않아도 됨

```JAVA
    Object[] oArray = new Object [100];
    GStack<Object> objectStack = new GStack<>();
    GenericMethodEx.toStack(oArray, objectStack); // 타입 매개변수 T를 Object로 유추함

    String[] sArray = new String [100];
    GStack<String> stringStack = new GStack<>();
    GenericMethodEx.toStack(sArray, stringStack); // 타입 매개변수 T를 String으로 유추함

    GenericMethodEx.toStack(sArray, objectStack); // 이 경우는 타입 매개변수 T를 Object로 유추함 -> Object가 String의 슈퍼 클래스이기 때문
```

### 제네릭의 장점

* 제네릭은 다음과 같은 장점이 있음
  * 동적으로 타입이 결정되지 않고 컴파일 시에 타입이 결정되므로 보다 안전한 프로그래밍 가능
  * 런타임 타입 충돌 문제 방지
  * 개발 시 타입 캐스팅 절차 불필요
  * ClassCastException 방지
