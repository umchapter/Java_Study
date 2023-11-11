package me.OpenChallenge5;

class TV {
    private int size;
    public TV(int size) {
        this.size = size;
    }
    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;
    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }
    public void printProperty() {
        System.out.printf("%d인치 %d컬러", getSize(), color);
    }
}

public class ExerciseNo1 {
    public static void main(String[] args) {
        ColorTV colorTV = new ColorTV(32, 1024);
        colorTV.printProperty();
    }
}
