package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExam01 {
    
    /* stream API 정의 및 등장 배경
     * 자바에서는 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션(Collect Framework)을 사용
     * 이렇게 저장된 데이터에 접근하기 위해서는 반복문이나 반복자를 사용하여 매번 새로운 코드를
     * 작성해야 함. 이렇게 작성된 코드는 길이가 길고 가독성이 떨어지며, 코드의 재사용이 불가능함.
     * 즉, 데이터베이스의 쿼리와 같이 정형화 된 처리 패턴을 가지지 못했기에 데이터마다 다른 방법으로 
     * 접근해서 작업을 했음. 이러한 문제점을 극복하기 위해 Java SE 8 부터 함수형 프로그램의 특성을 가진
     * stream 이라는 API(Application Program Interface, 여기서는 객체의 성격을 가짐)를 도입.
     * stream API는 정형적인 데이터 읽기/쓰기 메소드를 제공하므로 반복된 프로그램 작업 없이
     * 비교적 수월하게 프로그램을 작성할 수 있음.
     */

     /* Stream API의 특성
       1. 데이터 접근하여 읽기/쓰기/수정에 최적화된 메소드를 제공
       2. stream은 재사용이 가능한 컬렉션과 달리 단 한 번만 사용 -> 재사용 불가
       3. stream은 원본 데이터를 변경하지 않음.
       4. stream 연산은 filter-map 기반의 API를 사용하여 지연(lazy) 연산을 통해 성능을 최적화
       5. stream 연산은 병렬처리를 지원
      */
    
    /* Stream API의 동작 흐름
     * 데이터소스 -> 스트림 생성 -> 중개연산(필터) -> 중개연산(map) -> 최종연산(출력)
     */

    /* Stream API 예제
     * 1~10까지의 정수를 갖는 List에서 6보다 작고 짝수인 요소를 찾아 10배 시킨 리스트를 출력
     */
     public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // 1. 데이터 소스 생성
        list.stream() // 2. 스트림 생성
            .filter(i -> i < 6) // 3. 필터연산 : 6보다 작은 값들만 가져옴
            .filter(i -> i % 2 == 0) // 3. 필터 연산 : 짝수값만 가져옴
            .map(i -> i  * 10) // 4. map 연산 : 가져온 값에다 10을 곱함
            .collect(Collectors.toList()) // 5. 최종 연산 -> 출력
            .forEach(result -> System.out.print(result + "\t"));
        
    /* 1. 스트림 생성
    - 자바에서 제공하는 모든 컬렉션의 최상위 객체가 Collection 객체임
    - 이 Collection 인터페이스에는 stream() 메소드가 선언되어 있음
    - 따라서 Collection 인터페이스를 구현한 모든 List와 Set 컬렉션에서도 
    - stream() 메소드로 스트림을 생성할 수 있음.
    - 그리고 배열에서도 스트림을 생성할 수 있는데, 이 때는 Arrays 클래스를 이용함
    - 또한 기본 타입인 int, long, double 형에 대한 스트림 생성을 위한
    - IntStream, LongStream, DoubleStream 인터페이스가 존재함.
     */
        System.out.println("");
        List<Integer> list2 = new ArrayList<>();

        list2.add(4);
        list2.add(2);
        list2.add(3);
        list2.add(1);

        Stream<Integer> stream = list2.stream(); // 컬렉션에서 stream 객체 
        stream.forEach(System.out::println);

        // 배열로부터 스트림 생성
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        IntStream stream2 = Arrays.stream(arr); // 배열에서 stream 생성
        System.out.println("");
        stream2.forEach(System.out::println);

        // 가변매개변수
        Stream<Double> stream3 = Stream.of(4.2, 2.5, 3.1, 1.9);
        System.out.println("");
        stream3.forEach(System.out::println);

    /* 스트림 중개연산
    - 스트림 API에 의해 생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
    - 이러한 중개 연산은 스트림을 전달 받아 스트림을 반환하므로, 중개 연산은 연속으로 연결해서 사용 가능
    - 스트림의 중개 연산은 filter-map 기반의 API를 사용하고 lazy 연산을 통해 성능을 최적화 함
     1. 스트림 필터링 : filter(), distinct()
     2. 스트림 변환 : map(), flatMap()
     3. 스트림 제한 : limit(), skip()
     4. 스트림 정렬 : sorted()
     5. 스트림 연산 결과 확인 : peek()
     */
        System.out.println("");

        // 1. 스트림 필터링 : 스트림에서 중복된 요소를 제거하고 홀수만을 골라냄
        IntStream stream4 = IntStream.of(7,5,5,2,1,2,3,5,4,6,9,7,11,5,7,3,8,2,6,4,4);
        stream4.distinct()
               .filter(i -> i % 2 != 0)
               .forEach(System.out::println);
        
        System.out.println("");

        // 2-1. 스트림 변환 : 다음 각각의 문자열의 길이를 구하여 출력
        Stream<String> stream5 = Stream.of("HTML", "cSS", "JAVA", "JAVASCRIPT", "SQL");
        stream5.map(s -> s.length())
               .forEach(System.out::println);

        System.out.println("");

        // 2-2. 스트림 변환 : 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환
        String[] strings = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> stream6 = Arrays.stream(strings);
        stream6.flatMap(str -> Stream.of(str.split(" ")))
               .forEach(System.out::println);

        System.out.println("");

        // 3. 스트림 제한
        // limit() : 해당 스트림의 첫번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환
        // skip() : 해당 스트림의 첫번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지를 새로운 스트림으로 반환
        IntStream stream7 = IntStream.range(0, 10);
        IntStream stream8 = IntStream.range(0, 10);
        IntStream stream9 = IntStream.range(0, 10);

        stream7.skip(4)
               .forEach(n -> System.out.println(n + " "));
        System.out.println("");
        stream8.limit(5)
               .forEach(n -> System.out.println(n + " "));
        System.out.println("");
        stream9.skip(3)
               .limit(5)
               .forEach(n -> System.out.println(n + " "));

        System.out.println("");

        // 4. 스트림 정렬
        // 4-1. 오름차순(Ascending)
        Stream<String> stream10 = Stream.of("Park", "Kim", "Lee", "Choi");
        stream10.sorted().forEach(System.out::println);

        System.out.println("");

        // 4-2. 내림차순(Descending)
        // stream10.sorted(Comparator.reverseOrder()).forEach(System.out::println); // 스트림은 재사용 불가이므로 오류남
        Stream<String> stream11 = Stream.of("Park", "Kim", "Lee", "Choi");
        stream11.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        
    /* 스트림 최종 연산
     1. 요소의 출력 : forEach()
     2. 요소의 소모 : reduce() -> 첫번째와 두번째 요소를 가지고 연산을 수행한 뒤 그 결과와 세번째 요소를 가지고 또 다시 연산을 수행하고
                                 앞서 연산한 내용은 메모리에서 삭제
     3. 요소의 검색 : findFirst(), findAny()
     4. 요소의 검사 : anyMatch(), allMatch(), noneMatch()
     5. 요소의 통계 : count(), min(), max()
     6. 요소의 연산 : sum(), average()
     7. 요소의 수집 : collect() -> 스트림의 아이템들을 List 또는 Set 자료형으로 변환, 스트림의 아이템들을 joining
     */

        System.out.println("");
        LongStream stream12 = LongStream.range(1, 21);
        stream12.reduce((i, j) -> i * j).ifPresent(System.out::println);

        System.out.println("");
        
        // or        
        Stream<Integer> stream13 = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> sum1 = stream13.reduce((i, j) -> i + j);
        sum1.ifPresent(n -> System.out.println("sum of 1 to 10 = " + n));

        System.out.println("");

        // collect 메소드
        Stream<String> fruits = Stream.of("banana", "apple", "mango", "peach");
        String result = fruits
                            // .map(Object::toString)
                            .collect(Collectors.joining(","));
                            // .map(Object::toString) -> 클래스 내부의 메소드를 적용
        System.out.println(result);

        System.out.println("");

        // 열거된 문자열 중에 a를 포함한 단어를 출력
        Stream<String> stream14 = Stream.of("qqq", "aaa", "baba", "cecdfe");
        System.out.println(stream14.filter(n -> n.contains("a")).collect(Collectors.joining(",")));

        System.out.println("");

        // 열거된 문자열을 모두 대문자로 바꿔 보세요
        Stream<String> fruits2 = Stream.of("banana", "apple", "mango", "peach");
        System.out.println(fruits2.map(str -> str.toUpperCase()).collect(Collectors.joining(",")));

        System.out.println("");
    }
}