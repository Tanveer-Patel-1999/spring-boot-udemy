package com.example.logic.basic.finilization;

public class Test1 {
    public static void main(String[] args)  {
        Test1 t = new Test1();
        t.finalize();
        t.finalize();
        t = null;
        System.gc();
        System.out.println("end of main method");
    }

    protected void finalize(){
        System.out.println("finalize methode is called");
    }



}
