package me.OpenChallenge7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class Location {
    String city;
    int latitude;
    int longitude;

    public Location(String city, int latitude, int longitude) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String toString() {
        return String.format("%-7s%-5d%d", city, latitude, longitude);
    }
}

public class ExerciseNo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var map = new HashMap<String, Location>();

        System.out.println("도시, 경도, 위도를 입력하세요");
        while (true) {
            if (map.size() >= 4) {
                break;
            }
            System.out.print(">> ");
            String stringInput = scanner.nextLine();

            String[] splittedStrings = stringInput.split(", ");
            if (splittedStrings.length < 3) {
                System.out.println("입력을 확인하세요.");
                System.out.println("도시, 경도, 위도를 입력하세요");
                continue;
            }
            
            boolean isValidateInput = true;
            for (String s : splittedStrings) {
                if (s.equals("") || s == null) {
                    isValidateInput = false;
                    break;                    
                } else {
                    continue;
                }
            }

            if (!isValidateInput) {
                System.out.println("입력을 확인하세요.");
                System.out.println("도시, 경도, 위도를 입력하세요");
                continue;
            }
            
            int longitude;
            try {
                longitude = Integer.parseInt(splittedStrings[1]);
            } catch (NumberFormatException e) {
                System.out.println("입력을 확인하세요.");
                System.out.println("도시, 경도, 위도를 입력하세요");
                continue;
            }

            int latitude;
            try {
                latitude = Integer.parseInt(splittedStrings[2]);
            } catch (NumberFormatException e) {
                System.out.println("입력을 확인하세요.");
                System.out.println("도시, 경도, 위도를 입력하세요");
                continue;
            }

            String city = splittedStrings[0];

            map.put(city, new Location(city, latitude, longitude));  
        }

        System.out.println("------------------------------");
        Iterator<String> stringIterator = map.keySet().iterator();
        while (stringIterator.hasNext()) {
            System.out.println(map.get(stringIterator.next()));
        }

        System.out.println("------------------------------");

        while (true) {
            System.out.print("도시 이름 >> ");
            String city = scanner.nextLine();

            if (city.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }
            
            Location location = map.get(city);
            if (location == null) {
                System.out.println(city + "는 없습니다.");
                continue;
            } else {
                System.out.println(location);
            }


        }

        scanner.close();
    }
}
