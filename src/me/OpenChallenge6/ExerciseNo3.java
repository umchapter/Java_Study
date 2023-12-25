package me.OpenChallenge6;

import java.util.Calendar;

public class ExerciseNo3 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int ampm = now.get(Calendar.AM_PM);

        System.out.printf("현재 시간은 %d시%d분입니다.\n", hour, minute);
        String greeting;

        if (ampm == Calendar.AM) {
            if (hour >= 4) {
                greeting = "Good morning";
            } else {
                greeting = "Good night";
            }
        } else {
            if (hour < 6) {
                greeting = "Good Afternoon";
            } else if (hour >= 6 && hour < 10) {
                greeting = "Good Evening";
            } else {
                greeting = "Good night";
            }
        }

        System.out.println(greeting);
    }
}
