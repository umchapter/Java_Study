package me.OpenChallenge7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    String name;
    String subject;
    int studentId;
    double score;

    public Student(String name, String subject, int studentId, double score) {
        this.name = name;
        this.subject = subject;
        this.studentId = studentId;
        this.score = score;
    }

    public String toString() {
        return this.name + ", " + this.subject + ", " + this.studentId + ", " + this.score; 
    }
}

public class ExerciseNo5 {
    boolean isHashMap;
    Scanner scanner;
    HashMap<String, Student> hashMapDb;
    ArrayList<Student> arrayListDb;

    public <T> ExerciseNo5(String dataType) {
        this.scanner = new Scanner(System.in);
        if (dataType.equals("HashMap")) {
            this.isHashMap = true;
            this.hashMapDb = new HashMap<>();
        } else {
            this.isHashMap = false;
           this.arrayListDb = new ArrayList<>();
        }

        System.out.println("학생 이름, 학과, 학번, 학점평균을 입력하세요.");
        while(true) {
            int size = this.isHashMap ? hashMapDb.size() : arrayListDb.size();

            if(size == 4) {
                break;
            }

            System.out.print(">> ");
            String inputString = this.scanner.nextLine();

            String[] splittedStrings = inputString.split(", ");

            if (!this.isValidateInput(splittedStrings)) {
                System.out.println("입력을 다시 확인해주세요.");
                continue;
            }

            String name = splittedStrings[0];
            String subject = splittedStrings[1];
            int studentId = Integer.parseInt(splittedStrings[2]);
            double score = Double.parseDouble(splittedStrings[3]);


            if (this.isHashMap) {
                this.hashMapDb.put(name, new Student(name, subject, studentId, score));
            } else {
                this.arrayListDb.add(new Student(name, subject, studentId, score));
            }
        }

        for(int i = 0; i < 4; i++) {
            Student student;

            if (this.isHashMap) {
                Object[] students = this.hashMapDb.keySet().toArray();
                student = this.hashMapDb.get(students[i].toString());
            } else {
                student = this.arrayListDb.get(i);
            }

            System.out.println("------------------------------");
            System.out.println("이름:" + student.name);
            System.out.println("학과:" + student.subject);
            System.out.println("학번:" + student.studentId);
            System.out.println("학점평균:" + student.score);
        }

    }

    private boolean isValidateInput(String[] splittedStrings) {
        if (splittedStrings.length < 4) {
            return false;
        }

        for (String s : splittedStrings) {
            if (s.equals("") || s == null) {
                return false;
            }
        }

        try {
            Integer.parseInt(splittedStrings[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        try {
            Double.parseDouble(splittedStrings[3]);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public void search() {
        while (true) {
            System.out.println("------------------------------");
            System.out.print("학생 이름 >> ");
            String stringInput = this.scanner.nextLine();

            if (stringInput.equals("그만")) {
                System.out.println("종료합니다...");
                this.scanner.close();
                break;
            }

            if (this.isHashMap) {
                Student s = this.hashMapDb.get(stringInput);
                if (s == null) {
                    System.out.println("입력을 확인해주세요.");
                } else {
                    System.out.println(s);
                }
            } else {
                boolean isNull = true;
                for (Student s : this.arrayListDb) {
                    if (s.name.equals(stringInput)) {
                        System.out.println(s);
                        isNull = false;
                        break;
                    } else {
                        continue;
                    }
                }
                if (isNull) {
                    System.out.println("입력을 확인해주세요.");
                }
            }
        }
    }

    public static void main(String[] args) {
        // ExerciseNo5 exArrayList = new ExerciseNo5("ArrayList");
        // exArrayList.search();

        ExerciseNo5 exHash = new ExerciseNo5("HashMap");
        exHash.search();
    }
}
