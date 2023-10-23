package com.example.logic.basic.palindrome;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your String :");
        String str = sc.next();
        String rev = "";
        String org_str = str;

      /*  int length = str.length();
        for (int i = length-1; i >= 0; i--){
            rev = rev + str.charAt(i);
        }
        if(org_str.equals(rev)){
            System.out.println("The String is palindrome :"+org_str);
        } else {
            System.out.println("The String is not palindrome :"+org_str);
        }*/

//        char a[] = str.toCharArray();
//        int length1 = a.length;
//        for (int i =length1-1; i>=0; i--){
//            rev = rev + a[i];
//        }
//        if(org_str.equals(rev)){
//            System.out.println("The String is palindrome :"+org_str);
//        } else {
//            System.out.println("The String is not palindrome :"+org_str);
//        }



    }
}
