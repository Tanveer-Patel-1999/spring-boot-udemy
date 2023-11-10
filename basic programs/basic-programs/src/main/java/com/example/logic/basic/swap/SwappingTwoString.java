package com.example.logic.basic.swap;

public class SwappingTwoString {
    public static void main(String[] args) {
        String s1 = "Tanveer";
        String s2 = "Patel";
        System.out.println("After swapping :" + s1 + " " + s2);

//        1 : using third variable

        String temp = "";
        temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("Before swapping :" + s1 + " " + s2);

//        2 : not using third variable
        /*
        1 : append both string :a = a+b
        2 : store initial string s1 in s2
        3 : store initial string s2 in s1
         */

        s1 = s1 + s2;
        s2 = s1.substring(0, s1.length() - s2.length());
        s1 = s1.substring(s2.length());
        System.out.println("Before swapping :" + s1 + " " + s2);

//    3 : approach
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Before swapping: " + str1 + " " + str2);
        // Concatenate the strings
        String concat = str1 + str2;

        // Substring the strings to swap their values
        str1 = concat.substring(str2.length());
        str2 = concat.substring(0, str2.length());

        System.out.println("After swapping: " + str1 + " " + str2);
    }


}
