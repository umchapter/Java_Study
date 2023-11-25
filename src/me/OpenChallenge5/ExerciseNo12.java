package me.OpenChallenge5;

import java.util.Scanner;

abstract class Shape{
    public Shape next;
    public Shape() {next = null;}
    public void setNext(Shape obj) {next = obj;}
    public Shape getNext() {return next;}
    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    Shape start, last, obj;

    private void input(int selector) {
        switch (selector) {
            case 1:
                obj = new Line();
                if(start == null) {
                    start = obj;
                    last = start;                              
                } else {
                    last.setNext(obj);
                    last = obj;
                }
                break;
            case 2:
                obj = new Rect();
                if(start == null) {
                    start = obj;
                    last = start;                              
                } else {
                    last.setNext(obj);
                    last = obj;
                }
                break;
            case 3:
                obj = new Circle();
                if(start == null) {
                    start = obj;
                    last = start;                              
                } else {
                    last.setNext(obj);
                    last = obj;
                }
                break;
            default:
                System.out.println("Wrong Input");
                break;            
        }
    }

    private void delete(int delete) {
        Shape currentShape = start;
        
        if (delete == 1) {
            start = currentShape.getNext();
        } else {
            for (int i = 0; i < delete - 2; i++) {
                currentShape = currentShape.getNext();
            }

            if (currentShape == null || currentShape.getNext() == null) {
                System.out.println("삭제할 수 없습니다.");
            } else {
                currentShape.setNext(currentShape.getNext().getNext());
            }
        }
    }

    private void popAll() {
        Shape currentShape = start;
        while (currentShape != null) {
            currentShape.draw();
            currentShape = currentShape.getNext();
        }
    } 

    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("그래픽 에디터 beauty를 실행합니다.");
        boolean run = true;
        
        while (run) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >>");
            int input = scanner.nextInt();
            
            switch (input) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3) >>");
                    int selector = scanner.nextInt();
                    input(selector);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치 >>");
                    int delete = scanner.nextInt();                   
                    delete(delete);
                    break;
                case 3:
                    popAll();
                    break;
                case 4:
                    System.out.println("beauty를 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }

        scanner.close();
    }
}

public class ExerciseNo12 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.run();
    }   
}
