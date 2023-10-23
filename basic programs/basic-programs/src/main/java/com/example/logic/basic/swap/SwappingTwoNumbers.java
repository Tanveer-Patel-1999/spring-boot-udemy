package com.example.logic.basic.swap;

public class SwappingTwoNumbers {
    public static void main(String[] args) {

        int a = 3;
        int b = 4;
        System.out.println("Before swapping the value of a = "+ a + " and value of b = "+b);

/*

//      Logic 1 : using third variable : temp
        System.out.println("swapping a two number using third variable");
        int temp;
        temp = a;
        a = b;
        b= a;
        System.out.println("after swapping a value of a = "+ a + " value of b = "+b);
*/


/*
//    Logic 2 : swapping a number without using third variable : use plus and minus operator
        System.out.println("without using third variable swap a two number");
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("after swapping a value of a = "+ a + " value of b = "+b);
*/

/*
//     Logic 3 : swapping a number without using third variable : use multiplication and division operators
//             : This logic is applied when a and b are should not be a zero

        a = a*b;
        b = a/b;
        a = a/b;
        System.out.println("after swapping a value of a = "+ a + " value of b = "+b);
*/

/*
//     Logic 4 : swapping a number without using third variable : use bitwise XOR (^) operator

        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("after swapping a value of a = "+ a + " value of b = "+b);
*/

//      Logic 5 : using a single statement :  b = a+b-(a=b);
        /*
        --> start execution from right to left : a = b , a = 4
        --> a + b = 3+4 = 7 , 7-4 = 3 b =3
         */

        b = a+b-(a=b);
        System.out.println("after swapping a value of a = "+ a + " value of b = "+b);

    }
}
