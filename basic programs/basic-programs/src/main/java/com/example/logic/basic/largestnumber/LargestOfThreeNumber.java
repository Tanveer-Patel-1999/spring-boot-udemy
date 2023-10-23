package com.example.logic.basic.largestnumber;

import java.util.Scanner;

public class LargestOfThreeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your first number :");
        int num1 = sc.nextInt();
        System.out.println("enter your second number :");
        int num2 = sc.nextInt();
        System.out.println("enter your third number :");
        int num3 = sc.nextInt();

//      1 : using greater then operator : >

        if (num1 > num2 && num1 >num3){
            System.out.println("largest number is num1 :"+num1);
        } else if (num2 > num1 && num2 > num3){
            System.out.println("largest number is num2 :"+num2);
        } else {
            System.out.println("largest number is num3 :"+num3);
        }

//      2 :  using ternary operator : ?
        int largest1 = num1>num2 ? num1 : num2;
        int largest2 =   largest1>num3 ? largest1 : num3;
        System.out.println("largest number is :"+largest2);

//      3 :  using  Math.max()
        int largest3 = Math.max(num1, num2);
        int largest4= Math.max(largest3, num3);
        System.out.println("largest number is :"+largest4);
    }
}
