package com.example.logic.basic.sumofnumber;

import java.util.Scanner;

public class SumOfNumber {

/*
1 : number = 1234 , sum = 10
2 : create a variable sum
3 : extract a last digit : num%10
4 : add into the sum variable
5 : eliminate the last digit : num/10
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter a number :");
        int num = sc.nextInt();
        int sum = 0;
        int lastDigit = 0;
        while (num >0){

            lastDigit = num%10;
            sum = sum + lastDigit;
            num = num/10;
        }
        System.out.println("sum of digit = "+sum);
    }
}
