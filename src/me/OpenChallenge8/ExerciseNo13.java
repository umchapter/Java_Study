package me.OpenChallenge8;

import java.io.File;
import java.util.Scanner;

public class ExerciseNo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 파일 탐색기입니다. *****");
        File current = new File("c:/");

        run:
        while (true) {
            String path = current.getPath();
            System.out.print(path + ">");
            String[] inputStrings = scanner.nextLine().split(" ");
            String cmd = inputStrings[0];

            switch (cmd) {
                case "그만":
                    break run;
                case "dir":
                    for (String subDirectoriesOrFiles : current.list()) {
                        System.out.println(subDirectoriesOrFiles);
                    }
                    break;
                case "cd":
                    String targetPath;
                    String cdParameter;
                    try {
                        cdParameter = inputStrings[1];
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("대상 디렉토리를 입력해주세요.");
                        break;
                    }
                    if (cdParameter.equals("..")) {
                        targetPath = current.getParent();
                    } else if (cdParameter.equals(".")) {
                        break;
                    } else {
                        targetPath = path + File.separator + cdParameter;
                    }
                    File target = new File(targetPath);
                    if (target.exists() && target.isDirectory()) {
                        current = target;
                    } else {
                        System.err.println("대상이 존재하지 않거나 디렉토리가 아닙니다.");
                    }
                    break;
                case "rename":
                    String renameParameter1;
                    String renameParameter2;
                    try {
                        renameParameter1 = inputStrings[1];
                        renameParameter2 = inputStrings[2];
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("변경 대상의 이름과 변경할 이름이 필요합니다. 입력을 확인해주세요.");
                        break;
                    }
                    File oldFile = new File(path + File.separator + renameParameter1);
                    File newFile = new File(path + File.separator + renameParameter2);
                    if (!oldFile.exists()) {
                        System.err.println("대상이 존재하지 않습니다. 다시 확인해주세요.");
                    } else if (newFile.exists()) {
                        System.err.println("같은 이름의 파일 또는 디렉토리가 이미 존재합니다.");
                    } else {
                        oldFile.renameTo(newFile);
                        System.out.println(oldFile.getName() + "를" + newFile.getName() + "으로 변경했습니다.");
                    }
                    break;
                case "mkdir":
                    String mkdirParameter;
                    try {
                        mkdirParameter = inputStrings[1];
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("생성할 디렉토리 이름을 입력해주세요.");
                        break;
                    }
                    File newDirectory = new File(path + File.separator + mkdirParameter);
                    if (newDirectory.exists()) {
                        System.err.println("같은 이름의 디렉토리가 이미 존재합니다.");
                    } else {
                        newDirectory.mkdir();
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
