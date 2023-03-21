package com.test.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface // Annotation
interface MyLambdaFunction{
    int sum(int a, int b);
}

@FunctionalInterface
interface MyPrint{
    String printLambda();
}

public class LambdaExam {
    public static void main(String[] args) {
        
        // 2개의 인자를 받아서 메소드로 계산 후 반환하는 익명함수 선언
        MyLambdaFunction myLambdaFunction = (int a, int b) -> a + b;
        System.out.println("myLambdaFunction.sum(4, 5) = " + myLambdaFunction.sum(4, 5));

        // 인자 없이 결과 값을 반환
        MyPrint myPrint = () -> "Hello World!";
        System.out.println("myPrint.printLambda() = " + myPrint.printLambda());

        // 1. Supplier : 매개변수 없이 반환값만 갖는 함수형 인터페이스 사용
        Supplier<String> supplier = () -> "안녕하세요";
        System.out.println("supplier.get() = " + supplier.get());

        // 2. Consumer : 객체 T를 매개변수로 받아서 사용하고 반환값은 없는 함수형 인터페이스
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
        consumer.accept("금 김 곰"); // 리턴 값이 없고, 람다 식에서 System.out.println 사용했으므로 바로 쓰면 됨.

        consumer.andThen(System.out::println).accept("박 북 벽"); // 메소드 참조에 대한 람다 표기법

        // 3. Function : 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스
        Function<String, Integer> function = s -> s.length();
        System.out.println("function.apply(\"Kim Chiman\") = " + function.apply("Kim Chiman"));

        // 4. Predicate : 객체 T를 매개변수로 받아서 처리한 후 Boolean 타입으로 반환하는 함수형 인터페이스
        Predicate<String> predicate = strng -> strng.equals("Hello World");
        System.out.println("predicate.test(\"Hello World\") = " +predicate.test("Hello World"));
        System.out.println("predicate.test(\"Hello My World\") = " +predicate.test("Hello My World"));
    }
}
