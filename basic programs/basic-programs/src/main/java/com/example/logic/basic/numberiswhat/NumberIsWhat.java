package com.example.logic.basic.numberiswhat;

import java.util.Scanner;

public class NumberIsWhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your number :");
        int num = sc.nextInt();

        if (num > 0){
            System.out.println("number is positive :"+num);
        } else if (num < 0){
            System.out.println("number is negative : "+num);
        } else {
            System.out.println("number is zero :"+num);
        }
    }
}
