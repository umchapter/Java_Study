package me.OpenChallenge5;

class IPTV extends ColorTV {
    String IP;
    public IPTV(String IP, int size, int color) {
        super(size, color);
        this.IP = IP;
    }
    @Override
    public void printProperty() {
        System.out.printf("나의 IPTV는 %s 주소의 ", IP);
        super.printProperty();
    }
}

public class ExerciseNo2 {
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
