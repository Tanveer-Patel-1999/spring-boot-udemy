package com.example.logic.basic.reverse;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number...");
        int num = sc.nextInt();

/*
//     1 :  using algorithm : [ * , + , % , / ]
        int rev = 0;
        while (num!=0){
            rev = rev*10 + num%10;    // % :it will give the last digit
            num = num/10;             // / : it will eliminate the last digit
        }

        System.out.println("reverse number is : "+rev);
    */


/*
//        2 : using StringBuffer class method : reverse()
//        create a StringBuffer object and pass the number[String.valueOf(num) : convert the number into String ] into the StringBuffer constructor

        StringBuffer stringBuffer = new StringBuffer(String.valueOf(num));
        StringBuffer rev = stringBuffer.reverse();
        System.out.println("reverse number is : " + rev);

    */

/*
//      3 : using  StringBuilder class method : reverse()
//       create a StringBuilder object and pass the number[String.valueOf(num) : convert the number into String ] into the StringBuilder constructor


        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        StringBuilder rev = stringBuilder.reverse();
        System.out.println("reverse number is : " + rev);
    */

//    4 : using  StringBuilder class method : reverse() and append() methode
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num);
        StringBuilder rev = stringBuilder.reverse();
        System.out.println("reverse number is : "+rev);

    }
}
