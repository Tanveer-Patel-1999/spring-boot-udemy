package com.example.logic.basic.countnumber;

import java.util.Scanner;

public class CountNumberOfDigit {
// number = 12346  : 5
/*
1 : number = 12345 = 5
2 : take one variable count
1 : eliminate the last number : num/10
2 : after apply a count to find how many digit are eliminates
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your number :");
        int num = sc.nextInt();
        int count = 0;
        while (num>0){
            num = num/10;
            count++;
        }
        System.out.println("Number of digits :"+count);
    }
}
