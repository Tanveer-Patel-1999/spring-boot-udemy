package com.example.logic.basic.palindrome;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
//      Palindrome : A palindrome number is number that remain same when its digits are reversed.

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your number :");
        int num = scanner.nextInt();
        int rev = 0;
        int org_num = num;

        while (num!=0){
            rev = rev*10 + num%10;
            num = num/10;
        }
        System.out.println(rev);
        if (org_num == rev){
            System.out.println("The number is palindrome :"+org_num);
        } else {
            System.out.println("The number is not a palindrome :"+org_num
            );
        }

    }
}
