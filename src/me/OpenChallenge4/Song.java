package me.OpenChallenge4;

public class Song {
    private String title;
    private String artist;
    private String year;
    private String country;

    public Song() {

    }

    public Song(String title, String artist, String year, String country) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }

    public void show() {
        System.out.printf("%s년 %s국적의 %s가 부른 %s", year, country, artist, title);
    }

    public static void main(String[] args) {
        Song dancingQueen = new Song("Dancing Queen", "ABBA", "1978", "스웨덴");

        dancingQueen.show();
    }
}
