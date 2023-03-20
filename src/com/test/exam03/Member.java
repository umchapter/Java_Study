package com.test.exam03;

public class Member { // DTO(Data Transfer Object)
    
    private String userid; // String은 데이터 타입이 아닌 클래스
    private String username;
    private int age;

    public Member(){}
    public Member(String userid, String username, int age){
        this.userid = userid;
        this.username = username;
        this.age = age;
    }

    // getter method
    public String getUserId(){
        return this.userid;
    }

    public String getUserName(){
        return this.username;
    }

    public int getAge(){
        return this.age;
    }


    // setter method
    public void setUserId(String userid){
        this.userid = userid;
    }
    
    public void setUserName(String username){
        this.username = username;
    }

    public void setAge(int age){
        this.age = age;
    }

    static class Builder{

        private String userid; // String은 데이터 타입이 아닌 클래스
        private String username;
        private int age;

        public Builder userid(String userid){
            this.userid = userid;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }


        public Member build() {

            if(userid == null || username == null || age == 0){
                throw new IllegalStateException("Can not create member.");
            }
            else{
                return new Member(userid, username, age);
            }
        }

    }
}
