package me.OpenChallenge4;

class TV {
    String brand;
    int year, size;
    
    protected TV(String brand, int year, int size) {
        this.brand = brand;
        this.year = year;
        this.size = size;
    }

    protected void show() {
        System.out.printf("%s에서 만든 %d년형 %d인치 TV", brand, year, size);
    }
}

public class TvClassPractice {
    public static void main(String[] args) {
        TV myTv = new TV("LG", 2017, 32);
        myTv.show();
    }
}
