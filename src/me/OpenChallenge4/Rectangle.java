package me.OpenChallenge4;

public class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.printf("(%d, %d)에서 크기가 %dx%d인 사각형", x, y, width, height);
        System.out.println("");
    }

    public boolean container(Rectangle rect) {
        boolean result = false;

        if((x+width >= rect.x+rect.width) && (y+height >= rect.y+rect.height)) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if(t.container(r)) System.out.println("t는 r을 포함합니다.");
        if(t.container(s)) System.out.println("t는 s를 포함합니다.");
    }
}
