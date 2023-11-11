package me.OpenChallenge5;

class Pen {
    private int amount;

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class InkPen extends Pen {
    private String color;

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

class SharpPencil extends Pen {
    private int width;

    public SharpPencil(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
}

class BallPen extends InkPen {

}

class FountainPen extends InkPen {
    public void refill(int n) {
        setAmount(n);
    }
}

public class InheritanceEx {
    SharpPencil sharpPencil = new SharpPencil(3);
    BallPen ballPen = new BallPen();
    FountainPen fountainPen = new FountainPen();
}
