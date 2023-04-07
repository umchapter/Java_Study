package me.chapter4;

public class Book2 {
    String title;
    String author;

    void show() {
        System.out.println(title + " " + author);
    }

    public Book2() {
        this("", ""); // 생성자가 다른 생성자를 호출할 때 사용하는 코드 -> 가장 아래의 2개 인자 받는 생성자 호출
        System.out.println("생성자 호출됨");
    }
    
    public Book2(String title) { // 두 개 인자 받는 생성자 호출해서 this()를 통해 title과 author 값 넣어줌
        this(title, "작자미상");
    }

    public Book2(String title, String author) {
        this.title = title; // this는 객체 자신에 대한 레퍼런스
        this.author = author;
    }

    public static void main(String[] args) {
        Book2 littlePrince = new Book2("어린왕자", "생텍쥐페리");
        Book2 loveStory = new Book2("춘향전");
        Book2 emptyBook = new Book2(); // 생성자 호출됨
        loveStory.show();
    }
}
