package com.example.logic.basic.fibonacci;

public class FibonacciNumber {
//        A series of number in which each number is the sum od the two preceding numbers
//          0 , 1 , 1 , 2 , 3 , 5 , 8 , 13
    /*
    1 : take three variable n1= 0 , n2 = 1 , sum =0
    2 : printf(n1+ " " +n2)
    3 : iterate a loop from 2
    4 : sum the value of number
    5 : swap the number
     */
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        System.out.print(num1 + " "+num2);
        for (int i=2; i<10 ;i++ ){
            sum = num1+num2;
            System.out.print(" "+sum);
            num1=num2;
            num2=sum;
        }

    }
}
