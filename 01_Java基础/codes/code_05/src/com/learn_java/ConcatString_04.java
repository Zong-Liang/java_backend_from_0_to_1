package com.learn_java;

public class ConcatString_04 {
    public static void main(String[] args) {
        ConcatString_04 concatString = new ConcatString_04();
        String result = concatString.concatString("-", "hello", "world");
        String result1 = concatString.concatString("-", "hello");
        System.out.println(result);
        System.out.println(result1);
    }

    public String concatString(String separator, String... strings) {
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                result += strings[i];
            } else {
                result += separator + strings[i];
            }
        }
        return result;
    }
}
