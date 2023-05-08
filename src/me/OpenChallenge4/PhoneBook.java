package me.OpenChallenge4;

import java.util.Scanner;

class Phone {
    private String name;
    private String tel;

    protected Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    protected String getName() {
        return this.name;
    }

    protected String getTel() {
        return this.tel;
    }
}

public class PhoneBook {
    
    Phone[] phones;

    protected String serach(String searchName) {
        
        for(Phone phone : this.phones){
            String name = phone.getName();

            if(name.equals(searchName)) {
                return name + "의 번호는 " + phone.getTel() + " 입니다.";
            }
        }
        
        return searchName + "이 없습니다.";
    }


    protected void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("인원수>>");

        int num = scanner.nextInt();

        this.phones = new Phone[num];

        for(int i=0; i<this.phones.length; i++) {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");

            String inputName = scanner.next();
            String inputTel = scanner.next();

            phones[i] = new Phone(inputName, inputTel);
        }

        System.out.println("저장되었습니다...");

        while(true) {

        System.out.print("검색할 이름>>");

        String searchName = scanner.next();

        if(searchName.equals("그만")) {
            scanner.close();
            break;
        } else {
            String result = this.serach(searchName);

            System.out.println(result);
        }

        }
    }

    public static void main(String[] args) {
        
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.run();
    }
}
