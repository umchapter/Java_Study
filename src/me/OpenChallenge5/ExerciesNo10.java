package me.OpenChallenge5;

abstract class PairMap {
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    
    public Dictionary(int size) {
        this.keyArray = new String[size];
        this.valueArray = new String[size];
    }

    public String get(String key) {
        for(int i=0; i < keyArray.length; i++) {
            if(keyArray[i] == null) {
                return null;
            }
            if(keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    public void put(String key, String value) {
        for(int i=0; i < keyArray.length; i++) {
            if(keyArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                break;
            }
            if(keyArray[i].equals(key)) {
                valueArray[i] = value;
                break;
            }
        }
    }

    public String delete(String key) {
        for(int i=0; i < keyArray.length; i++) {
            if(keyArray[i] == null) {
                return null;
            }
            if(keyArray[i].equals(key)) {
                String value = valueArray[i];
                keyArray[i] = null;
                valueArray[i] = null;
                return value;
            }
        }
        return null;
    }

    public int length() {
        for(int i=0; i < keyArray.length; i++) {
            if(keyArray[i] == null) {
                return i;
            }
        }
        return keyArray.length;
    }

}

public class ExerciesNo10 {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
