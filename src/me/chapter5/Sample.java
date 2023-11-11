package me.chapter5;

class SuperObject {
    public void paint() {
        draw();
    }
    public void draw() {
        System.out.println("Super Object");
    }
}

class SubOject extends SuperObject {
    @Override
    public void paint() {
        super.draw();
    }
    @Override
    public void draw() {
        System.out.println("Sub Object");
    }
}

public class Sample {
    public static void main(String[] args) {
        SuperObject b = new SubOject(); // 업캐스팅
        // paint() 메소드가 두개 존재 -> 오버라이딩 된 SubObject의 paint() 선택
        // -> 메소드에 의해 super.draw() 실행 -> Super Object
        b.paint();

        SubOject c = new SubOject();
        // paint() 메소드 하나만 존재 -> super.draw() 불러옴.
        c.paint();

        
    }
}
