package com.test.exam03;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    
    public static void main(String[] args) {
        
        List<Member> list = new ArrayList<>();

        list.add(new Member("warlord","양금자",82));
        list.add(new Member("conqueror","최병식",67));
        list.add(new Member("handsomeBong","봉함길",76));

        list.add(new Member.Builder()
            .userid("KillerQueen")
            .username("박복자")
            .age(87)
            .build()
        );

        list.add(new Member.Builder()
            .userid("ToneDeff")
            .username("김석도")
            .age(101)
            .build()
        );

        for(Member member:list){
            System.out.println("userid = " + member.getUserId());
            System.out.println("username = " + member.getUserName());
            System.out.println("age = " + member.getAge());
        }
        
        // Member member = new Member("mylover", "김금김", 45);

        // member.setUserId("stella");
        // member.setUserName("김철수");
        // member.setAge(23);

        list.stream().map(n -> n.getUserName()).sorted().forEach(System.out::println);
        
    }
}
