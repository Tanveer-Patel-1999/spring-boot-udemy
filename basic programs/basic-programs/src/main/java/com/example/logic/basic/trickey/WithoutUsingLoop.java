package com.example.logic.basic.trickey;

import java.util.stream.IntStream;

public class WithoutUsingLoop {
    public static void main(String[] args) {
        String name = "Tanveer";
        String str  = "i";

//      1 : using replace() methode
        str = str.replace("i","iiiiiiiiiiiiiiiii");
        str = str.replace("i", name + "\n");
        System.out.println(str);

//      2 : using methode
        printHi(10);

//        3 : using stream
        IntStream.generate(() -> 0)
                .limit(10)
                .forEach(i -> System.out.println("patel"));

    }

//     using methode :
    public static void printHi(int n) {
        if (n > 0) {
            System.out.println("hii");
            printHi(n - 1);
        }
    }
}
