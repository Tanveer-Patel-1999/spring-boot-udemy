package com.example.logic.basic.largestnumber;

import java.util.Scanner;

public class LargestOfTwoNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your first number :");
        int num1 = sc.nextInt();
        System.out.println("enter your second number :");
        int num2 = sc.nextInt();

//        1 : using without ternary operator :

        if(num1 > num2){
            System.out.println("largest number is num1:"+num1);
        }
        else {
            System.out.println("largest number is num2:"+num2);
        }


//        2 : using ternary operator : ?
        int largest = num1>num2 ? num1:num2;
        System.out.println("largest number is :"+largest);


//        3 : using Math class and max() method;
        int max = Math.max(num1,num2);
        System.out.println("largest number is :"+max);
    }
}
