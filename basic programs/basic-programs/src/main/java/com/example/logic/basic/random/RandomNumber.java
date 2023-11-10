package com.example.logic.basic.random;

import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {
//        1 :    using Random class : Random

        Random random = new Random();
        long num = random.nextLong(1000000000);
        System.out.println("Random number :" + num);

//        2 : using Math class : Math : decimal number
         double random1= Math.random();
        System.out.println(random1);


    }
}
