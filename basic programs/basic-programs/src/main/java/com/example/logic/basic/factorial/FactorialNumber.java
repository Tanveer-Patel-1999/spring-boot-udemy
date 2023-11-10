package com.example.logic.basic.factorial;

import java.util.Scanner;

public class FactorialNumber {
    /*
    1 : 5! = 5*4*3*2*1 = 120
    2 : create two variable num , fact
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your number: ");
        int num = sc.nextInt();
        long factorial = 1;

//      1 approach : ascending

        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        System.out.println("factorial of number :" + factorial);


//       2 approach : descending
        for (int i = num ; i>=1 ; i--){
            factorial = factorial * i;
        }
        System.out.println("factorial of number :" + factorial);
    }
}
