package com.example.logic.basic.garbage;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        System.out.println("Before creating a 10000 object the memory");

        long totalMemory = r.totalMemory(); // 100 bytes
        System.out.println("total memory in heap :"+totalMemory);

        long freeMemory = r.freeMemory(); //80bytes
        System.out.println("free memory in heap :"+freeMemory);

        for (int i=0; i<10000; i++)
        {
            Date date = new Date();
            date = null;
        }

        long freeMemory1 = r.freeMemory(); // 60bytes
        System.out.println("free memory in heap :"+freeMemory1);

        r.gc();
        System.out.println("free memory :"+r.freeMemory()); // 70bytes

    }
    // to run program execution jvm require some memory
}
