package me.OpenChallenge5;

import java.util.Random;
import java.util.Scanner;

class Bear extends GameObeject {

    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    @Override
    protected void move() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
        String order = scanner.nextLine();

        switch (order) {
            case "a":
                int left = this.x - distance;
                this.x = left >=0 ? left : 0;
                break;
            case "s":
                int down = this.y + distance;
                this.y = down <= 10 ? down : 10;
                break;
            case "d":
                int up = this.y - distance;
                this.y = up >= 0 ? up : 0;
                break;
            case "f":
                int right = this.x + distance;
                this.x = right <= 20 ? right : 0;
                break;
            default:
                scanner.close();
        }
    }

    @Override
    protected char getShape() {
        return 'B';
    }
}

class Fish extends GameObeject {

    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    @Override
    protected void move() {
        Random random = new Random();

        int order = random.nextInt(4);

        switch (order) {
            case 0:
                int left = this.x - distance;
                this.x = left >=0 ? left : 0;
                break;
            case 1:
                int down = this.y + distance;
                this.y = down <= 10 ? down : 10;
                break;
            case 2:
                int up = this.y - distance;
                this.y = up >= 0 ? up : 0;
                break;
            case 3:
                int right = this.x + distance;
                this.x = right <= 20 ? right : 0;
                break;
            default:
                break;
        }
    }

    @Override
    protected char getShape() {
        return '@';
    }
}

public class Game {

    Bear bear;
    Fish fish;

    private void init() {
        Random random = new Random();

        this.bear = new Bear(random.nextInt(20), random.nextInt(10), 1);
        this.fish = new Fish(random.nextInt(20), random.nextInt(10), 1);
    }

    private void drawBoard() {
        int bearX = this.bear.getX();
        int bearY = this.bear.getY();

        int fishX = this.fish.getX();
        int fishY = this.fish.getY();

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 20; x++) {
                char pixel;
                if (x == bearX && y == bearY) {
                    pixel = this.bear.getShape();
                } else if (x == fishX && y == fishY) {
                    pixel = this.fish.getShape();
                } else {
                    pixel = '-';
                }

                System.out.print(pixel);
            }
            System.out.print("\n");
        }
    }

    private void run() {
        init();
        System.out.println("*** Bear의 Fish 먹기 게임을 시작합니다.***");

        int turn = 0;

        while (true) {
            if (this.bear.collide(this.fish)) {
                drawBoard();
                System.out.println("Bear Wins in " + turn + " Move(s)!!");
                break;
            }
            drawBoard();
            this.bear.move();
            if (turn % 5 == 3 || turn % 5 == 4) {
                this.fish.move();
            }
            turn++;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.run();
    }
}
