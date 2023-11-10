package com.example.logic.basic.prime;

import java.util.Scanner;

public class PrimeNumber {
    /*
    1 : natural number greater than 1
    2 : the number have only two factors 1 and itself
     */

    /*
    1 : need two variable : num and fact
    2 : check the number id greater than 1 or not
    3 : if number is greater than 1 then check the factors

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your number :");
        int num = scanner.nextInt();
        int fact = 0;

        if (num > 1) {
            for (int i=1;i<=num;i++) {
                if (num % i == 0) {
                    fact++;
                }
            }
                if (fact==2){
                    System.out.println("number is a prime number :"+num);
                } else {
                    System.out.println("number is not a prime number :"+num);
                }
            } else {
            System.out.println("number is not a prime number :"+num);
        }
    }

}
