package me.cahpter3;

public class ScoreAverage {
    
    public static void main(String[] args) {
        float[][] score = {{3.3f, 3.4f}, // 1학년 1학기, 2학기 평점
                           {3.5f, 3.6f},
                           {3.7f, 4.0f},
                           {4.1f, 4.2f}}; // 4학년 1학기, 2학기 평점

        float sum = 0;
        for(int year=0; year<score.length; year++) { // 각 학년별로 반복
            for(int semester=0; semester<score[year].length; semester++){ // 학기별로 반복
                sum += score[year][semester]; // 전체 평점 합
            }
        }

        int n = score.length; // 배열의 행 개수(연)
        int m = score[0].length; // 배열의 열 개수(학기)

        System.out.println("4년 전체 평점 평균은" + sum/(n*m));
    }
}
