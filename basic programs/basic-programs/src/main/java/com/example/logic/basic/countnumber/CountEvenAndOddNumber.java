package com.example.logic.basic.countnumber;

import java.util.Scanner;

public class CountEvenAndOddNumber {
/*
1 : number = 12345 , even = 2 , odd = 3
2 : take two count : evenCount , oddCount , lastDigit variable
3 : extract the last digit from a number : num%10
4 : check the number is even or odd
5 : if it is even increase an evenCount else oddCount
6 : eliminate the number : num/10
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a your number :");
        int num = sc.nextInt();
        int evenCount = 0;
        int oddCount = 0;
        int lastDigit = 0;

        while (num > 0) {
            lastDigit = num % 10;

            if (lastDigit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            num = num / 10;
        }
        System.out.println("Number of even count :"+evenCount);
        System.out.println("Number of odd count :"+oddCount);
    }
}
